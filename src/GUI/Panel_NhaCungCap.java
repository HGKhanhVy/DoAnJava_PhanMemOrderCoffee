/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.NhaCungCap_DTO;
import BLL.NHACUNGCAP_BLL;
import com.sun.glass.events.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caoth
 */
public class Panel_NhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form Panel_NhaCungCap
     */
    
    
    
    DefaultTableModel tblModel_NhaCungCap = new DefaultTableModel();
    NHACUNGCAP_BLL nccBLL = new NHACUNGCAP_BLL();
    ArrayList<NhaCungCap_DTO> lstNCC = new ArrayList<NhaCungCap_DTO>();
    
    
    public Panel_NhaCungCap() {
        initComponents();
        loadTable();
    }
    
   
    public void loadTable()
    {
        tblModel_NhaCungCap.setRowCount(0);
        tblModel_NhaCungCap.setColumnIdentifiers(nccBLL.showTitle());
        lstNCC = nccBLL.getALL();
        for (NhaCungCap_DTO items : lstNCC) {
           tblModel_NhaCungCap.addRow(new Object[]{
                    items.getMANHACUNGCAP(), items.getTENNHACUNGCAP(), items.getDIACHI(), items.getSDT()
                });
        }
        tbl_NCC.setModel(tblModel_NhaCungCap);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_diachi = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_mancc = new javax.swing.JTextField();
        txt_tenncc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NCC = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));

        btn_add.setBackground(new java.awt.Color(255, 204, 204));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 204, 204));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 204, 204));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png"))); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new java.awt.Color(255, 204, 204));
        btn_huy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/huy.png"))); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mã Nhà Cung Cấp: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tên Nhà Cung Cấp:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Địa chỉ: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SDT:");

        tbl_NCC.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NCCMouseClicked(evt);
            }
        });
        tbl_NCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_NCCKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NCC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenncc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mancc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_mancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_add)
                        .addComponent(btn_delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_tenncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_update)
                        .addComponent(btn_huy)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    int vitri=-1;
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        String ma, ten, diachi, sdt;
        ma=txt_mancc.getText();
     
        
        if (ma==null) {
            JOptionPane.showConfirmDialog(null, "Bạn chưa chọn NCC để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
        } else {
            String maNCC = ma;
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                int kt = nccBLL.delete_NCC(maNCC);
                if (kt == 1) {
                    JOptionPane.showConfirmDialog(null, "Thành Công", "Thông báo", JOptionPane.DEFAULT_OPTION);
                    loadTable();
                } else {
                    JOptionPane.showConfirmDialog(null, "Thất bại", "Thông báo", JOptionPane.DEFAULT_OPTION);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        txt_mancc.setText("");
        txt_tenncc.setText("");
        txt_diachi.setText("");
        txt_sdt.setText("");
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        String ma, ten, diachi, sdt;
        ma=txt_mancc.getText();
        ten=txt_tenncc.getText();
        diachi=txt_diachi.getText();
        sdt=txt_sdt.getText();
        
        NhaCungCap_DTO ncc = new NhaCungCap_DTO(ma.toString().trim(), ten.toString().trim(), diachi.toString().trim(), sdt.toString().trim());
        String kt = nccBLL.insert_NCC(ncc);
        JOptionPane.showConfirmDialog(null, kt, "Thông báo", JOptionPane.DEFAULT_OPTION);
        loadTable();
        
    }//GEN-LAST:event_btn_addActionPerformed

    
    private void tbl_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NCCMouseClicked
        // TODO add your handling code here:
        int vt=tbl_NCC.getSelectedRow();
        display(vt);
        
    }//GEN-LAST:event_tbl_NCCMouseClicked

    public void display(int select)
    {
        int vt=tbl_NCC.getSelectedRow();
        //Vector vct = (Vetor)
        
        txt_mancc.setText(tbl_NCC.getValueAt(vt, 0).toString());
        txt_tenncc.setText(tbl_NCC.getValueAt(vt, 1).toString());
        txt_diachi.setText(tbl_NCC.getValueAt(vt, 2).toString());
        txt_sdt.setText(tbl_NCC.getValueAt(vt, 3).toString());
    }
    
    private void tbl_NCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_NCCKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            int selectedIndex= tbl_NCC.getSelectedRow();
            display(selectedIndex);
        }
        
    }//GEN-LAST:event_tbl_NCCKeyReleased

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        
        String ma, ten, diachi, sdt;
        ma=txt_mancc.getText();
        ten=txt_tenncc.getText();
        diachi=txt_diachi.getText();
        sdt=txt_sdt.getText();
        
        NhaCungCap_DTO ncc = new NhaCungCap_DTO(ma.toString().trim(), ten.toString().trim(), diachi.toString().trim(), sdt.toString().trim());
        String kt = nccBLL.Update_NCC(ncc);
        JOptionPane.showConfirmDialog(null, kt, "Thông báo", JOptionPane.DEFAULT_OPTION);
        loadTable();
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_NCC;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_mancc;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenncc;
    // End of variables declaration//GEN-END:variables
}