package com.performance.analyzer.ui;

import com.performance.analyzer.Analyzer;
import com.performance.analyzer.ReportGenerator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPanel extends JPanel {
    private JTextArea reportArea;
    private JButton generateButton;

    public ReportPanel() {
        setLayout(new BorderLayout());
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        generateButton = new JButton("Generate Report");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analyzer analyzer = new Analyzer();
                String analysis = analyzer.analyzeData();
                ReportGenerator generator = new ReportGenerator();
                String report = generator.generateReport(analysis);
                reportArea.setText(report);
            }
        });

        add(generateButton, BorderLayout.SOUTH);
    }
}