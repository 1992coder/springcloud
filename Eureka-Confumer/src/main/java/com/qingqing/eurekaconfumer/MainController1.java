package com.qingqing.eurekaconfumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class MainController1 {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    public RestTemplate restTemplate;


    @GetMapping("/client6")
    public Map<String,String> client6(){
        String url = "http://provider/getMap";
        Map<String,String> map = restTemplate.getForObject(url,Map.class);
        System.out.println(map);
        return map;
    }


    @GetMapping("/client7")
    public Object client7(){
        String url = "http://provider/getObj";
        Person person = restTemplate.getForObject(url,Person.class);
        return person;
    }

    @GetMapping("/client8")
    public Object client8(){
        String url ="http://provider/getObj2?name={1}";
        Person p = restTemplate.getForObject(url,Person.class,"liuqingqing");
        return p;
    }

}
