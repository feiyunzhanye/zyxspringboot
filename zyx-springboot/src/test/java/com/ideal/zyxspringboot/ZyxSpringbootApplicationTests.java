package com.ideal.zyxspringboot;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.repository.AyUserRepository;
import com.ideal.zyxspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZyxSpringbootApplicationTests {
    @Resource
    private AyUserService ayUserService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedis(){
        //新增
        redisTemplate.opsForValue().set("name","ay");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        //删除
        redisTemplate.delete("name");
        //更新
        redisTemplate.opsForValue().set("name","al");
        //StringRedisTemplate 只针对键值是字符串的数据进行操作
        name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRepository(){
        List<AyUser> userList = ayUserService.findByName("阿毅");
        System.out.println("findName:"+userList.get(0));
    }
    @Test
    public void testTransaction(){
        AyUser ayUser = new AyUser();
        ayUser.setId("5");
        ayUser.setName("zhouyx");
        ayUser.setPassword("123");
        ayUserService.save(ayUser);
    }
    @Test
    public void testFindById(){
        Long redisUserSize = 0L;
        AyUser ayUser = ayUserService.findById("1");
        redisUserSize = redisTemplate.opsForList().size("ALL_USER_LIST");
        System.out.println("缓存中用户数量："+redisUserSize);
        System.out.println("------》》》id："+ayUser.getId()+" name:"+ayUser.getName());
        AyUser test = new AyUser();
        test.setId("4");
        test.setName("test");
        test.setPassword("123456");
        ayUserService.save(test);
        AyUser ayUser2 = ayUserService.findById("4");
        redisUserSize = redisTemplate.opsForList().size("ALL_USER_LIST");
        System.out.println("缓存中用户数量："+redisUserSize);
        System.out.println("------》》》id："+ayUser2.getId()+" name:"+ayUser2.getName());
    }
    Logger logger = LogManager.getLogger(this.getClass());
    @Test
    public void testLog4j(){
        ayUserService.delete("4");
        logger.info("delete success");
    }
    @Test
    public void testMybatis(){
        AyUser ayUser = ayUserService.findByNameAndPassword("阿毅","123456");
        logger.info(ayUser.getId()+ayUser.getName());
    }
}
