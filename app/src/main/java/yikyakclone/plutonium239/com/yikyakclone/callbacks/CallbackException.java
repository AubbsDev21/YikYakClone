package yikyakclone.plutonium239.com.yikyakclone.callbacks;

/**
 * Created by alexander on 6/17/2015.
 */
public class CallbackException extends Exception {

    public CallbackException() {
    }

    public CallbackException(String detailMessage) {
        super(detailMessage);
    }

    public CallbackException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CallbackException(Throwable throwable) {
        super(throwable);
    }
}
