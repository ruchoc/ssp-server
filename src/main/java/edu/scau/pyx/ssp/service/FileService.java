package edu.scau.pyx.ssp.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public List<String> uploadPicture(MultipartFile[] multipartFiles, long shareId);
}
