<?php
// file add 1 đối tượng thông tin ghế vào cơ sở dữ liệu
    require '../connect/dbcon.php';


    $tenBoSuuTap = $_POST['tenBoSuuTap'];
    $moTaBoSuuTap = $_POST['moTaBoSuuTap'];
    $chiTietBoSuuTap = $_POST['chiTietBoSuuTap'];
    $anhDaiDienBoSuuTap = $_POST['anhDaiDienBoSuuTap'];
    $hot = $_POST['hot'];

    // $tenBoSuuTap = 'tenBoSuuTapDemoooooooo';
    // $moTaBoSuuTap = 'moTaBoSuuTapDemooooooo';
    // $chiTietBoSuuTap = 'chiTietBoSuuTapDemooooo';
    // $anhDaiDienBoSuuTap = 'anhDaiDienBoSuuTapDemooooooo';
    // $hot = '14-11-2023';




    $querry = "INSERT INTO tbl_bosuutap VALUE(null, '$tenBoSuuTap', '$moTaBoSuuTap', '$chiTietBoSuuTap', '$anhDaiDienBoSuuTap', '$hot')";

    if (mysqli_query($connect, $querry)) {
        echo "thanhcong";
    }else{
        echo "khongthanhcong";
    }


?>