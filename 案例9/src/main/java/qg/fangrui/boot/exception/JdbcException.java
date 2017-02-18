package qg.fangrui.boot.exception;

/**
 * Created by zggdczfr on 2017/2/18.
 */
public class JdbcException extends RuntimeException {

    public JdbcException(String message){ super(message);}

    public JdbcException(String message, Throwable cause){ super(message, cause);}
}
