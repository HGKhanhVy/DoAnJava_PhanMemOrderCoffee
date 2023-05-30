/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.KHACHHANG_DTO;
import DAL.*;
/**
 *
 * @author DELL
 */
public class KHACHHANG_BLL {
    KHACHHANG_DAL khachHang_DAL = new KHACHHANG_DAL();
     public int InsertKhacHang(KHACHHANG_DTO kh) {
         return khachHang_DAL.InsertKhacHang(kh);
     }
}
