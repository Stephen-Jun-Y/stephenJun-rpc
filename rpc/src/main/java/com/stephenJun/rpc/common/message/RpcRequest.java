package com.stephenJun.rpc.common.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 定义发送消息格式
 *
 * @author 严文骏
 */
@Data
@Builder
public class RpcRequest implements Serializable {
    //服务类名，客户端只知道接口
    private String interfaceName;
    //调用的方法名
    private String methodName;
    //参数列表
    private Object[] params;
    //参数类型
    private Class<?>[] paramsType;
}
