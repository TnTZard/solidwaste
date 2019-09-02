package com.anzhi.solidwaste.common.study;

/**
 * @author anzhi
 * @date 2019/9/2 11:37
 */
public class GenericInterfaceImpl<String> implements GenericInterface<String> {

    @Override
    public void show(String o) {
        System.out.println("泛型接口实现类 ： " + o);
    }

}
