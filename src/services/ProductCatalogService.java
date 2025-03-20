package services;

import exceptions.ProductIdAlreadyPresentException;
import exceptions.ProductNotFoundException;
import models.Cart;
import models.CartItem;
import models.Product;
import repositories.IProductRepository;

import static repositories.InMemoryProductRepository.getInstanceOfProductRepository;

public class ProductCatalogService {
    private final IProductRepository productRepository;

    public ProductCatalogService() {
        this.productRepository = getInstanceOfProductRepository();
    }

    public void addProduct(Product product) throws ProductIdAlreadyPresentException {
        if(productRepository.getProductById(product.getId()) != null) {
            throw new ProductIdAlreadyPresentException();
        }
        System.out.println("Product " + product.getId() + " added successfully");
        productRepository.addProduct(product);
    }

    public void updateCatalog(Cart cart) throws ProductNotFoundException {

        for(CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            productRepository.updateProducts(product.getId(), quantity);
        }
    }

}
