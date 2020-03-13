package com.kong.service;

import com.kong.model.Position;

import java.util.List;
import java.util.Map;

public interface IPositionService {

    //查询所有列表
    List<Position> queryPersonalPosition(Map<String, Object> map);

    //查询职位Id
    List<Integer> queryPositionId(int publicId);

    //根据id查询
    Position queryPositionInfo(Map<String, Object> map);

    //新增岗位
    int addPosition(Map<String,Object> map);

    //更加岗位id更新岗位信息
    int updatePositionById(Map<String,Object> map);

    //删除岗位
    int delPosition(Map<String,Object> map);
}
