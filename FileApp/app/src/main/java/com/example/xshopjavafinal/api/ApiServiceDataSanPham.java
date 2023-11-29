package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.SanPham;
import com.example.xshopjavafinal.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceDataSanPham {
    public String URL_HEADER_GET_DATA_SANPHAM = "http://192.168.1.56/xshop/sanPham/";
    public String URL_BODY_GET_DATA_SANPHAM_BY_BOSUUTAPID = "sanPham/getDataSanPhamByBoSuuTapID.php";
    public String URL_BODY_GET_DATA_SANPHAM_BY_DANHMUCID = "sanPham/getDataSanPhamByDanhMucID.php";
    public String URL_BODY_GET_DATA_SANPHAM_BY_KEY_WORD = "sanPham/getDataSanPhamByTenSanPham.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataSanPham apiServiceDataSanPham = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataSanPham.class);

    @POST(URL_BODY_GET_DATA_SANPHAM_BY_BOSUUTAPID)
    @FormUrlEncoded
    Call<List<SanPham>> getDataSanPhamByBoSuuTapID(@Field("boSuuTapID") int boSuuTapID);

    @POST(URL_BODY_GET_DATA_SANPHAM_BY_KEY_WORD)
    @FormUrlEncoded
    Call<List<SanPham>> getDataSanPhamByTenSanPham(@Field("chuoiKyTu") String chuoiKyTu);

    @POST(URL_BODY_GET_DATA_SANPHAM_BY_DANHMUCID)
    @FormUrlEncoded
    Call<List<SanPham>> getDataSanPhamByDanhMucID(@Field("danhMucID") int danhMucID);
}
