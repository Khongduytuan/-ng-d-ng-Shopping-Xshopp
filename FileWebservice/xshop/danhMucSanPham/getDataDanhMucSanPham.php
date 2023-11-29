<?php
	// include "E:\App\Xampp\htdocs\xshop\connect";
	require '../connect/dbcon.php';
		class DanhMuc {
		    public $danhMucSanPhamID;
		    public $tenDanhMuc;
		    public $trangThai;
		    public $capDoDanhMuc;
		    public $nguoiTaoDanhMuc;
		    public $ngayTaoDanhMuc;
		        
		    public function __construct($danhMucSanPhamID, $tenDanhMuc, $trangThai, $capDoDanhMuc, $nguoiTaoDanhMuc, $ngayTaoDanhMuc) {
		        $this->danhMucSanPhamID = $danhMucSanPhamID;
		        $this->tenDanhMuc = $tenDanhMuc;
		        $this->trangThai = $trangThai;
		        $this->capDoDanhMuc = $capDoDanhMuc;
		        $this->nguoiTaoDanhMuc = $nguoiTaoDanhMuc;
		        $this->ngayTaoDanhMuc = $ngayTaoDanhMuc;
		    }
		}


		$querry = "SELECT * FROM tbl_danhmucsanpham";

		$data = mysqli_query($connect, $querry);


		$mArray = array();

		while ($row = mysqli_fetch_assoc($data)) {
			array_push($mArray, new DanhMuc($row['danhMucSanPhamID'], 
				$row['tenDanhMuc'], 
				$row['trangThai'], 
				$row['capDoDanhMuc'], 
				$row['nguoiTaoDanhMuc'],
				$row['ngayTaoDanhMuc']));
			
		}
		echo json_encode($mArray);

?>