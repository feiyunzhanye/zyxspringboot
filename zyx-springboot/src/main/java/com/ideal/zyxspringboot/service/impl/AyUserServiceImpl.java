package com.ideal.zyxspringboot.service.impl;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.repository.AyUserRepository;
import com.ideal.zyxspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Transactional 添加事务，可以添加到类上和方法上,同时使用方法级别覆盖累级别
 * */
@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private AyUserRepository ayUserRepository;
    @Resource
    private RedisTemplate redisTemplate;
    private static final String ALL_USER = "ALL_USER_LIST";
    @Override
    public AyUser findById(String id){
        List<AyUser> ayUserList = redisTemplate.opsForList().range(ALL_USER,0,-1);
        if(ayUserList!=null&&ayUserList.size()>0){
            for(AyUser user:ayUserList){
                if(user.getId().equals(id)){
                    return user;
                }
            }
        }
        AyUser ayUser = ayUserRepository.findById(id).get();
        if(ayUser!=null){
            //将数据添加到头部
            redisTemplate.opsForList().leftPush(ALL_USER,ayUser);
        }
        return ayUser;
    }

    @Override
    public List<AyUser> findAll(){
        return ayUserRepository.findAll();
    }
    @Transactional
    @Override
    public AyUser save(AyUser ayUser){
        AyUser ayUser1 = ayUserRepository.save(ayUser);
        //人造出现空指针异常添加事物应该保存不成功
       /* String error =null;
        error.split("/");*/
        return ayUser1;
    }

    @Override
    public void delete(String id){

        ayUserRepository.deleteById(id);
        logger.info("userId:"+id+"用户被删除");
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable){
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name){
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name){
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids){
        return ayUserRepository.findByIdIn(ids);
    }
}
