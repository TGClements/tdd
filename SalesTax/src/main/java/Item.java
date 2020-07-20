public class Item {
    private String name;
    private String type;
    private double price;
    private double id;
    private boolean isExempt, isImported;


    public Item(String name, double price, int id, String type) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.type = type;

        if(type.equals("Books") || type.equals("Food") || type.equals("Medical Products")) {
            isExempt = true;
            isImported = false;
        }
        else if(type.equals("Import Duty")) {
            isExempt = false;
            isImported = true;
        }
        else {
            isExempt = false;
            isImported = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setExempt(boolean b) {
        isExempt = b;
    }

    public boolean getExempt() {
        return isExempt;
    }

    public void setImported(boolean i) {
        isImported = i;
    }

    public boolean getImported() {
        return isImported;
    }

    public double getPrice() {
        return price;
    }
}