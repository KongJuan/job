package com.kong.controller;

import com.kong.common.ResultInfo;
import com.kong.model.China;
import com.kong.service.IChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/china")
public class ChinaController {

    @Autowired
    private IChinaService chinaService;

    @RequestMapping(value = "/province",produces = "application/json;charset=utf-8")
    public ResultInfo queryProvince(){
        List<China> resultList=chinaService.queryProvince();
        if(resultList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        }else{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value = "/city",produces = "application/json;charset=utf-8")
    public ResultInfo queryCity(@RequestBody Map<String,Object> map){
        List<China> resultList=chinaService.queryCity(map);
        if(resultList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        }else{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
}
