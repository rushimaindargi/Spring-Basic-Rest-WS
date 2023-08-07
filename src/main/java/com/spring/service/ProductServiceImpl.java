package com.spring.service;

import com.spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {

        products.add(new Product(01, "Samsung", 20999));
        products.add(new Product(02, "Apple", 99999));
        products.add(new Product(03, "Redmi", 14999));
        products.add(new Product(04, "Vivo", 8999));
    }

    @Override
    public List<Product> getProducts() {

        return products;
    }

    public Product getProduct(int id){

        Iterator<Product> itr = products.iterator();

        while (itr.hasNext()) {
            Product product = itr.next();
            if(product.getId()==id){
                return product;
            }
        }

        return null;
    }

    public void addProduct(int id, String name, double price){
        products.add( new Product(id, name, price));

    }

    public boolean deleteProduct(int id){


        for (int i = 0; i<products.size()-1; i++){

                Product product = products.get(i);
                if(product.getId()==id){
                    products.remove(i);
                    return true;
                }
        }
            return false;
    }

}
