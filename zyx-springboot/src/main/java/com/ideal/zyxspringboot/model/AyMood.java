package com.ideal.zyxspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ay_mood")
public class AyMood {
  @Id
  private String id;
  private String content;
  private String userId;
  private long praiseNum;
  private java.sql.Timestamp publishTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getPraiseNum() {
    return praiseNum;
  }

  public void setPraiseNum(long praiseNum) {
    this.praiseNum = praiseNum;
  }


  public java.sql.Timestamp getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(java.sql.Timestamp publishTime) {
    this.publishTime = publishTime;
  }

}
