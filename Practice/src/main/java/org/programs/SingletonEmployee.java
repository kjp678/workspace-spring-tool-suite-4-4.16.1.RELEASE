package org.programs;

import java.util.*;

public class SingletonEmployee {

    private static SingletonEmployee singletonEmployee;

    private SingletonEmployee(){

    }

    public static synchronized SingletonEmployee getInstance(){

        if (singletonEmployee == null){
            singletonEmployee = new SingletonEmployee();
        }
        return singletonEmployee;
    }

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(-1,-2,2,3);

        Optional<Integer> smallestPositive = list.stream().filter(a->a>0).sorted().findFirst();

        System.out.println("Smallest Positive :: "+smallestPositive);

        int a=0;
        int b=1;

        int total=0;

        int count=10;
        System.out.print(a+"\n "+b);
        for (int i=0; i<count; i++){
            // 0 1 1 2 3 5 8 13 21
            total = a+b;
            a=b;
            b=total;
            System.out.println(total);

        }

        System.out.println("Enter the factorial number ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int n=5;
        long fact =1;
        for (int i = 1; i < n+1; i++) {
            fact = fact*i;
        }
        System.out.println("Factorial :: "+fact);

        //factors
        List<Integer> factors = printFactors(6);
        factors.forEach(part-> System.out.println(part));

        //fibonacci
    }

    public static List<Integer> printFactors(Integer n){
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <n+1 ; i++) {
            if(n%i == 0){
//                System.out.println(i);
                list.add(i);
            }
        }

        return list;
    }

}
