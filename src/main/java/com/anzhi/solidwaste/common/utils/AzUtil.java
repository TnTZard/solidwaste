package com.anzhi.solidwaste.common.utils;

import com.anzhi.solidwaste.common.domain.AzConstant;
import com.anzhi.solidwaste.common.function.CacheSelector;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author andy
 * @date 2019/7/1 9:18
 */
@Slf4j
public class AzUtil {


    /**
     * 缓存查询模板
     *
     * @param cacheSelector    查询缓存的方法
     * @param databaseSelector 数据库查询方法
     * @return T
     */
    public static <T> T selctCacheByTenplate(CacheSelector<T> cacheSelector, Supplier<T> databaseSelector){
        try {
            log.debug("query data from redis ......");
            T t = cacheSelector.select();
            if(t == null){
                return databaseSelector.get();
            }else{
                return t;
            }
        } catch (Exception e){
            //缓存查询出错，则去数据库查询
            log.error("redis error:", e);
            log.debug("query data from database ......");
            return databaseSelector.get();
        }
    }

    /**
     * 加密token
     * @param token
     * @return
     */
    public static String encryptToken(String token) {
        try{
            EncryptUtil encryptUtil = new EncryptUtil(AzConstant.TOKEN_CACHE_PREFIX);
            return encryptUtil.encrypt(token);
        } catch (Exception e){
            log.info("token加密失败",e);
            return null;
        }
    }

    /**
     * 解密token
     * @param encryptToken
     * @return
     */
    public static String decryptToken(String encryptToken){
        try{
            EncryptUtil encryptUtil = new EncryptUtil(AzConstant.TOKEN_CACHE_PREFIX);
            return encryptUtil.decrypt(encryptToken);
        } catch (Exception e){
            log.info("token解密失败",e);
            return null;
        }
    }

    /**
     * 驼峰转下划线
     * @param value 待转换值
     * @return 结果
     */
    public static String camelToUnderscore(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        String[] arr = StringUtils.splitByCharacterTypeCamelCase(value);
        if (arr.length == 0) {
            return value;
        }
        StringBuilder result = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            if (i != arr.length - 1) {
                result.append(arr[i]).append(StringPool.UNDERSCORE);
            }
            else {
                result.append(arr[i]);
            }
        });
        return StringUtils.lowerCase(result.toString());
    }



}
