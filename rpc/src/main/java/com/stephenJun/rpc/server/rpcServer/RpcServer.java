package com.stephenJun.rpc.server.rpcServer;

/**
 * @author 严文骏
 */
public interface RpcServer {
    void start(int port);
    void stop();
}
