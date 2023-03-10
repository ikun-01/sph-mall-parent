package com.jing.mall.product.controller;

import com.jing.mall.common.result.Result;
import com.jing.mall.product.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/product")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        String url = fileUploadService.upload(file);
        return Result.ok(url);
    }
}
