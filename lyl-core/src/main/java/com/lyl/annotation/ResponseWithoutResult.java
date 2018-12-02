package com.lyl.annotation;

import java.lang.annotation.*;

/**
 * Created by lyl on 2016/9/11.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseWithoutResult {
}
