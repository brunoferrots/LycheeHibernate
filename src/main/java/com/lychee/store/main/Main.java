package com.lychee.store.main;

import com.lychee.store.dao.CategoryDAO;
import com.lychee.store.dao.ProductDAO;
import com.lychee.store.model.Category;
import com.lychee.store.model.Product;
import com.lychee.store.util.JPAUtil;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        createProduct();

        var entityManager = JPAUtil.getEntityManager();
        var productDAO =  new ProductDAO(entityManager);

        Long id = 1L;
        var product = productDAO.selectProductById(id);
        System.out.println(product.getName());

//        List<Product> products = productDAO.listProducts();
//        List<Product> products = productDAO.listProductsByName("Xiaomi K9");
        List<Product> products = productDAO.listProductsByCategory("CELLS");
        products.forEach(p -> System.out.println(p.getName()));

        entityManager.close();
    }

    private static void createProduct() {
        Category cells = new Category("CELLS");
        Product cellPhone = new Product(
                "Xiaomi K9",
                "Very Good" ,
                new BigDecimal("800"),
                cells);

        var entityManager = JPAUtil.getEntityManager();
        var productDAO =  new ProductDAO(entityManager);
        var categoryDAO = new CategoryDAO(entityManager);

        entityManager
                .getTransaction()
                .begin();

        productDAO.register(cellPhone);
        categoryDAO.register(cells);

        entityManager
                .getTransaction()
                .commit();

    }
}
