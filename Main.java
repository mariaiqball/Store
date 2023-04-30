public class Main {
    
    public static void main(String[] args) {

	    Store pacsun = new Store(1000, "Pacsun");
		//public Clothes(double buy, double sell, String type, int stock, String color, String size){

		pacsun.addItemInventory(new Clothes(10, 30, "hoodies", 30, "brown", "M" ));
		pacsun.addItemInventory(new Clothes(5, 10, "graphic tees", 30, "black", "S" ));
		pacsun.addItemInventory(new Clothes(15, 25, "jeans", 30, "light blue", "M" ));
		pacsun.addItemInventory(new Clothes(5, 15, "socks", 30, "white", "M" ));
		pacsun.addItemInventory(new Clothes(10, 20, "shorts", 30, "dark blue", "S" ));

		pacsun.printProducts();
		pacsun.printCatalog();

		int catalog = 0;
		int quantity = 0;

		while (catalog != -1){
			System.out.println("Choose the item you would like to purchase:");
			catalog = IO.readInt();

			if (catalog == -1){
				break;
			}
			
			
			while (catalog < -1 || catalog > pacsun.numOfProducts()-1){
				System.out.println("The item you chose is not available. Try again.");
				pacsun.printCatalog();
				catalog = IO.readInt();
			}
			

			System.out.println("How many would you like?");
			quantity = IO.readInt();
			
			if (quantity < 0){
				while (quantity < 0){
					System.out.println("The item you chose is not available. Try again.");
					pacsun.printCatalog();
					catalog = IO.readInt();
				}
			} 

			Clothes a = pacsun.getFromInventory(catalog);
			if (a.getStock() == 0){
				System.out.println("The item you chose is out of stock"); 
			}
			if (quantity > a.getStock()){
				System.out.println("The item you chose is out of stock in the number requested");
			}
			if (quantity < a.getStock()){
				pacsun.addItemCart(a);
				a.addCartNum(quantity);
			} 
		}

        System.out.println("Before Purchase:");
		System.out.println("Cart:");
		pacsun.printCart();
		pacsun.printProducts();
		System.out.println("Cash Register:");
		System.out.println("$" + pacsun.getCashRegister());
		
		pacsun.orderPurchased();
		
		System.out.println("After Purchase");
		System.out.println("Cart:");
		pacsun.printCart();
		pacsun.printProducts();
		System.out.println("Cash Register:");
	    System.out.println("$" + pacsun.getCashRegister());	
	
    }

}