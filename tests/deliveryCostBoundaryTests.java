import org.junit.jupiter.api.Test;

import static com.company.Main.deliveryCost;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class deliveryCostBoundaryTests {

    @Test
    public void testCaseBoundaryExceptionDistanceBelowZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(-0.01, 30, false, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Distance is low");
    }

    @Test
    public void testCaseBoundaryExceptionDistanceAboveZero() throws Exception {
        assertEquals(400,
                deliveryCost(0.01, 130, false, 1),
                "Delivery cost not as expected");
    }

    @Test
    public void testCaseBoundaryExceptionSizeBelowZero() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> deliveryCost(4, -1, false, 1));
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, "Size is low");
    }

    @Test
    public void testCaseBoundarySizeAboveZero() throws Exception {
        assertEquals(420,
                deliveryCost(13, 1, false, 1.4),
                "Delivery cost not as expected");
    }

//    TODO: cases could be extended with other boundary values

}
