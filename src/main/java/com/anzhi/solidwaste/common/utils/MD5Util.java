package com.anzhi.solidwaste.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description  散列算法 生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据.
 * @author anzhi
 * @date 2019/9/2 13:43
 */
public class MD5Util {

    protected MD5Util(){}

    public static final String ALGORITH_NAME = "md5";

    public static final int HASH_ITERATIONS = 2;

    public static String encrypt(String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(password), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String account, String password) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(account.toLowerCase() + password), HASH_ITERATIONS).toHex();
    }
}
