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
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.MainActivity;
import com.example.xshopjavafinal.activities.MainActivityForAdmin;
import com.example.xshopjavafinal.adapter.ThongBaoAdapter;
import com.example.xshopjavafinal.adapter.ThongBaoAdminAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataThongBao;
import com.example.xshopjavafinal.models.ThongBao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationAdminFragment extends Fragment implements
        ThongBaoAdminAdapter.OnItemClickDeleteThongBaoListener,
        ThongBaoAdminAdapter.OnItemClickThongBaoListener {

    private RecyclerView recycleView_thongBaoAdmin;
    private List<ThongBao> mList;
    private ThongBaoAdminAdapter thongBaoAdminAdapter;
    private MainActivityForAdmin mainActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_admin, container, false);
        mainActivity = (MainActivityForAdmin) getActivity();
        recycleView_thongBaoAdmin = view.findViewById(R.id.recycleView_thongBaoAdmin);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        recycleView_thongBaoAdmin.setLayoutManager(linearLayoutManager);

        mList = new ArrayList<>();

        thongBaoAdminAdapter = new ThongBaoAdminAdapter(mainActivity, this, this);
        recycleView_thongBaoAdmin.setAdapter(thongBaoAdminAdapter);
        GetDataThongBaoAdmin();
        return view;
    }

    private void GetDataThongBaoAdmin() {
        ApiServiceDataThongBao
                .apiServiceDataThongBao
                .getDataThongBao()
                .enqueue(new Callback<List<ThongBao>>() {
                    @Override
                    public void onResponse(Call<List<ThongBao>> call, Response<List<ThongBao>> response) {
                        mList = response.body();
                        thongBaoAdminAdapter.setData(mList);

                    }

                    @Override
                    public void onFailure(Call<List<ThongBao>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onItemClickThongBao(ThongBao thongBao) {


    }

    @Override
    public void onItemClickDeleteThongBao(ThongBao thongBao) {
        DeleteThongBao(thongBao);
        mList.remove(thongBao);
        thongBaoAdminAdapter.setData(mList);
    }

    private void DeleteThongBao(ThongBao thongBao) {
        ApiServiceDataThongBao
                .apiServiceDataThongBao
                .deleteDataThongBao(thongBao.getThongBaoID())
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("thanhcong")){
                            Toast.makeText(mainActivity, "Đã xóa thông báo!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(mainActivity, "Lỗi khi xóa thông báo!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

    }


    @Override
    public void onResume() {
        super.onResume();
        GetDataThongBaoAdmin();
    }
}