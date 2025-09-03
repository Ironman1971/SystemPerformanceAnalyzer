package com.performance.analyzer.ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("System Performance Analyzer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Monitor", new MonitorPanel());
        tabbedPane.addTab("Analysis", new AnalysisPanel());
        tabbedPane.addTab("Report", new ReportPanel());

        add(tabbedPane);
    }
}