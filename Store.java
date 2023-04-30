import java.util.ArrayList;

public class Store{

  //Attributes
	private ArrayList<Clothes> product; //inventory
	private ArrayList<Clothes> cart;
	private String name; 
	private double cashRegister;
	
	

    //Constructor
	public Store(double cashRegister, String name){
		this.product = new ArrayList<Clothes>();
		this.cart = new ArrayList<Clothes>();
		this.cashRegister = cashRegister;
		this.name = name;
	} 


    //Accessors
	public double getCashRegister(){
		return cashRegister;
	}  
	 
	public Clothes getFromInventory (int x){
		return product.get(x); 
	}


    //Mutators 
	public void addItemCart(Clothes x){
		cart.add(x);
	}

	public void removeItemCart(int x){
		cart.remove(x);
	}

	public void addItemInventory(Clothes x){
		product.add(x);
	}

	public void removeItemInventory(int x){
		product.remove(x);
	}

	//Methods 
	public double discount(double Discount, double total){
		double x = total*(1.00-Discount);
		return x;
	}

	public double tax(double total){
		double x = total*1.06625;
		return x;
	}

	

	public void printProducts(){
		System.out.println("Inventory:");
		System.out.println(product);
	}

	public void printCart(){
		System.out.println("[");
		for (int i = 0; i < cart.size(); i++){
			cart.get(i).printReciept();
		}
		System.out.println("]");
	}

	public void printCatalog(){
		for (int i = 0; i < product.size(); i++){
			Clothes x = product.get(i);
			String y = x.getType();
			System.out.print(i + ": " + y + "    ");
		}
		System.out.println(-1 + ": " + "Done shopping");
	}

	public int numOfProducts(){
		return product.size();
	}

	public boolean valid(int x, int i){
		int y = product.get(i).getStock();
		if (y >= x){
			return true;
		}
		else {
			return false;
		}
	}
	

	

	public double cartTotal(){
		double x = 0;
		for (int i = 0; i < cart.size(); i++){
			Clothes items = cart.get(i);
			x += items.total();
		}
		return x;
	}

	
	public void addRegister(double total){
		cashRegister += total;
	}

	public void orderPurchased(){
		cashRegister+= cartTotal()*1.06625;
		
		for (int i = 0; i < cart.size(); i++){
			cart.get(i).removeStock();
			cart.get(i).clearCartNum();
		}

		cart = new ArrayList<Clothes>();
	}

}



