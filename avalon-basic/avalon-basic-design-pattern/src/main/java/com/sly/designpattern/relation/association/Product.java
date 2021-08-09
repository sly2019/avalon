package com.sly.designpattern.relation.association;

import lombok.Data;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
@Data
public class Product {

    private String name;
    private Customer customer;

}
