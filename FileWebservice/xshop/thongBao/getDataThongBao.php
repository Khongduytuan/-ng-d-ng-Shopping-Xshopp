<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';

    class ThongBao {
        public $thongBaoID;
        public $tenThongBao;
        public $noiDungThongBao;

        public function __construct($thongBaoID, $tenThongBao, $noiDungThongBao) {
            $this->thongBaoID = $thongBaoID;
            $this->tenThongBao = $tenThongBao;
            $this->noiDungThongBao = $noiDungThongBao;
        }
    }


    $querry = "SELECT * FROM tbl_thongbao";
    
    $data = mysqli_query($connect, $querry);
    $array = array();



    while ($row = mysqli_fetch_assoc($data)) {
        array_push($array, new ThongBao($row['thongBaoID'], $row['tenThongBao'], $row['noiDungThongBao']));
        
    }
    echo json_encode($array);

?>