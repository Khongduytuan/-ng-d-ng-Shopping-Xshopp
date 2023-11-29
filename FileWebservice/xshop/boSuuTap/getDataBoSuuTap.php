<?php
	// include "E:\App\Xampp\htdocs\xshop\connect";
	require '../connect/dbcon.php';
		class BoSuuTap {
		    public $boSuuTapID;
		    public $tenBoSuuTap;
		    public $moTaBoSuuTap;
		    public $chiTietBoSuuTap;
		    public $anhDaiDienBoSuuTap;
		    public $hot;

		    public function __construct($boSuuTapID, $tenBoSuuTap, $moTaBoSuuTap, $chiTietBoSuuTap, $anhDaiDienBoSuuTap, $hot) {
		        $this->boSuuTapID = $boSuuTapID;
		        $this->tenBoSuuTap = $tenBoSuuTap;
		        $this->moTaBoSuuTap = $moTaBoSuuTap;
		        $this->chiTietBoSuuTap = $chiTietBoSuuTap;
		        $this->anhDaiDienBoSuuTap = $anhDaiDienBoSuuTap;
		        $this->hot = $hot;
		    }
		}


		$querry = "SELECT * FROM tbl_bosuutap";

		$data = mysqli_query($connect, $querry);


		$userArray = array();

		while ($row = mysqli_fetch_assoc($data)) {
			array_push($userArray, new BoSuuTap($row['boSuuTapID'], 
				$row['tenBoSuuTap'], 
				$row['moTaBoSuuTap'], 
				$row['chiTietBoSuuTap'], 
				$row['anhDaiDienBoSuuTap'],
				$row['hot']));
			
		}
		echo json_encode($userArray);

?>