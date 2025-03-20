package models;

import enums.CouponType;

import java.time.LocalDate;

public class PercentageCoupon extends Coupon {

    private double percentage;
    private double maxApplicableAmount;
    private CouponType couponType;

    public PercentageCoupon(String couponCode, double percentage, double maxApplicableAmount, double minPurchaseAmount, LocalDate expiryDate) {
        super(couponCode, expiryDate, minPurchaseAmount);
        this.percentage = percentage;
        this.maxApplicableAmount = maxApplicableAmount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }



    @Override
    public String toString() {
        return "PercentageCoupon{" +
                "" + super.toString() +
                "percentage=" + percentage +
                '}';
    }

    @Override
    public void apply(Cart cart) {
        double totalCartPrice = cart.getTotalCartPrice();
        double discountPrice = Math.min(this.maxApplicableAmount, totalCartPrice * percentage);
        System.out.println("DiscountPrice: " + discountPrice);
        cart.setTotalCartPrice(totalCartPrice - Math.min(this.maxApplicableAmount, totalCartPrice * percentage));
    }
}
