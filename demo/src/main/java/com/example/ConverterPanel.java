package com.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConverterPanel extends JPanel {

    public ConverterPanel(Converter converter) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // stacks the three sections top to bottom

        Font largerFont = new Font("SansSerif", Font.PLAIN, 18); // one shared font, used everywhere below

        // ---- FROM section: what you're converting, and from which unit ----
        JPanel fromRow = new JPanel();
        fromRow.setAlignmentX(Component.CENTER_ALIGNMENT); // keeps this row centered within the BoxLayout column

        JLabel fromLabel = new JLabel("Given Data:");
        fromLabel.setFont(largerFont);
        JTextField valueField = new JTextField(8);
        valueField.setFont(largerFont);
        JComboBox<String> fromUnitBox = new JComboBox<>(converter.getUnits());
        styleComboBox(fromUnitBox, largerFont);
        JComboBox<String> fromPrefixBox = new JComboBox<>(MetricPrefixes.NAMES);
        styleComboBox(fromPrefixBox, largerFont);
        fromPrefixBox.setSelectedIndex(10); // No prefix

        fromRow.add(fromLabel);
        fromRow.add(valueField);
        fromRow.add(fromUnitBox);
        fromRow.add(fromPrefixBox);

        // ---- Arrow: purely visual, signals "this flows into that" ----
        JLabel arrowLabel = new JLabel("↓");
        arrowLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        arrowLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ---- TO section: the target unit ----
        JPanel toRow = new JPanel();
        toRow.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel toLabel = new JLabel("Convert to:");
        toLabel.setFont(largerFont);
        JComboBox<String> toUnitBox = new JComboBox<>(converter.getUnits());
        styleComboBox(toUnitBox, largerFont);
        JComboBox<String> toPrefixBox = new JComboBox<>(MetricPrefixes.NAMES);
        styleComboBox(toPrefixBox, largerFont);
        toPrefixBox.setSelectedIndex(10); // No prefix

        toRow.add(toLabel);
        toRow.add(toUnitBox);
        toRow.add(toPrefixBox);

        // ---- Result section: the button and the answer ----
        JPanel resultRow = new JPanel();
        resultRow.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton convertButton = new JButton("Convert") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // smooths the curve edges
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // last two numbers control corner roundness
                g2.dispose();
                super.paintComponent(g);
            }
        };
        convertButton.setContentAreaFilled(false); // stops Swing's default square background from painting underneath your rounded one
        convertButton.setBorderPainted(false);
        convertButton.setFocusPainted(false);
        convertButton.setOpaque(false);
        convertButton.setBackground(new Color(51, 159, 35));
        convertButton.setForeground(Color.WHITE);
        convertButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        convertButton.setFont(largerFont);
        convertButton.setPreferredSize(new Dimension(100, 50));

        Border lineBorder = BorderFactory.createLineBorder(Color.black);

        convertButton.setBorder(lineBorder);
        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setFont(largerFont);

        resultRow.add(convertButton);
        resultRow.add(resultLabel);

        convertButton.addActionListener(e -> {
            try {
                double value = Double.parseDouble(valueField.getText());
                double result = converter.convert(value, fromUnitBox.getSelectedIndex(), toUnitBox.getSelectedIndex());
                double multiplier = MetricPrefixes.multiplierBetween(fromPrefixBox.getSelectedIndex(), toPrefixBox.getSelectedIndex());
                result *= multiplier;
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        add(Box.createVerticalGlue());
        add(fromRow);
        add(arrowLabel);
        add(toRow);
        add(resultRow);
        add(Box.createVerticalGlue());
    }

    private void styleComboBox(JComboBox<String> box, Font font) {
        box.setPreferredSize(new Dimension(150, 60));
        box.setBackground(new Color(51, 159, 35));
        box.setForeground(Color.WHITE);
        box.setFont(font);
        box.setFocusable(false);
        box.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // just padding, no visible line at all
    }
}