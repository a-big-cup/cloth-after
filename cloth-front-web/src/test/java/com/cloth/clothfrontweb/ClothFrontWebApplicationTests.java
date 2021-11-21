package com.cloth.clothfrontweb;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Expriences;
import com.cloth.clothfrontweb.service.DesignerService;
import com.cloth.clothfrontweb.service.ExpriencesService;
import com.cloth.clothfrontweb.service.MagazineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ClothFrontWebApplicationTests {

    @Autowired
    DesignerService designerService;
    @Autowired
    ExpriencesService expriencesService;
    @Autowired
    MagazineService magazineService;
    @Test
    void contextLoads() {
//        List<DesignerList> hot = designerService.getHot();
//        List<Designer> inspire = expriencesService.getInspire("1");
//        List<Designer> nearest = magazineService.getNearest();
//        System.out.println("\n"+hot.toString()+"\n"+inspire.toString()+"\n"+nearest.toString());
//        List<Expriences> expriences = expriencesService.getExpriences("2");
//        for (Expriences expriences1:expriences){
//            System.out.println(expriences1.getText());
//        }
    }

}
