package com.base.test.controller;

import cn.hutool.core.io.resource.FileResource;
import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.core.io.resource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author yhc
 * @create 2023-03-02 10:57
 */
@RestController
@RequestMapping(value = "user", produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    public HttpServletResponse httpServletResponse;

    /**
     * 返回图片
     */
    @PostMapping("getImg.do")
    public ResponseEntity<Resource> getImg() throws IOException {
        // 文件路径，可以改成你要返回的文件路径
        File file = new File("C:/Users/admin/Pictures/图片1.png");
        // 创建文件输入流
        InputStream inputStream = Files.newInputStream(file.toPath());
        // 创建字节数组输入流（你也可以直接使用 FileInputStream，这里为了演示用 ByteArrayInputStream）
        InputStreamResource resource = new InputStreamResource(inputStream);
        // 创建一个示例图片
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

}