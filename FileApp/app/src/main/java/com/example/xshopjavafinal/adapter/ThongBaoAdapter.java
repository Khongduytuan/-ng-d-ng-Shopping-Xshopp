package com.example.xshopjavafinal.adapter;

//public class ThongBaoAdapter {
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
import com.example.xshopjavafinal.models.ThongBao;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ThongBaoViewHolder> {
    private List<ThongBao> mList;
    private Context context;


    public ThongBaoAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setData(List<ThongBao> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThongBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao_nguoidung, parent, false);
        return new ThongBaoViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ThongBaoViewHolder holder, int position) {
        ThongBao thongBao = mList.get(position);
        holder.textView_itemTenThongBao.setText(thongBao.getTenThongBao());
        holder.textView_itemNoiDungThongBao.setText(thongBao.getNoiDungThongBao());

    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public static class ThongBaoViewHolder extends RecyclerView.ViewHolder {


        private TextView textView_itemTenThongBao, textView_itemNoiDungThongBao;

        public ThongBaoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_itemTenThongBao = itemView.findViewById(R.id.textView_itemTenThongBao);
            textView_itemNoiDungThongBao = itemView.findViewById(R.id.textView_itemNoiDungThongBao);

        }
    }
}
