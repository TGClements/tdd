import java.text.DecimalFormat;

public class Checkout {

    private static Checkout instance = null;

    public static Checkout getInstance() {

        if(instance == null){
            instance = new Checkout();
        }

        return instance;
    }

    public double getSalesTax(Cart cart) {
        DecimalFormat df = new DecimalFormat("0.00");
        double totalTax = 0.00;

        for(int i=0; i<cart.getNumItems(); i++) {

            if(!cart.getItem(i).getExempt()) {
                double unformatted = cart.getItem(i).getPrice() * 0.10;
                totalTax += Double.parseDouble(df.format(unformatted));

                if(cart.getItem(i).getImported()) {
                    double unformatted1 = cart.getItem(i).getPrice() * 0.05;
                    totalTax += Double.parseDouble(df.format(unformatted1));
                }
            }
            else if(cart.getItem(i).getImported()) {
                double unformatted1 = cart.getItem(i).getPrice() * 0.05;
                totalTax += Double.parseDouble(df.format(unformatted1));
            }
        }

        return Math.round(totalTax * 20) / 20.00;
    }

    public double getTotalItemPrice(Item item) {
        DecimalFormat df = new DecimalFormat("0.00");
        double totalItemPrice = 0.00;
        double itemTax = 0.00;

        if(!item.getExempt()) {
            double unformatted = item.getPrice() * 0.10;
            itemTax += Double.parseDouble(df.format(unformatted));

            if(item.getImported()) {
                double unformatted1 = item.getPrice() * 0.05;
                itemTax += Double.parseDouble(df.format(unformatted1));
            }
        }
        else if(item.getImported()) {
            double unformatted1 = item.getPrice() * 0.05;
            itemTax += Double.parseDouble(df.format(unformatted1));
        }

        totalItemPrice = Double.parseDouble(df.format(item.getPrice() + itemTax));

        return totalItemPrice;
    }

    public double getTotal(Cart cart) {
        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0.00;

        for(int i=0; i<cart.getNumItems(); i++) {
            total += cart.getItem(i).getPrice();
        }

        total += getSalesTax(cart);
        total = Double.parseDouble(df.format(total));

        return total;
    }

    public void printReceipt(Cart cart) {

        for(int i=0; i<cart.getNumItems(); i++) {
            System.out.println("1 " + cart.getItem(i).getName() + ": " + getTotalItemPrice(cart.getItem(i)) );
        }
        System.out.println("Sales Tax: " + getSalesTax(cart) + " Total: " + getTotal(cart) + "\n");
    }
}
