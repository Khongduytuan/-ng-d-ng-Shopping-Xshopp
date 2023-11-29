<?php

	require '../connect/dbcon.php';


	$kichCoID = $_POST['kichCoID'];
	$tenKichCo = $_POST['tenKichCo'];
	$kyHieuKichCoBangChu = $_POST['kyHieuKichCoBangChu'];
	$kyHieuKichCoBangSo = $_POST['kyHieuKichCoBangSo'];
	

	// $kichCoID = '17';
	// $tenKichCo = 'tenKichCo';
	// $kyHieuKichCoBangChu = 'tesst';
	// $kyHieuKichCoBangSo = '40';
	
	$querry = "UPDATE tbl_kichco
            SET tenKichCo='$tenKichCo', kyHieuKichCoBangChu='$kyHieuKichCoBangChu', kyHieuKichCoBangSo='$kyHieuKichCoBangSo' WHERE kichCoID='$kichCoID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}


?>