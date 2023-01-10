package com.hashTables;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
	
	private LinkedList<StoredEmployee>[] hashTable;
	
	
	public ChainedHashTable() {
		
		hashTable = new LinkedList[10];
		
		for (int indx = 0; indx < hashTable.length; indx++) {
			
			hashTable[indx] = new LinkedList<StoredEmployee>();
			
		}
		
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		hashTable[hashedKey].add(new StoredEmployee(key, employee));
		
	}
	
	public Employee get(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iter = hashTable[hashedKey].listIterator();
		StoredEmployee employee = null;
		
		while(iter.hasNext()) {
			
			employee = iter.next();
			
			if(employee.key.equals(key)) {
				return employee.employee;
			}
		}
		
		return null;
	}
	
	
	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iter = hashTable[hashedKey].listIterator();
		StoredEmployee employee = null;
		int index = -1;
		
		while(iter.hasNext()) {
			
			employee = iter.next();
			index++;
			
			if(employee.key.equals(key)) {
				break;
			}
			
			
		}
		
		
		if(employee == null || !employee.key.equals(key)) {
			return null;
		}else{
			hashTable[hashedKey].remove(index);
			return employee.employee;
		}
		
	}
	
	private int hashKey(String key) {
		//return key.length() % hashTable.length;
		
		return Math.abs(key.hashCode() % key.length());
		
	}
	
	public void printHashTable() {
		for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i].isEmpty()) {
				System.out.println("Position "+i+ " is empty!");
			}else {
				System.out.print("Position "+i);
				ListIterator<StoredEmployee> iter = hashTable[i].listIterator();
				
				while(iter.hasNext()) {
					System.out.println(iter.next().employee);
					System.out.println("->");
				}
				
				System.out.println("null");
			}
		}
	}

	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee johnWilson = new Employee("John", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        
        ChainedHashTable ht = new ChainedHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        //ht.put("Wilson", johnWilson);
        ht.put("End", billEnd);
        
        
        ht.printHashTable();
        
        System.out.println();
        
        System.out.println("Retrieve Key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve Key Jones: " + ht.get("Jones"));
        
        ht.remove("Wilson");
        ht.remove("Jones");
        
        System.out.println();
        
        ht.printHashTable();
        
        System.out.println("Retrieve Key Jones: " + ht.get("Smith"));
	}

}
