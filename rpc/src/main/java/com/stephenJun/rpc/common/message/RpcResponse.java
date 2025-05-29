package com.stephenJun.rpc.common.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 定义响应消息格式
 *
 * @author 严文骏
 */
@Data
@Builder
public class RpcResponse implements Serializable {
    //状态信息
    private int code;
    private String message;
    //具体数据
    private Object data;

    public static RpcResponse sussess(Object data){
        return RpcResponse.builder().code(200).data(data).build();
    }
    public static RpcResponse fail(){
        return RpcResponse.builder().code(500).message("服务器发生错误").build();
    }

}
