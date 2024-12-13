package org.programs;

public interface Emp {

    default String getName() {
        return "abc";
    }

    static String getCity() {
        return "city";
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 1;
        x++;


        System.out.println(x+y);
//        System.out.println(y);

    }
}
