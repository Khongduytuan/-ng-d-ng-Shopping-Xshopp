package com.example.xshopjavafinal.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.MainActivity;
import com.example.xshopjavafinal.activities.SanPhamFromTrangChuActivity;
import com.example.xshopjavafinal.adapter.BoSuuTapAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataBoSuuTap;
import com.example.xshopjavafinal.models.BoSuuTap;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrangChuFragment extends Fragment implements BoSuuTapAdapter.OnItemClickListener {
    private RecyclerView recycleView_BoSuuTap_TrangChu;
    private MainActivity mainActivity;
    private BoSuuTapAdapter boSuuTapAdapter;
    private List<BoSuuTap> mList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        mainActivity = (MainActivity) getActivity();
        recycleView_BoSuuTap_TrangChu = view.findViewById(R.id.recycleView_BoSuuTap_TrangChu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        recycleView_BoSuuTap_TrangChu.setLayoutManager(linearLayoutManager);

        mList = new ArrayList<>();

        boSuuTapAdapter = new BoSuuTapAdapter(mainActivity, this);
        recycleView_BoSuuTap_TrangChu.setAdapter(boSuuTapAdapter);
        GetDataBoSuuTap();
        return view;
    }
    private void GetDataBoSuuTap() {
        ApiServiceDataBoSuuTap.apiServiceGetDataBoSuuTap.getDataBoSuuTap().enqueue(new Callback<List<BoSuuTap>>() {
            @Override
            public void onResponse(Call<List<BoSuuTap>> call, Response<List<BoSuuTap>> response) {
                mList = response.body();
                boSuuTapAdapter.setData(mList);
               Log.d("respone", response.body().toString());

            }

            @Override
            public void onFailure(Call<List<BoSuuTap>> call, Throwable t) {
                Log.d("errorGetDataUser", t.toString());
            }
        });

    }

    @Override
    public void onItemClick(BoSuuTap boSuuTap) {

        Intent intent = new Intent(getActivity(), SanPhamFromTrangChuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("boSuuTapFromTrangChu", boSuuTap);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        GetDataBoSuuTap();
    }
}