package com.kong.service;

import com.kong.model.Position;

import java.util.List;
import java.util.Map;

public interface IResumeHandleService {
    //查询投递人员/
    List<Position> searchDeliver(Map<String,Object> map);

    String selectDeliverDate(int pid, int rid);

    //审核简历
    int verifyResume(Map<String,Object> map);

    //查看面试
    List<Position> queryInterview(Map<String,Object> map);

    //查看面试状态
    Map<String,Object> queryInterviewState(int pid,int rid);
}
