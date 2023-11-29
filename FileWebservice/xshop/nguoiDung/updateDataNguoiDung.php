<?php
// file cập nhật dữ liệu thông tin User đối với quyền người dùng thường 
	require '../connect/dbcon.php';

	$nguoiDungID = $_POST['nguoiDungID'];
	$hoVaTen = $_POST['hoVaTen'];
	$ngayThangNamSinh = $_POST['ngayThangNamSinh'];
	$diaChi = $_POST['diaChi'];
	$sdt = $_POST['sdt'];

	// $nguoiDungID = '4';
	// $hoVaTen = 'Khổng Tuấn ddddd';
	// $ngayThangNamSinh = '2001-12-01';
	// $diaChi = 'Cà mau';
	// $sdt = '0999999999';
		


	$querry = "UPDATE tbl_nguoidung SET hoVaTen = '$hoVaTen', ngayThangNamSinh = '$ngayThangNamSinh', diaChi ='$diaChi', sdt = '$sdt' WHERE nguoiDungID = '$nguoiDungID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}





?>