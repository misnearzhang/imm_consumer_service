package com.misnearzhang.grpc.config.annotation;

import io.grpc.ClientInterceptor;

import java.lang.annotation.*;

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface GRpcClient
{
    String value() default "localhost";

    Class<? extends ClientInterceptor>[] interceptors() default {};
}
