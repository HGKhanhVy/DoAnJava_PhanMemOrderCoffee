/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.*;
import Connect.Connect_DB;
import java.sql.Connection;

/**
 *
 * @author DELL
 */
public class KHACHHANG_DAL {
    Connect_DB con = new Connect_DB();
    Connection cn = con.getCn();
    public int InsertKhacHang(KHACHHANG_DTO kh) {
        String query = "set dateformat dmy insert into KHACHHANG (MAKHACHHANG, THOIGIANDEN, MABAN) VALUES ('" + kh.getMAKHACHHANG() + "','" + kh.getTHOIGIANDEN() + "','" + kh.getMABAN() + "')";
        int kt = con.executeUpdate(query);
        return kt;
    }
}
