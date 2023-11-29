package com.example.xshopjavafinal.fragments;

import static com.example.xshopjavafinal.R.id.recycleView_DanhMucSanPham;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.DanhSachSanPhamFromDanhMucActivity;
import com.example.xshopjavafinal.activities.MainActivity;
import com.example.xshopjavafinal.activities.SanPhamFromTrangChuActivity;
import com.example.xshopjavafinal.adapter.BoSuuTapAdapter;
import com.example.xshopjavafinal.adapter.DanhMucSanPhamAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataBoSuuTap;
import com.example.xshopjavafinal.api.ApiServiceDataDanhMucSanPham;
import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.models.DanhMucSanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DanhMucFragment extends Fragment implements DanhMucSanPhamAdapter.OnItemClickDanhMucListener {
    private RecyclerView recycleView_DanhMucSanPham;
    private MainActivity mainActivity;
    private DanhMucSanPhamAdapter danhMucSanPhamAdapter;
    private List<DanhMucSanPham> mList;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_muc, container, false);
        mainActivity = (MainActivity) getActivity();
        recycleView_DanhMucSanPham = view.findViewById(R.id.recycleView_DanhMucSanPham);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        recycleView_DanhMucSanPham.setLayoutManager(linearLayoutManager);

        mList = new ArrayList<>();

        danhMucSanPhamAdapter = new DanhMucSanPhamAdapter(mainActivity, this);
        recycleView_DanhMucSanPham.setAdapter(danhMucSanPhamAdapter);
        GetDataDanhMucSanPham();
        return view;
    }

    private void GetDataDanhMucSanPham() {
        ApiServiceDataDanhMucSanPham
                .apiServiceGetDataDanhMucSanPham
                .getDataDanhMucSanPham()
                .enqueue(new Callback<List<DanhMucSanPham>>() {
            @Override
            public void onResponse(Call<List<DanhMucSanPham>> call, Response<List<DanhMucSanPham>> response) {
                mList = response.body();
                danhMucSanPhamAdapter.setData(mList);
                Log.d("respone", response.body().toString());

            }

            @Override
            public void onFailure(Call<List<DanhMucSanPham>> call, Throwable t) {
                Log.d("errorGetDataUser", t.toString());
            }
        });
    }

    @Override
    public void onItemClick(DanhMucSanPham danhMucSanPham) {
        Toast.makeText(mainActivity, danhMucSanPham.getTenDanhMuc(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DanhSachSanPhamFromDanhMucActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("danhMucSanPham", danhMucSanPham);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        GetDataDanhMucSanPham();
    }
}