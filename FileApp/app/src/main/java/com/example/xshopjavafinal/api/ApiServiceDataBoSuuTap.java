package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.BoSuuTap;
import com.example.xshopjavafinal.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServiceDataBoSuuTap {
    // http://localhost/xshop/boSuuTap/
    // ha noi: 192.168.1.56
    // vinh phuc: 192.168.1.25
    public String URL_BODY_GET_DATA_BOSUUTAP = "boSuuTap/getDataBoSuuTap.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataBoSuuTap apiServiceGetDataBoSuuTap = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataBoSuuTap.class);


    @GET(URL_BODY_GET_DATA_BOSUUTAP)
    Call<List<BoSuuTap>> getDataBoSuuTap();

    @POST(URL_BODY_GET_DATA_BOSUUTAP)
    @FormUrlEncoded
    Call<String> getGiaDaiDienSanPhamBoSuuTap(@Field("boSuuTapID") int boSuuTapID);


}
