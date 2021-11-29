import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	
	
	public static List<List<Integer>> generate(int numRows) {
        	
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		
		
		triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
		
		if(numRows == 1) {
			return triangle;
		}
		
		triangle.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		
		
		if(numRows == 2) {
			return triangle;
		}
		
		
		
//	    for(int out = 0; out <= triangle.size() - 1; out++) {
//	    	List<Integer> val = triangle.get(out);
//	    	
//	    	for(int in = 0; in <= val.size() - 1; in++) {
//	    		System.out.print(val.get(in) + " ");
//	    	}
//	    	System.out.println();
//	    	
//	    }
		
	    System.out.println();
	    
	    for(int out = 1; out <= numRows - 1; out++) {
	    	List<Integer> val = new ArrayList<Integer>();
	    	val.add(1);
	    	
	    	for(int in = 0; in < triangle.get(out).size() - 1; in++) {
	    		val.add(triangle.get(out).get(in) + triangle.get(out).get(in + 1));
	    		
	    	}
	    	
	    	val.add(1);
	    	triangle.add(val);
	    	
	    }
	    
	    
	    
//	    for(int out = 0; out <= triangle.size() - 1; out++) {
//	    	List<Integer> val = triangle.get(out);
//	    	
//	    	for(int in = 0; in <= val.size() - 1; in++) {
//	    		System.out.print(val.get(in) + " ");
//	    	}
//	    	System.out.println();
//	    	
//	    }
	    
	    
		return null;
    }
	
	
	public static void main (String [] args) {
		generate(5);
	}
}
