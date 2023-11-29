<?php
	// include "E:\App\Xampp\htdocs\xshop\connect";
	require '../connect/dbcon.php';
		class BinhLuan {
		    public $binhLuanID;
		    public $tenNguoiDung;
		    public $noiDungBinhLuan;
		    public $emailNguoiBinhLuan;
		    public $ngayBinhLuan;
		    public $sanPhamID;
		       
		    public function __construct($binhLuanID, $tenNguoiDung, $noiDungBinhLuan, $emailNguoiBinhLuan, $ngayBinhLuan, $sanPhamID) {
		        $this->binhLuanID = $binhLuanID;
		        $this->tenNguoiDung = $tenNguoiDung;
		        $this->noiDungBinhLuan = $noiDungBinhLuan;
		        $this->emailNguoiBinhLuan = $emailNguoiBinhLuan;
		        $this->ngayBinhLuan = $ngayBinhLuan;
		        $this->sanPhamID = $sanPhamID;
		    }
		}

		$sanPhamID = $_POST['sanPhamID'];
		// $sanPhamID = '7';
		$querry = "SELECT * FROM tbl_binhluan WHERE sanPhamID='$sanPhamID'";

		$data = mysqli_query($connect, $querry);


		$userArray = array();

		while ($row = mysqli_fetch_assoc($data)) {
			array_push($userArray, new BinhLuan($row['binhLuanID'], 
				$row['tenNguoiDung'], 
				$row['noiDungBinhLuan'], 
				$row['emailNguoiBinhLuan'], 
				$row['ngayBinhLuan'],
				$row['sanPhamID']));
			
		}
		echo json_encode($userArray);
?>