/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DTO.*;
import DAL.*;
import java.util.ArrayList;
/**
 * 
 *
 * @author DELL
 */
public class THUCUONG_BLL {
    THUCUONG_DAL thucuong_DAL= new THUCUONG_DAL();
    String[] title_Table ={"MÃ NƯỚC","TÊN NƯỚC","SIZE","GIÁ"};
    public String[] showTitle(){
        return title_Table;
    }
    public ArrayList<THUCUONG_DTO> showDSThucUongByMaLoai(String maLoai){
        return  thucuong_DAL.showListNuocUongByMaLoai(maLoai);
    }
     public ArrayList<THUCUONG_DTO> getALL() {
        return thucuong_DAL.getALL();
    }
}
