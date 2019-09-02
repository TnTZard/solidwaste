package com.anzhi.solidwaste.common.study;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/2 11:40
 */
public class GenericDemo2 {


    class Base{}

    class Sub extends Base{}

    public void test() {
        // 继承关系
        Sub sub = new Sub();
        Base base = sub;


        List<Sub> subs = new ArrayList<>();
        // 编译器是不会让下面这行代码通过的，
        // 因为 Sub 是 Base 的子类，不代表 List<Sub>和 List<Base>有继承关系。
        // List<Base> bases = subs;
    }


    /**
     * 在现实编码中，确实有这样的需求，希望泛型能够处理某一范围内的数据类型，比如某个类和它的子类，对此 Java 引入了通配符这个概念。
     *
     * 所以，通配符的出现是为了指定泛型中的类型范围。
     *
     * 通配符有 3 种形式。
     *
     * <?>被称作无限定的通配符
     * <? extends T>被称作有上限的通配符
     * <? super T>被称作有下限的通配符
     */


}
