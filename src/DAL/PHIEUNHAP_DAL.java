/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.PHIEUNHAP_DTO;
import Connect.Connect_DB;
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
public class PHIEUNHAP_DAL {

    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();

    ArrayList<PHIEUNHAP_DTO> lstAllDS;

    public ArrayList<PHIEUNHAP_DTO> getALL() {
        try {
            lstAllDS = new ArrayList<PHIEUNHAP_DTO>();

            String query = "select p.MAPHIEUNHAP, TENPHIEUNHAP,NGAYNHAP, MANHANVIEN, MANHACUNGCAP , MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, DVT, GIA, THANHTIEN, TONGTIEN\n" + "from PHIEUNHAP as p, CHITIET_PHIEUNHAP as ct\n" + "where p.MAPHIEUNHAP=ct.MAPHIEUNHAP";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {

                PHIEUNHAP_DTO phieu = new PHIEUNHAP_DTO(rs.getString("MAPHIEUNHAP"), rs.getString("TENPHIEUNHAP"), rs.getString("NGAYNHAP"), rs.getString("MANHANVIEN"), rs.getString("MANHACUNGCAP"), rs.getString("MANGUYENLIEU"), rs.getString("TENNGUYENLIEU"), rs.getString("SOLUONG"), rs.getString("DVT"), rs.getString("GIA"), rs.getString("THANHTIEN"), rs.getString("TONGTIEN"));
                lstAllDS.add(phieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PHIEUNHAP_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAllDS;
    }

    /*
    
--CHI TIET PHIEU NHAP
    
INSERT INTO CHITIET_PHIEUNHAP(MAPHIEUNHAP,MANGUYENLIEU,TENNGUYENLIEU,SOLUONG,DVT,THANHTIEN,GIA)
VALUES ('P04','NL013',N'Bột kem',40,N'kg', 120000, 3000)
    
--PHIEU NHAP
    
INSERT INTO PHIEUNHAP(MAPHIEUNHAP,TENPHIEUNHAP,MANHANVIEN,MANHACUNGCAP,NGAYNHAP ,TONGTIEN)
VALUES (N'P04',N'Nhập hàng tháng 04', 'NV01', 'NCC01', '04/04/2023', null)
    
     */
    public int insertPN(PHIEUNHAP_DTO pn) {
        
        if (KT_TonTai_NCC(pn.getMAPHIEUNHAP()) == true) {
            //thực hiện update
             String query = "INSERT INTO CHITIET_PHIEUNHAP(MAPHIEUNHAP,MANGUYENLIEU,TENNGUYENLIEU,SOLUONG,DVT,THANHTIEN,GIA)\n"
                + "VALUES ('" + pn.getMAPHIEUNHAP() + "','" + pn.getMANGUYENLIEU() + "',N'" + pn.getTENNGUYENLIEU() + "'," + pn.getSOLUONG() + ",N'" + pn.getDVT() + "', " + pn.getTHANHTIEN() + "," + pn.getGIA() + ")";
            return con.executeUpdate(query);
        } else {
            
            String query = "INSERT INTO CHITIET_PHIEUNHAP(MAPHIEUNHAP,MANGUYENLIEU,TENNGUYENLIEU,SOLUONG,DVT,THANHTIEN,GIA)\n"
                + "VALUES ('" + pn.getMAPHIEUNHAP() + "','" + pn.getMANGUYENLIEU() + "',N'" + pn.getTENNGUYENLIEU() + "'," + pn.getSOLUONG() + ",N'" + pn.getDVT() + "', " + pn.getTHANHTIEN() + "," + pn.getGIA() + ")\n"
                + "INSERT INTO PHIEUNHAP(MAPHIEUNHAP,TENPHIEUNHAP,MANHANVIEN,MANHACUNGCAP,NGAYNHAP ,TONGTIEN)\n"
                + "VALUES (N'" + pn.getMAPHIEUNHAP() + "',N'" + pn.getTENPHIEUNHAP() + "', '" + pn.getMANHANVIEN() + "', '" + pn.getMANHACUNGCAP() + "', '" + pn.getNGAYNHAP() + "', null)";
            return con.executeUpdate(query);
        }
        
    }

    public int delete(String ma, String maNL) {
        String query = "delete CHITIET_PHIEUNHAP where MAPHIEUNHAP='" + ma + "' and MANGUYENLIEU='" + maNL + "'\n";
               
        return con.executeUpdate(query);
    }

    public boolean KT_TonTai_NCC(String MaPN) {
        for (PHIEUNHAP_DTO item : lstAllDS) {
            if (item.getMAPHIEUNHAP().equals(MaPN) == true) {
                return true;
            }
        }
        return false;
    }

    public int Update(PHIEUNHAP_DTO pn) {

        String MAPHIEUNHAP, TENPHIEUNHAP, NGAYNHAP, MANHANVIEN, MANHACUNGCAP, MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, DVT, GIA, THANHTIEN, TONGTIEN;

        MAPHIEUNHAP = pn.getMAPHIEUNHAP();
        TENPHIEUNHAP = pn.getTENPHIEUNHAP();
        NGAYNHAP = pn.getNGAYNHAP();
        MANHANVIEN = pn.getMANHANVIEN();
        MANHACUNGCAP = pn.getMANHACUNGCAP();
        MANGUYENLIEU = pn.getMANGUYENLIEU();
        TENNGUYENLIEU = pn.getTENNGUYENLIEU();
        SOLUONG = pn.getSOLUONG();
        DVT = pn.getDVT();
        GIA = pn.getGIA();
        THANHTIEN = pn.getTHANHTIEN();
        TONGTIEN = pn.getTONGTIEN();

        if (KT_TonTai_NCC(MAPHIEUNHAP) == true) {
            //thực hiện update
            String sql = "update PHIEUNHAP SET MAPHIEUNHAP='" + MAPHIEUNHAP + "' ,TENPHIEUNHAP= N'" + TENPHIEUNHAP + "', MANHANVIEN='" + MANHANVIEN + "',MANHACUNGCAP='" + MANHACUNGCAP + "' ,NGAYNHAP='" + NGAYNHAP +"',TONGTIEN=" + TONGTIEN + " where MAPHIEUNHAP='" + MAPHIEUNHAP + "'\n" + "update CHITIET_PHIEUNHAP SET MAPHIEUNHAP='" + MAPHIEUNHAP + "', MANGUYENLIEU='" + MANGUYENLIEU + "',TENNGUYENLIEU= N'" + TENNGUYENLIEU + "',SOLUONG = " + SOLUONG + ", DVT= N'" + DVT + "',GIA= " + GIA + ",THANHTIEN= " + THANHTIEN + " where MAPHIEUNHAP='" + MAPHIEUNHAP + "' and MANGUYENLIEU='"+MANGUYENLIEU+"'\n";
            return con.executeUpdate(sql);

        } else {
            //thông báo không tồn tại mã cần cập nhật
            JFrame frame = new JFrame();
            if (JOptionPane.showConfirmDialog(frame, "Mã không tồn tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
        return 1;
    }
    
    public ResultSet XuatPN(String mapn)
    {
        //String query = "select MANHACUNGCAP, MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, DVT, GIA, THANHTIEN  from PHIEUNHAP AS pn, CHITIET_PHIEUNHAP AS ct\n" + "where pn.MAPHIEUNHAP = ct.MAPHIEUNHAP and ct.MAPHIEUNHAP='"+mapn +"'";
        
        String query1 ="select MANGUYENLIEU, TENNGUYENLIEU, SOLUONG, DVT, GIA, THANHTIEN from CHITIET_PHIEUNHAP AS ct\n" +
            "where ct.MAPHIEUNHAP='"+ mapn +"'";
        
        ResultSet    kt = con.executeQuery(query1);
        return kt;
    }

}
 