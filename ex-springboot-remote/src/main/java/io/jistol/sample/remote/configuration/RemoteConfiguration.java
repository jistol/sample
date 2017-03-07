package io.jistol.sample.remote.configuration;

import io.jistol.sample.remote.annotation.RemoteType;
import io.jistol.sample.remote.service.DefaultService;
import io.jistol.sample.remote.service.impl.DefaultServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by kimjh on 2017-03-07.
 */
@Configuration
public class RemoteConfiguration implements BeanPostProcessor
{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        RemoteType remoteType = AnnotationUtils.findAnnotation(bean.getClass(), RemoteType.class);
        return (remoteType == null)? bean : remoteType.protocol().getServiceExporter(bean, beanName, remoteType);
    }

    @Bean
    public RmiServiceExporter regRmiService()
    {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("DefaultServiceRmiRemoteBean");
        rmiServiceExporter.setService(new DefaultServiceImpl());
        rmiServiceExporter.setServiceInterface(DefaultService.class);
        rmiServiceExporter.setRegistryPort(1099);

        return rmiServiceExporter;
    }

    @Bean("/DefaultServiceHttpRemoteBean")
    public HttpInvokerServiceExporter regHttpService()
    {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setServiceInterface(DefaultService.class);
        httpInvokerServiceExporter.setService(new DefaultServiceImpl());
        httpInvokerServiceExporter.afterPropertiesSet();
        return httpInvokerServiceExporter;
    }

}
