package com.example.xshopjavafinal.api;

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

public interface ApiServiceDataDonDatHang {


    public String URL_HEADER_GET_DATA_DON_DAT_HANG = "http://192.168.1.56/xshop/donDatHang/";
    public String URL_BODY_INSERT_DATA_DON_DAT_HANG_FROM_NGUOI_DUNG_ID = "donDatHang/insertDataDonDatHang.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataDonDatHang apiServiceDataDonDatHang = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataDonDatHang.class);

    @POST(URL_BODY_INSERT_DATA_DON_DAT_HANG_FROM_NGUOI_DUNG_ID)
    @FormUrlEncoded
    Call<List<DonDatHang>> insertDataDonDatHangFromNguoiDungID(@Field("nguoiDungID") int nguoiDungID,
                                                               @Field("ngayDatHang") String ngayDatHang,
                                                               @Field("trangThaiXuLy") String trangThaiXuLy,
                                                               @Field("trangThaiGiaoHang") String trangThaiGiaoHang,
                                                               @Field("ngayGiaoHang") String ngayGiaoHang,
                                                               @Field("ngayDuKienGiaoHang") String ngayDuKienGiaoHang,
                                                               @Field("tongTien") Float tongTien,
                                                               @Field("maGiamGiaID") int maGiamGiaID
                                                               );
}
