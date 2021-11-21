package com.cloth.clothfrontweb.controller;

import com.cloth.clothfrontweb.common.entity.Result;
import com.cloth.clothfrontweb.common.entity.ResultCode;
import com.cloth.clothfrontweb.commonmodel.domain.Expriences;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.commonmodel.domain.response.ExpriencesList;
import com.cloth.clothfrontweb.service.DesignerService;
import com.cloth.clothfrontweb.service.ExpriencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/expriences")
public class ExpriencesController {
    @Autowired
    ExpriencesService expriencesService;
    //    最热励志经历人物
    @RequestMapping(value = "/hot/getInspire",method = RequestMethod.GET)
    public Result getInspire(@RequestParam(name = "type") String type) {
        List<DesignerList> inspire = expriencesService.getInspire(type);
        return new Result(ResultCode.SUCCESS,inspire);
    }
//    个人的经历
@RequestMapping(value = "/getExpriences",method = RequestMethod.GET)
    public Result getExpriences(@RequestParam(name = "id") String id) {
    List<ExpriencesList> expriences = expriencesService.getExpriences(id);
        return new Result(ResultCode.SUCCESS,expriences);
    }
//    10.跑马灯推荐（个人经历）
    @RequestMapping(value = "/getCarousel",method = RequestMethod.GET)
    public Result getCarousel(@RequestParam(name = "type") String type,@RequestParam(name = "id") String id) {
        List<DesignerList> carousel = expriencesService.getCarousel(type, id);
        return new Result(ResultCode.SUCCESS,carousel);
    }
}
