package qg.fangrui.boot.exception;

/**
 * Created by zggdczfr on 2017/1/26.
 */
public class FormRepeatException extends RuntimeException {

    public FormRepeatException(String message){ super(message);}

    public FormRepeatException(String message, Throwable cause){ super(message, cause);}
}
