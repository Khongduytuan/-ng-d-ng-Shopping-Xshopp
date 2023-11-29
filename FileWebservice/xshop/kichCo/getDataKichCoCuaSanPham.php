<?php
	// cái này là lấy thông tin màu sắc cho 1 sản phẩm. Dành cho ngươif dùng là chính(và vẫn có thể dùng cho Admin)
	require '../connect/dbcon.php';
		class KichCo {
		    public $kichCoID;
		    public $tenKichCo;
		    public $kyHieuKichCoBangChu;
		    public $kyHieuKichCoBangSo;
		    public $sanPhamID;
		   
		        
		    public function __construct($kichCoID, $tenKichCo, $kyHieuKichCoBangChu, $kyHieuKichCoBangSo, $sanPhamID) {
		        $this->kichCoID = $kichCoID;
		        $this->tenKichCo = $tenKichCo;
		        $this->kyHieuKichCoBangChu = $kyHieuKichCoBangChu;
		        $this->kyHieuKichCoBangSo = $kyHieuKichCoBangSo;
		        $this->sanPhamID = $sanPhamID;
		        
		    }
		}
		$sanPhamID = $_POST['sanPhamID'];
		// $sanPhamID = '7';

		$querry = "SELECT * FROM tbl_kichco WHERE sanPhamID = '$sanPhamID'";

		$data = mysqli_query($connect, $querry);


		$mArray = array();

		while ($row = mysqli_fetch_assoc($data)) {
			array_push($mArray, new KichCo($row['kichCoID'], 
				$row['tenKichCo'],
				$row['kyHieuKichCoBangChu'],
				$row['kyHieuKichCoBangSo'],
				$row['sanPhamID']));
			
		}
		echo json_encode($mArray);

?>