<?php

	require '../connect/dbcon.php';


	$binhLuanID = $_POST['binhLuanID'];
    // $binhLuanID = '4';
    

	$querry = "DELETE FROM tbl_binhluan WHERE binhLuanID = '$binhLuanID'";


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