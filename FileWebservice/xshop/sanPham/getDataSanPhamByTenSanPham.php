<?php
// FILE LẤY DỮ LIỆU LỊCH ĐẶT CHO CLIENT VỚI MỖI UID CỦA CLIENT
require '../connect/dbcon.php';
	class SanPham {
		public $sanPhamID;
		public $boSuuTapID;
	    public $danhMucID;
	    public $tenSanPham;
	    public $chatLieuSanPham;
	    public $gia;
	    public $giaKhuyenMai;
	    public $ngaySanXuat;
	    public $noiSanXuat;
	    public $moTaSanPham;
	    public $chiTietSanPham;
	    public $anhDaiDienSanPham;
	    public $chatLuongSanPham;
	    public $soLuong;
	    public $hot;
	    public $donDatHangChiTietID;

	    

	    public function __construct($sanPhamID, $boSuuTapID, $danhMucID, $tenSanPham, $chatLieuSanPham, $gia, $giaKhuyenMai,$ngaySanXuat, $noiSanXuat, $moTaSanPham, $chiTietSanPham, $anhDaiDienSanPham, $chatLuongSanPham, $soLuong, $hot, $donDatHangChiTietID) {
	        $this->sanPhamID = $sanPhamID;
	        $this->boSuuTapID = $boSuuTapID;
	        $this->danhMucID = $danhMucID;
	        $this->tenSanPham = $tenSanPham;
	        $this->chatLieuSanPham = $chatLieuSanPham;
	        $this->gia = $gia;
	        $this->giaKhuyenMai = $giaKhuyenMai;
	        $this->ngaySanXuat = $ngaySanXuat;
	        $this->noiSanXuat = $noiSanXuat;
	        $this->moTaSanPham = $moTaSanPham;
	        $this->chiTietSanPham = $chiTietSanPham;
	        $this->anhDaiDienSanPham = $anhDaiDienSanPham;
	        $this->chatLuongSanPham = $chatLuongSanPham;
	        $this->soLuong = $soLuong;
	        $this->hot = $hot;
	        $this->donDatHangChiTietID = $donDatHangChiTietID;
	    }
	}

	$chuoiKyTu = $_POST['chuoiKyTu'];
	// $chuoiKyTu = 'Ju';
	

	$querry = "SELECT * FROM tbl_sanpham WHERE tenSanPham LIKE '%$chuoiKyTu%'";
	
	$data = mysqli_query($connect, $querry);
	$array = array();



	while ($row = mysqli_fetch_assoc($data)) {
		array_push($array, new SanPham($row['sanPhamID'], $row['boSuuTapID'], $row['danhMucID'], $row['tenSanPham'],$row['chatLieuSanPham'], $row['gia'], $row['giaKhuyenMai'], $row['ngaySanXuat'], $row['noiSanXuat'], $row['moTaSanPham'], $row['chiTietSanPham'], $row['anhDaiDienSanPham'], $row['chatLuongSanPham'], $row['soLuong'], $row['hot'], $row['donDatHangChiTietID']));
		
	}
	echo json_encode($array);

?>


