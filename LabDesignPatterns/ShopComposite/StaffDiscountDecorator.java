package ShopComposite;

public class StaffDiscountDecorator extends ShopComponent{
    protected ShopComponent staffDiscountedItem;

    public StaffDiscountDecorator(ShopComponent staffDiscountedItem){
        this.staffDiscountedItem = staffDiscountedItem;
    }

    public double compPrice(){
        return staffDiscountedItem.compPrice() * 0.5;
    }

    public String toString(){
        return String.format("\t%-10s £%4.2f", staffDiscountedItem.name, compPrice());
    }
}