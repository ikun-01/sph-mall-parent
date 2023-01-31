package com.jing.mall.product.service.impl;

import com.jing.mall.common.config.minio.properties.MinioProperties;
import com.jing.mall.common.util.DateUtil;
import com.jing.mall.product.service.FileUploadService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioProperties minioProperties;


    @Override
    public String upload(MultipartFile file) throws Exception {

        // 判断bucket是否存在
        boolean bucketExists = minioClient.bucketExists(minioProperties.getBucketName());

        if (bucketExists){
            log.warn("Bucket:{}已经存在,无需创建!",minioProperties.getBucketName());
        }else {
            // 创建桶
            minioClient.makeBucket(minioProperties.getBucketName());
            String bucketProxy = "{\n" +
                    "  \"Version\": \"2012-10-17\",\n" +
                    "  \"Statement\": [\n" +
                    "    {\n" +
                    "      \"Effect\": \"Allow\",\n" +
                    "      \"Principal\": {\n" +
                    "        \"AWS\": [\n" +
                    "          \"*\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"Action\": [\n" +
                    "        \"s3:GetBucketLocation\",\n" +
                    "        \"s3:ListBucket\",\n" +
                    "        \"s3:ListBucketMultipartUploads\"\n" +
                    "      ],\n" +
                    "      \"Resource\": [\n" +
                    "        \"arn:aws:s3:::gmall\"\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Effect\": \"Allow\",\n" +
                    "      \"Principal\": {\n" +
                    "        \"AWS\": [\n" +
                    "          \"*\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      \"Action\": [\n" +
                    "        \"s3:GetObject\",\n" +
                    "        \"s3:ListMultipartUploadParts\",\n" +
                    "        \"s3:PutObject\",\n" +
                    "        \"s3:AbortMultipartUpload\",\n" +
                    "        \"s3:DeleteObject\"\n" +
                    "      ],\n" +
                    "      \"Resource\": [\n" +
                    "        \"arn:aws:s3:::gmall/*\"\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            minioClient.setBucketPolicy(minioProperties.getBucketName(),bucketProxy);
        }
        // 获取日期
        String date = DateUtil.formatDate(new Date(),"yyyy-MM-dd");
        // 创建文件名称
        String objectName = date + "/" + UUID.randomUUID().toString().replace("-","") + "_" + file.getOriginalFilename();
        PutObjectOptions options = new PutObjectOptions(file.getInputStream().available(), -1);
        options.setContentType(file.getContentType());
        minioClient.putObject(minioProperties.getBucketName(), objectName, file.getInputStream(), options);
        return minioProperties.getEndpoint() + "/" + minioProperties.getBucketName() + "/" + objectName;
    }
}
