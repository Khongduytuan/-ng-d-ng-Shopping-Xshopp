<?php

	require '../connect/dbcon.php';


	$donDatHangChiTietID = $_POST['donDatHangChiTietID'];
	$tinhTrangXacNhan = $_POST['tinhTrangXacNhan'];

	// $donDatHangChiTietID = '55';
	// $tinhTrangXacNhan = 'Giao thành công';
	
	

	
	$querry = "UPDATE tbl_dondathangchitiet
            SET tinhTrangXacNhan='$tinhTrangXacNhan' WHERE donDatHangChiTietID='$donDatHangChiTietID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}


?>