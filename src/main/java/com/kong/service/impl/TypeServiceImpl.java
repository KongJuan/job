package com.kong.service.impl;

import com.kong.mapper.TypeMapper;
import com.kong.model.Type;
import com.kong.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public String queryCompanyTypeName(String code) {
        return typeMapper.queryCompanyTypeName(code);
    }

    @Override
    public String queryFunctionTypeName(String code) {
        return typeMapper.queryFunctionTypeName(code);
    }

    @Override
    public String queryWorkCharacterName(String code) {
        return typeMapper.queryWorkCharacterName(code);
    }

    @Override
    public String queryWorkTypeName(String code) {
        return typeMapper.queryWorkTypeName(code);
    }

    @Override
    public List<Type> queryCompanyType() {
        return typeMapper.queryCompanyType();
    }

    @Override
    public List<Type> queryFunctionType() {
        return typeMapper.queryFunctionType();
    }

    @Override
    public List<Type> queryWorkCharacter() {
        return typeMapper.queryWorkCharacter();
    }

    @Override
    public List<Type> queryWorkType() {
        return typeMapper.queryWorkType();
    }
}
