package org.programs;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Programs {

    public static void main(String[] args) {

        Map<Integer, String> integerStringMap = Map.of(1, "a", 2, "b", 3, "c");

        Set<Integer> integers = new HashSet<Integer>(integerStringMap.keySet());

        Collection<String> values = integerStringMap.values();

        out.println("Keys :: "+integers);

        out.println("Values :: "+values.toString());

        String path = "https://blogfilestorage.azure.net/abc.txt";

        String fileName ="abc.txt";

        Integer position = null;

        char[] chars = path.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='/') {
                position = i;
            }
        }
        out.println("Final position of slash / = "+position);

        String ans = path.substring(0,position);
        out.println("ans :: "+ans);

        String[] split = path.split("/");

        Optional<String> first = Arrays.stream(split).skip(split.length-2).findFirst();

        out.println("First ::"+ first.get());

        out.println("Printing Array :: "+Arrays.toString(split));

        out.println("Printing Array :: "+Arrays.deepToString(split));

        out.println("Printing Array :: "+Arrays.asList(split));

        Arrays.stream(split).map(a->a+" ").forEach(out::print);

        if(fileName !=null || fileName !=""){
            String s = path.replaceAll("fileName", "");
        }else{
            String newPath = path;
        }
        Integer lastPosition= 10;

        String substring = path.substring(lastPosition);

        out.println("2nd attempt ");
        out.println("URL :: "+first);

        out.println("/////////////////////////////////");






//        ACID-
//        @Primary
//                @Transaction
//                publioc EMplotee addEMpliuu(){
//
//
//            Empoyee
//
//                    Department
//
//
//                    Company
//
//        }






//
//        Integer[] numbers= {1,1,2,2,2,3,4,5,5};
//
//        List<Integer> listNumbers = Arrays.asList(numbers);
//
//        listNumbers.stream().collect(Collectors.groupingBy(a->a, Collectors.mapping(a->a, Collectors.counting())))
//                .entrySet()
//                .stream()
//                .forEach(System.out::println);
//
//        listNumbers.stream().mapToInt(b->b).summaryStatistics();
//
//
//        String [] arr = { "Red", "Violet", "Blue", "Yellow", "Red", "White", "Red", "Blue" };
//        ArrayList<String> listColor = new ArrayList<>(Arrays.asList(arr));
//
//
//        listColor.stream().collect(Collectors.groupingBy(a->a, Collectors.mapping(a->a, Collectors.counting())))
//                .entrySet()
//                .stream()
//                .forEach(a-> System.out.println(a));
//
//
//// Print the duplicate strings from the list
//        List<Map.Entry<String, Long>> listColourWithCount = listColor.stream()
//                .collect(Collectors.groupingBy(s -> s, Collectors.mapping(s -> s, Collectors.counting())))
//                .entrySet()
//                .stream()
//                .collect(Collectors.toList());
//
//        System.out.println("List of Duplicate Colors :: "+listColourWithCount);
    }
}
