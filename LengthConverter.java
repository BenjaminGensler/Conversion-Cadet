public class LengthConverter {
    private String[] units = {
        "meters",
        "inches", 
        "feet", 
        "yards", 
        "miles"
    };
    private double[] conversionFactors = {
        1.0, 
        0.0254, 
        0.3048, 
        0.9144, 
        1609.34
    };

    public double convert(double value, int fromUnit, int toUnit) {
        double valueInMeters = value * conversionFactors[fromUnit];
        return valueInMeters / conversionFactors[toUnit];
    }
}
