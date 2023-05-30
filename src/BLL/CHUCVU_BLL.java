/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CHUCVU_DAL;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class CHUCVU_BLL {
    CHUCVU_DAL QLChucVu = new CHUCVU_DAL();
    public String GetMaChucVu(String tenCV)
    {
        return QLChucVu.GetMaChucVu(tenCV);
    }
    public ArrayList<String> getTenCV() {
        return QLChucVu.getTenCV();
    }
}
