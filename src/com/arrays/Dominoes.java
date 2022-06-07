package com.arrays;

public class Dominoes {
	  
    /*Steps
        1) Convert the String to a char array.
        2) Create a new char array the same size as the string
        3) Create two integer values called leftPointer and rightPointer.
        4) Increment the rightPointer until the you reach a Letter either L or R
        5) Pass this section to a sub routine that will reassign the values of the char array between the two pointers to 
           their appropriate values. 
           R . . . . L = increment the left pointer converting everything on its indexes R, decrement the right pointer coverting 
                         everything on its indexs L until they are leftPointer < rightPointer one and other if == index = . 
           R . . . . R = if both ends equal to right convert all the indexs to R
           L . . . . L = if both ends equal to left convert all the indexs to L 
           L . . . . R = if both ends are these return. 
        6) From there assign the leftPointer to the rightPointers original position. 
        7) Go back to step 4 and continue until you reach the end.
    */
    
    public static String pushDominoes(String dominoes) {
        
        char[] doms = dominoes.toCharArray();
        int domLength = doms.length;
        int leftPointer = 0;
        int rightPointer = 0;
        String ans = "";
        
        
        if(domLength < 2){
            ans = new String(doms);
            return ans;
        }else{
            rightPointer++;
        }

        
        for(;rightPointer <= (domLength - 1);rightPointer++){
            if(doms[rightPointer] != '.' || rightPointer == (domLength - 1)) {
                // System.out.println("LP: " + leftPointer);
                // System.out.println("RP: " + rightPointer);
                // System.out.println();
                
                
                push(doms,leftPointer, rightPointer);
                
                
                leftPointer = rightPointer;
            }
        }

        
        ans = new String(doms);
        
        // System.out.println(ans);
        // System.out.println();
        return ans;
    }
    
    public static void push(char[] dominoes, int leftP, int rightP){
        // System.out.println("In Push!");
        // System.out.println();
        
        
        
        
        if(dominoes[leftP] == '.' && dominoes[rightP] == '.'){
            //System.out.println("No Dominoes Pushed!");
            return;
        }
        
        if(dominoes[leftP] == 'L' && dominoes[rightP] == '.'){
            return;
        }
        
        if(dominoes[leftP] == '.' && dominoes[rightP] == 'R'){
            return; 
        }
        
        if(dominoes[leftP] == 'L' && dominoes[rightP] == 'R'){
            return;
        }
        
        
        
        if((dominoes[leftP] == 'R' && dominoes[rightP] == '.') || (dominoes[leftP] == 'R' && dominoes[rightP] == 'R')){
            for(int runner = leftP; runner <= rightP; runner++){
                dominoes[runner] = 'R';
            }
            
            return;
        }
        
        if((dominoes[leftP] == '.' && dominoes[rightP] == 'L') || (dominoes[leftP] == 'L' && dominoes[rightP] == 'L')){
            for(int runner = rightP; runner >= leftP; runner--){
                dominoes[runner] = 'L';
            }
            
            return;
        }
        
    
        
        if(dominoes[leftP] == 'R' && dominoes[rightP] == 'L'){
        
            for(int leftRunner = leftP, rightRunner = rightP; leftRunner <= rightRunner; leftRunner++, rightRunner--){
                
                if(leftRunner == rightRunner){
                    dominoes[leftRunner] = '.';
                    return;
                }else{
                    dominoes[leftRunner] = 'R';
                    dominoes[rightRunner] = 'L';
                }
                
            }
            
            
            return;
        }
        
        
        
        
    }
    
    
	public static void main(String[] args) {
		pushDominoes(".L.R...LR..L..");

	}

}
