package com.kong.mapper;

import com.kong.model.JobSeeker;

import java.util.Map;

public interface CollectionMapper {

    //查询收藏列表
    JobSeeker queryCollectPosition(int userId);

    //添加收藏的职位
    int addCollectPosition(Map<String, Object> map);

    //删除收藏的职位
    int delCollectPosition(Map<String,Integer> map);
}
