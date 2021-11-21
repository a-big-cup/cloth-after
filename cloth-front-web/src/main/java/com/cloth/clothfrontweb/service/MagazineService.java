package com.cloth.clothfrontweb.service;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.dao.MagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service
public class MagazineService {
    @Autowired
    MagazineDao magazineDao;

    //最新期刊人物
    public List<DesignerList> getNearest(){
        List<DesignerList> list=new ArrayList<>();
        Magazine nearest = magazineDao.getNearest();
        Set<Designer> designers = nearest.getDesigners();
        Iterator<Designer> iterator = designers.iterator();
        while (iterator.hasNext()) {
            DesignerList dl = new DesignerList(iterator.next(),nearest);
            list.add(dl);
        }
        return list;
    }
}
