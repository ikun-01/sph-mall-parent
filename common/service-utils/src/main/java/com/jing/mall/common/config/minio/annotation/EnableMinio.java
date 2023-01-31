package com.jing.mall.common.config.minio.annotation;

import com.jing.mall.common.config.minio.MinioAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MinioAutoConfiguration.class)
public @interface EnableMinio {
}
