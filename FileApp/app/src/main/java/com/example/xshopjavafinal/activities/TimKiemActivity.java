package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.SanPhamInTimKiemAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataSanPham;
import com.example.xshopjavafinal.models.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimKiemActivity extends AppCompatActivity implements SanPhamInTimKiemAdapter.OnItemClickSanPhamInTimKiemListener {
    private ImageView icon_backInTimKiem;
    private RecyclerView recycleViewSanPhamInTimKiem;
    private List<SanPham> mList;
    private SanPhamInTimKiemAdapter sanPhamInTimKiemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        anhXa();
        sanPhamInTimKiemAdapter = new SanPhamInTimKiemAdapter(getApplicationContext(), this);
        mList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleViewSanPhamInTimKiem.setLayoutManager(linearLayoutManager);
        recycleViewSanPhamInTimKiem.setAdapter(sanPhamInTimKiemAdapter);

        String keyWord = getIntent().getStringExtra("keyWord");
        if (keyWord != null){
            GetDataSanPhamByKeyWord(keyWord);
        }



        icon_backInTimKiem.setOnClickListener(view -> onBackPressed());
    }


    private void GetDataSanPhamByKeyWord(String chuoiKyTu) {
        ApiServiceDataSanPham
                .apiServiceDataSanPham
                .getDataSanPhamByTenSanPham(chuoiKyTu)
                .enqueue(new Callback<List<SanPham>>() {
                    @Override
                    public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                        mList = response.body();
                        sanPhamInTimKiemAdapter.setData(mList);


                    }

                    @Override
                    public void onFailure(Call<List<SanPham>> call, Throwable t) {

                    }
                });
    }

    private void anhXa() {
        icon_backInTimKiem = findViewById(R.id.icon_backInTimKiem);
        recycleViewSanPhamInTimKiem = findViewById(R.id.recycleViewSanPhamInTimKiem);
    }

    @Override
    public void onItemClickInTimKiem(SanPham sanPham) {
        Intent intent = new Intent(this, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("chiTietSanPham", sanPham);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}