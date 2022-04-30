package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Collect;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CollectService {
    public boolean add(Collect collect);

    public List<Collect> getCollectList(long userId);
}
