/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.LOAITHUCUONG_DTO;
import java.awt.List;
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
public class LOAITHUCUONG_DAL {
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    ArrayList<LOAITHUCUONG_DTO> lstLoaiThucUong;
    public ArrayList<LOAITHUCUONG_DTO> showList_LOAITHUCUONG (){
        try {
            String query ="select * from LOAITHUCUONG";
            ResultSet rs = con.executeQuery(query);
            lstLoaiThucUong = new ArrayList<LOAITHUCUONG_DTO>();
            while(rs.next()){
                lstLoaiThucUong.add(new LOAITHUCUONG_DTO(rs.getString("MALOAI"),rs.getString("TENLOAI")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LOAITHUCUONG_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstLoaiThucUong;
    }
    public String getMaLoaiThucUong(String tenThucUong){
        try {
            String query ="select * from LOAITHUCUONG where  TENLOAI ='"+tenThucUong+"'";
            ResultSet rs = con.executeQuery(query);
            while(rs.next()){
                return rs.getString("MALOAI");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LOAITHUCUONG_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
