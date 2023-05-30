/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NHACUNGCAP_DAL;
import DTO.NhaCungCap_DTO;
import java.util.ArrayList;

/**
 *
 * @author caoth
 */
public class NHACUNGCAP_BLL {
    NHACUNGCAP_DAL ncc= new NHACUNGCAP_DAL();
    String[] title_Table ={"MÃ NHÀ CUNG CẤP","TÊN NHÀ CUNG CẤP","ĐỊA CHỈ","SDT"};
    public String[] showTitle(){
        return title_Table;
    }
    
     public ArrayList<NhaCungCap_DTO> getALL() {
        return ncc.getALL();
    }
     
    public String insert_NCC(NhaCungCap_DTO n){
        int kt =  ncc.insertNCC(n);
        if(kt == 1){
            return "Thành công";
        }
        else{
            return "Thất bại";
        }
    }
    public int delete_NCC(String maNCC ){
        return ncc.delete(maNCC);
    }
    public String Update_NCC(NhaCungCap_DTO n){
        int kt =  ncc.Update(n);
        if(kt == 1){
            return "Thành công";
        }
        else{
            return "Thất bại";
        }
    }
}
