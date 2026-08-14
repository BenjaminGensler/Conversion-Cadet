package com.example;

import javax.swing.*;
import java.awt.*;

public class ConverterFrame extends JFrame {
    public ConverterFrame() {
        setTitle("Conversion Cadet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // build the tabbed pane and its four tabs here, in the constructor
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Length", new ConverterPanel(new LengthConverter()));
        tabs.addTab("Weight", new ConverterPanel(new WeightConverter()));
        tabs.addTab("Temperature", new ConverterPanel(new TemperatureConverter()));
        tabs.addTab("Time", new ConverterPanel(new TimeConverter()));
        add(tabs);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConverterFrame());
    }
}
