package com.example.xshopjavafinal.models;

public class ThongBao {
    private int thongBaoID;
    private String tenThongBao, noiDungThongBao;

    public int getThongBaoID() {
        return thongBaoID;
    }

    public void setThongBaoID(int thongBaoID) {
        this.thongBaoID = thongBaoID;
    }

    public String getTenThongBao() {
        return tenThongBao;
    }

    public void setTenThongBao(String tenThongBao) {
        this.tenThongBao = tenThongBao;
    }

    public String getNoiDungThongBao() {
        return noiDungThongBao;
    }

    public void setNoiDungThongBao(String noiDungThongBao) {
        this.noiDungThongBao = noiDungThongBao;
    }

    public ThongBao() {
    }

    public ThongBao(String tenThongBao, String noiDungThongBao) {
        this.tenThongBao = tenThongBao;
        this.noiDungThongBao = noiDungThongBao;
    }

    public ThongBao(int thongBaoID, String tenThongBao, String noiDungThongBao) {
        this.thongBaoID = thongBaoID;
        this.tenThongBao = tenThongBao;
        this.noiDungThongBao = noiDungThongBao;
    }
}
