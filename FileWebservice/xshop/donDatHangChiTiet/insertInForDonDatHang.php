<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $sanPhamID = $_POST['sanPhamID'];
    $tenSanPham = $_POST['tenSanPham'];
    $mauSacSanPham = $_POST['mauSacSanPham'];
    $kichCoSanPham = $_POST['kichCoSanPham'];
    $giaLucMua = $_POST['giaLucMua'];
    $soLuong = $_POST['soLuong'];
    $donDatHangID = $_POST['donDatHangID'];
    $hoaDonID = $_POST['hoaDonID'];


  

    // $sanPhamID = '16';
    // $tenSanPham = 'Couple TX';
    // $mauSacSanPham = 'Hồng';
    // $kichCoSanPham = 'L';
    // $giaLucMua = '199000.0';
    // $soLuong = '1';
    // $donDatHangID = '8';
    // $hoaDonID = '1';

   
    $insertQuery = "INSERT INTO tbl_dondathangchitiet VALUE(null, '$sanPhamID', '$tenSanPham','$mauSacSanPham' ,'$kichCoSanPham', '$giaLucMua', '$soLuong', '$donDatHangID', '$hoaDonID')";
    
       
    if (mysqli_query($connect, $insertQuery)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>