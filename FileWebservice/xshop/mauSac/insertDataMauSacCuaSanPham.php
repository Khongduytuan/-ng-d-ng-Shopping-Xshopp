<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $tenMauSac = $_POST['tenMauSac'];
    $maMauSac = $_POST['maMauSac'];
    $sanPhamID = $_POST['sanPhamID'];
    // $tenMauSac = 'tenMauSacDemoooo';
    // $maMauSac = 'maMauSacDemooooo';
    // $sanPhamID = '7';
    


    $querry = "INSERT INTO tbl_mausac VALUE(null, '$tenMauSac', '$maMauSac', '$sanPhamID')";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>