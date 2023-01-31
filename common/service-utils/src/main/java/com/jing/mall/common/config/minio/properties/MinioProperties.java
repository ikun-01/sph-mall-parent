package com.jing.mall.common.config.minio.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "gmall.minio")
public class MinioProperties {
    /**
     * minio 的地址
     */
    private String endpoint;

    /**
     * 用户账号
     */
    private String accessKey;

    /**
     * 用户密码
     */
    private String secretKey;

    /**
     * 桶的名称
     */
    private String bucketName;


}
