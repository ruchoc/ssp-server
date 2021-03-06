package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Picture;

public interface PictureService {
    public Picture getPicture(String URL);

    public boolean uploadPicture(String URL, long shareId);

    public boolean deletePicture(long id);
}
