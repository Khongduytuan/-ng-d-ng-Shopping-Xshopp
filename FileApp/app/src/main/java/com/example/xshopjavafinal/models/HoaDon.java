package com.example.xshopjavafinal.models;

public class HoaDon {
    private int hoaDonID;
    private int nguoiDungID;
    private String ngayDatHang;
    private Float tongTien;


    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon(int hoaDonID, int nguoiDungID, String ngayDatHang, Float tongTien) {
        this.hoaDonID = hoaDonID;
        this.nguoiDungID = nguoiDungID;
        this.ngayDatHang = ngayDatHang;
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }
}
