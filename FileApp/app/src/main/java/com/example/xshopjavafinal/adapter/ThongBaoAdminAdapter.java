package com.example.xshopjavafinal.adapter;

//public class ThongBaoAdminAdapter {
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
import com.example.xshopjavafinal.models.ThongBao;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoAdminAdapter extends RecyclerView.Adapter<ThongBaoAdminAdapter.ThongBaoAdminViewHolder> {
    private List<ThongBao> mList;
    private Context context;
    private OnItemClickThongBaoListener onItemClickThongBaoListener;
    private OnItemClickDeleteThongBaoListener onItemClickDeleteThongBaoListener;


    public ThongBaoAdminAdapter(Context context,
                                OnItemClickThongBaoListener onItemClickThongBaoListener,
                                OnItemClickDeleteThongBaoListener onItemClickDeleteThongBaoListener) {
        this.context = context;
        this.onItemClickThongBaoListener = onItemClickThongBaoListener;
        this.onItemClickDeleteThongBaoListener = onItemClickDeleteThongBaoListener;
        mList = new ArrayList<>();
    }

    public void setData(List<ThongBao> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThongBaoAdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao_amin, parent, false);
        return new ThongBaoAdminViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ThongBaoAdminViewHolder holder, int position) {
        ThongBao thongBao = mList.get(position);
        holder.textView_itemTenThongBaoAdmin.setText(thongBao.getTenThongBao());
        holder.textView_itemNoiDungThongBaoAdmin.setText(thongBao.getNoiDungThongBao());
        holder.imageView_deleteThongBaoAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickDeleteThongBaoListener != null){
                    onItemClickDeleteThongBaoListener.onItemClickDeleteThongBao(thongBao);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                onItemClickThongBaoListener.onItemClickThongBao(thongBao);
                return true;
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

    public static class ThongBaoAdminViewHolder extends RecyclerView.ViewHolder {


        private TextView textView_itemTenThongBaoAdmin, textView_itemNoiDungThongBaoAdmin;
        private ImageView imageView_deleteThongBaoAdmin;

        public ThongBaoAdminViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_itemTenThongBaoAdmin = itemView.findViewById(R.id.textView_itemTenThongBaoAdmin);
            textView_itemNoiDungThongBaoAdmin = itemView.findViewById(R.id.textView_itemNoiDungThongBaoAdmin);
            imageView_deleteThongBaoAdmin = itemView.findViewById(R.id.imageView_deleteThongBaoAdmin);

        }
    }

    public interface OnItemClickThongBaoListener {
        void onItemClickThongBao(ThongBao thongBao);
    }

    public interface OnItemClickDeleteThongBaoListener {
        void onItemClickDeleteThongBao(ThongBao thongBao);
    }
}
