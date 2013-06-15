package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fee")
public class Fee {
  private Integer feeId;
  private String feeName;
  private long price;
  
  @Id
  @GeneratedValue
  @Column(name = "FeeID") 
  public Integer getFeeId() {
    return feeId;
  }
  public void setFeeId(Integer feeId) {
    this.feeId = feeId;
  }
  
  @Column(name = "FeeName")
  public String getFeeName() {
    return feeName;
  }
  public void setFeeName(String feeName) {
    this.feeName = feeName;
  }
  
  @Column(name = "Price")
  public long getPrice() {
    return price;
  }
  public void setPrice(long price) {
    this.price = price;
  }
}
