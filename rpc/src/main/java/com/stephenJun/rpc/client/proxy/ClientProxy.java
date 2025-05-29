package com.stephenJun.rpc.client.proxy;

import com.stephenJun.rpc.client.rpcClient.RpcClient;
import com.stephenJun.rpc.client.rpcClient.impl.NettyRpcClient;
import com.stephenJun.rpc.client.rpcClient.impl.SimpleSocketRpcCilent;
import com.stephenJun.rpc.common.message.RpcRequest;
import com.stephenJun.rpc.common.message.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 传入参数service接口的class对象，反射封装成一个request
 *
 * @author 严文骏
 */
public class ClientProxy implements InvocationHandler {
    private RpcClient rpcClient;

    public ClientProxy(){
        rpcClient=new NettyRpcClient();
    }

    //jdk动态代理，每一次代理对象调用方法，都会经过此方法增强（反射获取request对象，socket发送到服务端）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //构建request
        RpcRequest request=RpcRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsType(method.getParameterTypes()).build();
        //数据传输
        RpcResponse response= rpcClient.sendRequest(request);
        return response.getData();
    }
    public <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }
}
