
public class GreatestLetter {
	
	int[] alpha = new int[123];
    int large = 0;
    public String greatestLetter(String s) {

        large = recur(s.toCharArray(),alpha,0,large);
        
        System.out.println(large);

        return Character.toString((char)(large));
    }

    public int recur(char[] value,int[] alphabets , int index,int largest){

        if(index >= value.length){
            return largest;
        }

        int current = (int)value[index];
        alphabets[current] += 1;

        largest = recur(value,alphabets,index + 1,largest);
        
        int otherCurrent = current + 32;
        
        if(current > 90) {
        	otherCurrent = current - 32;
        }

        if(alphabets[current] >= 1 && alphabets[otherCurrent] >= 1){
            if(largest < Math.min(current, otherCurrent)){
                largest = Math.min(current, otherCurrent);
            }
        }

        return largest;
    }
    
    public String greatestLetter1(String s) {
        int[] alphabets = new int[123];
        char[] value = s.toCharArray();
        int current = 0;

        for(int index = 0; index < value.length; index++){
            current = (int)value[index];

            alphabets[current] += 1;
        }

        for(int index = alphabets.length - 1; index >= 97; index--){
            // System.out.println(((char)index) + " : " + alphabets[index]);
            // System.out.println(((char)(index - 32))  + " : " + alphabets[(index - 32)]);

            if(alphabets[index] >= 1 && alphabets[(index - 32)] >= 1){
                return Character.toString(((char)(index - 32)));  
            }
        }   

        return "";
    }   

	public static void main(String[] args) {
		
		GreatestLetter tester = new GreatestLetter();
		
		String x = "lEeTcOdE";
		x = "arRAzFif";
		x = "AbCdEfGhIjK";
		x = tester.greatestLetter(x);
		
		System.out.println(x);

	}

}
