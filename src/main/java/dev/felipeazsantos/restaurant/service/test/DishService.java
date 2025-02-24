package dev.felipeazsantos.restaurant.service.test;

import dev.felipeazsantos.restaurant.dao.DishDao;
import dev.felipeazsantos.restaurant.entity.Dish;
import dev.felipeazsantos.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DishService {
    public static void main(String[] args) {

        Dish risotto = new Dish();
        risotto.setName("seafood risotto");
        risotto.setDescription("risotto accompanied by squid, octopus and shellfish");
        risotto.setAvailable(true);
        risotto.setPrice(BigDecimal.valueOf(88.50));

        EntityManager entityManager = JPAUtil.getEntityManagerJpaH2();
        DishDao dishDao = new DishDao(entityManager);
        entityManager.getTransaction().begin();
        dishDao.register(risotto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
