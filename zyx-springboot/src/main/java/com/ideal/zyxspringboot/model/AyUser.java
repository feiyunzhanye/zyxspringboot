package com.ideal.zyxspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 每个持久化POJO类都是一个实体bean，通过@Entity注解来声明
 * */
@Entity
@Table(name="ay_user")
public class AyUser {

  @Id
  private String id;
  private String name;
  private String password;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
