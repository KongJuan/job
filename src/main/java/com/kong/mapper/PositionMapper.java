package com.kong.mapper;

import com.kong.model.Position;

import java.util.List;
import java.util.Map;

public interface PositionMapper {

    //查询个人发布职位列表
    List<Position> queryPersonalPosition(Map<String, Object> map);

    //查询职位Id
    List<Integer> queryPositionId(int publicId);

    //根据id查询
    Position queryPositionInfo(Map<String, Object> map);

    //新增岗位
    int addPosition(Map<String,Object> map);


    //根据岗位id更新岗位信息
    int updatePositionById(Map<String,Object> map);

    //删除岗位
    int delPosition(Map<String,Object> map);

}
