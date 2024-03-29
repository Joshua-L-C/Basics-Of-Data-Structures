package com.Lists;

public class MergeLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	
	/*You are given the heads of two sorted linked lists list1 and list2.
	  Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
	  Return the head of the merged linked list.
	 *
	 * 
	 * Steps 
	 * 	- create a new list node variable 
	 *  - check the head of both linked Lists and assign the head to be the lower of the two.
	 *  - repeat this process until you reach the end of one of the lists.
	 *  - then just copy over the remainder of the other list
	 * 
	 */
	
	 public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		 
		 if(list1 == null && list2 != null) {
			 return list2;
		 }
		 
		 if(list1 != null && list2 == null) {
			 return list1;
		 }
		 
		 
		 if(list1 == null && list2 == null) {
			 return null;
		 }
		 
		 
		 
	     ListNode head = null;
	     ListNode runningHead = head;
	     
	     if(list1.val > list2.val) {
	    	 head =  new MergeLinkedList().new ListNode(list2.val);
	    	 list2 = list2.next;
	    	 
	     }else {
	    	 head = new MergeLinkedList().new ListNode(list1.val);
	    	 list1 = list1.next;
	    	 
	     }
		 
	     ListNode runnerHead = head;
	     
	     while(list1 != null && list2 != null) {

	    	 if(list1.val < list2.val) {
	    		 
	    		 runnerHead.next = list1;
	    		 runnerHead = runnerHead.next;
	    		 
	    		 list1 = list1.next;
	    	 }else if(list1.val > list2.val) {
	    		 runnerHead.next = list2;
	    		 runnerHead = runnerHead.next;
	    		 
	    		 
	    		 list2 = list2.next;
	    	 }else if(list1.val == list2.val){
                 runnerHead.next = list1;
	    		 runnerHead = runnerHead.next;
	    		 list1 = list1.next;
	    		 
	    		 
	    		 runnerHead.next = list2;
	    		 runnerHead = runnerHead.next;
	    		 list2 = list2.next;
             }
	    		 
	    	 
	    	 
	    	 
	     }

	     if(list1 != null ) {
	    	 while(list1 != null) {
	    		 
	    		 runnerHead.next = list1;
	    		 runnerHead = runnerHead.next;
		    	 list1 = list1.next;
	    	 }
	     }
     
	     if(list2 != null ) {
    	 	while(list2 != null) {
    		 
    		 runnerHead.next = list2;
    		 runnerHead = runnerHead.next;
    		 list2 = list2.next;
    	 }

    	
     }
	     
	     
		 
	  
		 return head;
	       
	 }
	 
	 public static int timestables(int x,int n) {
		 
		 
		
		     if(n == 0) {
		    	 
				 return 0;
			 }
		     
			 timestables(x,(n - 1));
			 System.out.println("Number " + x + " times " + n + " = " +x*n);
			 
			 while(x < 10 && n == 10) {
				 x++;
				 timestables(x,(n - 1));
			 }
		     
			 
			 return 0;
		 
	 }
	
	public static void main(String[] args) {
		
		ListNode first = new MergeLinkedList().new ListNode(1);
		first.next = new MergeLinkedList().new ListNode(2);
		first.next.next = new MergeLinkedList().new ListNode(4);
//		first.next.next.next = new  MergeLinkedList().new ListNode(8);
		
		ListNode second = new MergeLinkedList().new ListNode(2);
		second.next = new MergeLinkedList().new ListNode(3);
		second.next.next = new MergeLinkedList().new ListNode(4);
//		second.next.next.next = new  MergeLinkedList().new ListNode(7);
//		
		
		
//		while(first.next != null) {
//			System.out.println(first.val);
//			first = first.next;
//		}
//		
//		while(second.next != null) {
//			System.out.println(second.val);
//			second = second.next;
//		}
		
		ListNode head = mergeTwoLists(first, second);
		
		while(head.next != null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
//		
//		timestables(2, 10);
		
		
	}

}
