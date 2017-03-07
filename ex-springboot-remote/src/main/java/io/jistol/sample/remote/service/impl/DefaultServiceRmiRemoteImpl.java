package io.jistol.sample.remote.service.impl;

import io.jistol.sample.remote.annotation.RemoteType;
import io.jistol.sample.remote.common.Protocol;
import io.jistol.sample.remote.service.DefaultService;
import org.springframework.stereotype.Service;

/**
 * Created by kimjh on 2017-03-07.
 */
@Service("DefaultServiceRmiRemote")
@RemoteType(protocol = Protocol.RMI, serviceInterface = DefaultService.class)
public class DefaultServiceRmiRemoteImpl extends DefaultServiceImpl
{

}
