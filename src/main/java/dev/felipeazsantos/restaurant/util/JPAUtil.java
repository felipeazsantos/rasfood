package dev.felipeazsantos.restaurant.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final String JPA_H2 = "jpa-h2";
    private static final EntityManagerFactory entityManagerFactoryJpaH2 = Persistence.createEntityManagerFactory(JPA_H2);

    public static EntityManager getEntityManagerJpaH2() {
        return entityManagerFactoryJpaH2.createEntityManager();
    }
}
