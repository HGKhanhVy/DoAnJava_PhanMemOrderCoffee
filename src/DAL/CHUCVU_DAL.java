/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Connect.Connect_DB;
import DTO.CHUCVU_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class CHUCVU_DAL {
    private ArrayList<CHUCVU_DTO> listCV = new ArrayList<>();
    public CHUCVU_DAL() 
    {
        listCV = getDSNhanVien();
    }
    public static ArrayList<CHUCVU_DTO> getDSNhanVien()
    {
        ArrayList<CHUCVU_DTO> dsNV = new ArrayList<CHUCVU_DTO>();
        try{
            String sql="Select * From CHUCVU";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next())
            {
                CHUCVU_DTO cv = new CHUCVU_DTO(rs.getString("MACHUCVU").trim(), rs.getString("TENCHUCVU").trim());
                dsNV.add(cv);
            }            
        }catch(Exception e)
        {
           dsNV.clear();
           return dsNV;
        }
        return  dsNV;
    }
    public String GetMaChucVu(String tenCV)
    {
        String maCV = "";
        try {
            String sql ="Select MACHUCVU from CHUCVU where TENCHUCVU=N'"+tenCV+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                maCV = rs.getString("MACHUCVU").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            maCV = "";
            return maCV;
        }
        return maCV;
    }
    public ArrayList<String> getTenCV()
    {
        ArrayList<String> dsTenCV = new ArrayList<String>();
        try {
            String sql ="select TENCHUCVU from CHUCVU";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                dsTenCV.add(rs.getString("TENCHUCVU"));
            }
            cn.close();
        } catch (SQLException ex) {
            dsTenCV.clear();
            return dsTenCV;
        }
        return dsTenCV;
    }
}
