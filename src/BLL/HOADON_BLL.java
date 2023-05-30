/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.*;
import DTO.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HOADON_BLL {

    HOADON_DAL hoadon_dal = new HOADON_DAL();

    public int ThemHoaDon(HOADON_DTO hd) {
        return hoadon_dal.ThemHoaDon(hd);
    }

    public String getMaHoaDonByBan(String MaBan) {
        return hoadon_dal.getMaHoaDonByBan(MaBan);
    }

    public int ThanhToanHoaDon(String MaHoaDon, String giora) {
        return hoadon_dal.ThanhToanHoaDon(MaHoaDon, giora);
    }
     public int ChuyenBan(String MaBan, String TenBan, String MaHoaDon){
       return hoadon_dal.ChuyenBan(MaBan, TenBan, MaHoaDon);
    }
    public String[] listTitleHD(){
        return hoadon_dal.listTitleHD();
    }
    public ArrayList<HOADON_DTO> getDSHDTheoNgayThang(String ngay, String ngayDen){
        return hoadon_dal.getDSHDTheoNgayThang(ngay, ngayDen);
    }
    public float GetTongTien(String maHD) {
        return hoadon_dal.GetTongTien(maHD);
    }
    public int GetTongSoHD(String ngay, String ngayDen) {
        return hoadon_dal.GetTongSoHD(ngay, ngayDen);
    }
}
