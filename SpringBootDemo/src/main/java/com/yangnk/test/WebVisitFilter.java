package com.yangnk.test;

import javax.servlet.*;
import java.io.IOException;

public class WebVisitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==========1. doFilter===========");
        System.out.println(request.toString());
        System.out.println(response.toString());
        System.out.println("==========2. doFilter===========");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
