/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Connect.Connect_DB;
import DTO.NguyenLieu_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author caoth
 */
public class NGUYENLIEU_DAL {
    
    
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    
    ArrayList<NguyenLieu_DTO> lstAllDS;
    

    public ArrayList<NguyenLieu_DTO> getALL() {
        try {
            lstAllDS = new ArrayList<NguyenLieu_DTO>();
            String query = "select * from NGUYENLIEU";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                
                NguyenLieu_DTO nl = new NguyenLieu_DTO(rs.getString("MANGUYENLIEU"), rs.getString("TENNGUYENLIEU"), rs.getString("SOLUONG"), rs.getString("TONKHO"), rs.getString("DVT"));
                lstAllDS.add(nl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NHACUNGCAP_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllDS;
    }
    /*
    INSERT INTO NGUYENLIEU(MANGUYENLIEU, TENNGUYENLIEU,SOLUONG,TONKHO,DVT)
    VALUES('NL001',N'Cafe nguyên chất', 100, 17, N'kg')
    
    */
    public int insertNCC(NguyenLieu_DTO nl) {
        String query = "INSERT INTO NGUYENLIEU(MANGUYENLIEU, TENNGUYENLIEU,SOLUONG,TONKHO,DVT)\n"
                + "values ('" + nl.getMANGUYENLIEU()+ "', N'" + nl.getTENNGUYENLIEU()+ "', " + nl.getSOLUONG()+", " +nl.getTONKHO()+ ", N'"+nl.getDVT()+"')";
        return con.executeUpdate(query);
    }
    public int delete(String ma) {
        String query = "delete NGUYENLIEU where MANGUYENLIEU='" + ma + "'";
        return con.executeUpdate(query);
    }
   
    public boolean KT_TonTai_NL(String MaNL) {
        for (NguyenLieu_DTO item : lstAllDS) {
            if (item.getMANGUYENLIEU().equals(MaNL) == true) {
                return true;
            }
        }
        return false;
    }

    public int Update(NguyenLieu_DTO nl) {
        
        String ma, ten, sl, dvt, tonkho;
        ma=nl.getMANGUYENLIEU();
        ten=nl.getTENNGUYENLIEU();
        sl=nl.getSOLUONG();
        tonkho=nl.getTONKHO();
        dvt=nl.getDVT();

        // 
        if (KT_TonTai_NL(nl.getMANGUYENLIEU()) == true) {
            //thực hiện update
            String query = "update NGUYENLIEU SET MANGUYENLIEU='"+ma+"' ,TENNGUYENLIEU= N'"+ten+"' ,SOLUONG= N'"+sl+"' ,TONKHO='" + tonkho +"' ,DVT='"+dvt +"' where MANGUYENLIEU='" + ma + "'";
            return con.executeUpdate(query);
           
        } else {
            //thông báo không tồn tại mã cần cập nhật
             JFrame frame = new JFrame();
            if(JOptionPane.showConfirmDialog(frame, "Mã không tồn tại","Thông báo",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) System.exit(0);
        }

        return 1;
    }
}
