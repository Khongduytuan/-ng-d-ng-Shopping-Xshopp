<?php

	require '../connect/dbcon.php';


	$boSuuTapID = $_POST['boSuuTapID'];
	$tenBoSuuTap = $_POST['tenBoSuuTap'];
	$moTaBoSuuTap = $_POST['moTaBoSuuTap'];
	$chiTietBoSuuTap = $_POST['chiTietBoSuuTap'];
	$anhDaiDienBoSuuTap = $_POST['anhDaiDienBoSuuTap'];
	$hot = $_POST['hot'];

	// $boSuuTapID = '1';
	// $tenBoSuuTap = 'Xuân hạ';
	// $moTaBoSuuTap = 'moTaBoSuuTap';
	// $chiTietBoSuuTap = 'chiTietBoSuuTap';
	// $anhDaiDienBoSuuTap = 'anhDaiDienBoSuuTap';
	// $hot = 'hot';


	$querry = "UPDATE tbl_bosuutap
            SET tenBoSuuTap='$tenBoSuuTap', moTaBoSuuTap='$moTaBoSuuTap', chiTietBoSuuTap='$chiTietBoSuuTap',
            anhDaiDienBoSuuTap='$anhDaiDienBoSuuTap',hot='$hot'
            WHERE boSuuTapID='$boSuuTapID'";


	if (mysqli_query($connect, $querry)) {
		echo "thanhcong";
	}
	else{
		echo "khongthanhcong";
	}





?>