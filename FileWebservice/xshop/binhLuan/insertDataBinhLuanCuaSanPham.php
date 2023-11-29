<?php
    require '../connect/dbcon.php';


    $tenNguoiDung = $_POST['tenNguoiDung'];
    $noiDungBinhLuan = $_POST['noiDungBinhLuan'];
    $emailNguoiBinhLuan = $_POST['emailNguoiBinhLuan'];
    $ngayBinhLuan = $_POST['ngayBinhLuan'];
    $sanPhamID = $_POST['sanPhamID'];

    // $tenNguoiDung = 'tenNguoiDungdemooooooo';
    // $noiDungBinhLuan = 'noiDungBinhLuandemooooooo';
    // $emailNguoiBinhLuan = 'emailNguoiBinhLuandemooooooo';
    // $ngayBinhLuan = '2023-10-10 18:00:00';
    // $sanPhamID = '7';
    


    $querry = "INSERT INTO tbl_binhluan VALUE(null, '$tenNguoiDung', '$noiDungBinhLuan', 
        '$emailNguoiBinhLuan', '$ngayBinhLuan', '$sanPhamID')";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>