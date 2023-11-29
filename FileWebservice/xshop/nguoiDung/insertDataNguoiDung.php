<?php
// file add 1 đối tượng thông tin xe vào cơ sở dữ liệu
	require '../connect/dbcon.php';

	
	$username = $_POST["username"];
	$password = $_POST["password"];
	$viTri = $_POST["viTri"];
	$hoVaTen = $_POST["hoVaTen"];
	$diaChi = $_POST["diaChi"];
	$sdt = $_POST["sdt"];
	$ngayThangNamSinh = $_POST["ngayThangNamSinh"];

	// $username = "manhtran";
	// $password = "123456";
	// $viTri = "Admin";
	// $hoVaTen = "Mạnh Trần";
	// $diaChi = "Thành phố Hồ Chí Minh";
	// $sdt = "0777777777";
	// $ngayThangNamSinh = "2001-12-02";
	


	$querry = "INSERT INTO tbl_nguoidung VALUE(null, '$username', '$password', '$viTri', '$hoVaTen', '$diaChi', '$sdt', '$ngayThangNamSinh')";

	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}else{
		echo "khongthanhcong". mysqli_error($connect);
	}

?>