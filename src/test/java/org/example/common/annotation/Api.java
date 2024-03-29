package org.example.common.annotation;

import org.example.common.extension.ApiExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(ApiExtension.class)
public @interface Api {
    String name();
    String isPrivate();
}
