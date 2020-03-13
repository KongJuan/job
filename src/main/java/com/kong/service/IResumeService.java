package com.kong.service;

import com.kong.model.Deliver;
import com.kong.model.Education;
import com.kong.model.Project;
import com.kong.model.Resume;

import java.util.List;
import java.util.Map;

public interface IResumeService {

    Resume queryResume(Map<String,Object> map);

    //查询简历中的个人信息
    Map<String, Object> queryUserInfo(Map<String, Object> map);

    //查询简历中的求职意向
    Map<String, Object> queryJobIntention(Map<String, Object> map);

    //查询简历中的个人信息
    Resume queryUserInfoById(Map<String, Object> map);

    //查询简历中的求职意向
    Resume queryJobIntentionById(Map<String, Object> map);

    //添加简历中的个人信息
    int insertUserInfo(Map<String,Object> map);

    //添加简历中的求职意向
    int insertJobIntention(Map<String,Object> map);

    //修改简历中的个人信息
    int updateUser(Resume resume);

    //修改简历中的求职意向
    int updateJobIntention(Resume resume);


    //通过Id查询简历中的项目经验
    List<Project> queryProjectById(Map<String, Object> map);

    //通过Id查询简历中的教育背景
    List<Education> queryEducationById(Map<String, Object> map);

    //添加简历中的项目经验
    int addProject(Project project);

    //添加简历中的教育背景
    int addEducation(Education education);

    //修改简历中的项目经验
    int updateProject(Project project);

    //修改简历中的教育背景
    int updateEducation(Education education);

    //投递简历
    int deliverResume(Map<String,Object> map);

    ///投递成功
    List<Deliver> deliverSuccess(int rid);
    //已查看
    List<Deliver> looked(int rid);
    List<Deliver> want(int rid);
    //邀请面试
    List<Deliver> interview(int rid);

    //不适合
    List<Deliver> deliverFail(int rid);
}
