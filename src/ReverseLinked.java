

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
	 
	 public static ListNode reverse(ListNode head) {
		 
		 if(head.next == null) {
			 
			 return new ListNode(head.val);
		 }
		 
		 
		 ListNode temp = reverse(head.next);
		 System.out.println(temp.val);
		 
		 return null;
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
		
		
		reverse(x1);
	}

}
