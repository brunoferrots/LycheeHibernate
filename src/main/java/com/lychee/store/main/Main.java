package com.lychee.store.main;

import com.lychee.store.model.Product;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Product cellPhone = new Product();
        cellPhone.setName("Xiaomi K9");
        cellPhone.setDescription("Very Good");
        cellPhone.setPrice(new BigDecimal("800"));

        var entityManager = Persistence
                .createEntityManagerFactory("store")
                .createEntityManager();
        entityManager
                .getTransaction()
                .begin();
        entityManager.persist(cellPhone);
        entityManager
                .getTransaction()
                .commit();
        entityManager.close();
    }
}
