package com.cloth.clothfrontweb.controller;

import com.cloth.clothfrontweb.common.entity.Result;
import com.cloth.clothfrontweb.common.entity.ResultCode;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/research")
public class ResearchController {

    @Autowired
    ResearchService researchService;
//    12.搜索的总数（作为分页的页码）
    @RequestMapping(value = "/getResearchSums",method = RequestMethod.GET)
    public Result getResearchSums(@RequestParam(name = "research")String research){
        String sum = researchService.getResearchSums(research);
        return new Result(ResultCode.SUCCESS, sum);
    }
//    13.通过得到当前类型下的一页内容（每一页的内容）
    @RequestMapping(value = "/getResearchPage",method = RequestMethod.GET)
    public Result getResearchPage(@RequestParam(name = "size")String size,@RequestParam(name = "currentPage")String currentPage,@RequestParam(name = "research")String research){
        List<DesignerList> researchPage = researchService.getResearchPage(size, currentPage, research);
        return new Result(ResultCode.SUCCESS,researchPage);
    }
}
