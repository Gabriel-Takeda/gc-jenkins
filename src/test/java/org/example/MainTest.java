package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void celsiusToFahrenheit() {
        assertEquals(32.0, Main.celsiusToFahrenheit(0), 0.0001);

        assertEquals(212.0, Main.celsiusToFahrenheit(100), 0.0001);

        assertEquals(-40.0, Main.celsiusToFahrenheit(-40), 0.0001);
    }

    @Test
    void fahrenheitToCelsius() {
        assertEquals(0.0, Main.fahrenheitToCelsius(32), 0.0001);

        assertEquals(100.0, Main.fahrenheitToCelsius(212), 0.0001);

        assertEquals(-40.0, Main.fahrenheitToCelsius(-40), 0.0001);
    }
}
