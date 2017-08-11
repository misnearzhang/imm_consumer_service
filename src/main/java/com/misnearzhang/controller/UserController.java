package com.misnearzhang.controller;

import com.misnearzhang.grpc.consumer.OrderServiceConsu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhanglong on 2017/7/24.
 */
@RestController
public class UserController {

    @Autowired
    OrderServiceConsu orderServiceConsu;


    @RequestMapping("/")
    public Object get(){
        return orderServiceConsu.getUserInfo("nihk");
    }

    @RequestMapping("/make-order")
    public Object makeOrder(){
        return orderServiceConsu.makeOrder();
    }
}
