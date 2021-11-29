package com.lyy.admin.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-29 16:44
 **/
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {
    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("dockerINfo","docker started......");
    }
    @WriteOperation
    public void stopDocker(){
        System.out.println("doucker stopped......");
    }
}
