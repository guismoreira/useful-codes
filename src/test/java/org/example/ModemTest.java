package org.example;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ModemTest {
    Modem modem = new Modem(0.0);

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertTrue(modem.priceIsInRange1(new Modem(10.0)));
        assertFalse(modem.priceIsInRange1(new Modem(9.9)));
        assertFalse(modem.priceIsInRange1(new Modem(null)));
        assertFalse(modem.priceIsInRange1(new Modem(15.5)));
        assertFalse(modem.priceIsInRange1(null));
    }

    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertTrue(modem.priceIsInRange2(new Modem(10.0)));
        assertFalse(modem.priceIsInRange2(new Modem(9.9)));
        assertFalse(modem.priceIsInRange2(new Modem(null)));
        assertFalse(modem.priceIsInRange2(new Modem(15.5)));
        assertFalse(modem.priceIsInRange2(null));
    }
}
