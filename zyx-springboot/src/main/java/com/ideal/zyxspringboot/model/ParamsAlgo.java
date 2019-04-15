package com.ideal.zyxspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="params_algo")
public class ParamsAlgo {

  @Id
  private long id;
  private long algoId;
  private String paramName;
  private String paramDetail;
  private String paramValue;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAlgoId() {
    return algoId;
  }

  public void setAlgoId(long algoId) {
    this.algoId = algoId;
  }


  public String getParamName() {
    return paramName;
  }

  public void setParamName(String paramName) {
    this.paramName = paramName;
  }


  public String getParamDetail() {
    return paramDetail;
  }

  public void setParamDetail(String paramDetail) {
    this.paramDetail = paramDetail;
  }


  public String getParamValue() {
    return paramValue;
  }

  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }

}
