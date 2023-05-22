package com.lychee.store.dao;

import com.lychee.store.model.Category;
import com.lychee.store.model.Product;
import jakarta.persistence.EntityManager;

public class CategoryDAO {

    private EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Category category) {
        this.entityManager.persist(category);
    }
}
