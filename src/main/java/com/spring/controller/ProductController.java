package com.spring.controller;

import com.spring.model.Product;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    List<Product> getProducts(){
        return  productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id){

        return productService.getProduct(id);
    }

    @PostMapping("add")
    public Map<String, Object> addProduct(@RequestParam(value = "id")int id,
                                          @RequestParam(value = "name")String name,
                                          @RequestParam(value = "price")double price){

productService.addProduct(id, name,price);

        Map<String, Object> map = new HashMap<>();

        map.put("status", "Product Added Successfully");
        return map;
    }


    @DeleteMapping("delete")
    public boolean deleteProduct(@RequestParam(value = "id")int id){
        boolean status = false;

        status = productService.deleteProduct(id);

        return status;
    }
}
