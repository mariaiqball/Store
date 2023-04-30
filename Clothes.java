public class Clothes{

    //Attributes
    private double buy; //buy price
    private double sell; //sell price
    private String type; //shirt, hoodie, jeans, etc.
    private int stock; //stock
    private String color; //color
    private String size; //xs, s, m, l, xl
    private int cartNum; //how much in cart 
  
  
    //Constructor
    public Clothes(double buy, double sell, String type, int stock, String color, String size){
        this.buy = buy;
        this.sell = sell;
        this.type = type;
        this.stock = stock;
        this.color = color;
        this.size = size;
        cartNum = 0;
    }
  
  
    //Accessors
    public double getBuy(){
        return buy;
    }
  
    public double getSell(){
        return sell;
    }
  
    public String getType(){
        return type;
    }
  
    public int getStock(){
       return stock;
    }
  
    public String getColor(){
        return color;
    }
  
    public String getSize(){
        return size;
    } 
  
    public int getCartNum(){
        return cartNum;
    }
  
    public double profit(){
        return sell - buy;
    }
  
      
  
    //Mutators
  
    public void addStock(int x){
        stock += x;
    }
  
    public void removeStock(){
        stock -= cartNum;
    }
  
    public void updateSell(int x){
        sell = x;
    } 
  
    public void updateBuy(int x){
        buy = x;
    }
  
    public void addCartNum(int x){
        cartNum += x;
    }
  
    public void removeCartNum(int x){
        cartNum -= x;
    }  
  
    public void clearCartNum(){
        cartNum = 0;
    }
    
    public double total(){
        return cartNum*sell;
    } 
  
    //replenish stock
    //clear stock 
    //print reciept
  
    public void printReciept(){
        System.out.println(cartNum + " " + size + " " + color + " " + type + " for $" + total());
    } 
  
  
  
    //ToString
    public String toString(){
        return "\n" + stock + " " + size + " " + color + " " + type + " for $" + sell ;
    }
  
}
