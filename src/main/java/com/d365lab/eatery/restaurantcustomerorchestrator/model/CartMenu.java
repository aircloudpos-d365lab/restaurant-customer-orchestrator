package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;
import java.util.List;

public class CartMenu implements Serializable {
    private List<Item> cartMenuList;

    public CartMenu() {
    }

    public CartMenu(List<Item> cartMenuList) {
        this.cartMenuList = cartMenuList;
    }

    public List<Item> getCartMenuList() {
        return cartMenuList;
    }

    public void setCartMenuList(List<Item> cartMenuList) {
        this.cartMenuList = cartMenuList;
    }
}
