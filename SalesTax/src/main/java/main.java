public class main {

    public static void main(String[] args) {

        Store s = Store.getInstance();

        Item i1 = new Item("Book", 12.49, 0, "Books");
        Item i2 = new Item("Music CD", 14.99, 1, "General Goods");
        Item i3 = new Item("Chocolate Bar", 0.85, 2, "Food");
        Item i4 = new Item("Imported Box of Chocolates", 10.00, 3, "Import Duty");
        i4.setExempt(true);
        Item i5 = new Item("Imported Bottle of Perfume", 47.50, 4, "Import Duty");
        Item i6 = new Item("Imported Bottle of Perfume", 27.99, 5, "Import Duty");
        Item i7 = new Item("Bottle of Perfume", 18.99, 6, "General Goods");
        Item i8 = new Item("Packet of Headache Pills", 9.75, 7, "Medical Products");
        Item i9 = new Item("Imported Box of Chocolates", 11.25, 8, "Import Duty");
        i9.setExempt(true);

        s.addItem(i1);
        s.addItem(i2);
        s.addItem(i3);
        s.addItem(i4);
        s.addItem(i5);
        s.addItem(i6);
        s.addItem(i7);
        s.addItem(i8);
        s.addItem(i9);

        s.addCart(new Cart(0));
        s.addCart(new Cart(1));
        s.addCart(new Cart(2));

        s.getCart(0).addItem(s.getItem(0));
        s.getCart(0).addItem(s.getItem(1));
        s.getCart(0).addItem(s.getItem(2));

        s.getCart(1).addItem(s.getItem(3));
        s.getCart(1).addItem(s.getItem(4));

        s.getCart(2).addItem(s.getItem(5));
        s.getCart(2).addItem(s.getItem(6));
        s.getCart(2).addItem(s.getItem(7));
        s.getCart(2).addItem(s.getItem(8));

        s.checkout.printReceipt(s.getCart(0));
        s.checkout.printReceipt(s.getCart(1));
        s.checkout.printReceipt(s.getCart(2));
    }

}
