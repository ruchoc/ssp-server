package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.service.FileService;
import edu.scau.pyx.ssp.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private PictureService pictureService;

    private static final String picturePath = "/picture";
    private static final int pictureRandomFileNameLength = 5;
    @Override
    public boolean uploadPicture(MultipartFile multipartFile, long shareId) {
        try{
            //获取随机文件名且判重
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.'));
            String randomFileName = getRandomString(pictureRandomFileNameLength)+suffix;
            String randomURL = picturePath+randomFileName;
            while(pictureService.getPicture(randomURL)!=null){
                randomFileName = getRandomString(pictureRandomFileNameLength)+suffix;
                randomURL = picturePath+randomFileName;
            }

            File file = new File(randomURL);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
