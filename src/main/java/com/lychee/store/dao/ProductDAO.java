package com.lychee.store.dao;

import com.lychee.store.model.Product;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Product product) {
        this.entityManager.persist(product);
    }

    public void update(Product product) {
        this.entityManager.merge(product);
    }

    public void remove(Product product) {
        product = this.entityManager.merge(product);
        this.entityManager.remove(product);
    }

    public Product selectProductById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    public List<Product> listProducts() {
        var jpql = "SELECT p FROM Product p";
        return this.entityManager
                .createQuery(jpql, Product.class)
                .getResultList();
    }

    public List<Product> listProductsByName(String name) {
        var jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return this.entityManager
                .createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> listProductsByCategory(String category) {
        var jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
        return this.entityManager
                .createQuery(jpql, Product.class)
                .setParameter("name", category)
                .getResultList();
    }

    public BigDecimal priceOfProductsByName(String name) {
        var jpql = "SELECT p.price FROM Product p WHERE p.name = :name";
        return this.entityManager
                .createQuery(jpql, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
