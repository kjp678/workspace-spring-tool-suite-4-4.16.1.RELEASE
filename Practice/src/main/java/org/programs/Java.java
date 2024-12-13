package org.programs;

import java.util.*;
import java.util.stream.Collectors;

public class Java {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        //odd even

        numbers.stream().filter(a->a%2!=0).forEach(a-> System.out.println("Odd "+a));
        numbers.stream().filter(a->a%2==0).forEach(a-> System.out.println("Even "+a));

        //remove duplicates from List

        numbers.stream().distinct().toList().forEach(a-> System.out.println("Using Distinct "+a));
        numbers.stream().toList().forEach(a-> System.out.println("Using set "+a));

        //print only unique elements
        numbers.stream().filter(a-> Collections.frequency(numbers,a)==1).toList().forEach(a-> System.out.println("Frequency "+a));

        //frequency of each character in String
        String str= "Beautiful";
        String[] split = str.split("");
        List<String> characters = Arrays.asList(split);
        Map<String, Long> mapCharCount = characters.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        mapCharCount.forEach((k,v)-> System.out.println(k+" "+v));

        //approach 2

        characters.stream().collect(Collectors.groupingBy(a->a));

        //Frequency of each element in an array

        numbers.stream().collect(Collectors.groupingBy(a->a, Collectors.counting())).forEach((k,v)-> System.out.println("Frequency of each number "+k+" is "+v));


        //sort the list in reverse order

        numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //prefix suffix
        characters.stream().map(a->"Mr."+a+" .").toList().forEach(a-> System.out.println(a));


        Map<Integer, String> map = Map.of(11, "A", 2, "ZB");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(a-> System.out.println(a));


    }
}
