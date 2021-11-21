package com.cloth.clothfrontweb.controller;

import com.cloth.clothfrontweb.common.entity.Result;
import com.cloth.clothfrontweb.common.entity.ResultCode;
import com.cloth.clothfrontweb.commonmodel.domain.response.DesignerList;
import com.cloth.clothfrontweb.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/magazine")
public class MagazineController {
    @Autowired
    MagazineService magazineService;
//    最新期刊人物
    @RequestMapping(value = "//hot/getNearest",method = RequestMethod.GET)
    public Result getNearest() {
        List<DesignerList> nearest = magazineService.getNearest();
        return new Result(ResultCode.SUCCESS,nearest);
    }
}
