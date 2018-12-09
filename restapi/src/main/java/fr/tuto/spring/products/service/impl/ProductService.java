package fr.tuto.spring.products.service.impl;

import fr.tuto.spring.products.Product;
import fr.tuto.spring.products.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    List<Product> product = Arrays.asList(
            new Product(1, "Chaise", "XCED"),
            new Product(2, "Fauteuil", "XDCE"),
            new Product(3, "Fauteuil", "XDRP")
    );


    public List<Product> findAll() {
        return product;
    }

    public Product getById(Integer id) {
        return this.product.stream().
                filter(p -> Objects.equals(p.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public Product getByNameAndReeference(String name, String ref) {
        return product.stream().filter(
                p -> ref != null && name != null && Objects.equals(name.toUpperCase(), p.getName().toUpperCase())
                        && Objects.equals(p.getReference().toUpperCase(), ref.toUpperCase())
        ).findFirst().orElse(null);
    }

    @Override
    public List<Product> getByName(String name) {
        return product.stream().filter(
                p -> name != null && Objects.equals(name.toUpperCase(), p.getName().toUpperCase())
        ).collect(Collectors.toList());
    }

    @Override
    public Product getByReference(String ref) {
        return product.stream().filter(
                p -> ref != null && Objects.equals(p.getReference().toUpperCase(), ref.toUpperCase())
        ).findFirst().orElse(null);
    }

}
