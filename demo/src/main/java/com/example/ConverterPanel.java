package com.example;

import javax.swing.*;
import java.awt.*;

public class ConverterPanel extends JPanel {

    public ConverterPanel(Converter converter) {
        setLayout(new FlowLayout());

        // both combo boxes pull directly from the Converter passed in —
        // no separate "populate on category change" logic needed anymore
        JComboBox<String> fromUnitBox = new JComboBox<>(converter.getUnits());
        JComboBox<String> toUnitBox = new JComboBox<>(converter.getUnits());
        JTextField valueField = new JTextField(8);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        convertButton.addActionListener(e -> {
            double value = Double.parseDouble(valueField.getText());
            double result = converter.convert(value, fromUnitBox.getSelectedIndex(), toUnitBox.getSelectedIndex());
            resultLabel.setText("Result: " + result);
        });

        add(fromUnitBox);
        add(toUnitBox);
        add(valueField);
        add(convertButton);
        add(resultLabel);
    }
}
