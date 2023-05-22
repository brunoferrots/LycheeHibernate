package com.lychee.store.main;

import com.lychee.store.dao.CategoryDAO;
import com.lychee.store.dao.ProductDAO;
import com.lychee.store.model.Category;
import com.lychee.store.model.Product;
import com.lychee.store.util.JPAUtil;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
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
        entityManager.close();
    }
}
