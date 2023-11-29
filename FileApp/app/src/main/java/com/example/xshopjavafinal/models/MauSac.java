package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class MauSac implements Serializable {
  private int mauSacID;
  private String tenMauSac;
  private String maMauSac;
  private String sanPhamID;


  public MauSac(int mauSacID, String tenMauSac, String maMauSac, String sanPhamID) {
    this.mauSacID = mauSacID;
    this.tenMauSac = tenMauSac;
    this.maMauSac = maMauSac;
    this.sanPhamID = sanPhamID;
  }

  public MauSac(String tenMauSac, String maMauSac, String sanPhamID) {
    this.tenMauSac = tenMauSac;
    this.maMauSac = maMauSac;
    this.sanPhamID = sanPhamID;
  }

  public int getMauSacID() {
    return mauSacID;
  }

  public void setMauSacID(int mauSacID) {
    this.mauSacID = mauSacID;
  }

  public String getTenMauSac() {
    return tenMauSac;
  }

  public void setTenMauSac(String tenMauSac) {
    this.tenMauSac = tenMauSac;
  }

  public String getMaMauSac() {
    return maMauSac;
  }

  public void setMaMauSac(String maMauSac) {
    this.maMauSac = maMauSac;
  }

  public String getSanPhamID() {
    return sanPhamID;
  }

  public void setSanPhamID(String sanPhamID) {
    this.sanPhamID = sanPhamID;
  }

  public MauSac() {
  }
}
