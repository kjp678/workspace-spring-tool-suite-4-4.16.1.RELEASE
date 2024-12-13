package org.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Fibo {

    public static void main(String[] args) {


        Integer a=0;
        Integer b=1;
        Integer current =0;
        //0 1 1 2 3 5 8 13 21 34 55 89 144
        for (int i = 1; i < 14; i++) {
            current= a+b;

            a=b;

            b=current;

            System.out.println(" "+current+ " ");


        }

        List<String> colors = Arrays.asList("Red", "Pink", "Red", "Green", "Orange");

        Map<String,Long> colorMap = colors.stream().collect(Collectors.groupingBy(color->color, Collectors.counting()));
        System.out.println(colorMap);

    }
}
