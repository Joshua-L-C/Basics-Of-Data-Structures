import java.math.BigInteger;

public class DecentNumbers {

    public static void decentNumber(int n) {

        if(n < 3){
            System.out.println(-1);
        }else{
            
            if(n == 3){
                System.out.println(555);
                return;
            }else if(n == 4){
                System.out.println(-1);
                return;
            }else if(n == 5){
                System.out.println(33333);
                return;
            }
              
            int numberOfPossible5s = n / 3;
            int numberOfPossible3s = 0;
            boolean possibilityFound = false;
            
            for(int multiplier = numberOfPossible5s * 3 ;multiplier >= 0;multiplier--){
                //System.out.println("Current 5s: " + numberOfPossible5s);
                
                numberOfPossible3s = n - multiplier; 
                
                if(numberOfPossible3s % 5 == 0 && multiplier % 3 == 0){
                    numberOfPossible5s = multiplier;
                    possibilityFound = true;
                    break;
                }
                
                
            }
            
            
            if(possibilityFound){
                
                String repeated5 = new String(new char[numberOfPossible5s]).replace("\0", "5");
                String repeated3 = new String(new char[numberOfPossible3s]).replace("\0", "3");          
                System.out.print(repeated5+repeated3);    
                
            }else{
                System.out.print("-1");
            }
  
            System.out.println();
            
        }
    }
    
    public static String appendAndDelete(String originString, String templateString, int k) {
        
        int originStringLeng = originString.length() - 1;
        int templateStringLeng = templateString.length() - 1;
        
        int unequalPoint = 0;
        
        
        
        for(int runner = 0; originString.charAt(runner) == templateString.charAt(runner) && runner < originStringLeng && runner < templateStringLeng ;runner++){
            System.out.println(originString.charAt(runner));
            unequalPoint = runner;
        }
        
        if(unequalPoint == templateStringLeng && unequalPoint == originStringLeng){
            return "Yes";
        }
            
            int x = originStringLeng - unequalPoint;
            int y = templateStringLeng - unequalPoint;

        
        //System.out.println("Spaces: " +spaces);
        if(x + y <= k){
            return "Yes";
        }else{
            return "No";    
        }
        
    }
    
    
    
  public static void kaprekarNumbers(int p, int q) {
        
	   String possibleKString = "";
       int possibleKSleng = 0;
       BigInteger possibleKN = new BigInteger("0");
       int left = 0;
       int right = 0;
       int mid = 0;
       boolean oneFound = false;
       
       for(int runner = p; runner < q; runner++){
           
    	   possibleKString = (runner * runner) + "";
           possibleKN =  new BigInteger(possibleKString);
           
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
           
           
          
           // System.out.println();
       }
       
       if(!oneFound){
           System.out.print("INVALID RANGE");
       }
       
   
 

    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//decentNumber(15);
		
		kaprekarNumbers(1, 99999);
		
		System.out.println(77777 * 77777);
		
		System.out.println(99999*99999);
	}

}
