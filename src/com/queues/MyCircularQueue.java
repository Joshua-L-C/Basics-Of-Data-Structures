package com.queues;

class MyCircularQueue {

	int head = -1;
	int tail = -1;
	int[] array;
	
    public MyCircularQueue(int k) {
        this.array = new int[k];
        
    }
    
    
    //Starting at -1 increase a pointer from zero going down the array and wrapping around.
    public boolean enQueue(int value) {
    	
    	if(!isFull()) {
	        if(this.tail == -1) {
	        	
	        	this.head = 0;
	        	this.tail = 0;
	        	
	        	array[this.tail] = value;
	        	return true;
	        	
	        }else if(this.tail + 1 == this.array.length) {
	        	
	        	this.tail = 0;
	        	array[this.tail] = value;
	        	
	        	
	        	return true;
	        	
	        }else {
	        	
	        	this.tail++;
	        	array[this.tail] = value;
	        	return true;
	        }
    	}else {
    		
    		if(this.tail + 1 == this.head) {
    			array[this.tail] = value;
    		}
    		
    		return false;
    	}
    	
    }
    
    public boolean deQueue() {
    	
    	
    	if(this.head + 1 == this.array.length) {
    		this.head = 0;
    		array[this.head] = 0;
    		return true;
    	}else if(this.head == -1) {
    		return false;
    	}else {
    		
    		array[this.head] = 0;
    		this.head++;
    		return true;
    	}
    	
    
    }
    
    public int Front() {
        return this.array[this.head];
    }
    
    public int Rear() {
        return this.array[this.tail];
    }
    
    public boolean isEmpty() {
        if(this.head == -1 && this.tail == -1){
        	return true;
        }
        
        return false;
    }
    
    public boolean isFull() {
        if(this.tail + 1 == this.head || (this.tail == array.length - 1 && this.head == 0)) {
        	return true;
        }else {
        	return false;
        }
    }
    
    
    public void printOut() {
    	
    	
    	System.out.println("Head: " + this.head);
    	System.out.println("Tail: " + this.tail);
    	for(int runner = 0; runner < this.array.length; runner++) {
    		System.out.println("Indx: " + runner+ "  Value: " + this.array[runner]);
    	}
    }
    
    public static void main(String [] args) {
    	MyCircularQueue items = new MyCircularQueue(3);
    	System.out.println(items.enQueue(1));
    	System.out.println(items.enQueue(2));
    	System.out.println(items.enQueue(3));
    	System.out.println(items.enQueue(4));
    	items.printOut();
    	System.out.println(items.Rear());
    	System.out.println(items.isFull());
    	System.out.println(items.deQueue());
    	items.printOut();
    	System.out.println(items.enQueue(4));
    	items.printOut();
    	System.out.println(items.Rear());
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