package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureMapper {
    public Picture getPicture(String URL);

    public boolean insertPicture(String URL, long shareId);

    public boolean deletePicture(long id);
}
