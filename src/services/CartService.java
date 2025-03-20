package services;

import models.Cart;
import models.CartItem;
import models.Product;
import repositories.ICartRepository;
import repositories.InMemoryCartRepository;

import java.util.HashMap;
import java.util.Map;

public class CartService {

    private final ICartRepository cartRepository;

    public CartService() {
        this.cartRepository = new InMemoryCartRepository();
    }

    public void addProductToCart(Cart cart, Product product, int quantity) {
        System.out.println("Products added to the cart");
        CartItem item = new CartItem(product, quantity);
        cart.addCartItem(item);
    }

    public void removeProductFromCart(Cart cart, String productId) {

    }

    public Cart getOrCreate(String cartId) {
        Cart cart = null;
        if (cartRepository.getCartForId(cartId) == null) {
            cartRepository.addToCart(new Cart(cartId));
            return new Cart(cartId);
        }
        cart = cartRepository.getCartForId(cartId);
        return cart;
    }

    public void displayCart(Cart cart) {
        System.out.println(cart.toString());
    }

}
