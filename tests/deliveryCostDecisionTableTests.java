import org.junit.jupiter.api.Test;

import static com.company.Main.deliveryCost;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class deliveryCostDecisionTableTests {

    @Test
    public void testCasePositive400() throws Exception {
        assertEquals(400,
                deliveryCost(1.2, 130, false, 1),
                "Delivery cost not as expected");
    }

    @Test
    public void testCasePositive720() throws Exception {
        assertEquals(720,
                deliveryCost(5.05, 170, true, 1.2),
                "Delivery cost not as expected");
    }

    @Test
    public void testCasePositive420() throws Exception {
        assertEquals(420,
                deliveryCost(15, 50, false, 1.4),
                "Delivery cost not as expected");
    }

    @Test
    public void testCasePositive800() throws Exception {
        assertEquals(800,
                deliveryCost(40, 190, false, 1.6),
                "Delivery cost not as expected");
    }

    @Test
    public void testCaseExceptionFragileFar() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(35, 30, true, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Fragile parcel could not be sent more than 30km");
    }

    @Test
    public void testCaseExceptionDistanceBelowZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(-2, 30, false, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Distance is low");
    }

    @Test
    public void testCaseExceptionDistanceZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(0, 30, false, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Distance is low");
    }

    @Test
    public void testCaseExceptionSizeBelowZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(4, -3, false, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Size is low");
    }

    @Test
    public void testCaseExceptionSizeZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(11, 0, true, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Size is low");
    }

    @Test
    public void testCaseExceptionUnknownLoad() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(18, 160, true, 1.1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Unknown load");
    }
}
