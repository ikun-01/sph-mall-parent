package com.jing.mall.common.config.minio;

import com.jing.mall.common.config.minio.properties.MinioProperties;
import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {
    @Bean
    public MinioClient minioClient(MinioProperties minioProperties) throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minioProperties.getEndpoint(),
                minioProperties.getAccessKey(),
                minioProperties.getSecretKey());
    }
}
