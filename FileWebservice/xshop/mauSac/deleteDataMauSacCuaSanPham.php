<?php

	require '../connect/dbcon.php';


	$mauSacID = $_POST['mauSacID'];
    // $mauSacID = '1';

	$querry = "DELETE FROM tbl_mausac WHERE mauSacID = '$mauSacID'";


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