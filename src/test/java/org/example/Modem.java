package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }
    public boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }

    public boolean priceIsInRange2(Modem modem2) {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }
}
