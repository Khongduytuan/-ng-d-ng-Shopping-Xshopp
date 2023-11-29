package com.example.xshopjavafinal.adapter;

//public class KichCoAdapter {
//}

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.models.KichCo;
import com.example.xshopjavafinal.models.MauSac;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class KichCoAdapter extends RecyclerView.Adapter<KichCoAdapter.KichCoViewHolder> {
    private List<KichCo> mList;
    private Context context;
    private OnItemClickKichCoListener onItemClickKichCoListener;
    private int selectedItemPositionKichCo = RecyclerView.NO_POSITION;

    public KichCoAdapter(Context context, OnItemClickKichCoListener onItemClickKichCoListener) {
        this.context = context;
        this.onItemClickKichCoListener = onItemClickKichCoListener;
        mList = new ArrayList<>();
    }

    public void setData(List<KichCo> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KichCoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kichco, parent, false);
        return new KichCoViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull KichCoViewHolder holder, int position) {
        KichCo kichCo = mList.get(position);
        holder.item_KichCo.setText(kichCo.getKyHieuKichCoBangChu());

        if (position == selectedItemPositionKichCo) {
            holder.linear_itemKichCo.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.linear_itemKichCo.setBackgroundResource(0);
        }

        holder.itemView.setOnClickListener(view -> {
            if (position == selectedItemPositionKichCo) {
                holder.linear_itemKichCo.setBackgroundResource(0);
                setSelectedItemPositionKichCo(RecyclerView.NO_POSITION);
            } else {
                setSelectedItemPositionKichCo(position);
                holder.linear_itemKichCo.setBackgroundResource(R.drawable.selected_item_background);
            }

            if (onItemClickKichCoListener != null) {
                onItemClickKichCoListener.onItemClickKichCo(kichCo);
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

    public static class KichCoViewHolder extends RecyclerView.ViewHolder {
        private TextView item_KichCo;
        private LinearLayout linear_itemKichCo;

        public KichCoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_KichCo = itemView.findViewById(R.id.item_KichCo);
            linear_itemKichCo = itemView.findViewById(R.id.linear_itemKichCo);

        }
    }
    public void setSelectedItemPositionKichCo(int position) {
        int previousSelectedItemPosition = selectedItemPositionKichCo;
        selectedItemPositionKichCo = position;

        // Thông báo cho Adapter cập nhật lại item được chọn trước đó và item mới được chọn
        notifyItemChanged(previousSelectedItemPosition);
        notifyItemChanged(selectedItemPositionKichCo);
    }
    public interface OnItemClickKichCoListener {
        void onItemClickKichCo(KichCo kichCo);
    }


}