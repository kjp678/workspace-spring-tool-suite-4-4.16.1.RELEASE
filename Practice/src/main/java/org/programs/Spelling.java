package org.programs;

import java.util.Arrays;
import java.util.List;

public class Spelling {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"Aman"),
                new Employee(2, "Banana"));

        List<Employee> employeeList1 = List.of(new Employee(1, "A"), new Employee(2, "B"));


        Employee fixedEmployee = fixSpelling(employeeList, 2, "Banana", "Bahubali");

        System.out.println(fixedEmployee);

    }

    public static Employee fixSpelling(List<Employee> list, int id, String oldName, String newName){

        int i = list.indexOf(new Employee(id, oldName));

        if(i!=-1) {
            list.set(i, new Employee(id, newName));


            return list.get(i);
        }

        return new Employee(100, "New");
    }


}
