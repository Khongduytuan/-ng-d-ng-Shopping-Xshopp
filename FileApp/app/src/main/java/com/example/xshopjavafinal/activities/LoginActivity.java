package com.example.xshopjavafinal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.api.ApiServiceDataNguoiDung;
import com.example.xshopjavafinal.models.NguoiDung;
import com.example.xshopjavafinal.sharedPreferences.SharedPreferencesManager;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassWord;
    private MaterialButton buttonDangNhap;
    private TextView textSignUp;


    public SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();

        sharedPreferencesManager = SharedPreferencesManager.getInstance(this);


        Intent intent = getIntent();
        if (intent != null){
            String userName = intent.getStringExtra("username");
            String passWord = intent.getStringExtra("password");
            editTextUserName.setText(userName);
            editTextPassWord.setText(passWord);

        }
        textSignUp.setOnClickListener(view -> {
            Intent intent12 = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent12);
        });


        buttonDangNhap.setOnClickListener(view -> {
            if (editTextUserName.getText().toString().trim().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Nhập tài khoản", Toast.LENGTH_SHORT).show();
            } else if (editTextPassWord.getText().toString().trim().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
            } else {
                String username = editTextUserName.getText().toString().trim();
                String password = editTextPassWord.getText().toString().trim();
                ApiServiceDataNguoiDung.apiServiceDataNguoiDung.dangNhap(username, password)
                        .enqueue(new Callback<List<NguoiDung>>() {
                            @Override
                            public void onResponse(Call<List<NguoiDung>> call, Response<List<NguoiDung>> response) {
                                List<NguoiDung> mList = response.body();
                                if (mList.size() > 0) {
                                    if (mList.get(0).getViTri().equals("Admin")) {
                                        Intent intent1 = new Intent(LoginActivity.this, MainActivityForAdmin.class);
                                        startActivity(intent1);
                                    } else {
                                        // lưu dữ liệu người dùng vào SharedPreferences
                                        NguoiDung nguoiDung = mList.get(0);
                                        sharedPreferencesManager.saveUserData(nguoiDung);
                                        Log.d("SharedPreferences", sharedPreferencesManager.sharedPreferencesGetHoVaTen());

                                        Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent1);
                                        finish();
                                    }

                                }
                            }

                            @Override
                            public void onFailure(Call<List<NguoiDung>> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void anhXa() {
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassWord = findViewById(R.id.editTextPassWord);
        buttonDangNhap = findViewById(R.id.buttonDangNhap);
        textSignUp = findViewById(R.id.textSignUp);
    }

}
