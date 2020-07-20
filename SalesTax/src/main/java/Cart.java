import java.util.ArrayList;

public class Cart {
    int cartID;
    private ArrayList<Item> Itemlist;

    public Cart(int i) {
        cartID = i;
        Itemlist = new ArrayList<>();
    }

    public void addItem(Item i) {
        Itemlist.add(i);
    }

    public int getNumItems() {
        return Itemlist.size();
    }

    public Item getItem(int i) {
        return Itemlist.get(i);
    }
}