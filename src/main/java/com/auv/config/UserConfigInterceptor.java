package com.auv.config;

import com.auv.intercetor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;



@Configuration
public class UserConfigInterceptor implements WebMvcConfigurer {

    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List list = new ArrayList();
        list.add("/user/login");
        list.add("/user/resgister");
        list.add("/static/**");
        list.add("/user/toLogin");
        list.add("/apk/download");
        list.add("/scene/download");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").
                excludePathPatterns(list);

    }

    //静态文件访问配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    //视图配置
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }


}
