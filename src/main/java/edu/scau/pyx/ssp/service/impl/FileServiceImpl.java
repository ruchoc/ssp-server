package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.service.FileService;
import edu.scau.pyx.ssp.service.PictureService;
import edu.scau.pyx.ssp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserInfoService userInfoService;

    private static final String picturePath = "/resource/picture/";
    private static final String avatarPath = "/resource/avatar/";
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
                    File newFile = new File(System.getProperty("user.dir")+picturePath,randomFileName);
                    if (!newFile.getParentFile().exists()) {
                        newFile.getParentFile().mkdirs();
                    }
                    file.transferTo(newFile);
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

    @Override
    public boolean uploadAvatar(MultipartFile multipartFile, long userId) {
        boolean result = false;
        if(!multipartFile.isEmpty()){
            String orgName = multipartFile.getOriginalFilename();
            String suffix = orgName.substring(orgName.lastIndexOf('.'));
            String randomFileName = UUID.randomUUID().toString().toUpperCase()+suffix;
            String randomURL = avatarPath+randomFileName;
            try{
                File newFile = new File(System.getProperty("user.dir")+avatarPath,randomFileName);
                if (!newFile.getParentFile().exists()) {
                    newFile.getParentFile().mkdirs();
                }
                multipartFile.transferTo(newFile);
                userInfoService.uploadAvatar(randomURL, userId);
                result = true;
            } catch (IllegalStateException | IOException e){
                e.printStackTrace();
                result = false;
            }
        }
        return result;
    }
}
