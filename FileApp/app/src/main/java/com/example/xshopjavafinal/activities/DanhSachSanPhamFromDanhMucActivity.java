package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.SanPhamAdapter;
import com.example.xshopjavafinal.adapter.SanPhamAdapterFromDanhMuc;
import com.example.xshopjavafinal.api.ApiServiceDataMauSac;
import com.example.xshopjavafinal.api.ApiServiceDataSanPham;
import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.models.MauSac;
import com.example.xshopjavafinal.models.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachSanPhamFromDanhMucActivity extends AppCompatActivity implements SanPhamAdapterFromDanhMuc.OnItemClickSanPhamFromDanhMucListener {
    private RecyclerView recycleView_DanhSachSanPhamFromDanhMuc;
    private List<SanPham> mList;
    private SanPhamAdapterFromDanhMuc sanPhamAdapterFromDanhMuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham_from_danh_muc);

        DanhMucSanPham danhMucSanPham = (DanhMucSanPham) getIntent().getExtras().get("danhMucSanPham");

        mList = new ArrayList<>();
        sanPhamAdapterFromDanhMuc = new SanPhamAdapterFromDanhMuc(getApplicationContext(), this);
        recycleView_DanhSachSanPhamFromDanhMuc = findViewById(R.id.recycleView_DanhSachSanPhamFromDanhMuc);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        recycleView_DanhSachSanPhamFromDanhMuc.setLayoutManager(layoutManager1);
        recycleView_DanhSachSanPhamFromDanhMuc.setAdapter(sanPhamAdapterFromDanhMuc);


        if (danhMucSanPham != null) {
            getDataSanPhamByDanhMucID(danhMucSanPham.getDanhMucSanPhamID());
        }
    }

    private void getDataSanPhamByDanhMucID(int danhMucID) {


        ApiServiceDataSanPham.apiServiceDataSanPham.getDataSanPhamByDanhMucID(danhMucID)
                .enqueue(new Callback<List<SanPham>>() {

                    @Override
                    public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                        mList = response.body();
                        sanPhamAdapterFromDanhMuc.setData(mList);
                    }

                    @Override
                    public void onFailure(Call<List<SanPham>> call, Throwable t) {

                    }
                });
    }


    public String formatNumber(String input) {
        try {
            long number = Long.parseLong(input);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            return decimalFormat.format(number);
        } catch (NumberFormatException e) {
            return "null";
        }
    }

    @Override
    public void onItemClick(SanPham sanPham) {
        Intent intent = new Intent(this, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("chiTietSanPham", sanPham);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}