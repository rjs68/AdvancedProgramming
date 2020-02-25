package ShopComposite;

public class StudentDiscountDecorator extends ShopComponent{
    protected ShopComponent studentDiscountedItem;

    public StudentDiscountDecorator(ShopComponent studentDiscountedItem){
        this.studentDiscountedItem = studentDiscountedItem;
    }

    public double compPrice(){
        return studentDiscountedItem.compPrice() * 0.9;
    }

    public String toString(){
        return String.format("\t%-10s £%4.2f", studentDiscountedItem.name, compPrice());
    }
}