package com.kong.service;

import com.kong.model.JobSeeker;

import java.util.Map;

public interface ICollectionService {

    JobSeeker queryCollectPosition(int userId);

    //添加收藏的职位
    int addCollectPosition(Map<String, Object> map);

    //删除收藏的职位
    int delCollectPosition(Map<String,Integer> map);

}
