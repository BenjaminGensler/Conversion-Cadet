package com.example;

import javax.swing.*;
import java.awt.*;

public class ConverterFrame extends JFrame {
    public ConverterFrame(){
        setTitle("Conversion Cadet"); // text for title
        setDefaultCloseOperation(EXIT_ON_CLOSE); // app quits when window is closed
        setLayout(new FlowLayout()); //standard left to right with wrap layout

        //Creating Combo Box for initial options (Length, Weight, Temperature, Time)
        JComboBox<String> categoryBox = new JComboBox<>(new String[] {
                "Length", "Weight", "Temperature", "Time"
        });

        //Adding categoryBox to frame
        add(categoryBox);

        pack(); //sizes the window to fit content automatically
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConverterFrame());
    }
}
