package com.hashTables;


public class SimpleHashTable {
	
	private StoredEmployee[] hashtable;
	
	public SimpleHashTable() {
		hashtable = new StoredEmployee[10];
	}
	
	public void put(String key, Employee employee) {
		
		int hashedKey = hashKey(key);
		
		if(occupied(hashedKey)) {
			int stopIndex = hashedKey;
			
			if(hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			}else {
				hashedKey++;
			}
			
			while(occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = ( hashedKey + 1) % hashtable.length;
			}
		}
		
		if(occupied(hashedKey)) {
			System.out.println("Sorry there is already an "
					+ "employee at this position: " + hashtable[hashedKey]);
		}else {
			hashtable[hashedKey] = new StoredEmployee(key,employee);
		}
	}
	
	public Employee get(String key) {
		int hashedKey = findKey(key);
		
		if(hashedKey == -1) {
			return null;
		}
		
		return hashtable[hashedKey].employee;
	}
	
	public Employee remove(String key) {
		int hashedKey = findKey(key);
		
		if(hashedKey == -1) {
			return null;
		}
		
		Employee employee = hashtable[hashedKey].employee;
		hashtable[hashedKey] = null;
		return employee;
	}
	
	private int findKey(String key) {
		int hashedKey = hashKey(key);
		
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		
		
			int stopIndex = hashedKey;
			
			if(hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			}else {
				hashedKey++;
			}
			
			while(hashedKey != stopIndex && hashtable[hashedKey] != null &&
					!hashtable[hashedKey].key.equals(key)) {
				hashedKey = ( hashedKey + 1) % hashtable.length;
			}
			
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}else {
			return -1; 
		}
		
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	private boolean occupied(int index) {
		return hashtable[index] != null;
	}
	
	public void printHashtable() {
		for(int i = 0 ; i  < hashtable.length; i++) {
			if(hashtable[i]!= null) {
				System.out.println(hashtable[i].employee);
			}else {
				System.out.println("---");
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
        
        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Wilson", johnWilson);
        ht.put("End", billEnd);
        
        
        ht.printHashtable();
        
        System.out.println();
        
        System.out.println("Retrieve Key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve Key Jones: " + ht.get("Jones"));
        
        ht.remove("Wilson");
        ht.remove("Jones");
        
        System.out.println();
        
        ht.printHashtable();
        
	}

}

