package com.stephenJun.rpc.server;


import com.stephenJun.rpc.common.service.UserService;
import com.stephenJun.rpc.common.service.impl.UserServiceImpl;
import com.stephenJun.rpc.server.provider.ServiceProvider;
import com.stephenJun.rpc.server.rpcServer.RpcServer;
import com.stephenJun.rpc.server.rpcServer.impl.NettyRPCRPCServer;

/**
 * @author 严文骏
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();

        ServiceProvider serviceProvider=new ServiceProvider("127.0.0.1",9999);
        serviceProvider.provideServiceInterface(userService);

        RpcServer rpcServer=new NettyRPCRPCServer(serviceProvider);
        rpcServer.start(9999);
    }
}
