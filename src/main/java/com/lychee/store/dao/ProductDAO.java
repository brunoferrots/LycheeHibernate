package com.lychee.store.dao;

import com.lychee.store.model.Product;
import jakarta.persistence.EntityManager;

public class ProductDAO {

    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Product product) {
        this.entityManager.persist(product);
    }
}
