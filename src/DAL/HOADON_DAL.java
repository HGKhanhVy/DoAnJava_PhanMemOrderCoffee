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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * c
 *
 * @author DELL
 */
public class HOADON_DAL {

    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();

    public int ThemHoaDon(HOADON_DTO HD) {
        String query = "set dateformat dmy insert into HOADON(MAHOADON,MANHANVIEN,TENHOADON,NGAYXUAT,TRANGTHAI,MABAN,GIOVAO) values('" + HD.getMAHOADON() + "','" + HD.getMANHANVIEN() + "','" + HD.getTENHOADON() + "','" + HD.getNGAYXUAT() + "','" + HD.getTRANGTHAI() + "','" + HD.getMABAN() + "','" + HD.getGIOVAO() + "')";
        return con.executeUpdate(query);
    }

    public String getMaHoaDonByBan(String MaBan) {
        String maBan = "";
        try {
            String query = "select MAHOADON from HOADON where MABAN='" + MaBan + "' and TRANGTHAI='CHUA THANH TOAN'";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                maBan = rs.getString("MAHOADON");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOADON_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maBan;
    }

    public int ThanhToanHoaDon(String MaHoaDon, String giora) {
        String query = "update HOADON set TRANGTHAI ='DA THANH TOAN',GIORA ='"+giora+"' where MAHOADON = '" + MaHoaDon + "'";
        int kt = con.executeUpdate(query);
        return kt;
    }
    public int ChuyenBan(String MaBan, String TenBan, String MaHoaDon){
        String query="update HOADON set TENHOADON ='"+TenBan+"', MABAN ='"+MaBan+"' where MAHOADON ='"+MaHoaDon+"'";
        int kt = con.executeUpdate(query);
        return kt;
    }
}
