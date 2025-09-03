public class Monitor {
    
}
package com.performance.analyzer;

import com.performance.analyzer.model.PerformanceData;
import com.performance.analyzer.util.Logger;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class Monitor {
    private Timer timer;
    private boolean isMonitoring = false;
    private Consumer<PerformanceData> dataConsumer;
    private Consumer<String> statusConsumer;

    public void startMonitoring(Consumer<PerformanceData> dataConsumer, Consumer<String> statusConsumer) {
        if (isMonitoring) return;
        this.dataConsumer = dataConsumer;
        this.statusConsumer = statusConsumer;
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new MonitorTask(), 0, 2000); // Every 2 seconds
        isMonitoring = true;
        statusConsumer.accept("Monitoring started.");
    }

    public void stopMonitoring() {
        if (!isMonitoring) return;
        timer.cancel();
        isMonitoring = false;
        statusConsumer.accept("Monitoring stopped.");
    }

    private class MonitorTask extends TimerTask {
        @Override
        public void run() {
            try {
                OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
                double cpuUsage = osBean.getSystemCpuLoad() * 100;
                Runtime runtime = Runtime.getRuntime();
                double memoryUsage = ((double) (runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory()) * 100;

                PerformanceData data = new PerformanceData(cpuUsage, memoryUsage, System.currentTimeMillis());
                Logger.logData(data);
                dataConsumer.accept(data);
            } catch (Exception e) {
                statusConsumer.accept("Error during monitoring: " + e.getMessage());
            }
        }
    }
}