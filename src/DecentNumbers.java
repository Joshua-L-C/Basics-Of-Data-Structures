
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
            
            //int numberFives = 0;
            //int numberThrees = 0;
            
            

            
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
            // for(int r = 0; r < numberOfPossible5s;r++){
            //     System.out.print("5");
            // }
            
            // for(int r = 0; r < numberOfPossible3s;r++){
            //     System.out.print("3");
            // }
          
            System.out.println();
            
        }
    }
       
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		decentNumber(15);

	}

}
