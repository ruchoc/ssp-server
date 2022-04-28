package edu.scau.pyx.ssp.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public boolean uploadPicture(MultipartFile multipartFile, long shareId);
}
