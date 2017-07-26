package com.misnearzhang.grpc.consumer;

import grpcstart.RpcServiceGrpc;
import grpcstart.proto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
/**
 * Hello world!
 *
 */
public class OrderServiceConsu {
        private final ManagedChannel channel;
        private final RpcServiceGrpc.RpcServiceBlockingStub blockingStub;


        public OrderServiceConsu(String host,int port){
            channel = ManagedChannelBuilder.forAddress(host,port)
                    .usePlaintext(true)
                    .build();

            blockingStub = RpcServiceGrpc.newBlockingStub(channel);
        }


        public void shutdown() throws InterruptedException {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }

        public  void hello(String name){
            proto.Request request = proto.Request .newBuilder().setData("hello").build();
            proto.Response response = blockingStub.getUserDate(request);
            System.out.println(response.getStatus());

        }

        public static void main(String[] args) throws InterruptedException {
            OrderServiceConsu client = new OrderServiceConsu("127.0.0.1",3000);
            for(int i=0;i<5;i++){
                client.hello("xcnana  这里是客户端调用请求:"+i);
            }


        }
    }
