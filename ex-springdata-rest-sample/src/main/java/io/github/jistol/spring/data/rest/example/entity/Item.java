package io.github.jistol.spring.data.rest.example.entity;

import javax.persistence.*;

/**
 * Created by kimjh on 2017-03-24.
 */
@Entity
public class Item
{
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
