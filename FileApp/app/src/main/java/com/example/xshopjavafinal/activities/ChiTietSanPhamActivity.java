package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.adapter.KichCoAdapter;
import com.example.xshopjavafinal.adapter.MauSacAdapter;
import com.example.xshopjavafinal.api.ApiServiceDataKichCo;
import com.example.xshopjavafinal.api.ApiServiceDataMauSac;
import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.models.KichCo;
import com.example.xshopjavafinal.models.MauSac;
import com.example.xshopjavafinal.models.SanPham;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.example.xshopjavafinal.util.Util;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietSanPhamActivity extends AppCompatActivity implements MauSacAdapter.OnItemClickMauSacListener, KichCoAdapter.OnItemClickKichCoListener {
    private TextView textView_TenSanPhamInChiTietSanPham, textView_MoTaSanPhamInChiTietSanPham,
            textView_ChiTietSanPhamInChiTietSanPham, textView_GiaHienTaiInChiTietSanPham,
            textView_GiaKhuyenMaiInChiTietSanPham, textView_ChatLieuSanPhamInChiTietSanPham,
            button_ThemGioHangInSanPhamChiTiet, button_MuaNgayInChiTietSanPham;
    private ImageView textView_anhDaiDienSanPhamInChiTietSanPham, imageView_buttonYeuThichInChiTietSanPham;
    private RecyclerView recycleView_MauSacInChiTietSanPham, recycleView_KichCoInChiTietSanPham;
    private Spinner spinner_SoLuongnChiTietSanPham;
    private MauSacAdapter mauSacAdapter;
    private KichCoAdapter kichCoAdapter;
    private List<MauSac> mauSacList;
    private List<KichCo> kichCoList;

    private int sanPhamID;
    private String tenSanPham, mauSacSanPham, kichCoSanPham, anhDaiDienSanPhamTrongDonHang;
    private Float giaLucMua;
    private int soLuong;
    private int donDatHangID = 8;
    private int hoaDonID = 1;

    private DonDatHangChiTiet donDatHangChiTiet = new DonDatHangChiTiet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        mauSacList = new ArrayList<>();
        anhXa();
        kichCoList = new ArrayList<>();
        mauSacAdapter = new MauSacAdapter(getApplicationContext(), this);
        kichCoAdapter = new KichCoAdapter(getApplicationContext(), this);
        // set layout cua spiner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_values));

        // Set layout cho danh sách thả xuống
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gắn ArrayAdapter cho Spinner
        spinner_SoLuongnChiTietSanPham.setAdapter(adapter);

        spinner_SoLuongnChiTietSanPham.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                soLuong = Integer.parseInt(adapterView.getSelectedItem().toString());
                donDatHangChiTiet.setSoLuong(soLuong);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                soLuong = 1;
                donDatHangChiTiet.setSoLuong(soLuong);
            }
        });


        // set layout của recycleView MauSac
        int spanCountMauSac = calculateNoOfColumns(this, 48);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this, spanCountMauSac);
        recycleView_MauSacInChiTietSanPham.setLayoutManager(layoutManager1);
        recycleView_MauSacInChiTietSanPham.setAdapter(mauSacAdapter);


        // set layout của recycleView KichCo
        int spanCountKichCo = calculateNoOfColumns(this, 48);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this, spanCountKichCo);
        recycleView_KichCoInChiTietSanPham.setLayoutManager(layoutManager2);
        recycleView_KichCoInChiTietSanPham.setAdapter(kichCoAdapter);


        SanPham sanPham = (SanPham) getIntent().getExtras().get("chiTietSanPham");
        if (sanPham != null) {
            sanPhamID = sanPham.getSanPhamID();
            tenSanPham = sanPham.getTenSanPham();
            giaLucMua = sanPham.getGiaKhuyenMai();
            anhDaiDienSanPhamTrongDonHang = sanPham.getAnhDaiDienSanPham();


            textView_TenSanPhamInChiTietSanPham.setText(sanPham.getTenSanPham());
            textView_MoTaSanPhamInChiTietSanPham.setText(sanPham.getMoTaSanPham());
            textView_ChiTietSanPhamInChiTietSanPham.setText(sanPham.getChiTietSanPham());
            textView_GiaHienTaiInChiTietSanPham
                    .setPaintFlags(textView_GiaHienTaiInChiTietSanPham.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            textView_GiaHienTaiInChiTietSanPham.setText(Util.formatNumber(sanPham.getGia().toString()));
            textView_GiaKhuyenMaiInChiTietSanPham.setText(Util.formatNumber(sanPham.getGiaKhuyenMai().toString()));
            textView_ChatLieuSanPhamInChiTietSanPham.setText(sanPham.getChatLieuSanPham());
            Picasso.get().load(sanPham.getAnhDaiDienSanPham()).into(textView_anhDaiDienSanPhamInChiTietSanPham);
            getDataMauSacVaKichCo(sanPham.getSanPhamID());
        }


        button_ThemGioHangInSanPhamChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDonDatHangChiTiet();
                SaveDonHangCHiTiet(donDatHangChiTiet);
                List<DonDatHangChiTiet> danhSachDonDatHang = SharedPreferencesManager
                        .getInstance(getApplicationContext())
                        .getOrderList();
                if (danhSachDonDatHang != null && !danhSachDonDatHang.isEmpty()) {
                    Log.d("danhSachDonDatHang", String.valueOf(danhSachDonDatHang.size()));
                    for (DonDatHangChiTiet x : danhSachDonDatHang
                    ) {
                        if (x != null) {
                            Log.d("danhSachDonDatHang: ", x.getTenSanPham() + " " + x.getSoLuong());
                        } else {
                            Log.d("danhSachDonDatHang", "Phần tử đầu tiên trong danh sách đơn đặt hàng là null.");
                        }

                    }
                } else {
                    Log.d("danhSachDonDatHang", "Danh sách đơn đặt hàng trống hoặc null.");
                }

            }
        });

        button_MuaNgayInChiTietSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDonDatHangChiTiet();
                Intent intent = new Intent(getApplicationContext(), XacNhanMuaSanPhamActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("donDatHangChiTiet", donDatHangChiTiet);
                Log.d("SaveDonHangChiTiet2", "donDatHangChiTietID: " + donDatHangChiTiet.getDonDatHangChiTietID() + " " +
                        "sanPhamID: " + donDatHangChiTiet.getSanPhamID() + " " +
                        "donDatHangID: " + donDatHangChiTiet.getDonDatHangID() + " " +
                        "tenSanPhamID: " + donDatHangChiTiet.getTenSanPham() + " " +
                        "anhDaiDienSanPhamTrongDonHang: " + donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang() + " " +
                        "soLuong: " + donDatHangChiTiet.getSoLuong() + " " +
                        "kichCoSanPham: " + donDatHangChiTiet.getKichCoSanPham() + " " +
                        "mauSacSanPham: " + donDatHangChiTiet.getMauSacSanPham() + " " +
                        "giaLucMua: " + donDatHangChiTiet.getGiaLucMua() + " " +
                        "hoaDonID: " + donDatHangChiTiet.getHoaDonID()
                );
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        imageView_buttonYeuThichInChiTietSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void SaveDonHangCHiTiet(DonDatHangChiTiet donDatHangChiTiet) {
        setDonDatHangChiTiet();
        if (donDatHangChiTiet != null) {
            if (donDatHangChiTiet.getMauSacSanPham() == null) {
                Toast.makeText(this, "Bạn hãy chọn màu sắc sản phẩm!", Toast.LENGTH_SHORT).show();
            } else if (donDatHangChiTiet.getKichCoSanPham() == null) {
                Toast.makeText(this, "Bạn hãy chọn kích cỡ sản phẩm!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sản phẩm đã được thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
                SharedPreferencesManager.getInstance(this).ThemGioHang(donDatHangChiTiet);
                Log.d("SaveDonHangChiTiet", "donDatHangChiTietID: " + donDatHangChiTiet.getDonDatHangChiTietID() + " " +
                        "sanPhamID: " + donDatHangChiTiet.getSanPhamID() + " " +
                        "donDatHangID: " + donDatHangChiTiet.getDonDatHangID() + " " +
                        "tenSanPhamID: " + donDatHangChiTiet.getTenSanPham() + " " +
                        "anhDaiDienSanPhamTrongDonHang: " + donDatHangChiTiet.getAnhDaiDienSanPhamTrongDonHang() + " " +
                        "soLuong: " + donDatHangChiTiet.getSoLuong() + " " +
                        "kichCoSanPham: " + donDatHangChiTiet.getKichCoSanPham() + " " +
                        "mauSacSanPham: " + donDatHangChiTiet.getMauSacSanPham() + " " +
                        "giaLucMua: " + donDatHangChiTiet.getGiaLucMua() + " " +
                        "hoaDonID: " + donDatHangChiTiet.getHoaDonID());
            }

        } else {
            Log.d("SaveDonHangChiTiet", "donDatHangChiTiet là null");
        }
    }

    private void setDonDatHangChiTiet() {
        donDatHangChiTiet.setSanPhamID(sanPhamID);
        donDatHangChiTiet.setTenSanPham(tenSanPham);
        donDatHangChiTiet.setGiaLucMua(giaLucMua);
        donDatHangChiTiet.setAnhDaiDienSanPhamTrongDonHang(anhDaiDienSanPhamTrongDonHang);
    }

    private void getDataMauSacVaKichCo(int sanPhamID) {
        getDataMauSacBySanPhamID(sanPhamID);
        getDataKichCoBySanPhamID(sanPhamID);
    }

    private void anhXa() {
        textView_TenSanPhamInChiTietSanPham = findViewById(R.id.textView_TenSanPhamInChiTietSanPham);
        textView_MoTaSanPhamInChiTietSanPham = findViewById(R.id.textView_MoTaSanPhamInChiTietSanPham);
        textView_ChiTietSanPhamInChiTietSanPham = findViewById(R.id.textView_ChiTietSanPhamInChiTietSanPham);
        textView_GiaHienTaiInChiTietSanPham = findViewById(R.id.textView_GiaHienTaiInChiTietSanPham);
        textView_GiaKhuyenMaiInChiTietSanPham = findViewById(R.id.textView_GiaKhuyenMaiInChiTietSanPham);
        textView_ChatLieuSanPhamInChiTietSanPham = findViewById(R.id.textView_ChatLieuSanPhamInChiTietSanPham);
        button_ThemGioHangInSanPhamChiTiet = findViewById(R.id.button_ThemGioHangInSanPhamChiTiet);
        button_MuaNgayInChiTietSanPham = findViewById(R.id.button_MuaNgayInChiTietSanPham);
        textView_anhDaiDienSanPhamInChiTietSanPham = findViewById(R.id.textView_anhDaiDienSanPhamInChiTietSanPham);
        imageView_buttonYeuThichInChiTietSanPham = findViewById(R.id.imageView_buttonYeuThichInChiTietSanPham);
        recycleView_MauSacInChiTietSanPham = findViewById(R.id.recycleView_MauSacInChiTietSanPham);
        recycleView_KichCoInChiTietSanPham = findViewById(R.id.recycleView_KichCoInChiTietSanPham);
        spinner_SoLuongnChiTietSanPham = findViewById(R.id.spinner_SoLuongnChiTietSanPham);
    }

    private void getDataMauSacBySanPhamID(int sanPhamID) {


        ApiServiceDataMauSac.apiServiceDataMauSac.getDataMauSacBySanPhamID(sanPhamID)
                .enqueue(new Callback<List<MauSac>>() {

                    @Override
                    public void onResponse(Call<List<MauSac>> call, Response<List<MauSac>> response) {
                        mauSacList = response.body();
                        mauSacAdapter.setData(mauSacList);
                    }

                    @Override
                    public void onFailure(Call<List<MauSac>> call, Throwable t) {

                    }
                });
    }


    private void getDataKichCoBySanPhamID(int sanPhamID) {
        ApiServiceDataKichCo.apiServiceDataKichCo.getDataKichCoBySanPhamID(sanPhamID)
                .enqueue(new Callback<List<KichCo>>() {

                    @Override
                    public void onResponse(Call<List<KichCo>> call, Response<List<KichCo>> response) {
                        kichCoList = response.body();
                        for (KichCo x : kichCoList) {
                            Log.d("MaMauSac", x.getKyHieuKichCoBangChu());
                        }
                        Log.d("MaMauSac", String.valueOf(sanPhamID));
                        kichCoAdapter.setData(kichCoList);
                    }

                    @Override
                    public void onFailure(Call<List<KichCo>> call, Throwable t) {

                    }
                });


    }


    private int calculateNoOfColumns(Context context, int giaTriItem) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / giaTriItem);
        return noOfColumns;
    }


    public String formatNumber(String input) {
        try {
            long number = Long.parseLong(input);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            return decimalFormat.format(number);
        } catch (NumberFormatException e) {
            return "null";
        }
    }


    @Override
    public void onItemClickMauSac(MauSac mauSac) {
        donDatHangChiTiet.setMauSacSanPham(mauSac.getTenMauSac());
    }

    @Override
    public void onItemClickKichCo(KichCo kichCo) {
        donDatHangChiTiet.setKichCoSanPham(kichCo.getTenKichCo());
    }


}