import com.example.inventorymanagementsystem.InvalidProductException;
import com.example.inventorymanagementsystem.Product;
import com.example.inventorymanagementsystem.ProductNotFoundException;
import com.example.inventorymanagementsystem.ProductService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ProductServiceTest {

    // Tests adding a valid product
    @Test
    public void testAddValidProduct() {
        ProductService service = new ProductService();
        Product p = new Product("Pen", "Stationery", 10.0, 20);
        service.addProduct(p);
        assertEquals(1, service.getAllProducts().size());
    }

    // Tests exception when adding a product with invalid data
    @Test
    public void testAddInvalidProduct() {
        assertThrows(InvalidProductException.class, () -> {
            new Product("Notebook", "Stationery", -5.0, 10);
        });
    }

    // Tests exception when product is not found by name
    @Test
    public void testSearchByNameNotFound() {
        ProductService service = new ProductService();
        assertThrows(ProductNotFoundException.class, () -> {
            service.searchByName("Eraser");
        });
    }

    // Tests filtering low-stock products
    @Test
    public void testFilterLowStock() {
        ProductService service = new ProductService();
        service.addProduct(new Product("Milk", "Groceries", 20.0, 3));
        service.addProduct(new Product("Sugar", "Groceries", 15.0, 10));
        List<Product> lowStock = service.filterLowStock();
        assertEquals(1, lowStock.size());
        assertEquals("Milk", lowStock.get(0).getName());
    }
}
