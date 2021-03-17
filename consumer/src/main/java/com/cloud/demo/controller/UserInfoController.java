package com.cloud.demo.controller;

import com.cloud.cloud.UserIInfoISV;
import com.cloud.cloud.ValidationService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    //@Reference(version = "1.0.0",url="dubbo://127.0.0.1:12345") retries=2 表示失败快速切换，用于读操作
    //cluster = "failfast" 表示快速执行失败
    //,loadbalance = "roundrobin" 表示负载均衡策略
    /**
     * version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
     * @Reference(version = "1.0.0",url="dubbo://127.0.0.1:12345") retries=2 表示失败快速切换，用于读操作
     * cluster = "failfast" 表示快速执行失败
     * ,loadbalance = "roundrobin" 表示负载均衡策略
     * registry=“test1” 表示引用test1注册中心的服务
     * registry=“test1，test2” 表示引用多个test1 test2 注册中心的服务
     */
    @Reference(version = "1.0.0",cluster = "failfast" ,loadbalance = "roundrobin",registry = "test1",group = "group1")
    private UserIInfoISV userInfoISV;
    /**
     * 开启参数验证
     */
    @Reference(version = "1.0.0",cluster = "failfast" ,validation = "true",registry = "test1",group = "group1")
    private ValidationService validationService;
    @GetMapping("/hello")
    public String sayHello (){
        System.out.println("******consumer访问成功******");
//        System.out.println(userInfoISV.sayHello());
        return userInfoISV.sayHello();
    }

}
