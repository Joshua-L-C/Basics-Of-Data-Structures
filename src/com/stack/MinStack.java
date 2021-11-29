package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
	
//	List<Integer> list;
//	int minIndex = 0;
//	
//	
//	public MinStack() {
//        list = new ArrayList<Integer>();
//    }
//    
//    public void push(int val) {
//    	
////    	if(!list.isEmpty()) {
////    		
////    		if(list.get(minIndex) > val) {
////    			minIndex = list.size() - 1; 
////    		}
////    	}
//    	
//    	
//    	
//        list.add(val);
//    	findMin();
//    }
//    
//    public void pop() {
//        list.remove(list.size() - 1);
//        findMin();
//    }
//    
//    public int top() {
//    	return list.get(list.size() - 1);
//    }
//    
//    public int getMin() {
//    	System.out.println(list.size());
//        return list.get(minIndex);
//    }
//    
//    
//    private void findMin() {
//    	for(int runner = 0; runner < list.size() ; runner++) {
//    		if(list.get(runner) < list.get(minIndex)) {
//    			minIndex = runner;
//    		}
//    	}
//    }
	
	
//	Stack<Integer> stack;
//    Stack<Integer> minStack;
//    
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//    
//    public void push(int x) {
//        stack.push(x);
//        if (minStack.isEmpty() || x <= minStack.peek()) {
//            minStack.push(x);
//        }
//    }
//    
//    public void pop() {
//        if (stack.peek().equals(minStack.peek())) {
//        	minStack.pop();
//        }
//        stack.pop();
//    }
//    
//    public int top() {
//        return stack.peek();
//    }
//    
//    public int getMin() {
//        return minStack.peek();
//    }
    
    
    private class Node {
        int min;
        int value ; 
        Node next;
        
        Node(int val, int m) {
            value = val;
            min = m;
        }
    }
     
         Node top;
         public MinStack() {
         }

         public void push(int x) {
             if(top == null) {
                 top = new Node(x, x);
             } else {
                 Node node = new Node(x, Math.min(top.min, x));
                 node.next = top;
                 top = node;
             }
         }

         public void pop() {
            if(top != null){
                top = top.next;
            }
         }

         public int top() {
             return top != null ? top.value : -1;
         }

         public int getMin() {
            if(top != null) return top.min;
             
             return -1;
         }
	
	public static void main(String[] args) {
		MinStack ints = new MinStack();
		ints.push(5);
		ints.push(0);
		ints.push(10);
		ints.push(-3);
		ints.push(-4);
		
		
		System.out.println(ints.getMin());
		ints.pop();
		System.out.println(ints.getMin());
		ints.pop();
		System.out.println(ints.getMin());
		ints.pop();
		System.out.println(ints.getMin());
		ints.pop();
		System.out.println(ints.getMin());
	}

}

