package com.ideal.zyxspringboot.listener;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;



@WebListener
public class AyUserListener implements ServletContextListener {
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private AyUserService ayUserService;
    private static final String All_USER = "ALL_USER_LIST";
    /**
     * 调用完该方法后再对Filter进行初始化
     * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        List<AyUser> ayUserList = ayUserService.findAll();
        //清除缓存
        redisTemplate.delete(All_USER);
        //存入缓存
        redisTemplate.opsForList().leftPushAll(All_USER,ayUserList);

        //查看缓存中的数据，真实项目中不需要
        //redisTemplate.opsForList().range获取指定区间的值
        List<AyUser> queryUserList = redisTemplate.opsForList().range(All_USER,0,-1);
        //System.out.println("ServletContext上下文初始化");
        logger.info("ServletContext上下文初始化");
        logger.info("缓存中目前的用户输有："+queryUserList.size()+"人");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        //System.out.println("ServletContext 上下文销毁");
        logger.info("ServletContext 上下文销毁");
    }
}
