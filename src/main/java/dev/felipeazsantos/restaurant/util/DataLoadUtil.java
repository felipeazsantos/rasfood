package dev.felipeazsantos.restaurant.util;

import dev.felipeazsantos.restaurant.dao.CategoryDao;
import dev.felipeazsantos.restaurant.dao.MenuItemDao;
import dev.felipeazsantos.restaurant.entity.Category;
import dev.felipeazsantos.restaurant.entity.MenuItem;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DataLoadUtil {

    public static void registerCategory(EntityManager entityManager) {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        Category mainDish = new Category("Main Dish");
        Category entry = new Category("entry");
        Category salad = new Category("salad");

        categoryDao.register(mainDish);
        entityManager.flush();
        categoryDao.register(entry);
        entityManager.flush();
        categoryDao.register(salad);
        entityManager.flush();
        entityManager.clear();
    }

    public static void registerMenuItems(EntityManager entityManager) {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        Category category = categoryDao.findById(1L);

        MenuItem risotto = new MenuItem();
        risotto.setName("seafood risotto");
        risotto.setDescription("risotto accompanied by squid, octopus and shellfish");
        risotto.setAvailable(true);
        risotto.setPrice(BigDecimal.valueOf(88.50));
        risotto.setCategory(category);

        MenuItem salmon = new MenuItem();
        salmon.setName("salmon in passion fruit sauce");
        salmon.setDescription("grilled salmon with passion fruit sauce");
        salmon.setAvailable(true);
        salmon.setPrice(BigDecimal.valueOf(60));
        salmon.setCategory(category);

        MenuItemDao menuItemDao = new MenuItemDao(entityManager);
        menuItemDao.register(risotto);
        entityManager.flush();

        menuItemDao.register(salmon);
        entityManager.flush();
//        System.out.println("the MenuItem sought was: " + menuItemDao.findById(1L));
//        System.out.println("the MenuItem sought was: " + menuItemDao.findById(2L));
//        menuItemDao.findAll().forEach(element -> System.out.println("the MenuItem sought was: " + element));
        entityManager.clear();

    }
}
