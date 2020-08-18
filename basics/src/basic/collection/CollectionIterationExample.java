package io.collection;

import io.lambda.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Elison","Elma",18),
                new Person("Bob","Birklin", 60),
                new Person("Chole","Chang",25),
                new Person("Danial", "Delson",27),
                new Person("Alice","Alkson",40),
                new Person("Francis", "Fang",55)
        );

        //iteration 1 : for loop //forever popular
        for (int i = 0; i < people.size(); i++){
            System.out.println(people.get(i));
        }

        //iteration 2 : for-in loop  //east to write and read
        for(Person p : people){
            System.out.println(p);
        }

        //iteration 3 : foreach   //can be done by other processor, better for parallel
        people.forEach(p -> System.out.println(p));
    }
}
