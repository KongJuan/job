package com.kong.common;

import com.kong.model.ResponseBody;



/**
 * @ClassName AssembleResponseMsg
 * @Description TODO  封装ResponseBody内容
 * @Author AZhen
 * Version 1.0
 **/
public class AssembleResponseMsg {

    /**
     * 成功返回内容
     * @Author AZhen
     * @Param [data]
     * @return com.wzz.model.ResponseBody
     **/
    public <T>ResponseBody success(T data){
       /* ResponseBody<T> resp=new ResponseBody<T>();
        resp.setData(data);
        InfoMsg info=new InfoMsg();
        resp.setInfo(info);
        return resp;*/
       return null;
    }

    /**
     * 失败/异常返回内容
     * @Author AZhen
     * @Param [status, errorCode, message]
     * @return com.wzz.model.ResponseBody
     **/
    public <T>ResponseBody failure(int status,String errorCode,String message){
        /*ResponseBody<T> resp=new ResponseBody<T>();
        resp.setStatus(status);
        InfoMsg info=new InfoMsg();
        info.setCode(errorCode);
        info.setMessage(message);
        resp.setInfo(info);
        return resp;*/
        return null;
    }
}
