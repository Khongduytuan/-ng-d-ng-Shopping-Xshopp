package com.example.xshopjavafinal.adapter;

//public class DonHangChiTietLichSuAdapter {
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

public class DonHangChiTietLichSuAdapter extends RecyclerView.Adapter<DonHangChiTietLichSuAdapter.DonHangChiTietLichSuViewHolder> {
    private List<DonDatHangChiTiet> mList;
    private Context context;

    public DonHangChiTietLichSuAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setData(List<DonDatHangChiTiet> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DonHangChiTietLichSuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_in_lichsudonhang, parent, false);
        return new DonHangChiTietLichSuViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull DonHangChiTietLichSuViewHolder holder, int position) {

        DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
        Picasso.get().load(donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang()).into(holder.image_itemSanPhamInLichSu);
        holder.textView_GiaKhuyenMaiInLichSu.setText(Util.formatNumber(String.valueOf(donDatHangChiTiet.getGiaLucMua())));
        holder.textView_KichCoInLichSu.setText(donDatHangChiTiet.getKichCoSanPham());
        holder.textView_MauSacInLichSu.setText(donDatHangChiTiet.getMauSacSanPham());
        holder.textView_TenSanPhamInLichSu.setText(donDatHangChiTiet.getTenSanPham());
        holder.textView_tinhTrangXacNhanInLichSu.setText(donDatHangChiTiet.getTinhTrangXacNhan());
        holder.textView_SoLuongInLichSu.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));


    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public static class DonHangChiTietLichSuViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_itemSanPhamInLichSu;
        private TextView textView_TenSanPhamInLichSu,
                textView_GiaKhuyenMaiInLichSu,
                textView_KichCoInLichSu,
                textView_MauSacInLichSu,
                textView_tinhTrangXacNhanInLichSu, textView_SoLuongInLichSu;



        public DonHangChiTietLichSuViewHolder(@NonNull View itemView) {
            super(itemView);
            image_itemSanPhamInLichSu = itemView.findViewById(R.id.image_itemSanPhamInLichSu);
            textView_TenSanPhamInLichSu = itemView.findViewById(R.id.textView_TenSanPhamInLichSu);
            textView_GiaKhuyenMaiInLichSu = itemView.findViewById(R.id.textView_GiaKhuyenMaiInLichSu);
            textView_KichCoInLichSu = itemView.findViewById(R.id.textView_KichCoInLichSu);
            textView_MauSacInLichSu = itemView.findViewById(R.id.textView_MauSacInLichSu);
            textView_tinhTrangXacNhanInLichSu = itemView.findViewById(R.id.textView_tinhTrangXacNhanInLichSu);
            textView_SoLuongInLichSu = itemView.findViewById(R.id.textView_SoLuongInLichSu);



        }
    }



}

