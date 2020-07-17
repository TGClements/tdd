import java.util.ArrayList;

public class Store {

    private static Store instance = null;
    private ArrayList<Cart> CartList;

    private Store() {

        CartList = new ArrayList<>();
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
}
