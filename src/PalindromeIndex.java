
public class PalindromeIndex {


    public static int palindromeIndexOld(String palindrome) {
    	
    	int headRunner = 0;
    	int tailRunner = palindrome.length() - 1;
    	int mid;
    	
    	if(palindrome.length() % 2 == 0) {
    		mid = (palindrome.length() / 2);
    	}else {
    		mid = (palindrome.length() / 2) + 1; 
    	}
    	
    	String firstHalf = "";
    	String secondHalf = "";
    	
    	for(int runner = 0; runner < mid; runner++) {
    		
    	
    		if(palindrome.charAt(runner) != palindrome.charAt(tailRunner)){
    			
    			
    			if(palindrome.charAt(runner + 1) == palindrome.charAt(tailRunner)) {
    				firstHalf += palindrome.charAt(runner) + palindrome.charAt(tailRunner);
    				secondHalf += palindrome.charAt(runner) + palindrome.charAt(tailRunner - 2);
    				
    				
    				if(firstHalf.equals(secondHalf)) {
        				return tailRunner;
        			}
    				
    				return runner;
    			}
    			
    			
    			
    			
    		}
    		
    		if(palindrome.charAt(runner) == palindrome.charAt(tailRunner - 1)) {
    			firstHalf += palindrome.charAt(runner + 2) + palindrome.charAt(tailRunner);
				secondHalf += palindrome.charAt(runner) + palindrome.charAt(tailRunner);
				
				if(firstHalf.equals(secondHalf)) {
    				return tailRunner;
    			}
				
				return tailRunner;
    		}
    		
    		
    		tailRunner--;
    	}
    	
    	
    	System.out.println("Head: "+headRunner);
    	System.out.println("Tail: "+tailRunner);
    	
    	
    	return 0;
    }
    
    public static int palindromeIndex(String palindrome){
    	
    	int mid;
    	String firstHalf;
    	String secondHalf;
    	
    	if(palindrome.length() % 2 == 0) {
    		
    		mid = (palindrome.length()/2);
    		
    		firstHalf = palindrome.substring(0,mid);
    		secondHalf = palindrome.substring(mid,palindrome.length());
    		
    	}else{
    		mid = (palindrome.length()/2) + 1;
    		
    		firstHalf = palindrome.substring(0,mid - 1);
    		secondHalf = palindrome.substring(mid,palindrome.length());
    	}
    	
    	
    	
    	
    	System.out.println(firstHalf);
    	System.out.println(secondHalf);
    	
    	return -1;
    }
	
	
	public static void main(String[] args) {

		System.out.println(palindromeIndex("afavvcc77"));
	
	}
}