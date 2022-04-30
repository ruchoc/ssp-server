package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/uoloadpic")
    public List<String> upload(@RequestParam(value = "pic")MultipartFile[] multipartFiles, @RequestParam(value = "shareId")long shareId){
        return fileService.uploadPicture(multipartFiles, shareId);
    }

    @RequestMapping(value = "/uoloadavatar")
    public boolean upload(@RequestParam(value = "avatar")MultipartFile multipartFile, @RequestParam(value = "userId")long userId){
        return fileService.uploadAvatar(multipartFile, userId);
    }
}
