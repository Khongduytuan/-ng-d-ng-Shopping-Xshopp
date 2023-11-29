package com.example.xshopjavafinal.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.models.NguoiDung;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesManager {
    private static SharedPreferencesManager instance;
    private SharedPreferences sharedPreferences;

    private static final String PREFS_NAME = "DataUser";
    private static final String PREFS_DANH_SACH = "DanhSachDonHang";

    private SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }

    public void clearAllData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    public void saveUserData(NguoiDung nguoiDung) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nguoiDungID", String.valueOf(nguoiDung.getNguoiDungID()));
        editor.putString("username", nguoiDung.getUsername());
        editor.putString("viTri", nguoiDung.getViTri());
        editor.putString("hoVaTen", nguoiDung.getHoVaTen());
        editor.putString("diaChi", nguoiDung.getDiaChi());
        editor.putString("sdt", nguoiDung.getSdt());
        editor.putString("ngayThangNamSinh", nguoiDung.getNgayThangNamSinh());
        editor.apply();
    }

//    public void ThemGioHang(DonDatHangChiTiet donDatHangChiTiet){
//        List<DonDatHangChiTiet> danhSachGioHang = getOrderList();
//        danhSachGioHang.add(donDatHangChiTiet);
//        saveOrderList(danhSachGioHang);
//    }


    public void ThemGioHang(DonDatHangChiTiet donDatHangChiTiet) {
        List<DonDatHangChiTiet> danhSachGioHang = getOrderList();

        boolean daTonTai = false;

        for (DonDatHangChiTiet x : danhSachGioHang) {
            if (x != null && x.getTenSanPham().equals(donDatHangChiTiet.getTenSanPham())) {
                x.TangSoLuong();
                daTonTai = true;
                break;
            }
        }

        if (!daTonTai) {
            danhSachGioHang.add(donDatHangChiTiet);
        }

        saveOrderList(danhSachGioHang);
    }

    public void XoaDonDatHangChiTiet(String tenSanPham) {
        List<DonDatHangChiTiet> danhSachDonHangChiTiet = getOrderList();

        for (int i = 0; i < danhSachDonHangChiTiet.size(); i++) {
            DonDatHangChiTiet donDatHangChiTiet = danhSachDonHangChiTiet.get(i);
            if (donDatHangChiTiet != null && donDatHangChiTiet.getTenSanPham().equals(tenSanPham)) {
                danhSachDonHangChiTiet.remove(i);
                break;
            }
        }

        saveOrderList(danhSachDonHangChiTiet);
    }



    public List<DonDatHangChiTiet> getOrderList() {
        String orderListJson = sharedPreferences.getString(PREFS_DANH_SACH, "");
        if (!orderListJson.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<DonDatHangChiTiet>>(){}.getType();
            return gson.fromJson(orderListJson, type);
        } else {
            return new ArrayList<>();
        }
    }

    public void TangGiaGiaTriDonHangChiTiet(String tenSanPham) {
        List<DonDatHangChiTiet> danhSachDonHangChiTiet = getOrderList();

        for (DonDatHangChiTiet x : danhSachDonHangChiTiet) {
            if (x != null && x.getTenSanPham().equals(tenSanPham)) {
                x.TangSoLuong();
                break;
            }
        }

        saveOrderList(danhSachDonHangChiTiet);
    }

    public void saveOrderList(List<DonDatHangChiTiet> orderList) {
        Gson gson = new Gson();
        String orderListJson = gson.toJson(orderList);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFS_DANH_SACH, orderListJson);
        editor.apply();
    }


    public String sharedPreferencesGetHoVaTen() {
        return sharedPreferences.getString("hoVaTen", "");
    }
    public String sharedPreferencesGetNguoiDungID() {
        return sharedPreferences.getString("nguoiDungID", "");
    }
    public String sharedPreferencesGetViTri() {
        return sharedPreferences.getString("viTri", "");
    }
    public String sharedPreferencesGetUsername() {
        return sharedPreferences.getString("username", "");
    }
    public String sharedPreferencesGetDiaChi() {
        return sharedPreferences.getString("diaChi", "");
    }

    public String sharedPreferencesGetSdt() {
        return sharedPreferences.getString("sdt", "");
    }
    public String sharedPreferencesGetNgayThangNamSinh() {
        return sharedPreferences.getString("ngayThangNamSinh", "");
    }






}
