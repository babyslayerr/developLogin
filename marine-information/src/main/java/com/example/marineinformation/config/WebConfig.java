package com.example.marineinformation.config;

import com.example.marineinformation.Auth.resolver.LoginMemberArgumentResolver;
import com.example.marineinformation.springInterceptor.LogInterceptor;
import com.example.marineinformation.springInterceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**");


//      //  registry.addInterceptor(new LoginCheckInterceptor())
//       //         .order(2)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/*","/swagger-ui.html**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }


}
