package by.bsu.domino.exception;

public class DominoGameException extends Exception {
    public DominoGameException() {
        super();
    }

    public DominoGameException(String message) {
        super(message);
    }

    public DominoGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DominoGameException(Throwable cause) {
        super(cause);
    }

    protected DominoGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
