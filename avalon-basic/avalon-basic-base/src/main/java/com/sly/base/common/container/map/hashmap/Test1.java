package com.sly.base.common.container.map.hashmap;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @Created by wj on 2021/5/28
 * @Description TODO
 */
public class Test1 {

    /**
     * test putIfAbsent
     */
    public static void test1(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.putIfAbsent("1", 2));
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.putIfAbsent("2", 2));
        System.out.println(JSON.toJSONString(map));
    }

    public static int rand100(){
        return (int) (Math.random() * 100);
    }

    public static void test2(){
        Map<String, List<UserInfo>> map = new HashMap<>();
        for(int i = 0; i < 5; i++){
            List<UserInfo> userInfos = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                //userInfos.add(new UserInfo("n" + i + j, rand100()));
                userInfos.add(new UserInfo(null, rand100()));
            }
            if(i==0){
                map.put(null, userInfos);
            } else {
                map.put("s" + i, userInfos);
            }
        }
        System.out.println(JSON.toJSONString(map));
        for(Map.Entry<String, List<UserInfo>> entry : map.entrySet()){
            //升序
            //entry.getValue().sort(Comparator.comparing(UserInfo::getAge));
            //降序
            entry.getValue().sort(Comparator.comparing(UserInfo::getName).reversed());
        }
        System.out.println(JSON.toJSONString(map));
    }

    public static void main(String[] args) {
        //test1();
        test2();
    }


}


class UserInfo{

    private String name;
    private int age;

    public UserInfo(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
