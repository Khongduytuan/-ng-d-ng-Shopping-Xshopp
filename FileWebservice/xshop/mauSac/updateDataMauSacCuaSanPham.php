<?php

	require '../connect/dbcon.php';


	$mauSacID = $_POST['mauSacID'];
	$tenMauSac = $_POST['tenMauSac'];
	$maMauSac = $_POST['maMauSac'];
	// $mauSacID = '1';
	// $tenMauSac = 'tenMauSac';
	// $maMauSac = 'maMauSac';
	
	$querry = "UPDATE tbl_mausac
            SET tenMauSac='$tenMauSac', maMauSac='$maMauSac'
            WHERE mauSacID='$mauSacID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}





?>