
package com.performance.analyzer;

import com.performance.analyzer.model.PerformanceData;
import com.performance.analyzer.util.Logger;

import java.util.List;

public class Analyzer {
    public String analyzeData() {
        List<PerformanceData> dataList = Logger.loadLoggedData();
        if (dataList.isEmpty()) {
            return "No data available for analysis.";
        }

        StringBuilder analysis = new StringBuilder("Performance Analysis:\n");
        double avgCpu = dataList.stream().mapToDouble(PerformanceData::getCpuUsage).average().orElse(0);
        double avgMemory = dataList.stream().mapToDouble(PerformanceData::getMemoryUsage).average().orElse(0);
        analysis.append("Average CPU Usage: ").append(String.format("%.2f%%", avgCpu)).append("\n");
        analysis.append("Average Memory Usage: ").append(String.format("%.2f%%", avgMemory)).append("\n");

        // Simulate root cause and issue detection
        boolean highCpu = avgCpu > 80;
        boolean highMemory = avgMemory > 80;
        if (highCpu) {
            analysis.append("Issue Detected: High CPU usage. Root Cause: Possible resource-intensive processes or infinite loops.\n");
            analysis.append("Suggestion: Optimize code or add throttling.\n");
        }
        if (highMemory) {
            analysis.append("Issue Detected: High Memory usage. Root Cause: Memory leaks or large data structures.\n");
            analysis.append("Suggestion: Implement garbage collection triggers or reduce object creation.\n");
        }
        if (!highCpu && !highMemory) {
            analysis.append("No major issues detected. System performance is optimal.\n");
        }

        analysis.append("Impact on Availability: ").append(highCpu || highMemory ? "High risk of downtime." : "Low risk.").append("\n");
        return analysis.toString();
    }
}