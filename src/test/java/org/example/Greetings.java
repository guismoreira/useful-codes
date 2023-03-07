package org.example;

import java.util.Optional;

public class Greetings {
    public Optional<String> getEmpty() {
        return Optional.empty();
    }

    public Optional<String> getHello() {
        return Optional.of("hello");
    }

    public Optional<String> getBye() {
        return Optional.of("bye");
    }

    public Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }
}
