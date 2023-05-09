/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.*;
import Connect.Connect_DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CT_HOADON_DAL {

    ArrayList<CT_HOADON_DTO> lstCT_HD;
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();

    public ArrayList<CT_HOADON_DTO> showChiTietHoaDon(String maban) {
        try {
            lstCT_HD = new ArrayList<CT_HOADON_DTO>();
            String query = "select * from HOADON,CT_HOADON where HOADON.MAHOADON = CT_HOADON.MAHOADON and MABAN='" + maban + "' and TRANGTHAI='CHUA THANH TOAN'";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                //String _MANUOC, String _MAHOADON, String , int , float , float _THANHTIEN
                String manuoc = rs.getString("MANUOC");
                String tenNuoc = rs.getString("TENNUOC");
                lstCT_HD.add(new CT_HOADON_DTO(rs.getString("MANUOC"), rs.getString("MAHOADON"), rs.getString("TENNUOC"), Integer.valueOf(rs.getShort("SL")), Float.valueOf(rs.getString("DONGIA")), Float.valueOf(rs.getString("THANHTIEN"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CT_HOADON_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCT_HD;
    }

    public int DeleteCT_HD(String maHoaDon) {
        String query = "delete CT_HOADON where MAHOADON ='HD001'";
        return con.executeUpdate(query);
    }

    public int InsertCT_HD(CT_HOADON_DTO ct) {
        String query = "INSERT INTO CT_HOADON(MANUOC,MAHOADON,TENNUOC,SL,DONGIA) VALUES ('" + ct.getMANUOC() + "','" + ct.getMAHOADON() + "',N'" + ct.getTENNUOC() + "'," + ct.getSL() + "," + ct.getDONGIA() + ")";
        int kq = con.executeUpdate(query);
        return kq;
    }

    public int UpdateSoLuong(int SL, String maHD, String MaNuoc) {
        String query = "update CT_HOADON set SL=" + SL + " where MAHOADON='" + maHD + "' and MANUOC='" + MaNuoc + "'";
        return con.executeUpdate(query);
    }
    public int Delete_Items_CTHD(String MaHD, String MaNuoc){
        String query="delete CT_HOADON where MAHOADON='"+MaHD+"' and MANUOC='"+MaNuoc+"'";
        int kt = con.executeUpdate(query);
        return kt;
    }
}
