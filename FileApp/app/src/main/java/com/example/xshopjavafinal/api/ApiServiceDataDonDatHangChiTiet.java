package com.example.xshopjavafinal.api;

import com.example.xshopjavafinal.models.DonDatHangChiTiet;
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

public interface ApiServiceDataDonDatHangChiTiet {

    public String URL_HEADER_GET_DATA_DON_DAT_HANG_CHI_TIET = "http://192.168.1.56/xshop/donDatHangChiTiet/";
    public String URL_BODY_INSERT_DATA_DON_DAT_HANG_CHI_TIET_FROM_NGUOI_DUNG_ID = "insertDataDonDatHangChiTietAndUpdateDataInBangSanPham.php";
    public String URL_BODY_INSERT_DATA_DON_DAT_HANG_CHI_TIET_FROM_NGUOI_DUNG_ID2 = "donDatHangChiTiet/insertDataDonDatHangChiTiet.php";
    public String URL_BODY_INSERT_DATA_DON_DAT_HANG_CHI_TIET_BY_KEY_WORD = "donDatHangChiTiet/getDataDonHangChiTietDaMua.php";
    public String URL_BODY_UPDATE_TRANG_THAI_DON_DAT_HANG_CHI_TIET = "donDatHangChiTiet/updateTrangThaiDonHangChiTiet.php";


    Gson gson = new GsonBuilder().setLenient().create();
    ApiServiceDataDonDatHangChiTiet apiServiceDataDonDatHangChiTiet = new Retrofit.Builder()
            .baseUrl(Util.BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceDataDonDatHangChiTiet.class);

    @POST(URL_BODY_INSERT_DATA_DON_DAT_HANG_CHI_TIET_FROM_NGUOI_DUNG_ID2)
    @FormUrlEncoded
    Call<String> insertDataDonDatHangChiTietFromNguoiDungID(@Field("sanPhamID") int sanPhamID,
                                                            @Field("nguoiDungID") int nguoiDungID,
                                                            @Field("tenSanPham") String tenSanPham,
                                                            @Field("anhDaiDienSanPhamTrongDonHang") String anhDaiDienSanPhamTrongDonHang,
                                                            @Field("mauSacSanPham") String mauSacSanPham,
                                                            @Field("kichCoSanPham") String kichCoSanPham,
                                                            @Field("giaLucMua") Float giaLucMua,
                                                            @Field("tinhTrangXacNhan") String tinhTrangXacNhan,
                                                            @Field("thoiGianDat") String thoiGianDat,
                                                            @Field("soLuong") int soLuong,
                                                            @Field("donDatHangID") int donDatHangID,
                                                            @Field("hoaDonID") int hoaDonID);


    @POST(URL_BODY_INSERT_DATA_DON_DAT_HANG_CHI_TIET_BY_KEY_WORD)
    @FormUrlEncoded
    Call<List<DonDatHangChiTiet>> getDataDonDatHangChiTiet(@Field("keyWord") String keyWord);

    @POST(URL_BODY_UPDATE_TRANG_THAI_DON_DAT_HANG_CHI_TIET)
    @FormUrlEncoded
    Call<String> updateTrangThaiDonDatHangChiTietAdmin(@Field("donDatHangChiTietID") int donDatHangChiTietID,
                                                            @Field("tinhTrangXacNhan") String tinhTrangXacNhan);
}
