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
public class SanPham {
    private String MaSanPham;
    private String TenSanPham;
    private String DonViTinh;
    private String TenNSX;
    private String GiaNhap;
    private String GiaBan;
    private int SoLuong;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String TenSanPham, String DonViTinh, String TenNSX, String GiaNhap, String GiaBan, int SoLuong) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.DonViTinh = DonViTinh;
        this.TenNSX = TenNSX;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
