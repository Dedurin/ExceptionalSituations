package ru.progect.Sinner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "ЧАСЫ CASIO COLLECTION MEN", 5_990);
    Product product2 = new Product(2, "ЧАСЫ CASIO G-SHOCK G-STEEL", 64_990);
    Product product3 = new Product(3, "ЧАСЫ CASIO COLLECTION VINTAGE", 13_390);

    @Test
    public void testRemoveProductByIdShouldRemoveProductFromRepository() {

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void testRemoveProductByIdNonExistingIdShouldThrowNotFoundException() {

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(5);
        });


    }
}

