package com.anzhi.solidwaste.common.domain;

import com.anzhi.solidwaste.common.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author andy
 * @date 2019/7/1 14:11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActiveUser implements Serializable {


    /**
     *  唯一编号
     */
    private String id = RandomStringUtils.randomAlphanumeric(20);

    /**
     *  账号
     */
    private String account;

    /**
     *  ip
     */
    private String ip;

    /**
     *  token
     */
    private String token;

    /**
     *  登录时间
     */
    private String loginTime = DateUtil.formatFullTime(LocalDateTime.now(),DateUtil.FULL_TIME_SPLIT_PATTERN);

    /**
     *  登录地点
     */
    private String loginAddress;

}
