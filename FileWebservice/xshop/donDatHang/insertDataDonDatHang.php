<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $nguoiDungID = $_POST['nguoiDungID'];
    $ngayDatHang = $_POST['ngayDatHang'];
    $trangThaiXuLy = $_POST['trangThaiXuLy'];
    $trangThaiGiaoHang = $_POST['trangThaiGiaoHang'];
    $ngayGiaoHang = $_POST['ngayGiaoHang'];
    $ngayDuKienGiaoHang = $_POST['ngayDuKienGiaoHang'];
    $tongTien = $_POST['tongTien'];
    $maGiamGiaID = $_POST['maGiamGiaID'];

    // $nguoiDungID = '2';
    // $ngayDatHang = '21/11/2023';
    // $trangThaiXuLy = 'Chưa Xác Nhận';
    // $trangThaiGiaoHang = 'Chưa Giao Hàng';
    // $ngayGiaoHang = '00/00/0000';
    // $ngayDuKienGiaoHang = '24/11/2023';
    // $tongTien = '500000';
    // $maGiamGiaID = '1';
    
    
    
    


    $querry = "INSERT INTO tbl_dondathang VALUE(null, '$nguoiDungID', '$ngayDatHang','$trangThaiXuLy' ,'$trangThaiGiaoHang', '$ngayGiaoHang', '$ngayDuKienGiaoHang', '$tongTien', '$maGiamGiaID' )";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong: ";
    }


?>