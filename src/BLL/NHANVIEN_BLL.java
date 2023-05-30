/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NHANVIEN_DAL;
import DTO.NHANVIEN_DTO;
import java.util.ArrayList;

/**
 *
 * @author caoth
 */
public class NHANVIEN_BLL {
    
    NHANVIEN_DAL nv= new NHANVIEN_DAL();
    
    
     public ArrayList<NHANVIEN_DTO> getALL() {
        return nv.getALL();
    }
    
}
