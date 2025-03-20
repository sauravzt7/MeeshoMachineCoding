package repositories;

import exceptions.ProductNotFoundException;
import models.Product;

public interface IProductRepository {

    void addProduct(Product product);
    void removeProduct(Product product);
    Product getProductById(String id);
    void updateProducts(String productId, int consumedQuantity) throws ProductNotFoundException;
}
