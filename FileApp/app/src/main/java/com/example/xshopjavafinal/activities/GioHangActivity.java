package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.SanPhamInGioHangAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.example.xshopjavafinal.util.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity implements
        SanPhamInGioHangAdapter.OnItemClickDeleteSanPhamInGioHangListener,
        SanPhamInGioHangAdapter.OnItemClickSanPhamInGioHangListener {
    private ImageView icon_backInGioHang;
    private RecyclerView recycleViewSanPhamInGioHang;
    private TextView textView_TongTienInGioHang;
    private AppCompatButton button_XacNhanInGioHang;
    private List<DonDatHangChiTiet> mList;
    private SanPhamInGioHangAdapter sanPhamInGioHangAdapter;

    private int donDatHangID = 8;
    private int hoaDonID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        anhXa();

        mList = SharedPreferencesManager.getInstance(this).getOrderList();
        if (mList != null) {
            for (DonDatHangChiTiet x : mList) {
                Log.d("danhsachdonhangtronggiohang", x.getTenSanPham() + " " + x.getSoLuong());

            }

        } else {
            Log.d("danhsachdonhangtronggiohang", "rong");
        }


        sanPhamInGioHangAdapter = new SanPhamInGioHangAdapter(getApplicationContext(),
                this,
                this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleViewSanPhamInGioHang.setLayoutManager(linearLayoutManager);
        recycleViewSanPhamInGioHang.setAdapter(sanPhamInGioHangAdapter);
        sanPhamInGioHangAdapter.setData(mList);


        icon_backInGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button_XacNhanInGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaoDonHang(mList);
            }
        });

    }

    private void TaoDonHang(List<DonDatHangChiTiet> mList) {
        int addedCount = 0;
        for (DonDatHangChiTiet x: mList) {
            if (x.getTenSanPham().isEmpty()
                    || x.getKichCoSanPham().isEmpty()
                    || x.getMauSacSanPham().isEmpty()
            ){
                Toast.makeText(this, "Thiếu thông tin sản phẩm thiếu!", Toast.LENGTH_SHORT).show();
            } else if (x.getSoLuong() <= 0) {
                Toast.makeText(this, "Sản phẩm " + x.getTenSanPham() + "không có số lượng!", Toast.LENGTH_SHORT).show();
            }else{
                int nguoiDungID = Integer.parseInt(SharedPreferencesManager.getInstance(getApplicationContext()).sharedPreferencesGetNguoiDungID());
                String tinhTrangXacNhan = "Chưa xác nhận";
                String thoiGianDat = getCurrentTime() ;
                InsertDataDonHangChiTiet(x.getSanPhamID(),
                        nguoiDungID,
                        x.getTenSanPham(),
                        x.getAnhDaiDienSanPhamTrongDonHang(),
                        x.getMauSacSanPham(),
                        x.getKichCoSanPham(),
                        x.getGiaLucMua(),
                        tinhTrangXacNhan,
                        thoiGianDat,
                        x.getSoLuong(),
                        donDatHangID,
                        hoaDonID);
                addedCount++;
            }

        }

        if (addedCount == mList.size()){
            Toast.makeText(this, "Các sản phẩm đã được xác nhận", Toast.LENGTH_SHORT).show();
        } else if (addedCount > 0 && addedCount < mList.size()) {
            Toast.makeText(this, "Có sản phẩm đã gặp lỗi trong quá trình xác nhận", Toast.LENGTH_SHORT).show();
        }
    }


    private void InsertDataDonHangChiTiet(int sanPhamID, int nguoiDungID, String tenSanPham, String anhDaiDienSanPhamTrongDonHang,
                                          String mauSacSanPham, String kichCoSanPham,
                                          Float giaLucMua, String tinhTrangXacNhan, String thoiGianDat,int soLuong, int donDatHangID,
                                          int hoaDonID
    ) {
        ApiServiceDataDonDatHangChiTiet
                .apiServiceDataDonDatHangChiTiet
                .insertDataDonDatHangChiTietFromNguoiDungID(sanPhamID,nguoiDungID, tenSanPham, anhDaiDienSanPhamTrongDonHang,
                        mauSacSanPham, kichCoSanPham, giaLucMua,tinhTrangXacNhan, thoiGianDat, soLuong, donDatHangID,
                        hoaDonID
                )
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("thanhcong")) {
                            SharedPreferencesManager.getInstance(getApplicationContext()).XoaDonDatHangChiTiet(tenSanPham);
                            xoaDonDatHangChiTiet(tenSanPham);
                            sanPhamInGioHangAdapter.setData(mList);
                            Log.d("donDatHangChiTiet", "thanhcong: " + sanPhamID + " " +
                                    nguoiDungID + " " +
                                    tenSanPham + " " +
                                    mauSacSanPham + " " +
                                    kichCoSanPham + " " +
                                    giaLucMua + " " +
                                    tinhTrangXacNhan + " " +
                                    thoiGianDat + " " +
                                    soLuong);

                        } else {
                            Log.d("donDatHangChiTiet", "error: " + sanPhamID + " " +
                                    nguoiDungID + " " +
                                    tenSanPham + " " +
                                    mauSacSanPham + " " +
                                    kichCoSanPham + " " +
                                    giaLucMua + " " +
                                    tinhTrangXacNhan + " " +
                                    thoiGianDat + " " +
                                    soLuong);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("donDatHangChiTiet", t.toString());
                    }
                });

    }


    private String getCurrentTime() {
        // Lấy ngày giờ hiện tại
        Date currentDate = new Date();

        // Định dạng ngày giờ theo ý muốn
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    private void anhXa() {
        icon_backInGioHang = findViewById(R.id.icon_backInGioHang);
        recycleViewSanPhamInGioHang = findViewById(R.id.recycleViewSanPhamInGioHang);
        textView_TongTienInGioHang = findViewById(R.id.textView_TongTienInGioHang);
        button_XacNhanInGioHang = findViewById(R.id.button_XacNhanInGioHang);
    }

    private void capNhatTongTien() {
        double tongTien = 0.0;
        if (mList != null){
            for (DonDatHangChiTiet donDatHangChiTiet : mList) {
                tongTien += donDatHangChiTiet.getGiaLucMua() * donDatHangChiTiet.getSoLuong();
            }
            textView_TongTienInGioHang.setText(Util.formatNumber(String.valueOf(tongTien)));
        }else {
            textView_TongTienInGioHang.setText("0");
        }
    }

    @Override
    public void onItemClickInGioHang(DonDatHangChiTiet donDatHangChiTiet) {
        capNhatTongTien();

    }


    @Override
    public void onItemClickDeleteInGioHang(DonDatHangChiTiet donDatHangChiTiet) {
        SharedPreferencesManager.getInstance(this)
                .XoaDonDatHangChiTiet(donDatHangChiTiet.getTenSanPham());
        xoaDonDatHangChiTiet(donDatHangChiTiet.getTenSanPham());
        capNhatTongTien();
    }

    private void xoaDonDatHangChiTiet(String tenSanPham) {
        for (int i = 0; i < mList.size(); i++) {
            DonDatHangChiTiet donDatHangChiTiet = mList.get(i);
            if (donDatHangChiTiet != null && donDatHangChiTiet.getTenSanPham().equals(tenSanPham)) {
                mList.remove(i);
                break;
            }
        }

    }
}