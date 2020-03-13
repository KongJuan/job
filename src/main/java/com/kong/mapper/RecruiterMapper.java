package com.kong.mapper;

import com.kong.model.Recruiter;

import java.util.List;
import java.util.Map;

public interface RecruiterMapper {

    //查询公司名称
    String queryCompanyName(int cid);

    //查看职位详细信息
    List<Recruiter> queryPositionDetail(Map<String,Object> map);

    //根据热门行业查询
    List<Recruiter> queryPositionInfoByTrade(Map<String,Object> map);

    //多条件查询
    List<Recruiter> queryPositionByMore(Map<String,Object> map);

    List<Recruiter> queryPositionInfo(Map<String,Object> map);

    List<Recruiter> queryRecruiterList(Map<String,Object> map);

    //根据公司名查询
    List<Recruiter> queryPositionBycompany(String companyName);

    //查询用户
    Recruiter login(Map<String, Object> map);

    //根据用户名查询用户是否存在
    Recruiter queryRecruiterByName(String name);

    //新增用户
    int addRecruiter(Map<String,Object> map);

    //根据用户姓名更新用户信息
    void updateRecruiter(Map<String,Object> map);

    //更加用户id更新用户信息
    void updateRecruiterById(Map<String,Object> map);

    //删除用户
    int delRecruiter(Map<String,Object> map);

    //修改用户密码
    int  updateRecruiterPass(Map<String,Object> map);

    //投递成功时显示的信息
    Recruiter querydeliver(int pid);
}
