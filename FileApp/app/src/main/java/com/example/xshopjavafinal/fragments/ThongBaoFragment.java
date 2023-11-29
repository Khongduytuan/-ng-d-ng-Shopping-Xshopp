package com.example.xshopjavafinal.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.MainActivity;
import com.example.xshopjavafinal.activities.MainActivityForAdmin;
import com.example.xshopjavafinal.adapter.DanhMucSanPhamAdapter;
import com.example.xshopjavafinal.adapter.ThongBaoAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataDanhMucSanPham;
import com.example.xshopjavafinal.api.ApiServiceDataThongBao;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.models.ThongBao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThongBaoFragment extends Fragment {
    private RecyclerView recycleView_thongBao;
    private List<ThongBao> mList;
    private ThongBaoAdapter thongBaoAdapter;
    private MainActivity mainActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_bao, container, false);
        mainActivity = (MainActivity) getActivity();
        recycleView_thongBao = view.findViewById(R.id.recycleView_thongBao);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        recycleView_thongBao.setLayoutManager(linearLayoutManager);

        mList = new ArrayList<>();

        thongBaoAdapter = new ThongBaoAdapter(mainActivity);
        recycleView_thongBao.setAdapter(thongBaoAdapter);
        GetDataThongBao();
        return view;
    }

    private void GetDataThongBao() {
        ApiServiceDataThongBao
                .apiServiceDataThongBao
                .getDataThongBao()
                .enqueue(new Callback<List<ThongBao>>() {
                    @Override
                    public void onResponse(Call<List<ThongBao>> call, Response<List<ThongBao>> response) {
                        mList = response.body();
                        thongBaoAdapter.setData(mList);

                    }

                    @Override
                    public void onFailure(Call<List<ThongBao>> call, Throwable t) {
                        Log.d("errorGetDataUser", t.toString());
                    }
                });
    }
}