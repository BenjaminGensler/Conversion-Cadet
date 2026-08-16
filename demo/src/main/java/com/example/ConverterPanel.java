package com.example;

import javax.swing.*;
import java.awt.*;

public class ConverterPanel extends JPanel {

    public ConverterPanel(Converter converter) {
        setLayout(new FlowLayout());

        // both combo boxes pull directly from the Converter passed in —
        // no separate "populate on category change" logic needed anymore
        JComboBox<String> fromUnitBox = new JComboBox<>(converter.getUnits());
        JComboBox<String> fromPrefixBox = new JComboBox<>(MetricPrefixes.NAMES);
        JComboBox<String> toUnitBox = new JComboBox<>(converter.getUnits());
        JComboBox<String> toPrefixBox = new JComboBox<>(MetricPrefixes.NAMES);
        JTextField valueField = new JTextField(8);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        convertButton.addActionListener(e -> {
            //try-catch for invalid number input
            try {
                double value = Double.parseDouble(valueField.getText());
                double result = converter.convert(value, fromUnitBox.getSelectedIndex(), toUnitBox.getSelectedIndex());

                // apply the prefix multiplier after the base conversion, same order Main.java uses
                double multiplier = MetricPrefixes.multiplierBetween(fromPrefixBox.getSelectedIndex(), toPrefixBox.getSelectedIndex());
                result *= multiplier;

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        add(fromUnitBox);
        add(fromPrefixBox);
        add(toUnitBox);
        add(toPrefixBox);
        add(valueField);
        add(convertButton);
        add(resultLabel);
    }
}
