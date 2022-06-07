package com.hashTables;

import com.Lists.Employee;
import com.Lists.EmployeeDoublyLinkedList;

public class SimpleHashTable {
	
	private Employee[] hashtable;
	
	public SimpleHashTable() {
		hashtable = new Employee[10];
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		if(hashtable[hashedKey] != null) {
			System.out.println("Sorry there is already an "
					+ "employee at this position: " + hashtable[hashedKey]);
		}else {
			hashtable[hashedKey] = employee;
		}
	}
	
	public Employee get(String key) {
		int hashedKey = hashKey(key);
		return hashtable[hashedKey];
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public void printHashtable() {
		for(int i = 0 ; i  < hashtable.length; i++) {
			System.out.println(hashtable[i]);
		}
	}
	
	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        
        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("End", billEnd);
        
        
        ht.printHashtable();
	}

}

