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
    public ArrayList<String>getTenLoai(){
        return LoaiTU.getTenLoai();
    }
    public String GetTenLoaiNuoc(String maNuoc){
        return LoaiTU.GetTenLoaiNuoc(maNuoc);
    }
    public String getMaLoai(String tenLoai){
        return LoaiTU.getMaLoai(tenLoai);
    }
    public int getSoLuongLoai(){
        return LoaiTU.getSoLuongLoai();
    }
    public String themLoaiNuoc(LOAITHUCUONG_DTO nc)
    {
        int kq = LoaiTU.themLoaiNuoc(nc);
        if(kq == 0)
            return "Thêm loại thức uống không thành công!";
        return "Thêm loại thức uống thành công";
    }
    public String updateLoaiNuoc(LOAITHUCUONG_DTO lnc)
    {
        int kq = LoaiTU.updateLoaiNuoc(lnc);
        if(kq == 0)
            return "Cập nhật loại thức uống không thành công!";
        return "Cập nhật loại thức uống thành công";
    }
    public String deleteLoaiNuoc(String maLoai)
    {
        int kq = LoaiTU.deleteLoaiNuoc(maLoai);
        if(kq == 0)
            return "Xóa loại thức uống không thành công!";
        return " Xóa loại thức uống thành công";
    }
}
