package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class KichCo implements Serializable {
  private String kichCoID;

  private String tenKichCo;

  private String kyHieuKichCoBangSo;

  private String kyHieuKichCoBangChu;

  private String sanPhamID;

  public KichCo() {
  }

  public KichCo(String tenKichCo, String kyHieuKichCoBangSo, String kyHieuKichCoBangChu, String sanPhamID) {
    this.tenKichCo = tenKichCo;
    this.kyHieuKichCoBangSo = kyHieuKichCoBangSo;
    this.kyHieuKichCoBangChu = kyHieuKichCoBangChu;
    this.sanPhamID = sanPhamID;
  }

  public KichCo(String kichCoID, String tenKichCo, String kyHieuKichCoBangSo, String kyHieuKichCoBangChu, String sanPhamID) {
    this.kichCoID = kichCoID;
    this.tenKichCo = tenKichCo;
    this.kyHieuKichCoBangSo = kyHieuKichCoBangSo;
    this.kyHieuKichCoBangChu = kyHieuKichCoBangChu;
    this.sanPhamID = sanPhamID;
  }

  public String getKichCoID() {
    return kichCoID;
  }

  public void setKichCoID(String kichCoID) {
    this.kichCoID = kichCoID;
  }

  public String getTenKichCo() {
    return tenKichCo;
  }

  public void setTenKichCo(String tenKichCo) {
    this.tenKichCo = tenKichCo;
  }

  public String getKyHieuKichCoBangSo() {
    return kyHieuKichCoBangSo;
  }

  public void setKyHieuKichCoBangSo(String kyHieuKichCoBangSo) {
    this.kyHieuKichCoBangSo = kyHieuKichCoBangSo;
  }

  public String getKyHieuKichCoBangChu() {
    return kyHieuKichCoBangChu;
  }

  public void setKyHieuKichCoBangChu(String kyHieuKichCoBangChu) {
    this.kyHieuKichCoBangChu = kyHieuKichCoBangChu;
  }

  public String getSanPhamID() {
    return sanPhamID;
  }

  public void setSanPhamID(String sanPhamID) {
    this.sanPhamID = sanPhamID;
  }
}
