package io.jistol.sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Created by kimjh on 2017-03-08.
 */
@Component
public class RestBuilder extends RouteBuilder
{
    @Override
    public void configure() throws Exception {
        restConfiguration().contextPath("/camel").component("servlet").bindingMode(RestBindingMode.json);

        rest().get("/hello").to("direct:hello");
        from("direct:hello").transform().constant("Hello World");
    }
}
