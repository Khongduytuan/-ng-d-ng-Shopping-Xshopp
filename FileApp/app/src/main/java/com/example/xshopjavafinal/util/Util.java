package com.example.xshopjavafinal.util;

import java.text.DecimalFormat;

public class Util {

    // http://localhost/xshop/boSuuTap/
    // ha noi: 192.168.1.56
    // vinh phuc: 192.168.1.25
    public static String BASE = "http://192.168.1.56/xshop/";
    public static String DA_GIAO_THANH_CONG = "Giao thành công";
    public static String DANG_GIAO = "Đang giao";
    public static String DA_XAC_NHAN = "Đã xác nhận";
    public static String CHUA_XAC_NHAN = "Chưa xác nhận";


    public static String formatNumber(String input) {
        try {
            // Check if the input string contains a valid number
            if (isValidNumber(input)) {
                double number = Double.parseDouble(input);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
                return decimalFormat.format(number);
            } else {
                return "null";
            }
        } catch (NumberFormatException e) {
            return "null";
        }
    }

    private static boolean isValidNumber(String input) {
        // Regular expression to check if the input string is a number (integer or float)
        String numberRegex = "^[-+]?[0-9]*\\.?[0-9]+$";
        return input.matches(numberRegex);
    }
}
