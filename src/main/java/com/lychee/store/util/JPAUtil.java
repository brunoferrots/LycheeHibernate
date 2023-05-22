package com.lychee.store.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManager ENTITY_MANAGER = Persistence
            .createEntityManagerFactory("store")
            .createEntityManager();

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
