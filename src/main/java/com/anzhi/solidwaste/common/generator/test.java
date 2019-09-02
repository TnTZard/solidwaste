package com.anzhi.solidwaste.common.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anzhi
 * @date 2019/8/29 17:12
 */
public class test {



    class AutoMobile {

    }

    class Holder1 {
        private AutoMobile a;
        public Holder1(AutoMobile a) {
            this.a = a;
        }
        // ~~
    }

    class Holder2 {
        private Object a;

        public Holder2(Object a) {
            this.a = a;
        }

        public Object getA(){
            return a;
        }

        public void setA(Object a) {
            this.a = a;
        }
    }



    public static void main(String[] args) {
        StringBuffer pwd = new StringBuffer("15122833571");
        pwd.substring(7);
        System.out.println(pwd.substring(7));

        List<String> strList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        System.out.println("------------------------------------------");
        System.out.println( strList.getClass() == integerList.getClass());







    }


}
