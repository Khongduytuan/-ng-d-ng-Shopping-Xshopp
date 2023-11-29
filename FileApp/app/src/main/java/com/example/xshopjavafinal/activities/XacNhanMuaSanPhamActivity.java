package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.squareup.picasso.Picasso;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XacNhanMuaSanPhamActivity extends AppCompatActivity {

    private int donDatHangID = 8;
    private int hoaDonID = 1;
    private int soLuong;
    private Float giaLucMua;

    private ImageView iamgeView_AnhSanPhamInXacNhanMua;
    private TextView textView_TenSanPhamInXacNhanMua,
            textView_MauSacInXacNhan, textView_KichCoInXacNhan,
            textView_GiaInXacNhan,textView_TongTienInXacNhan;

    private ImageView icon_back;
    private AppCompatButton button_XacNhanMuaSanPham;

    private Spinner spinner_SoLuongInXacNhan;
    private ProgressBar loaddingBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_mua_san_pham);
        anhXa();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_values));

        // Set layout cho danh sách thả xuống
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gắn ArrayAdapter cho Spinner
        spinner_SoLuongInXacNhan.setAdapter(adapter);

        DonDatHangChiTiet donDatHangChiTiet = (DonDatHangChiTiet) getIntent().getExtras().get("donDatHangChiTiet");
        if (donDatHangChiTiet != null){
            Log.d("donDatHangChiTietInXacNhan", "donDatHangChiTietID: " + donDatHangChiTiet.getDonDatHangChiTietID() + " " +
                    "sanPhamID: " + donDatHangChiTiet.getSanPhamID() + " " +
                    "donDatHangID: " + donDatHangChiTiet.getDonDatHangID() + " " +
                    "tenSanPhamID: " + donDatHangChiTiet.getTenSanPham() + " " +
                    "anhDaiDienSanPhamTrongDonHang: " + donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang() + " " +
                    "soLuong: " + donDatHangChiTiet.getSoLuong() + " " +
                    "kichCoSanPham: " + donDatHangChiTiet.getKichCoSanPham() + " " +
                    "mauSacSanPham: " + donDatHangChiTiet.getMauSacSanPham() + " " +
                    "giaLucMua: " + donDatHangChiTiet.getGiaLucMua() + " " +
                    "hoaDonID: " + donDatHangChiTiet.getHoaDonID()
            );

            Picasso.get().load(donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang()).into(iamgeView_AnhSanPhamInXacNhanMua);
            textView_TenSanPhamInXacNhanMua.setText(donDatHangChiTiet.getTenSanPham());
            textView_MauSacInXacNhan.setText(donDatHangChiTiet.getMauSacSanPham());
            textView_KichCoInXacNhan.setText(donDatHangChiTiet.getKichCoSanPham());
            textView_GiaInXacNhan.setText(String.valueOf(donDatHangChiTiet.getGiaLucMua()));
            spinner_SoLuongInXacNhan.setSelection(donDatHangChiTiet.getSoLuong() - 1);
            soLuong = donDatHangChiTiet.getSoLuong();
            giaLucMua = donDatHangChiTiet.getGiaLucMua();

            textView_TongTienInXacNhan.setText(String.valueOf(capNhatTongTien(soLuong, giaLucMua)));
        }

        icon_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        spinner_SoLuongInXacNhan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                soLuong = Integer.parseInt(adapterView.getSelectedItem().toString());
                donDatHangChiTiet.setSoLuong(soLuong);
                textView_TongTienInXacNhan.setText(String.valueOf(capNhatTongTien(soLuong, giaLucMua)));
                Log.d("donDatHangChiTietInXacNhanSauKhiClickSpiner", "donDatHangChiTietID: " + donDatHangChiTiet.getDonDatHangChiTietID() + " " +
                        "sanPhamID: " + donDatHangChiTiet.getSanPhamID() + " " +
                        "donDatHangID: " + donDatHangChiTiet.getDonDatHangID() + " " +
                        "tenSanPhamID: " + donDatHangChiTiet.getTenSanPham() + " " +
                        "anhDaiDienSanPhamTrongDonHang: " + donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang() + " " +
                        "soLuong: " + donDatHangChiTiet.getSoLuong() + " " +
                        "kichCoSanPham: " + donDatHangChiTiet.getKichCoSanPham() + " " +
                        "mauSacSanPham: " + donDatHangChiTiet.getMauSacSanPham() + " " +
                        "giaLucMua: " + donDatHangChiTiet.getGiaLucMua() + " " +
                        "hoaDonID: " + donDatHangChiTiet.getHoaDonID()
                );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        button_XacNhanMuaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nguoiDungID = Integer.parseInt(SharedPreferencesManager.getInstance(getApplicationContext()).sharedPreferencesGetNguoiDungID());
                String tinhTrangXacNhan = "Chưa xác nhận";
                String thoiGianDat = getCurrentTime() ;

                InsertDataDonHangChiTiet(donDatHangChiTiet.getSanPhamID(),
                        nguoiDungID,
                        donDatHangChiTiet.getTenSanPham(),
                        donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang(),
                        donDatHangChiTiet.getMauSacSanPham(),
                        donDatHangChiTiet.getKichCoSanPham(),
                        donDatHangChiTiet.getGiaLucMua(),
                        tinhTrangXacNhan,
                        thoiGianDat,
                        donDatHangChiTiet.getSoLuong(),
                        donDatHangID,
                        hoaDonID
                        );
            }
        });
    }

    private void showProgressBarFor2Seconds() {
        // Hiển thị progressBar
        loaddingBar.setVisibility(View.VISIBLE);

        // Tạo một Handler để đặt thời gian độ trễ
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Ẩn progressBar sau 2 giây
                loaddingBar.setVisibility(View.GONE);
            }
        }, 2000); // 2000 milliseconds = 2 giây
    }
    private Float capNhatTongTien(int soLuong, float giaLucMua) {
        showProgressBarFor2Seconds();
        Float kq = soLuong*giaLucMua;
        return kq;
    }

    private void anhXa() {
        iamgeView_AnhSanPhamInXacNhanMua = findViewById(R.id.iamgeView_AnhSanPhamInXacNhanMua);
        icon_back = findViewById(R.id.icon_back);
        textView_TenSanPhamInXacNhanMua = findViewById(R.id.textView_TenSanPhamInXacNhanMua);
        textView_MauSacInXacNhan = findViewById(R.id.textView_MauSacInXacNhan);
        textView_KichCoInXacNhan = findViewById(R.id.textView_KichCoInXacNhan);
        textView_GiaInXacNhan = findViewById(R.id.textView_GiaInXacNhan);
        textView_TongTienInXacNhan = findViewById(R.id.textView_TongTienInXacNhan);
        button_XacNhanMuaSanPham = findViewById(R.id.button_XacNhanMuaSanPham);
        spinner_SoLuongInXacNhan = findViewById(R.id.spinner_SoLuongInXacNhan);
        loaddingBar = findViewById(R.id.loaddingBar);
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
}