package com.example.xshopjavafinal.models;

public class HoaDonChiTiet {
    private int hoaDonChiTietID;
    private int hoaDonID;
    private int sanPhamID;
    private String tenSanPham;
    private Float giaHienTai;
    private int soLuong;

    public HoaDonChiTiet(int hoaDonID, int sanPhamID, String tenSanPham, Float giaHienTai, int soLuong) {
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.tenSanPham = tenSanPham;
        this.giaHienTai = giaHienTai;
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet(int hoaDonChiTietID, int hoaDonID, int sanPhamID, String tenSanPham, Float giaHienTai, int soLuong) {
        this.hoaDonChiTietID = hoaDonChiTietID;
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.tenSanPham = tenSanPham;
        this.giaHienTai = giaHienTai;
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet() {
    }

    public int getHoaDonChiTietID() {
        return hoaDonChiTietID;
    }

    public void setHoaDonChiTietID(int hoaDonChiTietID) {
        this.hoaDonChiTietID = hoaDonChiTietID;
    }

    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Float getGiaHienTai() {
        return giaHienTai;
    }

    public void setGiaHienTai(Float giaHienTai) {
        this.giaHienTai = giaHienTai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
