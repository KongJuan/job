package com.kong.service.impl;

import com.kong.mapper.CollectionMapper;
import com.kong.model.JobSeeker;
import com.kong.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CollectionServiceImpl implements ICollectionService {


    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public JobSeeker queryCollectPosition(int userId) {
        return collectionMapper.queryCollectPosition(userId);
    }

    @Override
    public int addCollectPosition(Map<String, Object> map) {
        return collectionMapper.addCollectPosition(map);
    }

    @Override
    public int delCollectPosition(Map<String,Integer> map) {
        return collectionMapper.delCollectPosition(map);
    }

}
