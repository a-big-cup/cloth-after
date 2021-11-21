package com.cloth.clothfrontweb.controller;

import com.cloth.clothfrontweb.common.entity.Result;
import com.cloth.clothfrontweb.common.entity.ResultCode;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/designer")
public class DesignerController {
    @Autowired
    DesignerService designerService;
    //热点推荐
    @RequestMapping(value = "/recommend/getHot",method = RequestMethod.GET)
    public Result getHot(){
        List<DesignerList> hot = designerService.getHot();
        return new Result(ResultCode.SUCCESS,hot);
    }
    //2.热点advise
    @RequestMapping(value = "/hot/getHotAdvise",method = RequestMethod.GET)
    public Result getHotAdvise(@RequestParam(name = "type") String type){
        List<DesignerList> advise = designerService.getHotAdvise(type);
        return new Result(ResultCode.SUCCESS,advise);
    }
//    3.热点设计师和新闻
    @RequestMapping(value = "/hot/getHotDeAndNe",method = RequestMethod.GET)
    public Result getHotDeAndNe(@RequestParam(name = "type1") String type1,@RequestParam(name = "type2") String type2){
        List<DesignerList> hotDeAndNe = designerService.getHotDeAndNe(type1, type2);
        return new Result(ResultCode.SUCCESS,hotDeAndNe);
    }
    //    6.最近学校毕业秀
    @RequestMapping(value = "/hot/getGraduationShow",method = RequestMethod.GET)
    public Result getGraduationShow(@RequestParam(name = "type") String type){
        List<DesignerList> advise = designerService.getHotAdvise(type);
        return new Result(ResultCode.SUCCESS,advise);
    }
//    8.通过类型查询该类型的总数（作为分页的页码）
    @RequestMapping(value = "/getTypeSums",method = RequestMethod.GET)
    public Result getTypeSums(@RequestParam(name = "type") String type){
        String typeSums = designerService.getTypeSums(type);
        return new Result(ResultCode.SUCCESS,typeSums);
    }
//    9.通过得到当前类型下的一页内容（每一页的内容）
    @RequestMapping(value = "/getTypePage",method = RequestMethod.GET)
    public Result getTypePage(@RequestParam(name = "size")String size,@RequestParam(name = "currentPage")String currentPage,@RequestParam(name = "type")String type){
        List<DesignerList> typePages = designerService.getTypePage(size, currentPage, type);
        return new Result(ResultCode.SUCCESS,typePages);
    }
    //    11.跑马灯推荐（主页）
    @RequestMapping(value = "/getCarousel",method = RequestMethod.GET)
    public Result getCarousel(@RequestParam(name = "type") String type,@RequestParam(name = "num") Integer num){
        List<DesignerList> carousel = designerService.getCarousel(type, num);
        return new Result(ResultCode.SUCCESS,carousel);
    }
}
