package com.sly.designpattern.pattern.observer.demo2;

import io.reactivex.Observable;

/**
 * @Created by wj on 2021/5/26
 * @Description TODO
 */
public class Test1 {

    public static void main(String[] args) {
        Observable<Object> observable = Observable.create(os -> {
            double rd = Math.random();
            System.out.println(rd);
            if(rd < 0.5){
                os.onNext(0);
            } else {
                os.onNext(1);
            }
            os.onComplete();
        });
        System.out.println("1");
        observable.subscribe(r -> System.out.println(r + ",1"));
        System.out.println("2");
        observable.subscribe(r -> System.out.println(r + ",2"));
        System.out.println("3");
        observable.subscribe(r -> System.out.println(r + ",3"));
    }

}
