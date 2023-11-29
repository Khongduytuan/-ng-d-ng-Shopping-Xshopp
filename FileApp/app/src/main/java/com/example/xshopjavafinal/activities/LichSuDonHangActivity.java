package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.DonHangChiTietLichSuAdapter;
import com.example.xshopjavafinal.adapter.DonHangChiTietTheoDoiAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.util.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuDonHangActivity extends AppCompatActivity {

    private ImageView icon_backInLichSu;
    private RecyclerView recycleViewSanPhamInLichSu;
    private List<DonDatHangChiTiet> mList;
    private DonHangChiTietLichSuAdapter donHangChiTietLichSuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_don_hang);
        anhXa();
        mList = new ArrayList<>();
        donHangChiTietLichSuAdapter = new DonHangChiTietLichSuAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleViewSanPhamInLichSu.setLayoutManager(linearLayoutManager);
        recycleViewSanPhamInLichSu.setAdapter(donHangChiTietLichSuAdapter);
        icon_backInLichSu.setOnClickListener(view -> onBackPressed());

        GetDonHangChiTietTrongManHinhTheoDoi(Util.DA_GIAO_THANH_CONG);

    }


    private void GetDonHangChiTietTrongManHinhTheoDoi(String keyWord) {


        ApiServiceDataDonDatHangChiTiet.apiServiceDataDonDatHangChiTiet.getDataDonDatHangChiTiet(keyWord)
                .enqueue(new Callback<List<DonDatHangChiTiet>>() {

                    @Override
                    public void onResponse(Call<List<DonDatHangChiTiet>> call, Response<List<DonDatHangChiTiet>> response) {
                        List<DonDatHangChiTiet> rsList = new ArrayList<>();
                        rsList = response.body();
                        mList.addAll(rsList);
                        donHangChiTietLichSuAdapter.setData(mList);
                    }

                    @Override
                    public void onFailure(Call<List<DonDatHangChiTiet>> call, Throwable t) {

                    }
                });
    }

    private void anhXa() {
        icon_backInLichSu = findViewById(R.id.icon_backInLichSu);
        recycleViewSanPhamInLichSu = findViewById(R.id.recycleViewSanPhamInLichSu);
    }
}