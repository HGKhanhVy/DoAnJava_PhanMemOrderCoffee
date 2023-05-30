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
            String query ="select * from LOAITHUCUONG where TENLOAI ='"+tenThucUong+"'";
            ResultSet rs = con.executeQuery(query);
            while(rs.next()){
                return rs.getString("MALOAI");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LOAITHUCUONG_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<String> getTenLoai()
    {
        ArrayList<String> dsTenLoai = new ArrayList<String>();
        try {
            String query ="select TENLOAI from LOAITHUCUONG";
            ResultSet rs = con.executeQuery(query);
            while(rs.next()){
                dsTenLoai.add(rs.getString("TENLOAI"));
            }
        } catch (SQLException ex) {
            dsTenLoai.clear();
            return dsTenLoai;
        }
        return dsTenLoai;
    }
    public String GetTenLoaiNuoc(String maLoai)
    {
        String tenNuoc = "";
        try {
            String sql ="Select TENLOAI from LOAITHUCUONG where MALOAI='"+maLoai+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                tenNuoc = rs.getString("TENLOAI").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            tenNuoc = "";
            return tenNuoc;
        }
        return tenNuoc;
    }
    public String getMaLoai(String tenLoai) 
    {
        String maLoai = "";
        try {
            String sql ="Select MALOAI from LOAITHUCUONG where TENLOAI=N'"+tenLoai+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                maLoai = rs.getString("MALOAI").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            maLoai = "";
            return maLoai;
        }
        return maLoai;
    }
    public int getSoLuongLoai()
    {
        int sl = 0;
        try {
            String sql ="Select COUNT(*) AS SOLUONG from LOAITHUCUONG";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                sl = rs.getInt("SOLUONG");
            }
            cn.close();
        } catch (Exception e) 
        {
            sl = 0;
            return sl;
        }
        return sl;
    }
    public int themLoaiNuoc(LOAITHUCUONG_DTO lnc)
    {
        int i = 0;
        try
        {
            String sql = "INSERT INTO LOAITHUCUONG VALUES('"+lnc.getMALOAI()+"', N'"+lnc.getTENLOAI()+"')";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstLoaiThucUong = showList_LOAITHUCUONG();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int updateLoaiNuoc(LOAITHUCUONG_DTO lnc)
    {
        int i = 0;
        try
        {
            String sql = "Update LOAITHUCUONG set TENLOAI=N'"+lnc.getTENLOAI()+"' Where MALOAI='"+lnc.getMALOAI()+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstLoaiThucUong = showList_LOAITHUCUONG();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int deleteLoaiNuoc(String maLoai)
    {
        int i = 0;
        try
        {
            String sql = "Delete from LOAITHUCUONG where MALOAI='"+maLoai+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstLoaiThucUong = showList_LOAITHUCUONG();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
}
