package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.NguoiDung;
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

public interface ApiServiceDataNguoiDung {


    public String URL_BODY_LOGIN = "nguoiDung/dangNhap.php";
    public String URL_BODY_DANG_KY = "nguoiDung/insertDataNguoiDung.php";
    public String URL_BODY_CAP_NHAT_THONG_TON = "nguoiDung/updateDataNguoiDung.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataNguoiDung apiServiceDataNguoiDung = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataNguoiDung.class);

    @POST(URL_BODY_LOGIN)
    @FormUrlEncoded
    Call<List<NguoiDung>> dangNhap(@Field("username") String username,
                                    @Field("password") String password);

    @POST(URL_BODY_DANG_KY)
    @FormUrlEncoded
    Call<String> dangKy(@Field("username") String username,
                           @Field("password") String password,
                           @Field("viTri") String viTri,
                           @Field("hoVaTen") String hoVaTen,
                           @Field("diaChi") String diaChi,
                           @Field("sdt") String sdt,
                           @Field("ngayThangNamSinh") String ngayThangNamSinh);

    @POST(URL_BODY_CAP_NHAT_THONG_TON)
    @FormUrlEncoded
    Call<String> capNhatThongTin(@Field("nguoiDungID") int nguoiDungID,
                        @Field("hoVaTen") String hoVaTen,
                        @Field("ngayThangNamSinh") String ngayThangNamSinh,
                        @Field("diaChi") String diaChi,
                        @Field("sdt") String sdt);
}
