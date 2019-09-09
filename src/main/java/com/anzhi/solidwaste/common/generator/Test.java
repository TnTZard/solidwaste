package com.anzhi.solidwaste.common.generator;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anzhi
 * @date 2019/8/29 17:12
 */

public class Test {




    public static void main(String[] args) {

        //testUrl("http://www.baidu.com");
        //最好使用下面这个，上面那个超时时间不定，所以可能会导致卡住的情况
        testUrlWithTimeOut("http://www.szzfcg.cn/home/1/indexca.jsp", 2000);
        testUrlWithTimeOut("http://www.baidu.com", 2000);
        testUrlWithTimeOut("http://cgzx.sz.gov.cn/", 2000);
    }


    public static boolean testUrl(String urlString){

        long lo = System.currentTimeMillis();
        URL url;
        try {
            url = new URL(urlString);
            InputStream in = url.openStream();
            System.out.println("连接可用");
            System.out.println(System.currentTimeMillis()-lo);
            return true;
        } catch (Exception e1) {
            System.out.println("连接打不开!");
            url = null;
            System.out.println(System.currentTimeMillis()-lo);
            return false;
        }


    }

    public static boolean testUrlWithTimeOut(String urlString,int timeOutMillSeconds){
        long lo = System.currentTimeMillis();
        URL url;
        try {
            url = new URL(urlString);
            URLConnection co =  url.openConnection();
            co.setConnectTimeout(timeOutMillSeconds);
            co.connect();
            System.out.println("连接可用");
            System.out.println(System.currentTimeMillis()-lo);
            return true;
        } catch (Exception e1) {
            System.out.println("连接打不开!");
            url = null;
            System.out.println(System.currentTimeMillis()-lo);
            return false;
        }

    }

}
