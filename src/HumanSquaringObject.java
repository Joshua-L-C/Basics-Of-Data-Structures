

public class HumanSquaringObject {
	
	public String calculationRoll = "-----Calculation Roll-----"; 
	public int ans = 0;
	public int firstDistance = 0;
	public int secondDistance = 0;
	public int distanceCounter = 0;
	
	
	public HumanSquaringObject() {
	}
	
	
	
	public  void humanSquaring(int number) {
		
		if(number % 10 == 0) {
			this.ans = number * number;
			this.calculationRoll += "\n";
			this.calculationRoll += number + " * " + number + " = " + (ans);
		}else{
			
			this.calculationRoll += "\n";
			this.calculationRoll += "Numbers that add to " + (number + number);
			this.calculationRoll += "\n";
			
			this.firstDistance = number;
			this.secondDistance = number;
			
			while((this.firstDistance % 10 != 0) && (this.secondDistance % 10 != 0)) {
				
				this.calculationRoll += firstDistance + "  " + secondDistance + "\n";
				this.firstDistance--;
				this.secondDistance++;
				this.distanceCounter++;
				
			}
			
			this.calculationRoll += this.firstDistance + "  " + this.secondDistance + "\n";
			
		}
		
		this.ans = (int) ((this.firstDistance * this.secondDistance) + (Math.pow(this.distanceCounter,2)));
		this.calculationRoll += "\n";
		this.calculationRoll += "("+this.firstDistance + " * " + this.secondDistance + ") + "+ this.distanceCounter+"^2 = "+ this.ans +"\n";
	}
	
	public static void main(String[] args) {
		
		HumanSquaringObject obj = new HumanSquaringObject();
		
		obj.humanSquaring(285);
		
		System.out.println(obj.calculationRoll);
		

	}

}
