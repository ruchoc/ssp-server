package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/uoloadpic")
    public boolean upload(@RequestParam(value = "pic")MultipartFile multipartFile, @RequestParam(value = "shareId")long shareId){
        return fileService.uploadPicture(multipartFile, shareId);
    }
}
