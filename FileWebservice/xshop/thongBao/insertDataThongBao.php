<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $tenThongBao = $_POST['tenThongBao'];
    $noiDungThongBao = $_POST['noiDungThongBao'];
  
    // $tenThongBao = 'black friday 202';
    // $noiDungThongBao = 'Giảm gía sâu hầu hết các mặt hàng vào dịp black friday 2023';
  
    $insertQuery = "INSERT INTO tbl_thongbao VALUE(null, '$tenThongBao','$noiDungThongBao')";
        if (mysqli_query($connect, $insertQuery)) {
            echo "thanhcong";
        }
        else{
            echo "khongthanhcong";
        }

?>