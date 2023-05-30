/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.*;
import DAL.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CT_HOADON_BLL {

    String[] title = {"Mã nước", "Tên Nước", "Số lượng", "Đơn Giá", "Thành Tiền"};
    CT_HOADON_DAL ctHoadon_DAL = new CT_HOADON_DAL();

    public String[] showTitleTable() {
        return title;
    }

    public ArrayList<CT_HOADON_DTO> ShowCTHoaDon(String MABAN) {
        return ctHoadon_DAL.showChiTietHoaDon(MABAN);
    }

    public int DeleteCT_HD(String maHoaDon) {
        return ctHoadon_DAL.DeleteCT_HD(maHoaDon);
    }

    public int InsertCT_HD(CT_HOADON_DTO ct) {
        return ctHoadon_DAL.InsertCT_HD(ct);
    }

    public int UpdateSoLuong(int SL, String maHD, String MaNuoc) {
        return ctHoadon_DAL.UpdateSoLuong(SL, maHD, MaNuoc);
    }

    public int Delete_Items_CTHD(String MaHD, String MaNuoc) {
        return ctHoadon_DAL.Delete_Items_CTHD(MaHD, MaNuoc);
    }
}
