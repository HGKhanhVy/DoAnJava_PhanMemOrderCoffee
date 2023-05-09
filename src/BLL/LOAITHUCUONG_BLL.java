/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DTO.LOAITHUCUONG_DTO;
import DAL.LOAITHUCUONG_DAL;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class LOAITHUCUONG_BLL {
    LOAITHUCUONG_DAL LoaiTU= new LOAITHUCUONG_DAL();
    public ArrayList<LOAITHUCUONG_DTO>showListLoaiThucUong(){
        return LoaiTU.showList_LOAITHUCUONG();
    }
    public String getMaLoaiThucUong (String tenLoai){
        return LoaiTU.getMaLoaiThucUong(tenLoai);
    }
}
