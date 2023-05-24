package com.lychee.store.dao;

import com.lychee.store.model.Category;
import com.lychee.store.model.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryDAO {

    private EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Category category) {
        this.entityManager.persist(category);
    }

    public void update(Category category) {
        this.entityManager.merge(category);
    }

    public void remove(Category category) {
        category = this.entityManager.merge(category);
        this.entityManager.remove(category);
    }

    public Category selectCategoryById(Long id) {
        return this.entityManager.find(Category.class, id);
    }
    public List<Category> listCategories() {
        var jpql = "SELECT c FROM Category c";
        return this.entityManager
                .createQuery(jpql, Category.class)
                .getResultList();
    }
}
