package com.kong.controller;

import com.kong.common.MD5Util;
import com.kong.common.ResultInfo;
import com.kong.model.JobSeeker;
import com.kong.model.Recruiter;
import com.kong.service.IJobSeekerService;
import com.kong.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IJobSeekerService jobSeekerService;

    @Autowired
    private IRecruiterService recruiterService;

    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String, Object> map, HttpServletRequest request){
        int type=Integer.parseInt(map.get("userType").toString());
        System.out.println(type);
        if(type==1){
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("userName",map.get("name"));
            resultMap.put("userPwd", MD5Util.string2MD5(map.get("password").toString()));
            JobSeeker jobSeeker = jobSeekerService.queryJobSeeker(resultMap);
            request.getSession().setAttribute("jobSeeker",jobSeeker);
            int userId=jobSeeker.getUserId();
            if (jobSeeker!=null){
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(userId);
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else if(type==2){
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("cname",map.get("name"));
            resultMap.put("cpwd", MD5Util.string2MD5(map.get("password").toString()));
            Recruiter recruiter= recruiterService.login(resultMap);
            if (recruiter!=null){
                request.getSession().setAttribute("recruiter",recruiter);
                return new ResultInfo(ResultInfo.Status.SUCCESS);
            }{
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{

        }
        return null;
    }
}
