package io.collection;

import io.lambda.Person;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Elison","Elma",18),
                new Person("Bob","Birklin", 60),
                new Person("Chole","Chang",25),
                new Person("Danial", "Delson",27),
                new Person("Alice","Alkson",40),
                new Person("Francis", "Fang",55)
        );

        people.stream()
                .filter(p -> p.getAge() > 30)
                .filter(p -> p.getAge() < 60)
                .forEach(p->System.out.println(p));


        boolean anyMatch = people.stream()
                .filter(p -> p.getAge() > 30)
                .filter(p -> p.getAge() < 60)
                .anyMatch(p->p.getFirstName() == "Alice");
        System.out.println("Is there an Alice in the collection who is between 30 and 60: "+ anyMatch);
    }
}
