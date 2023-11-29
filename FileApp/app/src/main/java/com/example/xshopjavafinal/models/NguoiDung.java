package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class NguoiDung implements Serializable {
  private int nguoiDungID;
  private String username;
  private String password;
  private String viTri;
  private String hoVaTen;
  private String diaChi;
  private String sdt;
  private String ngayThangNamSinh;


  public int getNguoiDungID() {
    return nguoiDungID;
  }

  public void setNguoiDungID(int nguoiDungID) {
    this.nguoiDungID = nguoiDungID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getViTri() {
    return viTri;
  }

  public void setViTri(String viTri) {
    this.viTri = viTri;
  }

  public String getHoVaTen() {
    return hoVaTen;
  }

  public void setHoVaTen(String hoVaTen) {
    this.hoVaTen = hoVaTen;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public String getNgayThangNamSinh() {
    return ngayThangNamSinh;
  }

  public void setNgayThangNamSinh(String ngayThangNamSinh) {
    this.ngayThangNamSinh = ngayThangNamSinh;
  }

  public NguoiDung() {
  }

  public NguoiDung(String username, String password, String viTri, String hoVaTen, String diaChi, String sdt, String ngayThangNamSinh) {
    this.username = username;
    this.password = password;
    this.viTri = viTri;
    this.hoVaTen = hoVaTen;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.ngayThangNamSinh = ngayThangNamSinh;
  }

  public NguoiDung(int nguoiDungID, String username, String password, String viTri, String hoVaTen, String diaChi, String sdt, String ngayThangNamSinh) {
    this.nguoiDungID = nguoiDungID;
    this.username = username;
    this.password = password;
    this.viTri = viTri;
    this.hoVaTen = hoVaTen;
    this.diaChi = diaChi;
    this.sdt = sdt;
    this.ngayThangNamSinh = ngayThangNamSinh;
  }
}
