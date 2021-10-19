package com.Lists;

public class EmployeeLinkedList {
	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public void printlist() {
		EmployeeNode current = head;
		System.out.print("HEAD ->");
		while(current != null) {
			System.out.print(current.toString());
			System.out.print(" -> ");
			current = current.getNext();
		}
		
		System.out.print("null");
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void addBefore(Employee inserting, Employee finding) {
		
		EmployeeNode current = head;
		EmployeeNode before = null;
		while(current.toString().compareTo(finding.toString()) != 0 && current.getNext() != null) {
			before = current;
			current = current.getNext();
		}
		
		//System.out.println(current.toString());
		
		if(before == null) {
			addToFront(inserting);
			return;
		}
		
		
		if(before != null) {
			EmployeeNode temp = new EmployeeNode(inserting);
			
			temp.setNext(current);
			before.setNext(temp);
			return;
		}
		
		
		
	}
	
	public EmployeeNode removeFromFront() {
		if(isEmpty()) {
			return null;
		}
		
		EmployeeNode removeNode = head;
		head = head.getNext();
		size--;
		removeNode.setNext(null);
		return removeNode;
	}
	
	public static void main(String [] args) {
		
		  	Employee janeJones = new Employee("Jane", "Jones", 123);
	        Employee johnDoe = new Employee("John", "Doe", 4567);
	        Employee marySmith = new Employee("Mary", "Smith", 22);
	        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
	        Employee billEnd = new Employee("Bill", "End", 78);

	        EmployeeLinkedList list = new EmployeeLinkedList();

	        list.addToFront(janeJones);
	        list.addToFront(johnDoe);
	        list.addToFront(marySmith);
	        list.addToFront(mikeWilson);
	        list.printlist();
	        System.out.println();

	        list.addBefore(billEnd, johnDoe);
			list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);
	        list.printlist();

	    
	}
}
