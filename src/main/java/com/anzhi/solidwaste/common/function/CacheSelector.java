package com.anzhi.solidwaste.common.function;

/**
 * @author andy
 * @date 2019/7/1 9:17
 */
@FunctionalInterface
public interface CacheSelector<T> {

    /**
     *
     *
     * @param null
     * @return 泛型T
     * @throws Exception
     */
    T select() throws Exception;


}
