package services;

import exceptions.InvalidCouponException;
import exceptions.ProductNotFoundException;
import models.*;

public class CheckOutService {

    private final ProductCatalogService productCatalogService;

    public CheckOutService(ProductCatalogService productCatalogService, CouponService couponService) {
        this.productCatalogService = productCatalogService;
    }

    public Order checkOut(User user, Cart cart) throws InvalidCouponException, ProductNotFoundException {

        //validate order [check the available quantity v/s what cart order quantity for each product]
        //upon successful payment and other processes

        productCatalogService.updateCatalog(cart);
        return null;
    }
}
