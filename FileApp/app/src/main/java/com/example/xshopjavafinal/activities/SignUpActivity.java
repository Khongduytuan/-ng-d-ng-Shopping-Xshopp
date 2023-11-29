package com.example.xshopjavafinal.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataNguoiDung;
import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class SignUpActivity extends AppCompatActivity {
    private EditText inputDKHoTen, inputDKNgayThangNS, inputDKDiaChi,
            inputDKSDT, inputDKMatKhau, inputDKXacNhanMatKhau, inputDKUsername;

    private ImageView imageBack;
    private TextView textSignIn;
    private MaterialButton buttonSignUp;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        anhXa();
        imageBack.setOnClickListener(view -> onBackPressed());
        textSignIn.setOnClickListener(view -> onBackPressed());

        calendar = Calendar.getInstance();
        inputDKNgayThangNS.setOnClickListener(view -> showDatePickerDialog());


        buttonSignUp.setOnClickListener(view -> {
            if (inputDKHoTen.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập họ tên", Toast.LENGTH_SHORT).show();
            } else if (inputDKNgayThangNS.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập ngày tháng năm sinh", Toast.LENGTH_SHORT).show();
            } else if (inputDKDiaChi.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập địa chỉ", Toast.LENGTH_SHORT).show();
            } else if (inputDKSDT.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập số điện thoại", Toast.LENGTH_SHORT).show();
            } else if (inputDKMatKhau.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
            } else if (inputDKXacNhanMatKhau.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Xác nhận lại mật khẩu", Toast.LENGTH_SHORT).show();
            } else if (!inputDKMatKhau.getText().toString().trim()
                    .equals(inputDKXacNhanMatKhau.getText().toString().trim())) {
                Toast.makeText(SignUpActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            } else if (inputDKUsername.getText().toString().trim().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Nhập tên tài khoản", Toast.LENGTH_SHORT).show();
            } else {
                String hoVaTen = inputDKHoTen.getText().toString().trim();
                String ngayThangNamSinh = inputDKNgayThangNS.getText().toString().trim();
                String diaChi = inputDKDiaChi.getText().toString().trim();
                String sdt = inputDKSDT.getText().toString().trim();
                String username = inputDKUsername.getText().toString().trim();
                String password = inputDKMatKhau.getText().toString().trim();
                String viTri = "User";

//                @Field("username") String username,
//                @Field("password") String password,
//                @Field("viTri") String viTri,
//                @Field("hoVaTen") String hoVaTen,
//                @Field("diaChi") String diaChi,
//                @Field("sdt") String sdt,
//                @Field("ngayThangNamSinh") String ngayThangNamSinh);
                ApiServiceDataNguoiDung.apiServiceDataNguoiDung.dangKy(username,
                                password,
                                viTri,
                                hoVaTen,
                                diaChi,
                                sdt,
                                ngayThangNamSinh)
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.body().equals("thanhcong")) {
                                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                    intent.putExtra("username", username);
                                    intent.putExtra("password", password);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Đăng ký không thành công!", Toast.LENGTH_SHORT).show();
                                    inputDKMatKhau.setText("");
                                    inputDKXacNhanMatKhau.setText("");
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(SignUpActivity.this, "Lỗi đăng ký", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    private void anhXa() {
        inputDKHoTen = findViewById(R.id.inputDKHoTen);
        inputDKNgayThangNS = findViewById(R.id.inputDKNgayThangNS);
        inputDKDiaChi = findViewById(R.id.inputDKDiaChi);
        inputDKSDT = findViewById(R.id.inputDKSDT);
        inputDKMatKhau = findViewById(R.id.inputDKMatKhau);
        inputDKXacNhanMatKhau = findViewById(R.id.inputDKXacNhanMatKhau);
        imageBack = findViewById(R.id.imageBack);
        textSignIn = findViewById(R.id.textSignIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        inputDKUsername = findViewById(R.id.inputDKUsername);
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
                    inputDKNgayThangNS.setText(selectedDate);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
}
