package repositories;

import exceptions.ProductNotFoundException;
import models.Product;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductRepository implements IProductRepository {

    private static InMemoryProductRepository instance;
    private Map<String, Product> products;

    private InMemoryProductRepository() {
        this.products = new HashMap<>();
    }

    public static IProductRepository getInstanceOfProductRepository() {
        if(instance == null){
            instance = new InMemoryProductRepository();
        }
        return instance;
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("Adding product: " + product.getName());
        products.put(product.getId(), product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product.getId());
    }

    @Override
    public void updateProducts(String productId, int consumedQuantity) throws ProductNotFoundException {
        Product product = this.products.get(productId);
        if(product == null){
            throw new ProductNotFoundException();
        }
        product.setQuantity(product.getQuantity() - consumedQuantity);
        this.products.put(productId, product); // update the key with new product not necessary though
    }

    @Override
    public Product getProductById(String id) {
        if(products.containsKey(id)) {
            return products.get(id);
        }
        return null;
    }


    public void displayAllProducts() {
        System.out.println("All products: ");
        for(Map.Entry<String, Product> entry : this.products.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + " Quantity: " + entry.getValue().getQuantity());
        }
    }

}
