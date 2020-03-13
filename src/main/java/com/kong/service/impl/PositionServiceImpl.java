package com.kong.service.impl;

import com.github.pagehelper.PageHelper;
import com.kong.mapper.PositionMapper;
import com.kong.model.Position;
import com.kong.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private PositionMapper positionMapper;

   @Override
    public List<Position> queryPersonalPosition(Map<String, Object> map) {
        //获取当前页
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        //每页几条记录
        int pageSize = Integer.parseInt(map.get("pageSize").toString());

        PageHelper.startPage(pageNum,pageSize);

        List<Position> positionList = positionMapper.queryPersonalPosition(map);

        return positionList;
    }

    @Override
    public List<Integer> queryPositionId(int publicId) {
        return positionMapper.queryPositionId(publicId);
    }

    @Override
    public Position queryPositionInfo(Map<String, Object> map) {
        return positionMapper.queryPositionInfo(map);
    }

    @Override
    public int addPosition(Map<String, Object> map) {
        return positionMapper.addPosition(map);
    }

    @Override
    public int updatePositionById(Map<String, Object> map) {
        return positionMapper.updatePositionById(map);
    }

    @Override
    public int delPosition(Map<String, Object> map) {
        return positionMapper.delPosition(map);
    }
}
