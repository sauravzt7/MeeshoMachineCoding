import exceptions.InvalidCouponException;
import exceptions.ProductIdAlreadyPresentException;
import exceptions.ProductNotFoundException;
import models.*;
import repositories.InMemoryProductRepository;
import services.CartService;
import services.ProductCatalogService;
import services.CheckOutService;
import services.CouponService;

public static void main(String[] args) throws ProductIdAlreadyPresentException, InvalidCouponException, ProductNotFoundException {

    ProductCatalogService productCatalogService = new ProductCatalogService();
    CouponService couponService = new CouponService();
    CartService cartService = new CartService();

    CheckOutService checkOutService = new CheckOutService(productCatalogService, couponService);

    //create Products
    Product product1 = new Product("P1", "TShirt", 1000, 50);
    Product product2 = new Product("P2", "Jeans", 2000, 30);

    productCatalogService.addProduct(product1);
    productCatalogService.addProduct(product2);
    //create Coupons

    InMemoryProductRepository instance = (InMemoryProductRepository) InMemoryProductRepository.getInstanceOfProductRepository();
    instance.displayAllProducts();
    Coupon coupon1 = new FlatCoupon("FLAT200", 200, 1000, LocalDate.now().plusDays(20));
    Coupon coupon2 = new PercentageCoupon("SUMMER30", 30, 500, 1500, LocalDate.now().plusDays(20));

    couponService.createCoupon(coupon1);
    couponService.createCoupon(coupon2);

    //Create User
    User user = new User("userId1", "saurav");
    //Create Cart
    Cart cart = cartService.getOrCreate("1234");

    //ADD_TO_CART CART1 P1 2
    cartService.addProductToCart(cart, product1, 2);
    //ADD_TO_CART CART1 P2 1
    cartService.addProductToCart(cart, product2, 1);
    System.out.println("Original Amount: " + cart.getTotalCartPrice());
//    cartService.displayCart(cart);

    //APPLY_COUPON CART1 SUMMER30
    couponService.applyCouponToCart(cart, coupon1);

//    couponService.applyCouponToCart(cart, coupon2);

    System.out.println("Final Amount: " + cart.getTotalCartPrice());

    cartService.displayCart(cart);
    //COMPLETE_PURCHASE CART1
    checkOutService.checkOut(user, cart);
    System.out.println("Order placed successfully");


    instance.displayAllProducts();



}