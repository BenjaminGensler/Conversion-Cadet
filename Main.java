// Java program for conversions (Universal Converter)
// This program allows users to convert between various units of length.
// -------------------------------------------------------------------
// Author: Benjamin Gensler
// Created On: 5/22/2025
// Last Modified: 5/22/2025
// Version: 1.0
// Description: This program was developed to provide a simple and user-friendly
//              way to convert between units of length such as meters, inches, feet, etc.
// -------------------------------------------------------------------

// This will include:
// 1. Length

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // This is the main method where the program starts executing
        // It will include a menu for the user to select the type of conversion they want
        // and then prompt them for the necessary inputs.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Universal Converter!");
        System.out.println("This program will allow you to convert between various units of length.");
        System.out.println("Please select the type of conversion you would like to perform:");
        System.out.println("1 - Length");
        System.out.println("2 - Weight");
        // Future options can be added here for other types of conversions
        int choice = scanner.nextInt();

        Converter converter = null; // Initialize converter to null so it can be assigned later
        
        if (choice == 1) {
            converter = new LengthConverter();
        } else if (choice == 2) {
            converter = new WeightConverter();
        } else {
            System.out.println("Invalid choice. Please restart the program and select a valid option.");
        }

        // collects given units from converter
        String[] units = converter.getUnits();

        System.out.println("Please select from below what information you would like to convert?");
        for(int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + " - " + units[i]);
        }


        System.out.println("Please enter the unit you would like to convert from:");
        int var1 = scanner.nextInt() - 1;
        System.out.println("Please enter the unit you would like to convert to:");
        int var2 = scanner.nextInt() - 1;

        System.out.println("Please enter the number of" + units[var1] + " you would like to convert");
        double num = scanner.nextDouble();

        //Prefix array
        // String[] prefixes = {"yocta (y)", "zepto (z)", "atto (a)", "femto (f)", "pico (p)", "nano (n)", "micro (u)", "milli (m)", "centi (c)", "deci (d)", "(No prefix)", "deca (da)", "hecto (h)", "kilo (k)", "mega (M)", "giga (G)", "tera (T)", "peta (P)", "exa (E)", "zetta (Z)", "yotta (Y)"};
        String[] prefixes = {"yocta (y)", "zepto (z)", "atto (a)", "femto (f)", "pico (p)", "nano (n)", "micro (u)", "milli (m)", "centi (c)", "deci (d)", "(No prefix)", "deca (da)", "hecto (h)", "kilo (k)", "mega (M)", "giga (G)"};
        // double[] prefixValues = {0.000000000000000001, 0.000000000000001, 0.000000000001, 0.000000001, 0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 10, 100, 1000, 1000000, 1000000000, 1000000000000, 1000000000000000, 1000000000000000000, 1000000000000000000000, 1000000000000000000000000};
        double[] prefixValues = {0.000000000000000001, 0.000000000000001, 0.000000000001, 0.000000001, 0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 10, 100, 1000, 1000000, 1000000000};
        for(int i = 0; i < prefixes.length; i++) {
            System.out.println((i + 1) + " - " + prefixes[i]);
        }
        System.out.println("Please tell me what the prefix is for the number you entered for " + units[var1] + "(e.g., kilo, mega, etc.)");
        int prefixPrimary = scanner.nextInt() - 1;
        System.out.println("Please tell me what the prefix is for the number you would like to convert to " + units[var2] + "(e.g., kilo, mega, etc.)");
        int prefixSecondary = scanner.nextInt() - 1;

        // Converting the prefix to a multiplier
        double prefixMultiplier = prefixValues[prefixPrimary] / prefixValues[prefixSecondary];

        // Deciding on how best to convert the given metric
        double convertedNum = converter.convert(num, var1, var2);

        // Applying the prefix multiplier to the converted number
        convertedNum *= prefixMultiplier;

        System.out.println("The converted number is: " + convertedNum);

        scanner.close();
    }
}