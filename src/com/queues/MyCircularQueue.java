package com.queues;

class MyCircularQueue {

	int head = -1;
	int tail = -1;
	int[] array;
	
	
	/*
     * Function: Creates the queue with the particular number of elements
     * Steps: Initialize an array with the size of the queue provided.
     * Cases: k == null
     * 
     */
    public MyCircularQueue(int k) {
    	
    	if(k > 0) {
    		this.array = new int[k];
    	}else {
    		System.out.println("Error: Size needs to be greater than zero");
    	}
        
    }
    
    
    /*
     * Function: Adds an element to the end of the queue at the tail pointer.
     * Steps:
     * 		- Check if the array has just been initialized and if it has assign both head and tail to zero
     *      - Check to see if the queue is full if it is not then add 1 to the tail and change the value at 
     *        that index. 
     *      - Check to see if the queue is empty and assign both the head and tail variable to 0;
     * Cases:
     * 		head = -1 and tail = -1
     * 		tail = array.length
     * 		tail + 1 = head
     * 
     */
    public boolean enQueue(int value) {
    	
    		if(isEmpty()) {
	     		this.head = 0;
	     		this.tail = 0;
	     		
	     		this.array[this.tail] = value;
	     		return true;
	     		
    		}else if(!isFull()) {
    		
	    		if(this.tail + 1 == this.head) {
	    			
	    			if(array[this.tail] == -1) {
	    				this.array[this.tail] = value;
	            		return true;
	    			}else {
	    				return false;
	    			}
	    		}
	    		
	    		if(this.tail + 1 == this.array.length) {
	    			if(this.head == 0) {
	    				if(array[this.tail] == -1) {
	    					this.array[this.tail] = value;
	        				return true;
	    				}
	    				
	    			}else {
	    				this.tail = 0;
	    				this.array[this.tail] = value;
	    				return true;
	    			}
	    		}
	    		
	    		this.tail++;
	    		this.array[this.tail] = value;
	    		return true;

    	}else {
    		
    		
    		return false;
    	}
    }
    
    
    /*
     * Function: Removes an element from the head pointer of the queue.
     * Steps:
     * 		- If the queue is empty return false;
     * 		- Remove the item at the head by assigning it to zero and increasing head by 1
     *      
     * Cases:
     * 		head = tail and head value != 0
     * 	    head = array.length - 1;
     *      head = tail and head value == 0
     */
    public boolean deQueue() {
    	
    	if(isEmpty()) {
    		return false;
    	}else {
    		
    		if(this.head == this.tail && this.array[this.head] != -1) {
    			this.array[this.head] = -1;
    			return true;
    		}else if(this.head + 1 == this.array.length) {
    			if(this.tail == 0) {
    				if(this.array[this.head] != -1) {
    					this.array[this.head] = -1;
    					this.head = 0;
    	    			return true;
    				}
    			}else {
    				this.array[this.head] = -1;
    				this.head = 0;
    				return true;
    			}
    		}else {
    			this.array[this.head] = -1;
    			this.head++;
    			return true;
    		}
    		
    	}
    	
    	return false;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public int Front() {
    	if(!isEmpty()) {
    		return this.array[this.head];
    	}
    	return -1;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public int Rear() {
    	if(!isEmpty()) {
    		return this.array[this.tail];
    	}
    	return -1;
    }
    
    
    /*
     * Function: Returns weather the queue is empty
     * Steps:
     * 		- If the head pointer and the queue pointer and equal and the 
     * 		  items at those indexes are 0 then return true; 
     * 		- If the head and tail pointer are both pointing at -1
     * Cases:
     * 		head = 5 tail = 5 tail value = 0;
     * 
     */
    public boolean isEmpty() {
    	
    	if(this.head == -1 && this.tail == -1) {
    		return true;
    	}else if(this.head == this.tail && this.array[this.tail] == -1) {
    		return true;
    	}
    	
    	return false;
    }
    
    
    /*
     * Function: Returns weather the queue is full.
     * Steps: 
     * 		- If the tail pointer + 1 == head pointer and the current element at 
     * 		  the tail is not 0 return true
     * 		- If the head is at the 0 index and the tail is at the last index of the array.
     * 
     * Cases: 
     * 		- head = 0 tail = length
     * 
     */
    public boolean isFull() {
        if(this.head == this.tail + 1 && this.tail != 0) {
        	return true;
        }else if(this.head == 0 && this.tail == this.array.length - 1) {
        	return true;
        }else {
        	return false;
        }
    }
    
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public void printOut() {
    	
    	
    	System.out.println("Head: " + this.head);
    	System.out.println("Tail: " + this.tail);
    	for(int runner = 0; runner < this.array.length; runner++) {
    		System.out.println("Indx: " + runner+ "  Value: " + this.array[runner]);
    	}
    }
    
    public static void main(String [] args) {
    	
    	
    	/*["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//    			[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
    	*/
//    	
//    	["MyCircularQueue","enQueue","deQueue","Front","deQueue","Front","Rear","enQueue","isFull","deQueue","Rear","enQueue"]
//    			[[3],[7],[],[],[],[],[],[0],[],[],[],[3]]
    	
    	MyCircularQueue items = new MyCircularQueue(6);
    	System.out.println(items.enQueue(3));
    	System.out.println(items.deQueue());
    	System.out.println(items.Front());
    	System.out.println(items.deQueue());
    	System.out.println(items.Front());
    	System.out.println(items.Rear());
    	System.out.println(items.enQueue(0));
    	System.out.println(items.isFull());
    	System.out.println(items.deQueue());
    	System.out.println(items.Rear());
    	System.out.println(items.enQueue(3));
    	
    	
    	
    	
//    	items.enQueue(10);
//    	items.deQueue();
//    	items.enQueue(20);
//    	items.enQueue(30);
//    	items.enQueue(40);
//    	items.enQueue(50);
//    	items.enQueue(60);
//    	items.enQueue(70);
//    	items.printOut();
//    	
//    	items.deQueue();
//    	items.deQueue();
//    	items.deQueue();
//    	items.deQueue();
//    	items.deQueue();
//
//    	System.out.println();
//    	items.printOut();
//    	
//    	items.enQueue(20);
//    	items.enQueue(30);
//    	
//    	System.out.println();
//    	items.printOut();
//    	items.deQueue();
//    	System.out.println();
//    	items.printOut();
    	
//    	items.enQueue(80);
//    	items.enQueue(90);
//    	System.out.println();
//    	items.printOut();
//    	items.enQueue(100);
//    	items.enQueue(110);
//    	items.enQueue(120);
//    	System.out.println();
//    	items.printOut();
    	
    	
//    	System.out.println(items.enQueue(6));
//    	System.out.println(items.enQueue(6));
//    	System.out.println(items.Rear());
//    	System.out.println(items.Rear());
//    	System.out.println(items.deQueue());
//    	System.out.println(items.enQueue(5));
//    	System.out.println(items.Rear());
//    	System.out.println(items.deQueue());
//    	System.out.println(items.Front());
//    	System.out.println(items.deQueue());
//    	System.out.println(items.deQueue());
//    	System.out.println(items.deQueue());
    	
    	
//    	System.out.println(items.enQueue(6));
//    	System.out.println(items.Rear());
//    	System.out.println(items.Rear());
//    	System.out.println(items.deQueue());
//    	System.out.println(items.enQueue(5));
//    	System.out.println(items.Rear());
    	
//    	System.out.println(items.enQueue(1));
//    	System.out.println(items.enQueue(2));
//    	System.out.println(items.enQueue(3));
//    	System.out.println(items.enQueue(4));
//    	items.printOut();
//    	System.out.println(items.Rear());
//    	System.out.println(items.isFull());
//    	System.out.println(items.deQueue());
//    	items.printOut();
//    	System.out.println(items.enQueue(4));
//    	items.printOut();
//    	System.out.println(items.Rear());
//    	for(int runner = 0; runner < 11; runner++) {
//    		items.enQueue(runner);
//    	}
//    	
//    	
//    	items.printOut();
//    	
//    	
//    	for(int runner = 0; runner < 4; runner++) {
//    		items.deQueue();
//    	}
//    	
//    	System.out.println();
//    	System.out.println();
//    	System.out.println();
//    	
//    	
//    	items.printOut();
//    	
//    	for(int runner = 10; runner < 20; runner++) {
//    		items.enQueue(runner);
//    	}
//    	
//    	System.out.println();
//    	System.out.println();
//    	System.out.println();
//    	
//    	
//    	items.printOut();
    	
//    	for(int runner = 0; runner < 20; runner++) {
//    		System.out.println(runner + ": Increment: " + (runner + 1) % 10);
//    	
//    	}
//    	
//    	System.out.println();
//    	System.out.println();
//    	
//     	for(int runner = 0; runner < 20; runner++) {
//    	
//    		System.out.println(runner + ": Decrement: " + (runner + 10 - 1) % 10);
//    	}
    	
    	
    	
    }
}