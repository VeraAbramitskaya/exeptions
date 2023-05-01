import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test
    public void shouldRemoveByIDProductExist() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "Product1", 10);
        Product product2 = new Product(2, "Product2", 15);
        Product product3 = new Product(3, "Product3", 20);
        Product product4 = new Product(4, "Product4", 25);


        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);


        shop.remove(4);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIDProductNotExist() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "Product1", 10);
        Product product2 = new Product(2, "Product2", 15);
        Product product3 = new Product(3, "Product3", 20);
        Product product4 = new Product(4, "Product4", 25);


        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);


        // shop.remove(5);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(5);
        });
    }


}
