package com.cloth.clothfrontweb.service;


import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Expriences;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.commonmodel.domain.response.ExpriencesList;
import com.cloth.clothfrontweb.dao.DesignerDao;
import com.cloth.clothfrontweb.dao.ExpriencesDao;
import com.cloth.clothfrontweb.dao.MagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExpriencesService {
    @Autowired
    ExpriencesDao expriencesDao;
    @Autowired
    MagazineDao magazineDao;
    @Autowired
    DesignerDao designerDao;
    //   最热励志经历人物
    public List<DesignerList> getInspire(String inspire){
        List<DesignerList> list=new ArrayList<>();
        List<Expriences> ins = expriencesDao.getInspire(inspire);
        for (Expriences exp : ins) {
            Designer designer = exp.getDesigner();
            Magazine nearestOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl = new DesignerList(designer, nearestOne);
            list.add(dl);
        }
        return  list;
    }
    //    通过designerid获取经历
    public List<ExpriencesList> getExpriences(String designerId){
        List<ExpriencesList> list = new ArrayList<>();
        List<Expriences> expList = expriencesDao.findByDesignerId(designerId);
        for (Expriences ex:expList){
            Designer designer = ex.getDesigner();
            ExpriencesList e=new ExpriencesList(designer,ex);
            list.add(e);
        }
        return list;
    }
//跑马灯推荐（个人经历）
    public List<DesignerList> getCarousel(String type,String id) {
        List<DesignerList> list=new ArrayList<>();
        List<Designer> carousel = designerDao.getCarousel(type, id);
        for (Designer designer : carousel) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=new DesignerList(designer,hotOne);
            list.add(dl);
        }
        return list;
    }
}
