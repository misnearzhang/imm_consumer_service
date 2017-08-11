package com.misnearzhang.grpc.consumer;

import com.misnearzhang.common.grpcdl.RpcServiceGrpc;
import com.misnearzhang.common.grpcdl.proto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Hello world!
 *
 */

@Service
public class OrderServiceConsu {
    @Autowired
    private RpcServiceGrpc.RpcServiceBlockingStub blockingStub;

        public  String getUserInfo(String name){
            proto.Request request = proto.Request .newBuilder().setData(name).build();
            proto.Response response = blockingStub.getUserDate(request);
            return response.getStatus()== proto.status.OK?response.getData():"err";

        }

        public String makeOrder(){
            proto.Request request =  proto.Request.newBuilder().setId(1).setTime(System.currentTimeMillis()).setData("zhanglong grpc request").build();
            proto.Response response = blockingStub.makeOrder(request);
            return "successful!";
        }
    }
