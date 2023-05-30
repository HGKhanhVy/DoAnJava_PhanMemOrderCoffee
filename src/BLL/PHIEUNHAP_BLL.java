/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PHIEUNHAP_DAL;
import DTO.PHIEUNHAP_DTO;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author caoth select p.MAPHIEUNHAP, TENPHIEUNHAP,NGAYNHAP, MANHANVIEN,
 * MANHACUNGCAP , MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, DVT, GIA, THANHTIEN,
 * TONGTIEN
 *
 */
public class PHIEUNHAP_BLL {

    PHIEUNHAP_DAL pn = new PHIEUNHAP_DAL();

    String[] title = {"MAPHIEUNHAP", "TENPHIEUNHAP", "NGAYNHAP", "MANHANVIEN", "MANHACUNGCAP", "MANGUYENLIEU", "TENNGUYENLIEU", "SOLUONG", "DVT", "GIA", "THANHTIEN"};

    public String[] showTitle() {
        return title;
    }

    public ArrayList<PHIEUNHAP_DTO> getALL() {
        return pn.getALL();
    }

    public String insert_PN(PHIEUNHAP_DTO n) {
        int kt = pn.insertPN(n);
        if (kt == 1) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    public int delete_PN(String ma, String maNL) {
        return pn.delete(ma, maNL);
    }

    public String Update_PN(PHIEUNHAP_DTO n) {
        int kt = pn.Update(n);
        if (kt == 1) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    public ResultSet XuatPN(String mapn) {
        return pn.XuatPN(mapn);
    }

}
