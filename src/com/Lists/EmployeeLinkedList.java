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
}
