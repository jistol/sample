package io.jistol.sample.remote.controller;

import io.jistol.sample.remote.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kimjh on 2017-03-07.
 */
@RestController
@RequestMapping("/rmi")
public class RmiController
{
    @Autowired
    private DefaultService defaultService;

    @RequestMapping("/service")
    public String service(@RequestParam(defaultValue = "service") String prefix)
    {
        return "rmi " + defaultService.say(prefix);
    }


    @RequestMapping("/extend")
    public String extend(@RequestParam(defaultValue = "extend") String prefix)
    {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1099/DefaultServiceRmiRemote");
        rmiProxyFactoryBean.setServiceInterface(DefaultService.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        DefaultService defaultService = (DefaultService)rmiProxyFactoryBean.getObject();
        return "rmi " + defaultService.say(prefix);
    }

    @RequestMapping("/bean")
    public String bean(@RequestParam(defaultValue = "bean") String prefix)
    {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1099/DefaultServiceRmiRemoteBean");
        rmiProxyFactoryBean.setServiceInterface(DefaultService.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        DefaultService defaultService = (DefaultService)rmiProxyFactoryBean.getObject();
        return "rmi " + defaultService.say(prefix);
    }
}
