
public class NitWit {
	
	public static void nitWit(int x) {
		StringBuilder output = new StringBuilder("I am not a nitwit");
		
		if(x % 2 != 0) {
			output.delete(4,8);
		}
		
		System.out.println(output.toString());
	}

	public static void main(String[] args) {
		
		nitWit(19);
		nitWit(20);
		nitWit(-89);
		nitWit(-200);
		nitWit(100);
		nitWit(71);

	}

}
