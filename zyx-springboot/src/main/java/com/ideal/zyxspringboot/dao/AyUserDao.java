package com.ideal.zyxspringboot.dao;

import com.ideal.zyxspringboot.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AyUserDao {
    AyUser findByNameAndPassword(@Param("name") String name,@Param("password") String password);
}
