package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Fee")
public class Fee {
  private Integer feeId;
  private String feeName;
  private long price;
  
  public Integer getFeeId() {
    return feeId;
  }
  public void setFeeId(Integer feeId) {
    this.feeId = feeId;
  }
  public String getFeeName() {
    return feeName;
  }
  public void setFeeName(String feeName) {
    this.feeName = feeName;
  }
  public long getPrice() {
    return price;
  }
  public void setPrice(long price) {
    this.price = price;
  }
}
