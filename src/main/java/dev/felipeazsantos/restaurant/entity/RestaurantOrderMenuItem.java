package dev.felipeazsantos.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurant_order_menu_item")
public class RestaurantOrderMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantOrder restaurantOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    private BigDecimal price;

    private Long quantity;

    public RestaurantOrderMenuItem() {
    }

    public RestaurantOrderMenuItem(MenuItem menuItem, Long quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = this.menuItem.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantOrder getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(RestaurantOrder restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RestaurantOrderMenuItem{" +
                "id=" + id +
                ", menuItem=" + menuItem +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
