package com.sly.base.common.root.runtime.demo1;

/**
 * @Author by wj on 2021/5/26 16:43
 * @Description TODO
 */
public class Test1 {

    public static void main(String[] args) {
        //可用处理器的Java虚拟机的数量
        int availableProcessorsCount = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessorsCount);
    }

}
