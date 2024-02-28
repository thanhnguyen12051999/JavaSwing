/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.NhanVien;
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
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.Flags;

/**
 *
 * @author HP
 */
public class frmNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form frmNhanVien
     */
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    NhanVien nv = new NhanVien();
    ArrayList<NhanVien> listNV = new ArrayList<>();
    public frmNhanVien() {
        loadFile();
        initComponents();
        getData(listNV);
    }
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNV = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhanvien.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(arr[0]);
                    nv.setHoTen(arr[1]);
                    nv.setSoDienThoai(arr[2]);
                    nv.setEmail(arr[3]);
                    nv.setMatKhau(arr[4]);
                    nv.setNhom(Integer.parseInt(arr[5]));
                    nv.setGioiTinh(arr[6]);
                    nv.setTrangThai(Integer.parseInt(arr[7]));
                    listNV.add(nv);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    private void getData(ArrayList<NhanVien> listNV) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Họ tên NV");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");
        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Trạng Thái");

        for (NhanVien obj : listNV) {
            Vector vector = new Vector();
            vector.add(obj.getMaNhanVien());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getEmail());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_nhanvien.setModel(defaultTableModel);
    }
    
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNV.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listNV.get(i).getMaNhanVien() + "\t";
                row = row + listNV.get(i).getHoTen() + "\t";
                row = row + listNV.get(i).getSoDienThoai() + "\t";
                row = row + listNV.get(i).getEmail() + "\t";
                row = row + listNV.get(i).getMatKhau() + "\t";
                row = row + listNV.get(i).getNhom() + "\t";
                row = row + listNV.get(i).getGioiTinh() + "\t";
                row = row + listNV.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("nhanvien.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean KTMaNV(String maNV){
        loadFile();
        boolean flag = false;
        for (int i = 0; i < listNV.size(); i++) {
            if (maNV.equalsIgnoreCase(listNV.get(i).getMaNhanVien())) {
                flag = true;
                break;
            }
        }
        return flag;
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
        tbl_nhanvien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_matkhau = new javax.swing.JPasswordField();
        txt_nhomnv = new javax.swing.JComboBox<>();
        txt_hoten = new javax.swing.JTextField();
        txt_gioitinh = new javax.swing.JComboBox<>();
        txt_email = new javax.swing.JTextField();
        txt_trangthai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_thoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(null);

        tbl_nhanvien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 720, 1880, 230);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã NV:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Họ và Tên:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Nhóm NV:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giới Tính:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Mật Khẩu:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Trạng Thái:");

        txt_manv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_sdt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_matkhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_nhomnv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_nhomnv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));

        txt_hoten.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_gioitinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_trangthai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Đã khóa" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_manv)
                            .addComponent(txt_matkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(txt_nhomnv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nhomnv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33))
        );

        add(jPanel1);
        jPanel1.setBounds(130, 220, 710, 410);

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
                .addGap(35, 35, 35)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_timkiem)
                    .addComponent(btn_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(1220, 260, 420, 83);

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-list-add-user-icon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        add(btn_them);
        btn_them.setBounds(1250, 410, 158, 70);

        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-icon.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setMaximumSize(new java.awt.Dimension(101, 33));
        btn_xoa.setMinimumSize(new java.awt.Dimension(101, 33));
        btn_xoa.setPreferredSize(new java.awt.Dimension(101, 33));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        add(btn_xoa);
        btn_xoa.setBounds(1480, 410, 160, 70);

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pencil-icon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setMaximumSize(new java.awt.Dimension(101, 33));
        btn_sua.setMinimumSize(new java.awt.Dimension(101, 33));
        btn_sua.setPreferredSize(new java.awt.Dimension(101, 33));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        add(btn_sua);
        btn_sua.setBounds(1250, 550, 158, 70);

        btn_thoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users-Exit-icon.png"))); // NOI18N
        btn_thoa.setText("Thoát");
        btn_thoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoaActionPerformed(evt);
            }
        });
        add(btn_thoa);
        btn_thoa.setBounds(1480, 550, 160, 70);

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(747, 747, 747)
                .addComponent(jLabel9)
                .addContainerGap(837, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(33, 33, 33))
        );

        add(jPanel3);
        jPanel3.setBounds(0, 0, 1960, 110);

        jLabel10.setIcon(new javax.swing.ImageIcon("E:\\F\\img_gabi.jpg")); // NOI18N
        add(jLabel10);
        jLabel10.setBounds(710, 0, 1950, 950);
    }// </editor-fold>//GEN-END:initComponents

   
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
         int dem = 0;
        String maNV = txt_manv.getText();
        String tenNV = txt_hoten.getText();
        String email = txt_email.getText();
        String sdt = txt_sdt.getText();
        String matKhau = txt_matkhau.getText();
        String gioiTinh = "";
        if (txt_gioitinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        }else{
            gioiTinh = "Nữ";
        }
        int nhom = 0;
        if (txt_nhomnv.getSelectedItem().toString().equals("Quản lý")) {
            nhom = 1;
        }else{
            nhom = 0;
        }
        int trangThai = 0;
        if (txt_trangthai.getSelectedItem().toString().equals("Hoạt động")) {
            trangThai = 1;
        }else{
            trangThai = 0;
        }
        if (maNV.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            return;
        }else if (KTMaNV(maNV)){
            dem++;
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại !");
            return;
        }else{
            nv.setMaNhanVien(txt_manv.getText());
        }
        if (tenNV.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống !");
            return;
        }else{
            if (validate.check_ten(tenNV)) {
                dem++;
                JOptionPane.showMessageDialog(this, "Tên nhân viên không được chứa số !");
                return;
            }
            else{
                nv.setHoTen(txt_hoten.getText());
            }
        }
        if (sdt.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            return;
        }else{
            if (validate.check_sdt(sdt)) {
                dem++;
                JOptionPane.showMessageDialog(this, "Số điện thoại phải >= 10 và <= 11 chữ số !");
                return;
            }else{
                nv.setHoTen(txt_hoten.getText());
            }
        }
        if (email.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Email không được để trống !");
            return;
        }else {
            if (!validate.check_email(email)) {
            dem++;
            JOptionPane.showMessageDialog(this, "Email sai, vui lòng nhập lại theo định dạng abc@xxx.com");
            return;
            }else{
            nv.setEmail(txt_email.getText());
            }
            
           
            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(maNV);
            nv.setHoTen(tenNV);
            nv.setEmail(email);
            nv.setGioiTinh(gioiTinh);
            nv.setMatKhau(validate.md5(matKhau));
            nv.setNhom(nhom);
            nv.setSoDienThoai(sdt);
            nv.setTrangThai(trangThai);
            listNV.add(nv);
            saveFile();
            getData(listNV);
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công !");
            reset();
            }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timkiem.getText();
        if (tuKhoa.equals("")) {
            getData(listNV);
        }else{
            ArrayList<NhanVien> ListResult = new ArrayList<>();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getHoTen().contains(tuKhoa) || listNV.get(i).getMaNhanVien().contains(tuKhoa) 
                                                              || listNV.get(i).getSoDienThoai().contains(tuKhoa) 
                                                              || listNV.get(i).getEmail().contains(tuKhoa)) {
                    ListResult.add(listNV.get(i));
                }
            }
            getData(ListResult);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    int index;
    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        // TODO add your handling code here:
        int row = tbl_nhanvien.getSelectedRow();        
        String maNV = tbl_nhanvien.getValueAt(row, 0).toString();
        for (int i = 0; i < listNV.size(); i++) {
            if (maNV.equals(listNV.get(i).getMaNhanVien())) {
                nv = listNV.get(i);
                index = i;
                break;
            }
        }
        btn_them.setEnabled(false);
        txt_matkhau.setEnabled(false);
        txt_manv.setText(nv.getMaNhanVien());
        txt_hoten.setText(nv.getHoTen());
        txt_sdt.setText(nv.getSoDienThoai());
        txt_email.setText(nv.getEmail());
        
        if (nv.getGioiTinh().equals("Nam")) {
            txt_gioitinh.setSelectedItem("Nam");
        }else{
            txt_gioitinh.setSelectedItem("Nữ");
        }
        if (nv.getNhom() == 1) {
            txt_nhomnv.setSelectedItem("Quản lý");
        }else{
            txt_nhomnv.setSelectedItem("Nhân viên");
        }
        if (nv.getTrangThai() == 1) {
            txt_trangthai.setSelectedItem("Hoạt động");
        }else{
            txt_trangthai.setSelectedItem("Đã khóa");
        }
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int dem = 0;
        String maNV = txt_manv.getText();
        String tenNV = txt_hoten.getText();
        String email = txt_email.getText();
        String sdt = txt_sdt.getText();
        String matKhau = txt_matkhau.getText();
        String gioiTinh = "";
        if (txt_gioitinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        }else{
            gioiTinh = "Nữ";
        }
        int nhom = 0;
        if (txt_nhomnv.getSelectedItem().toString().equals("Quản lý")) {
            nhom = 1;
        }else{
            nhom = 0;
        }
        int trangThai = 0;
        if (txt_trangthai.getSelectedItem().toString().equals("Hoạt động")) {
            trangThai = 1;
        }else{
            trangThai = 0;
        }
       
        if (tenNV.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống !");
            return;
        }else{
            if (validate.check_ten(tenNV)) {
                dem++;
                JOptionPane.showMessageDialog(this, "Tên nhân viên không được chứa số !");
                return;
            }
            else{
                nv.setHoTen(txt_hoten.getText());
            }
        }
        if (sdt.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            return;
        }else{
            if (validate.check_sdt(sdt)) {
                dem++;
                JOptionPane.showMessageDialog(this, "Số điện thoại phải >= 10 và <= 11 chữ số !");
                return;
            }else{
                nv.setHoTen(txt_hoten.getText());
            }
        }
        if (email.equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Email không được để trống !");
            return;
        }else{
            if (!validate.check_email(email)) {
                dem++;
                JOptionPane.showMessageDialog(this, "Email chưa đúng định dạng abc@xxx.com !");
            }else{
                nv.setEmail(txt_email.getText());
            }
        }   
        NhanVien nv = new NhanVien();
            nv.setMaNhanVien(maNV);
            nv.setHoTen(tenNV);
            nv.setEmail(email);
            nv.setGioiTinh(gioiTinh);
            nv.setMatKhau(validate.md5(matKhau));
            nv.setNhom(nhom);
            nv.setSoDienThoai(sdt);
            nv.setTrangThai(trangThai);
        
            if (dem == 0) {
                listNV.set(index, nv);
                saveFile();
                getData(listNV);
                
                JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                reset();
            }else{
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confim = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không ?", "Xóa", 2);
        if (confim == JOptionPane.YES_OPTION) {
            if (listNV.remove(nv)) {
                saveFile();
                getData(listNV);
                reset();
                JOptionPane.showMessageDialog(this, "Xóa thành công nhân viên" + nv.getHoTen());
            }else{
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại !");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_thoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoaActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);

    }//GEN-LAST:event_btn_thoaActionPerformed


    public void reset(){
        txt_email.setText("");
        txt_manv.setText("");
        txt_matkhau.setText("");
        txt_hoten.setText("");
        txt_sdt.setText("");
        txt_nhomnv.setSelectedIndex(0);
        txt_gioitinh.setSelectedIndex(0);
        txt_trangthai.setSelectedIndex(0);
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        txt_manv.setEnabled(true);
        txt_matkhau.setEnabled(true);
        
        getData(listNV);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoa;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox<String> txt_gioitinh;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JPasswordField txt_matkhau;
    private javax.swing.JComboBox<String> txt_nhomnv;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JComboBox<String> txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
