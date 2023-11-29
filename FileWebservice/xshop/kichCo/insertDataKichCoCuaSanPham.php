<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $tenKichCo = $_POST['tenKichCo'];
    $kyHieuKichCoBangChu = $_POST['kyHieuKichCoBangChu'];
    $kyHieuKichCoBangSo = $_POST['kyHieuKichCoBangSo'];
    $sanPhamID = $_POST['sanPhamID'];
    // $tenKichCo = 'L';
    // $kyHieuKichCoBangChu = 'L';
    // $kyHieuKichCoBangSo = '39';
    // $sanPhamID = '7';
    
    


    $querry = "INSERT INTO tbl_kichco VALUE(null, '$tenKichCo', '$kyHieuKichCoBangChu','$kyHieuKichCoBangSo' ,'$sanPhamID')";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>