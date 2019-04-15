package com.ideal.zyxspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="algo")
public class Algo {
  @Id
  private long id;
  private String name;
  private String detail;
  private String scence;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  public String getScence() {
    return scence;
  }

  public void setScence(String scence) {
    this.scence = scence;
  }

}
