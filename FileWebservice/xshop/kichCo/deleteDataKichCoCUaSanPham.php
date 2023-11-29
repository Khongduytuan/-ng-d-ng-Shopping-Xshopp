<?php

	require '../connect/dbcon.php';


	$kichCoID = $_POST['kichCoID'];
    // $kichCoID = '18';

	$querry = "DELETE FROM tbl_kichco WHERE kichCoID = '$kichCoID'";


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