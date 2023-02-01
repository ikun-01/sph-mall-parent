package com.jing.mall.common.config.swagger;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(Swagger2Config.class)
public @interface EnableSwagger {
}
