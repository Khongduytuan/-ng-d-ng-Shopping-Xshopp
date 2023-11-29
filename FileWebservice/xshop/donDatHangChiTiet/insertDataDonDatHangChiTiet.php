<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $sanPhamID = $_POST['sanPhamID'];
    $nguoiDungID = $_POST['nguoiDungID'];
    $tenSanPham = $_POST['tenSanPham'];
    $anhDaiDienSanPhamTrongDonHang = $_POST['anhDaiDienSanPhamTrongDonHang'];
    $mauSacSanPham = $_POST['mauSacSanPham'];
    $kichCoSanPham = $_POST['kichCoSanPham'];
    $giaLucMua = $_POST['giaLucMua'];
    $tinhTrangXacNhan = $_POST['tinhTrangXacNhan'];
    $thoiGianDat = $_POST['thoiGianDat'];
    $soLuong = $_POST['soLuong'];
    $donDatHangID = $_POST['donDatHangID'];
    $hoaDonID = $_POST['hoaDonID'];



    $selectQuery = "SELECT * FROM tbl_sanpham WHERE sanPhamID = '$sanPhamID'";
    $result = mysqli_query($connect, $selectQuery);

    if ($result) {
        $row = mysqli_fetch_assoc($result);
        $soLuongHienTai = $row['soLuong'];
        // echo $soLuongHienTai;

        // Kiểm tra xem có đủ số lượng sản phẩm để cập nhật không
        if ($soLuongHienTai >= $soLuong) {
            // Cập nhật số lượng sản phẩm trong bảng dondathangchitiet
            $insertQuery = "INSERT INTO tbl_dondathangchitiet VALUE(null, '$sanPhamID','$nguoiDungID', '$tenSanPham', '$anhDaiDienSanPhamTrongDonHang', '$mauSacSanPham' ,'$kichCoSanPham', '$giaLucMua', '$tinhTrangXacNhan', '$thoiGianDat' , '$soLuong', '$donDatHangID', '$hoaDonID')";
            if (mysqli_query($connect, $insertQuery)) {
                // Cập nhật số lượng sản phẩm trong bảng sanpham
                $newSoLuong = $soLuongHienTai - $soLuong;
                $updateQuery = "UPDATE tbl_sanpham SET soLuong = '$newSoLuong' WHERE sanPhamID = '$sanPhamID'";
                mysqli_query($connect, $updateQuery);

                // Commit transaction nếu mọi thứ thành công
                mysqli_commit($connect);
                echo "thanhcong";
            }

            // // Cập nhật số lượng sản phẩm trong bảng sanpham
            // $newSoLuong = $soLuongHienTai - $soLuong;
            // $updateQuery = "UPDATE tbl_sanpham SET soLuong = '$newSoLuong' WHERE sanPhamID = '$sanPhamID'";
            // mysqli_query($connect, $updateQuery);

            // // Commit transaction nếu mọi thứ thành công
            // mysqli_commit($connect);
            // echo "thanhcong";
        } else {
            echo "Số lượng sản phẩm không đủ";
        }
    } else {
        echo "Không thể lấy thông tin sản phẩm";
    }


?>