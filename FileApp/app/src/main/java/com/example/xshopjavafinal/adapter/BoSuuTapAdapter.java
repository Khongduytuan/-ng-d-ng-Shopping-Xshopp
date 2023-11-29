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
import com.example.xshopjavafinal.api.ApiServiceDataBoSuuTap;
import com.example.xshopjavafinal.models.BoSuuTap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoSuuTapAdapter extends RecyclerView.Adapter<BoSuuTapAdapter.BoSuuTapViewHolder> {
    private List<BoSuuTap> mList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public BoSuuTapAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        mList = new ArrayList<>();
    }

    public void setData(List<BoSuuTap> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BoSuuTapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bosuutap_trangchu, parent, false);
        return new BoSuuTapViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull BoSuuTapViewHolder holder, int position) {
        BoSuuTap boSuuTap = mList.get(position);
        holder.textView_TenBoSuuTap.setText(boSuuTap.getTenBoSuuTap());
        holder.textView_MoTa.setText(boSuuTap.getMoTaBoSuuTap());
        Picasso.get().load(boSuuTap.getAnhDaiDienBoSuuTap()).into(holder.anhDaiDienBoSuuTap);
        getGiaDaiDienBoSuuTap(boSuuTap.getBoSuuTapID(), new GiaDaiDienCallback() {
            @Override
            public void onSuccess(String giaDaiDien) {
                holder.textView_GiaDaiDien.setText(giaDaiDien);
            }
            @Override
            public void onErrorOnGiaDaiDien(String errorMessage) {
                holder.textView_GiaDaiDien.setText("");
            }
        });
        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(boSuuTap);
            }
        });
        holder.button_XemThem.setOnClickListener(view ->{
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(boSuuTap);
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

    public static class BoSuuTapViewHolder extends RecyclerView.ViewHolder {
        private ImageView anhDaiDienBoSuuTap;

        private TextView textView_TenBoSuuTap, textView_MoTa, textView_GiaDaiDien, button_XemThem;

        public BoSuuTapViewHolder(@NonNull View itemView) {
            super(itemView);
            anhDaiDienBoSuuTap = itemView.findViewById(R.id.anhDaiDienBoSuuTap);
            textView_TenBoSuuTap = itemView.findViewById(R.id.textView_TenBoSuuTap);
            textView_MoTa = itemView.findViewById(R.id.textView_MoTa);
            textView_GiaDaiDien = itemView.findViewById(R.id.textView_GiaDaiDien);
            button_XemThem = itemView.findViewById(R.id.button_XemThem);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(BoSuuTap boSuuTap);
    }

    public interface GiaDaiDienCallback {
        void onSuccess(String giaDaiDien);
        void onErrorOnGiaDaiDien(String errorMessage);
    }

    private void getGiaDaiDienBoSuuTap(int boSuuTapID, GiaDaiDienCallback callback) {
        ApiServiceDataBoSuuTap.apiServiceGetDataBoSuuTap.getGiaDaiDienSanPhamBoSuuTap(boSuuTapID)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            String giaDaiDien = response.body();
                            if ("error".equals(giaDaiDien)) {
                                callback.onErrorOnGiaDaiDien("Error occurred");
                            } else if ("Queryerror".equals(giaDaiDien)) {
                                callback.onErrorOnGiaDaiDien("Query error occurred");
                            } else {
                                callback.onSuccess(giaDaiDien);
                            }
                        } else {
                            callback.onErrorOnGiaDaiDien("Network error");
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        callback.onErrorOnGiaDaiDien("Request failed");
                    }
                });
    }


}