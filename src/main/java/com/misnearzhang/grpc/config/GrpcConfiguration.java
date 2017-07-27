package com.misnearzhang.grpc.config;

import com.misnearzhang.grpc.config.annotation.GRpcClient;
import grpcstart.RpcServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>
 *  rpc server连接配置
 * </p>
 *
 * @author wangxiaohu
 * @since 2017-05-08
 */

@Configuration
@EnableAutoConfiguration
public class GrpcConfiguration {
    @GRpcClient("grpc-server")
    private  ManagedChannel channel;

    @Bean
    public RpcServiceGrpc.RpcServiceBlockingStub blockingStub() {
        return RpcServiceGrpc.newBlockingStub(channel);
    }

}