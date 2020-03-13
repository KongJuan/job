package com.kong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kong.mapper.RecruiterMapper;
import com.kong.model.Recruiter;
import com.kong.model.RecruiterPosition;
import com.kong.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecruiterServiceImpl implements IRecruiterService {

    @Autowired
    private RecruiterMapper recruiterMapper;

    @Override
    public String queryCompanyName(int cid) {
        return recruiterMapper.queryCompanyName(cid);
    }

    @Override
    public List<Map<String,Object>> queryPositionDetail(Map<String, Object> map) {
        List<Recruiter> posDetail=recruiterMapper.queryPositionDetail(map);
        List<Map<String,Object>> resultList=new ArrayList<>();
        Iterator<Recruiter> it=posDetail.iterator();
        if (it.hasNext()) {
            Recruiter recruiter = it.next();
            Map<String,Object> pmMap=new HashMap<>();
            pmMap.put("name",recruiter.getPositions().get(0).getP_name());
            pmMap.put("address",recruiter.getPositions().get(0).getWorkCity());
            pmMap.put("time",recruiter.getPositions().get(0).getPublicTime());
            pmMap.put("degree",recruiter.getPositions().get(0).getEmployeeType());
            pmMap.put("salary",recruiter.getPositions().get(0).getSalary());
            pmMap.put("degree",recruiter.getPositions().get(0).getXueli());
            pmMap.put("functionType",recruiter.getPositions().get(0).getFunctionType());
            pmMap.put("num",recruiter.getPositions().get(0).getNum());
            pmMap.put("brief",recruiter.getPositions().get(0).getBrief());
            pmMap.put("realName",recruiter.getRealname());
            pmMap.put("pos",recruiter.getPos());
            pmMap.put("company",recruiter.getCompanyName());
            pmMap.put("workType",recruiter.getTrade());
            pmMap.put("tagData",recruiter.getSubsidy());
            resultList.add(pmMap);
        }
        return resultList;
    }

    @Override
    public List<RecruiterPosition> queryPositionInfoByTrade(Map<String,Object> map) {

        List<Recruiter> postListByTrade=recruiterMapper.queryPositionInfoByTrade(map);
        List<RecruiterPosition> resultList=new ArrayList<RecruiterPosition>();
        Iterator<Recruiter> it=postListByTrade.iterator();
        while(it.hasNext()){
            Recruiter recruiter=it.next();
            RecruiterPosition rs=new RecruiterPosition();
            rs.setCompanyName(recruiter.getCompanyName());
            rs.setWorkCity(recruiter.getPositions().get(0).getWorkCity());
            rs.setSubsidy(recruiter.getSubsidy());
            rs.setTrade(recruiter.getTrade());
            rs.setpName(recruiter.getPositions().get(0).getP_name());
            rs.setEmployeeType(recruiter.getPositions().get(0).getEmployeeType());
            rs.setSalary(recruiter.getPositions().get(0).getSalary());
            rs.setDegree(recruiter.getPositions().get(0).getXueli());
            rs.setPublicTime(recruiter.getPositions().get(0).getPublicTime());
            resultList.add(rs);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryPositionByMore(Map<String, Object> map) {
        //获取当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum,pageSize);
        List<Recruiter> pmList=recruiterMapper.queryPositionByMore(map);

        List<Map<String,Object>> resultList=new ArrayList<>();

        Iterator<Recruiter> it=pmList.iterator();
        while(it.hasNext()) {
            Recruiter recruiter = it.next();
            Map<String,Object> pmMap=new HashMap<>();
            pmMap.put("name",recruiter.getPositions().get(0).getP_name());
            pmMap.put("address",recruiter.getPositions().get(0).getWorkCity());
            pmMap.put("time",recruiter.getPositions().get(0).getPublicTime());
            pmMap.put("degree",recruiter.getPositions().get(0).getEmployeeType());
            pmMap.put("salary",recruiter.getPositions().get(0).getSalary());
            pmMap.put("company",recruiter.getCompanyName());
            pmMap.put("workType",recruiter.getTrade());
            pmMap.put("tagData",recruiter.getSubsidy());
            resultList.add(pmMap);
        }

        return resultList;
    }

    //查询职位
    @Override
    public List<RecruiterPosition> queryPositionInfo(Map<String, Object> map) {
        List<Recruiter> posList =recruiterMapper.queryPositionInfo(map);
        List<RecruiterPosition> resultList=new ArrayList<RecruiterPosition>();
        Iterator<Recruiter> it=posList.iterator();
        while(it.hasNext()){
            Recruiter recruiter=it.next();
            RecruiterPosition rs=new RecruiterPosition();
            //System.out.println(recruiter.getCid());
            rs.setCompanyName(recruiter.getCompanyName());
            rs.setWorkCity(recruiter.getPositions().get(0).getWorkCity());
            rs.setSubsidy(recruiter.getSubsidy());
            rs.setTrade(recruiter.getTrade());
            rs.setpName(recruiter.getPositions().get(0).getP_name());
            rs.setEmployeeType(recruiter.getPositions().get(0).getEmployeeType());
            rs.setSalary(recruiter.getPositions().get(0).getSalary());
            rs.setDegree(recruiter.getPositions().get(0).getXueli());
            rs.setPublicTime(recruiter.getPositions().get(0).getPublicTime());
            resultList.add(rs);
        }
        return resultList;
    }

    @Override
    public List<Recruiter> queryRecruiterList(Map<String, Object> map) {
        //获取当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum,pageSize);
        List<Recruiter> recruiterList =recruiterMapper.queryRecruiterList(map);

        PageInfo pageInfo = new PageInfo(recruiterList);

        //long total = pageInfo.getTotal();
        List<Recruiter> resultList=new ArrayList<Recruiter>();
        resultList.addAll(recruiterList);

        return resultList;
    }

    @Override
    public List<Recruiter> queryPositionBycompany(String companyName) {
        return recruiterMapper.queryPositionBycompany(companyName);
    }

    @Override
    public Recruiter login(Map<String, Object> map) {
        return recruiterMapper.login(map);
    }

    @Override
    public Recruiter queryRecruiterByName(String cname) {
        return recruiterMapper.queryRecruiterByName(cname);
    }

    @Override
    public int addRecruiter(Map<String, Object> map) {
        return recruiterMapper.addRecruiter(map);
    }

    @Override
    public void updateRecruiter(Map<String, Object> map) {
        recruiterMapper.updateRecruiter(map);
    }

    @Override
    public void updateRecruiterById(Map<String, Object> map) {
        recruiterMapper.updateRecruiterById(map);
    }

    @Override
    public int delRecruiter(Map<String, Object> map) {
        return recruiterMapper.delRecruiter(map);
    }

    @Override
    public int updateRecruiterPass(Map<String, Object> map) {
        return recruiterMapper.updateRecruiterPass(map);
    }

    @Override
    public Recruiter querydeliver(int pid) {
        System.out.println(recruiterMapper.querydeliver(pid));
        return recruiterMapper.querydeliver(pid);
    }
}
