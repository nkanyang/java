package io.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExcerciseSolutionJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Elison","Elma",18),
                new Person("Bob","Birklin", 60),
                new Person("Chole","Chang",25),
                new Person("Danial", "Delson",27),
                new Person("Alice","Alkson",40),
                new Person("Francis", "Fang",55)
        );

        // step 1:Sort list by last name
        Collections.sort(people,(p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // step 2:Create a method that prints all elements in the list
        System.out.println("Print the sorted list:");
        printConditionally(people, p -> true);

        // step 3:Create a method that prints all people that have last name beginning with C
        System.out.println("Print the list conditionally:");
        printConditionally(people, p -> p.getLastName().startsWith("B"));
        performConditionally(people, p -> p.getLastName().startsWith("B"), p -> System.out.println(p.getFirstName()));
    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate){
        for(Person p : people){
            if(predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p : people){
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
