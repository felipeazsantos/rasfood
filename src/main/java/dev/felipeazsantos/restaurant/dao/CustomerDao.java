package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.Customer;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class CustomerDao {

    private final EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final Customer customer) {
        this.entityManager.persist(customer);
    }

    public Customer findById(final Long id) {
        try {
            return this.entityManager.find(Customer.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<Customer> findAll() {
        try {
            String jpql = "SELECT c FROM customer c";
            return this.entityManager.createQuery(jpql, Customer.class).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    public void update(final Customer customer) {
        this.entityManager.merge(customer);
    }

    public void remove(final Customer customer) {
        this.entityManager.remove(customer);
    }
}
