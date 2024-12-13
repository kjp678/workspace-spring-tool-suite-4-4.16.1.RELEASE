package org.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Special {

    public static void main(String[] args) {
        
        //working
        List<Integer> numbers = Arrays.asList(1,2,2,3,3,3,2,2);

        Map<Integer, Long> mapOccurrence = numbers.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        System.out.println(mapOccurrence);


        Map<Integer, Long> mapOccurrence2 = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(mapOccurrence2);


        char[] letters = {'a','b','b','c','c','c','d','c'};
        String name1 = "Beautiful";

        String[] split = name1.split("");
        List<String> chars = Arrays.asList(split);
        Map<String, Long> mapBeautiful = chars.stream().collect(Collectors.groupingBy(a->a, Collectors.counting()));
        System.out.println(mapBeautiful);


        String[] colours = {"Red", "Yellow", "Green", "Red"};
        Map<String, Long> colour = Arrays.asList(colours).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(colour);


//        Arrays.asList(letters);
//
//        Map<char[], Long> collect = Arrays.asList(letters).stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
//
////        Map<char[], Long> collect = Stream.of(letters).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
//        System.out.println(collect.toString());

    }
}
