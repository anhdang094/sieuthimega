package vn.smart.web.infrastructure.exception;

public class SystemException extends Exception {

    private static final long serialVersionUID = 1L;

    public SystemException(String s) {
        super(s);
    }

    public SystemException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SystemException(Throwable throwable) {
        super(throwable);
    }

}
