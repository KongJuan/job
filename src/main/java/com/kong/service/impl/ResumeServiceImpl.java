package com.kong.service.impl;

import com.kong.mapper.ResumeMapper;
import com.kong.model.Deliver;
import com.kong.model.Education;
import com.kong.model.Project;
import com.kong.model.Resume;
import com.kong.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public  Resume queryResume(Map<String, Object> map) {

        return resumeMapper.queryResume(map);
    }

    @Override
    public Map<String, Object> queryUserInfo(Map<String, Object> map) {
        List<Resume> resumeList=resumeMapper.queryUserInfo(map);
        Iterator<Resume> it=resumeList.iterator();
        Map<String,Object> resultMap=new HashMap<>();
        if (it.hasNext()) {
           // Resume resume=it.next();
//            resultMap.put("id",resume.getId());
//            resultMap.put("name",resume.getName());
//            resultMap.put("gender",resume.getGender());
         //   resultMap.put("birthDate", Integer.parseInt(DateUtil.getCurrentDateStr("yyyy",new Date()))-Integer.parseInt(DateUtil.getCurrentDateStr("yyyy",resume.getBirthDate())));
          //  resultMap.put("workDate",Integer.parseInt(DateUtil.getCurrentDateStr("yyyy",new Date()))-Integer.parseInt(DateUtil.getCurrentDateStr("yyyy",resume.getWorkDate())));
//            resultMap.put("birthAddress",resume.getBirthAddress());
//            resultMap.put("phone",resume.getPhone());
//            resultMap.put("mail",resume.getMail());
//            resultMap.put("identity",resume.getIdentity());
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> queryJobIntention(Map<String, Object> map) {
        List<Resume> resumeList=resumeMapper.queryJobIntention(map);

        Iterator<Resume> it=resumeList.iterator();
        Map<String,Object> resultMap=new HashMap<>();
        if (it.hasNext()) {
            Resume resume=it.next();
            resultMap.put("id",resume.getId());
            resultMap.put("workCharacter",resume.getWorkCharacter());
            resultMap.put("expectPlace",resume.getExpectPlace());
            resultMap.put("expectJob",resume.getExpectJob());
            resultMap.put("expectPost",resume.getExpectPost());
            resultMap.put("expectSalary",resume.getExpectSalary());
        }

        return resultMap;
    }

    @Override
    public Resume queryUserInfoById(Map<String, Object> map) {
        return resumeMapper.queryUserInfoById(map);

    }

    @Override
    public Resume queryJobIntentionById(Map<String, Object> map) {
         return resumeMapper.queryJobIntentionById(map);

    }

    @Override
    public int insertUserInfo(Map<String, Object> map) {
        return resumeMapper.insertUserInfo(map);
    }

    @Override
    public int insertJobIntention(Map<String, Object> map) {
        return resumeMapper.insertJobIntention(map);
    }

    @Override
    public int updateUser(Resume resume) {
        return resumeMapper.updateUser(resume);
    }

    @Override
    public int updateJobIntention(Resume resume) {
        return resumeMapper.updateJobIntention(resume);
    }

    @Override
    public int deliverResume(Map<String, Object> map) {
        return resumeMapper.deliverResume(map);
    }

    @Override
    public List<Project> queryProjectById(Map<String, Object> map) {
        return resumeMapper.queryProjectById(map);
    }

    @Override
    public List<Education> queryEducationById(Map<String, Object> map) {
        return resumeMapper.queryEducationById(map);
    }

    @Override
    public int addProject(Project project) {
        return resumeMapper.addProject(project);
    }

    @Override
    public int addEducation(Education education) {
        return resumeMapper.addEducation(education);
    }

    @Override
    public int updateProject(Project project) {
        return resumeMapper.updateProject(project);
    }

    @Override
    public int updateEducation(Education education) {
        return resumeMapper.updateEducation(education);
    }

    @Override
    public List<Deliver> deliverSuccess(int rid) {
        return resumeMapper.deliverSuccess(rid);
    }

    @Override
    public List<Deliver> interview(int rid) {
        return resumeMapper.interview(rid);
    }

    @Override
    public List<Deliver> want(int rid) {
        return resumeMapper.want(rid);
    }

    @Override
    public List<Deliver> looked(int pid) {
        return resumeMapper.looked(pid);
    }

    @Override
    public List<Deliver> deliverFail(int rid) {
        return resumeMapper.deliverFail(rid);
    }
}
