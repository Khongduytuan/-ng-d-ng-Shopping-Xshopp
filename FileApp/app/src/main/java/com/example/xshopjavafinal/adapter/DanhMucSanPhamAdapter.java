package com.example.xshopjavafinal.adapter;

//public class DanhMucSanPhamAdapter {
//}


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.models.DanhMucSanPham;

import java.util.ArrayList;
import java.util.List;

public class DanhMucSanPhamAdapter extends RecyclerView.Adapter<DanhMucSanPhamAdapter.DanhMucSanPhamViewHolder> {
    private List<DanhMucSanPham> mList;
    private Context context;
    private OnItemClickDanhMucListener onItemClickDanhMucListener;

    public DanhMucSanPhamAdapter(Context context, OnItemClickDanhMucListener onItemClickDanhMucListener) {
        this.context = context;
        this.onItemClickDanhMucListener = onItemClickDanhMucListener;
        mList = new ArrayList<>();
    }

    public void setData(List<DanhMucSanPham> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhMucSanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmucsanpham, parent, false);
        return new DanhMucSanPhamViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull DanhMucSanPhamViewHolder holder, int position) {
        DanhMucSanPham danhMucSanPham = mList.get(position);
        holder.textView_tenDanhMuc.setText(danhMucSanPham.getTenDanhMuc());
        holder.itemView.setOnClickListener(view -> {
            if (onItemClickDanhMucListener != null) {
                onItemClickDanhMucListener.onItemClick(danhMucSanPham);
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

    public static class DanhMucSanPhamViewHolder extends RecyclerView.ViewHolder {


        private TextView textView_tenDanhMuc;

        public DanhMucSanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_tenDanhMuc = itemView.findViewById(R.id.textView_tenDanhMuc);

        }
    }

    public interface OnItemClickDanhMucListener {
        void onItemClick(DanhMucSanPham danhMucSanPham);
    }

}
