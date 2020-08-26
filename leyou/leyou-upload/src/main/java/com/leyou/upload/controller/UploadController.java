package com.leyou.upload.controller;

import com.leyou.upload.serivce.UploadSerivce;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadSerivce uploadSerivce;

    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file)  {

        String url = this.uploadSerivce.uploadImage(file);
        if (StringUtils.isBlank(url)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}
