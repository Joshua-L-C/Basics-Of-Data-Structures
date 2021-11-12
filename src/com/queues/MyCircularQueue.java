package com.queues;

class MyCircularQueue {

	int head = -1;
	int tail = -1;
	int[] array;
	
	
	/*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public MyCircularQueue(int k) {
        this.array = new int[k];
        
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public boolean enQueue(int value) {
    	return false;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public boolean deQueue() {
    	return false;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public int Front() {
    	return -1;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public int Rear() {
        return -1;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public boolean isEmpty() {
    	return false;
    }
    
    
    /*
     * Function:
     * Steps:
     * Cases:
     * 
     */
    public boolean isFull() {
        return false;
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
    	MyCircularQueue items = new MyCircularQueue(6);
    	
    	/*["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//    			[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
    	*/
    	
    	items.enQueue(10);
    	items.enQueue(20);
    	items.enQueue(30);
    	items.printOut();
    	items.deQueue();
    	items.deQueue();
    	items.deQueue();
    	System.out.println();
    	items.printOut();
    	System.out.println();
    	items.enQueue(40);
    	items.enQueue(50);
    	items.enQueue(60);
    	items.printOut();
    	items.deQueue();
    	items.deQueue();
    	items.deQueue();
    	System.out.println();
    	items.printOut();
    	System.out.println();
    	items.enQueue(70);
    	items.enQueue(80);
    	items.enQueue(90);
    	items.enQueue(100);
    	System.out.println(items.Front());
    	items.printOut();
    	items.deQueue();
    	items.deQueue();
    	items.deQueue();
    	items.deQueue();
    	System.out.println();
    	items.printOut();
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