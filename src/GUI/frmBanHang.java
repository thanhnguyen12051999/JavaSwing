/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.HoaDon;
import OBJ.KhachHang;
import OBJ.SanPham;
import Utils.ValidateData;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
 
 

/**
 *
 * @author HP
 */
public class frmBanHang extends javax.swing.JPanel {

    /**
     * Creates new form frmBanHang
     */
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    KhachHang kh = new KhachHang();
    ArrayList<KhachHang> listKH = new ArrayList<>();
   
    SanPham sp = new SanPham();
    ArrayList<HoaDon> listGioHang = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###");
    int index;
    private ArrayList<Object> listSP;
    
    public frmBanHang() {
        initComponents();
        getDataKhachHang(loadKH());
        getDataSanPham(loadSP());
        txt_nhanvien.setText(frmLogin.userName);
        btn_thanhtoan.setEnabled(false);
    }
    public ArrayList<KhachHang> loadKH(){
        frmKhachHang frm_KhachHang = new frmKhachHang();
        return frm_KhachHang.listKH;
        
    }
    
    public ArrayList<SanPham> loadSP(){
        frmSanPham frmSanPham = new frmSanPham();
        return frmSanPham.listSP;
    }
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSP = new ArrayList<>(); //lưu ý
            fr = new FileReader("hoadon.txt");
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
                    sp.setSoLuong(Integer.parseInt(arr[2]));
                    sp.setGiaBan(arr[3]);
                    listSP.add(sp);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    private void getDataKhachHang(ArrayList<KhachHang> listKH) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã KH");
        defaultTableModel.addColumn("Họ tên KH");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số Điện Thoại");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Trạng Thái");

        for (KhachHang obj : listKH) {
            Vector vector = new Vector();
            vector.add(obj.getMaKhachHang());
            vector.add(obj.getHoTen());
            vector.add(obj.getDiaChi());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getEmail());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_bangkhachhang.setModel(defaultTableModel);
    }

    private void getDataSanPham(ArrayList<SanPham> listSP) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
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
        tbl_bangsanpham.setModel(defaultTableModel);
    }
    public void saveFile(){
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            String data = "";
            for (int i = 0; i < listGioHang.size(); i++) {
                String row = "";
                row = row + listGioHang.get(i).getMaHD() + "\t";
                row = row + listGioHang.get(i).getMaNV()+ "\t";
                row = row + listGioHang.get(i).getMaKH()+ "\t";
                row = row + listGioHang.get(i).getMaSP()+ "\t";
                row = row + listGioHang.get(i).getSoLuong()+ "\t";
                row = row + listGioHang.get(i).getDonGia()+ "\t";
                row = row + listGioHang.get(i).getThanhTien()+ "\t";
                row = row + listGioHang.get(i).getNgayBan()+ "\n";
                data += row;
            }
            fw = new FileWriter("hoadon.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        }catch (IOException ex){
            Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bangkhachhang = new javax.swing.JTable();
        txt_khachhang = new javax.swing.JTextField();
        txt_timkiemKH = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_giohang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_xoagiohang = new javax.swing.JButton();
        txt_tongtien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        txt_makh = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JLabel();
        txt_email = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bangsanpham = new javax.swing.JTable();
        txt_sanpham = new javax.swing.JTextField();
        btn_timkiemSP = new javax.swing.JButton();
        txt_sl = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        btn_themvaogiohang = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_nhanvien = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(null);

        tbl_bangkhachhang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_bangkhachhang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_bangkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bangkhachhang);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(6, 150, 878, 153);

        txt_khachhang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_khachhangActionPerformed(evt);
            }
        });
        jPanel1.add(txt_khachhang);
        txt_khachhang.setBounds(71, 78, 530, 35);

        txt_timkiemKH.setBackground(new java.awt.Color(255, 255, 255));
        txt_timkiemKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_timkiemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-2-icon.png"))); // NOI18N
        txt_timkiemKH.setText("Tìm Kiếm");
        txt_timkiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemKHActionPerformed(evt);
            }
        });
        jPanel1.add(txt_timkiemKH);
        txt_timkiemKH.setBounds(642, 78, 140, 35);

        jLabel13.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 30, 890, 280);

        add(jPanel1);
        jPanel1.setBounds(40, 140, 890, 310);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_giohang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_giohang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_giohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_giohangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_giohang);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 850, 238));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã KH: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 71, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Số điện thoại: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 155, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Địa chỉ: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 231, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Họ và Tên: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 71, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Email: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 155, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-icon.png"))); // NOI18N
        jLabel6.setText("Giỏ hàng: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 300, -1, -1));

        btn_xoagiohang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_xoagiohang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-icon.png"))); // NOI18N
        btn_xoagiohang.setText("Xóa khỏi giỏ hàng");
        btn_xoagiohang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoagiohangActionPerformed(evt);
            }
        });
        jPanel2.add(btn_xoagiohang, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, -1, 50));

        txt_tongtien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_tongtien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money-icon.png"))); // NOI18N
        txt_tongtien.setText("Tổng tiền: ");
        jPanel2.add(txt_tongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 644, -1, 50));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("(VND)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, 40));

        btn_thanhtoan.setBackground(new java.awt.Color(255, 255, 255));
        btn_thanhtoan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_thanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay-per-click-icon.png"))); // NOI18N
        btn_thanhtoan.setText("Thanh Toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });
        jPanel2.add(btn_thanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 730, -1, 50));

        btn_thoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users-Exit-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 730, -1, 50));

        txt_makh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_makh.setText(".......................");
        jPanel2.add(txt_makh, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 71, -1, -1));

        txt_sdt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_sdt.setText(".......................");
        jPanel2.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 155, -1, -1));

        txt_diachi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_diachi.setText(".......................");
        jPanel2.add(txt_diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 231, -1, -1));

        txt_hoten.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_hoten.setText("...............................");
        jPanel2.add(txt_hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 71, -1, -1));

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_email.setText("...............................");
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 155, -1, -1));

        lbl_tongtien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_tongtien.setText("..............");
        jPanel2.add(lbl_tongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 70, -1));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 770));

        add(jPanel2);
        jPanel2.setBounds(990, 140, 860, 798);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(null);

        tbl_bangsanpham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_bangsanpham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_bangsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangsanphamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bangsanpham);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 160, 878, 218);

        txt_sanpham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(txt_sanpham);
        txt_sanpham.setBounds(80, 70, 537, 40);

        btn_timkiemSP.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiemSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_timkiemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-2-icon.png"))); // NOI18N
        btn_timkiemSP.setText("Tìm Kiếm");
        btn_timkiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemSPActionPerformed(evt);
            }
        });
        jPanel3.add(btn_timkiemSP);
        btn_timkiemSP.setBounds(660, 70, 150, 40);

        txt_sl.setBackground(new java.awt.Color(204, 204, 204));
        txt_sl.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_sl.setForeground(new java.awt.Color(51, 51, 51));
        txt_sl.setText("Số Lượng: ");
        jPanel3.add(txt_sl);
        txt_sl.setBounds(240, 400, 120, 30);

        txt_soluong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soluongActionPerformed(evt);
            }
        });
        jPanel3.add(txt_soluong);
        txt_soluong.setBounds(390, 400, 27, 30);

        btn_themvaogiohang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_themvaogiohang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cart-icon.png"))); // NOI18N
        btn_themvaogiohang.setText("Thêm vào giỏ hàng");
        btn_themvaogiohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themvaogiohangMouseClicked(evt);
            }
        });
        btn_themvaogiohang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themvaogiohangActionPerformed(evt);
            }
        });
        jPanel3.add(btn_themvaogiohang);
        btn_themvaogiohang.setBounds(640, 410, 199, 40);
        jPanel3.add(jLabel12);
        jLabel12.setBounds(0, 30, 890, 440);

        add(jPanel3);
        jPanel3.setBounds(40, 470, 890, 470);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("HÓA ĐƠN BÁN HÀNG");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Nhân Viên :");

        txt_nhanvien.setBackground(new java.awt.Color(255, 204, 255));
        txt_nhanvien.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        txt_nhanvien.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(795, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(365, 365, 365)
                .addComponent(jLabel11)
                .addGap(37, 37, 37)
                .addComponent(txt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        add(jPanel4);
        jPanel4.setBounds(0, 0, 1960, 122);

        jLabel10.setBackground(new java.awt.Color(255, 204, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/store-832188_1920.jpg"))); // NOI18N
        add(jLabel10);
        jLabel10.setBounds(0, 90, 1950, 950);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_khachhangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_khachhangActionPerformed

    private void tbl_bangkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangkhachhangMouseClicked
        // TODO add your handling code here:
        int row = tbl_bangkhachhang.getSelectedRow();
        String maKH = tbl_bangkhachhang.getValueAt(row, 0).toString();
        ArrayList<KhachHang> listKH = loadKH();
        for (int i = 0; i < loadKH().size(); i++) {
            if (maKH.equals(loadKH().get(i).getMaKhachHang())) {
                kh = loadKH().get(i);
                index = i;
                break;
            }
        }
        txt_makh.setText(kh.getMaKhachHang());
        txt_hoten.setText(kh.getHoTen());
        txt_diachi.setText(kh.getDiaChi());
        txt_email.setText(kh.getEmail());
        txt_sdt.setText(kh.getSoDienThoai());
    }//GEN-LAST:event_tbl_bangkhachhangMouseClicked

    private void txt_timkiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemKHActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_khachhang.getText();
        if (tuKhoa.equals("")) {
            getDataKhachHang(loadKH());
        }else{
            ArrayList<KhachHang> ListResult = new ArrayList<>();
            for (int i = 0; i < loadKH().size(); i++) {
                if (loadKH().get(i).getHoTen().contains(tuKhoa) || loadKH().get(i).getMaKhachHang().contains(tuKhoa) || loadKH().get(i).getSoDienThoai().contains(tuKhoa) || loadKH().get(i).getEmail().contains(tuKhoa)) {
                    ListResult.add(loadKH().get(i));
                }
                getDataKhachHang(ListResult);
            }
        }
    }//GEN-LAST:event_txt_timkiemKHActionPerformed

    String maSP;
    private void tbl_giohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_giohangMouseClicked
        // TODO add your handling code here:
        int row = tbl_giohang.getSelectedRow();
        maSP = tbl_giohang.getValueAt(row, 0).toString();
        
    }//GEN-LAST:event_tbl_giohangMouseClicked

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);

    }//GEN-LAST:event_btn_thoatActionPerformed

    double tongTien = 0;
    private void btn_themvaogiohangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themvaogiohangActionPerformed
        // TODO add your handling code here:
        
        int soLuongMua = Integer.parseInt(txt_soluong.getText());
        if (soLuongMua <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng hàng phải > 0 ");
        }else if (soLuongMua > sp.getSoLuong()){
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm lớn hơn trong kho!");
        }else{
            HoaDon hd = new HoaDon();
            hd.setMaSP(sp.getMaSanPham());
            hd.setSoLuong(soLuongMua);
            hd.setDonGia(Double.parseDouble(sp.getGiaBan()));
            hd.setThanhTien(soLuongMua*Double.parseDouble(sp.getGiaBan()));
            if (checkSPExistGioHang(hd.getMaSP(), listGioHang)) {
                HoaDon hoaDon = listGioHang.get(indexMaSPTrungTrongGioHang);
                hoaDon.setSoLuong(Integer.parseInt(txt_soluong.getText()) + hoaDon.getSoLuong());
                hoaDon.setThanhTien(hoaDon.getSoLuong() * hd.getDonGia());
                listGioHang.set(indexMaSPTrungTrongGioHang, hoaDon);
            }else{
                listGioHang.add(hd);
                
            }
            loadGioHang(listGioHang);
            JOptionPane.showMessageDialog(this, "Thêm giỏ hàng thành công !");
            tongTien = 0;
            for (int i = 0; i < listGioHang.size(); i++) {
                tongTien += listGioHang.get(i).getThanhTien();
            }
            lbl_tongtien.setText(formatter.format(tongTien));
        }
    }//GEN-LAST:event_btn_themvaogiohangActionPerformed

    int indexMaSPTrungTrongGioHang;
    public boolean checkSPExistGioHang(String maSP, ArrayList<HoaDon> listHD){
        for (int i = 0; i < listHD.size(); i++) {
            if (maSP.equals(listHD.get(i).getMaSP())) {
                indexMaSPTrungTrongGioHang = i;
                return true;
            }
        }
        return false;
    }
    public void loadGioHang(ArrayList<HoaDon> listHD){
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("ĐVT");
        defaultTableModel.addColumn("SL mua");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Thành tiền");
        for (HoaDon obj : listHD) {
            SanPham sp = new frmBanHang().getSPByCode(obj.getMaSP());
            Vector vector = new Vector();
            vector.add(obj.getMaSP());
            vector.add(sp.getTenSanPham());
            vector.add(sp.getDonViTinh());
            vector.add(formatter.format(obj.getSoLuong()));
            vector.add(formatter.format(obj.getDonGia()));
            vector.add(formatter.format(obj.getThanhTien()));
            defaultTableModel.addRow(vector);
        }
        tbl_giohang.setModel(defaultTableModel);
        if (listHD.size() > 0) {
            btn_thanhtoan.setEnabled(true);
        }else{
            btn_thanhtoan.setEnabled(false);
        }
    }
    public SanPham getSPByCode(String maSP){
        ArrayList<SanPham> listSP = loadSP();
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSanPham())) {
                return listSP.get(i);
            }
        }
        return null;
    }
     
    public String timKiemTenSanPhamTheoMSP(String maSP){
        for (int i = 0; i < loadSP().size(); i++) {
            if (maSP.equals(loadSP().get(i).getMaSanPham())) {
                return loadSP().get(i).getMaSanPham();
            }
        }
        return null;
    }
    private void btn_timkiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemSPActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_sanpham.getText();
        if (tuKhoa == "") {
            getDataSanPham(loadSP());
        }else{
            ArrayList<SanPham> listSanPham_timkiem = new ArrayList<>();
            for (int i = 0; i < loadSP().size(); i++) {
                if (loadSP().get(i).getMaSanPham().contains(tuKhoa)
                        || loadSP().get(i).getTenSanPham().contains(tuKhoa) 
                        || loadSP().get(i).getTenNSX().contains(tuKhoa)) {
                    listSanPham_timkiem.add(loadSP().get(i));
                }
            }
            getDataSanPham(listSanPham_timkiem);
        }
    }//GEN-LAST:event_btn_timkiemSPActionPerformed

    private void tbl_bangsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangsanphamMouseClicked
        // TODO add your handling code here:
        int row = tbl_bangsanpham.getSelectedRow();
        String maSP = tbl_bangsanpham.getValueAt(row, 0).toString();
        ArrayList<SanPham> listSP = loadSP();
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSanPham())) {
                sp = listSP.get(i);
                index = i;
                break;

            }
        }
        txt_soluong.setText("1");
    }//GEN-LAST:event_tbl_bangsanphamMouseClicked

    private void btn_themvaogiohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themvaogiohangMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_themvaogiohangMouseClicked

    private void btn_xoagiohangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoagiohangActionPerformed
        // TODO add your handling code here:
        double tienGiam;
        for (int i = 0; i < listGioHang.size(); i++) {
            if (maSP.equals(listGioHang.get(i).getMaSP())) {
                tienGiam = listGioHang.get(i).getThanhTien();
                listGioHang.remove(i);
                tongTien = tongTien - tienGiam;
                lbl_tongtien.setText(String.valueOf(tongTien));               
           }
        }
        loadGioHang(listGioHang);
    }//GEN-LAST:event_btn_xoagiohangActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        // TODO add your handling code here:
        if (kh.getMaKhachHang() == null || kh.getMaKhachHang().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng trước !");
            return;
        }else{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            String maHD = kh.getMaKhachHang() + "-" + sdf.format(date);
            for (int i = 0; i < listGioHang.size(); i++) {
                HoaDon hd = listGioHang.get(i);
                hd.setMaHD(maHD);
                hd.setMaKH(kh.getMaKhachHang());
                hd.setMaNV(frmLogin.maNV_Login);
                hd.setNgayBan(sdf2.format(date));
                listGioHang.set(i, hd);
            }
            JTextField txtSoTien = new JTextField(10);
            
            JPanel myPanel = new JPanel();
            myPanel.add(Box.createHorizontalStrut(10));
            myPanel.add(new JLabel("Số tiền khách đưa: "));
            myPanel.add(txtSoTien);
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Số tiền khách thanh toán", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                double soTienKhachDua = Double.parseDouble(txtSoTien.getText());
                if (soTienKhachDua < tongTien) {
                    JOptionPane.showMessageDialog(this, "Số tiền khách trả chưa đủ !");
                    return;
                }else if (soTienKhachDua > tongTien) {
                    JOptionPane.showMessageDialog(this, "NV trả lại cho khách hàng " + (soTienKhachDua - tongTien));
                }
                saveFile();
                JOptionPane.showMessageDialog(this, "Thanh toán thành công !");
                frmSanPham frmSP = new frmSanPham();
                frmSP.loadFile();
                for (int i = 0; i < listGioHang.size(); i++) {
                    updateSoLuong(listGioHang.get(i).getMaSP(), listGioHang.get(i).getSoLuong(), frmSP.listSP);
                }
                frmSP.saveFile();
                
                listGioHang = new ArrayList<>();
                reset();
            }
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void txt_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soluongActionPerformed

    public void updateSoLuong(String maSP, int soLuongMua, ArrayList<SanPham> listSP){
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSanPham())) {
                SanPham sp = listSP.get(i);
                sp.setSoLuong(sp.getSoLuong() - soLuongMua);
                listSP.set(i, sp);
            }
        }
    }
    public void reset(){
        getDataKhachHang(loadKH());
        getDataSanPham(loadSP());
        loadGioHang(listGioHang);
        txt_makh.setText("...");
        txt_hoten.setText("...");
        txt_sdt.setText("...");
        txt_diachi.setText("...");
        txt_email.setText("...");
        tongTien = 0;
        lbl_tongtien.setText("...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_themvaogiohang;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timkiemSP;
    private javax.swing.JButton btn_xoagiohang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_tongtien;
    private javax.swing.JTable tbl_bangkhachhang;
    private javax.swing.JTable tbl_bangsanpham;
    private javax.swing.JTable tbl_giohang;
    private javax.swing.JLabel txt_diachi;
    private javax.swing.JLabel txt_email;
    private javax.swing.JLabel txt_hoten;
    private javax.swing.JTextField txt_khachhang;
    private javax.swing.JLabel txt_makh;
    private javax.swing.JLabel txt_nhanvien;
    private javax.swing.JTextField txt_sanpham;
    private javax.swing.JLabel txt_sdt;
    private javax.swing.JLabel txt_sl;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JButton txt_timkiemKH;
    private javax.swing.JLabel txt_tongtien;
    // End of variables declaration//GEN-END:variables
}
