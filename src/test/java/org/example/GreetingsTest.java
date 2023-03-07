package org.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {
    Greetings greetings = new Greetings();
    @Test
    public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.of(
                        greetings.getEmpty(),
                        greetings.getHello(),
                        greetings.getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertEquals(greetings.getHello(), found);
    }

    @Test
    public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturnedAndRestNotEvaluated() {
        Optional<String> found =
                Stream.<Supplier<Optional<String>>>of(
                                this.greetings::getEmpty,
                                this.greetings::getHello,
                                this.greetings::getBye)
                        .map(Supplier::get)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .findFirst();

        assertEquals(greetings.getHello(), found);
    }
    @Test
    public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(
                        () -> greetings.createOptional("empty"),
                        () -> greetings.createOptional("hello")
                )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertEquals(greetings.createOptional("hello"), found);
    }

    @Test
    public void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned() {
        String found = Stream.<Supplier<Optional<String>>>of(
                        () -> greetings.createOptional("empty"),
                        () -> greetings.createOptional("empty")
                )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseGet(() -> "default");

        assertEquals("default", found);
    }
}
