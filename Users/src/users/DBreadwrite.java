/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SG
 */
public class DBreadwrite extends javax.swing.JFrame {

    /**
     * Creates new form DBreadwrite
     */
    private Connection connect;
    private Statement statement;
    private ResultSet result;
    ArrayList<Users> userList;
    private DefaultTableModel table;
    
    public DBreadwrite() {
        initComponents();
 //       createtable();
        usersList();
        TableDisp();
    }
    /*
    public void createTable(){
        Connection connect=getConnection();
        try {
            PreparedStatement ps=connect.prepareStatement("CREATE TABLE IF NOT EXISTS register_cust(`AccNo` int, `AccType` varchar(50), `Name` varchar(50), `Address`varchar(200), `Sex` varchar(10), `DOB`varchar(11), `Occupation` varchar(40), `Balance` int)");
        } catch (SQLException ex) {
            Logger.getLogger(DBreadwrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public Connection getConnection(){
        try {
            connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banking", "root","");
            return connect;
        } catch (SQLException ex){
            //Logger.getLogger(DBreadwrite.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Please start your MySql server");
            System.exit(1);
            return null;
        }
    }
    public final ArrayList<Users> usersList(){
        userList = new ArrayList<>();
        Connection connection=getConnection();
        String query="Select * from register_cust";
        try {
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            Users user;
            while (result.next()){
                user=new Users(result.getString("AccNo"),result.getString("AccType"),result.getString("Name"),result.getString("Address"),result.getString("Sex"),result.getString("DOB"),result.getString("Occupation"),result.getString("Balance"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBreadwrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
    public final void TableDisp(){
        System.out.println("userList size in TableDisp(): "+userList.size());
        Object[] row=new Object[8];
        table = (DefaultTableModel)this.jTable1.getModel();
        for (int cnt=0;cnt<userList.size();cnt++){
            row[0]=userList.get(cnt).getAccNo();
            row[1]=userList.get(cnt).getAccType();
            row[2]=userList.get(cnt).getName();
            row[3]=userList.get(cnt).getAddress();
            row[4]=userList.get(cnt).getSex();
            row[5]=userList.get(cnt).getDob();
            row[6]=userList.get(cnt).getOccupation();
            row[7]=userList.get(cnt).getBalance();
            table.addRow(row);
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
        jTable1 = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtAccNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtAccType = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSex = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AccNo", "AccType", "Name", "Address", "Sex", "DOB", "Occupation", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Name");

        jLabel6.setText("Account No");

        jLabel8.setText("Address");

        jLabel9.setText("Sex");

        jLabel12.setText("Balance");

        jLabel11.setText("Occupation");

        jLabel5.setText("Account type");

        jLabel10.setText("DOB");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtSex)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtAccType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtOccupation)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtBalance))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAccNo, txtAccType, txtAddress, txtName});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtAccType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(361, 361, 361))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
         String query="INSERT INTO `register_cust`( VALUES ('"+txtAccNo.getText()+"','"+txtAccType.getText()+"','"+txtName.getText()+"','"+txtAddress.getText()+"','"+txtSex.getText()+"','"+txtDOB.getText()+"','"+txtOccupation.getText()+"','"+txtBalance.getText()+"')";        // TODO add your handling code here:
         execute(query,"insert");
         System.out.println("userList size before call to : "+userList.size());
         Object[] row=new Object[8];
         row[0]=txtAccNo.getText();
         row[1]=txtAccType.getText();
         row[2]=txtName.getText();
         row[3]=txtAddress.getText();
         row[4]=txtSex.getText();
         row[5]=txtDOB.getText();
         row[6]=txtOccupation.getText();
         row[7]=txtBalance.getText();
         table = (DefaultTableModel)this.jTable1.getModel();
         table.addRow(row);
         this.makeTxtBoxesEmpty();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         String query="UPDATE `register_cust` SET `AccNo`='"+txtAccNo.getText()+"',`AccType`='"+txtAccType.getText()+"',`Name`='"+txtName.getText()+"',`Address`='"+txtAddress.getText()+"',`Sex`='"+txtSex.getText()+"',`DOB`='"+txtDOB.getText()+"',`Occupation`='"+txtOccupation.getText()+"',`Balance`='"+txtBalance.getText()+"' WHERE `AccNo`='"+txtAccNo.getText()+"'";        // TODO add your handling code here:
         execute(query,"update");
         int rowChoice=jTable1.getSelectedRow();
         table = (DefaultTableModel)this.jTable1.getModel();
         Object[] row=new Object[8];
         row[0]=txtAccNo.getText();
         row[1]=txtAccType.getText();
         row[2]=txtName.getText();
         row[3]=txtAddress.getText();
         row[4]=txtSex.getText();
         row[5]=txtDOB.getText();
         row[6]=txtOccupation.getText();
         row[7]=txtBalance.getText();
         for (int col=0;col<row.length;col++) 
             table.setValueAt(row[col],rowChoice,col);
         this.makeTxtBoxesEmpty();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String query="DELETE FROM `register_cust` WHERE `AccNo`='"+txtAccNo.getText()+"'";// TODO add your handling code here:
        execute(query,"delete");
        int row=jTable1.getSelectedRow();
        table.removeRow(row);
        this.makeTxtBoxesEmpty();
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void makeTxtBoxesEmpty(){
        this.txtAccNo.setText("");
        this.txtAccType.setText("");
        this.txtName.setText("");
        this.txtAddress.setText("");
        this.txtSex.setText("");
        this.txtDOB.setText("");
        this.txtOccupation.setText("");
        this.txtBalance.setText("");
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtAccNo.setEnabled(false);
        int row=  jTable1.getSelectedRow();
        table = (DefaultTableModel)this.jTable1.getModel();
        txtAccNo.setText(table.getValueAt(row,0).toString());
        txtAccType.setText(table.getValueAt(row,1).toString());
        txtName.setText(table.getValueAt(row,2).toString());
        txtAddress.setText(table.getValueAt(row,3).toString());
        txtSex.setText(table.getValueAt(row,4).toString());
        txtDOB.setText(table.getValueAt(row,5).toString());
        txtOccupation.setText(table.getValueAt(row,6).toString());
        txtBalance.setText(table.getValueAt(row,7).toString());
    }//GEN-LAST:event_jTable1MouseClicked
    
    
    private void execute(String query, String msg){
        connect=getConnection();
        try {
            statement=connect.createStatement();
            int result=statement.executeUpdate(query);
            if (result==1) System.out.println("Successful "+msg);
            } catch (SQLException ex) {
            Logger.getLogger(DBreadwrite.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UnSuccessful "+msg);
            }
        }
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
            java.util.logging.Logger.getLogger(DBreadwrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBreadwrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBreadwrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBreadwrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBreadwrite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAccNo;
    private javax.swing.JTextField txtAccType;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtSex;
    // End of variables declaration//GEN-END:variables

    private void createtable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
