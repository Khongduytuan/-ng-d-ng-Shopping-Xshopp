package com.example.xshopjavafinal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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
import com.example.xshopjavafinal.models.MauSac;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MauSacAdapter extends RecyclerView.Adapter<MauSacAdapter.MauSacViewHolder> {
    private List<MauSac> mList;
    private Context context;
    private OnItemClickMauSacListener onItemClickMauSacListener;
    private int selectedItemPosition = RecyclerView.NO_POSITION;


    public MauSacAdapter(Context context, OnItemClickMauSacListener onItemClickMauSacListener) {
        this.context = context;
        this.onItemClickMauSacListener = onItemClickMauSacListener;
        mList = new ArrayList<>();
    }

    public void setData(List<MauSac> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MauSacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mausac, parent, false);
        return new MauSacViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MauSacViewHolder holder, int position) {
        MauSac mauSac = mList.get(position);
        holder.itemMauSac.setBackgroundColor(DoiMaMau(mauSac.getMaMauSac()));

        // Kiểm tra nếu item hiện tại được chọn, thiết lập viền xung quanh
        if (position == selectedItemPosition) {
            holder.linear_itemMauSac.setBackgroundResource(R.drawable.selected_item_background); // Thay drawable theo mong muốn của bạn
        } else {
            holder.linear_itemMauSac.setBackgroundResource(0); // Xóa viền xung quanh nếu không được chọn
        }

        holder.itemView.setOnClickListener(view -> {
            if (position == selectedItemPosition) {
                // Bỏ viền xung quanh nếu item được chọn lại
                holder.linear_itemMauSac.setBackgroundResource(0);
                // Huỷ bỏ chọn bằng cách set vị trí được chọn là NO_POSITION
                setSelectedItemPosition(RecyclerView.NO_POSITION);
            } else {
                // Cập nhật vị trí của item được chọn
                setSelectedItemPosition(position);
                // Thiết lập viền xung quanh nếu item được chọn
                holder.linear_itemMauSac.setBackgroundResource(R.drawable.selected_item_background);
            }

            if (onItemClickMauSacListener != null) {
                onItemClickMauSacListener.onItemClickMauSac(mauSac);
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

    public static class MauSacViewHolder extends RecyclerView.ViewHolder {
        private TextView itemMauSac;
        private LinearLayout linear_itemMauSac;

        public MauSacViewHolder(@NonNull View itemView) {
            super(itemView);
            itemMauSac = itemView.findViewById(R.id.itemMauSac);
            linear_itemMauSac = itemView.findViewById(R.id.linear_itemMauSac);

        }
    }

    public interface OnItemClickMauSacListener {
        void onItemClickMauSac(MauSac mauSac);
    }

    public int DoiMaMau(String maMau){
        int color = Color.parseColor(maMau);
        return color;

    }

    public void setSelectedItemPosition(int position) {
        int previousSelectedItemPosition = selectedItemPosition;
        selectedItemPosition = position;

        // Thông báo cho Adapter cập nhật lại item được chọn trước đó và item mới được chọn
        notifyItemChanged(previousSelectedItemPosition);
        notifyItemChanged(selectedItemPosition);
    }


}