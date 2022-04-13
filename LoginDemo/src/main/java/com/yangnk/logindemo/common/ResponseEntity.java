package com.yangnk.logindemo.common;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-01-03 上午10:45
 **/
public class ResponseEntity<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseEntity(int status){
        this.status = status;
    }
    private ResponseEntity(int status, T data){
        this.status = status;
        this.data = data;
    }

    private ResponseEntity(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResponseEntity(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ResponseEntity<T> createBySuccess(){
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseEntity<T> createBySuccessMessage(String msg){
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResponseEntity<T> createBySuccess(T data){
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResponseEntity<T> createBySuccess(String msg, T data){
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> ResponseEntity<T> createByError(){
        return new ResponseEntity<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ResponseEntity<T> createByErrorMessage(String errorMessage){
        return new ResponseEntity<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResponseEntity<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ResponseEntity<T>(errorCode,errorMessage);
    }
}
