# Conversion Cadet

A simple desktop app for converting between common units of length, weight, temperature, and time.

## Download & Install (macOS)

1. Go to the [Releases page](https://github.com/BenjaminGensler/Conversion-Cadet/releases) and download the latest `Conversion Cadet-x.x.x.dmg` file.
2. Open the downloaded `.dmg` file — it will mount like a disk and show the Conversion Cadet app icon.
3. Drag **Conversion Cadet** into your **Applications** folder.
4. The first time you open it, macOS will likely warn that it's from an "unidentified developer." Right-click (or Control-click) the app in Applications and choose **Open**, then confirm — you only need to do this once. After that, it opens normally like any other app.

> Currently, a packaged installer is only available for macOS. If you're on Windows or Linux, see [Building from source](#building-from-source) below to run it with Java directly.

## How to use it

When you open Conversion Cadet, you'll see a tabbed window with one tab per conversion category: **Length**, **Weight**, **Temperature**, and **Time**.

On each tab:

1. Pick the unit you're converting **from** using the first set of dropdowns.
2. Pick the unit you're converting **to** using the second set of dropdowns.
3. Optionally, choose a metric prefix (e.g., kilo, milli, centi) for each side if your value uses one — set this on "(No prefix)" if it doesn't apply.
4. Enter the number you want to convert in the text field.
5. Click **Convert**. The result appears below the button.

Switch tabs at any time to convert a different type of unit — each tab keeps its own inputs independently.

## Building from source

Requirements: Java 17 and Maven.

```bash
git clone https://github.com/BenjaminGensler/Conversion-Cadet.git
cd Conversion-Cadet/demo
mvn clean package
java -jar target/demo-1.0-SNAPSHOT.jar
```

Or open the `demo/` folder in IntelliJ IDEA (or another Java IDE) and run `ConverterFrame.java` directly.

## Project structure

```
demo/
├── pom.xml
└── src/main/java/com/example/
    ├── Main.java             # original console version [Terminal] *ignore
    ├── ConverterFrame.java   # Swing UI entry point
    ├── Converter.java        # shared interface for all converters
    ├── LengthConverter.java
    ├── WeightConverter.java
    ├── TemperatureConverter.java
    └── TimeConverter.java
```
