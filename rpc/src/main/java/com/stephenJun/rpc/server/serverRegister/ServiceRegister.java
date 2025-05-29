package com.stephenJun.rpc.server.serverRegister;

import java.net.InetSocketAddress;

/**
 * 服务注册接口
 * 用于将服务名和对应的地址进行注册
 * @author 严文骏
 */
// 服务注册接口
public interface ServiceRegister {
    //  注册：保存服务与地址。
    void register(String serviceName, InetSocketAddress serviceAddress);

}