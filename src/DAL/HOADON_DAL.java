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
 * c
 *
 * @author DELL
 */
public class HOADON_DAL {

    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    private ArrayList<HOADON_DTO> listHD = new ArrayList<>();
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
        String query = "set dateformat dmy update HOADON set TRANGTHAI ='DA THANH TOAN',GIORA ='"+giora+"' where MAHOADON = '" + MaHoaDon + "'";
        int kt = con.executeUpdate(query);
        return kt;
    }
    public int ChuyenBan(String MaBan, String TenBan, String MaHoaDon){
        String query="update HOADON set TENHOADON ='"+TenBan+"', MABAN ='"+MaBan+"' where MAHOADON ='"+MaHoaDon+"'";
        int kt = con.executeUpdate(query);
        return kt;
    }
    
    public static ArrayList<HOADON_DTO> getDSHDTheoNgayThang(String ngay, String ngayDen)
    {
        ArrayList<HOADON_DTO> dsHD = new ArrayList<HOADON_DTO>();
        try{
            String sql="Select * From HOADON Where NGAYXUAT >= '"+ngay+"' And NGAYXUAT <= '"+ngayDen+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next())
            {
                HOADON_DTO hd = new HOADON_DTO(rs.getString("MAHOADON").trim(), rs.getString("MANHANVIEN").trim(), rs.getString("NGAYXUAT").trim() , rs.getString("TRANGTHAI").trim(),rs.getString("MABAN").trim());
                dsHD.add(hd);
            }            
        }catch(Exception e)
        {
           dsHD.clear();
           return dsHD;
        }
        return  dsHD;
    }
    public String[] listTitleHD() {
        String[] arr = {"Mã hóa đơn", "Mã nhân viên", "Ngày xuất", "Trạng thái", "Mã bàn", "Tổng tiền"};
        return arr;
    }
    public float GetTongTien(String maHD)
    {
        float tt = 0;
        try {
            String sql ="Select TONGTIEN from HOADON where MAHOADON='"+maHD+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                tt = rs.getFloat("TONGTIEN");
            }
            cn.close();
        } catch (Exception e) 
        {
            tt = 0;
            return tt;
        }
        return tt;
    }
    public int GetTongSoHD(String ngay, String ngayDen)
    {
        int tt = 0;
        try {
            String sql ="Select COUNT(*) AS SOLUONG from HOADON Where NGAYXUAT >= '"+ngay+"' And NGAYXUAT <= '"+ngayDen+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                tt = rs.getInt("SOLUONG");
            }
            cn.close();
        } catch (Exception e) 
        {
            tt = 0;
            return tt;
        }
        return tt;
    }
}
