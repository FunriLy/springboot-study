package qg.fangrui.boot.exception;

/**
 * Created by zggdczfr on 2017/1/26.
 */
public class RequestLimitException extends Exception {
    private static final long serialVersionUID = 1364225358754654702L;

    public RequestLimitException() {
        super("HTTP请求超出设定的限制");
    }

    public RequestLimitException(String message) {
        super(message);
    }

    public RequestLimitException(String message, Throwable cause){
        super(message, cause);
    }
}