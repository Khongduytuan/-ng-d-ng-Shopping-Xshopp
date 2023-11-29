<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';

    $sanPhamID = $_POST['sanPhamID'];
    $tenSanPham = $_POST['tenSanPham'];
    $mauSacSanPham = $_POST['mauSacSanPham'];
    $kichCoSanPham = $_POST['kichCoSanPham'];
    $giaLucMua = $_POST['giaLucMua'];
    $soLuong = $_POST['soLuong'];
    $donDatHangID = $_POST['donDatHangID'];
    $hoaDonID = $_POST['hoaDonID'];

mysqli_begin_transaction($connect);

try {
    $selectQuery = "SELECT * FROM tbl_sanpham WHERE sanPhamID = '$sanPhamID'";
    $result = mysqli_query($connect, $selectQuery);

    if ($result) {
        $row = mysqli_fetch_assoc($result);
        $soLuongHienTai = $row['soLuong'];
        if ($soLuongHienTai >= $soLuong) {
            $insertQuery = "INSERT INTO tbl_dondathangchitiet VALUE(null, '$sanPhamID', '$tenSanPham','$mauSacSanPham' ,'$kichCoSanPham', '$giaLucMua', '$soLuong', '$donDatHangID', '$hoaDonID')";
            mysqli_query($connect, $insertQuery);
            $newSoLuong = $soLuongHienTai - $soLuong;
            $updateQuery = "UPDATE tbl_sanpham SET soLuong = '$newSoLuong' WHERE sanPhamID = '$sanPhamID'";
            mysqli_query($connect, $updateQuery);
            mysqli_commit($connect);
            echo "thanhcong";
        } else {
            echo "Số lượng sản phẩm không đủ";
        }
    } else {
        echo "Không thể lấy thông tin sản phẩm";
    }
} catch (Exception $e) {
    mysqli_rollback($connect);
    echo "Không thể cập nhật dữ liệu: " . $e->getMessage();
}
mysqli_close($connect);
?>
