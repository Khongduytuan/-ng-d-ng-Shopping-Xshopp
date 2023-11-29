package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.DonDatHangChiTiet;
import com.example.xshopjavafinal.models.KichCo;
import com.example.xshopjavafinal.models.ThongBao;
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

public interface ApiServiceDataThongBao {

    public String URL_BODY_GET_DATA_THONG_BAO = "thongBao/getDataThongBao.php";
    public String URL_BODY_INSERT_DATA_THONG_BAO = "thongBao/insertDataThongBao.php";
    public String URL_BODY_DELETE_DATA_THONG_BAO = "thongBao/deleteDataThongBao.php";



    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataThongBao apiServiceDataThongBao = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataThongBao.class);

    @GET(URL_BODY_GET_DATA_THONG_BAO)
    Call<List<ThongBao>> getDataThongBao();

    @POST(URL_BODY_INSERT_DATA_THONG_BAO)
    @FormUrlEncoded
    Call<String> insertDataThongBao(@Field("tenThongBao") String tenThongBao,
                                    @Field("noiDungThongBao") String noiDungThongBao);

    @POST(URL_BODY_DELETE_DATA_THONG_BAO)
    @FormUrlEncoded
    Call<String> deleteDataThongBao(@Field("thongBaoID") int thongBaoID);

}
