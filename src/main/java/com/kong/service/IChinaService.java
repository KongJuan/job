package com.kong.service;

import com.kong.model.China;

import java.util.List;
import java.util.Map;

public interface IChinaService {

    List<China> queryProvince();
    List<China> queryCity(Map<String,Object> map);
    String placeName(int id);
}
