/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Connect.Connect_DB;
import DTO.NhaCungCap_DTO;
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
public class NHACUNGCAP_DAL {
    
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    
    ArrayList<NhaCungCap_DTO> lstAllDS;
    

    public ArrayList<NhaCungCap_DTO> getALL() {
        try {
            lstAllDS = new ArrayList<NhaCungCap_DTO>();
            String query = "select * from NHACUNGCAP";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                
                NhaCungCap_DTO ncc = new NhaCungCap_DTO(rs.getString("MANHACUNGCAP"), rs.getString("TENNHACUNGCAP"), rs.getString("DIACHI"), rs.getString("SDT"));
                lstAllDS.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NHACUNGCAP_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllDS;
    }
    
/*
    INSERT INTO NHACUNGCAP(MANHACUNGCAP,TENNHACUNGCAP,DIACHI,SDT)
    VALUES ('NCC01',N' 90S Coffee',N'Quận 12','0123456889')
*/
    public int insertNCC(NhaCungCap_DTO ncc) {
        String query = "INSERT INTO NHACUNGCAP(MANHACUNGCAP,TENNHACUNGCAP,DIACHI,SDT)\n"
                + "values ('" + ncc.getMANHACUNGCAP()+ "',N'" + ncc.getTENNHACUNGCAP()+ "',N'" + ncc.getDIACHI()+"','" +ncc.getSDT() + "')";
        return con.executeUpdate(query);
    }
    public int delete(String ma) {
        String query = "delete NHACUNGCAP where MANHACUNGCAP='" + ma + "'";
        return con.executeUpdate(query);
    }
   
    public boolean KT_TonTai_NCC(String MaNCC) {
        for (NhaCungCap_DTO item : lstAllDS) {
            if (item.getMANHACUNGCAP().equals(MaNCC) == true) {
                return true;
            }
        }
        return false;
    }

    public int Update(NhaCungCap_DTO ncc) {
        
        String ma, ten, diachi, sdt;
        ma=ncc.getMANHACUNGCAP();
        ten=ncc.getTENNHACUNGCAP();
        diachi=ncc.getDIACHI();
        sdt=ncc.getSDT(); 

        // update NHACUNGCAP SET DIACHI=N'Cái Bè' where MANHACUNGCAP='NCC07'
        if (KT_TonTai_NCC(ncc.getMANHACUNGCAP()) == true) {
            //thực hiện update
            String query = "update NHACUNGCAP SET MANHACUNGCAP='"+ma+"' ,TENNHACUNGCAP= N'"+ten+"' ,DIACHI= N'"+diachi+"' ,SDT='" + sdt  +"' where MANHACUNGCAP='" + ma + "'";
            return con.executeUpdate(query);
           
        } else {
            //thông báo không tồn tại mã cần cập nhật
             JFrame frame = new JFrame();
            if(JOptionPane.showConfirmDialog(frame, "Mã không tồn tại","Thông báo",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) System.exit(0);
        }

        return 1;
    }
    
}
