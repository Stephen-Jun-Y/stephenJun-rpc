package com.stephenJun.rpc.client.serviceCenter;

import java.net.InetSocketAddress;

/**
 * 服务中心接口
 *
 * @author 严文骏
 */
public interface ServiceCenter {
    //  查询：根据服务名查找地址
    InetSocketAddress serviceDiscovery(String serviceName);
}
