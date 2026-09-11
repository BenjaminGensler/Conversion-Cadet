package com.example;

import javax.swing.*;
import java.awt.*;

public class ConverterFrame extends JFrame {
    public ConverterFrame() {
        setTitle("Conversion Cadet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(new Color(0x123456));

        JPanel contentPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();

        contentPanel.add(new ConverterPanel(new LengthConverter()), "Length");
        contentPanel.add(new ConverterPanel(new WeightConverter()), "Weight");
        contentPanel.add(new ConverterPanel(new TemperatureConverter()), "Temperature");
        contentPanel.add(new ConverterPanel(new TimeConverter()), "Time");

        String[] categories = {"Length", "Weight", "Temperature", "Time"};
        JList<String> categoryList = new JList<>(categories); // simplest way to hand JList its items directly

        // Category List Design
        categoryList.setFont(new Font("SansSerif", Font.PLAIN, 16));
        categoryList.setFixedCellHeight(40);
        categoryList.setBackground(new Color(230, 230, 235));
        categoryList.setForeground(Color.DARK_GRAY);
        categoryList.setSelectionBackground(new Color(38, 158, 72));
        categoryList.setSelectionForeground(Color.WHITE);

        categoryList.setSelectedIndex(0); // Temporary: Plan to make it the same panel that was last visited in the previous session ----

        // fires whenever the selection changes
        categoryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = categoryList.getSelectedValue();
                cardLayout.show(contentPanel, selected); // shows whichever card matches this name
            }
        });

        JScrollPane sidebarScrollPane = new JScrollPane(categoryList);
        sidebarScrollPane.setPreferredSize(new Dimension(150, 0));
        add(sidebarScrollPane, BorderLayout.WEST);

        add(contentPanel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        // add Nimbus fix for JComboBox to avoid MacOS's native Aqua rendering (ignoring setBackground)
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new ConverterFrame());

    }
}
