package com.kong.mapper;

import com.kong.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ResumeHandleMapper {

    //查询投递人员/
    List<Position>  searchDeliver(Map<String,Object> map);
    //查询投递时间
    String selectDeliverDate(@Param("pid") int pid,@Param("rid") int rid);
    //审核简历
    int verifyResume(Map<String,Object> map);
    //查看面试
    List<Position> queryInterview(Map<String,Object> map);
    //查看面试状态
    Map<String,Object> queryInterviewState(@Param("pid") int pid,@Param("rid") int rid);
}
