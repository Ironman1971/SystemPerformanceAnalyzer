package com.performance.analyzer.util;

import com.performance.analyzer.model.PerformanceData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final String LOG_FILE = "logs/performance.log";

    static {
        try {
            Files.createDirectories(Paths.get("logs"));
        } catch (IOException e) {
            System.err.println("Error creating logs directory: " + e.getMessage());
        }
    }

    public static void logData(PerformanceData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(data.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error logging data: " + e.getMessage());
        }
    }

    public static List<PerformanceData> loadLoggedData() {
        List<PerformanceData> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(PerformanceData.fromString(line));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading log: " + e.getMessage());
        }
        return dataList;
    }

    public static void logEvent(String event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write("Event: " + event);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error logging event: " + e.getMessage());
        }
    }
}