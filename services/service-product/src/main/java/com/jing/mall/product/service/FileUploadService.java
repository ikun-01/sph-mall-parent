package com.jing.mall.product.service;

import org.springframework.web.multipart.MultipartFile;



public interface FileUploadService {
    /**
     * 文件上传服务
     *
     * @param file
     * @return
     */
    String upload(MultipartFile file) throws Exception;
}
