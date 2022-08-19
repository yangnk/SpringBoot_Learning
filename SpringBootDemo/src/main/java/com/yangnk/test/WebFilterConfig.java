package com.yangnk.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.util.StringUtils;
import javax.servlet.*;

@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> webVisitFilterConfigRegistration() {
        //设置url过滤规则
        String urlPatterns = "/test/*,/system/*,/test";
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new WebVisitFilter());
        registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
        //设置名称
        registration.setName("webVisitFilter");
        //设置过滤器链执行顺序
        registration.setOrder(3);
        //启动标识
        registration.setEnabled(true);
        //添加初始化参数
        registration.addInitParameter("enabel", "true");
        return registration;
    }
}
