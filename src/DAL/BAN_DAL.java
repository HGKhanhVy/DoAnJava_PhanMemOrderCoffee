/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BAN_DTO;
import java.util.*;
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
public class BAN_DAL {

    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    ArrayList<BAN_DTO> lstBan;

    public ArrayList<BAN_DTO> ShowThongTinBan() {
        try {
            lstBan = new ArrayList<BAN_DTO>();
            String query = "select * from BAN";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                lstBan.add(new BAN_DTO(rs.getString("MABAN"), rs.getString("TENBAN"), rs.getString("TRANGTHAI")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BAN_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstBan;
    }

    public int CapNhatTrangThai(String MaBan, String TrangThai) {
        String query = "update BAN set TRANGTHAI ='" + TrangThai + "' where MABAN='" + MaBan + "'";
        int kt = con.executeUpdate(query);
        return con.executeUpdate(query);
    }

    public String GetTrangThaiBan(String maBan) {
        try {
            String query = "select * from BAN where MABAN ='" + maBan + "'";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String TT = rs.getString("TRANGTHAI");
                String tenban = rs.getString("TENBAN");
                return TT;
            }
            return rs.getString("TRANGTHAI");
        } catch (SQLException ex) {
            Logger.getLogger(BAN_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int SetDatBan(String maBan) {
        String query = "update BAN set TRANGTHAI ='datcho' where MABAN = '"+maBan+"'";
        return con.executeUpdate(query);
    }
}
