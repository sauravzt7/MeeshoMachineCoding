package repositories;

import models.Cart;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCartRepository implements ICartRepository {
    private Map<String, Cart> carts;

    public InMemoryCartRepository() {
        this.carts = new HashMap<>();
    }

    //crud operations

    @Override
    public void addToCart(Cart cart) {
        carts.put(cart.getId(), cart);
    }

    @Override
    public void removeFromCart(Cart cart) {
        carts.remove(cart.getId());
    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public Cart getCartForId(String id) {
        if (carts.containsKey(id)) {
            return carts.get(id);
        }
        return null;
    }

    public Map<String, Cart> getCarts() {
        return carts;
    }

}
