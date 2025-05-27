public class WeightConverter implements Converter {
    public String[] units = {
        "grams (g)",
        // "Metric tons (t)", 
        "Pounds (lb)", 
        "ounces (oz)"
    };
    private double[] conversionFactors = {
        1.0, 
        // 1e+6,
        453.592, 
        28.3495
    };

    public String[] getUnits() {
        return units;
    }

    public double convert(double value, int fromUnit, int toUnit) {
        double valueInMeters = value * conversionFactors[fromUnit];
        return valueInMeters / conversionFactors[toUnit];
    }
}
