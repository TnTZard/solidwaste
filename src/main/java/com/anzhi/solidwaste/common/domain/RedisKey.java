package com.anzhi.solidwaste.common.domain;

import lombok.Data;

/**
 * redis的key储存
 */
@Data
public class RedisKey {

    /**
     * 水域管理站点新增所有企业
     */
    public static final String pollutants = "pollutants";
    /**
     * 所有站点的名称集合
     */
    public static final String stationname = "stationname";
    /**
     * 所有站点的编号集合
     */
    public static final String stationNumbering = "stationNumbering";
    /**
     * 行业类型
     */
    public static final String sourceType = "sourceType";
    /**
     * 所有企业的名称集合
     */
    public static final String pollutantName = "pollutantName";
    /**
     * 所有企业的编号集合
     */
    public static final String pollutantNumbering = "pollutantNumbering";
    /**
     * 备件耗材类型
     */
    public static final String consumableType = "consumableType";
    /**
     * 站点与管理员管理集合
     */
    public static final String stationManagerUser = "stationManagerUser";

    /**
     * 记录预警id和预警短信推送的时间
     */
    public static final String warningAndTime = "warningAndTime";

}
