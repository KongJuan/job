package com.kong.controller;

import com.kong.common.DateUtil;
import com.kong.common.ResultInfo;
import com.kong.model.*;
import com.kong.service.IChinaService;
import com.kong.service.IRecruiterService;
import com.kong.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    private IResumeService resumeService;

    @Autowired
    private IRecruiterService recruiterService;

    @Autowired
    private IChinaService chinaService;

    @PostMapping("queryResume")
    public ResultInfo queryResume(@RequestBody Map<String,Object> map,HttpServletRequest request){
        Resume resume= resumeService.queryResume(map);

        resume.setBirthProvince(chinaService.placeName(Integer.parseInt(resume.getBirthProvince())));
        resume.setBirthCity(chinaService.placeName(Integer.parseInt(resume.getBirthCity())));
        resume.setLiveProvince(chinaService.placeName(Integer.parseInt(resume.getLiveProvince())));
        resume.setLiveCity(chinaService.placeName(Integer.parseInt(resume.getLiveCity())));
        resume.setLiveCounty(chinaService.placeName(Integer.parseInt(resume.getLiveCounty())));

        request.getSession().setAttribute("resume",resume);
        if (resume!=null) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resume);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }


    /**
     * 查询简历中的个人信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryUserInfo",produces = "application/json;charset=utf-8")
    public ResultInfo queryUserInfo(@RequestBody Map<String,Object> map,HttpServletRequest request){
        Map<String,Object> resultMap= resumeService.queryUserInfo(map);
        request.getSession().setAttribute("rid",resultMap.get("id"));
        if (resultMap.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 查询简历中的求职意向信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryJobIntention",produces = "application/json;charset=utf-8")
    public ResultInfo queryJobIntention(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= resumeService.queryJobIntention(map);
        if (resultMap.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    @RequestMapping(value = "/queryUserInfoById",produces = "application/json;charset=utf-8")
    public ResultInfo queryUserInfoById(@RequestBody Map<String,Object> map){
       Resume result= resumeService.queryUserInfoById(map);
        if (result!=null) {
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("id",result.getId());
            resultMap.put("name",result.getName());
            resultMap.put("gender",result.getGender());
            resultMap.put("birthDate", DateUtil.getCurrentDateStr("yyyy-MM-dd",result.getBirthDate()));
            resultMap.put("workDate",DateUtil.getCurrentDateStr("yyyy-MM-dd",result.getWorkDate()));
            resultMap.put("birthProvince",result.getBirthProvince());
            resultMap.put("birthCity",result.getBirthCity());
            resultMap.put("liveProvince",result.getLiveProvince());
            resultMap.put("liveCity",result.getLiveCity());
            resultMap.put("liveCounty",result.getLiveCounty());
            resultMap.put("phone",result.getPhone());
            resultMap.put("mail",result.getMail());
            resultMap.put("identity",result.getIdentity());
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 查询简历中的求职意向信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryJobIntentionById",produces = "application/json;charset=utf-8")
    public ResultInfo queryJobIntentionById(@RequestBody Map<String,Object> map){
        Resume result= resumeService.queryJobIntentionById(map);
        if (result!=null) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
    /**
     * 修改简历中的个人信息
     * @param resume
     * @return
     */
    @PostMapping("updateUserInfo")
    public ResultInfo updateUserInfo(@RequestBody Resume resume){
        int resultMap= resumeService.updateUser(resume);
        if (resultMap > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 修改简历中的求职意向信息
     * @param resume
     * @return
     */
    @RequestMapping(value = "/updateJobIntention",produces = "application/json;charset=utf-8")
    public ResultInfo updateJobIntention(@RequestBody Resume resume){
        int resultMap= resumeService.updateJobIntention(resume);
        if (resultMap> 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }


    /**
     * 查询简历中的项目经验
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryProjectById",produces = "application/json;charset=utf-8")
    public ResultInfo queryProjectById(@RequestBody Map<String,Object> map){
        List<Project> resultMap= resumeService.queryProjectById(map);
        if (resultMap.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 查询简历中的教育背景
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryEducationById",produces = "application/json;charset=utf-8")
    public ResultInfo queryEducationById(@RequestBody Map<String,Object> map){
        List<Education> resultMap= resumeService.queryEducationById(map);
        if (resultMap.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }


    @RequestMapping(value = "/submitProject",produces = "application/json;charset=utf-8")
    public ResultInfo submitProject(@RequestBody Project project){
        if(project.getProId()>0){
            int result= resumeService.updateProject(project);
            if (result> 0) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{
            int result= resumeService.addProject(project);
            if (result> 0) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }

    }

    @RequestMapping(value = "/submitEducation",produces = "application/json;charset=utf-8")
    public ResultInfo submitEducation(@RequestBody Education education){
        if(education.getEduId()>0){
            int result= resumeService.updateEducation(education);
            if (result> 0) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{
            int result= resumeService.addEducation(education);
            if (result> 0) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(result);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }

    }

    /**
     * 投递简历  申请职位
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "/deliverResume",produces = "application/json;charset=utf-8")
    public ResultInfo deliverResume(@RequestBody Map<String,Object> map, HttpServletRequest request){
        Map<String,Object> jobSeekerMap=new HashMap<>();
        jobSeekerMap.put("userId",Integer.parseInt(map.get("userId").toString()));
        Resume resumeInfo= resumeService.queryResume(jobSeekerMap);
        if(resumeInfo!=null){
            int resultMap= resumeService.deliverResume(map);
            if (resultMap> 0) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultMap);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{
            return new ResultInfo(ResultInfo.Status.WARN).message("请先将基本信息填写完整");
        }

    }

    /**
     * 投递进程
     * @param map
     * @return
     */
    @RequestMapping(value = "/progress",produces = "application/json;charset=utf-8")
    public ResultInfo progress(@RequestBody Map<String,Object> map){
        int type= Integer.parseInt(map.get("type").toString());
        Map<String,Object> jobSeekerMap=new HashMap<>();
        jobSeekerMap.put("userId",map.get("userId"));
        Resume resumeInfoMap= resumeService.queryResume(jobSeekerMap);
        int resumeId=resumeInfoMap.getId();
        if(resumeId>0){
            if(type==1){  //查看全部投递
                List<Deliver> deliverList=resumeService.deliverSuccess(resumeId);
                return deliverProgress(deliverList,recruiterService,type);
            }else if(type==2){ //查看被查看
                List<Deliver> deliverList=resumeService.looked(resumeId);
                return deliverProgress(deliverList,recruiterService,type);
            }else if(type==3){ //查看有意向
                List<Deliver> deliverList=resumeService.want(resumeId);
                return deliverProgress(deliverList,recruiterService,type);
            }else if(type==4){  //查看邀请面试
                List<Deliver> deliverList=resumeService.interview(resumeId);
                return deliverProgress(deliverList,recruiterService,type);
            }else{//查看不适合
                List<Deliver> deliverList=resumeService.deliverFail(resumeId);
                return deliverProgress(deliverList,recruiterService,type);
            }

        }else{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    public static ResultInfo deliverProgress(List<Deliver> deliverList,IRecruiterService recruiterService,int type){
        if(deliverList.size()>0){
            List<Map<String,Object>> list=new ArrayList<>();
            for(Deliver deliver:deliverList){
                Recruiter re=recruiterService.querydeliver(deliver.getPid());
                Map<String,Object> remap=new HashMap<>();
                remap.put("pname",re.getPositions().get(0).getP_name());
                remap.put("salary",re.getPositions().get(0).getSalary());
                remap.put("company",re.getCompanyName());
                if(type==1){
                    remap.put("time",deliver.getDeliverTime());
                }else if(type==2){
                    remap.put("time",deliver.getLookTime());
                }else if(type==3){
                    remap.put("time",deliver.getWantTime());
                }else if(type==4){
                    remap.put("time",deliver.getInviteTime());
                }else{
                    remap.put("time",deliver.getUnsuitedTime());
                }

                list.add(remap);
            }
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(list);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN).message("很遗憾，您没有面试邀请");
        }
    }

}
