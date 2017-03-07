package io.jistol.sample.remote.controller;

import io.jistol.sample.remote.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kimjh on 2017-03-07.
 */
@RestController
@RequestMapping("/http")
public class HttpController
{
    @Autowired
    private DefaultService defaultService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/service")
    public String service(@RequestParam(defaultValue = "service") String prefix)
    {
        return "http " + defaultService.say(prefix);
    }

    @RequestMapping("/extend")
    public String extend(@RequestParam(defaultValue = "extend") String prefix)
    {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://127.0.0.1:" + port + "/DefaultServiceHttpRemote");
        httpInvokerProxyFactoryBean.setServiceInterface(DefaultService.class);
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        DefaultService defaultService = (DefaultService)httpInvokerProxyFactoryBean.getObject();
        return "http " + defaultService.say(prefix);
    }

    @RequestMapping("/bean")
    public String bean(@RequestParam(defaultValue = "bean") String prefix)
    {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://127.0.0.1:" + port + "/DefaultServiceHttpRemoteBean");
        httpInvokerProxyFactoryBean.setServiceInterface(DefaultService.class);
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        DefaultService defaultService = (DefaultService)httpInvokerProxyFactoryBean.getObject();
        return "http " + defaultService.say(prefix);
    }
}
