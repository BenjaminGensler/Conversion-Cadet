package com.example;

public class MetricPrefixes {
    //Prefix array
    public static final String[] NAMES = {
            "yocta (y)", "zepto (z)", "atto (a)", "femto (f)", "pico (p)",
            "nano (n)", "micro (u)", "milli (m)", "centi (c)", "deci (d)",
            "(No prefix)", "deca (da)", "hecto (h)", "kilo (k)", "mega (M)", "giga (G)"
    };

    private static final double[] VALUES = {
            0.000000000000000001, 0.000000000000001, 0.000000000001, 0.000000001,
            0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 10, 100, 1000, 1000000, 1000000000
    };
    // Given the index of a "from" prefix and a "to" prefix, returns the multiplier
    public static double multiplierBetween(int fromIndex, int toIndex) {
        return VALUES[fromIndex] / VALUES[toIndex];
    }
}
