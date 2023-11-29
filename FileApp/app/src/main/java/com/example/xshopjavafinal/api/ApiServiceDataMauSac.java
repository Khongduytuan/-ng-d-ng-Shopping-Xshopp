package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.MauSac;
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

public interface ApiServiceDataMauSac {
    public String URL_HEADER_GET_DATA_MAU_SAC = "http://192.168.1.56/xshop/mauSac/";
    public String URL_BODY_GET_DATA_MAU_SAC_BY_SAN_PHAM_ID = "mauSac/getDataMauSacCuaSanPham.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataMauSac apiServiceDataMauSac = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataMauSac.class);

    @POST(URL_BODY_GET_DATA_MAU_SAC_BY_SAN_PHAM_ID)
    @FormUrlEncoded
    Call<List<MauSac>> getDataMauSacBySanPhamID(@Field("sanPhamID") int sanPhamID);


}
