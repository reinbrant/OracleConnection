/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package connecttooracle;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Albrecht Arcangel
 */
public class MainScreenAct extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form MainScreenAct
     */
    public void refresh() {
        try {
            conn = ConnectDB.connect();
            ps = conn.prepareStatement("SELECT * FROM HR.VWEMPLOYEE ORDER BY EMPLOYEE_ID");
            rs = ps.executeQuery();
            tblEmployees.setModel(DbUtils.resultSetToTableModel(rs));
            JTableHeader tblHeader = tblEmployees.getTableHeader();
            DefaultTableCellRenderer tblRenderer = (DefaultTableCellRenderer) tblHeader.getDefaultRenderer();
            
            // Combo Box Select Options
            ps = conn.prepareStatement("SELECT JOB_TITLE FROM HR.JOBS ORDER BY JOB_ID");
            rs = ps.executeQuery();
            while(rs.next())
                cmbJobId.addItem(rs.getString("JOB_TITLE"));
            
            ps = conn.prepareStatement("SELECT DEPARTMENT_NAME FROM HR.DEPARTMENTS ORDER BY DEPARTMENT_NAME");
            rs = ps.executeQuery();
            while(rs.next())
                cmbDeptId.addItem(rs.getString("DEPARTMENT_NAME"));
            
            ps = conn.prepareStatement("SELECT last_name || ', ' || first_name as manager_name FROM HR.EMPLOYEES ORDER BY last_name");
            rs = ps.executeQuery();
            while(rs.next()) 
                cmbMgrId.addItem(rs.getString("manager_name"));
            
            /* ps = conn.prepareStatement("SELECT EMPLOYEE_ID FROM HR.EMPLOYEES ORDER BY EMPLOYEE_ID");
            rs = ps.executeQuery();
            while(rs.next()) 
                cmbMgrId.addItem(rs.getString("manager.name")); */
            
            //Customization for the table headers
            tblRenderer.setHorizontalAlignment(SwingConstants.CENTER);          //Sets horizontal alignment
            tblHeader.setBackground(new Color(2, 113, 121));                    //Sets bg color
            tblHeader.setForeground(Color.WHITE);                               //Sets font color
            tblHeader.setFont(new Font("Century Gothic", Font.BOLD, 12));       //Sets font family and size
            
            //Width for each header of the table
            tblEmployees.getColumnModel().getColumn(0).setPreferredWidth(60);   //Employee Number
            tblEmployees.getColumnModel().getColumn(1).setPreferredWidth(50);   //First Name
            tblEmployees.getColumnModel().getColumn(2).setPreferredWidth(50);   //Last Name
            tblEmployees.getColumnModel().getColumn(3).setPreferredWidth(80);   //Email
            tblEmployees.getColumnModel().getColumn(4).setPreferredWidth(80);   //Phone Number
            tblEmployees.getColumnModel().getColumn(5).setPreferredWidth(100);  //Hire Date
            tblEmployees.getColumnModel().getColumn(6).setPreferredWidth(30);   //Job ID
            tblEmployees.getColumnModel().getColumn(7).setPreferredWidth(1);    //Salary
            tblEmployees.getColumnModel().getColumn(8).setPreferredWidth(40);   //Commission PCT
            tblEmployees.getColumnModel().getColumn(9).setPreferredWidth(20);   //Manager ID
            tblEmployees.getColumnModel().getColumn(10).setPreferredWidth(30);  //Department ID
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public MainScreenAct() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        tblEmployees = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmployeeNo = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        txtCommPct = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtHireDate = new javax.swing.JTextField();
        cmbDeptId = new javax.swing.JComboBox<>();
        cmbJobId = new javax.swing.JComboBox<>();
        cmbMgrId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Screen");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(50, 50));
        setMaximumSize(new java.awt.Dimension(1400, 825));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1500, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblEmployees.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmployees.setGridColor(new java.awt.Color(2, 113, 121));
        tblEmployees.setRowHeight(30);
        tblEmployees.setShowGrid(true);
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        jPanel1.setBackground(new java.awt.Color(2, 113, 121));
        jPanel1.setMaximumSize(new java.awt.Dimension(1300, 90));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 90));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 90));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Log");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(590, 590, 590))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("Employee Information");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Employee Number:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("First Name:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Email Address:");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Phone Number:");

        txtEmployeeNo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtEmployeeNo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmployeeNo.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtEmployeeNo.setMaximumSize(new java.awt.Dimension(95, 35));
        txtEmployeeNo.setMinimumSize(new java.awt.Dimension(95, 35));
        txtEmployeeNo.setPreferredSize(new java.awt.Dimension(95, 35));

        txtLastName.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLastName.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtLastName.setMaximumSize(new java.awt.Dimension(200, 35));
        txtLastName.setMinimumSize(new java.awt.Dimension(200, 35));
        txtLastName.setPreferredSize(new java.awt.Dimension(200, 35));

        txtFirstName.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFirstName.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtFirstName.setMaximumSize(new java.awt.Dimension(200, 35));
        txtFirstName.setMinimumSize(new java.awt.Dimension(200, 35));
        txtFirstName.setPreferredSize(new java.awt.Dimension(200, 35));

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtEmail.setMaximumSize(new java.awt.Dimension(250, 35));
        txtEmail.setMinimumSize(new java.awt.Dimension(250, 35));
        txtEmail.setPreferredSize(new java.awt.Dimension(250, 35));

        txtPhoneNo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtPhoneNo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPhoneNo.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtPhoneNo.setMaximumSize(new java.awt.Dimension(150, 35));
        txtPhoneNo.setMinimumSize(new java.awt.Dimension(150, 35));
        txtPhoneNo.setPreferredSize(new java.awt.Dimension(150, 35));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("Department:");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Job:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Manager Name:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Hire Date:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Salary:");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setText("Commission PCT:");

        txtSalary.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtSalary.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSalary.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtSalary.setMaximumSize(new java.awt.Dimension(130, 25));
        txtSalary.setMinimumSize(new java.awt.Dimension(130, 25));
        txtSalary.setPreferredSize(new java.awt.Dimension(130, 25));

        txtCommPct.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtCommPct.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCommPct.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtCommPct.setMaximumSize(new java.awt.Dimension(85, 35));
        txtCommPct.setMinimumSize(new java.awt.Dimension(85, 35));
        txtCommPct.setPreferredSize(new java.awt.Dimension(85, 35));

        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setMaximumSize(new java.awt.Dimension(80, 35));
        btnAdd.setMinimumSize(new java.awt.Dimension(80, 35));
        btnAdd.setPreferredSize(new java.awt.Dimension(80, 35));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setMaximumSize(new java.awt.Dimension(80, 35));
        btnUpdate.setMinimumSize(new java.awt.Dimension(80, 35));
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 35));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(245, 66, 102));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setMaximumSize(new java.awt.Dimension(80, 35));
        btnDelete.setMinimumSize(new java.awt.Dimension(80, 35));
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 35));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        txtHireDate.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtHireDate.setMargin(new java.awt.Insets(1, 2, 1, 1));
        txtHireDate.setMaximumSize(new java.awt.Dimension(150, 35));
        txtHireDate.setMinimumSize(new java.awt.Dimension(150, 35));
        txtHireDate.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1441, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(235, 235, 235)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDeptId, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCommPct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(184, 184, 184))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbMgrId, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbDeptId)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtEmployeeNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel12)
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(txtCommPct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJobId, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbMgrId, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(456, 456, 456))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_formWindowActivated

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(null, "Do you wish to add the record?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(respond == JOptionPane.YES_OPTION) {
        try {
            conn = ConnectDB.connect();
            PreparedStatement psJobId = null;
            ResultSet rsJobId = null;
            
            PreparedStatement psMgrId = null;
            ResultSet rsMgrId = null;
            
            PreparedStatement psDeptId = null;
            ResultSet rsDeptId = null;
            
            String hireDateInput = txtHireDate.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(hireDateInput);
            Date sqlDate = new Date(utilDate.getTime());
            String sqlJobId = "SELECT JOB_ID FROM HR.JOBS WHERE JOB_TITLE = '"+cmbJobId.getSelectedItem().toString().trim()+"'";
            String sqlMgrId = "SELECT EMPLOYEE_ID FROM HR.EMPLOYEES WHERE last_name || ', ' || first_name = '"+cmbMgrId.getSelectedItem().toString().trim()+"'";
            String sqlDeptId = "SELECT DEPARTMENT_ID FROM HR.DEPARTMENTS WHERE DEPARTMENT_NAME = '"+cmbDeptId.getSelectedItem().toString().trim()+"'";
            
            psJobId = conn.prepareStatement(sqlJobId);
            rsJobId = psJobId.executeQuery();
            
           
            psMgrId = conn.prepareStatement(sqlMgrId);
            rsMgrId = psMgrId.executeQuery();
            
            psDeptId = conn.prepareStatement(sqlDeptId);
            rsDeptId = psDeptId.executeQuery();
            
            String sql = "INSERT INTO hr.EMPLOYEES (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtEmployeeNo.getText().trim()));
            ps.setString(2, txtFirstName.getText().trim());
            ps.setString(3, txtLastName.getText().trim());
            ps.setString(4, txtEmail.getText().trim());
            ps.setString(5, txtPhoneNo.getText().trim());
            ps.setDate(6, sqlDate);
            while (rsJobId.next())
                ps.setString(7, rsJobId.getString("JOB_ID"));
            ps.setDouble(8, Double.parseDouble(txtSalary.getText().trim()));
            ps.setDouble(9, txtCommPct.getText().isEmpty() ? 0 : Double.parseDouble(txtCommPct.getText().trim()));
            while (rsMgrId.next())
                ps.setInt(10, rsMgrId.getInt("EMPLOYEE_ID"));
            while (rsDeptId.next())
                ps.setInt(11, rsDeptId.getInt("DEPARTMENT_ID"));

            ps.executeUpdate();
            refresh();

            JOptionPane.showMessageDialog(null, "Adding of Record is successful.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use YYYY-MM-DD.");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e);
        }
        } else
            JOptionPane.showMessageDialog(null, "Adding of Record is aborted.");
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(null, "Do you wish to update?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        
            
        if(respond == JOptionPane.YES_OPTION) {
        try {
            conn = ConnectDB.connect();
            
            String sqlJobId = "SELECT JOB_ID FROM HR.JOBS WHERE JOB_TITLE = '"+cmbJobId.getSelectedItem().toString().trim()+"'";
            String sqlMgrId = "SELECT EMPLOYEE_ID FROM HR.EMPLOYEES WHERE last_name || ', ' || first_name = '"+cmbMgrId.getSelectedItem().toString().trim()+"'";
            String sqlDeptId = "SELECT DEPARTMENT_ID FROM HR.DEPARTMENTS WHERE DEPARTMENT_NAME = '"+cmbDeptId.getSelectedItem().toString().trim()+"'";

            PreparedStatement psJobId = null;
            ResultSet rsJobId = null;

            PreparedStatement psMgrId = null;
            ResultSet rsMgrId = null;

            PreparedStatement psDeptId = null;
            ResultSet rsDeptId = null;

            psJobId = conn.prepareStatement(sqlJobId);
            rsJobId = psJobId.executeQuery();


            psMgrId = conn.prepareStatement(sqlMgrId);
            rsMgrId = psMgrId.executeQuery();

            psDeptId = conn.prepareStatement(sqlDeptId);
            rsDeptId = psDeptId.executeQuery();
        
            String hireDateInput = txtHireDate.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(hireDateInput);
            String sql = "UPDATE hr.EMPLOYEES SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = TO_DATE(?, 'YYYY-MM-DD'), job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, department_id = ? WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(11, Integer.parseInt(txtEmployeeNo.getText().trim()));
            ps.setString(1, txtFirstName.getText().trim());
            ps.setString(2, txtLastName.getText().trim());
            ps.setString(3, txtEmail.getText().trim());
            ps.setString(4, txtPhoneNo.getText().trim());
            ps.setString(5, sdf.format(utilDate));
            while (rsJobId.next())
                ps.setString(6, rsJobId.getString("JOB_ID"));
            ps.setDouble(7, Double.parseDouble(txtSalary.getText().trim()));
            ps.setDouble(8, txtCommPct.getText().isEmpty() ? 0 : Double.parseDouble(txtCommPct.getText().trim()));
            while (rsMgrId.next())
                ps.setInt(9, rsMgrId.getInt("EMPLOYEE_ID"));
            while (rsDeptId.next())
                ps.setInt(10, rsDeptId.getInt("DEPARTMENT_ID"));

            ps.executeUpdate();
            refresh();

            JOptionPane.showMessageDialog(null, "Updating of Record is successful.");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Date Parsing Error: Invalid date format. Please use 'YYYY-MM-DD'.");
        }
        } else
            JOptionPane.showMessageDialog(null, "Updating of Record is aborted.");
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(null, "Do you wish to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(respond == JOptionPane.YES_OPTION) {
            try {
            conn = ConnectDB.connect();

            String deleteChildSQL = "DELETE FROM hr.JOB_HISTORY WHERE employee_id = ?";
            ps = conn.prepareStatement(deleteChildSQL);
            ps.setInt(1, Integer.parseInt(txtEmployeeNo.getText().trim()));
            ps.executeUpdate();

            String deleteParentSQL = "DELETE FROM hr.EMPLOYEES WHERE employee_id = ?";
            ps = conn.prepareStatement(deleteParentSQL);
            ps.setInt(1, Integer.parseInt(txtEmployeeNo.getText().trim()));
            ps.executeUpdate();

            refresh();
            JOptionPane.showMessageDialog(null, "Deleting of Record is successful.");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else
            JOptionPane.showMessageDialog(null, "Deleting of Record is aborted.");
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        // TODO add your handling code here:
        
        
        int row = tblEmployees.getSelectedRow();         
            txtEmployeeNo.setText(tblEmployees.getModel().getValueAt(row, 0).toString());
            txtFirstName.setText(tblEmployees.getModel().getValueAt(row, 1).toString());
            txtLastName.setText(tblEmployees.getModel().getValueAt(row, 2).toString());
            txtHireDate.setText(tblEmployees.getModel().getValueAt(row, 5).toString());
            txtEmail.setText(tblEmployees.getModel().getValueAt(row, 3).toString());
            txtPhoneNo.setText(tblEmployees.getModel().getValueAt(row, 4).toString());
            cmbJobId.setSelectedItem(tblEmployees.getModel().getValueAt(row, 6).toString());
            cmbDeptId.setSelectedItem(tblEmployees.getModel().getValueAt(row, 10).toString());
            cmbMgrId.setSelectedItem(tblEmployees.getModel().getValueAt(row, 9).toString());
            txtSalary.setText(tblEmployees.getModel().getValueAt(row, 7).toString());
            txtCommPct.setText(tblEmployees.getModel().getValueAt(row, 8).toString());
    }//GEN-LAST:event_tblEmployeesMouseClicked

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
            java.util.logging.Logger.getLogger(MainScreenAct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreenAct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreenAct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreenAct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenAct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDeptId;
    private javax.swing.JComboBox<String> cmbJobId;
    private javax.swing.JComboBox<String> cmbMgrId;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtCommPct;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeNo;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHireDate;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
