/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BAN_BLL;
import BLL.CT_HOADON_BLL;
import BLL.HOADON_BLL;
import BLL.KHACHHANG_BLL;
import BLL.LOAITHUCUONG_BLL;
import BLL.THUCUONG_BLL;
import Connect.Connect_DB;
import DTO.CT_HOADON_DTO;
import DTO.HOADON_DTO;
import DTO.KHACHHANG_DTO;
import DTO.LOAITHUCUONG_DTO;
import DTO.THUCUONG_DTO;
import Helper.MyHelper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
<<<<<<< HEAD:src/GUI/Panel_ChiTietBan.java
=======
import Helper.MyHelper;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
>>>>>>> 8ceae77189d9deb2864ecc42c0d83b0124347814:src/GUI/Panel_ChiTietHD_Ban.java
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author khanh
 */
public class Panel_ChiTietBan extends javax.swing.JPanel {

    /**
     * Creates new form Panel_ChiTietBan
     */
    String _TenBan, _MaBan, _MaHoaDon = "", _TrangThai = "";

    DefaultComboBoxModel cbxModelLoaiThucUong = new DefaultComboBoxModel();
    DefaultTableModel tblModel_DSNuoc = new DefaultTableModel();
    DefaultTableModel tblModel_CTHoaDon = new DefaultTableModel();

    THUCUONG_BLL thucuong_BLL = new THUCUONG_BLL();
    LOAITHUCUONG_BLL loaiThucUong_BLL = new LOAITHUCUONG_BLL();
    CT_HOADON_BLL chitietHD = new CT_HOADON_BLL();
    HOADON_BLL hoadon_bll = new HOADON_BLL();
    BAN_BLL ban_bll = new BAN_BLL();
    KHACHHANG_BLL khachHangBLL = new KHACHHANG_BLL();

    ArrayList<THUCUONG_DTO> lstThucUong = new ArrayList<THUCUONG_DTO>();
    public Panel_ChiTietBan() {
        initComponents();
        LoadData();
        loadComboboxLoaiNuocUong();
        LoadDSNuoc();
        tblModel_CTHoaDon.setRowCount(0);
        tbl_CT_HoaDon.setModel(tblModel_CTHoaDon);
        lstThucUong = thucuong_BLL.getALL();
    }
    public void KTrangThai_btn_DatBan() {
        String tam = _TrangThai;
        int len = _TrangThai.length();
        if (_TrangThai.equalsIgnoreCase("datcho") == true && _TrangThai.length() > 0) {
            //bàn đang đặt
            //set btn hủy đặt 
            btn_DatBan.setText("Hủy Đặt");
        } else {
            btn_DatBan.setText("Đặt Bàn");
        }

    }

    public void SetMaBan(String MaBan, String TrangThai) {
        _MaBan = MaBan;
        txt_MaBan.setText("Mã Bàn: " + _MaBan);
        txt_TrangThai.setText("Trạng Thái: " + TrangThai);
        _TrangThai = TrangThai;
        KTrangThai_btn_DatBan();
    }

    public void SetMaHoaDon(String MaHoaDon) {
        _MaHoaDon = MaHoaDon;
        if (_MaHoaDon.length() != 0) {
            txt_MaHoaDon.setText("Mã Hóa Đơn: " + MaHoaDon);
        } else {
            txt_MaHoaDon.setText("Mã Hóa Đơn: null");
        }
    }

    public void ThemRowtbl_CTHD(String manuoc, String TenNuoc, int sl, float DonGia) {
        tblModel_CTHoaDon.addRow(new Object[]{
            manuoc, TenNuoc, sl, DonGia
        });
        tbl_CT_HoaDon.setModel(tblModel_CTHoaDon);
    }

    public void LoadChiTietHoaDon() {
        tblModel_CTHoaDon.setColumnIdentifiers(chitietHD.showTitleTable());
        tblModel_CTHoaDon.setRowCount(0);
        if (_MaHoaDon.length() != 0) {
            //Load hoa đơn cua bàn đó lên
            for (CT_HOADON_DTO items : chitietHD.ShowCTHoaDon(_MaBan)) {
                tblModel_CTHoaDon.addRow(new Object[]{
                    items.getMANUOC(), items.getTENNUOC(), items.getSL(), items.getDONGIA(), items.getTHANHTIEN()
                });
            }
        }//nếu bàn trống chờ oder
        tbl_CT_HoaDon.setModel(tblModel_CTHoaDon);
        TongTienTamTinh();
    }

