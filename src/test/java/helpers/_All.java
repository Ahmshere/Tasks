package helpers;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

public class _All {


    public static void main(String[]args){

    checkArrayList(1000000);
    checkLinkedList(1000000);



    }

    public static void checkArrayList(int number){
        Instant start = Instant.now();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i<number; i++){
            numbers.add(i);
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("ArrayList : Прошло времени, мс: " + elapsed);
    }

    public static void checkLinkedList(int number){
        Instant start = Instant.now();
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for(int i = 0; i<number; i++){
            numbers.add(i);
        }

        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("LinkedList : Прошло времени, мс: " + elapsed);
    }
}
