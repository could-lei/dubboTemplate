package com.cloud.provide.impl;

import com.cloud.cloud.UserIInfoISV;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * version 表示版本号
 * protocol = "dubbo"
 * protocol 表示使用的接口使用的协议
 *不同服务在性能上适用不同协议进行传输，比如大数据用短连接协议，小数据大并发用长连接协议
 * protocol = "dubbo,rmi" 多协议服务暴露
 * registry 注册注册中心
 * registry="test1,test2" 表示向两个注册中心注册服务
 * group="组号" 使用服务分组区分服务接口的不同实现
 * dynamic 设置一段服务的动态管理模式 人工进行一段服务的上线和下线
 * cache
 * 参数：lru 最近最少使用算法
 *      threadlocal 当前线程缓存，比如一个页面渲染，用到很多portal，每个portal都要去
 *      查用户的消息，通过线程缓存，可以减少这种多余访问
 *      jcache 与 JSR107 集成，可以桥接各种缓存实现
 */
@Service(version="1.0.0",protocol = "dubbo",registry = "test1",group = "group1",dynamic = false,cache = "lru")
public class UserIInfoISVimpl implements UserIInfoISV {
//    @Cacheable(cacheNames = "lru")
    @Override
    public String sayHello() {
        System.out.println("******provider访问成功******");
        return "hello dubbo";
    }
}
