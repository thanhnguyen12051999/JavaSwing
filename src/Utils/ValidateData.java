/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import OBJ.NhanVien;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ValidateData {
    public static String md5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean check_email(String email){
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[_A-Za-z]{2,}$)";
        boolean KTEmail = email.matches(dinhDangEmail);
        return KTEmail;
    }
    
    public boolean check_sdt(String sdt){
        try {
            if (sdt.length() >= 10 && sdt.length() <= 11) {
                //ép sđt về kiểu int, nếu sđt chỉ chứa số  --> trả về false
                //nếu sđt chứa kís tự khác số --> ngoại lệ--> trả về true
                Integer.parseInt(sdt);
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            return true;
        }
    }
    
    public boolean check_ten(String hoTen){
        for (int i = 0; i < hoTen.length(); i++) {
            //ký tự ASCII 48->57 tương tự từ 0->9
            //duyệt lần lượt các phần tử trong chuỗi họ tên nếu phần tử ở vị trí i tồn tại giá trị nằm trong khoảng 48->57 
            //thì chuỗi này chứa số trả về true.
            if (hoTen.charAt(i) > 47 && hoTen.charAt(i) < 58) {
                return true;
            }
        }
        return false;
    }
}
