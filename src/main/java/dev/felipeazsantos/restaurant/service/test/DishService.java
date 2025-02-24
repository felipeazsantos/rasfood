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

        Dish salmon = new Dish();
        salmon.setName("salmon in passion fruit sauce");
        salmon.setDescription("grilled salmon with passion fruit sauce");
        salmon.setAvailable(true);
        salmon.setPrice(BigDecimal.valueOf(60));

        EntityManager entityManager = JPAUtil.getEntityManagerJpaH2();
        DishDao dishDao = new DishDao(entityManager);
        entityManager.getTransaction().begin();
        dishDao.register(risotto);
        entityManager.flush();
        dishDao.register(salmon);
        entityManager.flush();
        System.out.println("the dish sought was: " + dishDao.findById(2L));

        dishDao.remove(salmon);
        entityManager.flush();
        System.out.println("the dish sought was: " + dishDao.findById(2L));

        entityManager.clear();
        risotto.setPrice(BigDecimal.valueOf(75.50));
        dishDao.update(risotto);
        entityManager.flush();

        System.out.println("the dish sought was: " + dishDao.findById(1L));
    }
}
