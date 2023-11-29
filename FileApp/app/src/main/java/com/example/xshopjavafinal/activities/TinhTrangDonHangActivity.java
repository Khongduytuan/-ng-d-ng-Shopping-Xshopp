package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.DonHangChiTietTheoDoiAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.api.ApiServiceDataMauSac;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.models.MauSac;
import com.example.xshopjavafinal.util.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TinhTrangDonHangActivity extends AppCompatActivity {
    private ImageView icon_backInTheoDoi;
    private RecyclerView recycleViewSanPhamInTheoDoi;
    private List<DonDatHangChiTiet> mList;
    private DonHangChiTietTheoDoiAdapter donHangChiTietTheoDoiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_trang_don_hang);
        anhXa();
        mList = new ArrayList<>();
        donHangChiTietTheoDoiAdapter = new DonHangChiTietTheoDoiAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleViewSanPhamInTheoDoi.setLayoutManager(linearLayoutManager);
        recycleViewSanPhamInTheoDoi.setAdapter(donHangChiTietTheoDoiAdapter);
        icon_backInTheoDoi.setOnClickListener(view -> onBackPressed());

        GetDonHangChiTietTrongManHinhTheoDoi(Util.CHUA_XAC_NHAN);
        GetDonHangChiTietTrongManHinhTheoDoi(Util.DA_XAC_NHAN);
        GetDonHangChiTietTrongManHinhTheoDoi(Util.DANG_GIAO);

    }


    private void GetDonHangChiTietTrongManHinhTheoDoi(String keyWord) {


        ApiServiceDataDonDatHangChiTiet.apiServiceDataDonDatHangChiTiet.getDataDonDatHangChiTiet(keyWord)
                .enqueue(new Callback<List<DonDatHangChiTiet>>() {

                    @Override
                    public void onResponse(Call<List<DonDatHangChiTiet>> call, Response<List<DonDatHangChiTiet>> response) {
                        List<DonDatHangChiTiet> rsList = new ArrayList<>();
                        rsList = response.body();
                        mList.addAll(rsList);
                        donHangChiTietTheoDoiAdapter.setData(mList);
                    }

                    @Override
                    public void onFailure(Call<List<DonDatHangChiTiet>> call, Throwable t) {

                    }
                });
    }

    private void anhXa() {
        icon_backInTheoDoi = findViewById(R.id.icon_backInTheoDoi);
        recycleViewSanPhamInTheoDoi = findViewById(R.id.recycleViewSanPhamInTheoDoi);
    }
}