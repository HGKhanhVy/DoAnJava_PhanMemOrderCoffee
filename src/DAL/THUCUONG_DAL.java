/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.*;
import java.util.ArrayList;
import Connect.Connect_DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class THUCUONG_DAL {

    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    ArrayList<THUCUONG_DTO> lstThucUong;
    ArrayList<THUCUONG_DTO> lstAllThucUong;

    public ArrayList<THUCUONG_DTO> showListNuocUongByMaLoai(String maLoai) {
        try {
            lstThucUong = new ArrayList<THUCUONG_DTO>();
            String query = "select * from THUCUONG where MALOAI='" + maLoai + "'";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                lstThucUong.add(new THUCUONG_DTO(rs.getString("MANUOC"), rs.getString("MALOAI"), rs.getString("TENNUOC"), rs.getString("SIZE"), rs.getString("TRANGTHAI"), Float.valueOf(rs.getShort("GIA"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(THUCUONG_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstThucUong;
    }

    public ArrayList<THUCUONG_DTO> getALL() {
        try {
            lstAllThucUong = new ArrayList<THUCUONG_DTO>();
            String query = "select * from THUCUONG ";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                //String _MANUOC, String _MALOAI, String _TENNUOC, String _SIZE, String _TRANGTHAI, float _GIA
                THUCUONG_DTO thucuong = new THUCUONG_DTO(rs.getString("MANUOC"), rs.getString("MALOAI"), rs.getString("TENNUOC"), rs.getString("SIZE"), rs.getString("TRANGTHAI"), Float.valueOf(rs.getString("GIA")));
                lstAllThucUong.add(thucuong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(THUCUONG_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllThucUong;
    }
}
