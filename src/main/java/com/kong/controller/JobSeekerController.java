package com.kong.controller;

import com.kong.common.AssembleResponseMsg;
import com.kong.common.MD5Util;
import com.kong.common.ResultInfo;
import com.kong.model.JobSeeker;
import com.kong.model.ResponseBody;
import com.kong.service.IJobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController{
    @Autowired
    private IJobSeekerService jobSeekerService;

    /**
     * 功能描述：查询用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryJobSeekerList",produces = "application/json;charset=utf-8")
    public ResponseBody queryJobSeekerList(@RequestBody Map<String,Object> map){
        Map<String, Object> resultMap = jobSeekerService.queryJobSeekerList(map);
        return new AssembleResponseMsg().success(resultMap);
    }

    /**
     * 功能描述：登录
     * @param map
     * @return
     */
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public ResultInfo login(@RequestBody Map<String,Object> map, HttpServletRequest request){
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("userName",map.get("userName"));
        resultMap.put("userPwd",MD5Util.string2MD5(map.get("userPwd").toString()));
        JobSeeker jobSeeker = jobSeekerService.queryJobSeeker(resultMap);
        request.getSession().setAttribute("jobSeeker",jobSeeker);
        int userId=jobSeeker.getUserId();
        if (jobSeeker!=null){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(userId);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
        /*return null;*/
    }

    /**
     * 功能描述：新增用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/addJobSeeker",produces = "application/json;charset=utf-8")
    public ResultInfo addJobSeeker(@RequestBody Map<String,Object> map){
        String name=map.get("userName").toString();
        map.put("userPwd",MD5Util.string2MD5(map.get("userPwd").toString()));
        if(jobSeekerService.queryJobSeekerByName(name)==null){

            int flag=jobSeekerService.addJobSeeker(map);
            if (flag==1) {
                return new ResultInfo(ResultInfo.Status.SUCCESS).result(flag);
            }else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{
            return new ResultInfo(ResultInfo.Status.WARN).message("用户名已存在");
        }


    }

    /**
     * 功能描述：根据用户名更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateJobSeekerByName",produces = "application/json;charset=utf-8")
    public ResponseBody updateJobSeekerByName(@RequestBody Map<String,Object> map){
        jobSeekerService.updateJobSeeker(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：根据用户ID更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateJobSeekerById",produces = "application/json;charset=utf-8")
    public ResponseBody updateUserById(@RequestBody Map<String,Object> map){
        jobSeekerService.updateJobSeekerById(map);
        return new AssembleResponseMsg().success("OK");
    }

    /**
     * 功能描述：删除用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/delJobSeeker",produces = "application/json;charset=utf-8")
    public  ResponseBody delJobSeeker(@RequestBody Map<String,Object> map){
        int flag=jobSeekerService.delJobSeeker(map);
        if (flag==1){
            return new AssembleResponseMsg().success("OK");
        }{
            return new AssembleResponseMsg().failure(200,"error","该用户不存在");
        }
    }

    /**
     * 功能描述：修改用户密码
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateJobSeekerPass",produces = "application/json;charset=utf-8")
    public ResponseBody updateJobSeekerPass(@RequestBody Map<String,Object> map){
        jobSeekerService.updateJobSeekerPass(map);
        return new AssembleResponseMsg().success("OK");
    }


}
