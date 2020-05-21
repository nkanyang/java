package io.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaExceptionHandle {
    public static void main(String[] args) {
        int [] someNumbers = {1, 2, 3, 4};
        int key = 0;

        //way 1: catch outside the operation: not very precious
        try {
            process(someNumbers, key, (i, k) ->System.out.println(i / k) );
        }catch (ArithmeticException e){
            System.out.println("Devided by zero exception!");
        }

        //way 3: catch in lambda expression: not so readable
        process(someNumbers, key, (i, k) ->{
            try {
                System.out.println(i / k);
            }catch(ArithmeticException e){
                System.out.println("Devided by zero exception caught in lambda expression!");
            }
        } );

        //way 3: use a wrapper --- more elegant
        process(someNumbers, key, wrapperLambda((i, k) ->System.out.println(i / k) ));
    }

    static void process(int[] numberArray, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : numberArray){
            consumer.accept(i,key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            }catch (ArithmeticException e){
                System.out.println("first:" + v +"second:" + k);
                System.out.println("Devided by zero exception caught by a wrapper!");
            }
        };
    }
}
