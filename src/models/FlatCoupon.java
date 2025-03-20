package models;

import enums.CouponType;

import java.time.LocalDate;

public class FlatCoupon extends Coupon {

    private double couponAmount;
    private CouponType couponType;

    public FlatCoupon(String couponCode, double flatAmount, double minPurchaseAmount, LocalDate expiryDate) {
        super(couponCode, expiryDate, minPurchaseAmount);
        this.couponAmount = flatAmount;
        this.couponType = CouponType.FLAT;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    @Override
    public void apply(Cart cart){
        cart.setTotalCartPrice(cart.getTotalCartPrice() - couponAmount);
    }

    @Override
    public String toString() {
        return "FlatCoupon{" +
                "" + super.toString() +
                "couponAmount=" + couponAmount +
                '}';
    }
}
