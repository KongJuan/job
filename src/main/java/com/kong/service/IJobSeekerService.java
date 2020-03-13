package com.kong.service;

import com.kong.model.JobSeeker;

import java.util.Map;

public interface IJobSeekerService {

    //查询用户列表
    Map<String,Object> queryJobSeekerList(Map<String,Object> map);

    //登录
    JobSeeker queryJobSeeker(Map<String,Object> map);

    //查询用户  注册
    JobSeeker queryJobSeekerByName(String userName);

    //新增用户
    int addJobSeeker(Map<String,Object> map);

    //根据用户名更改用户信息
    void updateJobSeeker(Map<String,Object> map);

    //根据用户ID更改用户信息
    void updateJobSeekerById(Map<String,Object> map);

    //删除用户
    int delJobSeeker(Map<String,Object> map);

    //修改用户密码
    void updateJobSeekerPass(Map<String,Object> map);
}
