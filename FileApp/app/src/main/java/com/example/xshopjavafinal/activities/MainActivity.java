package com.example.xshopjavafinal.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xshopjavafinal.R;
import com.example.xshopjavafinal.fragments.DanhMucFragment;
import com.example.xshopjavafinal.fragments.HoSoCaNhanFragment;
import com.example.xshopjavafinal.fragments.ThongBaoFragment;
import com.example.xshopjavafinal.fragments.TrangChuFragment;
import com.example.xshopjavafinal.fragments.YeuThichFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    private ImageView icon_card, searchIcon;
    private EditText searchEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        icon_card = findViewById(R.id.icon_card);
        searchIcon = findViewById(R.id.searchIcon);
        searchEditText = findViewById(R.id.searchEditText);


        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String keyWord = searchEditText.getText().toString();

                if (!keyWord.equals("")){
                    Intent intent = new Intent(MainActivity.this, TimKiemActivity.class);
                    intent.putExtra("keyWord", keyWord);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Nhập từ khóa!", Toast.LENGTH_SHORT).show();
                }




            }
        });


        icon_card.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GioHangActivity.class);
            startActivity(intent);
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new TrangChuFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_logout:
//                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                        startActivity(intent);
                            Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }


        replaceFragment(new TrangChuFragment());

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.trangChu:
                    replaceFragment(new TrangChuFragment());
                    break;
                case R.id.danhMuc:
                    replaceFragment(new DanhMucFragment());
                    break;
//                case R.id.yeuThich:
//                    replaceFragment(new YeuThichFragment());
//                    break;
                case R.id.thongBao:
                    replaceFragment(new ThongBaoFragment());
                    break;
                case R.id.hoSo:
                    replaceFragment(new HoSoCaNhanFragment());
                    break;
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        LinearLayout layoutAccount = dialog.findViewById(R.id.layoutAccount);
        LinearLayout layoutConfirm = dialog.findViewById(R.id.layoutConfirm);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);


        cancelButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
