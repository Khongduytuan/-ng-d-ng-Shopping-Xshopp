<?php

	require '../connect/dbcon.php';


	$danhMucSanPhamID = $_POST['danhMucSanPhamID'];
    // $danhMucSanPhamID = '6';

	$querry = "DELETE FROM tbl_danhmucsanpham WHERE danhMucSanPhamID = '$danhMucSanPhamID'";


	if (mysqli_query($connect, $querry)) {
        $affectedRows = mysqli_affected_rows($connect);
        if ($affectedRows > 0) {
            echo "thanhcong";
        } else {
            echo "loiid";
        }
    } else {
        echo "khongthanhcong";
    }





?>