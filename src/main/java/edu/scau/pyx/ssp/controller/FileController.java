package edu.scau.pyx.ssp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @RequestMapping(value = "/uoloadpic")
    public booleam upload(@RequestParam(value = "pic")MultipartFile multipartFile, @RequestParam(value = "shareId")long shareId){

    }
}
