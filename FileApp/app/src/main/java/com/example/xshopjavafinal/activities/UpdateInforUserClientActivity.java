package com.example.xshopjavafinal.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataNguoiDung;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateInforUserClientActivity extends AppCompatActivity {
    private EditText inputUpdateHoTenClient, inputUpdateNgayThangNSClient, inputUpdateDiaChiClient,
            inputUpdateSDTClient, inputUpdateEmailClient;
    private Button buttonUpdateUserClient, buttonBackInFragUserClient;

    private Calendar calendar;
    private int uID;
    public SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_infor_user_client);
        anhXa();

        sharedPreferencesManager = SharedPreferencesManager.getInstance(this);
        calendar = Calendar.getInstance();
        inputUpdateNgayThangNSClient.setOnClickListener(view -> showDatePickerDialog());



        if (sharedPreferencesManager != null){
            uID = Integer.parseInt(sharedPreferencesManager.sharedPreferencesGetNguoiDungID());
            inputUpdateHoTenClient.setText(sharedPreferencesManager.sharedPreferencesGetHoVaTen());
            inputUpdateNgayThangNSClient.setText(sharedPreferencesManager.sharedPreferencesGetNgayThangNamSinh());
            inputUpdateDiaChiClient.setText(sharedPreferencesManager.sharedPreferencesGetDiaChi());
            inputUpdateSDTClient.setText(sharedPreferencesManager.sharedPreferencesGetSdt());

        }
        buttonBackInFragUserClient.setOnClickListener(view -> onBackPressed());

        buttonUpdateUserClient.setOnClickListener(view -> {
            if (inputUpdateHoTenClient.getText().toString().trim().isEmpty()){
                Toast.makeText(UpdateInforUserClientActivity.this, "Nhập họ tên", Toast.LENGTH_SHORT).show();
            } else if (inputUpdateNgayThangNSClient.getText().toString().trim().isEmpty()) {
                Toast.makeText(UpdateInforUserClientActivity.this, "Nhập ngày tháng năm sinh", Toast.LENGTH_SHORT).show();
            } else if (inputUpdateDiaChiClient.getText().toString().trim().isEmpty()) {
                Toast.makeText(UpdateInforUserClientActivity.this, "Nhập địa chỉ", Toast.LENGTH_SHORT).show();
            } else if (inputUpdateSDTClient.getText().toString().trim().isEmpty()) {
                Toast.makeText(UpdateInforUserClientActivity.this, "Nhập số điện thoại", Toast.LENGTH_SHORT).show();
            }else {

                String hoTen = inputUpdateHoTenClient.getText().toString().trim();
                String ngayThangNamSinh = inputUpdateNgayThangNSClient.getText().toString().trim();
                String diaChi = inputUpdateDiaChiClient.getText().toString().trim();
                String sdt = inputUpdateSDTClient.getText().toString().trim();



                ApiServiceDataNguoiDung.apiServiceDataNguoiDung.capNhatThongTin(uID, hoTen, ngayThangNamSinh, diaChi, sdt)
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.body().equals("thanhcong")){
                                    Toast.makeText(UpdateInforUserClientActivity.this, "Cập nhật đối tượng người dùng thành công", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                }
                                else{
                                    Toast.makeText(UpdateInforUserClientActivity.this, "Cập nhật không thành công!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(UpdateInforUserClientActivity.this, "lỗi khi cập nhật đối tượng", Toast.LENGTH_SHORT).show();
                                Log.d("errorUpdateUser", t.toString());
                            }
                        });
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                    String selectedDate = sdf.format(calendar.getTime());
                    inputUpdateNgayThangNSClient.setText(selectedDate);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void anhXa() {
        inputUpdateHoTenClient = findViewById(R.id.inputUpdateHoTenClient);
        inputUpdateNgayThangNSClient = findViewById(R.id.inputUpdateNgayThangNSClient);
        inputUpdateDiaChiClient = findViewById(R.id.inputUpdateDiaChiClient);
        inputUpdateSDTClient = findViewById(R.id.inputUpdateSDTClient);
        buttonUpdateUserClient = findViewById(R.id.buttonUpdateUserClient);
        buttonBackInFragUserClient = findViewById(R.id.buttonBackInFragUserClient);
    }
}