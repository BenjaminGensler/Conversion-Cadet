# Conversion Cadet

A simple Java command-line application for converting between units of measurement. Built as a learning/practice project.

## Current state

The app is a single-run console program (`Main.java`) that walks the user through a menu-driven flow. There is no GUI, web interface, packaged JAR, or automated test suite yet — it's run directly from compiled `.class` files via Maven or an IDE.

### What it can do

When run, the program:

1. Asks the user to pick a conversion category: Length, Weight, Temperature, or Time.
2. Lists the units available for that category and asks which unit to convert *from* and *to*.
3. Asks for the numeric value to convert.
4. Asks for a metric prefix (e.g., kilo, milli, mega) to apply to both the "from" and "to" values, then computes a prefix multiplier.
5. Converts the value and prints the result.

### Supported categories and units

| Category | Units |
|---|---|
| Length | meters, inches, feet, yards, miles |
| Weight | grams, pounds, ounces |
| Temperature | Celsius, Fahrenheit, Kelvin |
| Time | seconds, minutes, hours, days, weeks, months, years |

Each category is implemented as its own class (`LengthConverter`, `WeightConverter`, `TemperatureConverter`, `TimeConverter`) that implements the shared `Converter` interface (`getUnits()` and `convert()`).

### Known limitations

- No input validation — entering a non-numeric value, an out-of-range menu choice, or an invalid unit index will crash the program with an exception rather than showing a friendly error.
- The metric-prefix step applies to every conversion, even Temperature and Time, where prefixes (kilo-seconds, milli-Celsius, etc.) don't really make sense.
- `WeightConverter` has "Metric tons" commented out in the source rather than removed.
- No unit tests exist yet.
- No `mvn package` build is configured to produce a runnable JAR (no `maven-shade-plugin` or `maven-assembly-plugin` in `pom.xml`), so the app is run from compiled classes, not a jar.

## Requirements

- Java 17 (set via `maven.compiler.source`/`target` in `pom.xml`)
- Maven

## How to run

From the `demo/` directory (where `pom.xml` lives):

```bash
# Compile the source
mvn compile

# Run the program
java -cp target/classes com.example.Main
```

Alternatively, open the `demo/` folder in an IDE (IntelliJ, VS Code with Java extensions, Eclipse) and run `Main.java` directly.

## Project structure

```
demo/
├── pom.xml
└── src/
    └── main/
        ├── java/com/example/
        │   ├── Main.java                # Entry point, console menu/flow
        │   ├── Converter.java           # Shared interface
        │   ├── LengthConverter.java
        │   ├── WeightConverter.java
        │   ├── TemperatureConverter.java
        │   └── TimeConverter.java
        └── resources/
            └── README.md                # This file
```
