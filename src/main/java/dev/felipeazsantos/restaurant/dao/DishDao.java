package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.Dish;

import javax.persistence.EntityManager;

public class DishDao {

    private final EntityManager entityManager;

    public DishDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("Entity registered: " + dish);
    }
}
