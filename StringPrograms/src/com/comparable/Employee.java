package com.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Comparable<Employee> {
	
	private int empId;
	private String empName;
	private int deptId;
	private String status="active";
	private int salary;
	
	public enum daysOfTheWeek {
		Monday, Tuesday;
		
	}
	
	
	
	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
	
		
		List<Employee> empList1= new ArrayList<>();
		
		empList1.add(new Employee(1, "sanskruti", 1, "active", 20000));
		empList1.add(new Employee(2, "lalitha", 2, "active", 50000));
		empList1.add(new Employee(3, "raju", 3, "inactive", 60000));
		empList1.add(new Employee(4, "shivam", 4, "inactive", 40000));
		empList1.add(new Employee(5, "bob", 5, "active", 35000));
		empList1.add(new Employee(6, "alice", 2, "inactive", 35000));
		empList1.add(new Employee(7, "srinu", 1, "active", 35000));
		
		//print employee details based on department
		
		Map<Integer, List<Employee>> collectListByDept = empList1.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
		
		collectListByDept.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+"   "+entry.getValue());
		});
		//System.out.println(collectListByDept);
		
		empList1.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
		
		Map<Integer, Long> count = empList1.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
		
		count.entrySet().forEach(entry->{
			System.out.println("dept "+entry.getKey()+" count="+entry.getValue());
		});
		
		//System.out.println(count);
		//status wise count
		System.out.println("\n status wise count");
		Map<String, Long> collectStatus = empList1.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.counting()));
		System.out.println(collectStatus);
		
		long activeEmpCount= empList1.stream().filter(e->e.getStatus().equals("active")).count();
		long inactiveEmpCount= empList1.stream().filter(e->e.getStatus().equals("inactive")).count();
		
		System.out.print("\n active employee count=");
		System.out.println(activeEmpCount);
		System.out.print("\n inactive employee count=");
		System.out.println(inactiveEmpCount);
		
		System.out.println("\nMAX salary");
		Employee maxSalary = empList1.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("MAX ="+maxSalary);
		
		System.out.println("\nmin salary");
		Employee minSalary= empList1.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("min ="+minSalary);
		
		//print max salary of employee department wise
		
		Map<Integer, Optional<Employee>> deptWiseMax = empList1.stream().collect(Collectors.groupingBy((Employee::getDeptId), 
				Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println(deptWiseMax);
		//empList1.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee))))
		
		deptWiseMax.entrySet().forEach(entry->{
			System.out.println("dept "+entry.getKey()+"top emp="+entry.getValue());
			
			
		});
		
		 Employee employee = empList1.stream().sorted(Collections.reverseOrder()).map(x->x).findFirst().get();
		System.out.println(employee);
	}
	
	
}