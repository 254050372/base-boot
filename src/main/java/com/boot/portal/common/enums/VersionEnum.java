package com.boot.portal.common.enums;/**
 * @description
 * @autor xbwu on 2017/8/17.
 */

/**
 * 版本控制
 * @author xbwu
 * @create 2017-08-17 
 **/
public enum VersionEnum {
    V1(1,"v1");

    private int code;
    private String name;
    VersionEnum(int code,String name){
        this.code=code;
        this.name=name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCurrentVersion(){
        return V1.getName();
    }
}