    public void LoadDSNuoc(String maLoai) {
        if (maLoai == null) {
            maLoai = "L001";
        }
        tblModel_DSNuoc.setRowCount(0);
        tblModel_DSNuoc.setColumnIdentifiers(thucuong_BLL.showTitle());
        for (THUCUONG_DTO items : lstThucUong) {
            if (items.getMALOAI().equalsIgnoreCase(maLoai) == true) {
                tblModel_DSNuoc.addRow(new Object[]{
                    items.getMANUOC(), items.getTENNUOC(), items.getSIZE(), items.getGIA()
                });
            }
        }
        tblDSNuocUong.setModel(tblModel_DSNuoc);
    }

    public void LoadDSNuoc() {
        tblModel_DSNuoc.setRowCount(0);
        tblModel_DSNuoc.setColumnIdentifiers(thucuong_BLL.showTitle());
        tblDSNuocUong.setModel(tblModel_DSNuoc);
    }

    private void loadComboboxLoaiNuocUong() {
        for (LOAITHUCUONG_DTO items : loaiThucUong_BLL.showListLoaiThucUong()) {
            cbx_LoaiNuocUong.addItem(items.getTENLOAI());
        }
    }

    private void LoadData() {
        
    }

    public void setTenBan(String TenBan) {
        _TenBan = TenBan;
        txt_MaBan.setText(_TenBan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaBan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_TrangThai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbx_LoaiNuocUong = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_CT_HoaDon = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSNuocUong = new javax.swing.JTable();
        btn_ChuyenBan = new javax.swing.JButton();
        btn_DatBan = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_MaHoaDon = new javax.swing.JLabel();
        txt_TongTien = new javax.swing.JLabel();
        txt_SL = new javax.swing.JSpinner();

        jLabel2.setText("jLabel2");

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tên bàn:");

        txt_MaBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_MaBan.setText("Mã bàn");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("-");

        txt_TrangThai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_TrangThai.setText("TT");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Loại đồ uống:");

        cbx_LoaiNuocUong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbl_CT_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CT_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CT_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_CT_HoaDon);

        btn_Them.setText("<");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setText(">");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        tblDSNuocUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDSNuocUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNuocUongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSNuocUong);

