package dev.felipeazsantos.restaurant.service.test;

import dev.felipeazsantos.restaurant.dao.AddressDao;
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
        AddressDao addressDao = new AddressDao(entityManager);
        RestaurantOrderDao restaurantOrderDao = new RestaurantOrderDao(entityManager);

        Address address = new Address("Rua XYZ", "SP", "São Paulo", "123", "casa", "00000-000");
        Customer felipe = new Customer("11111111111", "Felipe");
        felipe.addAddress(address);
        RestaurantOrder restaurantOrder = new RestaurantOrder(felipe);
        restaurantOrder.addRestaurantOrderMenuItem(new RestaurantOrderMenuItem(menuItemDao.findById(1L), 10L));
        restaurantOrder.addRestaurantOrderMenuItem(new RestaurantOrderMenuItem(menuItemDao.findById(2L), 5L));

        customerDao.register(felipe);
        restaurantOrderDao.register(restaurantOrder);

        System.out.println(addressDao.findCustomers("SP", "São Paulo", "rua xyz"));
        System.out.println(addressDao.findCustomersCriteria("SP", "São Paulo", "rua xyz"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
