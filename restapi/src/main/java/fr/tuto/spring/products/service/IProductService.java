package fr.tuto.spring.products.service;
import fr.tuto.spring.products.Product;
import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product getById(Integer id);

    Product getByNameAndReeference(String name, String ref);

    List<Product> getByName(String name);

    Product getByReference(String ref);
}
