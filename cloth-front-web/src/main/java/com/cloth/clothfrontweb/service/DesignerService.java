package com.cloth.clothfrontweb.service;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.dao.DesignerDao;
import com.cloth.clothfrontweb.dao.MagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DesignerService {
    @Autowired
    DesignerDao designerDao;
    @Autowired
    MagazineDao magazineDao;
    //热点推荐
    public List<DesignerList> getHot(){
        List<DesignerList> list = new ArrayList<>();
        List<Designer> hot = designerDao.getHot();
        for (Designer designer:hot) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=null;
            if(hotOne!=null)
                dl=new DesignerList(designer,hotOne);
            else
                continue;
            list.add(dl);
        }
        return  list;
    }
    //热点advise
    public List<DesignerList>  getHotAdvise(String type){
        List<DesignerList> list = new ArrayList<>();
        List<Designer> hot = designerDao.getHotAdvise(type);
        for (Designer designer:hot) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=new DesignerList(designer,hotOne);
            list.add(dl);
        }
        return  list;
    }
    //热点设计师和新闻
    public List<DesignerList>  getHotDeAndNe(String type1,String type2){
        List<DesignerList> list = new ArrayList<>();
        Designer one = designerDao.getHotOne(type1);
        Magazine nearestOne = magazineDao.getNearestOne(one.getId());
        DesignerList dl=new DesignerList(one,nearestOne);
        Designer two = designerDao.getHotOne(type2);
        Magazine nearestTwo = magazineDao.getNearestOne(two.getId());
        DesignerList dl2=new DesignerList(two,nearestTwo);
        list.add(dl);
        list.add(dl2);
        return list;
    }
    //最近学校毕业秀
    public List<DesignerList> getGraduationShow(String type){
        List<DesignerList> list = new ArrayList<>();
        List<Designer> showearest = designerDao.getGraduationShowearest(type);
        for (Designer designer:showearest) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=new DesignerList(designer,hotOne);
            list.add(dl);
        }
        return  list;
    }
//通过类型查询该类型的总数
    public String getTypeSums(String type) {
        return "" + designerDao.getTypeSums(type);
    }
//通过得到当前类型下的一页内容（每一页的内容）
    public List<DesignerList> getTypePage(String size, String currentPage, String type) {
        Integer start=Integer.parseInt(size)*(Integer.parseInt(currentPage)-1);
        List<DesignerList> list = new ArrayList<>();
        List<Designer> typePages = designerDao.getTypePage(Integer.parseInt(size), start, type);
        for (Designer designer:typePages) {
            Magazine hotOne = magazineDao.getNearestOne(designer.getId());
            DesignerList dl=new DesignerList(designer,hotOne);
            list.add(dl);
        }
        return list;
    }
//跑马灯推荐（主页）
    public List<DesignerList> getCarousel(String type,Integer num) {
        List<DesignerList> list = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        for (int i=0;i<num;){
            Designer designer = designerDao.getCarouselOne();
            if(ids.add(designer.getId())){//id不重复
                Magazine hotOne = magazineDao.getNearestOne(designer.getId());
                DesignerList dl=new DesignerList(designer,hotOne);
                list.add(dl);
                i++;
            }
        }
        return list;
    }
}
