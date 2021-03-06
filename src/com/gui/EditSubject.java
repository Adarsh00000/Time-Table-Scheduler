package com.gui;

import com.data_structure.DBConnect;
import static com.gui.MainMenu.desktop1;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class EditSubject extends javax.swing.JInternalFrame {
    private int sub_id;
    public EditSubject(int sub_id) {
        this.sub_id = sub_id;
        DBConnect.connect();
        initComponents();

        try{
            PreparedStatement st;
            String sql = "select * from subject where sub_id = ?";
            st = DBConnect.con.prepareStatement(sql);

            st.setInt(1, sub_id);

            DBConnect.rs = st.executeQuery();
            DBConnect.rs.next();

            subject_name.setText(DBConnect.rs.getString("sub_name"));
            subject_faculty.setText(DBConnect.rs.getString("sub_faculty"));
        }catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subject_name = new javax.swing.JTextField();
        subject_faculty = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
//        no_of_student = new com.toedter.components.JSpinField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 12, 92));
        jPanel2.setPreferredSize(new java.awt.Dimension(596, 488));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT SUBJECT INFORMATION PAGE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Subject Name ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        subject_name.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jPanel1.add(subject_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 220, -1));

        insert.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        insert.setText("Update the Information");
        insert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 12, 92), 2));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel1.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 260, 35));

        close.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        close.setText("Close");
        close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 12, 92), 2));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 80, 35));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("Subject Faculty ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

//        no_of_student.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
//        no_of_student.setMaximum(300);
//        no_of_student.setMinimum(0);
//        jPanel1.add(no_of_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 40, 30));

        subject_faculty.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jPanel1.add(subject_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
        this.hide();

        Thread runner = new Thread() {

            public void run() {
                ViewSubject regJ = new ViewSubject();
                desktop1.add(regJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));
                try {
                    regJ.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            }
        };
        runner.start();
    }//GEN-LAST:event_closeActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        if(subject_name.getText().trim().equals("") ||
                subject_faculty.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this,"Empty Field(s), Please correct and try again", "Empty Field(s)", JOptionPane.OK_OPTION);
        }else{
            try{
                PreparedStatement st;
                String sql1="update subject set sub_name = ?, sub_faculty = ? where sub_id = ?";
                st = DBConnect.con.prepareStatement(sql1);
                st.setString(1, subject_name.getText().trim());
                st.setString(2, subject_faculty.getText().trim());
                st.setInt(3, sub_id);

                st.executeUpdate();

                JOptionPane.showMessageDialog(this, "Subject information has been update","Success",JOptionPane.INFORMATION_MESSAGE);

                ViewSubject view_subject = new ViewSubject();
                MainMenu.desktop1.removeAll();
                MainMenu.desktop1.add(view_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0) );
                MainMenu.desktop1.setVisible(false);
                MainMenu.desktop1.setVisible(true);
                MainMenu.desktop1.setSelectedFrame(view_subject);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_insertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JTextField subject_name;
    private javax.swing.JTextField subject_faculty;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
//    private com.toedter.components.JSpinField no_of_student;
    // End of variables declaration//GEN-END:variables
}
