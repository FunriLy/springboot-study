package qg.fangrui.springboot.exception;

/**
 * Created by zggdczfr on 2017/3/1.
 */
public class CacheException extends RuntimeException {

    public CacheException(String message){ super(message);}

    public CacheException(String message, Throwable cause){ super(message, cause);}
}