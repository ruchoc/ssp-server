package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileService fileService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = "/uoloadpic")
    public List<String> uploadPicture(@RequestParam(value = "pic")MultipartFile[] multipartFiles, @RequestParam(value = "shareId")long shareId){
        return fileService.uploadPicture(multipartFiles, shareId);
    }

    @RequestMapping(value = "/uoloadavatar")
    public boolean uploadAvatar(@RequestParam(value = "avatar")MultipartFile multipartFile, @RequestParam(value = "userId")long userId){
        return fileService.uploadAvatar(multipartFile, userId);
    }

    @RequestMapping("/get")
    public ResponseEntity<Resource> get(String url) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + System.getProperty("user.dir") + "/" + url));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
