package com.stephenJun.rpc.client.rpcClient;

import com.stephenJun.rpc.common.message.RpcRequest;
import com.stephenJun.rpc.common.message.RpcResponse;

/**
 * @author 严文骏
 */
public interface RpcClient {
    //定义底层通信的方法
    RpcResponse sendRequest(RpcRequest request);
}
