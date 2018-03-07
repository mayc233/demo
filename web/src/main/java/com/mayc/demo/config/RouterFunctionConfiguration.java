package com.mayc.demo.config;

import com.mayc.demo.domain.User;
import com.mayc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author mayc
 * @description 路由器函数 配置
 * @return ${return_type}
 * @Company 久远银海湖北事业部
 * @ 2018/3/2
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request->{
                    //返回所有用户对象
                    Collection<User> users = userRepository.findAll();
                    //Reactive中的Flux或者Mono 他是异步处理
                    Mono<ServerResponse> response =null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
