package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class SanPham implements Serializable {
  private int boSuuTapID;

  private String tenSanPham;

  private String moTaSanPham;

  private String hot;

  private String ngaySanXuat;

  private String noiSanXuat;

  private String chiTietSanPham;

  private String chatLuongSanPham;

  private int donDatHangChiTietID;

  private int sanPhamID;

  private int danhMucID;

  private String chatLieuSanPham;

  private Float giaKhuyenMai;

  private String anhDaiDienSanPham;

  private Float gia;

  private int soLuong;

  public SanPham(int boSuuTapID, String tenSanPham,
                 String moTaSanPham, String hot, String ngaySanXuat,
                 String noiSanXuat, String chiTietSanPham, String chatLuongSanPham,
                 int donDatHangChiTietID, int sanPhamID, int danhMucID, String chatLieuSanPham,
                 Float giaKhuyenMai, String anhDaiDienSanPham, Float gia, int soLuong) {
    this.boSuuTapID = boSuuTapID;
    this.tenSanPham = tenSanPham;
    this.moTaSanPham = moTaSanPham;
    this.hot = hot;
    this.ngaySanXuat = ngaySanXuat;
    this.noiSanXuat = noiSanXuat;
    this.chiTietSanPham = chiTietSanPham;
    this.chatLuongSanPham = chatLuongSanPham;
    this.donDatHangChiTietID = donDatHangChiTietID;
    this.sanPhamID = sanPhamID;
    this.danhMucID = danhMucID;
    this.chatLieuSanPham = chatLieuSanPham;
    this.giaKhuyenMai = giaKhuyenMai;
    this.anhDaiDienSanPham = anhDaiDienSanPham;
    this.gia = gia;
    this.soLuong = soLuong;
  }

  public SanPham() {
  }

  public SanPham(String tenSanPham, String moTaSanPham,
                 String hot, String ngaySanXuat, String noiSanXuat,
                 String chiTietSanPham, String chatLuongSanPham,
                 int donDatHangChiTietID, int sanPhamID, int danhMucID,
                 String chatLieuSanPham, Float giaKhuyenMai,
                 String anhDaiDienSanPham, Float gia, int soLuong) {
    this.tenSanPham = tenSanPham;
    this.moTaSanPham = moTaSanPham;
    this.hot = hot;
    this.ngaySanXuat = ngaySanXuat;
    this.noiSanXuat = noiSanXuat;
    this.chiTietSanPham = chiTietSanPham;
    this.chatLuongSanPham = chatLuongSanPham;
    this.donDatHangChiTietID = donDatHangChiTietID;
    this.sanPhamID = sanPhamID;
    this.danhMucID = danhMucID;
    this.chatLieuSanPham = chatLieuSanPham;
    this.giaKhuyenMai = giaKhuyenMai;
    this.anhDaiDienSanPham = anhDaiDienSanPham;
    this.gia = gia;
    this.soLuong = soLuong;
  }

  public int getBoSuuTapID() {
    return boSuuTapID;
  }

  public void setBoSuuTapID(int boSuuTapID) {
    this.boSuuTapID = boSuuTapID;
  }

  public String getTenSanPham() {
    return tenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }

  public String getMoTaSanPham() {
    return moTaSanPham;
  }

  public void setMoTaSanPham(String moTaSanPham) {
    this.moTaSanPham = moTaSanPham;
  }

  public String getHot() {
    return hot;
  }

  public void setHot(String hot) {
    this.hot = hot;
  }

  public String getNgaySanXuat() {
    return ngaySanXuat;
  }

  public void setNgaySanXuat(String ngaySanXuat) {
    this.ngaySanXuat = ngaySanXuat;
  }

  public String getNoiSanXuat() {
    return noiSanXuat;
  }

  public void setNoiSanXuat(String noiSanXuat) {
    this.noiSanXuat = noiSanXuat;
  }

  public String getChiTietSanPham() {
    return chiTietSanPham;
  }

  public void setChiTietSanPham(String chiTietSanPham) {
    this.chiTietSanPham = chiTietSanPham;
  }

  public String getChatLuongSanPham() {
    return chatLuongSanPham;
  }

  public void setChatLuongSanPham(String chatLuongSanPham) {
    this.chatLuongSanPham = chatLuongSanPham;
  }

  public int getDonDatHangChiTietID() {
    return donDatHangChiTietID;
  }

  public void setDonDatHangChiTietID(int donDatHangChiTietID) {
    this.donDatHangChiTietID = donDatHangChiTietID;
  }

  public int getSanPhamID() {
    return sanPhamID;
  }

  public void setSanPhamID(int sanPhamID) {
    this.sanPhamID = sanPhamID;
  }

  public int getDanhMucID() {
    return danhMucID;
  }

  public void setDanhMucID(int danhMucID) {
    this.danhMucID = danhMucID;
  }

  public String getChatLieuSanPham() {
    return chatLieuSanPham;
  }

  public void setChatLieuSanPham(String chatLieuSanPham) {
    this.chatLieuSanPham = chatLieuSanPham;
  }

  public Float getGiaKhuyenMai() {
    return giaKhuyenMai;
  }

  public void setGiaKhuyenMai(Float giaKhuyenMai) {
    this.giaKhuyenMai = giaKhuyenMai;
  }

  public String getAnhDaiDienSanPham() {
    return anhDaiDienSanPham;
  }

  public void setAnhDaiDienSanPham(String anhDaiDienSanPham) {
    this.anhDaiDienSanPham = anhDaiDienSanPham;
  }

  public Float getGia() {
    return gia;
  }

  public void setGia(Float gia) {
    this.gia = gia;
  }

  public int getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }
}
