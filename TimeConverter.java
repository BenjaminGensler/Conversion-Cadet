public class TimeConverter implements Converter {
    public String[] units = {
        "seconds",
        "minutes",
        "hours",
        "days",
        "weeks",
        "months",
        "years"
    };
    
    private double[] conversionFactors = {
        1.0,          // seconds
        60.0,         // minutes
        3600.0,       // hours
        86400.0,      // days
        604800.0,     // weeks
        2629800.0,    // months (approx)
        31557600.0    // years (approx)
    };

    public String[] getUnits() {
        return units;
    }

    public double convert(double value, int fromUnit, int toUnit) {
        double valueInSeconds = value * conversionFactors[fromUnit];
        return valueInSeconds / conversionFactors[toUnit];
    }

}
