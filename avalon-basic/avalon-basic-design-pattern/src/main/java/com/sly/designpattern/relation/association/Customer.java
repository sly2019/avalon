package com.sly.designpattern.relation.association;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
@Data
public class Customer {

    private List<Product> products = new ArrayList<>();
    private Address address;
    private String name;

    public void buyProducts(Product product){
        if(!CollectionUtils.isEmpty(products)){
            for(Product item : products){
                if(!StringUtils.isEmpty(item.getName())){
                    System.out.println(item.getName() + "已存在");
                    return;
                }
            }
        }
        product.setCustomer(this);
        products.add(product);
    }

    public void hasProducts(){

    }

}
