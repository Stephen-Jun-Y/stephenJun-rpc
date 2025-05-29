# stephenJun-rpc
基于Netty与Zookeeper的轻量级RPC框架

## RPC概念

### 概念

1. RPC（Remote Procedure Call Protocol） 远程过程调用协议。
2. RPC是一种通过网络从远程计算机程序上请求服务，不需要了解底层网络技术的协议。
3. RPC主要作用就是不同的服务间方法调用就像本地调用一样便捷。

## 特性
- 基于Netty实现高效网络通信：
  - netty是一个nio（同步非阻塞）框架，提供了异步事件驱动的网络应用程序框架和工具。 主要的核心概念有eventloop，eventloopgroup，channel，handler
- 使用Zookeeper实现服务注册与发现：
  - 讲服务端的服务注册至zookeeper，客户端去zookeeper调用服务。zookeeper客户端的服务发现和注册伴随rpc客户端与rpc服务端的启动和关闭。生命周期我认为是随着channel一样的
- 支持动态代理调用远程服务：
  - 使用jdk动态代理实现远程服务调用，客户端通过代理对象调用远程服务方法，底层会将方法调用转换为网络请求。
- 客户端与服务端通过zookeeper的心跳机制保持连接

## 快速开始

### 启动服务端
```java
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 9999);
        serviceProvider.provideServiceInterface(userService);
        RpcServer rpcServer = new NettyRPCRPCServer(serviceProvider);
        rpcServer.start(9999);
    }
}
```
### 架构图
```plaintext
+---------------+       +---------------+       +---------------+
|   Client      |       |   Zookeeper   |       |   Server       |
|---------------|       |---------------|       |---------------|
|  DynamicProxy |<----->| ServiceCenter |<----->| ServiceRegister|
|  NettyClient  |       | (Discovery)   |       |                |
+---------------+       +---------------+       +---------------+
        ↓                                               ↑
        +---------------Netty通信------------------------+
```