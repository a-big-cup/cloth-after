package com.cloth.clothfrontweb.service;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.dao.DesignerDao;
import com.cloth.clothfrontweb.dao.MagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResearchService {
    @Autowired
    DesignerDao designerDao;
    @Autowired
    MagazineDao magazineDao;
//    12.搜索的总数（作为分页的页码）
    public String  getResearchSums(String research){
       return designerDao.getResearchSums(research);
    }
//    13.通过得到当前类型下的一页内容（每一页的内容）
    public List<DesignerList> getResearchPage(String size, String currentPage, String research){
        Integer start=Integer.parseInt(size)*(Integer.parseInt(currentPage)-1);
        List<DesignerList> list = new ArrayList<>();
        List<Designer> researchPage = designerDao.getResearchPage(Integer.parseInt(size), start, research);
        for (Designer designer:researchPage) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=new DesignerList(designer,hotOne);
            list.add(dl);
        }
        return list;
    }
}
