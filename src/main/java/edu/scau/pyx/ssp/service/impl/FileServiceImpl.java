package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.service.FileService;
import edu.scau.pyx.ssp.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private PictureService pictureService;

    private static final String picturePath = "/picture";
    private static final int pictureRandomFileNameLength = 5;
    @Override
    public List<String> uploadPicture(MultipartFile[] multipartFiles, long shareId) {
        List<String> messages = new ArrayList<String>();
        for(MultipartFile file : multipartFiles){
            if(!file.isEmpty()){
                String orgName = file.getOriginalFilename();
                String suffix = orgName.substring(orgName.lastIndexOf('.'));
                String randomFileName = UUID.randomUUID().toString().toUpperCase()+suffix;
                String randomURL = picturePath+randomFileName;
                try{
                    file.transferTo(new File(picturePath,randomFileName));
                    pictureService.uploadPicture(randomURL, shareId);
                    messages.add(orgName+"上传成功");
                } catch (IllegalStateException | IOException e){
                    e.printStackTrace();
                    messages.add(orgName + "上传失败" + e.getMessage());
                }
            }
        }
        return messages;
    }
}
