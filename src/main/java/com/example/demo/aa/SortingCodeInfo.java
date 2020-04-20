package com.example.demo.aa;

import java.util.Date;

public class SortingCodeInfo {

  private Integer id;

  private String pno;

  private String srcProvinceCode;

  private String srcCityCode;

  private String srcDistrictCode;

  private String srcPostalCode;

  private String srcStoreId;

  private String dstProvinceCode;

  private String dstCityCode;

  private String dstDistrictCode;

  private String dstPostalCode;

  private String dstStoreId;

  private String sortingCode;

  private String lineCode;

  private Integer operatorType;

  private String operatorId;

  private Date createdAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPno() {
    return pno;
  }

  public void setPno(String pno) {
    this.pno = pno == null ? null : pno.trim();
  }

  public String getSrcProvinceCode() {
    return srcProvinceCode;
  }

  public void setSrcProvinceCode(String srcProvinceCode) {
    this.srcProvinceCode = srcProvinceCode == null ? null : srcProvinceCode.trim();
  }

  public String getSrcCityCode() {
    return srcCityCode;
  }

  public void setSrcCityCode(String srcCityCode) {
    this.srcCityCode = srcCityCode == null ? null : srcCityCode.trim();
  }

  public String getSrcDistrictCode() {
    return srcDistrictCode;
  }

  public void setSrcDistrictCode(String srcDistrictCode) {
    this.srcDistrictCode = srcDistrictCode == null ? null : srcDistrictCode.trim();
  }

  public String getSrcPostalCode() {
    return srcPostalCode;
  }

  public void setSrcPostalCode(String srcPostalCode) {
    this.srcPostalCode = srcPostalCode == null ? null : srcPostalCode.trim();
  }

  public String getSrcStoreId() {
    return srcStoreId;
  }

  public void setSrcStoreId(String srcStoreId) {
    this.srcStoreId = srcStoreId == null ? null : srcStoreId.trim();
  }

  public String getDstProvinceCode() {
    return dstProvinceCode;
  }

  public void setDstProvinceCode(String dstProvinceCode) {
    this.dstProvinceCode = dstProvinceCode == null ? null : dstProvinceCode.trim();
  }

  public String getDstCityCode() {
    return dstCityCode;
  }

  public void setDstCityCode(String dstCityCode) {
    this.dstCityCode = dstCityCode == null ? null : dstCityCode.trim();
  }

  public String getDstDistrictCode() {
    return dstDistrictCode;
  }

  public void setDstDistrictCode(String dstDistrictCode) {
    this.dstDistrictCode = dstDistrictCode == null ? null : dstDistrictCode.trim();
  }

  public String getDstPostalCode() {
    return dstPostalCode;
  }

  public void setDstPostalCode(String dstPostalCode) {
    this.dstPostalCode = dstPostalCode == null ? null : dstPostalCode.trim();
  }

  public String getDstStoreId() {
    return dstStoreId;
  }

  public void setDstStoreId(String dstStoreId) {
    this.dstStoreId = dstStoreId == null ? null : dstStoreId.trim();
  }

  public String getSortingCode() {
    return sortingCode;
  }

  public void setSortingCode(String sortingCode) {
    this.sortingCode = sortingCode == null ? null : sortingCode.trim();
  }

  public String getLineCode() {
    return lineCode;
  }

  public void setLineCode(String lineCode) {
    this.lineCode = lineCode == null ? null : lineCode.trim();
  }

  public Integer getOperatorType() {
    return operatorType;
  }

  public void setOperatorType(Integer operatorType) {
    this.operatorType = operatorType;
  }

  public String getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(String operatorId) {
    this.operatorId = operatorId == null ? null : operatorId.trim();
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
