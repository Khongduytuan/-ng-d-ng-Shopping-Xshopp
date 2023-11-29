package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.models.DanhMucSanPham;
import com.example.xshopjavafinal.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiServiceDataDanhMucSanPham {
    // http://192.168.1.25/xshop/danhMucSanPham/getDatadanhMucSanPham.php
    public String URL_HEADER_GET_DATA_DANHMUCSANPHAM = "http://192.168.1.56/xshop/danhMucSanPham/";
    public String URL_BODY_GET_DATA_DANHMUCSANPHAM = "danhMucSanPham/getDatadanhMucSanPham.php";

    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataDanhMucSanPham apiServiceGetDataDanhMucSanPham = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataDanhMucSanPham.class);


    @GET(URL_BODY_GET_DATA_DANHMUCSANPHAM)
    Call<List<DanhMucSanPham>> getDataDanhMucSanPham();
}
