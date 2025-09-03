package com.performance.analyzer.ui;

import com.performance.analyzer.Analyzer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalysisPanel extends JPanel {
    private JTextArea analysisArea;
    private JButton analyzeButton;

    public AnalysisPanel() {
        setLayout(new BorderLayout());
        analysisArea = new JTextArea();
        analysisArea.setEditable(false);
        add(new JScrollPane(analysisArea), BorderLayout.CENTER);

        analyzeButton = new JButton("Run Analysis");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analyzer analyzer = new Analyzer();
                String result = analyzer.analyzeData();
                analysisArea.setText(result);
            }
        });

        add(analyzeButton, BorderLayout.SOUTH);
    }
}