package fr.tuto.spring.products.web;

import fr.tuto.spring.products.Product;
import fr.tuto.spring.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api-v1/products")
public class ProductController {

    @Autowired
    IProductService service;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "ref"})
    @ResponseBody
    public Product getByNameAndReference(@RequestParam("name") String name, @RequestParam("ref") String ref) {
        return service.getByNameAndReeference(name, ref);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    @ResponseBody
    public List<Product> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"ref"})
    @ResponseBody
    public Product getByReference(@RequestParam("ref") String ref) {
        return service.getByReference(ref);
    }

}
