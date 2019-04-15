package com.ideal.zyxspringboot.service.impl;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.repository.AyUserRepository;
import com.ideal.zyxspringboot.service.AyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Resource
    private AyUserRepository ayUserRepository;
    @Override
    public AyUser findById(String id){
        return ayUserRepository.findById(id).get();
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
