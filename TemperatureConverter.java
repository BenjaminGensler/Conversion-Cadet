public class TemperatureConverter implements Converter {
    public String[] units = {
        "Celsius (°C)",
        "Fahrenheit (°F)",
        "Kelvin (K)"
    };

    private double[] conversionFactors = {
        1.0,          // Celsius
        1.8,          // Fahrenheit
        1.0           // Kelvin (offset handled separately)
    };

    public String[] getUnits() {
        return units;
    }

    public double convert(double value, int fromUnit, int toUnit) {

        // Convert from the source unit to Celsius first
        double valueInCelsius;
        if (fromUnit == 0) { // Celsius
            valueInCelsius = value;
        } else if (fromUnit == 1) { // Fahrenheit
            valueInCelsius = (value - 32) / conversionFactors[1];
        } else { // Kelvin
            valueInCelsius = value - 273.15;
        }

        // Convert from Celsius to the target unit
        if (toUnit == 0) { // Celsius
            return valueInCelsius;
        } else if (toUnit == 1) { // Fahrenheit
            return valueInCelsius * conversionFactors[1] + 32;
        } else { // Kelvin
            return valueInCelsius + 273.15;
        }
    }

}
