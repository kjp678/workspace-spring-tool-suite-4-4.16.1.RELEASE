package org.programs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Employee implements Emp, Externalizable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;


    private Employee employee;

    public Employee(){

    }

    public Employee(int id, String name){
        this.id=id;
        this.name=name;
    }

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 33, "Male", "Product Development", 2012, 35700.0));

        //

        //1. male female count
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //2. names of department
        employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        //3. average age male and female employees
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        //4. names of employees who joined after 2015
        employeeList.stream().filter(a->a.yearOfJoining>2015).map(Employee::getName).distinct().collect(Collectors.toList());

        //5. count by department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        

        //1.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //2.
        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

        //3.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        //4.
        employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toSet());

        //5.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //6.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //7.
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

        //8.
        DoubleSummaryStatistics statistics1 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        //9.
        Map<String, List<Employee>> employees2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entries1 = employees2.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entries1) {
            String department = entry.getKey();
            List<Employee> value = entry.getValue();
            value.forEach(out::println);

        }

        //10.
        Optional<Employee> min = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));

        //1. male and female count
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //2. names of all departments
        employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        //3. average age of male and female employees
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //4. Names of employees who joined after 2015
        employeeList.stream().filter(a->a.yearOfJoining>2015).map(Employee::getName).distinct().collect(Collectors.toList());

        //5.Count number of employees in each department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //6.Average salary of each department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //7.oldest employee
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

        //8.average and total salary of organization
        employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        //9.names of employees by department
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entries = collect.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entries) {
            out.println("------------------------");
            out.println(entry.getKey());

            List<Employee> values = entry.getValue();
            values.forEach(a-> out.println("Latest :: "+a.name));
        }

        //
        List<String> collect1 = employeeList.stream().filter(a -> a.getGender().equals("Male")).map(a -> "Mr. " + a.getName() + " .").collect(Collectors.toList());
        out.println("Mr List "+collect1);

        //1. male and female count
         employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

         //2.Names of all the departments
        employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        //3.Average age of Male and Female Employees
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //4.Names of employees who joined after 2015
        employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toSet());

        //5.Count number of employees in each department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //6.Average salary of each department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //7.Oldest employee
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();

        //8.Average and Total Salary of Organization
        DoubleSummaryStatistics statistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));






        //1 gender wise count
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //2 department names
        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

        //3 average age of male female
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        //4
        employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toSet());

        //5 count employees by department
        Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //6 average salary of each department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //7
        Optional<Employee> oldIsGold = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        oldIsGold.get().getAge();
        oldIsGold.get().getDepartment();


        //8 average and total salary of organization
        DoubleSummaryStatistics summaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        summaryStatistics.getSum();

        //9 Employees by Department List

        Map<String, List<Employee>> mapEmpByDept =
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> set = mapEmpByDept.entrySet();

        for (Map.Entry<String, List<Employee>> entry : set) {
            String department = entry.getKey();
            out.println("Department Name ="+department);

            List<Employee> list= entry.getValue();
            list.forEach(out::println);
        }

        //10 Highest experienced Employee
        employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));

        //or Using sorted
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();



        //1. count of male and female employees

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


        //2. all departments names

        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

        //3. average age of Male and Female Employees.

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));


        //4.  names of employees who joined after 2015

        employeeList.stream().filter(a->a.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());


        //5. number of employees in each department.

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));


        //6. average salary of each department

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));


        //7. oldest employee, his department, age , name


        Optional<Employee> maxAgeEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).stream().findFirst();
        maxAgeEmp.get().getAge();
        maxAgeEmp.get().getName();
        maxAgeEmp.get().getDepartment();

        // employee by department with Max age
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));


        //8. average and total salary of the organization

        employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));


        //9.List down the employees of each department.

        out.println("-----9------");
        Map<String, List<Employee>> list = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> setMap = list.entrySet();

        for (Map.Entry<String, List<Employee>> entry : setMap) {
            out.println("------------------");
            out.println("Employee Department "+entry.getKey());
            out.println("------------------");
            List<Employee> listEmp = entry.getValue();
            out.println("Employee Names :: ");
            listEmp.forEach(a-> out.println(a.getName()));
        }


        //10. highest experienced employees in the organization

        employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));


        // highest experienced employees by department

        Map<String, Optional<Employee>> listMaxExp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));


        String colors[] = {"red", "green", "yellow", "red"};
        List<String> list2 = Arrays.asList(colors);
        list2.stream().collect(Collectors.groupingBy(a -> a, Collectors.mapping(a->a, Collectors.counting()) ))
                .entrySet()
                .stream()
                .forEach(a-> out.println(a));


    }

    public static void usefulMethods(){
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 33, "Male", "Product Development", 2012, 35700.0));


        //1.  male and female employees present in the organization

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


        //2.print the names of all departments in the organization.

        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

        //3. average age of Male and Female Employees.

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        //4. Get the Names of employees who joined after 2015.

        employeeList.stream().filter(a->a.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());

        //5. average salary of each department

        Map<String, Double> avgDeptSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        Set<Map.Entry<String, Double>> entries3 = avgDeptSalary.entrySet();

        for (Map.Entry<String, Double> entry : entries3) {

            out.println(entry.getKey());

            out.println(entry.getValue());
        }

        //6. oldest employee, his/her age and department?
        Optional<Employee> maxAge = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        maxAge.get().getName();
        String format1 = String.format("%s is the name :: %s is the age :: %s is the department", maxAge.get().name, maxAge.get().age, maxAge.get().department);


        //7. average and total salary of the organization.

        DoubleSummaryStatistics statistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        statistics.getSum();
        statistics.getAverage();
        statistics.getCount();

        List<Integer> list = Arrays.asList(1,2,1,2,2,3,3);
        list.stream().filter(a-> Collections.frequency(list,a)>1).distinct().collect(Collectors.toList());

        list.stream().filter(a->a%2!=0).map(b->b*b).mapToInt(c->c).sum();

        Set<Integer> duplicates = new HashSet<>();

        Set<Integer> set = list.stream().filter(a-> ! duplicates.add(a)).collect(Collectors.toSet());

        //print the repeating
        out.println(set);



        //1 . male female count

        Map<String, Long> countByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //2 . names of all departments

        employeeList.stream().map(Employee::getDepartment).distinct();


        //3 . "average-age" of Male and Female Employees.

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));


        //4 . employees joined after 2015
        employeeList.stream().filter(a -> a.getYearOfJoining() > 2015).collect(Collectors.toList());


        //5 . max age employee
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge));


        //6 . number of employees in each dept
        Map<String, Long> deptWise = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        out.println(deptWise);


        Set<Map.Entry<String, Long>> entries = deptWise.entrySet();
        out.println("Entries " + entries);

        entries.forEach(a -> out.println(a.getKey() + ": " + a.getValue()));


        //7 . oldest employee

        Optional<Employee> max1 = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        Optional<Employee> reversedFirst = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst();

        out.println("\nOldest Employee Name:" + reversedFirst.get().getName() + " Age : " + reversedFirst.get().age + " Department : " + reversedFirst.get().department);


        //8 . Department wise oldest employee
        out.println("Oldest Department wise");
        Map<String, Optional<Employee>> oldestDeptWise = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
        out.println(oldestDeptWise);

        Set<Map.Entry<String, Optional<Employee>>> entries2 = oldestDeptWise.entrySet();
        entries2.forEach(a->a.getValue().stream().forEach(aa-> out.println(aa.getName())));


        //average and total salary of organization
        Double salary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        out.println(salary);

        Double sum = employeeList.stream().mapToDouble(Employee::getSalary).sum();

        out.println(sum);

        // summarizingDouble

        DoubleSummaryStatistics statistics2 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        Double totalSalary = statistics2.getSum();
        Double averageSalary = statistics2.getAverage();

        out.println("Total : " + totalSalary + " Average Salary : " + averageSalary);

        //Employees by Department
        Map<String, List<Employee>> entriesSet2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet2 = entriesSet2.entrySet();
        entrySet2.forEach(a->{
            out.println("---------------------");
            out.println("Department :: "+a.getKey());
            out.println("---------------------");
            List<Employee> valueList = a.getValue();

            valueList.forEach(employee-> out.println("Employee name :: "+employee.getName()));


        });


        Map<String, List<Employee>> empDeptmap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        out.println("Employees by Department");
        out.println(empDeptmap);

        Set<Map.Entry<String, List<Employee>>> entries1 = empDeptmap.entrySet();

        Map<String, List<Employee>> empList = employeeList.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> entrySet = empList.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("--------------------------------------");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("--------------------------------------");

            List<Employee> list2 = entry.getValue();
            for (Employee e : list2) {
                System.out.println(e.getName());
            }
        }

        //

        Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        out.println(max.get().salary);


        // highest experienced

        Optional<Employee> first1 = Optional.ofNullable(employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().orElse(null));
        out.println(first1);


        //sum of all employee's salary

        Double sumSalary = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        out.println("SUM SALARY :" + sumSalary);


        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8, 10, 10, 10, 10));

        Map<Integer, Long> countMap = numbersList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        out.println(countMap);

        OptionalInt max2 = numbersList.stream().mapToInt(a -> a).max();
        out.println("Max :: "+max2);

        Integer [] abc = {1,2,3};
        List<Integer> arrayList1 = Arrays.asList(abc);
        out.println(arrayList1);

        out.println("hi"+1+1);

        out.println("hi"+3+3);

        out.println(1+1+"hi"+1+1);


        out.println("\nArray String to ArrayList");

        String [] stringArray = {"abc", "ddd", "eee"};
        out.println("Printing array with Arrays.toString");
        out.println(Arrays.toString(stringArray));

        out.println("Printing array with Arrays.asList");
        out.println(Arrays.asList(stringArray));

        List<String> list3 = Arrays.asList(stringArray);
        list.stream().collect(Collectors.groupingBy(a -> a, Collectors.mapping(a -> a, Collectors.counting())))
                .entrySet()
                .forEach(ab-> out.println(ab.getKey()+" "+ab.getValue()));

        int a =1;
        int b =2;

        String format = String.format("%s is %s ", a, b);
        out.println(format);


        String[] geeks = {"Rahul", "Utkarsh",
                "Shubham", "Neelam"};

        List<String> al = new ArrayList<String>();

        Collections.addAll(al, geeks);

        out.println(al);
        out.println("Length of Array :: "+geeks.length);
        out.println(geeks[0].length());

        Map<String, Integer> collectMap = IntStream.range(0, al.size())
                .boxed()
                .collect(Collectors.toMap(al::get, Function.identity()));
        out.println("Map :: "+collectMap);

        String sentence= "Monday, Sunday";
        String[] split = sentence.split(",");

        //removal of trailing and leading white spaces
        String trim = sentence.trim();
        out.println(trim);
        out.print(Arrays.toString(split));

        List<String> strings = Collections.synchronizedList(al);
        out.println("synchronized list "+strings);

        int[] aa= {1,2,3};
        out.println();


        String [] arr = { "Red", "Violet", "Blue", "Yellow", "Red", "White", "Red", "Blue" };
        ArrayList<String> list5 = new ArrayList<>(Arrays.asList(arr));

