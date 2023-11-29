package com.example.xshopjavafinal.adapter;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataDonDatHangChiTiet;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.models.KichCo;
import com.example.xshopjavafinal.models.SanPham;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonDatHangTrangThaiAdminAdapter extends RecyclerView.Adapter<DonDatHangTrangThaiAdminAdapter.DonDatHangTrangThaiAdminViewHolder> {
    private List<DonDatHangChiTiet> mList;
    private Context context;
    private OnSelectTrangThai onSelectTrangThai;

    private DonDatHangTrangThaiAdminViewHolder donDatHangTrangThaiAdminViewHolder;

    public void setDonDatHangTrangThaiAdminViewHolder(DonDatHangTrangThaiAdminViewHolder viewHolder) {
        this.donDatHangTrangThaiAdminViewHolder = viewHolder;
    }

    public DonDatHangTrangThaiAdminAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setData(List<DonDatHangChiTiet> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DonDatHangTrangThaiAdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trangthai_dondathang_admin, parent, false);
        return new DonDatHangTrangThaiAdminViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull DonDatHangTrangThaiAdminViewHolder holder, int position) {

        DonDatHangChiTiet donDatHangChiTiet = mList.get(position);
        Picasso.get().load(donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang()).into(holder.image_itemSanPhamInAdmin);
        holder.textView_GiaKhuyenMaiInAdmin.setText(String.valueOf(donDatHangChiTiet.getGiaLucMua()));
        holder.textView_KichCoInAdmin.setText(donDatHangChiTiet.getKichCoSanPham());
        holder.textView_MauSacInAdmin.setText(donDatHangChiTiet.getMauSacSanPham());
        holder.textView_TenSanPhamInAdmin.setText(donDatHangChiTiet.getTenSanPham());
        holder.textView_SoLuongInAdmin.setText(String.valueOf(donDatHangChiTiet.getSoLuong()));
        holder.textView_IDSanPhamInAdmin.setText(String.valueOf(donDatHangChiTiet.getDonDatHangChiTietID()));
        holder.textView_IDNguoiMuaInAdmin.setText(String.valueOf(donDatHangChiTiet.getNguoiDungID()));
        holder.textView_TinhTrangHienTaiInAdmin.setText(donDatHangChiTiet.getTinhTrangXacNhan());


//        holder.itemView.setOnClickListener(view -> {
//            showStatusDialog(donDatHangChiTiet);
//        });

        holder.itemView.setOnClickListener(view -> {
            showStatusDialog(donDatHangChiTiet, holder); // Truyền ViewHolder vào showStatusDialog
        });


    }


    private void showStatusDialog(DonDatHangChiTiet donDatHangChiTiet, DonDatHangTrangThaiAdminViewHolder holder) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);
        builder.setView(dialogView);

        Spinner spinnerStatus = dialogView.findViewById(R.id.spinnerStatus);
        Button btnUpdateStatus = dialogView.findViewById(R.id.btnUpdateStatus);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                context,
                R.array.order_statuses,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);

        AlertDialog dialog = builder.create();
        dialog.show();

        btnUpdateStatus.setOnClickListener(view -> {
            String selectedStatus = spinnerStatus.getSelectedItem().toString();
            CapNhatTrangThaiChoDonHang(donDatHangChiTiet, selectedStatus, holder);
            dialog.dismiss();
        });
    }

    private void CapNhatTrangThaiChoDonHang(DonDatHangChiTiet donDatHangChiTiet, String trangThaiCanCapNhat, DonDatHangTrangThaiAdminViewHolder holder) {
        ApiServiceDataDonDatHangChiTiet
                .apiServiceDataDonDatHangChiTiet
                .updateTrangThaiDonDatHangChiTietAdmin(donDatHangChiTiet.getDonDatHangChiTietID(), trangThaiCanCapNhat)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("thanhcong")) {
                            Toast.makeText(context, "Cập nhật trạng thái đơn hàng thành công!", Toast.LENGTH_SHORT).show();

                            // Cập nhật giá trị cho textView_TinhTrangHienTaiInAdmin trong ViewHolder
                            donDatHangChiTiet.setTinhTrangXacNhan(trangThaiCanCapNhat);
                            holder.updateTinhTrang(trangThaiCanCapNhat);
                        } else {
                            Toast.makeText(context, "Cập nhật trạng thái đơn hàng không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }

//    private void showStatusDialog(DonDatHangChiTiet donDatHangChiTiet) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);
//        builder.setView(dialogView);
//
//        Spinner spinnerStatus = dialogView.findViewById(R.id.spinnerStatus);
//        Button btnUpdateStatus = dialogView.findViewById(R.id.btnUpdateStatus);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                context,
//                R.array.order_statuses,
//                android.R.layout.simple_spinner_item
//        );
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerStatus.setAdapter(adapter);
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//        btnUpdateStatus.setOnClickListener(view -> {
//            String selectedStatus = spinnerStatus.getSelectedItem().toString();
//            CapNhatTrangThaiChoDonHang(donDatHangChiTiet.getDonDatHangChiTietID(), selectedStatus);
//            dialog.dismiss();
//        });
//    }
//
//    private void CapNhatTrangThaiChoDonHang(int donDatHangID, String trangThaiCanCapNhat) {
//        ApiServiceDataDonDatHangChiTiet
//                .apiServiceDataDonDatHangChiTiet
//                .updateTrangThaiDonDatHangChiTietAdmin(donDatHangID, trangThaiCanCapNhat
//                )
//                .enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        if (response.body().equals("thanhcong")) {
//                            Toast.makeText(context, "Cập nhật trạng thái đơn hàng thành công!", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(context, "Cập nhật trạng thái đơn hàng không thành công!", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//
//                    }
//                });
//    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public static class DonDatHangTrangThaiAdminViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_itemSanPhamInAdmin;
        private TextView textView_TenSanPhamInAdmin,
                textView_GiaKhuyenMaiInAdmin,
                textView_KichCoInAdmin,
                textView_MauSacInAdmin,
                textView_SoLuongInAdmin,
                textView_IDSanPhamInAdmin,
                textView_IDNguoiMuaInAdmin,
                textView_TinhTrangHienTaiInAdmin;



        public DonDatHangTrangThaiAdminViewHolder(@NonNull View itemView) {
            super(itemView);
            image_itemSanPhamInAdmin = itemView.findViewById(R.id.image_itemSanPhamInAdmin);
            textView_TenSanPhamInAdmin = itemView.findViewById(R.id.textView_TenSanPhamInAdmin);
            textView_GiaKhuyenMaiInAdmin = itemView.findViewById(R.id.textView_GiaKhuyenMaiInAdmin);
            textView_KichCoInAdmin = itemView.findViewById(R.id.textView_KichCoInAdmin);
            textView_MauSacInAdmin = itemView.findViewById(R.id.textView_MauSacInAdmin);
            textView_SoLuongInAdmin = itemView.findViewById(R.id.textView_SoLuongInAdmin);
            textView_IDSanPhamInAdmin = itemView.findViewById(R.id.textView_IDSanPhamInAdmin);
            textView_IDNguoiMuaInAdmin = itemView.findViewById(R.id.textView_IDNguoiMuaInAdmin);
            textView_TinhTrangHienTaiInAdmin = itemView.findViewById(R.id.textView_TinhTrangHienTaiInAdmin);


        }

        public void updateTinhTrang(String tinhTrangMoi) {
            textView_TinhTrangHienTaiInAdmin.setText(tinhTrangMoi);
        }
    }


    public interface OnSelectTrangThai {
        void onItemClickTrangThai(DonDatHangChiTiet donDatHangChiTiet);
    }
}


