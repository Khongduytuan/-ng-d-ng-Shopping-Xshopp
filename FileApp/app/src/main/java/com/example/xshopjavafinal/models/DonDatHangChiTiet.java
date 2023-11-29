package com.example.xshopjavafinal.models;

import java.io.Serializable;

public class DonDatHangChiTiet implements Serializable {
    private int donDatHangChiTietID;
    private int sanPhamID;
    private int nguoiDungID;
    private String tenSanPham;
    private String anhDaiDienSanPhamTrongDonHang;
    private String mauSacSanPham;
    private String kichCoSanPham;
    private Float giaLucMua;
    private String tinhTrangXacNhan;
    private String thoiGianDat;
    private int soLuong;
    private int donDatHangID;
    private int hoaDonID;

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

    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getAnhDaiDienSanPhamTrongDonHang() {
        return anhDaiDienSanPhamTrongDonHang;
    }

    public void setAnhDaiDienSanPhamTrongDonHang(String anhDaiDienSanPhamTrongDonHang) {
        this.anhDaiDienSanPhamTrongDonHang = anhDaiDienSanPhamTrongDonHang;
    }

    public String getMauSacSanPham() {
        return mauSacSanPham;
    }

    public void setMauSacSanPham(String mauSacSanPham) {
        this.mauSacSanPham = mauSacSanPham;
    }

    public String getKichCoSanPham() {
        return kichCoSanPham;
    }

    public void setKichCoSanPham(String kichCoSanPham) {
        this.kichCoSanPham = kichCoSanPham;
    }

    public Float getGiaLucMua() {
        return giaLucMua;
    }

    public void setGiaLucMua(Float giaLucMua) {
        this.giaLucMua = giaLucMua;
    }

    public String getTinhTrangXacNhan() {
        return tinhTrangXacNhan;
    }

    public void setTinhTrangXacNhan(String tinhTrangXacNhan) {
        this.tinhTrangXacNhan = tinhTrangXacNhan;
    }

    public String getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(String thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonDatHangID() {
        return donDatHangID;
    }

    public void setDonDatHangID(int donDatHangID) {
        this.donDatHangID = donDatHangID;
    }

    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public DonDatHangChiTiet() {
    }

    public DonDatHangChiTiet(int sanPhamID, int nguoiDungID, String tenSanPham, String anhDaiDienSanPhamTrongDonHang, String mauSacSanPham, String kichCoSanPham, Float giaLucMua, String tinhTrangXacNhan, String thoiGianDat, int soLuong, int donDatHangID, int hoaDonID) {
        this.sanPhamID = sanPhamID;
        this.nguoiDungID = nguoiDungID;
        this.tenSanPham = tenSanPham;
        this.anhDaiDienSanPhamTrongDonHang = anhDaiDienSanPhamTrongDonHang;
        this.mauSacSanPham = mauSacSanPham;
        this.kichCoSanPham = kichCoSanPham;
        this.giaLucMua = giaLucMua;
        this.tinhTrangXacNhan = tinhTrangXacNhan;
        this.thoiGianDat = thoiGianDat;
        this.soLuong = soLuong;
        this.donDatHangID = donDatHangID;
        this.hoaDonID = hoaDonID;
    }

    public DonDatHangChiTiet(int donDatHangChiTietID, int sanPhamID, int nguoiDungID, String tenSanPham, String anhDaiDienSanPhamTrongDonHang, String mauSacSanPham, String kichCoSanPham, Float giaLucMua, String tinhTrangXacNhan, String thoiGianDat, int soLuong, int donDatHangID, int hoaDonID) {
        this.donDatHangChiTietID = donDatHangChiTietID;
        this.sanPhamID = sanPhamID;
        this.nguoiDungID = nguoiDungID;
        this.tenSanPham = tenSanPham;
        this.anhDaiDienSanPhamTrongDonHang = anhDaiDienSanPhamTrongDonHang;
        this.mauSacSanPham = mauSacSanPham;
        this.kichCoSanPham = kichCoSanPham;
        this.giaLucMua = giaLucMua;
        this.tinhTrangXacNhan = tinhTrangXacNhan;
        this.thoiGianDat = thoiGianDat;
        this.soLuong = soLuong;
        this.donDatHangID = donDatHangID;
        this.hoaDonID = hoaDonID;
    }

    public void TangSoLuong() {
        this.soLuong++;
    }
    public void GiamSoLuong() {
        if (soLuong > 0) {
            soLuong--;
        }
    }


}
