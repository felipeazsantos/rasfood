package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.MenuItem;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

public class MenuItemDao {

    private final EntityManager entityManager;

    public MenuItemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final MenuItem menuItem) {
        this.entityManager.persist(menuItem);
        System.out.println("Entity registered: " + menuItem);
    }

    public MenuItem findByName(final String name) {
        try {
            String jpql = "SELECT mi FROM MenuItem mi WHERE lower(mi.name) = :name";
            return this.entityManager.createQuery(jpql, MenuItem.class).setParameter("name", name).getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<MenuItem> findByPrice(final BigDecimal price) {
        try {
            String jpql = "SELECT mi FROM MenuItem mi WHERE mi.price = :price";
            return this.entityManager.createQuery(jpql, MenuItem.class).setParameter("price", price).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    public MenuItem findById(final Long id) {
        return this.entityManager.find(MenuItem.class, id);
    }

    public List<MenuItem> findAll() {
        try {
            String jpql = "SELECT mi FROM MenuItem mi";
            return this.entityManager.createQuery(jpql, MenuItem.class).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    public void update(final MenuItem menuItem) {
        this.entityManager.merge(menuItem);
    }

    public void remove(final MenuItem menuItem) {
        this.entityManager.remove(menuItem);
    }
}
