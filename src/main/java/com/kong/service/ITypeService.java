package com.kong.service;

import com.kong.model.Type;

import java.util.List;

public interface ITypeService {

    String queryCompanyTypeName(String code);
    String queryFunctionTypeName(String code);
    String queryWorkCharacterName(String code);
    String queryWorkTypeName(String code);


    List<Type> queryCompanyType();
    List<Type> queryFunctionType();
    List<Type> queryWorkCharacter();
    List<Type> queryWorkType();
}
