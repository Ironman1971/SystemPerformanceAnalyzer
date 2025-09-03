package com.performance.analyzer.model;

public class PerformanceData {
    private double cpuUsage;
    private double memoryUsage;
    private long timestamp;

    public PerformanceData(double cpuUsage, double memoryUsage, long timestamp) {
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.timestamp = timestamp;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return timestamp + "," + cpuUsage + "," + memoryUsage;
    }

    public static PerformanceData fromString(String line) {
        String[] parts = line.split(",");
        return new PerformanceData(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Long.parseLong(parts[0]));
    }
}