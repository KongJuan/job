package com.kong.mapper;

import com.kong.model.China;

import java.util.List;
import java.util.Map;

public interface ChinaMapper {
    List<China> queryProvince();
    List<China> queryCity(Map<String,Object> map);

    String placeName(int id);
}
