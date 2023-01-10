package com.hashTables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ScratchPadHashMap {

	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee johnWilson = new Employee("John", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        
        Map<String, Employee> hashmap = new HashMap<String, Employee>();
        
        hashmap.put("Jones", janeJones);
        hashmap.put("Doe", johnDoe);
        hashmap.put("Wilson", mikeWilson);
        hashmap.put("Smith", marySmith);
        
        
        
        //Iterator way of printing out things.
        Iterator<Employee> iter = hashmap.values().iterator();
        while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
        
        System.out.println();
        Employee sentBack = hashmap.put("Wilson",johnWilson);
        
        System.out.println();
        
        //
        hashmap.forEach((k,v) -> System.out.println("Key = " + k + " Val = "+ v));        
        System.out.println(sentBack);
        
        System.out.println();
        hashmap.putIfAbsent("Farmer", billEnd);
        hashmap.forEach((k,v) -> System.out.println("Key = " + k + " Val = "+ v));
        System.out.println();
        
        
        hashmap.getOrDefault("Tanner", billEnd);
        hashmap.forEach((k,v) -> System.out.println("Key = " + k + " Val = "+ v));
        System.out.println();
        
        System.out.println(hashmap.remove("Jane"));
        hashmap.forEach((k,v) -> System.out.println("Key = " + k + " Val = "+ v));
        System.out.println();
	}

}
