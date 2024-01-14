package org.fasttrackit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureConverterTest {

    @Test
    public void testFahrenheitToCelsius() {
        double fahrenheit = 32.0;
        double expectedCelsius = 0.0;

        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);

        assertEquals(expectedCelsius, actualCelsius, 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        double celsius = 0.0;
        double expectedFahrenheit = 32.0;

        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001);
    }
}
