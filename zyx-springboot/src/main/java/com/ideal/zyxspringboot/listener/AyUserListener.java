package com.ideal.zyxspringboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AyUserListener implements ServletContextListener {
    /**
     * 调用玩该方法后再对Filter进行初始化
     * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("ServletContext上下文初始化");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("ServletContext 上下文销毁");
    }
}
