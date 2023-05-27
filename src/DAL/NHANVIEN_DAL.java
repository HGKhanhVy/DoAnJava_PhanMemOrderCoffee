/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Connect.Connect_DB;
import DTO.NHANVIEN_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caoth
 */
public class NHANVIEN_DAL {
    
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    
    ArrayList<NHANVIEN_DTO> lstAllDS;
    

    public ArrayList<NHANVIEN_DTO> getALL() {
        try {
            lstAllDS = new ArrayList<NHANVIEN_DTO>();
            String query = "select * from NHANVIEN";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                //MANHANVIEN, MACHUCVU,TENNHANVIEN, GIOITINH, DIACHI, SDT, TAIKHOAN, MATKHAU;
                NHANVIEN_DTO nv = new NHANVIEN_DTO(rs.getString("MANHANVIEN"), rs.getString("MACHUCVU"), rs.getString("TENNHANVIEN"), rs.getString("GIOITINH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("TAIKHOAN"), rs.getString("MATKHAU"));
                lstAllDS.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NHANVIEN_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllDS;
    }
    
    
}
