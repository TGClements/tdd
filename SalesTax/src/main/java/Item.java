public class Item {
    private String name;
    private double price;
    private double id;

    public Item(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
