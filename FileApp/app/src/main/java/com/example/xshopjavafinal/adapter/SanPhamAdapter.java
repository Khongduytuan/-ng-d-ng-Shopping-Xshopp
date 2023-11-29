package com.example.xshopjavafinal.adapter;

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
import com.example.xshopjavafinal.models.SanPham;
import com.example.xshopjavafinal.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {
    private List<SanPham> mList;
    private Context context;
    private OnItemClickSanPhamInBoSuuTapListener onItemClickSanPhamInBoSuuTapListener;

    public SanPhamAdapter(Context context, OnItemClickSanPhamInBoSuuTapListener onItemClickSanPhamInBoSuuTapListener) {
        this.context = context;
        this.onItemClickSanPhamInBoSuuTapListener = onItemClickSanPhamInBoSuuTapListener;
        mList = new ArrayList<>();
    }

    public void setData(List<SanPham> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_in_bosuutap, parent, false);
        return new SanPhamViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = mList.get(position);
        holder.textView_TenSanPhamInBoSuuTap.setText(sanPham.getTenSanPham());
        holder.textView_Gia.setText(Util.formatNumber(sanPham.getGia().toString()));
        holder.textView_GiaKhuyenMai.setText(Util.formatNumber(sanPham.getGiaKhuyenMai().toString()));
        Picasso.get().load(sanPham.getAnhDaiDienSanPham()).into(holder.image_itemSanPhamInBoSuuTap);

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickSanPhamInBoSuuTapListener != null) {
                onItemClickSanPhamInBoSuuTapListener.onItemClick(sanPham);
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

    public static class SanPhamViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_TenSanPhamInBoSuuTap, textView_Gia, textView_GiaKhuyenMai;
        private ImageView image_itemSanPhamInBoSuuTap;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_TenSanPhamInBoSuuTap = itemView.findViewById(R.id.textView_TenSanPhamInBoSuuTap);
            textView_Gia = itemView.findViewById(R.id.textView_Gia);
            textView_GiaKhuyenMai = itemView.findViewById(R.id.textView_GiaKhuyenMai);
            image_itemSanPhamInBoSuuTap = itemView.findViewById(R.id.image_itemSanPhamInBoSuuTap);
        }
    }

    public interface OnItemClickSanPhamInBoSuuTapListener {
        void onItemClick(SanPham sanPham);
    }

}