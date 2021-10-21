

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
	        
	        while(frontRunner.next != null) {
	        	temp = frontRunner;
	        	frontRunner = frontRunner.next;
	        	temp.next = backRunner;
	        	backRunner.next = temp;
	        	temp = null;
	        }
	        
	        
	        frontRunner.next = backRunner;
	        return frontRunner;
	    }
	 


	public static void main(String[] args) {
		
		ListNode x1 = new ListNode();
		ListNode x2 = new ListNode();
		ListNode x3 = new ListNode();
		ListNode x4 = new ListNode();
		
		x1.val = 1;
		x1.next = x2;
		
		x2.val = 2;
		x2.next = x3;
		
		x3.val = 3;
		x3.next = x4;
		
		x4.val = 4;
		
		ReverseLinked tester = new ReverseLinked();
		ListNode node = tester.reverseList(x1);
		
		
		while(node.next != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
