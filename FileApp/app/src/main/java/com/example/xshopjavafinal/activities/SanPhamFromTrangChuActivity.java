package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.SanPhamAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataSanPham;
import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.models.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamFromTrangChuActivity extends AppCompatActivity implements SanPhamAdapter.OnItemClickSanPhamInBoSuuTapListener {
    private RecyclerView recycleView_SanPhamFromTrangChu;
    private ImageView image_BoSuuTapInSanPhamFromTrangChu;
    private TextView textView_TenBoSuuTapInSanPhamFromTrangChu, textView_MoTaSanPhamFromTrangChu;
    private List<SanPham> mList;
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_from_trang_chu);
        BoSuuTap boSuuTap = (BoSuuTap) getIntent().getExtras().get("boSuuTapFromTrangChu");

        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), this);

        recycleView_SanPhamFromTrangChu = findViewById(R.id.recycleView_SanPhamFromTrangChu);
        image_BoSuuTapInSanPhamFromTrangChu = findViewById(R.id.image_BoSuuTapInSanPhamFromTrangChu);
        textView_TenBoSuuTapInSanPhamFromTrangChu = findViewById(R.id.textView_TenBoSuuTapInSanPhamFromTrangChu);
        textView_MoTaSanPhamFromTrangChu = findViewById(R.id.textView_MoTaSanPhamFromTrangChu);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recycleView_SanPhamFromTrangChu.setLayoutManager(layoutManager);
        recycleView_SanPhamFromTrangChu.setAdapter(sanPhamAdapter);

        mList = new ArrayList<>();
        if (boSuuTap != null){
            getDataSanPhamFromTrangChu(boSuuTap.getBoSuuTapID());
            Picasso.get().load(boSuuTap.getAnhDaiDienBoSuuTap()).into(image_BoSuuTapInSanPhamFromTrangChu);
            textView_MoTaSanPhamFromTrangChu.setText(boSuuTap.getMoTaBoSuuTap());
            textView_TenBoSuuTapInSanPhamFromTrangChu.setText(boSuuTap.getTenBoSuuTap());
        }

    }



    private void getDataSanPhamFromTrangChu(int boSuuTapID) {


        ApiServiceDataSanPham.apiServiceDataSanPham.getDataSanPhamByBoSuuTapID(boSuuTapID)
                .enqueue(new Callback<List<SanPham>>() {

                    @Override
                    public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                        Log.d("onResponseOfgetDataSanPhamFromTrangChu", response.body().toString());
                        mList = response.body();
                        sanPhamAdapter.setData(mList);
                    }

                    @Override
                    public void onFailure(Call<List<SanPham>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onItemClick(SanPham sanPham) {
        Intent intent = new Intent(this, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("chiTietSanPham", sanPham);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}