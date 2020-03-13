package com.kong.service.impl;

import com.kong.mapper.ResumeHandleMapper;
import com.kong.model.Position;
import com.kong.service.IResumeHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResumeHandleServiceImpl implements IResumeHandleService {

    @Autowired
    private ResumeHandleMapper resumeHandleMapper;
    @Override
    public List<Position> searchDeliver(Map<String,Object> map) {
        return resumeHandleMapper.searchDeliver(map);
    }

    @Override
    public String selectDeliverDate(int pid, int rid) {
        return resumeHandleMapper.selectDeliverDate(pid,rid);
    }

    @Override
    public int verifyResume(Map<String, Object> map) {
        return resumeHandleMapper.verifyResume(map);
    }

    @Override
    public List<Position> queryInterview(Map<String, Object> map) {
        return resumeHandleMapper.queryInterview(map);
    }

    @Override
    public Map<String,Object> queryInterviewState(int pid, int rid) {
        return resumeHandleMapper.queryInterviewState(pid,rid);
    }
}
