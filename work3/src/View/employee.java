/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.*;
import Dao.GenericDao;
import Dao.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Location;
import org.hibernate.Session;


/**
 *
 * @author AAAA
 */
public class employee extends javax.swing.JFrame {

    /**
     * Creates new form employee
     */
    DefaultTableModel emptable;
    GenericDao<Employee> emp = new GenericDao<>(Employee.class); 
    GenericDao<Location> loc = new GenericDao<>(Location.class); 
    public employee() {
        initComponents();
        emptable = (DefaultTableModel)jTable1.getModel();
        populateProvince();
        EmployeeTable();
         
    }
    public void EmployeeTable(){
    
        List<Employee> le = emp .findAll();
        for (Employee el : le ){
        emptable.insertRow(emptable.getRowCount(), new Object[]{
        el.getEmployee_id(),el.getEmployee_name(),el.getResidence_district()
        });
        }
    }
    private void populateProvince(){   
       try{
           PROVINCE.removeAllItems();
           Session ss = HibernateUtil.getSessionFactory().openSession();
           ss.beginTransaction().commit();
           List<Location> location = (List<Location>)ss.createQuery("from Location where parent = 0").list();
           for(Location l:location){
               PROVINCE.addItem(l.getName());
            }
           }
       
       //}
       catch(Exception ex){
           System.out.println("populateProvince "+ex);
       }
       
    }private void getDistrictByParent(String Province){
        int id = 0;
    try{
       Session ss = HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction().commit();
       List<Location> location = (List<Location>)ss.createQuery("from Location where name = '"+Province+"' ").list();
       for(Location l:location){
           id = Integer.parseInt(l.getId());
       }
    }catch(Exception ex){
        System.out.println("getDistrictByParent "+ex);
    }
    populateDistrict(id);
}
private void populateDistrict(int Parentid){
    try{
          DISTRICT.removeAllItems();
    Session ss = HibernateUtil.getSessionFactory().openSession();
    ss.beginTransaction().commit();
    List<Location> location = (List<Location>)ss.createQuery("from Location where parent ='"+Parentid+"' ").list();
    for(Location l:location){
        DISTRICT.addItem(l.getName());
    }
    }catch (Exception ex){
        System.out.println("populateDistrict "+ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SAVE = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        PROVINCE = new javax.swing.JComboBox<String>();
        DISTRICT = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Names", "Residence District"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Employee ID:");

        jLabel2.setText("Employee Name:");

        jLabel4.setText("Residence Province:");

        jLabel5.setText("Residence District:");

        SAVE.setText("SAVE");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });

        ID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        PROVINCE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PROVINCEItemStateChanged(evt);
            }
        });
        PROVINCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PROVINCEMouseClicked(evt);
            }
        });
        PROVINCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROVINCEActionPerformed(evt);
            }
        });

        DISTRICT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DISTRICTItemStateChanged(evt);
            }
        });
        DISTRICT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DISTRICTMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DISTRICTMousePressed(evt);
            }
        });
        DISTRICT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISTRICTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PROVINCE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(252, 252, 252)
                                        .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PROVINCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(SAVE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
 
 String id; 
 if(ID.getText().length()<=5){
     id = ID.getText();
      
 
String name = NAME.getText();
String district = DISTRICT.getSelectedItem().toString();
Employee ep = new Employee(id,name,district);

 emp.createA(ep);
 emptable.setRowCount(0);
 EmployeeTable();
 
 }else{

 JOptionPane.showMessageDialog(this,"id needs to have a maximum of 5 digits");
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_SAVEActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void DISTRICTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DISTRICTMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void DISTRICTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DISTRICTItemStateChanged


     //populateSector();     
// TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTItemStateChanged

    private void PROVINCEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PROVINCEItemStateChanged
        String Province = PROVINCE.getSelectedItem().toString();
        getDistrictByParent(PROVINCE.getSelectedItem().toString());


        // TODO add your handling code here:
    }//GEN-LAST:event_PROVINCEItemStateChanged

    private void DISTRICTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DISTRICTMouseClicked
     

// TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTMouseClicked

    private void PROVINCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROVINCEActionPerformed
 
    }//GEN-LAST:event_PROVINCEActionPerformed

    private void DISTRICTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DISTRICTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTActionPerformed

    private void PROVINCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PROVINCEMouseClicked
       
    }//GEN-LAST:event_PROVINCEMouseClicked

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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DISTRICT;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField NAME;
    private javax.swing.JComboBox<String> PROVINCE;
    private javax.swing.JButton SAVE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables



















}
       
       
    
