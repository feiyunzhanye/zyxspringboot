package com.ideal.zyxspringboot;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.repository.AyUserRepository;
import com.ideal.zyxspringboot.service.AyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZyxSpringbootApplicationTests {
    @Resource
    private AyUserService ayUserService;
    @Test
    public void testRedis(){
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



}
