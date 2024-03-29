

public class PermutationsExample<T> {

	public static <T> void printAllRecursive(T[] elements, char delimiter) {
	       printAllRecursive(elements.length, elements, delimiter);
	}
	
	
	public static <T> void printAllRecursive(int n, T[] elements, char delimiter) {
		
		
		
		if(n == 1) {
			printArray(elements,delimiter);
		}else {
			
			for(int i = 0; i < n - 1;i++) {
				printAllRecursive(n - 1, elements, delimiter);
			
			
				if(n % 2 == 0) {
					swap(elements, i, n - 1);
				}else {
					swap(elements, 0 , n - 1);
				}
			
			}
			
			printAllRecursive(n - 1, elements, delimiter);
		}
		
	}
	
	
	private static <T> void swap( T [] input, int a, int b) {
		T tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
	
	
	private static <T> void printArray(T[] input , char delimiter) {
		System.out.println('\n');
		
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (delimiter+""));
		}
		
	}
	
	public static void main(String[] args) {

        Integer[] elements = {1,2,3};

        System.out.println("Rec:");
        printAllRecursive(elements, ';');

	}
	
	

}