// Print the duplicate strings from the list
        list5.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.mapping(s -> s, Collectors.counting())))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toList());

        String city = Emp.getCity();
        out.println(city);


        //max age from each department

        Map<String, Optional<Employee>> mapLatest = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
        out.println("map latest "+mapLatest);

    }

    public static void lastTry(){
        {
            List<Employee> employeeList = new ArrayList<>();

            employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
            employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
            employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
            employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
            employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
            employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
            employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
            employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
            employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
            employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
            employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
            employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
            employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
            employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
            employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
            employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
            employeeList.add(new Employee(277, "Anuj Chettiar", 33, "Male", "Product Development", 2012, 35700.0));

            //-------------------

            /**
             * Find out the count of male and female employees present in the organization?
             * Write a program to print the names of all departments in the organization.
             * Find the average age of Male and Female Employees.
             * Get the Names of employees who joined after 2015.
             * Count the number of employees in each department.
             * Find out the average salary of each department.
             * Find out the oldest employee, his/her age and department?
             * Find out the average and total salary of the organization.
             * List down the employees of each department.
             * Find out the highest experienced employees in the organization
             *
             */



            //1
            employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

            //2
            employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

            //3
            employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

            //4
            employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toSet());

            //5 count employees by department
            Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

            //6 average salary of each department
            employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

            //7
            employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));


            //8 average and total salary of organization
            employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();

            Map<String, List<Employee>> mapEmpByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

            Set<Map.Entry<String, List<Employee>>> set = mapEmpByDept.entrySet();

            for (Map.Entry<String, List<Employee>> entry : set) {
                String department = entry.getKey();
                out.println("Department Name ="+department);

                List<Employee> list= entry.getValue();
                list.forEach(out::println);
            }

            //9 highest experienced employee
            employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));

            Optional<Employee> first = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining).reversed()).findFirst();

            //1. count of male and female employees

            employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


            //2. all departments names

            employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());

            //3. average age of Male and Female Employees.

            employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));


            //4.  names of employees who joined after 2015

            employeeList.stream().filter(a->a.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());


            //5. number of employees in each department.

            employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));


            //6. average salary of each department

            employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));


            //7. oldest employee, his department, age , name


            Optional<Employee> maxAgeEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).stream().findFirst();
            maxAgeEmp.get().getAge();
            maxAgeEmp.get().getName();
            maxAgeEmp.get().getDepartment();

            // employee by department with Max age
            employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));


            //8. average and total salary of the organization

            employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));


            //9.List down the employees of each department.

            out.println("-----9------");
            Map<String, List<Employee>> list = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
            Set<Map.Entry<String, List<Employee>>> setMap = list.entrySet();

            for (Map.Entry<String, List<Employee>> entry : setMap) {
                out.println("------------------");
                out.println("Employee Department "+entry.getKey());
                out.println("------------------");
                List<Employee> listEmp = entry.getValue();
                out.println("Employee Names :: ");
                listEmp.forEach(a-> out.println(a.getName()));
            }


            //10. highest experienced employees in the organization

            employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));


            // highest experienced employees by department

            Map<String, Optional<Employee>> listMaxExp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));


            List<String> list2 = Arrays.asList("red, green, yellow, red");

            list2.stream().collect(Collectors.groupingBy(aaa -> aaa, Collectors.mapping(aaa->aaa, Collectors.counting()) ))
                    .entrySet()
                    .stream()
                    .forEach(e-> out.println(e.getKey() +" value "+e.getValue()));


        }
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
