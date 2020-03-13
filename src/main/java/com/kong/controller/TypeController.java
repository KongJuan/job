package com.kong.controller;

import com.kong.common.ResultInfo;
import com.kong.model.Type;
import com.kong.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @PostMapping("queryCompanyType")
    public ResultInfo queryCompanyType(){
        List<Type> typeList=typeService.queryCompanyType();
        if(typeList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(typeList);
        }else{
            return new ResultInfo((ResultInfo.Status.WARN));
        }
    }

    @PostMapping("queryWorkCharacter")
    public ResultInfo queryWorkCharacter(){
        List<Type> typeList=typeService.queryWorkCharacter();
        if(typeList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(typeList);
        }else{
            return new ResultInfo((ResultInfo.Status.WARN));
        }
    }

    @PostMapping("queryFunctionType")
    public ResultInfo queryFunctionType(){
        List<Type> typeList=typeService.queryFunctionType();
        if(typeList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(typeList);
        }else{
            return new ResultInfo((ResultInfo.Status.WARN));
        }
    }

    @PostMapping("queryWorkType")
    public ResultInfo queryWorkType(){
        List<Type> typeList=typeService.queryWorkType();
        if(typeList.size()>0){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(typeList);
        }else{
            return new ResultInfo((ResultInfo.Status.WARN));
        }
    }
}
