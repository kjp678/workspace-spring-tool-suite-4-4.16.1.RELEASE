package org.programs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee ;

    @Test
    public void add() {
        employee = new Employee();

        int sum = employee.add(4,5);

        assertEquals(9,sum);

    }

    @Test
    void subtract() {
       int subtraction = Employee.subtract(4,5);

       assertEquals(-1, subtraction);
    }

    @Test
    void multiply(){

        employee = new Employee();
        int multiplication = employee.multiply(4,5);

        assertEquals(20,multiplication, "Working");
    }
}