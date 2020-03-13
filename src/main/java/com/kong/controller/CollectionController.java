package com.kong.controller;

import com.kong.common.ResultInfo;
import com.kong.model.JobSeeker;
import com.kong.model.Position;
import com.kong.service.ICollectionService;
import com.kong.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private ICollectionService collectionService;

    @Autowired
    private IRecruiterService recruiterService;

    /**
     * 显示用户收藏
     *
     * @return
     */
    @RequestMapping(value = "/queryCollectPosition",produces = "application/json;charset=utf-8")
    public ResultInfo queryCollectPosition(@RequestBody Map<String,Integer> map){

        JobSeeker collectPosition=collectionService.queryCollectPosition(map.get("userId"));
        List<Position> positionList=collectPosition.getPositions();

        List<Map<String,Object>> resultList=new ArrayList<>();
        if (positionList.size() > 0) {
            for(Position position:positionList){
                Map<String,Object> resultMap =new HashMap<>();
                resultMap.put("pid",position.getP_id());
                resultMap.put("pName",position.getP_name());
                resultMap.put("workCity",position.getWorkCity());
                resultMap.put("publicTime",position.getPublicTime());
                resultMap.put("companyName",recruiterService.queryCompanyName(position.getPublicId()));
                resultList.add(resultMap);
            }
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 用户收藏职位
     * @param map
     * @return
     */
    @RequestMapping(value="/addCollectPosition",produces = "application/json;charset=utf-8")
    public ResultInfo addCollectPosition(@RequestBody Map<String,Object> map){
        int resultMap=collectionService.addCollectPosition(map);
        if (resultMap==1) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 删除收藏
     * @param map
     * @return
     */
    @RequestMapping(value="/delCollectPosition",produces = "application/json;charset=utf-8")
    public ResultInfo delCollectPosition(@RequestBody Map<String,Integer> map){
        int resultMap=collectionService.delCollectPosition(map);
        if (resultMap==1) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
}
