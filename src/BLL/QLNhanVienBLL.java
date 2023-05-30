/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.QLNhanVienDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class QLNhanVienBLL {
    QLNhanVienDAL QLNhanVien = new QLNhanVienDAL();
    public String[] listTitleNV(){
        return QLNhanVien.listTitleNV();
    }
    
    public ArrayList<NhanVienDTO> showListNV_BLL(){
        return QLNhanVien.showListNV_DAL();
    }
    
    public void LoadNV(int index, NhanVienDTO nvTemp)
    {
        NhanVienDTO nv = new NhanVienDTO();
        nv = QLNhanVien.LoadNV(index, nvTemp);
    }
    public String CheckExist(String tk)
    {
        String rs = QLNhanVien.CheckExist(tk);
        if(rs.equals(""))
            return "Tài khoản không tồn tại";
        return "Tên tài khoản đã tồn tại";
    }
    public String CheckLogin(String tk, String mk)
    {
        int rs = QLNhanVien.CheckLogin(tk, mk);
        if(rs == 0)
            return "Vui lòng kiểm tra lại tài khoản/mật khẩu!";
        return "Đăng nhập thành công";
    }
    public String GetChucVu(String tk)
    {
        String rs = QLNhanVien.GetChucVu(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu chức vụ";
        return rs;
    }
    public String CheckExistTheoMaNV(String maNV)
    {
        String rs = QLNhanVien.CheckExistTheoMaNV(maNV);
        if(rs.equals(""))
            return "Mã nhân viên không tồn tại";
        return "Mã nhân viên đã tồn tại";
    }
    public String themNV(NhanVienDTO nv)
    {
        int kq = QLNhanVien.themNV(nv);
        if(kq == 0)
            return "Thêm nhân viên không thành công!";
        return "Thêm nhân viên thành công";
    }
    public String upateNV(NhanVienDTO nv)
    {
        int kq = QLNhanVien.updateNV(nv);
        if(kq == 0)
            return "Cập nhật nhân viên không thành công!";
        return "Cập nhật nhân viên thành công";
    }
    public String deleteNV(String maNV)
    {
        int kq = QLNhanVien.deleteNV(maNV);
        if(kq == 0)
            return "Xóa nhân viên không thành công!";
        return " Xóa nhân viên thành công";
    }
    public int getSoLuongNhanVien(){
        return QLNhanVien.getSoLuongNhanVien();
    }
    public String GetMatKhau(String tk)
    {
        String rs = QLNhanVien.GetMatKhau(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu mật khẩu";
        return rs;
    }
    public String upateMK(String tk, String mk)
    {
        int kq = QLNhanVien.updateMK(tk, mk);
        if(kq == 0)
            return "Thay đổi mật khẩu không thành công!";
        return "Thay đổi mật khẩu thành công";
    }
    public String GetMaNV(String tk)
    {
        String rs = QLNhanVien.GetMaNV(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu mã nhân viên";
        return rs;
    }
    public String GetNameNV(String tk)
    {
        String rs = QLNhanVien.GetNameNV(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu tên nhân viên";
        return rs;
    }
    public String GetGioiTinh(String tk)
    {
        String rs = QLNhanVien.GetGioiTinh(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu giới tính";
        return rs;
    }
    public String GetSDT(String tk)
    {
        String rs = QLNhanVien.GetSDT(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu số điện thoại";
        return rs;
    }
    public String GetDiaChi(String tk)
    {
        String rs = QLNhanVien.GetDiaChi(tk);
        if(rs.equals(""))
            return "Không thể lấy dữ liệu địa chỉ";
        return rs;
    }
    public String thayDoiThongTin(NhanVienDTO nv)
    {
        int kq = QLNhanVien.thayDoiThongTin(nv);
        if(kq == 0)
            return "Cập nhật nhân viên không thành công!";
        return "Cập nhật nhân viên thành công";
    }
}
