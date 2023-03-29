package io.github.returntmp.titanms.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * 操作类
 *
 * @author CGH
 * @date 2023/03/29
 */
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operation {
    String value() default "";
}
