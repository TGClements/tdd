import java.text.DecimalFormat;
import java.util.ArrayList;

public class Store {

    private static Store instance = null;
    private ArrayList<Cart> CartList;
    private ArrayList<Item> ItemList;

    Checkout checkout = Checkout.getInstance();

    private Store() {

        CartList = new ArrayList<>();
        ItemList = new ArrayList<>();
    }

    public static Store getInstance() {

        if(instance == null){
            instance = new Store();
        }

        return instance;
    }

    public void addCart(Cart cart) {
        CartList.add(cart);
    }

    public int getCarts() {
        return CartList.size();
    }

    public Cart getCart(int num) {
        return CartList.get(num);
    }

    public void addItem(Item i) {
        ItemList.add(i);
    }

    public int getItems() {

        return ItemList.size();
    }

    public Item getItem(int i) {
        return ItemList.get(i);
    }
}