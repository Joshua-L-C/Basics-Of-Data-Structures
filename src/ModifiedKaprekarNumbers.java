
public class ModifiedKaprekarNumbers {
	 public static void kaprekarNumbers(int p, int q) {
	        
	        String possibleKString = "";
	       int possibleKSleng = 0;
	       long possibleKN = 0;
	       int left = 0;
	       int right = 0;
	       int mid = 0;
	       boolean oneFound = false;
	       
	       for(long runner = p; runner <= q; runner++){
	           
	           
	           possibleKN =  (runner * runner);
	           possibleKString = possibleKN + "";
	           
	           
	           possibleKSleng = possibleKString.length();
	           mid = possibleKSleng/2;
	           
	           if(possibleKString.substring(0,mid).equals("")){
	               left = 0;    
	           }else{
	               left = Integer.parseInt(possibleKString.substring(0,mid));    
	           }
	           
	           right = Integer.parseInt(possibleKString.substring(mid,possibleKSleng));
	           
	    
	               // System.out.println("Runner: " + runner);
	               // System.out.println("Number: " + possibleKString);    
	               // System.out.println("String Length: " + possibleKSleng);
	               // System.out.println("Mid Point: " + mid);
	               // System.out.println("Char At Mid: " + possibleKString.charAt(mid));
	               // System.out.println("Possible Left "+ left);
	               // System.out.println("Possible Right " + right );
	           
	           if((left + right) == runner){
	               System.out.print(runner + " ");
	               oneFound = true;
	           }
	           
	           
	          
	        }
	       
	       
	        if(!oneFound){
	           System.out.print("INVALID RANGE");
	        }

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
