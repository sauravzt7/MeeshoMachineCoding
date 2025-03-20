Entities : 

User, 
CartItem -> 
Product [stock, ]
Cart
Coupon


Repositories: 
CouponRepository
ProductRepository


Service classes: 
CouponManager
CouponValidator
ProductInventoryManager{CatalogService} [can use the product repository to do all the CRUD]


Exceptions
![img.png](img.png)




