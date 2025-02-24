package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.Dish;

import javax.persistence.EntityManager;

public class DishDao {

    private final EntityManager entityManager;

    public DishDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("Entity registered: " + dish);
    }

    public Dish findById(final Long id) {
        return this.entityManager.find(Dish.class, id);
    }

    public void update(final Dish dish) {
        this.entityManager.merge(dish);
    }

    public void remove(final Dish dish) {
        this.entityManager.remove(dish);
    }
}
