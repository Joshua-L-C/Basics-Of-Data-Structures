package com.Lists;

public class IntList {
	
	private class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public Node head;
	
	
	public IntList(int value) {
		head = new Node(value);
	}
	
	public void printlist() {
		Node current = head;
		System.out.print("HEAD -> ");
		while(current != null) {
			System.out.print(current.value);
			System.out.print(" -> ");
			current = current.next;
		}
		
		System.out.print("null");
	}
	
	public void add(int value) {
		
		Node runner = head;
		Node holder = null;
		while(runner.value < value && runner.next != null) {
			holder = runner;
			runner = runner.next;		
		}

		if(value >= runner.value) {
			Node temp = new Node(value);
			runner.next = temp;
			return;
		}
		
		if(value < runner.value && holder == null) {
			Node temp = new Node(value);
			temp.next = runner;
			head = temp;
			return;
		}
		
		if(holder != null) {
			System.out.println("Holder: "+ holder.value);
			System.out.println("Runner: " + runner.value);
			
			Node temp = new Node(value);
			temp.next = runner;
			holder.next = temp;
			
			//runner.next = new Node(value);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		IntList x = new IntList(1);
		x.add(10);
		x.add(20);
		x.add(5);
		x.add(30);
		x.add(7);
		x.add(100);
		x.add(2324);
		x.add(-1);
		x.add(-10);
		x.add(-5);
		
		x.printlist();

	}

}
