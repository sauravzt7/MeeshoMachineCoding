package exceptions;

public class InvalidQuanitityException extends Exception {

    public Exception InvalidQuanitityException() throws Exception {
        throw new Exception("Quantity not valid");
    }
}
