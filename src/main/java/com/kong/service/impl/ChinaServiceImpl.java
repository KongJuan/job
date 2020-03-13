package com.kong.service.impl;

import com.kong.mapper.ChinaMapper;
import com.kong.model.China;
import com.kong.service.IChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChinaServiceImpl implements IChinaService {

    @Autowired
    private ChinaMapper chinaMapper;

    @Override
    public List<China> queryProvince() {
        return chinaMapper.queryProvince();
    }

    @Override
    public List<China> queryCity(Map<String, Object> map) {
        return chinaMapper.queryCity(map);
    }

    @Override
    public String placeName(int id) {
        return chinaMapper.placeName(id);
    }
}
