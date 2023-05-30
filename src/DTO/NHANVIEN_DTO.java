/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author caoth
 */
public class NHANVIEN_DTO {
    String MANHANVIEN, MACHUCVU,TENNHANVIEN, GIOITINH, DIACHI, SDT, TAIKHOAN, MATKHAU;

    public String getMANHANVIEN() {
        return MANHANVIEN;
    }

    public void setMANHANVIEN(String MANHANVIEN) {
        this.MANHANVIEN = MANHANVIEN;
    }

    public String getMACHUCVU() {
        return MACHUCVU;
    }

    public void setMACHUCVU(String MACHUCVU) {
        this.MACHUCVU = MACHUCVU;
    }

    public String getTENNHANVIEN() {
        return TENNHANVIEN;
    }

    public void setTENNHANVIEN(String TENNHANVIEN) {
        this.TENNHANVIEN = TENNHANVIEN;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public NHANVIEN_DTO(String MANHANVIEN, String MACHUCVU, String TENNHANVIEN, String GIOITINH, String DIACHI, String SDT, String TAIKHOAN, String MATKHAU) {
        this.MANHANVIEN = MANHANVIEN;
        this.MACHUCVU = MACHUCVU;
        this.TENNHANVIEN = TENNHANVIEN;
        this.GIOITINH = GIOITINH;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
        this.TAIKHOAN = TAIKHOAN;
        this.MATKHAU = MATKHAU;
    }
    
}
