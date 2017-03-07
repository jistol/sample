package io.jistol.sample.remote.service.impl;

import io.jistol.sample.remote.service.DefaultService;
import org.springframework.stereotype.Service;

/**
 * Created by kimjh on 2017-03-07.
 */
@Service("defaultService")
public class DefaultServiceImpl implements DefaultService
{
    @Override
    public String say(String prefix) {
        return "Hello " + prefix;
    }
}
