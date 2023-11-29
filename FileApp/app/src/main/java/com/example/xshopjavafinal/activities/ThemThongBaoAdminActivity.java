package com.example.xshopjavafinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataSanPham;
import com.example.xshopjavafinal.api.ApiServiceDataThongBao;
import com.example.xshopjavafinal.models.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThemThongBaoAdminActivity extends AppCompatActivity {
    private ImageView image_themthongbao, image_back;
    private EditText editText_tenthongbao, editText_noidungthongbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thong_bao_admin);
        anhXa();


        image_back.setOnClickListener(view -> onBackPressed());

        image_themthongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_tenthongbao.getText().toString().isEmpty()) {
                    Toast.makeText(ThemThongBaoAdminActivity.this, "Nhập tên của thông báo!", Toast.LENGTH_SHORT).show();
                } else if (editText_noidungthongbao.getText().toString().isEmpty()) {
                    Toast.makeText(ThemThongBaoAdminActivity.this, "Nhập nội dung thông báo!", Toast.LENGTH_SHORT).show();
                } else {
                    ThemThongBao(editText_tenthongbao.getText().toString(),
                            editText_noidungthongbao.getText().toString()
                    );
                    editText_tenthongbao.setText("");
                    editText_noidungthongbao.setText("");
                }
            }
        });

    }


    private void ThemThongBao(String tenThongBao, String noiDungThongBao) {
        ApiServiceDataThongBao.
                apiServiceDataThongBao.
                insertDataThongBao(tenThongBao, noiDungThongBao).
                enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("thanhcong")) {
                            Toast.makeText(ThemThongBaoAdminActivity.this, "Thêm thông báo thành công!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ThemThongBaoAdminActivity.this, "Thêm báo không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }

    private void anhXa() {
        image_themthongbao = findViewById(R.id.image_themthongbao);
        image_back = findViewById(R.id.image_back);
        editText_tenthongbao = findViewById(R.id.editText_tenthongbao);
        editText_noidungthongbao = findViewById(R.id.editText_noidungthongbao);
    }
}