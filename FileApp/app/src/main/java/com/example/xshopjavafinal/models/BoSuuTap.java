
package com.example.xshopjavafinal.models;

import java.io.Serializable;
import java.lang.String;

public class BoSuuTap implements Serializable {
    private int boSuuTapID;

    private String moTaBoSuuTap;

    private String anhDaiDienBoSuuTap;

    private String tenBoSuuTap;

    private String chiTietBoSuuTap;

    private String hot;

    public BoSuuTap() {
    }

    public BoSuuTap(String moTaBoSuuTap, String anhDaiDienBoSuuTap, String tenBoSuuTap, String chiTietBoSuuTap, String hot) {
        this.moTaBoSuuTap = moTaBoSuuTap;
        this.anhDaiDienBoSuuTap = anhDaiDienBoSuuTap;
        this.tenBoSuuTap = tenBoSuuTap;
        this.chiTietBoSuuTap = chiTietBoSuuTap;
        this.hot = hot;
    }

    public BoSuuTap(int boSuuTapID, String moTaBoSuuTap, String anhDaiDienBoSuuTap, String tenBoSuuTap, String chiTietBoSuuTap, String hot) {
        this.boSuuTapID = boSuuTapID;
        this.moTaBoSuuTap = moTaBoSuuTap;
        this.anhDaiDienBoSuuTap = anhDaiDienBoSuuTap;
        this.tenBoSuuTap = tenBoSuuTap;
        this.chiTietBoSuuTap = chiTietBoSuuTap;
        this.hot = hot;
    }

    public int getBoSuuTapID() {
        return boSuuTapID;
    }

    public void setBoSuuTapID(int boSuuTapID) {
        this.boSuuTapID = boSuuTapID;
    }

    public String getMoTaBoSuuTap() {
        return moTaBoSuuTap;
    }

    public void setMoTaBoSuuTap(String moTaBoSuuTap) {
        this.moTaBoSuuTap = moTaBoSuuTap;
    }

    public String getAnhDaiDienBoSuuTap() {
        return anhDaiDienBoSuuTap;
    }

    public void setAnhDaiDienBoSuuTap(String anhDaiDienBoSuuTap) {
        this.anhDaiDienBoSuuTap = anhDaiDienBoSuuTap;
    }

    public String getTenBoSuuTap() {
        return tenBoSuuTap;
    }

    public void setTenBoSuuTap(String tenBoSuuTap) {
        this.tenBoSuuTap = tenBoSuuTap;
    }

    public String getChiTietBoSuuTap() {
        return chiTietBoSuuTap;
    }

    public void setChiTietBoSuuTap(String chiTietBoSuuTap) {
        this.chiTietBoSuuTap = chiTietBoSuuTap;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }
}
