<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $tenDanhMuc = $_POST['tenDanhMuc'];
    $trangThai = $_POST['trangThai'];
    $capDoDanhMuc = $_POST['capDoDanhMuc'];
    $nguoiTaoDanhMuc = $_POST['nguoiTaoDanhMuc'];
    $ngayTaoDanhMuc = $_POST['ngayTaoDanhMuc'];

    // $tenDanhMuc = 'tenDanhMucDemooooo';
    // $trangThai = '1';
    // $capDoDanhMuc = '0';
    // $nguoiTaoDanhMuc = 'Admin';
    // $ngayTaoDanhMuc = '2023-10-28 18:08:02';


    $querry = "INSERT INTO tbl_danhmucsanpham VALUE(null, '$tenDanhMuc', '$trangThai', '$capDoDanhMuc', '$nguoiTaoDanhMuc', '$ngayTaoDanhMuc')";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>