        btn_ChuyenBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ChuyenBan.setText("Chuyển bàn");
        btn_ChuyenBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChuyenBanActionPerformed(evt);
            }
        });

        btn_DatBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_DatBan.setText("Đặt bàn");
        btn_DatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatBanActionPerformed(evt);
            }
        });

        btn_ThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ThanhToan.setText("Thanh toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Mã hóa đơn:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        txt_MaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_MaHoaDon.setText("maHD");

        txt_TongTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_TongTien.setText("tongtien");

        txt_SL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbx_LoaiNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_MaBan)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_TrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(52, 52, 52)))
                        .addComponent(btn_ChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_SL))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TongTien)
                            .addComponent(txt_MaHoaDon)))
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_MaBan)
                    .addComponent(jLabel3)
                    .addComponent(txt_TrangThai)
                    .addComponent(btn_ChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_LoaiNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_MaHoaDon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_TongTien))
                .addGap(18, 18, 18)
                .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void ShowThongBao(String thongbao) {
        JOptionPane.showConfirmDialog(null, thongbao, "Thông báo hệ thống", JOptionPane.DEFAULT_OPTION);
    }

    private int KT_TrungMaNuoc(String MaHD, String MaNuoc) {
        for (int i = 0; i < tbl_CT_HoaDon.getRowCount(); i++) {
            if (tbl_CT_HoaDon.getValueAt(i, 0).toString().equalsIgnoreCase(MaNuoc) == true) {
                return 1;
            }
        }
        return 0;
    }

    private int getSLtbl_CTHD(String manuoc) {
        for (int i = 0; i < tbl_CT_HoaDon.getRowCount(); i++) {
            if (tbl_CT_HoaDon.getValueAt(i, 0).toString().equalsIgnoreCase(manuoc) == true) {
                return Integer.valueOf(tbl_CT_HoaDon.getValueAt(i, 2).toString());
            }
        }
        return 0;
    }

    private boolean KT_ThongTin() {
        if (_MaBan == "" || _MaBan == null) {
            return false;
        }
        return true;
    }

    private void TongTienTamTinh() {
        float sum = 0;
        for (int i = 0; i < tbl_CT_HoaDon.getRowCount(); i++) {
            sum += Float.valueOf(tbl_CT_HoaDon.getValueAt(i, 4).toString());
        }
        txt_TongTien.setText("Tổng Tiền: " + sum);
    }
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        boolean KT_ThongTin = KT_ThongTin();
        if (vitri_click_DSNuoc == -1) {
            ShowThongBao("Bạn chưa chọn nước");
        } else if (KT_ThongTin() == true && vitri_click_DSNuoc != -1) {

            if (tbl_CT_HoaDon.getRowCount() == 0) {
                //thêm mới hóa đơn
                //Lưu thông tin hóa đơn
                //String _MAHOADON, String _MANHANVIEN, String _TENHOADON, String _TRANGTHAI, String _MABAN, String _NGAYXUAT, String _GIOVAO
                try {
                    String _maHoaDon_Temp = MyHelper.getMaHD();
                    HOADON_DTO hd = new HOADON_DTO(_maHoaDon_Temp, "NV01", _MaBan, "CHUA THANH TOAN", _MaBan, Helper.MyHelper.getDate(), Helper.MyHelper.getDate() + " " + Helper.MyHelper.getTime());
                    int kt = hoadon_bll.ThemHoaDon(hd);
                    if (kt == -1) {
                        ShowThongBao("Thêm hóa đơn thất bại");
                    }
                    _MaHoaDon = _maHoaDon_Temp;
                } catch (Exception e) {
                    System.out.print("Lỗi Thêm hóa đơn");
                }
                //lưu thong tin khách hàng 
                KHACHHANG_DTO kh = new KHACHHANG_DTO(MyHelper.getMaKH(), MyHelper.getDate() + " " + MyHelper.getTime(), _MaBan);
                khachHangBLL.InsertKhacHang(kh);
                //lưu thông tin chi tiết hóa đơn
                //String _MANUOC, String _MAHOADON, String _TENNUOC, int _SL, float _DONGIA
                String manuoc = (String) tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 0);
                String tennuoc = (String) tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 1);
                int sl = Integer.valueOf(txt_SL.getValue().toString());
                float gia = Float.valueOf(tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 3).toString());
                CT_HOADON_DTO cthd = new CT_HOADON_DTO(manuoc, _MaHoaDon, tennuoc, sl, gia);
                int kt_chitiethoadon = chitietHD.InsertCT_HD(cthd);
                if (1 == kt_chitiethoadon) {
                    System.out.print("Thêm chi tiết hóa đơn thành công.");
                    ban_bll.CapNhatTrangThai(_MaBan, "hetcho");
                    Frm_QuanLyBan f = new Frm_QuanLyBan();
                    f.UpdateTrangThaiCoKhach(_MaBan);
                    //f.LoadTrangThaiBan();
                    _TrangThai = "hetcho";
                    LoadChiTietHoaDon();
                } else {
                    System.out.print("Thêm chi tiết hóa đơn thất bại");
                    ShowThongBao("Thêm thất bại");
                }
            } else {
                //lầy thông tin trên bảng
                String manuoc = (String) tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 0);
                String tennuoc = (String) tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 1);
                int sl = Integer.valueOf(txt_SL.getValue().toString());
                float gia = Float.valueOf(tblDSNuocUong.getValueAt(vitri_click_DSNuoc, 3).toString());
                //add thêm vào chi tiết háo đơn
                if (KT_TrungMaNuoc(_MaHoaDon, manuoc) == 0) {   //không trùng
                    //ThemRowtbl_CTHD(manuoc, tennuoc, sl, gia);
                    //thêm mới một chi tiêt hóa đơn  
                    //String _MANUOC, String _MAHOADON, String _TENNUOC, int _SL, float _DONGIA
                    CT_HOADON_DTO ctHd = new CT_HOADON_DTO(manuoc, _MaHoaDon, tennuoc, sl, gia);
                    int kt = chitietHD.InsertCT_HD(ctHd);
                    vitri_click_DSNuoc = -1;
                    LoadChiTietHoaDon();
                } else {
                    //trùng tăng số lượng
                    int slhientai = getSLtbl_CTHD(manuoc);
                    int slchon = Integer.valueOf(txt_SL.getValue().toString());
                    int kt = chitietHD.UpdateSoLuong(slhientai + slchon, _MaHoaDon, manuoc);
                    if (kt == 1) {
                        LoadChiTietHoaDon();
                    } else {
                        System.out.print("Cập nhật số lượng không thành công!");
                    }
                }
            }
            TongTienTamTinh();
        } else {
            ShowThongBao("Bạn chưa chọn bàn.");
        }
    }//GEN-LAST:event_btn_ThemActionPerformed
    int vitri_click_DSNuoc = -1;
    private void tblDSNuocUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNuocUongMouseClicked
        vitri_click_DSNuoc = tblDSNuocUong.getSelectedRow();
    }//GEN-LAST:event_tblDSNuocUongMouseClicked
    
    String MaLoai = "";
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        String TenLoai = cbx_LoaiNuocUong.getSelectedItem().toString();
        MaLoai = loaiThucUong_BLL.getMaLoaiThucUong(TenLoai);
        LoadDSNuoc(MaLoai);
    }//GEN-LAST:event_formMouseEntered
    
    int vitri_tblCTHoaDon = -1;
    private void tbl_CT_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CT_HoaDonMouseClicked
        vitri_tblCTHoaDon = tbl_CT_HoaDon.getSelectedRow();
    }//GEN-LAST:event_tbl_CT_HoaDonMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        if (vitri_tblCTHoaDon == -1) {
            ShowThongBao("Bạn chưa chọn mã nước..");
        } else {
            int slXoa = Integer.valueOf(txt_SL.getValue().toString());
            String manuoc = tbl_CT_HoaDon.getValueAt(vitri_tblCTHoaDon, 0).toString();
            int sltblCTHD = Integer.valueOf(tbl_CT_HoaDon.getValueAt(vitri_tblCTHoaDon, 2).toString());
            if (slXoa == sltblCTHD) {
                //xóa một chi tiết hoa đơn
                int kt = chitietHD.Delete_Items_CTHD(_MaHoaDon, manuoc);
                if (1 == chitietHD.Delete_Items_CTHD(_MaHoaDon, manuoc)) {
                    System.out.print("\nXóa thành công 1 chi tiết hóa đơn");
                    vitri_tblCTHoaDon = -1; //set lai vi tri chon
                }
                LoadChiTietHoaDon();
            } else if (slXoa > sltblCTHD) {
                ShowThongBao("Số lương cần xóa không thể lớn hơn.");
            } else if (slXoa < sltblCTHD) {
                //giảm số lượng
                int k2t = sltblCTHD - slXoa;
                int kt = chitietHD.UpdateSoLuong(k2t, _MaHoaDon, manuoc);
                if (1 == kt) {
                    System.out.print("\nXóa thành công một chi tiết hóa đơn");
                    vitri_tblCTHoaDon = -1; //set lai vi tri chon
                }
                LoadChiTietHoaDon();
            }
            TongTienTamTinh();
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        int kt = hoadon_bll.ThanhToanHoaDon(_MaHoaDon, Helper.MyHelper.getDate() + " " + Helper.MyHelper.getTime());
        if (kt == 1) {
            ShowThongBao("Thanh Toán Thành Công" + _MaHoaDon);
            ban_bll.CapNhatTrangThai(_MaBan, "trong");
            //xuất report hóa đơn
            XuatHoaDon(_MaHoaDon);
        } else {
            ShowThongBao("Thanh Toán Thất Bại");
        }
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void btn_ChuyenBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChuyenBanActionPerformed
        Dialog_HienThiDanhSachBan f = new Dialog_HienThiDanhSachBan(null, true);
        f.SetMaBan(_MaBan);
        f.SetMaHoaDon(_MaHoaDon);
        f.show();
    }//GEN-LAST:event_btn_ChuyenBanActionPerformed

    private void btn_DatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatBanActionPerformed
        String nameBtn = btn_DatBan.getText();
        if (nameBtn.equalsIgnoreCase("Hủy Đặt") == true) {
            //hủy đặt bàn
            ban_bll.CapNhatTrangThai(_MaBan, "trong");
            ShowThongBao("Hủy đặt bàn thành công.");
        } else {
            if (tbl_CT_HoaDon.getRowCount() != 0) {
                ShowThongBao("Bàn này không thể đặt");
            } else if (1 == ban_bll.SetDatBan(_MaBan)) {
                ShowThongBao("Đặt bàn thành công!");
            } else {
                ShowThongBao("Đặt bàn không thành công");
            }
        }
    }//GEN-LAST:event_btn_DatBanActionPerformed
    public void XuatHoaDon(String _mahd) {
        try {
            Connect_DB cn = new Connect_DB();
            Hashtable map = new Hashtable();
            JasperReport rpt = JasperCompileManager.compileReport("src/Report/rpt_HoaDon.jrxml");
            map.put("maHD", _mahd);
            Connection con = cn.getCn();
            JasperPrint p = JasperFillManager.fillReport(rpt, map, con);
            JasperViewer.viewReport(p, false);
        } catch (JRException ex) {
            Logger.getLogger(Panel_ChiTietBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChuyenBan;
    private javax.swing.JButton btn_DatBan;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbx_LoaiNuocUong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tblDSNuocUong;
    private javax.swing.JTable tbl_CT_HoaDon;
    private javax.swing.JLabel txt_MaBan;
    private javax.swing.JLabel txt_MaHoaDon;
    private javax.swing.JSpinner txt_SL;
    private javax.swing.JLabel txt_TongTien;
    private javax.swing.JLabel txt_TrangThai;
    // End of variables declaration//GEN-END:variables
}
