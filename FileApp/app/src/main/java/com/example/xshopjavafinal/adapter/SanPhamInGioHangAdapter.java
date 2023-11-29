package com.example.xshopjavafinal.adapter;

//public class SanPhamInGioHangAdapter {
//}


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.example.xshopjavafinal.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SanPhamInGioHangAdapter extends RecyclerView.Adapter<SanPhamInGioHangAdapter.SanPhamInGioHangViewHolder> {
    private List<DonDatHangChiTiet> mList;
    private Float tongTien;
    private Context context;
    private OnItemClickSanPhamInGioHangListener onItemClickSanPhamInGioHangListener;
    private OnItemClickDeleteSanPhamInGioHangListener onItemClickDeleteSanPhamInGioHangListener;

    public SanPhamInGioHangAdapter(
            Context context,
            OnItemClickSanPhamInGioHangListener onItemClickSanPhamInGioHangListener,
            OnItemClickDeleteSanPhamInGioHangListener onItemClickDeleteSanPhamInGioHangListener) {
        this.context = context;
        this.onItemClickSanPhamInGioHangListener = onItemClickSanPhamInGioHangListener;
        this.onItemClickDeleteSanPhamInGioHangListener = onItemClickDeleteSanPhamInGioHangListener;
        mList = new ArrayList<>();
    }

    public void setData(List<DonDatHangChiTiet> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamInGioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_in_giohang, parent, false);
        return new SanPhamInGioHangViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull SanPhamInGioHangViewHolder holder, int position) {

        DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
        Picasso.get().load(donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang())
                .into(holder.iamgeView_AnhSanPhamInGioHang);

        holder.textView_TenSanPhamInGioHang.setText(donDatHangChiTiet.getTenSanPham());
        holder.textView_MauSacInGioHang.setText(donDatHangChiTiet.getMauSacSanPham());
        holder.textView_KichCoInGioHang.setText(donDatHangChiTiet.getKichCoSanPham());
        holder.textView_GiaInGioHang.setText(Util.formatNumber(String.valueOf(donDatHangChiTiet.getGiaLucMua())));
        holder.edit_soLuong.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));

        holder.image_tangSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donDatHangChiTiet.TangSoLuong();
                holder.edit_soLuong.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));
                updateSoLuong(position, donDatHangChiTiet.getSoLuong());
                capNhatTongTien();
            }
        });

        holder.image_giamSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donDatHangChiTiet.GiamSoLuong();
                holder.edit_soLuong.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));
                updateSoLuong(position, donDatHangChiTiet.getSoLuong());
                capNhatTongTien();

            }
        });


        holder.itemView.setOnClickListener(view -> {
            if (onItemClickSanPhamInGioHangListener != null) {
                onItemClickSanPhamInGioHangListener.onItemClickInGioHang(donDatHangChiTiet);
            }
        });

        holder.delete_sanPham.setOnClickListener(view -> {
            if (onItemClickDeleteSanPhamInGioHangListener != null){
                onItemClickDeleteSanPhamInGioHangListener.onItemClickDeleteInGioHang(donDatHangChiTiet);
            }

        });


    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public void updateSoLuong(int position, int newSoLuong) {
        if (position >= 0 && position < mList.size()) {
            DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
            donDatHangChiTiet.setSoLuong(newSoLuong);
            notifyDataSetChanged();

            // Lưu vào SharedPreferences
            SharedPreferencesManager.getInstance(context).saveOrderList(mList);
        }
    }

    public void updateSoLuong2(int position, int newSoLuong) {
        if (position >= 0 && position < mList.size()) {
            DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
            int oldSoLuong = donDatHangChiTiet.getSoLuong();
            donDatHangChiTiet.setSoLuong(newSoLuong);

            // Giảm giá trị cũ khi số lượng giảm
            tongTien -= donDatHangChiTiet.getGiaLucMua() * oldSoLuong;

            // Thêm giá trị mới khi số lượng tăng
            tongTien += donDatHangChiTiet.getGiaLucMua() * newSoLuong;

            notifyDataSetChanged();

            // Lưu vào SharedPreferences
            SharedPreferencesManager.getInstance(context).saveOrderList(mList);
        }
    }

    private void capNhatTongTien() {
        tongTien = 0f;
        for (DonDatHangChiTiet donDatHangChiTiet : mList) {
            tongTien += donDatHangChiTiet.getGiaLucMua() * donDatHangChiTiet.getSoLuong();
        }

    }


    public static class SanPhamInGioHangViewHolder extends RecyclerView.ViewHolder {

        private ImageView delete_sanPham, iamgeView_AnhSanPhamInGioHang;
        private ProgressBar loaddingBar_InGioHang;
        private TextView textView_TenSanPhamInGioHang, textView_MauSacInGioHang, textView_KichCoInGioHang,
                textView_GiaInGioHang;

        private ImageView image_tangSoLuong, image_giamSoLuong;
        private EditText edit_soLuong;


        public SanPhamInGioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            delete_sanPham = itemView.findViewById(R.id.delete_sanPham);
            textView_TenSanPhamInGioHang = itemView.findViewById(R.id.textView_TenSanPhamInGioHang);
            textView_MauSacInGioHang = itemView.findViewById(R.id.textView_MauSacInGioHang);
            textView_KichCoInGioHang = itemView.findViewById(R.id.textView_KichCoInGioHang);
            textView_GiaInGioHang = itemView.findViewById(R.id.textView_GiaInGioHang);
            iamgeView_AnhSanPhamInGioHang = itemView.findViewById(R.id.iamgeView_AnhSanPhamInGioHang);
            image_tangSoLuong = itemView.findViewById(R.id.image_tangSoLuong);
            image_giamSoLuong = itemView.findViewById(R.id.image_giamSoLuong);
            edit_soLuong = itemView.findViewById(R.id.edit_soLuong);

        }
    }

    public interface OnItemClickSanPhamInGioHangListener {
        void onItemClickInGioHang(DonDatHangChiTiet donDatHangChiTiet);
    }

    public interface OnItemClickDeleteSanPhamInGioHangListener {
        void onItemClickDeleteInGioHang(DonDatHangChiTiet donDatHangChiTiet);
    }
}
