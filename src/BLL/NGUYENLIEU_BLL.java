/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NGUYENLIEU_DAL;
import DTO.NguyenLieu_DTO;
import java.util.ArrayList;

/**
 *
 * @author caoth
 */
public class NGUYENLIEU_BLL {
    
     NGUYENLIEU_DAL nl= new NGUYENLIEU_DAL();
    String[] title_Table ={"MÃ NGUYÊN LIỆU","TÊN NGUYÊN LIỆU","SỐ LƯỢNG ","TỒN KHO", "DVT"};
    public String[] showTitle(){
        return title_Table;
    }
    
     public ArrayList<NguyenLieu_DTO> getALL() {
        return nl.getALL();
    }
     public String insert_NL(NguyenLieu_DTO n){
        int kt =  nl.insertNCC(n);
        if(kt == 1){
            return "Thành công";
        }
        else{
            return "Thất bại";
        }
    }
    public int delete_NL(String maNL ){
        return nl.delete(maNL);
    }
    public String Update_NL(NguyenLieu_DTO n){
        int kt =  nl.Update(n);
        if(kt == 1){
            return "Thành công";
        }
        else{
            return "Thất bại";
        }
    }
}
