package com.anzhi.solidwaste.common.domain;

/**
 * @author andy
 * @date 2019/7/1 18:33
 */
public class RegexpConstant {

    // 手机号正则
    public static final String MOBILE_REG =  "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";


    // 身份证号正则
    public static final String IDENTITY_REG = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";


    //经纬度
    public static final String LONGITUDE = "((?:[0-9]|[1-9][0-9]|1[0-7][0-9])\\.([0-9]{0,6}))|((?:180)\\.([0]{0,6}))";
    public static final String LATITUDE  = "((?:[0-9]|[1-8][0-9])\\.([0-9]{0,6}))|((?:90)\\.([0]{0,6}))";
}
