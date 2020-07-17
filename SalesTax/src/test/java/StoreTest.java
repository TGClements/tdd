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
    public void canCreateItem() {
        try {
            Item i = new Item("Book", 12.49, 0);
            Item expected = i;
            assertEquals(expected, i);

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(3)
    public void canSetItemValues() {
        try {
            Item i = new Item("Music CD", 14.99, 1);

            assertEquals("Music CD", i.getName());

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(4)
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
    @Order(5)
    public void storeHasCarts() {
        try {
            s.addCart(new Cart(1));

            assertEquals(1, s.getCarts());

        } catch (RuntimeException e) {
            System.out.println(e);
            fail();
        }
    }

}