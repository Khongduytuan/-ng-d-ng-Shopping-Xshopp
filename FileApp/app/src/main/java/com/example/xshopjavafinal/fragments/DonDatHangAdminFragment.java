package com.example.xshopjavafinal.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.MainActivity;
import com.example.xshopjavafinal.activities.MainActivityForAdmin;
import com.example.xshopjavafinal.adapter.BoSuuTapAdapter;
import com.example.xshopjavafinal.adapter.DonDatHangTrangThaiAdminAdapter;
import com.example.xshopjavafinal.adapter.DonHangChiTietTheoDoiAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.util.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonDatHangAdminFragment extends Fragment{
    private RecyclerView recycleView_DanhSachDonHangAdmin;
    private MainActivityForAdmin mainActivity;
    private DonDatHangTrangThaiAdminAdapter donDatHangTrangThaiAdminAdapter;
    private List<DonDatHangChiTiet> mList;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_don_dat_hang_admin, container, false);

        mainActivity = (MainActivityForAdmin) getActivity();
        recycleView_DanhSachDonHangAdmin = view.findViewById(R.id.recycleView_DanhSachDonHangAdmin);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        recycleView_DanhSachDonHangAdmin.setLayoutManager(linearLayoutManager);

        mList = new ArrayList<>();

        donDatHangTrangThaiAdminAdapter = new DonDatHangTrangThaiAdminAdapter(mainActivity);
        recycleView_DanhSachDonHangAdmin.setAdapter(donDatHangTrangThaiAdminAdapter);
        GetDonHangChiTietAdmin(Util.CHUA_XAC_NHAN);
        GetDonHangChiTietAdmin(Util.DA_XAC_NHAN);
        GetDonHangChiTietAdmin(Util.DANG_GIAO);
        GetDonHangChiTietAdmin(Util.DA_GIAO_THANH_CONG);
        return view;
    }

    private void GetDonHangChiTietAdmin(String keyWord) {


        ApiServiceDataDonDatHangChiTiet.apiServiceDataDonDatHangChiTiet.getDataDonDatHangChiTiet(keyWord)
                .enqueue(new Callback<List<DonDatHangChiTiet>>() {

                    @Override
                    public void onResponse(Call<List<DonDatHangChiTiet>> call, Response<List<DonDatHangChiTiet>> response) {
                        List<DonDatHangChiTiet> rsList;
                        rsList = response.body();
                        mList.addAll(rsList);
                        donDatHangTrangThaiAdminAdapter.setData(mList);
                    }

                    @Override
                    public void onFailure(Call<List<DonDatHangChiTiet>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}