package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class DanhMucSanPham implements Serializable {
  private int danhMucSanPhamID;

  private String ngayTaoDanhMuc;

  private String tenDanhMuc;

  private String trangThai;

  private String nguoiTaoDanhMuc;

  private String capDoDanhMuc;

  public DanhMucSanPham(String ngayTaoDanhMuc, String tenDanhMuc, String trangThai, String nguoiTaoDanhMuc, String capDoDanhMuc) {
    this.ngayTaoDanhMuc = ngayTaoDanhMuc;
    this.tenDanhMuc = tenDanhMuc;
    this.trangThai = trangThai;
    this.nguoiTaoDanhMuc = nguoiTaoDanhMuc;
    this.capDoDanhMuc = capDoDanhMuc;
  }

  public DanhMucSanPham() {
  }

  public DanhMucSanPham(int danhMucSanPhamID, String ngayTaoDanhMuc, String tenDanhMuc, String trangThai, String nguoiTaoDanhMuc, String capDoDanhMuc) {
    this.danhMucSanPhamID = danhMucSanPhamID;
    this.ngayTaoDanhMuc = ngayTaoDanhMuc;
    this.tenDanhMuc = tenDanhMuc;
    this.trangThai = trangThai;
    this.nguoiTaoDanhMuc = nguoiTaoDanhMuc;
    this.capDoDanhMuc = capDoDanhMuc;
  }

  public int getDanhMucSanPhamID() {
    return danhMucSanPhamID;
  }

  public void setDanhMucSanPhamID(int danhMucSanPhamID) {
    this.danhMucSanPhamID = danhMucSanPhamID;
  }

  public String getNgayTaoDanhMuc() {
    return ngayTaoDanhMuc;
  }

  public void setNgayTaoDanhMuc(String ngayTaoDanhMuc) {
    this.ngayTaoDanhMuc = ngayTaoDanhMuc;
  }

  public String getTenDanhMuc() {
    return tenDanhMuc;
  }

  public void setTenDanhMuc(String tenDanhMuc) {
    this.tenDanhMuc = tenDanhMuc;
  }

  public String getTrangThai() {
    return trangThai;
  }

  public void setTrangThai(String trangThai) {
    this.trangThai = trangThai;
  }

  public String getNguoiTaoDanhMuc() {
    return nguoiTaoDanhMuc;
  }

  public void setNguoiTaoDanhMuc(String nguoiTaoDanhMuc) {
    this.nguoiTaoDanhMuc = nguoiTaoDanhMuc;
  }

  public String getCapDoDanhMuc() {
    return capDoDanhMuc;
  }

  public void setCapDoDanhMuc(String capDoDanhMuc) {
    this.capDoDanhMuc = capDoDanhMuc;
  }
}
