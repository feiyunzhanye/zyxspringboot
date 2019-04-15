package com.ideal.zyxspringboot.service;

import com.ideal.zyxspringboot.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AyUserService {
    AyUser findById(String id);
    List<AyUser> findAll();
    AyUser save(AyUser ayUser);
    void delete(String id);
    //分页 方法名命名体现了java的重载特性
    Page<AyUser> findAll(Pageable pageable);
    //自定义查询方法接口
    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<String> ids);
}
