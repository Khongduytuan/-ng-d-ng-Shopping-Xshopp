package com.example.xshopjavafinal.adapter;

//public class SanPhamAdapterFromDanhMuc {
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
import com.example.xshopjavafinal.models.SanPham;
import com.example.xshopjavafinal.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SanPhamAdapterFromDanhMuc extends RecyclerView.Adapter<SanPhamAdapterFromDanhMuc.SanPhamFromDanhMucViewHolder> {
    private List<SanPham> mList;
    private Context context;
    private OnItemClickSanPhamFromDanhMucListener onItemClickSanPhamFromDanhMucListener;

    public SanPhamAdapterFromDanhMuc(Context context, OnItemClickSanPhamFromDanhMucListener onItemClickSanPhamFromDanhMucListener) {
        this.context = context;
        this.onItemClickSanPhamFromDanhMucListener = onItemClickSanPhamFromDanhMucListener;
        mList = new ArrayList<>();
    }

    public void setData(List<SanPham> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamFromDanhMucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_from_danhmuc, parent, false);
        return new SanPhamFromDanhMucViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull SanPhamFromDanhMucViewHolder holder, int position) {
        SanPham sanPham = mList.get(position);
        holder.textView_TenSanPhamFromDanhMuc.setText(sanPham.getTenSanPham());
        holder.textView_GiaFromDanhMuc.setText(Util.formatNumber(sanPham.getGia().toString()));
        holder.textView_GiaKhuyenMaiFromDanhMuc.setText(Util.formatNumber(sanPham.getGiaKhuyenMai().toString()));
        Picasso.get().load(sanPham.getAnhDaiDienSanPham()).into(holder.image_itemSanPhamFromDanhMuc);


        holder.itemView.setOnClickListener(view -> {
            if (onItemClickSanPhamFromDanhMucListener != null) {
                onItemClickSanPhamFromDanhMucListener.onItemClick(sanPham);
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

    public static class SanPhamFromDanhMucViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_TenSanPhamFromDanhMuc, textView_GiaFromDanhMuc, textView_GiaKhuyenMaiFromDanhMuc;
        private ImageView image_itemSanPhamFromDanhMuc;

        public SanPhamFromDanhMucViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_TenSanPhamFromDanhMuc = itemView.findViewById(R.id.textView_TenSanPhamFromDanhMuc);
            textView_GiaFromDanhMuc = itemView.findViewById(R.id.textView_GiaFromDanhMuc);
            textView_GiaKhuyenMaiFromDanhMuc = itemView.findViewById(R.id.textView_GiaKhuyenMaiFromDanhMuc);
            image_itemSanPhamFromDanhMuc = itemView.findViewById(R.id.image_itemSanPhamFromDanhMuc);
        }
    }

    public interface OnItemClickSanPhamFromDanhMucListener {
        void onItemClick(SanPham sanPham);
    }

}