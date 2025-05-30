package com.example;
public interface Converter {
    String[] getUnits();
    double convert(double value, int fromUnitIndex, int toUnitIndex);
}
