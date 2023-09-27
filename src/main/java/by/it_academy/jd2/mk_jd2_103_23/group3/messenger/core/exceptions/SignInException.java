package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions;

public class SignInException extends Exception{
    public SignInException() {
        super();
    }

    public SignInException(String message) {
        super(message);
    }

    public SignInException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignInException(Throwable cause) {
        super(cause);
    }

    protected SignInException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
