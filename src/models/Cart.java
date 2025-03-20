package models;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private String id;
    private final List<CartItem> cartItems;
    private double totalCartPrice;

    public Cart(String id) {
        this.id = id;
        this.cartItems = new ArrayList<>();
        this.totalCartPrice = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        this.totalCartPrice += cartItem.getQuantity() * cartItem.getProduct().getPrice();
    }
    public void removeCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

    public double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    public double calculateCartTotal() {
        double total = 0;
        for(CartItem cartItem : cartItems) {
            total += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        return total;
    }



    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", cartItems=" + cartItems.toString() +
                ", totalCartPrice=" + totalCartPrice +
                '}';
    }
}
