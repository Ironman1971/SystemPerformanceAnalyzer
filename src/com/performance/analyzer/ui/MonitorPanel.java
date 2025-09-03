package com.performance.analyzer.ui;

import com.performance.analyzer.Monitor;
import com.performance.analyzer.model.PerformanceData;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonitorPanel extends JPanel {
    private JTextArea displayArea;
    private JButton startButton;
    private JButton stopButton;
    private Monitor monitor;

    public MonitorPanel() {
        setLayout(new BorderLayout());
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start Monitoring");
        stopButton = new JButton("Stop Monitoring");
        stopButton.setEnabled(false);

        monitor = new Monitor();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monitor.startMonitoring(data -> appendData(data), status -> appendStatus(status));
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monitor.stopMonitoring();
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void appendData(PerformanceData data) {
        displayArea.append("CPU: " + String.format("%.2f%%", data.getCpuUsage()) + 
                           " | Memory: " + String.format("%.2f%%", data.getMemoryUsage()) + 
                           " | Time: " + data.getTimestamp() + "\n");
    }

    private void appendStatus(String status) {
        displayArea.append("Status: " + status + "\n");
    }
}