package dev.felipeazsantos.restaurant.service.test;

import dev.felipeazsantos.restaurant.dao.MenuItemDao;
import dev.felipeazsantos.restaurant.util.DataLoadUtil;
import dev.felipeazsantos.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MenuService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerJpaH2();
        DataLoadUtil.registerCategory(entityManager);
        DataLoadUtil.registerMenuItems(entityManager);
        MenuItemDao menuItemDao = new MenuItemDao(entityManager);
        System.out.println("List of MenuItems by price: " + menuItemDao.findByPrice(BigDecimal.valueOf(88.50)));
        System.out.println("MenuItem by name " + menuItemDao.findByName("salmon in passion fruit sauce"));
    }




}
