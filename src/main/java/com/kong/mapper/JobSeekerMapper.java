package com.kong.mapper;

import com.kong.model.JobSeeker;

import java.util.List;
import java.util.Map;

public interface JobSeekerMapper {


    //查询所有列表
    List<JobSeeker> queryJobSeekerList(Map<String, Object> map);

    //查询用户  登录
    JobSeeker queryJobSeeker(Map<String, Object> map);

    //查询用户  注册
    JobSeeker queryJobSeekerByName(String userName);

    //新增用户
    int addJobSeeker(Map<String,Object> map);

    //根据用户姓名更新用户信息
    void updateJobSeeker(Map<String,Object> map);

    //更加用户id更新用户信息
    void updateJobSeekerById(Map<String,Object> map);

    //删除用户
    int delJobSeeker(Map<String,Object> map);

    //修改用户密码
    void  updateJobSeekerPass(Map<String,Object> map);
}
