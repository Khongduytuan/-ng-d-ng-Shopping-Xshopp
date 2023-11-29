<?php
// file đăng nhập
	require '../connect/dbcon.php';
	class NguoiDung {
	    public $nguoiDungID;
	    public $username;
	    public $password;
	    public $viTri;
	    public $hoVaTen;
	    public $diaChi;
	    public $sdt;
	    public $ngayThangNamSinh;
	    public function __construct($nguoiDungID, $username, $password, $viTri, $hoVaTen, $diaChi, $sdt, $ngayThangNamSinh) {
		        $this->nguoiDungID = $nguoiDungID;
		        $this->username = $username;
		        $this->password = $password;
		        $this->viTri = $viTri;
		        $this->hoVaTen = $hoVaTen;
		        $this->diaChi = $diaChi;
		        $this->sdt = $sdt;
		        $this->ngayThangNamSinh = $ngayThangNamSinh;
	    	}
		
	}

	$username = $_POST["username"];
	$password = $_POST["password"];


	if (strlen($username) > 0 && strlen($password) > 0) {
		$mangUser = array();
		$querry = "SELECT * FROM tbl_nguoidung WHERE FIND_IN_SET('$username', username) AND FIND_IN_SET('$password', password)";
		$data = mysqli_query($connect, $querry);
		if ($data) {
			while ($row = mysqli_fetch_assoc($data)) {
				array_push($mangUser, new NguoiDung($row['nguoiDungID'], 
					$row['username'], 
					$row['password'], 
					$row['viTri'], 
					$row['hoVaTen'],
					$row['diaChi'],  
					$row['sdt'], 
					$row['ngayThangNamSinh']));
			}
			if (count($mangUser) > 0) {
				echo json_encode($mangUser); 
			}
			else{
				echo "loi";
			}
		}
	}
	else{
		echo "null";
	}


?>
