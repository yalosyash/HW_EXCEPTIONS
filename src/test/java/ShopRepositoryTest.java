
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exception.NotFoundException;
import Exception.AlreadyExistsException;

class ShopRepositoryTest {
    @Test
    public void shouldAddToArray() {
        Product product1 = new Product(55, "Iphone", 65_000);
        Product product2 = new Product(56, "Nokia", 1000);
        Product product3 = new Product(57, "Xiaomi", 30_000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        Product[] expected = {product1, product2, product3};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addToArrayByIdShouldThrowException() {
        Product product1 = new Product(55, "Iphone", 65_000);
        Product product2 = new Product(56, "Nokia", 1000);
        Product product3 = new Product(56, "Xiaomi", 30_000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });
    }

    @Test
    public void shouldRemove() {
        Product product1 = new Product(55, "Iphone", 65_000);
        Product product2 = new Product(56, "Nokia", 1000);
        Product product3 = new Product(57, "Xiaomi", 30_000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(57);
        Product[] expected = {product1, product2};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdShouldThrowException() {
        Product product1 = new Product(55, "Iphone", 65_000);
        Product product2 = new Product(56, "Nokia", 1000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(5);
        });
    }
}