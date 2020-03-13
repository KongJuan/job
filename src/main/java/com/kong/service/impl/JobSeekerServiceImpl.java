package com.kong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kong.mapper.JobSeekerMapper;
import com.kong.model.JobSeeker;
import com.kong.service.IJobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//业务层实现类
@Service()
public class JobSeekerServiceImpl implements IJobSeekerService {

    @Autowired
    private JobSeekerMapper jobSeekerMapper;

    //查询用户列表
    @Override
    public Map<String, Object> queryJobSeekerList(Map<String, Object> map) {
        //获取当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum,pageSize);
        List<JobSeeker> jsList = jobSeekerMapper.queryJobSeekerList(map);
        PageInfo pageInfo = new PageInfo(jsList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",jsList);

        return resultMap;
    }

    //根据条件查询   登录
    @Override
    public JobSeeker queryJobSeeker(Map<String, Object> map) {
        return jobSeekerMapper.queryJobSeeker(map);
    }

    @Override
    public JobSeeker queryJobSeekerByName(String userName) {
        return jobSeekerMapper.queryJobSeekerByName(userName);
    }

    //添加用户
    @Override
    public int addJobSeeker(Map<String, Object> map) {
        return jobSeekerMapper.addJobSeeker(map);
    }

    //根据用户名更改用户信息
    @Override
    public void updateJobSeeker(Map<String, Object> map) {
        jobSeekerMapper.updateJobSeeker(map);
    }

    //根据用户id更改用户信息
    @Override
    public void updateJobSeekerById(Map<String, Object> map) {
        jobSeekerMapper.updateJobSeekerById(map);
    }

    //删除用户
    @Override
    public int delJobSeeker(Map<String, Object> map) {
        return jobSeekerMapper.delJobSeeker(map);
    }

    //修改用户密码
    @Override
    public void updateJobSeekerPass(Map<String, Object> map) {
        jobSeekerMapper.updateJobSeekerPass(map);
    }
}
