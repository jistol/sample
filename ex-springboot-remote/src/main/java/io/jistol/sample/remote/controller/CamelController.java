package io.jistol.sample.remote.controller;

import io.jistol.sample.remote.service.DefaultService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kimjh on 2017-03-07.
 */
@RestController
@RequestMapping("/camel")
public class CamelController
{
    @Value("${server.port}")
    private String port;

    @RequestMapping("/http/extend")
    public String extend(@RequestParam(defaultValue = "extend") String prefix)
    {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://127.0.0.1:9090/route/DefaultServiceHttpRemote");
        httpInvokerProxyFactoryBean.setServiceInterface(DefaultService.class);
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        DefaultService defaultService = (DefaultService)httpInvokerProxyFactoryBean.getObject();
        return "camel http " + defaultService.say(prefix);
    }
}
