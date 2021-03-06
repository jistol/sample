package io.jistol.sample.remote.annotation;

import io.jistol.sample.remote.common.Protocol;
import org.springframework.beans.factory.annotation.Required;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kimjh on 2017-03-07.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface RemoteType
{
    Protocol protocol() default Protocol.HTTP;

    int port() default -1;

    @Required
    Class<?> serviceInterface();
}
