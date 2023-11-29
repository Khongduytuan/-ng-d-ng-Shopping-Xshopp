<?php

	require '../connect/dbcon.php';


	$boSuuTapID = $_POST['boSuuTapID'];
    // $boSuuTapID = '4';

	$querry = "DELETE FROM tbl_bosuutap WHERE boSuuTapID = '$boSuuTapID'";


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