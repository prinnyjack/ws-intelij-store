package model.exceptions;

public class InsertProductException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public InsertProductException (String msg) {
        super(msg);
    }
}
