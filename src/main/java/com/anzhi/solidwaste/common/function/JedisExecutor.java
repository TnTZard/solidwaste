package com.anzhi.solidwaste.common.function;


import com.anzhi.solidwaste.common.exception.RedisConnectException;

/**
 *
 * @author andy
 * @date 2019/7/1 14:54
 */
@FunctionalInterface
public interface JedisExecutor<T,R> {

    /**
     * @description
     * @param t
     * @return
     * @throws RedisConnectException
     */
    R excute(T t) throws RedisConnectException;
}
