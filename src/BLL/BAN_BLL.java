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
 * @author DELL
 */
public class BAN_BLL {

    BAN_DAL ban_DAL = new BAN_DAL();

    public ArrayList<BAN_DTO> showThongTinBan() {
        return ban_DAL.ShowThongTinBan();
    }

    public int CapNhatTrangThai(String MaBan, String TrangThai) {
        return ban_DAL.CapNhatTrangThai(MaBan, TrangThai);
    }

    public String getTrangThai(String MaBan) {
        return ban_DAL.GetTrangThaiBan(MaBan);
    }
    public int SetDatBan(String maBan) {
        return ban_DAL.SetDatBan(maBan);
    }
}
