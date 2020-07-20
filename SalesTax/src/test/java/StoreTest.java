import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StoreTest {

    Store s = Store.getInstance();

    @Test
    @Order(1)
    public void canCreateStore() {
        try {
            assertNotNull(s);

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(2)
    public void addItems() {
        try {
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

            assertEquals(9, s.getItems());

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(3)
    public void canHaveMultipleInstances() {
        try {
            Store s2 = Store.getInstance();

            if(System.identityHashCode(s) == System.identityHashCode(s2)) {
                assertTrue(true);
            }
            else
                fail();

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(4)
    public void storeHasCarts() {
        try {
            s.addCart(new Cart(0));

            assertEquals(1, s.getCarts());

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    @Order(5)
    public void addToCart() {
        try {
            Cart c1 = new Cart(1);
            c1.addItem(s.getItem(0));

            assertEquals(1, c1.getNumItems());

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    @Order(6)
    public void addsToCartAndGenerateSalesTax() {
        try {
            s.addCart(new Cart(1));
            s.getCart(1).addItem(s.getItem(0));
            s.getCart(1).addItem(s.getItem(1));
            s.getCart(1).addItem(s.getItem(2));

            assertEquals("Music CD", s.getCart(1).getItem(1).getName());

            double totaltax = s.checkout.getSalesTax(s.getCart(1));

            assertEquals(1.50, totaltax);

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    @Order(7)
    public void getCartTotal() {
        try {

            double total1 = s.checkout.getTotal(s.getCart(1));

            assertEquals(29.83, total1);

            s.addCart(new Cart(2));
            s.getCart(2).addItem(s.getItem(3));
            s.getCart(2).addItem(s.getItem(4));

            double total2 = s.checkout.getTotal(s.getCart(2));

            assertEquals(65.13, total2);

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    @Order(8)
    public void getTotalItemPrice() {
        try {

            double total = s.checkout.getTotalItemPrice(s.getItem(1));
            assertEquals(16.49, total);

            double total2 = s.checkout.getTotalItemPrice(s.getItem(0));
            assertEquals(12.49, total2);

            double total3 = s.checkout.getTotalItemPrice(s.getItem(3));
            assertEquals(10.50, total3);

            double total4 = s.checkout.getTotalItemPrice(s.getItem(4));
            assertEquals(54.65, total4);

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }
}
