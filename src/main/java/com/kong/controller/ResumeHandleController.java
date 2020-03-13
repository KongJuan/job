package com.kong.controller;

import com.kong.common.ResultInfo;
import com.kong.model.Position;
import com.kong.service.IPositionService;
import com.kong.service.IResumeHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resumeHandle")
public class ResumeHandleController {

    @Autowired
    private IResumeHandleService resumeHandleService;

    @Autowired
    private IPositionService positionService;

    //筛选简历
    @RequestMapping(value = "/searchDeliver",produces = "application/json;charset=utf-8")
    public ResultInfo searchDeliver(@RequestBody Map<String,Object> map){
        Map<String,Object> responseMap=new HashMap<>();
        List<Integer> list=positionService.queryPositionId(Integer.parseInt(map.get("publicId").toString()));
        responseMap.put("list",list);
        responseMap.put("pname",map.get("pname"));
        responseMap.put("rname",map.get("rname"));
        responseMap.put("state",map.get("state"));
        List<Position> deliverList=resumeHandleService.searchDeliver(responseMap);
        List<Map<String,Object>> resultList=new ArrayList<>();
        if(deliverList.size()>0){

            for(Position position:deliverList){
                Map<String,Object> resultMap=new HashMap<>();
                resultMap.put("name",position.getResumes().get(0).getName());
                resultMap.put("gender",position.getResumes().get(0).getGender());
                resultMap.put("birthday",position.getResumes().get(0).getBirthDate());
                resultMap.put("job", position.getP_name());
                resultMap.put("applyDate",resumeHandleService.selectDeliverDate(position.getP_id(),position.getResumes().get(0).getId()));
                resultList.add(resultMap);
            }

            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        }else{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    //审核简历
    @RequestMapping(value = "/verifyResume",produces = "application/json;charset=utf-8")
    public ResultInfo verifyResume(@RequestBody Map<String,Object> map) {
          int result=resumeHandleService.verifyResume(map);
          if(result>0){
              return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
          }else{
              return new ResultInfo(ResultInfo.Status.WARN);
          }
    }

    //查看面试
    @RequestMapping(value = "/queryInterview",produces = "application/json;charset=utf-8")
    public ResultInfo queryInterview(@RequestBody Map<String,Object> map){
        Map<String,Object> responseMap=new HashMap<>();
        List<Integer> list=positionService.queryPositionId(Integer.parseInt(map.get("publicId").toString()));
        responseMap.put("list",list);
        responseMap.put("pname",map.get("pname"));
        responseMap.put("rname",map.get("rname"));
        responseMap.put("state",map.get("state"));
        List<Position> interviewList=resumeHandleService.queryInterview(responseMap);
        List<Map<String,Object>> resultList=new ArrayList<>();
        if(interviewList.size()>0){
            for(Position position:interviewList){
                Map<String,Object> resultMap=new HashMap<>();
                Map<String,Object> interviewState=resumeHandleService.queryInterviewState(position.getP_id(),position.getResumes().get(0).getId());
                resultMap.put("name",position.getResumes().get(0).getName());
                resultMap.put("gender",position.getResumes().get(0).getGender());
                resultMap.put("birthday",position.getResumes().get(0).getBirthDate());
                resultMap.put("job", position.getP_name());
                resultMap.put("applyDate",interviewState.get("inviteTime"));
                resultMap.put("status",interviewState.get("state"));
                resultList.add(resultMap);
            }

            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        }else{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
}
