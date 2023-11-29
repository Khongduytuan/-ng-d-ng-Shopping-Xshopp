package com.example.xshopjavafinal.adapter;

//public class DonHangChiTietTheoDoiAdapter {
//}


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.util.Util;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DonHangChiTietTheoDoiAdapter extends RecyclerView.Adapter<DonHangChiTietTheoDoiAdapter.DonHangChiTietTheoDoiViewHolder> {
    private List<DonDatHangChiTiet> mList;
    private Context context;

    public DonHangChiTietTheoDoiAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setData(List<DonDatHangChiTiet> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DonHangChiTietTheoDoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_in_theodoidonhang, parent, false);
        return new DonHangChiTietTheoDoiViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull DonHangChiTietTheoDoiViewHolder holder, int position) {

        DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
        Picasso.get().load(donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang()).into(holder.image_itemSanPhamInTimKiem);
        holder.textView_GiaKhuyenMaiInTheoDoi.setText(Util.formatNumber(String.valueOf(donDatHangChiTiet.getGiaLucMua())));
        holder.textView_KichCoInTheoDoi.setText(donDatHangChiTiet.getKichCoSanPham());
        holder.textView_MauSacInTheoDoi.setText(donDatHangChiTiet.getMauSacSanPham());
        holder.textView_TenSanPhamInTheoDoi.setText(donDatHangChiTiet.getTenSanPham());
        holder.textView_tinhTrangXacNhanInTheoDoi.setText(donDatHangChiTiet.getTinhTrangXacNhan());
        holder.textView_SoLuongInTheoDoi.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));


    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public static class DonHangChiTietTheoDoiViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_itemSanPhamInTimKiem;
        private TextView textView_TenSanPhamInTheoDoi,
                textView_GiaKhuyenMaiInTheoDoi,
                textView_KichCoInTheoDoi,
                textView_MauSacInTheoDoi,
                textView_tinhTrangXacNhanInTheoDoi, textView_SoLuongInTheoDoi;



        public DonHangChiTietTheoDoiViewHolder(@NonNull View itemView) {
            super(itemView);
            image_itemSanPhamInTimKiem = itemView.findViewById(R.id.image_itemSanPhamInTimKiem);
            textView_TenSanPhamInTheoDoi = itemView.findViewById(R.id.textView_TenSanPhamInTheoDoi);
            textView_GiaKhuyenMaiInTheoDoi = itemView.findViewById(R.id.textView_GiaKhuyenMaiInTheoDoi);
            textView_KichCoInTheoDoi = itemView.findViewById(R.id.textView_KichCoInTheoDoi);
            textView_MauSacInTheoDoi = itemView.findViewById(R.id.textView_MauSacInTheoDoi);
            textView_tinhTrangXacNhanInTheoDoi = itemView.findViewById(R.id.textView_tinhTrangXacNhanInTheoDoi);
            textView_SoLuongInTheoDoi = itemView.findViewById(R.id.textView_SoLuongInTheoDoi);



        }
    }



}

