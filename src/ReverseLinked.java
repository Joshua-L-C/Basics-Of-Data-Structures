

public class ReverseLinked {
	 
	 public ListNode reverseList(ListNode head) {
	        
	        if(head.next == null){
	            return head;
	        }
	        
	        ListNode backRunner = head;
	        ListNode frontRunner = backRunner.next;
	        
	        ListNode temp;
	        
	        if(frontRunner.next == null){
	            frontRunner.next = backRunner;
	            backRunner.next = null;
	            
	            return frontRunner;
	        }
	        
	        backRunner.next = null;

	        while(frontRunner.next != null) {
	        	
	        
	        	temp = frontRunner;
	        	frontRunner = frontRunner.next;
	        	temp.next = backRunner;
	        	backRunner = temp;
	        	
	        	temp = null;
	        }
	        
	        
	        frontRunner.next = backRunner;
	        return frontRunner;
	  }
	 
	 public static int recursiveSum(ListNode head) {
		 
		 if(head.next == null) {
			
			return head.val;
		 }
	
		 
		 int val = head.val + recursiveSum(head.next);
		 
		 
		 
		 return val;
	 }
	 
	 public static ListNode reverse(ListNode node) {
		 
		 if(node.next == null) {
			 return node;
		 }
		 
		 ListNode n = reverse(node.next); 
		 node.next.next = node;
		 node.next = null;
		 
		 return n;
	 }

	    static ListNode reverseRecursive(ListNode head)
	    {
	        if (head == null || head.next == null)
	            return head;
	 
	        /* reverse the rest list and put
	        the first element at the end */
	        ListNode rest = reverse(head.next);
	        head.next.next = head;
	 
	        /* tricky step -- see the diagram */
	        head.next = null;
	 
	        /* fix the head pointer */
	        return rest;
	    }
	 
	public static void main(String[] args) {
		
		ListNode x1 = new ListNode();
		ListNode x2 = new ListNode();
		ListNode x3 = new ListNode();
		ListNode x4 = new ListNode();
		ListNode x5 = new ListNode();
		ListNode x6 = new ListNode();
		
		x1.val = 1;
		x1.next = x2;
		
		x2.val = 2;
		x2.next = x3;
		
		x3.val = 3;
		x3.next = x4;
		
		x4.val = 4;
		x4.next = x5;
		
		x5.val = 5;
		x5.next = x6;
		
		x6.val = 6;
		
//		ReverseLinked tester = new ReverseLinked();
//		ListNode node = tester.reverseList(x1);
//		
//		
//		while(node.next != null) {
//			System.out.println(node.val);
//			node = node.next;
//		}
//		
//		System.out.println(node.val);
		
		
		ListNode node = reverse(x1);
		
		//int val = recursiveSum(x1);
		while(node.next != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
		System.out.println(node.val);
		
		//reverse(x1);
	}

}
