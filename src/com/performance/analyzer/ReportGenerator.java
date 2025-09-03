package com.performance.analyzer;

import com.performance.analyzer.util.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReportGenerator {
    public String generateReport(String analysis) {
        String report = "System Performance Report\n";
        report += "Generated on: " + LocalDateTime.now() + "\n";
        report += "------------------------------------\n";
        report += analysis;
        report += "\n------------------------------------\n";
        report += "End of Report\n";

        // Save to file
        try (FileWriter writer = new FileWriter("logs/performance_report.txt")) {
            writer.write(report);
        } catch (IOException e) {
            return "Error generating report file: " + e.getMessage() + "\n" + report;
        }

        Logger.logEvent("Report generated successfully.");
        return report;
    }
}