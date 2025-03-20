package exceptions;

public class InvalidCouponException extends Exception {

    public Exception InvalidCouponException(String message) throws Exception {
        throw new Exception(message);
    }
}
