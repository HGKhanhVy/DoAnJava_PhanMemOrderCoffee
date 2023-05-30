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
    public THUCUONG_DTO LoadNuoc(int index, THUCUONG_DTO ncTemp) 
    {
        THUCUONG_DTO nuoc = lstAllThucUong.get(index);
        ncTemp.setMANUOC(nuoc.getMANUOC());
        ncTemp.setTENNUOC(nuoc.getTENNUOC());
        ncTemp.setGIA(nuoc.getGIA());
        ncTemp.setSIZE(nuoc.getSIZE());
        return ncTemp;
    }
    public String GetMaLoaiNuoc(String maNuoc)
    {
        String maLoai = "";
        try {
            String sql ="Select MALOAI from THUCUONG where MANUOC='"+maNuoc+"'";
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
    public int getSoLuongNuoc()
    {
        int sl = 0;
        try {
            String sql ="Select COUNT(*) AS SOLUONG from THUCUONG";
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
    public int themNuoc(THUCUONG_DTO lnc)
    {
        int i = 0;
        try
        {
            String sql = "INSERT INTO THUCUONG VALUES('"+lnc.getMANUOC()+"', '"+lnc.getMALOAI()+"', N'"+lnc.getTENNUOC()+"', '"+lnc.getGIA()+"', '"+lnc.getSIZE()+"', N'"+lnc.getTRANGTHAI()+"')";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstAllThucUong = getALL();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int updateNuoc(THUCUONG_DTO lnc)
    {
        int i = 0;
        try
        {
            String sql = "Update THUCUONG set TENNUOC=N'"+lnc.getTENNUOC()+"', GIA='"+lnc.getGIA()+"', SIZE='"+lnc.getSIZE()+"', TRANGTHAI=N'"+lnc.getTRANGTHAI()+"' Where MANUOC='"+lnc.getMANUOC()+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstAllThucUong = getALL();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int deleteNuoc(String maNuoc)
    {
        int i = 0;
        try
        {
            String sql = "Delete from THUCUONG where MANUOC='"+maNuoc+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            lstAllThucUong = getALL();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public String GetTrangThai(String maNuoc)
    {
        String trThai = "";
        try {
            String sql ="Select TRANGTHAI from THUCUONG where MANUOC='"+maNuoc+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                trThai = rs.getString("TRANGTHAI").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            trThai = "";
            return trThai;
        }
        return trThai;
    }
    public int CheckExist(String tenNuoc)
    {
        for(int i = 0;i < lstAllThucUong.size(); i++)
        {
            if(lstAllThucUong.get(i).getTENNUOC().equalsIgnoreCase(tenNuoc))
            {
                return 1;
            }
        }
        return 0;
    }
    public int SearchNuoc(String tenNuoc)
    {
        int index = 0;
        for(int i = 0;i < lstAllThucUong.size(); i++)
        {
            if(lstAllThucUong.get(i).getTENNUOC().equalsIgnoreCase(tenNuoc))
            {
                index = i;
                return index;
            }
        }
        return index;
    }
}
