package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final Category category) {
        this.entityManager.persist(category);
    }

    public Category findById(final Long id) {
        return this.entityManager.find(Category.class, id);
    }

    public void update(final Category category) {
        this.entityManager.merge(category);
    }

    public void remove(final Category category) {
        this.entityManager.remove(category);
    }
}
