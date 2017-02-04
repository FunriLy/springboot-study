package qg.fangrui.boot.exception;

/**
 * Created by zggdczfr on 2017/1/30.
 */
public class HttpServletException extends RuntimeException {

    public HttpServletException(String message){
        super(message);
    }

    public HttpServletException(String message, Throwable cause){
        super(message, cause);
    }
}
