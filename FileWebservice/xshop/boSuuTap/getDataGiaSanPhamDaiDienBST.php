<?php
require '../connect/dbcon.php';

// $boSuuTapID = '3';
$boSuuTapID = $_POST['boSuuTapID'];
$querry = "SELECT giaKhuyenMai FROM tbl_sanpham WHERE boSuuTapID = $boSuuTapID LIMIT 1";

if (mysqli_query($connect, $querry)) {
    $result = $connect->query($querry);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $giaKhuyenMai = $row['giaKhuyenMai'];

        // In ra giá khuyến mãi
        echo "$giaKhuyenMai";
    } else {
        echo "error";
    }
} else {
    echo "Queryerror";
}

$connect->close();
?>
