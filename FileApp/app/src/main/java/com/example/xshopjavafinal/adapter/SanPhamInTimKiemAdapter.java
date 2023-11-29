package com.example.xshopjavafinal.adapter;

//public class SanPhamInTimKiemAdapter {
//}




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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SanPhamInTimKiemAdapter extends RecyclerView.Adapter<SanPhamInTimKiemAdapter.SanPhamInTimKiemViewHolder> {
    private List<SanPham> mList;
    private Context context;
    private OnItemClickSanPhamInTimKiemListener onItemClickSanPhamInTimKiemListener;

    public SanPhamInTimKiemAdapter(Context context, OnItemClickSanPhamInTimKiemListener onItemClickSanPhamInTimKiemListener) {
        this.context = context;
        this.onItemClickSanPhamInTimKiemListener = onItemClickSanPhamInTimKiemListener;
        mList = new ArrayList<>();
    }

    public void setData(List<SanPham> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamInTimKiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_in_timkiem, parent, false);
        return new SanPhamInTimKiemViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull SanPhamInTimKiemViewHolder holder, int position) {
        SanPham sanPham = mList.get(position);
        holder.textView_TenSanPhamInTimKiem.setText(sanPham.getTenSanPham());
        holder.textView_GiaInTimKiem.setText(sanPham.getGia().toString());
        holder.textView_GiaKhuyenMaiInTimKiem.setText(sanPham.getGiaKhuyenMai().toString());
        Picasso.get().load(sanPham.getAnhDaiDienSanPham()).into(holder.image_itemSanPhamInTimKiem);


        holder.itemView.setOnClickListener(view -> {
            if (onItemClickSanPhamInTimKiemListener != null) {
                onItemClickSanPhamInTimKiemListener.onItemClickInTimKiem(sanPham);
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

    public static class SanPhamInTimKiemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_TenSanPhamInTimKiem, textView_GiaInTimKiem, textView_GiaKhuyenMaiInTimKiem;
        private ImageView image_itemSanPhamInTimKiem;

        public SanPhamInTimKiemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_TenSanPhamInTimKiem = itemView.findViewById(R.id.textView_TenSanPhamInTimKiem);
            textView_GiaInTimKiem = itemView.findViewById(R.id.textView_GiaInTimKiem);
            textView_GiaKhuyenMaiInTimKiem = itemView.findViewById(R.id.textView_GiaKhuyenMaiInTimKiem);
            image_itemSanPhamInTimKiem = itemView.findViewById(R.id.image_itemSanPhamInTimKiem);
        }
    }

    public interface OnItemClickSanPhamInTimKiemListener {
        void onItemClickInTimKiem(SanPham sanPham);
    }

}
