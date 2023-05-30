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
    public void LoadNuoc(int index, THUCUONG_DTO ncTemp)
    {
        THUCUONG_DTO nuoc = new THUCUONG_DTO();
        nuoc = thucuong_DAL.LoadNuoc(index, ncTemp);
    }
    public String GetMaLoaiNuoc(String maNuoc){
        return thucuong_DAL.GetMaLoaiNuoc(maNuoc);
    }
    public int getSoLuongNuoc(){
        return thucuong_DAL.getSoLuongNuoc();
    }
    public String themNuoc(THUCUONG_DTO nc)
    {
        int kq = thucuong_DAL.themNuoc(nc);
        if(kq == 0)
            return "Thêm thức uống không thành công!";
        return "Thêm thức uống thành công";
    }
    public String updateNuoc(THUCUONG_DTO nc)
    {
        int kq = thucuong_DAL.updateNuoc(nc);
        if(kq == 0)
            return "Cập nhật thức uống không thành công!";
        return "Cập nhật thức uống thành công";
    }
    public String deleteNuoc(String maNuoc)
    {
        int kq = thucuong_DAL.deleteNuoc(maNuoc);
        if(kq == 0)
            return "Xóa thức uống không thành công!";
        return " Xóa thức uống thành công";
    }
    public String GetTrangThai(String maNuoc){
        return thucuong_DAL.GetTrangThai(maNuoc);
    }
    public String CheckExist(String tenNuoc)
    {
        int rs = thucuong_DAL.CheckExist(tenNuoc);
        if(rs == 0)
            return "Không tồn tại tên thức uống cần tìm";
        return "Đã tìm thấy thức uống: " + tenNuoc;
    }
    public int SearchNuoc(String tenNuoc)
    {
        int rs = thucuong_DAL.SearchNuoc(tenNuoc);
        return rs;
    }
}
