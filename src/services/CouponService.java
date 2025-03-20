package services;

import exceptions.InvalidCouponException;
import models.Cart;
import models.Coupon;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CouponService {
    private final Map<String, Coupon> coupons; // couponCode -> Coupon


    public CouponService() {
        coupons = new HashMap<>();
    }

    public void createCoupon(Coupon coupon) {
        //TODO: add error handling
        System.out.println("Coupon " + coupon.getCouponCode() + " created Successfully");
        coupons.put(coupon.getCouponCode(), coupon);
    }

    public Coupon getCoupon(String couponCode) throws InvalidCouponException {
        if(!coupons.containsKey(couponCode)) {
            throw new InvalidCouponException();
        }
        return coupons.get(couponCode);
    }

    public boolean validateCoupon(Coupon coupon) throws InvalidCouponException {
        if(!coupons.containsKey(coupon.getCouponCode())) {
            System.out.println("coupon not found");
            throw new InvalidCouponException();
        }
        if(LocalDateTime.now().isAfter(coupon.getExpiryDate())){
            System.out.println("Expired Coupon");
            throw new InvalidCouponException();
        }
        return true;
    }

    public void applyCouponToCart(Cart cart, Coupon coupon1) throws InvalidCouponException {

        if(validateCoupon(coupon1)) {
            coupon1.apply(cart);
            return;
        }
        throw new InvalidCouponException();
    }
}
