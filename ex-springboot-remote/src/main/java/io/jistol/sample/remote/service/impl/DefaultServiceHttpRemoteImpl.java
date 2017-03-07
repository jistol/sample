package io.jistol.sample.remote.service.impl;

import io.jistol.sample.remote.annotation.RemoteType;
import io.jistol.sample.remote.common.Protocol;
import io.jistol.sample.remote.service.DefaultService;
import org.springframework.stereotype.Service;

/**
 * Created by kimjh on 2017-03-07.
 */
@Service("/DefaultServiceHttpRemote")
@RemoteType(protocol = Protocol.HTTP, serviceInterface = DefaultService.class)
public class DefaultServiceHttpRemoteImpl extends DefaultServiceImpl
{

}
