package dev.felipeazsantos.restaurant.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant_order")
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal total;

    @CreationTimestamp
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "restaurantOrder", cascade = CascadeType.ALL)
    private List<RestaurantOrderMenuItem> restaurantOrderMenuItemList = new ArrayList<>();

    public RestaurantOrder() {
    }

    public RestaurantOrder(Customer customer) {
        this.customer = customer;
    }

    public void addRestaurantOrderMenuItem(RestaurantOrderMenuItem restaurantOrderMenuItem) {
        restaurantOrderMenuItem.setRestaurantOrder(this);
        this.restaurantOrderMenuItemList.add(restaurantOrderMenuItem);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<RestaurantOrderMenuItem> getRestaurantOrderMenuItemList() {
        return restaurantOrderMenuItemList;
    }

    public void setRestaurantOrderMenuItemList(List<RestaurantOrderMenuItem> restaurantOrderMenuItemList) {
        this.restaurantOrderMenuItemList = restaurantOrderMenuItemList;
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "id=" + id +
                ", total=" + total +
                ", creationDate=" + creationDate +
                ", customer=" + customer +
                ", restaurantOrderMenuItemList=" + restaurantOrderMenuItemList +
                '}';
    }
}
