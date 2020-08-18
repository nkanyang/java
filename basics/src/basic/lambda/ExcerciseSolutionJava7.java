package io.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExcerciseSolutionJava7 {
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
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        // step 2:Create a method that prints all elements in the list
        System.out.println("Print the sorted list:");
        printAll(people);
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return true;
            }
        });
        // step 3:Create a method that prints all people that have last name beginning with C
        System.out.println("Print the list conditionally:");
        printLastNameBeginningWithC(people);
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                if(p.getLastName().startsWith("B"))
                    return true;
                else
                    return false;
            }
        });


    }

    private static void printAll(List<Person> people){
        for(Person p : people){
            System.out.println(p);
        }
    }
    private static void printLastNameBeginningWithC(List<Person> people){
        for(Person p : people){
            if(p.getLastName().startsWith("C")) {
                System.out.println(p);
            }
        }
    }

    private static void printConditionally(List<Person> people, Condition condition){
        for(Person p : people){
            if(condition.test(p)) {
                System.out.println(p);
            }
        }
    }

}
interface Condition{
    boolean test(Person p);
}