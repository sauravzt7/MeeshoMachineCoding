package exceptions;

public class ProductIdAlreadyPresentException extends Exception {

    public Exception ProductIdAlreadyPresentException() throws Exception{
        throw new Error("Product Id already exists");
    }
}
