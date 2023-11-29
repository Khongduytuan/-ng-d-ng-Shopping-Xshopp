<?php

	require '../connect/dbcon.php';


	$danhMucSanPhamID = $_POST['danhMucSanPhamID'];
	$tenDanhMuc = $_POST['tenDanhMuc'];
	$trangThai = $_POST['trangThai'];
	$capDoDanhMuc = $_POST['capDoDanhMuc'];
	$nguoiTaoDanhMuc = $_POST['nguoiTaoDanhMuc'];
	$ngayTaoDanhMuc = $_POST['ngayTaoDanhMuc'];

	// $danhMucSanPhamID = '6';
	// $tenDanhMuc = 'tenDanhMuc';
	// $trangThai = 'trangThai';
	// $capDoDanhMuc = 'capDoDanhMuc';
	// $nguoiTaoDanhMuc = 'nguoiTaoDanhMuc';
	// $ngayTaoDanhMuc = 'ngayTaoDanhMuc';
	


	$querry = "UPDATE tbl_danhmucsanpham
            SET tenDanhMuc='$tenDanhMuc', trangThai='$trangThai', capDoDanhMuc='$capDoDanhMuc',
            nguoiTaoDanhMuc='$nguoiTaoDanhMuc',ngayTaoDanhMuc='$ngayTaoDanhMuc'
            WHERE danhMucSanPhamID='$danhMucSanPhamID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}





?>