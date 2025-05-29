package com.stephenJun.rpc.common.service;

import com.stephenJun.rpc.common.pojo.User;

/**
 * @author 严文骏
 */
public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);
    //新增一个功能
    Integer insertUserId(User user);
}
