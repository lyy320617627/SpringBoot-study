package com.lyy.admin.controller;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-26 10:48
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 测试文件上传
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile:会自动封装上传来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username")String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={}，username={},headImg={},photos={}",email
        ,username,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()){
            String filename = headerImg.getOriginalFilename();


            headerImg.transferTo(new File("D:\\"+filename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if (photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\"+filename));
                }

            }
        }
        return "main";
    }
}
