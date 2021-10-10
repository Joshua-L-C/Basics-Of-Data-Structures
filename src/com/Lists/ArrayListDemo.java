package com.Lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Jane","Jane",10));
		empList.add(new Employee("Bob","Jane",20));
		empList.add(new Employee("Tom","Jane",30));
		empList.add(new Employee("Bill","Jane",40));
		
		 
		empList.forEach(emp -> System.out.println(emp.toString()));
		
		System.out.println(empList.size());
		
		empList.add(2, new Employee("Rich","Jane",40));
		
		empList.forEach(emp -> System.out.println(emp.toString()));
		
		System.out.println(empList.size()); 
		
		System.out.println();
		Employee[] employeeArray = empList.toArray(new Employee[empList.size()]);
		
		for(Employee em: employeeArray) {
			System.out.println(em.toString());
		}
		
		System.out.println(empList.indexOf(new Employee("Tom","Jane",30)));
		
		empList.remove(new Employee("Tom","Jane",30));
		empList.remove(0);
		
		empList.forEach(emp -> System.out.println(emp.toString()));
		
		
		
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(new Employee("Jane","S",10));
		list.addToFront(new Employee("John","F",10));
		list.addToFront(new Employee("James","S",10));
		list.addToFront(new Employee("Jun","A",10));
		
		list.printlist();
		list.removeFromFront();
		System.out.println();
		list.printlist();
		
		EmployeeDoublyLinkedList dList = new EmployeeDoublyLinkedList();
		dList.addToFront(new Employee("Jane","S",10));
		dList.addToFront(new Employee("John","F",10));
		dList.addToFront(new Employee("James","S",10));
		dList.addToFront(new Employee("Jun","A",10));
		
		dList.printlist();
		dList.removeFromFront();
		System.out.println();
		
		dList.addToEnd(new Employee("Bill","A",10));
		dList.printlist();
		System.out.println();
		System.out.println("Removed: " + dList.removeFromFront().toString());
		System.out.println("Removed End: " + dList.removeFromEnd().toString());
		
	}

}
