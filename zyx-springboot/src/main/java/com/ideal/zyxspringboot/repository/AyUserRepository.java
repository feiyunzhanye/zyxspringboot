package com.ideal.zyxspringboot.repository;

import com.ideal.zyxspringboot.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AyUserRepository extends JpaRepository<AyUser,String> {
    /**
     * Spring data jpa 按照约定好的命名规则实现数据库操作
     * 通过名字相等进行查询，参数为name
     * 相当于:select u from ay_user u where u.name=?1
     * */
    List<AyUser> findByName(String name);
    /**
     * 通过名字like查询，参数为name
     * 相当于：select u from ay_user u where u.name like ?1
     * */
    List<AyUser> findByNameLike(String name);
    /**
     * 通过主键id集合查询，参数为id集合
     * 选用Collection集合因为它是Set list 的父类，则该方法实现时可以用Collection的子类实现
     * */
    List<AyUser> findByIdIn(Collection<String> ids);

}
