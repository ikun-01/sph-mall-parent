package com.jing.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

///*@SpringBootApplication // spring boot项目
//@EnableDiscoveryClient // 开启服务注册与发现
//@EnableCircuitBreaker // 开启链路追踪*/
@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
