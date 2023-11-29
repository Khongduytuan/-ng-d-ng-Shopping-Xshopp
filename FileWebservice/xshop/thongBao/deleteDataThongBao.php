<?php

	require '../connect/dbcon.php';


	$thongBaoID = $_POST['thongBaoID'];
    

	$querry = "DELETE FROM tbl_thongbao WHERE thongBaoID = '$thongBaoID'";


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