package ShopComposite;

public class ShopTest{
    public static void main(String[] args){
        ShopComponent pen = new StudentDiscountDecorator(new Item("Pen", 1.20));
        ShopComponent ruler = new StaffDiscountDecorator(new Item("Ruler", 0.50));
        Item pencil = new Item("Pencil", 0.80);

        ItemBundle stationery = new ItemBundle("Stationery");
        stationery.addItem(pen);
        stationery.addItem(ruler);
        stationery.addItem(pencil);

        System.out.println(stationery);
    }
}