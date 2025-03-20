package models;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;

public abstract class Coupon {
    private String couponCode;
    private LocalDate expiryDate;
    private double minPurchaseAmount;

    public Coupon(String couponCode, LocalDate expiryDate, double minPurchaseAmount) {
        this.couponCode = couponCode;
        this.expiryDate = expiryDate;
        this.minPurchaseAmount = minPurchaseAmount;
    }


    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }


    public ChronoLocalDateTime<?> getExpiryDate() {
        return expiryDate.atStartOfDay();
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }


    @Override
    public String toString() {
        return "Coupon {" +
                "Code: " + this.couponCode + " " +
                "Expiry Date: " + this.expiryDate + " " +
                "}";
    }

    public abstract void apply(Cart cart);
}
