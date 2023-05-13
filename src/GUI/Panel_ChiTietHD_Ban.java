/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.*;
import DTO.*;
import Connect.Connect_DB;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DELL
 */
public class Panel_ChiTietHD_Ban extends javax.swing.JPanel {

    /**
     * Creates new form Panel_ChiTietHD_Ban
     */
    String _TenBan, _MaBan, _MaHoaDon, _TrangThai = "";

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

    public Panel_ChiTietHD_Ban() {
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
        txt_MaBan.setText(_MaBan);
        txtTrangThai.setText(TrangThai);
        _TrangThai = TrangThai;
        KTrangThai_btn_DatBan();
    }

    public void SetMaHoaDon(String MaHoaDon) {
        _MaHoaDon = MaHoaDon;
        txt_MaHoaDon.setText(MaHoaDon);
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
        } //nếu bàn trống chờ oder
        tbl_CT_HoaDon.setModel(tblModel_CTHoaDon);
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
        this.setSize(925, 440);
    }

    public void setTenBan(String TenBan) {
        _TenBan = TenBan;
        txt_TenBan.setText("Tên bàn: " + _TenBan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CT_HoaDon = new javax.swing.JTable();
        btn_Xoa = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        txt_TenBan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNuocUong = new javax.swing.JTable();
        cbx_LoaiNuocUong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_SL = new javax.swing.JSpinner();
        txt_MaBan = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JLabel();
        btn_ThanhToanHoaDon = new javax.swing.JButton();
        txt_MaBan1 = new javax.swing.JLabel();
        txt_MaHoaDon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_DatBan = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        tbl_CT_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_CT_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CT_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CT_HoaDon);

        btn_Xoa.setText(">");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Them.setText("<");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        txt_TenBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_TenBan.setText("Tên bàn");

        tblDSNuocUong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDSNuocUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDSNuocUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNuocUongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNuocUong);

        cbx_LoaiNuocUong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_LoaiNuocUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_LoaiNuocUongMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Loại đồ uống");

        txt_SL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_SL.setEditor(new javax.swing.JSpinner.NumberEditor(txt_SL, ""));
        txt_SL.setValue(1);

        txt_MaBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_MaBan.setText("Ma Bàn");

        txtTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTrangThai.setText("Trạng thái");

        btn_ThanhToanHoaDon.setText("Thanh Toán");
        btn_ThanhToanHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanHoaDonActionPerformed(evt);
            }
        });

        txt_MaBan1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_MaBan1.setText("Mã hóa đơn");

        txt_MaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_MaHoaDon.setText("Trạng thái");

        jButton1.setText("Chuyển bàn");
        jButton1.setMaximumSize(new java.awt.Dimension(91, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(91, 10));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_DatBan.setText("Đặt bàn");
        btn_DatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_DatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_SL, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_ThanhToanHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(txt_MaBan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(txt_MaBan1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_MaHoaDon)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_TenBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_LoaiNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TenBan)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_LoaiNuocUong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_MaBan)
                            .addComponent(txtTrangThai)
                            .addComponent(txt_MaBan1)
                            .addComponent(txt_MaHoaDon)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_SL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_DatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ThanhToanHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        boolean KT_ThongTin = KT_ThongTin();
        if (vitri_click_DSNuoc == -1) {
            ShowThongBao("Bạn chưa chọn nước");
        } else if (KT_ThongTin() == true && vitri_click_DSNuoc != -1) {
            if (tbl_CT_HoaDon.getRowCount() == 0) {
                //thêm mới hóa đơn
                //Lưu thông tin hóa đơn
                //String _MAHOADON, String _MANHANVIEN, String _TENHOADON, String _TRANGTHAI, String _MABAN, String _NGAYXUAT, String _GIOVAO
                String _maHoaDon_Temp = MyHelper.getMaHD();
                HOADON_DTO hd = new HOADON_DTO(_maHoaDon_Temp, "NV001", _MaBan, "CHUA THANH TOAN", _MaBan, Helper.MyHelper.getDate(), Helper.MyHelper.getDate() + " " + Helper.MyHelper.getTime());
                int kt = hoadon_bll.ThemHoaDon(hd);
                _MaHoaDon = _maHoaDon_Temp;
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
                    f.LoadTrangThaiBan();
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
        } else {
            ShowThongBao("Bạn chưa chọn bàn.");
        }
    }//GEN-LAST:event_btn_ThemActionPerformed
    int vitri_click_DSNuoc = -1;
    private void tblDSNuocUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNuocUongMouseClicked
        // TODO add your handling code here:
        vitri_click_DSNuoc = tblDSNuocUong.getSelectedRow();
    }//GEN-LAST:event_tblDSNuocUongMouseClicked

    private void cbx_LoaiNuocUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_LoaiNuocUongMouseClicked
        // TODO add your handling code here:
        //String TenLoai = cbx_LoaiNuocUong.getSelectedItem().toString();
        //String MaLoai =loaiThucUong_BLL.getMaLoaiThucUong(TenLoai);
        //LoadDSNuoc(MaLoai);
    }//GEN-LAST:event_cbx_LoaiNuocUongMouseClicked
    String MaLoai = "";
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        String TenLoai = cbx_LoaiNuocUong.getSelectedItem().toString();
        MaLoai = loaiThucUong_BLL.getMaLoaiThucUong(TenLoai);
        LoadDSNuoc(MaLoai);
    }//GEN-LAST:event_formMouseEntered
    int vitri_tblCTHoaDon = -1;
    private void tbl_CT_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CT_HoaDonMouseClicked
        // TODO add your handling code here:
        vitri_tblCTHoaDon = tbl_CT_HoaDon.getSelectedRow();
    }//GEN-LAST:event_tbl_CT_HoaDonMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
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
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_ThanhToanHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanHoaDonActionPerformed
        // TODO add your handling code here:
        int kt = hoadon_bll.ThanhToanHoaDon(_MaHoaDon, Helper.MyHelper.getDate() + " " + Helper.MyHelper.getTime());
        if (kt == 1) {
            ShowThongBao("Thanh Toán Thành Công" + _MaHoaDon);
            ban_bll.CapNhatTrangThai(_MaBan, "trong");
            //xuất report hóa đơn
            XuatHoaDon(_MaHoaDon);
        } else {
            ShowThongBao("Thanh Toán Thất Bại");
        }
    }//GEN-LAST:event_btn_ThanhToanHoaDonActionPerformed
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
            Logger.getLogger(Panel_ChiTietHD_Ban.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Dialog_HienThiDanhSachBan f = new Dialog_HienThiDanhSachBan(null, true);
        f.SetMaBan(_MaBan);
        f.SetMaHoaDon(_MaHoaDon);
        f.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_DatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatBanActionPerformed
        // TODO add your handling code here:
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DatBan;
    private javax.swing.JButton btn_ThanhToanHoaDon;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbx_LoaiNuocUong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDSNuocUong;
    private javax.swing.JTable tbl_CT_HoaDon;
    private javax.swing.JLabel txtTrangThai;
    private javax.swing.JLabel txt_MaBan;
    private javax.swing.JLabel txt_MaBan1;
    private javax.swing.JLabel txt_MaHoaDon;
    private javax.swing.JSpinner txt_SL;
    private javax.swing.JLabel txt_TenBan;
    // End of variables declaration//GEN-END:variables
}
