/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Connect.Connect_DB;
import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class QLNhanVienDAL {
    private ArrayList<NhanVienDTO> listNV = new ArrayList<>();
    public QLNhanVienDAL() 
    {
        listNV = getDSNhanVien();
    }
    public static ArrayList<NhanVienDTO> getDSNhanVien()
    {
        ArrayList<NhanVienDTO> dsNV = new ArrayList<NhanVienDTO>();
        try{
            String sql="Select * From NhanVien";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next())
            {
                NhanVienDTO nv = new NhanVienDTO(rs.getString("MANHANVIEN").trim(), rs.getString("MACHUCVU").trim(), rs.getString("TENNHANVIEN").trim() , rs.getString("GIOITINH").trim(),rs.getString("DIACHI").trim(),rs.getString("SDT").trim(),rs.getString("TAIKHOAN").trim(),rs.getString("MATKHAU").trim());
                dsNV.add(nv);
            }            
        }catch(Exception e)
        {
           dsNV.clear();
           return dsNV;
        }
        return  dsNV;
    }
    public String[] listTitleNV() {
        String[] arr = {"Mã nhân viên", "Chức vụ", "Tên nhân viên", "Giới tính", "Địa chỉ", "Sdt", "Tài khoản"};
        return arr;
    }
    
    public ArrayList<NhanVienDTO> showListNV_DAL() {
        return listNV;
    }
    
    public NhanVienDTO LoadNV(int index, NhanVienDTO nvTemp) 
    {
        NhanVienDTO nv = listNV.get(index);
        nvTemp.setMaNV(nv.getMaNV());
        nvTemp.setMaCV(nv.getMaCV());
        nvTemp.setTenNV(nv.getTenNV());
        nvTemp.setGioiTinh(nv.getGioiTinh());
        nvTemp.setDiaChi(nv.getDiaChi());
        nvTemp.setSdt(nv.getSdt());
        nvTemp.setTaiKhoan(nv.getTaiKhoan());
        nvTemp.setMatKhau(nv.getMatKhau());
        return nvTemp;
    }
    public String CheckExist(String tk) 
    {
        String kq = "";
        try {
            String sql ="Select * from NHANVIEN where TAIKHOAN='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                kq = rs.getString("TAIKHOAN");
            }
            cn.close();
        } catch (Exception e) 
        {
            kq = "";
            return kq;
        }
        return kq;
    }
    public int CheckLogin(String tk, String mk)
    {
        int kq = 0;
        try {
            String sql ="Select * from NHANVIEN where TAIKHOAN='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                String tempTK = rs.getString("TAIKHOAN").trim();
                String tempMK = rs.getString("MATKHAU").trim();
                if(tempTK.equals(tk) && tempMK.equals(mk))
                    kq = 1;
            }
            cn.close();
        } catch (Exception e) 
        {
            kq = 0;
            return kq;
        }
        return kq;
    }
    
    public String GetChucVu(String tk)
    {
        String nameCV = "";
        try {
            String sql ="Select TENCHUCVU from NHANVIEN, CHUCVU where NHANVIEN.MACHUCVU = CHUCVU.MACHUCVU and TAIKHOAN='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                nameCV = rs.getString("TENCHUCVU").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            nameCV = "";
            return nameCV;
        }
        return nameCV;
    }
    public int themNV(NhanVienDTO nv)
    {
        int i = 0;
        try
        {
            String sql = "INSERT INTO NhanVien VALUES('"+nv.getMaNV()+"', '"+nv.getMaCV()+"', N'"+nv.getTenNV()+"', N'"+nv.getGioiTinh()+"', N'"+nv.getDiaChi()+"','"+nv.getSdt()+"','"+nv.getTaiKhoan()+"','"+nv.getMatKhau()+"')";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            listNV = getDSNhanVien();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int updateNV(NhanVienDTO nv)
    {
        int i = 0;
        try
        {
            String sql = "Update NhanVien set TENNHANVIEN=N'"+nv.getTenNV()+"', GioiTinh=N'"+nv.getGioiTinh()+"',DiaChi=N'"+nv.getDiaChi()+"',SDT='"+nv.getSdt()+"', TaiKhoan='"+nv.getTaiKhoan()+"',MatKhau='"+nv.getMatKhau()+"' Where MANHANVIEN='"+nv.getMaNV()+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            listNV = getDSNhanVien();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public int deleteNV(String maNV)
    {
        int i = 0;
        try
        {
            String sql = "Delete from NhanVien where MANHANVIEN= '"+maNV+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            listNV = getDSNhanVien();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public String CheckExistTheoMaNV(String maNV) 
    {
        String kq = "";
        try {
            String sql ="Select MANHANVIEN from NhanVien where MANHANVIEN='"+maNV+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                kq = rs.getString("MaNV");
            }
            cn.close();
        } catch (Exception e) 
        {
            kq = "";
            return kq;
        }
        return kq;
    }
    public int getSoLuongNhanVien()
    {
        int sl = 0;
        try {
            String sql ="Select COUNT(*) AS SOLUONG from NHANVIEN";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                sl = rs.getInt("SOLUONG");
            }
            cn.close();
        } catch (Exception e) 
        {
            sl = 0;
            return sl;
        }
        return sl;
    }
    public String GetMatKhau(String tk)
    {
        String matKhau = "";
        try {
            String sql ="Select MatKhau from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                matKhau = rs.getString("MatKhau").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            matKhau = "";
            return matKhau;
        }
        return matKhau;
    }
    public int updateMK(String tk, String mk)
    {
        int i = 0;
        try
        {
            String sql = "Update NhanVien set MatKhau='"+mk+"' Where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            listNV = getDSNhanVien();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
    public String GetMaNV(String tk)
    {
        String maNV = "";
        try {
            String sql ="Select MANHANVIEN from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                maNV = rs.getString("MANHANVIEN").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            maNV = "";
            return maNV;
        }
        return maNV;
    }
    public String GetNameNV(String tk)
    {
        String nameNV = "";
        try {
            String sql ="Select TENNHANVIEN from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                nameNV = rs.getString("TENNHANVIEN").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            nameNV = "";
            return nameNV;
        }
        return nameNV;
    }
    public String GetGioiTinh(String tk)
    {
        String gioiTinh = "";
        try {
            String sql ="Select GioiTinh from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                gioiTinh = rs.getString("GioiTinh").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            gioiTinh = "";
            return gioiTinh;
        }
        return gioiTinh;
    }
    public String GetSDT(String tk)
    {
        String sdt = "";
        try {
            String sql ="Select SDT from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                sdt = rs.getString("SDT").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            sdt = "";
            return sdt;
        }
        return sdt;
    }
    public String GetDiaChi(String tk)
    {
        String diaChi = "";
        try {
            String sql ="Select DiaChi from NhanVien where TaiKhoan='"+tk+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                diaChi = rs.getString("DiaChi").trim();
            }
            cn.close();
        } catch (Exception e) 
        {
            diaChi = "";
            return diaChi;
        }
        return diaChi;
    }
    public int thayDoiThongTin(NhanVienDTO nv)
    {
        int i = 0;
        try
        {
            String sql = "Update NhanVien set TENNHANVIEN=N'"+nv.getTenNV()+"', GioiTinh=N'"+nv.getGioiTinh()+"',DiaChi=N'"+nv.getDiaChi()+"',SDT='"+nv.getSdt()+"' Where MANHANVIEN='"+nv.getMaNV()+"'";
            Connect_DB cn = new Connect_DB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            listNV = getDSNhanVien();
            cn.close();
        } catch(Exception e)
        {
            return 0;
        }   
        return 1;
    }
}
