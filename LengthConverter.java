public class LengthConverter implements Converter {
    public String[] units = {
        "meters",
        "inches", 
        "feet", 
        "yards", 
        "miles"
    };
    private double[] conversionFactors = {
        1.0,        // meters
        0.0254,     // inches
        0.3048,     // feet
        0.9144,     // yards
        1609.34     // miles
    };

    public String[] getUnits() {
        return units;
    }

    public double convert(double value, int fromUnit, int toUnit) {
        double valueInMeters = value * conversionFactors[fromUnit];
        return valueInMeters / conversionFactors[toUnit];
    }
}
