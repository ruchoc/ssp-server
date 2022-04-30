package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Picture;
import edu.scau.pyx.ssp.mapper.PictureMapper;
import edu.scau.pyx.ssp.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;

    @Override
    public Picture getPicture(String URL) {
        return pictureMapper.getPicture(URL);
    }

    @Override
    public boolean uploadPicture(String URL, long shareId) {
        return pictureMapper.insertPicture(URL, shareId);
    }
}
