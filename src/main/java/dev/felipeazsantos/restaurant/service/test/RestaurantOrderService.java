package dev.felipeazsantos.restaurant.service.test;

import dev.felipeazsantos.restaurant.dao.CustomerDao;
import dev.felipeazsantos.restaurant.dao.MenuItemDao;
import dev.felipeazsantos.restaurant.dao.RestaurantOrderDao;
import dev.felipeazsantos.restaurant.entity.*;
import dev.felipeazsantos.restaurant.util.DataLoadUtil;
import dev.felipeazsantos.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;

public class RestaurantOrderService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerJpaH2();
        entityManager.getTransaction().begin();
        DataLoadUtil.registerCategory(entityManager);
        DataLoadUtil.registerMenuItems(entityManager);

        MenuItemDao menuItemDao = new MenuItemDao(entityManager);
        CustomerDao customerDao = new CustomerDao(entityManager);
        RestaurantOrderDao restaurantOrderDao = new RestaurantOrderDao(entityManager);

        MenuItem menuItem = menuItemDao.findById(1L);

        Address address = new Address("Rua XYZ", "SP", "São Paulo", "123", "casa", "00000-000");
        Customer felipe = new Customer("11111111111", "Felipe");
        felipe.addAddress(address);
        RestaurantOrder restaurantOrder = new RestaurantOrder(felipe);
        RestaurantOrderMenuItem restaurantOrderMenuItem = new RestaurantOrderMenuItem(menuItem, 10L);
        restaurantOrder.addRestaurantOrderMenuItem(restaurantOrderMenuItem);

        customerDao.register(felipe);
        restaurantOrderDao.register(restaurantOrder);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
