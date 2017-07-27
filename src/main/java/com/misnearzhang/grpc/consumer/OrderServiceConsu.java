package com.misnearzhang.grpc.consumer;

import com.misnearzhang.grpc.config.annotation.GRpcClient;
import grpcstart.RpcServiceGrpc;
import grpcstart.proto;
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
        /*private final ManagedChannel channel;
        private final RpcServiceGrpc.RpcServiceBlockingStub blockingStub;


        public OrderServiceConsu(String host,int port){
            channel = ManagedChannelBuilder.forAddress(host,port)
                    .usePlaintext(true)
                    .build();

            blockingStub = RpcServiceGrpc.newBlockingStub(channel);
        }


        public void shutdown() throws InterruptedException {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }*/

        public  String hello(String name){
            proto.Request request = proto.Request .newBuilder().setData(name).build();
            proto.Response response = blockingStub.getUserDate(request);
            return response.getStatus()== proto.status.OK?"OK":"err";

        }

        /*public static void main(String[] args) throws InterruptedException {
            OrderServiceConsu client = new OrderServiceConsu("127.0.0.1",3000);
            for(int i=0;i<5;i++){
                client.hello("xcnana  这里是客户端调用请求:"+i);
            }


        }*/
    }
