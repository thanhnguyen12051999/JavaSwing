/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import OBJ.SanPham;
import Utils.ValidateData;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class frmSanPham extends javax.swing.JPanel {

    /**
     * Creates new form frmSanPham
     */
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    
    SanPham sp = new SanPham();
    ArrayList<SanPham> listSP = new ArrayList<>();
    public frmSanPham() {
        loadFile();
        initComponents();
        getData(listSP);
    }
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSP = new ArrayList<>(); //lưu ý
            fr = new FileReader("sanpham.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    SanPham sp = new SanPham() {};
                    sp.setMaSanPham(arr[0]);
                    sp.setTenSanPham(arr[1]);
                    sp.setDonViTinh(arr[2]);
                    sp.setTenNSX(arr[3]);
                    sp.setGiaNhap(arr[4]);
                    sp.setGiaBan(arr[5]);
                    sp.setSoLuong(Integer.parseInt(arr[6]));
                    listSP.add(sp);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    private void getData(ArrayList<SanPham> listSP) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn vi tính");
        defaultTableModel.addColumn("Tên NSX");
        defaultTableModel.addColumn("Giá nhập");
        defaultTableModel.addColumn("Giá bán");
        defaultTableModel.addColumn("Số lượng");

        for (SanPham obj : listSP) {
            Vector vector = new Vector();
            vector.add(obj.getMaSanPham());
            vector.add(obj.getTenSanPham());
            vector.add(obj.getDonViTinh());
            vector.add(obj.getTenNSX());
            vector.add(obj.getGiaNhap());
            vector.add(obj.getGiaBan());
            vector.add(obj.getSoLuong());
            defaultTableModel.addRow(vector);
            
        }
        tbl_sanpham.setModel(defaultTableModel);
    }
    
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSP .size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listSP.get(i).getMaSanPham()+ "\t";
                row = row + listSP.get(i).getTenSanPham()+ "\t";
                row = row + listSP.get(i).getDonViTinh()+ "\t";
                row = row + listSP.get(i).getTenNSX()+ "\t";
                row = row + listSP.get(i).getGiaNhap()+ "\t";
                row = row + listSP.get(i).getGiaBan()+ "\t";
                row = row + listSP.get(i).getSoLuong()+ "\n";
                data += row;
            }
            fw = new FileWriter("sanpham.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean KTMaSP(String maSP){
        loadFile();
        boolean flag = false;
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equalsIgnoreCase(listSP.get(i).getMaSanPham())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean kiemTraSo(String so){
        try{
            if (Integer.parseInt(so) > 0) {
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            return true;
        }
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
        tbl_sanpham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_masanpham = new javax.swing.JTextField();
        txt_donvitinh = new javax.swing.JTextField();
        txt_gianhap = new javax.swing.JTextField();
        txt_tensanpham = new javax.swing.JTextField();
        txt_tennsx = new javax.swing.JTextField();
        txt_giaban = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(null);

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanpham);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 721, 1860, 230);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã SP:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 80, 57, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên SP:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(440, 80, 60, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Đơn vị tính:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 180, 93, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Tên NSX:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(440, 180, 74, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Giá Nhập:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 270, 80, 22);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Giá Bán:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(440, 270, 69, 22);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Số lượng:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 350, 75, 22);

        txt_masanpham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_masanpham);
        txt_masanpham.setBounds(150, 60, 240, 40);

        txt_donvitinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_donvitinh);
        txt_donvitinh.setBounds(150, 160, 240, 41);

        txt_gianhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_gianhap);
        txt_gianhap.setBounds(150, 250, 240, 38);

        txt_tensanpham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_tensanpham);
        txt_tensanpham.setBounds(540, 60, 250, 40);

        txt_tennsx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_tennsx);
        txt_tennsx.setBounds(540, 160, 250, 43);

        txt_giaban.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_giaban);
        txt_giaban.setBounds(540, 250, 250, 38);

        txt_soluong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txt_soluong);
        txt_soluong.setBounds(150, 340, 240, 36);

        add(jPanel1);
        jPanel1.setBounds(40, 210, 810, 480);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204))); // NOI18N

        txt_timkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-2-icon.png"))); // NOI18N
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_timkiem)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(1190, 230, 490, 80);

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-list-add-user-icon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        add(btn_them);
        btn_them.setBounds(1200, 410, 180, 70);

        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-icon.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        add(btn_xoa);
        btn_xoa.setBounds(1500, 410, 170, 70);

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pencil-icon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        add(btn_sua);
        btn_sua.setBounds(1200, 540, 170, 70);

        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users-Exit-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat);
        btn_thoat.setBounds(1500, 540, 170, 70);

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(610, 610, 610)
                .addComponent(jLabel8)
                .addContainerGap(985, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(0, 0, 1959, 116);

        jLabel9.setIcon(new javax.swing.ImageIcon("E:\\icon\\126439359_3263613160589309_1782703457098946434_n.jpg")); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(430, -20, 2020, 960);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confim = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không ?", "Xóa", 2);
        if (confim == JOptionPane.YES_OPTION) {
            if (listSP.remove(sp)) {
               saveFile ();
                getData(listSP);
                reset();
                JOptionPane.showMessageDialog(this, "Xóa thành công sản phẩm " + sp.getTenSanPham());
            }else{
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại !");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        String maSP = txt_masanpham.getText();
        String tenSP = txt_tensanpham.getText();
        String tenNSX =txt_tennsx.getText();
        String donViTinh = txt_donvitinh.getText();
        String giaNhap = txt_gianhap.getText();
        String giaBan = txt_giaban.getText();
        String soLuong = txt_soluong.getText();
        int dem = 0;
        if (maSP.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống !");
            return;
        }else if (KTMaSP(maSP)){
            dem++;
            JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại !");
            return;
        }else{
            sp.setMaSanPham(txt_masanpham.getText());
        }
        if (soLuong.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống !");
            return;
        }else if (kiemTraSo(soLuong)) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !");
            return;
        }else{
            sp.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        }
            SanPham sp = new SanPham();
            sp.setDonViTinh(donViTinh);
            sp.setGiaBan(giaBan);
            sp.setGiaNhap(giaNhap);
            sp.setMaSanPham(maSP);
            sp.setSoLuong(Integer.parseInt(soLuong));
            sp.setTenNSX(tenNSX);
            sp.setTenSanPham(tenSP);
            
            listSP.add(sp);
            saveFile();
            getData(listSP);
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công !");
            reset();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timkiem.getText();
        if (tuKhoa.equals("")) {
            getData(listSP);
        }else{
            ArrayList<SanPham> ListResult = new ArrayList<>();
            for (int i = 0; i < listSP.size(); i++) {
                if (listSP.get(i).getMaSanPham().contains(tuKhoa) 
                        || listSP.get(i).getTenSanPham().contains(tuKhoa) 
                        || listSP.get(i).getTenNSX().contains(tuKhoa)) {
                    
                    ListResult.add(listSP.get(i));
                }
            }
            getData(ListResult);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    int index;
    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        // TODO add your handling code here:
        int row = tbl_sanpham.getSelectedRow();        
        String maSP = tbl_sanpham.getValueAt(row, 0).toString();
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSanPham())) {
                sp = listSP.get(i);
                index = i;
                break;
            }
        }
        btn_them.setEnabled(false);
        txt_masanpham.setEnabled(false);
        txt_masanpham.setText(sp.getMaSanPham());
        txt_tensanpham.setText(sp.getTenSanPham());
        txt_tennsx.setText(sp.getTenNSX());
        txt_donvitinh.setText(sp.getDonViTinh());
        txt_soluong.setText(String.valueOf(sp.getSoLuong()));
        txt_giaban.setText(String.valueOf(sp.getGiaBan()));
        txt_gianhap.setText(String.valueOf(sp.getGiaNhap()));
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:

        String maSP = txt_masanpham.getText();
        String tenSP = txt_tensanpham.getText();
        String tenNSX =txt_tennsx.getText();
        String donViTinh = txt_donvitinh.getText();
        String giaNhap = txt_gianhap.getText();
        String giaBan = txt_giaban.getText();
        String soLuong = txt_soluong.getText();
        int dem = 0;
        
        if (maSP.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống !");
            return;
        }else if (KTMaSP(maSP)){
            dem++;
            JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại !");
            return;
        }else{
            sp.setMaSanPham(txt_masanpham.getText());
        }
        if (soLuong.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống !");
            return;
        }else if (kiemTraSo(soLuong)) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !");
            return;
        }else{
            sp.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        }
            SanPham sp = new SanPham();
            sp.setDonViTinh(donViTinh);
            sp.setGiaBan(giaBan);
            sp.setGiaNhap(giaNhap);
            sp.setMaSanPham(maSP);
            sp.setSoLuong(Integer.parseInt(soLuong));
            sp.setTenNSX(tenNSX);
            sp.setTenSanPham(tenSP);
            
            
            if (dem == 0) {
                listSP.set(index, sp);
                saveFile();
                getData(listSP);
                
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công !");
                reset();
            }else{
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thất bại !");
            }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);
    }//GEN-LAST:event_btn_thoatActionPerformed


    public void reset(){
        txt_donvitinh.setText("");
        txt_giaban.setText("");
        txt_gianhap.setText("");
        txt_masanpham.setText("");
        txt_soluong.setText("");
        txt_tennsx.setText("");
        txt_tensanpham.setText("");
        txt_timkiem.setText("");

        
        getData(listSP);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_donvitinh;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_masanpham;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tennsx;
    private javax.swing.JTextField txt_tensanpham;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
