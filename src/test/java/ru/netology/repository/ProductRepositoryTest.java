package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(8, "Тестирование для начинающих", 1100, "О. Назина");
    private Smartphone phone1 = new Smartphone(35, "mi12", 25000, "xiaomi");

    @BeforeEach
    public void addProducts() {
        repository.save(book1);
        repository.save(phone1);
    }

    @Test
    public void shouldSaveOneBook() {
        ProductRepository repository = new ProductRepository();

        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {
        ProductRepository repository = new ProductRepository();

        repository.save(phone1);

        Product[] expected = new Product[]{phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllSavedProducts() {
        Product[] expected = {book1, phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemovedById() {
        repository.removeById(8);

        Product[] expected = {phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkingSuccessFullRemovingExistingElement() {
        repository.removeById(8);

        Product[] expected = {phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removingNonExistentElement() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(537);
        });
    }
}
