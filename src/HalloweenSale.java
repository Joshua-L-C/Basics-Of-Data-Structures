
public class HalloweenSale {
	

    public static int howManyGames(int price, int discount, int minPrice, int money) {
    	
    	int counter = 0;
    	
    	for(;money >= 0;) {
    		money = money - price;
    		
    		price = price - discount;
    		
    		if(price <= minPrice) {
    			discount = 0;
    			price = minPrice;
    		}
    		
    		counter++;
    	}
    	
    	return (counter - 1);
    }
	
	public static void main(String[] args) {
		
		System.out.println(howManyGames(20, 3, 6, 80));

	}

}
