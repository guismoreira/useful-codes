package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@Setter
public class Person {
    private String name;
    private int age;
    private String password;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    public static List<Person> search(List<Person> people, String name, Optional<Integer> age) {
        // Null checks for people and name
        return people.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getAge().get() >= age.orElse(0))
                .collect(Collectors.toList());
    }

    public static List<Person> search(List<Person> people, String name, Integer age) {
        // Null checks for people and name
        final Integer ageFilter = age != null ? age : 0;

        return people.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getAge().get() >= ageFilter)
                .collect(Collectors.toList());
    }

    public static List<Person> search(List<Person> people, String name) {
        return doSearch(people, name, 0);
    }

    public static List<Person> search(List<Person> people, String name, int age) {
        return doSearch(people, name, age);
    }

    private static List<Person> doSearch(List<Person> people, String name, int age) {
        // Null checks for people and name
        return people.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getAge().get().intValue() >= age)
                .collect(Collectors.toList());
    }

    // normal constructors and setters
}
