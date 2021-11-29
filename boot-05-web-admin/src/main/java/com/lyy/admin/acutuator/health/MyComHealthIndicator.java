package com.lyy.admin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: boot-05-web-admin
 * @description:定制健康信息
 * @author: ly
 * @create: 2021-11-29 16:13
 **/
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb  获取连接进行测试
        Map<String,Object> map=new HashMap<>();
        //检查完成
        if (1==1){
//            builder.up();//健康状态
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",100);
        }
        else {
//            builder.down(); //不健康
            builder.status(Status.DOWN);
            map.put("error","连接超时");
            map.put("ms",3000);
        }
        builder.withDetail("code",100).withDetails(map);
    }
}
