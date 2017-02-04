package qg.fangrui.boot.aop;

import java.lang.annotation.*;

/**
 * Token注解类
 * 要求方法中一定要有参数 HttpServletRequest 与 HttpServletResponse
 * Created by zggdczfr on 2017/1/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Token {
    boolean save() default false ;

    boolean remove() default false ;
}