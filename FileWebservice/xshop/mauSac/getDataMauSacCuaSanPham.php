<?php
	// cái này là lấy thông tin màu sắc cho 1 sản phẩm. Dành cho ngươif dùng là chính(và vẫn có thể dùng cho Admin)
	require '../connect/dbcon.php';
		class MauSac {
		    public $mauSacID;
		    public $tenMauSac;
		    public $maMauSac;
		    public $sanPhamID;
		   
		        
		    public function __construct($mauSacID, $tenMauSac, $maMauSac, $sanPhamID) {
		        $this->mauSacID = $mauSacID;
		        $this->tenMauSac = $tenMauSac;
		        $this->maMauSac = $maMauSac;
		        $this->sanPhamID = $sanPhamID;
		        
		    }
		}
		$sanPhamID = $_POST['sanPhamID'];
		// $sanPhamID = '7';

		$querry = "SELECT * FROM tbl_mausac WHERE sanPhamID = '$sanPhamID'";

		$data = mysqli_query($connect, $querry);


		$mArray = array();

		while ($row = mysqli_fetch_assoc($data)) {
			array_push($mArray, new MauSac($row['mauSacID'], 
				$row['tenMauSac'],
				$row['maMauSac'],
				$row['sanPhamID']));
			
		}
		echo json_encode($mArray);

?>