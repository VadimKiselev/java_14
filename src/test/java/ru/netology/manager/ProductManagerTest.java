package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Тестирование для начинающих", 1100, "О. Назина");
    private Smartphone phone1 = new Smartphone(2, "mi12", 25000, "xiaomi");
    private Smartphone phone2 = new Smartphone(3, "mi12 pro", 30000, "xiaomi");

    @Test
    public void shouldAddedProductToRepository() {

        manager.add(book1);
        manager.add(phone1);

        Product[] expected = new Product[]{book1, phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(phone1);

        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("mi12");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void productDoesNotMatchSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(phone1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Redmi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleProductMatchSameSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {phone1, phone2};
        Product[] actual = manager.searchBy("mi");
        assertArrayEquals(expected, actual);
    }
}