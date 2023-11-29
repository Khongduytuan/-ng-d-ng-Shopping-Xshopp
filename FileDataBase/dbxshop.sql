-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 29, 2023 lúc 08:11 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbxshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_bosuutap`
--

CREATE TABLE `tbl_bosuutap` (
  `boSuuTapID` int(11) NOT NULL,
  `tenBoSuuTap` varchar(100) NOT NULL,
  `moTaBoSuuTap` text NOT NULL,
  `chiTietBoSuuTap` text NOT NULL,
  `anhDaiDienBoSuuTap` varchar(255) NOT NULL,
  `hot` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_bosuutap`
--

INSERT INTO `tbl_bosuutap` (`boSuuTapID`, `tenBoSuuTap`, `moTaBoSuuTap`, `chiTietBoSuuTap`, `anhDaiDienBoSuuTap`, `hot`) VALUES
(1, 'Bộ sưu tập xuân hạ 2023', 'Bộ sưu tập quần áo công sở xuân hạ của chúng tôi là sự kết hợp tinh tế giữa thiết kế hiện đại và sự thoải mái, mang đến cho phụ nữ không chỉ phong cách mà còn sự thoải mái khi làm việc.', 'Chúng tôi đã đặt nặng vào việc lựa chọn chất liệu như chiffon nhẹ, cotton thoáng khí, và linen mềm mại để tạo ra những sản phẩm mang đến cảm giác thoải mái và tự tin cho phái đẹp. Đường may tỉ mỉ và chi tiết nhỏ như cổ áo, túi xách, hay nút cài đều được chú ý để tăng thêm sự sang trọng và chất lượng.\r\n\r\nSự đa dạng trong kiểu dáng như áo sơ mi oversize, quần culottes rộng rãi, và váy xòe nhẹ nhàng cho thấy mong muốn phục vụ mọi người phụ nữ, từ người thích sự quý phái đến những người ưa thích sự năng động. Màu sắc từ pastel nhẹ nhàng đến trung tính tinh tế được chọn lựa một cách cân nhắc, tạo nên một bức tranh màu sắc phong phú và tràn ngập năng lượng tích cực, đúng như là bức tranh của một mùa xuân hạ tươi mới.', 'https://lh6.googleusercontent.com/eHuOSTs6d0sbmug7omhcz_yD-NRxAFOjrktyBEHDZjiVcjk2YV3q6Ve8X0bkcJUuPw0xzc8DFVmYvMQesOXciCjJ15VrdHsyyYkmHcWXk-i-KRBScZOpp1QqhGssgtGNgpS92aw', '0000-00-00'),
(2, 'Bộ Sưu Tập Áo Giả Lông Cừu Thu/Đông 2023', 'Áo giả lông cừu XShop. Kiểu dáng mới. Cảm giác mới', 'Chúng tôi đã thật sự tập trung vào sự dịu dàng và mềm mại với da của bạn. Ấm áp như chất liệu dệt kim, nhưng dễ chăm sóc vì là sản phẩm giả lông cừu. Những chiếc áo thun hoàn hảo để mặc độc lập hoặc phối như một lớp lót bên trong. Có thể sử dụng cho một mùa dài, từ thu sang đông.', 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/463164/item/vngoods_31_463164.jpg?width=828', '2023-11-10'),
(3, 'JUJUTSU KAISEN SEASON 2', 'Bộ anime truyền hình nổi tiếng \"JUJUTSU KAISEN\" nay đã đến với XShop', 'Bộ anime truyền hình nổi tiếng \"JUJUTSU KAISEN\" đã đến với XShop! Bộ sưu tập lần này lấy cảm hứng từ phần \"Hidden Inventory/Premature Death\" tiết lộ quá khứ của Satoru Gojo và Suguru Geto, và phần \"Shibuya Incident\" tiếp tục dòng thời gian từ mùa đầu tiên. Các nhân vật được yêu thích và những hình ảnh mang tính biểu tượng trong bộ truyện được khắc họa trên những thiết kế áo thun của XShop.', 'https://www.dexerto.com/cdn-cgi/image/width=3840,quality=75,format=auto/https://editors.dexerto.com/wp-content/uploads/2023/09/08/jujutsu-kaisen-season-2-both-arcs.jpg', '2023-11-15'),
(6, 'ÁO KHOÁC LOCAL BRAND NỮ RẺ DKMV', 'Áo khoác Local Brand Nữ là lựa chọn hoàn hảo cho những người phụ nữ hiện đại, mang đến sự phối hợp tinh tế giữa phong cách và tính tiện ích. Thiết kế độc đáo và chất liệu chất lượng cao tạo nên sự thoải mái và ấm áp.', 'Áo khoác Local Brand Nữ không chỉ là một chiếc áo khoác, mà còn là biểu tượng của phong cách và sự thoải mái. Được làm từ chất liệu vải chất lượng cao, áo khoác này mang lại cảm giác êm dịu và bền bỉ. Thiết kế độc đáo với chi tiết cẩn thận, áo khoác kết hợp một loạt các yếu tố thời trang, từ cổ điển đến hiện đại.\r\n\r\nVới phong cách Local Brand, sản phẩm không chỉ là một bộ phận của thời trang hàng ngày, mà còn là tuyên bố cá nhân. Áo khoác nữ này không chỉ giữ ấm cho bạn trong những ngày lạnh, mà còn là điểm nhấn thú vị cho trang phục của bạn. Được thiết kế để đáp ứng nhu cầu của người tiêu dùng thông thái về giá trị, áo khoác Local Brand Nữ là sự kết hợp hoàn hảo giữa chất lượng và sự tiện lợi với giá trị không thể tin được.', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__3__8f9b311fe9434e29a16f3abe8b12ffc2_grande.png', '2023-11-13'),
(7, 'Bộ sưu tập Blazer', ' Blazer là một chiếc áo khoác có kiểu dáng chuyên nghiệp, thường được kết hợp với quần âu hoặc váy công sở. Chúng thường có màu sắc trung tính như đen, navy, hoặc xám.', 'Blazer trong bộ sưu tập của chúng tôi được thiết kế với kiểu dáng chuyên nghiệp và sự tinh tế trong đơn giản. Với cổ tròn hay cổ lá sen, chiếc blazer này mang lại vẻ lịch lãm và đồng thời dễ dàng kết hợp với nhiều loại trang phục khác nhau.Chúng tôi đã lựa chọn chất liệu vải cao cấp như lụa, wool hoặc cotton blend để đảm bảo không chỉ sự mềm mại mà còn độ bền và chất lượng vượt trội. Chất liệu này không chỉ tạo nên sự thoải mái mà còn giữ được hình dáng và form dáng của blazer qua thời gian.', 'https://aristino.com/Data/ResizeImage/images/product/ao-blazer/1sj01203/NTC_9341x900x900x4.webp', '0000-00-00'),
(8, 'Bộ sưu tập áo sơ mi 2023', 'Bộ sưu tập Áo Sơ Mi 2023 của chúng tôi là sự kết hợp độc đáo giữa thiết kế hiện đại và vẻ thanh lịch, hứa hẹn mang đến cho người mặc những trải nghiệm mới mẻ trong thế giới thời trang công sở. Mỗi chiếc áo sơ mi không chỉ là một trang phục, mà là biểu tượ', 'Bộ sưu tập này mang đến một loạt kiểu dáng đa dạng, từ áo sơ mi cổ điển đến áo sơ mi oversize và áo sơ mi dài tay với nhiều chi tiết độc đáo. Đường may tinh tế và form dáng chau chuốt giúp tôn lên vóc dáng và tạo nên vẻ ngoại hình chuyên nghiệp.Bộ sưu tập này không ngần ngại sử dụng màu sắc đa dạng, từ những gam màu truyền thống như trắng, đen, và navy cho đến những màu sắc tươi sáng như hồng phấn, xanh mint, và cam. Mỗi màu sắc đều được lựa chọn cẩn thận để tạo ra sự cân bằng và hài hòa.', 'https://lh3.googleusercontent.com/jrmUdY-Gp5t9KhiXdRtCylg2lquyyjrzxzZwugdTSgDp4NYk1ogI-K21k1mADHTuuZ_RljNLp4Mdq0k3CXKBiBwAhuTDC68wcNMhoSo3yxww_-fjk5aVD6-EHkgUtiMsOP2Dce9r', '0000-00-00'),
(9, 'Bộ sưu tập Đầm và Chân váy', 'Bộ sưu tập đầm và chân váy của chúng tôi mang đến một hành trình thời trang đầy ấn tượng và sang trọng, tôn lên vẻ đẹp tự tin và quý phái của phụ nữ. Từ những kiểu dáng đơn giản đến những chi tiết độc đáo, mỗi mẫu thiết kế đều được chú trọng để thể hiện s', 'Chân váy pencil với độ ôm vừa vặn, kết hợp cùng chất liệu co giãn, tạo nên sự thoải mái trong khi vẫn giữ được sự chuyên nghiệp. Phù hợp cho môi trường công sở.\r\nBộ sưu tập \"Elegance in Motion\" không chỉ là sự kết hợp tài năng nghệ thuật và sự chăm chỉ trong việc lựa chọn chất liệu mà còn là sự thể hiện rõ nét của sự đẳng cấp và phong cách trong từng đường may.', 'https://cdn.kkfashion.vn/25845-large_default/dam-den-cong-so-om-body-phoi-that-lung-kk162-38.jpg', '2023-12-15'),
(10, 'Bộ sưu tập quần âu công sở 2023', 'Thời trang dành cho phái mạnh thường không có quá nhiều sự lựa chọn. Đa số chỉ xoay quanh quần, áo, đôi khi có thêm áo khoác ngoài. Vì vậy, để lựa chọn và kết kết hợp giúp bộ trang phục đẹp hơn cũng là một việc không dễ dàng. Cùng Generos tìm hiểu bộ sưu tập quần âu công sở đang được ưa chuộng nhất.', 'Phối quần đen với áo sơ mi trắng: Sự tương phản 2 tone màu trắng – đen sẽ đem lại cho bạn sự nổi bật khi diện bộ trang phục này. Không những thế, thiết kế áo sơ mi trắng cũng giúp vẻ ngoài của bạn trông năng động và trẻ trung hơn.', 'https://file.hstatic.net/200000564155/file/ld013_3b4f434b40f54ae2a85e86c5d891e657_grande.jpg', '2023-11-09');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_danhmucsanpham`
--

CREATE TABLE `tbl_danhmucsanpham` (
  `danhMucSanPhamID` int(11) NOT NULL,
  `tenDanhMuc` varchar(255) NOT NULL,
  `trangThai` int(11) NOT NULL,
  `capDoDanhMuc` int(11) NOT NULL,
  `nguoiTaoDanhMuc` varchar(20) NOT NULL,
  `ngayTaoDanhMuc` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_danhmucsanpham`
--

INSERT INTO `tbl_danhmucsanpham` (`danhMucSanPhamID`, `tenDanhMuc`, `trangThai`, `capDoDanhMuc`, `nguoiTaoDanhMuc`, `ngayTaoDanhMuc`) VALUES
(1, 'Áo', 1, 0, 'Admin', '2023-10-28 18:07:23'),
(2, 'Quần', 1, 0, 'Admi', '2023-10-28 18:08:02'),
(3, 'Đầm&Chân váy', 1, 0, 'Admin', '2023-10-28 20:00:00'),
(4, 'Đồ mặc nhà', 1, 0, 'Admin', '2023-10-28 18:08:02'),
(5, 'Đồ mặc ngoài', 1, 0, 'Admin', '2023-10-28 18:08:02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_dondathang`
--

CREATE TABLE `tbl_dondathang` (
  `donDatHangID` int(11) NOT NULL,
  `nguoiDungID` int(11) NOT NULL,
  `ngayDatHang` datetime NOT NULL,
  `trangThaiXuLy` varchar(100) NOT NULL,
  `trangThaiGiaoHang` varchar(100) NOT NULL,
  `ngayGiaoHang` datetime NOT NULL,
  `ngayDuKienGiaoHang` date NOT NULL,
  `tongTien` float NOT NULL,
  `maGiamGiaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_dondathang`
--

INSERT INTO `tbl_dondathang` (`donDatHangID`, `nguoiDungID`, `ngayDatHang`, `trangThaiXuLy`, `trangThaiGiaoHang`, `ngayGiaoHang`, `ngayDuKienGiaoHang`, `tongTien`, `maGiamGiaID`) VALUES
(8, 2, '0000-00-00 00:00:00', 'Chưa Xác Nhận', 'Chưa Giao Hàng', '0000-00-00 00:00:00', '0000-00-00', 500000, 1),
(9, 2, '0000-00-00 00:00:00', 'Chưa Xác Nhận', 'Chưa Giao Hàng', '0000-00-00 00:00:00', '0000-00-00', 500000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_dondathangchitiet`
--

CREATE TABLE `tbl_dondathangchitiet` (
  `donDatHangChiTietID` int(11) NOT NULL,
  `sanPhamID` int(11) NOT NULL,
  `nguoiDungID` int(11) NOT NULL,
  `tenSanPham` varchar(225) NOT NULL,
  `anhDaiDienSanPhamTrongDonHang` text NOT NULL,
  `mauSacSanPham` varchar(11) NOT NULL,
  `kichCoSanPham` varchar(11) NOT NULL,
  `giaLucMua` float NOT NULL,
  `tinhTrangXacNhan` text NOT NULL,
  `thoiGianDat` varchar(20) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donDatHangID` int(11) NOT NULL,
  `hoaDonID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_dondathangchitiet`
--

INSERT INTO `tbl_dondathangchitiet` (`donDatHangChiTietID`, `sanPhamID`, `nguoiDungID`, `tenSanPham`, `anhDaiDienSanPhamTrongDonHang`, `mauSacSanPham`, `kichCoSanPham`, `giaLucMua`, `tinhTrangXacNhan`, `thoiGianDat`, `soLuong`, `donDatHangID`, `hoaDonID`) VALUES
(12, 1, 0, 'Áo Phông Jujutsu kaishen', '', 'Xanh', 'M', 300000, '', '', 2, 8, 1),
(13, 1, 0, 'Áo Phông Jujutsu kaishen', '', 'Xanh', 'M', 250000, '', '', 2, 8, 1),
(14, 1, 0, 'Áo Phông Jujutsu kaishen', '', 'Xanh', 'M', 250000, '', '', 2, 8, 1),
(15, 1, 0, 'Áo Phông Jujutsu kaishen', '', 'Xanh', 'M', 250000, '', '', 2, 8, 1),
(48, 11, 0, 'Áo khoác HeyYou', '', 'Đen', 'L', 300000, '', '', 1, 8, 1),
(49, 11, 0, 'Áo khoác HeyYou', '', 'Xanh lá mạ', 'L', 300000, '', '', 1, 8, 1),
(50, 12, 0, 'Eternity', '', 'Xanh Dương', 'M', 299000, '', '', 1, 8, 1),
(51, 14, 0, 'Angel Land', '', 'Xanh lá mạ', 'M', 199000, '', '', 1, 8, 1),
(52, 11, 0, 'Áo khoác HeyYou', '', 'Xanh lá mạ', 'L', 300000, '', '', 1, 8, 1),
(53, 11, 0, 'Áo khoác HeyYou', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__5__bcba9bf96e7b4c9d8a90c1fea09b86a3_grande.png', 'Hồng ', 'L', 300000, '', '', 3, 8, 1),
(55, 16, 1, 'Couple TX', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__5__bcba9bf96e7b4c9d8a90c1fea09b86a3_grande.png', 'Hồng', 'L', 199000, 'Giao thành công', '', 1, 8, 1),
(56, 11, 1, 'Áo khoác HeyYou', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__5__bcba9bf96e7b4c9d8a90c1fea09b86a3_grande.png', 'Xanh Dương', 'L', 300000, 'Chưa xác nhận', '', 2, 8, 1),
(57, 12, 1, 'Eternity', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__4__5f6a1d6795be47ab92937de72885f853_grande.png', 'Nâu', 'L', 299000, 'Đã xác nhận', '', 1, 8, 1),
(58, 12, 1, 'Eternity', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__4__5f6a1d6795be47ab92937de72885f853_grande.png', 'Nâu', 'L', 299000, 'Đã xác nhận', '2023-11-26 10:57:19', 1, 8, 1),
(73, 12, 1, 'Eternity', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__4__5f6a1d6795be47ab92937de72885f853_grande.png', 'Xanh Dương', 'XS', 299000, 'Đã xác nhận', '2023-11-27 08:56:27', 2, 8, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_hoadon`
--

CREATE TABLE `tbl_hoadon` (
  `hoaDonID` int(11) NOT NULL,
  `nguoiDungID` int(11) NOT NULL,
  `ngayDatHang` datetime NOT NULL,
  `tongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_hoadon`
--

INSERT INTO `tbl_hoadon` (`hoaDonID`, `nguoiDungID`, `ngayDatHang`, `tongTien`) VALUES
(1, 1, '2023-11-21 09:22:02', 500000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_hoadonchitiet`
--

CREATE TABLE `tbl_hoadonchitiet` (
  `hoaDonChiTietID` int(11) NOT NULL,
  `hoaDonID` int(11) NOT NULL,
  `sanPhamID` int(11) NOT NULL,
  `tenSanPham` varchar(100) NOT NULL,
  `giaHienTai` float NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_kichco`
--

CREATE TABLE `tbl_kichco` (
  `kichCoID` int(11) NOT NULL,
  `tenKichCo` varchar(10) NOT NULL,
  `kyHieuKichCoBangChu` varchar(10) NOT NULL,
  `kyHieuKichCoBangSo` varchar(10) NOT NULL,
  `sanPhamID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_kichco`
--

INSERT INTO `tbl_kichco` (`kichCoID`, `tenKichCo`, `kyHieuKichCoBangChu`, `kyHieuKichCoBangSo`, `sanPhamID`) VALUES
(19, 'XS', 'XS', '38', 11),
(20, 'S', 'S', '39', 11),
(21, 'M', 'M', '40', 11),
(22, 'L', 'L', '41', 11),
(23, 'S', 'S', '39', 12),
(24, 'XS', 'XS', '39', 12),
(25, 'M', 'M', '40', 12),
(26, 'L', 'L', '41', 12),
(27, 'S', 'S', '39', 13),
(28, 'XS', 'XS', '39', 13),
(29, 'M', 'M', '40', 13),
(30, 'L', 'L', '41', 13),
(31, 'S', 'S', '39', 14),
(32, 'XS', 'XS', '39', 14),
(33, 'M', 'M', '40', 14),
(34, 'L', 'L', '41', 14),
(35, 'S', 'S', '39', 15),
(36, 'XS', 'XS', '39', 15),
(37, 'M', 'M', '40', 15),
(38, 'L', 'L', '41', 15),
(39, 'S', 'S', '39', 16),
(40, 'XS', 'XS', '39', 16),
(41, 'M', 'M', '40', 16),
(42, 'L', 'L', '41', 16),
(43, 'XS', 'XS', '38', 17),
(44, 'XS', 'XS', '38', 17),
(45, 'S', 'S', '39', 17),
(46, 'M', 'M', '40', 17),
(47, 'L', 'L', '41', 17),
(48, 'XS', 'XS', '38', 18),
(49, 'S', 'S', '39', 18),
(50, 'M', 'M', '40', 18),
(51, 'L', 'L', '41', 18),
(52, 'XS', 'XS', '38', 19),
(53, 'S', 'S', '39', 19),
(54, 'M', 'M', '40', 19),
(55, 'L', 'L', '41', 19),
(56, 'XS', 'XS', '38', 20),
(57, 'S', 'S', '39', 20),
(58, 'M', 'M', '40', 20),
(59, 'L', 'L', '41', 20),
(60, 'XS', 'XS', '38', 21),
(61, 'S', 'S', '39', 21),
(62, 'M', 'M', '40', 21),
(63, 'L', 'L', '41', 21),
(64, 'XS', 'XS', '38', 22),
(65, 'S', 'S', '39', 22),
(66, 'M', 'M', '40', 22),
(67, 'L', 'L', '41', 22),
(68, 'XS', 'XS', '38', 23),
(69, 'S', 'S', '39', 23),
(70, 'M', 'M', '40', 23),
(71, 'L', 'L', '41', 23),
(72, 'XS', 'XS', '38', 24),
(73, 'S', 'S', '39', 24),
(74, 'M', 'M', '40', 24),
(75, 'L', 'L', '41', 24),
(76, 'XS', 'XS', '38', 25),
(77, 'S', 'S', '39', 25),
(78, 'M', 'M', '40', 25),
(79, 'L', 'L', '41', 25),
(80, 'XS', 'XS', '38', 26),
(81, 'S', 'S', '39', 26),
(82, 'M', 'M', '40', 26),
(83, 'L', 'L', '41', 26);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_magiamgia`
--

CREATE TABLE `tbl_magiamgia` (
  `maGiamGiaID` int(11) NOT NULL,
  `tenMaGiamGia` varchar(100) NOT NULL,
  `moTaMaGiamGia` varchar(255) NOT NULL,
  `chiTietMaGiamGia` varchar(255) NOT NULL,
  `phanTramGiamGia` float NOT NULL,
  `trangThaiSuDung` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_magiamgia`
--

INSERT INTO `tbl_magiamgia` (`maGiamGiaID`, `tenMaGiamGia`, `moTaMaGiamGia`, `chiTietMaGiamGia`, `phanTramGiamGia`, `trangThaiSuDung`) VALUES
(1, 'Giảm 50%', 'Giảm 50%', 'Giảm 50%', 50, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_mausac`
--

CREATE TABLE `tbl_mausac` (
  `mauSacID` int(11) NOT NULL,
  `tenMauSac` varchar(10) NOT NULL,
  `maMauSac` varchar(10) NOT NULL,
  `sanPhamID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_mausac`
--

INSERT INTO `tbl_mausac` (`mauSacID`, `tenMauSac`, `maMauSac`, `sanPhamID`) VALUES
(14, 'tenMauSacD', 'F0', 7),
(15, 'Đen', '#000000', 11),
(16, 'Xanh Đen', '#000080', 11),
(17, 'Xanh Dương', '#0000FF', 11),
(18, 'Xanh lá mạ', '#008000', 11),
(19, 'Hồng ', '#FF00FF', 11),
(20, 'Nâu', '#A52A2A', 11),
(21, 'Xám', '#808080', 11),
(22, 'Xanh Đen', '#000080', 12),
(23, 'Xanh Dương', '#0000FF', 12),
(24, 'Xanh lá mạ', '#008000', 12),
(25, 'Hồng ', '#FF00FF', 12),
(26, 'Nâu', '#A52A2A', 12),
(27, 'Xám', '#808080', 12),
(28, 'Xanh Đen', '#000080', 13),
(29, 'Xanh Dương', '#0000FF', 13),
(30, 'Xanh lá mạ', '#008000', 13),
(31, 'Hồng ', '#FF00FF', 13),
(32, 'Nâu', '#A52A2A', 13),
(33, 'Xám', '#808080', 13),
(34, 'Xanh Đen', '#000080', 14),
(35, 'Xanh Dương', '#0000FF', 14),
(36, 'Xanh lá mạ', '#008000', 14),
(37, 'Hồng ', '#FF00FF', 14),
(38, 'Nâu', '#A52A2A', 14),
(39, 'Xám', '#808080', 14),
(40, 'Xanh Đen', '#000080', 15),
(41, 'Xanh Dương', '#0000FF', 15),
(42, 'Xanh lá mạ', '#008000', 15),
(43, 'Hồng ', '#FF00FF', 15),
(44, 'Nâu', '#A52A2A', 15),
(45, 'Xám', '#808080', 15),
(46, 'Xanh Đen', '#000080', 16),
(47, 'Xanh Dương', '#0000FF', 16),
(48, 'Xanh lá mạ', '#008000', 16),
(49, 'Hồng ', '#FF00FF', 16),
(50, 'Nâu', '#A52A2A', 16),
(51, 'Xám', '#808080', 16),
(52, 'Đen', '#000000', 17),
(53, 'Xanh Đen', '#000080', 17),
(54, 'Xanh Dương', '#0000FF', 17),
(55, 'Xám', '#808080', 17),
(56, 'Đen', '#000000', 18),
(57, 'Xanh Đen', '#000080', 18),
(58, 'Xanh Dương', '#0000FF', 18),
(59, 'Xám', '#808080', 18),
(60, 'Đen', '#000000', 19),
(61, 'Xanh Đen', '#000080', 19),
(62, 'Xanh Dương', '#0000FF', 19),
(63, 'Xám', '#808080', 19),
(64, 'Đen', '#000000', 20),
(65, 'Xanh Đen', '#000080', 20),
(66, 'Xanh Dương', '#0000FF', 20),
(67, 'Xám', '#808080', 20),
(68, 'Đen', '#000000', 21),
(69, 'Xanh Đen', '#000080', 21),
(70, 'Xanh Dương', '#0000FF', 21),
(71, 'Xám', '#808080', 21),
(72, 'Đen', '#000000', 22),
(73, 'Xanh Đen', '#000080', 22),
(74, 'Xanh Dương', '#0000FF', 22),
(75, 'Xám', '#808080', 22),
(76, 'Đen', '#000000', 23),
(77, 'Xanh Đen', '#000080', 23),
(78, 'Xanh Dương', '#0000FF', 23),
(79, 'Xám', '#808080', 23),
(80, 'Đen', '#000000', 24),
(81, 'Xanh Đen', '#000080', 24),
(82, 'Xanh Dương', '#0000FF', 24),
(83, 'Xám', '#808080', 24),
(84, 'Đen', '#000000', 25),
(85, 'Xanh Đen', '#000080', 25),
(86, 'Xanh Dương', '#0000FF', 25),
(87, 'Xám', '#808080', 25),
(88, 'Đen', '#000000', 26),
(89, 'Xanh Đen', '#000080', 26),
(90, 'Xanh Dương', '#0000FF', 26),
(91, 'Xám', '#808080', 26);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_nguoidung`
--

CREATE TABLE `tbl_nguoidung` (
  `nguoiDungID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `viTri` varchar(100) NOT NULL,
  `hoVaTen` varchar(255) NOT NULL,
  `diaChi` varchar(255) NOT NULL,
  `sdt` varchar(15) NOT NULL,
  `ngayThangNamSinh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_nguoidung`
--

INSERT INTO `tbl_nguoidung` (`nguoiDungID`, `username`, `password`, `viTri`, `hoVaTen`, `diaChi`, `sdt`, `ngayThangNamSinh`) VALUES
(1, 'khongtuan', '123456', 'user', 'Khổng Duy Tuấn', 'Vĩnh Phúc', '011111', '2001-12-01'),
(2, 'khongtuan2', '123456', 'user', 'Khổng Duy Tuấn 2', 'Vĩnh Phúc', '0333761504', '2001-12-01'),
(3, 'khongtuan3', '123456', 'user', 'Khổng Duy Tuấn 3', 'Vĩnh Phúc', '0333761503', '2001-12-01'),
(4, 'manhtran', '123456', 'Admin', 'Khổng Tuấn ddddd', 'Cà mau', '0999999999', '2001-12-01'),
(6, 'khongtuan222', '1234567', 'User', 'Khổng Tuấn 2', 'Vĩnh Phúc Hà Nội', '0264583725', '2023-11-23');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_sanpham`
--

CREATE TABLE `tbl_sanpham` (
  `sanPhamID` int(11) NOT NULL,
  `boSuuTapID` int(11) NOT NULL,
  `danhMucID` int(11) NOT NULL,
  `tenSanPham` varchar(100) NOT NULL,
  `chatLieuSanPham` varchar(100) NOT NULL,
  `gia` float NOT NULL,
  `giaKhuyenMai` float NOT NULL,
  `ngaySanXuat` date NOT NULL,
  `noiSanXuat` varchar(100) NOT NULL,
  `moTaSanPham` text NOT NULL,
  `chiTietSanPham` text NOT NULL,
  `anhDaiDienSanPham` varchar(255) NOT NULL,
  `chatLuongSanPham` varchar(100) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `hot` date NOT NULL,
  `donDatHangChiTietID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_sanpham`
--

INSERT INTO `tbl_sanpham` (`sanPhamID`, `boSuuTapID`, `danhMucID`, `tenSanPham`, `chatLieuSanPham`, `gia`, `giaKhuyenMai`, `ngaySanXuat`, `noiSanXuat`, `moTaSanPham`, `chiTietSanPham`, `anhDaiDienSanPham`, `chatLuongSanPham`, `soLuong`, `hot`, `donDatHangChiTietID`) VALUES
(1, 3, 1, 'Áo Phông Jujutsu kaishen', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 6, '2023-11-12', 1),
(2, 3, 1, 'Áo Phông Jujutsu kaishen 2', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 8, '2023-11-12', 1),
(3, 2, 3, 'Áo Phông Jujutsu kaishen 4', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(4, 3, 2, 'Áo Phông Jujutsu kaishen 3', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(5, 1, 1, 'Áo Phông Jujutsu kaishen 333', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(6, 2, 4, 'Áo Phông Jujutsu kaishen dddddd', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(7, 3, 1, 'áo jutjusu kaisen', 'áo jutjusu kaisen', 319, 270, '2015-10-07', 'áo jutjusu kaisen', 'áo jutjusu kaisen', 'áo jutjusu kaisen', 'áo jutjusu kaisen', 'new', 10, '2023-11-10', 1),
(8, 3, 1, 'Áo Phông Jujutsu kaishen', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(9, 3, 1, 'Áo Phông Jujutsu kaishen', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(10, 3, 1, 'Áo Phông Jujutsu kaishen', 'Vải cotton', 319000, 270000, '2023-11-01', 'Việt Nam', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'Mô tả sản phẩm xxxxxxxxxxxxx', 'https://salt.tikicdn.com/cache/w1200/ts/product/dc/ef/78/d1ccffdbae8af717bda2ff7a163bf0b0.jpg', '100%', 10, '2023-11-12', 1),
(11, 6, 1, 'Áo khoác HeyYou', 'Cotton 70% và Polieste 30%', 500000, 300000, '2023-11-01', 'Việt Nam', 'Bạn đang tìm một địa chỉ có áo khoác hoodie local brand, áo khoác gió local brand, áo khoác local brand giá rẻ, áo khoác local brand dưới 200k,… HEYYOU là một lựa chọn hoàn hảo dành cho bạn. ', 'Hãng liên tục thiết kế những bộ sưu tập áo khoác mới mẻ lên kệ đều đều và không ngừng cập nhật xu hướng. Sản phẩm của hãng liên tục theo trend mặc dù nó đi theo phong cách đơn giản, cá tính và có gì đó rất chất chơi, thể hiện được cái riêng của người mặc.', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__5__bcba9bf96e7b4c9d8a90c1fea09b86a3_grande.png', 'New 100%', 5, '2023-11-22', 1),
(12, 6, 1, 'Eternity', 'Cotton 100%', 450000, 299000, '2023-11-08', 'Việt Nam', 'Eternity là một trong những cái tên local brand áo khoác giá rẻ thu hút đông đảo giới trẻ hiện nay. Với slogan “Eternity là bạn của học sinh Việt”, không cần quá nhiều thời gian, thương hiệu này đã chiếm được thiện cảm từ đông đảo các bạn học sinh – sinh ', 'Phương châm của hãng “Chắc gì rẻ mà không tốt” đã nhanh chóng lan rộng và được chứng thực. Bởi lượng khách hàng quay trở lại lên đến 48%, một con số ấn tượng với những local brand thời trang ở phân khúc giá rẻ. Thiết kế của Eternity đủ để làm thỏa mãn nhữ', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__4__5f6a1d6795be47ab92937de72885f853_grande.png', 'New 100%', 3, '2023-11-30', 1),
(13, 6, 1, 'Twenti', 'Cotton 100%', 499000, 299000, '2017-11-30', 'Việt Nam-Hồ Chí Minh', 'Nói đến dòng thời trang local brand giá rẻ tốt nhất hiện nay khó có thể quên điểm danh Twenti. Ban đầu hãng này có tên là 20 Years Old và sau này đổi thành Twenti, với khá nhiều kinh nghiệm cùng lượng khách hàng trung thành ổn định. Thương hiệu này có một', 'Hãng theo đuổi phong cách năng động trẻ trung phù hợp với giới trẻ. Đặc biệt giá cả luôn dưới 200k cực kỳ phù hợp với những bạn có thu nhập thấp đến đây lựa chọn. Rẻ mà chất lượng vẫn luôn là phương châm phục vụ mà Twenti gửi đến khách hàng của họ.', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__1__7bb9068315b643cea4a927276c7ab417_grande.png', 'New 100%', 7, '2023-11-15', 1),
(14, 6, 1, 'Angel Land', 'Cotton 100%', 399000, 199000, '2017-11-30', 'Việt Nam-Hà Nội', 'Angel Land vẫn luôn là một trong những cái tên dẫn đầu xu hướng local brand tại Việt Nam. Thương hiệu này vẫn định hình ở phân khúc giá rẻ, phù hợp với đại đa số các bạn học sinh sinh viên Việt Nam và những bạn trẻ có thu nhập thấp. ', 'Giá trị của sản phẩm từ Angel Land tập trung ở sự chuyển đổi và linh hoạt, với tính thẩm mỹ cao, tinh gọn và đậm chất riêng. Các họa tiết in trên áo thun, áo khoác, áo hoodie của Angel Land khá đặc biệt, nó là sự kết hợp đa dạng của các nền văn hóa và trà', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__2__f1a33dc9a04e41dcbd0fce7372cb7815_grande.png', 'New 100%', 26, '2023-11-15', 1),
(15, 6, 1, '7 Millions', 'Sợi tổng hợp', 299000, 199000, '2017-11-30', 'Việt Nam-Hà Nội', 'Bình dị nhất, đơn sắc và đôi khi chỉ có in một dòng chữ nhỏ, một logo nhỏ là đủ để làm nên sự thú vị của chiếc áo thun của 7 Millions. Đơn giản và đầy phong cách là định hướng sản phẩm của local brand áo khoác dưới 200k này. Hãng đi theo phong cách street', 'Nhóm khách hàng mục tiêu của hãng từ 18 – 22 tuổi, có mức thu nhập trung bình thấp, học sinh, sinh viên và những thiết kế sang xịn, mát, giữ đúng form dáng.', 'https://file.hstatic.net/1000184601/file/local-brand-ao-khoac__6__f0821dca8cda454a9c16d8c12085e139_grande.png', 'New 100%', 14, '2023-11-15', 1),
(16, 6, 1, 'Couple TX', 'Sợi vải dù tổng hợp', 299000, 199000, '2017-11-30', 'Việt Nam-Hà Nội', 'Một local brand tầm trung chất lượng như Couple TX từ lâu đã nhận được sự yêu mến của đông đảo khách hàng Việt. Bằng chứng là từ năm 2009 đến nay, hãng đã mở rộng ra 45 chi nhánh trên toàn quốc.', 'Tất cả các sản phẩm đều được đặc biệt chú trọng về chất liệu, liên tục ứng dụng công nghệ mới nhất trong thời trang, đi theo xu hướng đơn giản, phi giới tính, năng động và vươn tầm quốc tế. Thời trang bền vững với chất liệu sợi polyester tái chế bảo vệ mô', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPMSsPoUGQc76za2JKk-ImuBaK1zp__BYY1g&usqp=CAU', 'New 100%', 10, '2023-11-15', 1),
(17, 8, 1, 'Men in Blue', '100% Linen', 500000, 450000, '2023-11-01', 'Việt nam', 'Các mẫu áo sơ mi nam thiết kế trong bộ sưu tập đều có tông màu chủ đạo là màu xanh. Đây là gam màu phù hợp nhất với nam giới, giúp thể hiện năng lượng, sự trẻ trung, chuyên nghiệp và làm nên sức hút đối với phái yếu.', 'Bên cạnh đó, tông màu xanh vừa đủ sự lịch thiệp, sự tự tin và nhất là phù hợp với nhiều thời điểm, hoàn cảnh khác nhau: sự kiện, đi làm, đi chơi… Tuyệt vời hơn đó là màu xanh còn rất dễ phối với các màu sắc khác như: xám, đen, trắng, nâu, đỏ,... đem đến c', 'https://lh6.googleusercontent.com/1EtmnmPtQ543RyHgpqNTC708ABfyHyDVoP5odhhSbNVGB900uDmfnDF1yUUi56ofxcj4lBiJbkyW6o6B-dwzV4S5da_PNiL7FxgvXgNw2XDbunOXlbdxIWCPINeKg6QKf1xjlxZV', 'Mới', 20, '2023-11-29', 0),
(18, 8, 1, 'Day of Summer', '100% Cotton', 499000, 299000, '2023-11-03', 'Việt nam', 'Days Of Summer là BST những mẫu áo sơ mi nam trẻ trung và bắt mắt của TQQ. Những thiết kế nằm trong BST hướng đến sự thoải mái, đẹp mắt, ấn tượng cho nam giới. Các mẫu áo sơ mi cộc tay sử dụng nhiều màu sắc đa dạng như: đỏ rượu, xanh, xám, ghi,... phối cù', 'BST Days Of Summer có lối thiết kế với 2 dáng áo cơ bản là: classic fit, slimfit. Đây là 2 dáng áo dễ dàng phù hợp với nhiều dáng người và đem đến sự thoải mái cho người mặc. Ngoài ra, các thiết kế với form dáng này còn phù hợp nhiều phong cách mặc khác n', 'https://lh3.googleusercontent.com/dEtjSfvsz18WoDzgXHeyw00ezsW9-4hD8m6ujE81qltyvatSRQrnwLZmgigWkC5nWlyvHH-ZG3lABodGZm0p-2EQik6IhJpHA07fiEhBEKrXwL4ZTKeSjrflyrgwer9kM7DSjc0i', 'Mới', 23, '2023-11-30', 1),
(19, 8, 1, 'Fun Office Style', '100% Silk(Lụa)', 500000, 450000, '2022-10-04', 'Việt nam', 'BST Fun Office Style với lối thiết kế hướng tới sự chuyên nghiệp, lịch sự nhưng vẫn thể hiện được sự năng động, trẻ trung cho phái mạnh. Những thiết kế áo sơ mi nằm trong bộ sưu tập phù hợp với đối tượng là nam giới làm việc trong môi trường công sở. Các thiết kế sơ mi nam của Fun Office Style tôn lên sự chỉn chu, phong cách chuyên nghiệp nhưng vẫn mang lại sự thoải mái cho phái mạnh.', 'Các họa tiết chìm, họa tiết nhỏ, kẻ sọc hay kẻ ô phối cùng các gam màu nhã nhặn như: xanh pastel, xanh coban, xanh cổ vịt, xanh ngọc hay nâu, xám nhat,... với cách phối hài hòa, vô cùng đẹp mắt, tạo nên ấn tượng trong mắt người đối diện. Có thể nói đây là những mẫu áo sơ mi mà nam giới công sở không nên bỏ qua.', 'https://tqq.com.vn/hm_content/uploads/seo/so-mi-nam-caro.jpg', 'Mới', 30, '2023-11-30', 1),
(20, 7, 1, 'Áo blazer AristinoB', '50% Wool; 46,5% Polyester; 0,5 Anti Statics', 600000, 500000, '2023-08-01', 'Việt nam ', 'Áo thiết kế lịch lãm với 1 khuy cài, 4 khuy tay áo, 2 đường xẻ tà truyền thống nhưng vẫn trẻ trung. Gam màu trung tính, lịch lãm tạo điểm nhấn nổi bật và thời thượng cho quý ông.', 'Blazer này là một kiệt tác thiết kế, với sự lịch lãm độc đáo và sự trẻ trung tinh tế. Với việc sử dụng một khuy cài và bốn khuy tay áo, blazer mang lại cảm giác sang trọng và chuyên nghiệp. Điểm nhấn tinh tế của blazer là hai đường xẻ tà truyền thống, nhưng được tái tạo một cách hiện đại, giữ cho bức tranh chung luôn mới mẻ và phong cách. Gam màu trung tính được chọn lựa với cẩn thận, tạo nên một vẻ ngoại hình lịch lãm và thời thượng cho quý ông hiện đại. Blazer này không chỉ là một chiếc áo, mà là biểu tượng của sự phối hợp tinh tế giữa truyền thống và đương đại, phản ánh phong cách riêng biệt và đẳng cấp của người mặc.', 'https://aristino.com/Data/ResizeImage/images/product/ao-blazer/1sj01203/NTC_9325x900x900x4.webp', 'Mới', 40, '2023-12-01', 0),
(21, 7, 1, 'Áo blazer nam Aristino ABZ00201', '70% Polyester; 28% Rayon; 2% Spandex', 2000000, 1599000, '2023-11-12', 'Việt nam', 'Áo Blazer nam phom Regular fit suông nhẹ, thoải mái, phù hợp với mọi dáng người.', 'Hiệu ứng kẻ caro thời thượng, đường cắt may tỉ mỉ, thiết kế lịch lãm với 2 khuy cài và 4 khuy tay áo, mix&match cùng áo sơ mi hay áo t-shirt cũng đều tôn lên vẻ lịch thiệp, sang trọng đầy nam tính của quý ông thành đạt.', 'https://aristino.com/Data/ResizeImage/images/product/ao-blazer/abz00201/ao-blazer-nam-aristino-ABZ00201-07x900x900x4.webp', 'Mới', 10, '2023-11-12', 1),
(22, 9, 3, 'Đầm công sở nữ dáng xòe xếp ly', '100% Cotton', 560000, 499000, '2023-11-08', 'Việt nam', 'Đầm công sở nữ \"Elegance in Motion\" là một biểu tượng của sự thanh lịch và sự thuận lợi trong thế giới làm việc. Với dáng xòe xếp ly tinh tế, chiếc đầm này không chỉ tạo nên vẻ ngoại hình nữ tính mà còn mang lại sự thoải mái và linh hoạt cho người mặc.', 'Để hoàn thiện phong cách, bạn có thể kết hợp chiếc đầm này với một chiếc blazer và một đôi giày cao gót để tạo nên vẻ ngoại hình đầy sức quyến rũ và chuyên nghiệp.Chiếc đầm công sở nữ dáng xòe xếp ly \"Elegance in Motion\" là sự lựa chọn hoàn hảo cho phụ nữ muốn kết hợp giữa vẻ đẹp thanh lịch và sự thoải mái trong môi trường công việc.\r\n\r\n\r\n\r\n\r\n\r\n', 'https://cdn.kkfashion.vn/26770-large_default/dam-cong-so-nu-dang-xoe-xep-ly-kk165-12.jpg', 'Mới', 20, '2023-12-08', 1),
(23, 9, 3, 'Đầm xòe hoa tay cánh tiên', '100% Cotton', 490000, 399000, '2023-11-05', 'Việt nam', 'Chiếc đầm xòe hoa tay cánh tiên \"Enchanted Blossom\" là sự kết hợp tuyệt vời giữa sự tinh tế và vẻ đẹp tự nhiên. Thiết kế này không chỉ mang lại vẻ quyến rũ mà còn là biểu tượng của sự dịu dàng và thanh thoát.', 'Chiếc đầm xòe hoa tay cánh tiên \"Enchanted Blossom\" là lựa chọn hoàn hảo cho các sự kiện dạ hội, dự tiệc hoặc những buổi gặp gỡ quan trọng. Kết hợp với đôi giày cao gót và một chiếc clutch nhỏ để tạo nên vẻ đẹp đầy quyến rũ và phong cách. Đầm xòe hoa tay cánh tiên \"Enchanted Blossom\" không chỉ là một bản thiết kế mà còn là câu chuyện của sự nữ tính và mộng mơ, hứa hẹn làm nổi bật vẻ đẹp độc đáo của bạn.', 'https://cdn.kkfashion.vn/26820-large_default/dam-xoe-hoa-tay-canh-tien-kk164-12.jpg', 'Mới', 20, '2023-11-30', 1),
(24, 9, 3, 'Đầm công sở dáng xòe cổ đan', '100% Silk(Lụa)', 490000, 400000, '2023-11-01', 'Việt nam', 'Chiếc đầm công sở dáng xòe cổ đan \"Sophisticated Elegance\" là sự hòa quyện giữa vẻ đẹp thanh lịch và sự thoải mái, mang lại cho phái đẹp sự tự tin và phong cách tại nơi làm việc. Thiết kế này không chỉ là một chiếc đầm, mà là biểu tượng của sự tinh tế và đẳng cấp.', 'Chiếc đầm công sở dáng xòe cổ đan \"Sophisticated Elegance\" là sự lựa chọn hoàn hảo cho các buổi làm việc chính thức, họp nhóm hay các sự kiện công việc. Kết hợp với một chiếc blazer và một đôi giày cao gót để tạo nên vẻ đẹp đầy chuyên nghiệp và quyến rũ. Đầm công sở dáng xòe cổ đan \"Sophisticated Elegance\" không chỉ là một sản phẩm thời trang, mà là biểu tượng của sự tinh tế và sự đẳng cấp trong thế giới công sở.', 'https://cdn.kkfashion.vn/26777-large_default/dam-cong-so-dang-xoe-co-dan-tong-mau-xanh-kk165-22.jpg', 'Mới', 15, '2023-10-04', 1),
(25, 10, 2, 'Quần âu Màu xanh navy', '100% Cotton', 500000, 450000, '2023-11-01', 'Việt nam', 'Chiếc quần âu màu xanh navy \"Timeless Elegance\" là sự kết hợp hoàn hảo giữa phong cách hiện đại và sự lịch lãm. Thiết kế này không chỉ là lựa chọn đa dạng cho mọi dịp, mà còn là biểu tượng của sự tinh tế và đẳng cấp trong thế giới thời trang nam giới.', 'Màu Xanh Navy Trang Nhã: Màu xanh navy là sự kết hợp tinh tế giữa sự đen và xanh, tạo nên vẻ trang nhã và dễ dàng phối hợp với nhiều loại áo và giày khác nhau. Dáng Ôm Vừa Vặn: Quần âu được thiết kế với dáng ôm vừa vặn, giúp tạo nên hình dáng chuyên nghiệp và tôn lên đường cong tự nhiên của người mặc.', 'https://file.hstatic.net/200000564155/file/ld013_3b4f434b40f54ae2a85e86c5d891e657_grande.jpg', 'Mới', 20, '2023-11-12', 1),
(26, 10, 2, 'Quần âu công sở kẻ caro', '100% Cotton', 499000, 450000, '2017-11-30', 'Việt nam', 'Chiếc quần âu công sở kẻ caro \"Modern Classic\" là sự kết hợp tinh tế giữa phong cách hiện đại và sự truyền thống, tạo nên sự sang trọng và chuyên nghiệp trong bộ sưu tập thời trang công sở của bạn.', 'Chiếc quần âu công sở kẻ caro \"Modern Classic\" là lựa chọn hoàn hảo cho những buổi làm việc chính thức hay các sự kiện quan trọng. Kết hợp với áo sơ mi hoặc áo polo và giày da để tạo nên vẻ đẹp chuyên nghiệp và thời trang. Quần âu công sở kẻ caro \"Modern Classic\" không chỉ là một chiếc quần, mà là biểu tượng của sự tinh tế và sự đẳng cấp trong thế giới thời trang công sở.', 'https://file.hstatic.net/200000564155/file/ld022_02736bedd1d2433493d60bc2c6245beb_grande.jpg', 'Mới', 20, '2023-11-10', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_thongbao`
--

CREATE TABLE `tbl_thongbao` (
  `thongBaoID` int(11) NOT NULL,
  `tenThongBao` varchar(255) NOT NULL,
  `noiDungThongBao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_thongbao`
--

INSERT INTO `tbl_thongbao` (`thongBaoID`, `tenThongBao`, `noiDungThongBao`) VALUES
(9, 'Black Friday 2023', 'Đợt giảm giá sâu cuối cùng trong năm bắt đầu từ thứ 6 của tuần cuối cùng tháng 11');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_bosuutap`
--
ALTER TABLE `tbl_bosuutap`
  ADD PRIMARY KEY (`boSuuTapID`);

--
-- Chỉ mục cho bảng `tbl_danhmucsanpham`
--
ALTER TABLE `tbl_danhmucsanpham`
  ADD PRIMARY KEY (`danhMucSanPhamID`);

--
-- Chỉ mục cho bảng `tbl_dondathang`
--
ALTER TABLE `tbl_dondathang`
  ADD PRIMARY KEY (`donDatHangID`),
  ADD KEY `nguoiDungID` (`nguoiDungID`);

--
-- Chỉ mục cho bảng `tbl_dondathangchitiet`
--
ALTER TABLE `tbl_dondathangchitiet`
  ADD PRIMARY KEY (`donDatHangChiTietID`);

--
-- Chỉ mục cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD PRIMARY KEY (`hoaDonID`),
  ADD KEY `nguoiDungID` (`nguoiDungID`);

--
-- Chỉ mục cho bảng `tbl_hoadonchitiet`
--
ALTER TABLE `tbl_hoadonchitiet`
  ADD PRIMARY KEY (`hoaDonChiTietID`),
  ADD KEY `hoaDonID` (`hoaDonID`),
  ADD KEY `sanPhamID` (`sanPhamID`);

--
-- Chỉ mục cho bảng `tbl_kichco`
--
ALTER TABLE `tbl_kichco`
  ADD PRIMARY KEY (`kichCoID`),
  ADD KEY `sanPhamID` (`sanPhamID`);

--
-- Chỉ mục cho bảng `tbl_magiamgia`
--
ALTER TABLE `tbl_magiamgia`
  ADD PRIMARY KEY (`maGiamGiaID`);

--
-- Chỉ mục cho bảng `tbl_mausac`
--
ALTER TABLE `tbl_mausac`
  ADD PRIMARY KEY (`mauSacID`),
  ADD KEY `sanPhamID` (`sanPhamID`);

--
-- Chỉ mục cho bảng `tbl_nguoidung`
--
ALTER TABLE `tbl_nguoidung`
  ADD PRIMARY KEY (`nguoiDungID`);

--
-- Chỉ mục cho bảng `tbl_sanpham`
--
ALTER TABLE `tbl_sanpham`
  ADD PRIMARY KEY (`sanPhamID`),
  ADD KEY `boSuuTapID` (`boSuuTapID`),
  ADD KEY `danhMucID` (`danhMucID`),
  ADD KEY `donDatHangChiTietID` (`donDatHangChiTietID`);

--
-- Chỉ mục cho bảng `tbl_thongbao`
--
ALTER TABLE `tbl_thongbao`
  ADD PRIMARY KEY (`thongBaoID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_bosuutap`
--
ALTER TABLE `tbl_bosuutap`
  MODIFY `boSuuTapID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tbl_danhmucsanpham`
--
ALTER TABLE `tbl_danhmucsanpham`
  MODIFY `danhMucSanPhamID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `tbl_dondathang`
--
ALTER TABLE `tbl_dondathang`
  MODIFY `donDatHangID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `tbl_dondathangchitiet`
--
ALTER TABLE `tbl_dondathangchitiet`
  MODIFY `donDatHangChiTietID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  MODIFY `hoaDonID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tbl_hoadonchitiet`
--
ALTER TABLE `tbl_hoadonchitiet`
  MODIFY `hoaDonChiTietID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbl_kichco`
--
ALTER TABLE `tbl_kichco`
  MODIFY `kichCoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tbl_magiamgia`
--
ALTER TABLE `tbl_magiamgia`
  MODIFY `maGiamGiaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tbl_mausac`
--
ALTER TABLE `tbl_mausac`
  MODIFY `mauSacID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT cho bảng `tbl_nguoidung`
--
ALTER TABLE `tbl_nguoidung`
  MODIFY `nguoiDungID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbl_sanpham`
--
ALTER TABLE `tbl_sanpham`
  MODIFY `sanPhamID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `tbl_thongbao`
--
ALTER TABLE `tbl_thongbao`
  MODIFY `thongBaoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbl_dondathang`
--
ALTER TABLE `tbl_dondathang`
  ADD CONSTRAINT `tbl_dondathang_ibfk_1` FOREIGN KEY (`nguoiDungID`) REFERENCES `tbl_sanpham` (`sanPhamID`),
  ADD CONSTRAINT `tbl_dondathang_ibfk_2` FOREIGN KEY (`maGiamGiaID`) REFERENCES `tbl_magiamgia` (`maGiamGiaID`);

--
-- Các ràng buộc cho bảng `tbl_dondathangchitiet`
--
ALTER TABLE `tbl_dondathangchitiet`
  ADD CONSTRAINT `tbl_dondathangchitiet_ibfk_1` FOREIGN KEY (`donDatHangID`) REFERENCES `tbl_dondathang` (`donDatHangID`),
  ADD CONSTRAINT `tbl_dondathangchitiet_ibfk_2` FOREIGN KEY (`hoaDonID`) REFERENCES `tbl_hoadon` (`hoaDonID`),
  ADD CONSTRAINT `tbl_dondathangchitiet_ibfk_3` FOREIGN KEY (`sanPhamID`) REFERENCES `tbl_sanpham` (`sanPhamID`);

--
-- Các ràng buộc cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD CONSTRAINT `tbl_hoadon_ibfk_1` FOREIGN KEY (`nguoiDungID`) REFERENCES `tbl_nguoidung` (`nguoiDungID`);

--
-- Các ràng buộc cho bảng `tbl_hoadonchitiet`
--
ALTER TABLE `tbl_hoadonchitiet`
  ADD CONSTRAINT `tbl_hoadonchitiet_ibfk_1` FOREIGN KEY (`hoaDonID`) REFERENCES `tbl_hoadon` (`hoaDonID`),
  ADD CONSTRAINT `tbl_hoadonchitiet_ibfk_2` FOREIGN KEY (`sanPhamID`) REFERENCES `tbl_sanpham` (`sanPhamID`);

--
-- Các ràng buộc cho bảng `tbl_kichco`
--
ALTER TABLE `tbl_kichco`
  ADD CONSTRAINT `tbl_kichco_ibfk_1` FOREIGN KEY (`sanPhamID`) REFERENCES `tbl_sanpham` (`sanPhamID`);

--
-- Các ràng buộc cho bảng `tbl_mausac`
--
ALTER TABLE `tbl_mausac`
  ADD CONSTRAINT `tbl_mausac_ibfk_1` FOREIGN KEY (`sanPhamID`) REFERENCES `tbl_sanpham` (`sanPhamID`);

--
-- Các ràng buộc cho bảng `tbl_sanpham`
--
ALTER TABLE `tbl_sanpham`
  ADD CONSTRAINT `tbl_sanpham_ibfk_1` FOREIGN KEY (`boSuuTapID`) REFERENCES `tbl_bosuutap` (`boSuuTapID`),
  ADD CONSTRAINT `tbl_sanpham_ibfk_2` FOREIGN KEY (`danhMucID`) REFERENCES `tbl_danhmucsanpham` (`danhMucSanPhamID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
