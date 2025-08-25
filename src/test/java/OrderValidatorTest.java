import com.example.onlineorderprocessing.InvalidAddressException;
import com.example.onlineorderprocessing.InvalidPaymentException;
import com.example.onlineorderprocessing.Order;
import com.example.onlineorderprocessing.OrderValidator;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class OrderValidatorTest {

    OrderValidator validator = new OrderValidator();

    // Valid order test case
    @Test
    void testValidOrder() {
        Order order = new Order("John", Arrays.asList("Phone", "Charger"), "UPI", "456 Elm St", "SAVE20");
        assertDoesNotThrow(() -> validator.validate(order));
    }

    // Missing payment method should throw exception
    @Test
    void testInvalidPayment() {
        Order order = new Order("Jane", Arrays.asList("Tablet"), null, "789 Oak St", null);
        assertThrows(InvalidPaymentException.class, () -> validator.validate(order));
    }

    // Empty delivery address should throw exception
    @Test
    void testInvalidAddress() {
        Order order = new Order("Bob", Arrays.asList("TV"), "Cash", "   ", "WELCOME");
        assertThrows(InvalidAddressException.class, () -> validator.validate(order));
    }

    // Test with no promo code (Optional.empty)
    @Test
    void testOptionalPromoCode() {
        Order order = new Order("Dave", Arrays.asList("Headphones"), "Card", "101 Maple St", null);
        assertFalse(order.getPromoCode().isPresent());
    }
}
