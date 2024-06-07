package com.server.reservation.common.config;

import com.server.reservation.netty.http.mapping.HttpMethodHandler;
import com.server.reservation.netty.http.mapping.HttpMethodHandlerFactory;
import com.server.reservation.netty.http.mapping.NettySimpleUrlHandlerMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class InitialRouteRegistry {
    @Bean
    public NettySimpleUrlHandlerMapping<HttpMethodHandler> nettySimpleUrlHandlerMapping(ApplicationContext applicationContext) {
        NettySimpleUrlHandlerMapping<HttpMethodHandler> urlHandlerMapping = new NettySimpleUrlHandlerMapping(new HttpMethodHandlerFactory());
        urlHandlerMapping.registerHandlers(applicationContext, new Class[]{RestController.class, Controller.class});
        return urlHandlerMapping;
    }
}