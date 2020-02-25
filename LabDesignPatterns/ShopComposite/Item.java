package ShopComposite;

public class Item extends ShopComponent{
    public String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double compPrice(){
        return price;
    }

    public String toString(){
        return String.format("\t%-10s £%4.2f", name, price);
    }
}