package com.stephenJun.rpc.client;

import com.stephenJun.rpc.client.proxy.ClientProxy;
import com.stephenJun.rpc.common.pojo.User;
import com.stephenJun.rpc.common.service.UserService;

/**
 * @author 严文骏
 */
public class TestClient {
    public static void main(String[] args) {
        ClientProxy clientProxy=new ClientProxy("127.0.0.1",9999,0);
        UserService proxy=clientProxy.getProxy(UserService.class);

        User user = proxy.getUserByUserId(1);
        System.out.println("从服务端得到的user="+user.toString());

        User u=User.builder().id(100).userName("ywj").sex(true).build();
        Integer id = proxy.insertUserId(u);
        System.out.println("向服务端插入user的id"+id);
    }
}
