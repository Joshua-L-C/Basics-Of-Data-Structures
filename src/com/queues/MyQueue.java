package com.queues;

import java.util.ArrayList;
import java.util.List;

class MyQueue {
    // store elements
    private List<Integer> data;         
    // a pointer to indicate the start position
    private int p_start;            
    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }
    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    };    
    /** Delete an element from the queue. Return true if the operation is successful. */
    public int deQueue() {
        if (isEmpty() == true) {
        	return -1;
            //return false;
        }
        int x = data.get(p_start);
        p_start++;
        return x;
        //return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
    	if(p_start <= data.size() - 1) {
    		return data.get(p_start);
    	}else {
    		return Integer.MIN_VALUE;
    	}
        
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_start >= data.size();
    }     



    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(7);
        q.enQueue(4);
        q.enQueue(6);
        q.enQueue(9);
        
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }
//        
//        q.deQueue();
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }
//        q.deQueue();
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }
//        q.deQueue();
//        if (q.isEmpty() == false) {
//            System.out.println(q.Front());
//        }
//        
        while(!q.isEmpty()) {
        	System.out.println(q.Front());
        	System.out.println(q.deQueue());
        }
        
        System.out.println(q.Front());
    }
}
