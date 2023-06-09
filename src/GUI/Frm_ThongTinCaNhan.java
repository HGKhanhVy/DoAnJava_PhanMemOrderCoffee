/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.QLNhanVienBLL;
import DTO.NhanVienDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author khanh
 */
public class Frm_ThongTinCaNhan extends javax.swing.JDialog {
    QLNhanVienBLL QLNhanVien = new QLNhanVienBLL();
    NhanVienDTO nv = new NhanVienDTO();
    String tk = null;
    /**
     * Creates new form Frm_ThongTinCaNhan
     */
    public void getTaiKhoan(String taiKhoan) {
        tk = taiKhoan;
        lbl_MaNV.setText(QLNhanVien.GetMaNV(tk));
        lbl_ChucVu.setText(QLNhanVien.GetChucVu(tk));
        lbl_TenNV.setText(QLNhanVien.GetNameNV(tk));
        lbl_GioiTinh.setText(QLNhanVien.GetGioiTinh(tk));
        lbl_DiaChi.setText(QLNhanVien.GetDiaChi(tk));
        lbl_SDT.setText(QLNhanVien.GetSDT(tk));
        lbl_TaiKhoan.setText(tk);
    }
    private Frm_QuanLy home;
    public Frm_ThongTinCaNhan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (Frm_QuanLy) parent;
        this.setTitle("Thông tin cá nhân");
    }
    public Frm_ThongTinCaNhan() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thông tin cá nhân");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_ThayDoiThongTin = new javax.swing.JButton();
        btn_DoiMK = new javax.swing.JButton();
        lbl_MaNV = new javax.swing.JLabel();
        lbl_TenNV = new javax.swing.JLabel();
        lbl_ChucVu = new javax.swing.JLabel();
        lbl_GioiTinh = new javax.swing.JLabel();
        lbl_DiaChi = new javax.swing.JLabel();
        lbl_SDT = new javax.swing.JLabel();
        lbl_TaiKhoan = new javax.swing.JLabel();
        btn_Thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Chức vụ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tên nhân viên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Giới tính:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số điện thoại:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tài khoản:");

        btn_ThayDoiThongTin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ThayDoiThongTin.setText("Thay đổi thông tin");
        btn_ThayDoiThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThayDoiThongTinActionPerformed(evt);
            }
        });

        btn_DoiMK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_DoiMK.setText("Đổi mật khẩu");
        btn_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMKActionPerformed(evt);
            }
        });

        lbl_MaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MaNV.setText("Mã nhân viên:");

        lbl_TenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TenNV.setText("Tên nhân viên:");

        lbl_ChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ChucVu.setText("Chức vụ:");

        lbl_GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_GioiTinh.setText("Giới tính:");

        lbl_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_DiaChi.setText("Địa chỉ:");

        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_SDT.setText("Số điện thoại:");

        lbl_TaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TaiKhoan.setText("Tài khoản:");

        btn_Thoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(26, 26, 26))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(21, 21, 21)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_DiaChi)
                            .addComponent(lbl_GioiTinh)
                            .addComponent(lbl_TenNV)
                            .addComponent(lbl_ChucVu)
                            .addComponent(lbl_MaNV)
                            .addComponent(lbl_TaiKhoan)
                            .addComponent(lbl_SDT)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_ThayDoiThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_MaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_ChucVu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_TenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_GioiTinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_DiaChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_SDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_TaiKhoan))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThayDoiThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMKActionPerformed
        FrmDia_DoiMatKhau frm = new FrmDia_DoiMatKhau(this, rootPaneCheckingEnabled);
        boolean isOK = true;
        String tenNV = "";
        String taikhoan = "";
        try {
            tenNV = lbl_TenNV.getText();
            taikhoan = lbl_TaiKhoan.getText();
        } catch (Exception e) {
            isOK = false;
        }
        if(isOK) {
            frm.getTK_MK(taikhoan, tenNV);
            this.dispose();
        }
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_DoiMKActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Quay lại trang quản lý ?", "Đăng xuất",JOptionPane.YES_NO_OPTION);
        if( n == JOptionPane.YES_OPTION)
        {
            Frm_QuanLy frm = new Frm_QuanLy();
            frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_ThayDoiThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThayDoiThongTinActionPerformed
        FrmDia_ThayDoiThongTin frm = new FrmDia_ThayDoiThongTin(this, rootPaneCheckingEnabled);
        boolean isOK = true;
        String taikhoan = "";
        try {
            taikhoan = tk;
        } catch (Exception e) {
            isOK = false;
        }
        if(isOK) {
            frm.getTaiKhoan(taikhoan);
            this.dispose();
        }
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThayDoiThongTinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongTinCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongTinCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongTinCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongTinCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_ThongTinCaNhan dialog = new Frm_ThongTinCaNhan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DoiMK;
    private javax.swing.JButton btn_ThayDoiThongTin;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_ChucVu;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_GioiTinh;
    private javax.swing.JLabel lbl_MaNV;
    private javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TaiKhoan;
    private javax.swing.JLabel lbl_TenNV;
    // End of variables declaration//GEN-END:variables
}
