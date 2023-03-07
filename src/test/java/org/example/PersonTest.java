package org.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    Person person = new Person("john", 26);
    Optional<Person> personOptional = Optional.of(person);

    @Test
    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper
                = personOptional.map(Person::getName);
        Optional<String> nameOptional
                = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        assertEquals("john", name1);

        String name = personOptional
                .flatMap(Person::getName)
                .orElse("");
        assertEquals("john", name);
    }
}
