package repositories;

import models.Cart;

public interface ICartRepository {

    void addToCart(Cart cart);
    void removeFromCart(Cart cart);
    void updateCart(Cart cart);
    Cart getCartForId(String id);

}
