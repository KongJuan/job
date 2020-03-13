package com.kong.controller;

import com.kong.common.ResultInfo;
import com.kong.model.Position;
import com.kong.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @RequestMapping(value = "/queryPersonalPosition",produces = "application/json;charset=utf-8")
    public ResultInfo queryPersonalPosition(@RequestBody Map<String,Object> map){
        List<Position> result=positionService.queryPersonalPosition(map);
        if (result.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value = "/queryPositionInfo",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionInfo(@RequestBody Map<String,Object> map){
        Position resultMap=positionService.queryPositionInfo(map);
        if (resultMap!=null) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value="/addPosition",produces = "application/json;charset=utf-8")
    public ResultInfo addPosition(@RequestBody Map<String,Object> map){
        int resultMap=positionService.addPosition(map);
        if (resultMap==1) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value="/updatePosition",produces = "application/json;charset=utf-8")
    public ResultInfo updatePosition(@RequestBody Map<String,Object> map){
        int resultMap=positionService.updatePositionById(map);
        if (resultMap==1) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value="/delPosition",produces = "application/json;charset=utf-8")
    public ResultInfo delPosition(@RequestBody Map<String,Object> map){
        int resultMap=positionService.delPosition(map);
        if (resultMap==1) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
}
