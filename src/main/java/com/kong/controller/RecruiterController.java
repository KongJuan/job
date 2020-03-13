package com.kong.controller;

import com.kong.common.MD5Util;
import com.kong.common.ResultInfo;
import com.kong.model.Recruiter;
import com.kong.model.RecruiterPosition;
import com.kong.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recruit")
public class RecruiterController {

    @Autowired
    private IRecruiterService recruiterService;

    @RequestMapping(value = "/queryPositionDetail",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionDetail(@RequestBody Map<String,Object> map){
        List<Map<String,Object>> resultList = recruiterService.queryPositionDetail(map);
        if (resultList.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 根据热门行业搜索
     * @return
     */
    @RequestMapping(value = "/queryPositionInfoByTrade",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionInfoByTrade(@RequestBody Map<String,Object> map){
        List<RecruiterPosition> resultList = recruiterService.queryPositionInfoByTrade(map);
        if (resultList.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 功能描述：查询列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryPositionByMore",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionByMore(@RequestBody Map<String,Object> map){
        List<Map<String,Object>> resultList = recruiterService.queryPositionByMore(map);
        if (resultList.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 功能描述：查询列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryPositionRecruiter",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionRecruiter(@RequestBody Map<String,Object> map){
        ResultInfo resultInfo;
        List<RecruiterPosition> resultList = recruiterService.queryPositionInfo(map);
        if (resultList.size() > 0) {
            resultInfo = new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            resultInfo = new ResultInfo(ResultInfo.Status.WARN);
        }
        return resultInfo;
    }

    /**
     * 查询某公司发布的职位
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryPositionBycompany",produces = "application/json;charset=utf-8")
    public ResultInfo queryPositionBycompany(HttpServletRequest request){
        Recruiter recruiter=(Recruiter)request.getSession().getAttribute("recruiter");
        String companyName=recruiter.getCompanyName();
            List<Recruiter> pList = recruiterService.queryPositionBycompany(companyName);
            if (pList.size() > 0) {
                if(pList.get(0).getPositions().size()>0){
                    List<Map<String,Object>> resultList=new ArrayList<>();
                    for(Recruiter rec:pList){
                        Map<String,Object> map=new HashMap<>();
                        map.put("realname",rec.getRealname());
                        map.put("pname",rec.getPositions().get(0).getP_name());
                        map.put("salary",rec.getPositions().get(0).getSalary());
                        map.put("employeeType",rec.getPositions().get(0).getEmployeeType());
                        map.put("brief",rec.getPositions().get(0).getBrief());
                        map.put("publicTime",rec.getPositions().get(0).getPublicTime());
                        resultList.add(map);
                    }
                    return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
                }else {
                    return new ResultInfo(ResultInfo.Status.WARN).message("该公司未发布过任何职位");
                }
            } else {
                return new ResultInfo(ResultInfo.Status.WARN);
            }

    }

    /**
     * 功能描述：查询用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryRecruiterList",produces = "application/json;charset=utf-8")
    public ResultInfo queryRecruiterList(@RequestBody Map<String,Object> map){
        List<Recruiter> resultList = recruiterService.queryRecruiterList(map);
        if (resultList.size() > 0) {
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(resultList);
        } else {
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 功能描述：登录
     * @param map
     * @return
     */
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public ResultInfo login(@RequestBody Map<String,Object> map, HttpServletRequest request){
        /*Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("cname",map.get("cname"));
        resultMap.put("cpwd", MD5Util.string2MD5(map.get("cpwd").toString()));
        Recruiter recruiter= recruiterService.login(resultMap);
        if (recruiter!=null){
            request.getSession().setAttribute("recruiter",recruiter);
            return new ResultInfo(ResultInfo.Status.SUCCESS);
        }{
            return new ResultInfo(ResultInfo.Status.WARN);
        }*/
        return null;
    }

    /**
     * 功能描述：单位注册
     * @param map
     * @return
     */
    @RequestMapping(value = "/addRecruiter",produces = "application/json;charset=utf-8")
    public ResultInfo addRecruiter(@RequestBody Map<String,Object> map) {
        ResultInfo resultInfo;
        if(recruiterService.queryRecruiterByName(map.get("cname").toString())==null){
            map.put("cpwd",MD5Util.string2MD5(map.get("cpwd").toString()));
            int flag = recruiterService.addRecruiter(map);
            if (flag == 1) {
                resultInfo = new ResultInfo(ResultInfo.Status.SUCCESS).result(flag);
            } else {
                resultInfo = new ResultInfo(ResultInfo.Status.WARN);
            }
        }else{
            resultInfo = new ResultInfo(ResultInfo.Status.WARN).message("用户名已存在");
        }

        return resultInfo;
    }

    /**
     * 功能描述：根据用户名更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateRecruiterByName",produces = "application/json;charset=utf-8")
    public ResultInfo updateRecruiterByName(@RequestBody Map<String,Object> map){
        recruiterService.updateRecruiter(map);

        return new ResultInfo(ResultInfo.Status.SUCCESS).result("Ok");

    }

    /**
     * 功能描述：根据用户ID更改用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateRecruiterById",produces = "application/json;charset=utf-8")
    public ResultInfo updateUserById(@RequestBody Map<String,Object> map){
        recruiterService.updateRecruiterById(map);
        return new ResultInfo(ResultInfo.Status.SUCCESS).result("Ok");
    }

    /**
     * 功能描述：删除用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/delRecruiter",produces = "application/json;charset=utf-8")
    public  ResultInfo delRecruiter(@RequestBody Map<String,Object> map){
        int flag=recruiterService.delRecruiter(map);
        if (flag==1){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(flag);
        }{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }

    /**
     * 功能描述：修改用户密码
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateRecruiterPass",produces = "application/json;charset=utf-8")
    public ResultInfo updateRecruiterPass(@RequestBody Map<String,Object> map){
        int flag=recruiterService.updateRecruiterPass(map);
        if (flag==1){
            return new ResultInfo(ResultInfo.Status.SUCCESS).result(flag);
        }{
            return new ResultInfo(ResultInfo.Status.WARN);
        }
    }
}
