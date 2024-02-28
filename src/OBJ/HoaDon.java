/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJ;

/**
 *
 * @author HP
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String maSP;
    private String maKH;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    private String ngayBan;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String maSP, String maKH, int soLuong, double donGia, double thanhTien, String ngayBan) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maSP = maSP;
        this.maKH = maKH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.ngayBan = ngayBan;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public Object getDonViTinh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getTenSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
