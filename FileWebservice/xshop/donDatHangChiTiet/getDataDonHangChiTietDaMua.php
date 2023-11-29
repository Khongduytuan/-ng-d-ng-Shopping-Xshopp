<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    class DonDatHangChiTiet {
        public $donDatHangChiTietID;
        public $sanPhamID;
        public $nguoiDungID;
        public $tenSanPham;
        public $anhDaiDienSanPhamTrongDonHang;
        public $mauSacSanPham;
        public $kichCoSanPham;
        public $giaLucMua;
        public $tinhTrangXacNhan;
        public $thoiGianDat;
        public $soLuong;
        public $donDatHangID;
        public $hoaDonID;
    

        public function __construct($donDatHangChiTietID, $sanPhamID, $nguoiDungID, $tenSanPham, $anhDaiDienSanPhamTrongDonHang, $mauSacSanPham, $kichCoSanPham,$giaLucMua, $tinhTrangXacNhan, $thoiGianDat, $soLuong, $donDatHangID, $hoaDonID) {
            $this->donDatHangChiTietID = $donDatHangChiTietID;
            $this->sanPhamID = $sanPhamID;
            $this->nguoiDungID = $nguoiDungID;
            $this->tenSanPham = $tenSanPham;
            $this->anhDaiDienSanPhamTrongDonHang = $anhDaiDienSanPhamTrongDonHang;
            $this->mauSacSanPham = $mauSacSanPham;
            $this->kichCoSanPham = $kichCoSanPham;
            $this->giaLucMua = $giaLucMua;
            $this->tinhTrangXacNhan = $tinhTrangXacNhan;
            $this->thoiGianDat = $thoiGianDat;
            $this->soLuong = $soLuong;
            $this->donDatHangID = $donDatHangID;
            $this->hoaDonID = $hoaDonID;
        }
    }

    $keyWord = $_POST['keyWord'];
    // $keyWord = 'Chưa xác nhận';
    $querry = "SELECT * FROM tbl_dondathangchitiet WHERE tinhTrangXacNhan LIKE '$keyWord'";
    
    $data = mysqli_query($connect, $querry);
    $array = array();



    while ($row = mysqli_fetch_assoc($data)) {
        array_push($array, new DonDatHangChiTiet($row['donDatHangChiTietID'], $row['sanPhamID'], $row['nguoiDungID'], $row['tenSanPham'],$row['anhDaiDienSanPhamTrongDonHang'], $row['mauSacSanPham'], $row['kichCoSanPham'], $row['giaLucMua'], $row['tinhTrangXacNhan'], $row['thoiGianDat'], $row['soLuong'], $row['donDatHangID'], $row['hoaDonID']));
        
    }
    echo json_encode($array);



?>