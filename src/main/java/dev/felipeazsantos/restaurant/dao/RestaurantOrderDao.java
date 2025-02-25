package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.RestaurantOrder;
import dev.felipeazsantos.restaurant.vo.BestSellingItemsVo;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class RestaurantOrderDao {

    private final EntityManager entityManager;

    public RestaurantOrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final RestaurantOrder restaurantOrder) {
        this.entityManager.persist(restaurantOrder);
    }

    public RestaurantOrder findById(final Long id) {
        try {
            return this.entityManager.find(RestaurantOrder.class, id);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<RestaurantOrder> findAll() {
        try {
            String jpql = "SELECT ro FROM RestaurantOrder ro";
            return this.entityManager.createQuery(jpql, RestaurantOrder.class).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    public List<BestSellingItemsVo> findBestSellingItems() {
        try {
            String jpql = "SELECT new dev.felipeazsantos.restaurant.vo.BestSellingItemsVo(mi.name, SUM(romi.quantity)) FROM RestaurantOrder ro " +
                    "JOIN RestaurantOrderMenuItem romi on ro.id = romi.restaurantOrder.id " +
                    "JOIN romi.menuItem mi " +
                    "GROUP BY mi.name " +
                    "ORDER BY SUM(romi.quantity) DESC";
            return this.entityManager.createQuery(jpql, BestSellingItemsVo.class).getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    public RestaurantOrder joinFetchCustomer(final Long id) {
        String jpql = "SELECT ro FROM RestaurantOrder ro JOIN FETCH ro.customer WHERE ro.id = :id";
        return this.entityManager.createQuery(jpql, RestaurantOrder.class).setParameter("id", id).getSingleResult();
    }

    public void update(final RestaurantOrder restaurantOrder) {
        this.entityManager.merge(restaurantOrder);
    }

    public void remove(final RestaurantOrder restaurantOrder) {
        this.entityManager.remove(restaurantOrder);
    }
}
