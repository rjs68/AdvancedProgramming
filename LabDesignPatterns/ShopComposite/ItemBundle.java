package ShopComposite;

import java.util.ArrayList;

public class ItemBundle extends ShopComponent {
    String name;
    ArrayList<ShopComponent> items;

    public ItemBundle(String name){
        this.name = name;
        items = new ArrayList<ShopComponent>();
    }

    public void addItem(ShopComponent item){
        items.add(item);
    }

    public double compPrice(){
        double price = 0.0;
        for(ShopComponent item: items){
            price += item.compPrice();
        }
        return price;
    }

    public String toString(){
        String printString = String.format("%-11s £%4.2f:", name, compPrice());
        for(ShopComponent item: items){
            printString += "\n" + item;
        }
        return printString;
    }
}