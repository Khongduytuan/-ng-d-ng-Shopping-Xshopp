package com.example.xshopjavafinal.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.activities.LichSuDonHangActivity;
import com.example.xshopjavafinal.activities.LoginActivity;
import com.example.xshopjavafinal.activities.TinhTrangDonHangActivity;
import com.example.xshopjavafinal.activities.UpdateInforUserClientActivity;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;


public class HoSoCaNhanFragment extends Fragment {

    private LinearLayout linear_lichsudonhang, linaer_nguoidung, linear_theodoidonhang, linear_signout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ho_so_ca_nhan, container, false);
        anhXa(view);


        linear_lichsudonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LichSuDonHangActivity.class);
                startActivity(intent);
            }
        });


        linaer_nguoidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UpdateInforUserClientActivity.class);
                startActivity(intent);
            }
        });


        linear_theodoidonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TinhTrangDonHangActivity.class);
                startActivity(intent);
            }
        });

        linear_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesManager.getInstance(getContext()).clearAllData();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();

            }
        });
        return view;
    }

    private void anhXa(View view) {
        linear_lichsudonhang = view.findViewById(R.id.linear_lichsudonhang);
        linaer_nguoidung = view.findViewById(R.id.linaer_nguoidung);
        linear_theodoidonhang = view.findViewById(R.id.linear_theodoidonhang);
        linear_signout = view.findViewById(R.id.linear_signout);
    }
}