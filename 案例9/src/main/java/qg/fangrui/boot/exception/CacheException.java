package qg.fangrui.boot.exception;

/**
 * Created by zggdczfr on 2017/2/10.
 */
public class CacheException extends RuntimeException {

    public CacheException(String message){ super(message);}

    public CacheException(String message, Throwable cause){ super(message, cause);}
}
