package bug_tracing_system.Tester;

import bug_tracing_system.DataBase;
import bug_tracing_system.Data;
import static bug_tracing_system.EditAccounts.IncBugs;
import bug_tracing_system.Name;
import bug_tracing_system.Mailer;
import bug_tracing_system.Users;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class BugSubmiter extends javax.swing.JFrame implements Data, Name {
    public static final int NOT_FOUND = -1;
    static int xPress = 0;
    static int yPress = 0;
    static Users myuser;
    public static  int Index;
    private int bugId;
    ArrayList<Users> arrLst = new ArrayList<>();
    
    public BugSubmiter(Users user) {
        try {
            myuser = user;
            initComponents();
            fillComboBox();
            getData();
            for(int i = 0; i < arrLst.size(); i++)
            {
                this.developersList.addItem(getName(i));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BugSubmiter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void getData() throws SQLException, ClassNotFoundException
    {      
        DataBase db = new DataBase();           
            String sql = "SELECT * FROM accounts as a, roles as r WHERE a.UserId = r.AccountsUserId and r.RoleName = 'Developer'";
            ResultSet rs = db.selectQuery(sql);
            while(rs.next())
            {
               Users user = new Users(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"),rs.getString("RoleName"),  rs.getInt("NoOfBugs"), rs.getString("FName") + rs.getString("LName"));
               arrLst.add(user);
            } 
    }
    @Override
    public String getName(int loc)
    {
        return arrLst.get(loc).getName();
    }
       private void fillComboBox() throws SQLException, ClassNotFoundException
  {
        DataBase db = new DataBase();           
        String sql = "SELECT * FROM projects";
        ResultSet rs = db.selectQuery(sql);
        while(rs.next())
        {
           this.projectNamesList.addItem(rs.getString("ProjectName"));
        }  
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bugTypeText = new javax.swing.JTextField();
        bugNameText = new javax.swing.JTextField();
        priortyText = new javax.swing.JTextField();
        statueText = new javax.swing.JTextField();
        browseBtn = new javax.swing.JButton();
        screenShotText = new javax.swing.JTextField();
        projectNamesList = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        developersList = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bugDesText = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        sendBtn = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(33, 63, 86));

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Project name");

        jLabel2.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bug Type");

        jLabel3.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bug Name");

        jLabel4.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Priorty");

        jLabel6.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Statue");

        jLabel7.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ScreenShot");

        bugTypeText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        bugNameText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        priortyText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        statueText.setEditable(false);
        statueText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        statueText.setText("WIP");

        browseBtn.setBackground(new java.awt.Color(204, 204, 204));
        browseBtn.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        browseBtn.setForeground(new java.awt.Color(33, 63, 86));
        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        screenShotText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        projectNamesList.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Developer");

        developersList.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bug description");

        bugDesText.setColumns(20);
        bugDesText.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        bugDesText.setRows(5);
        jScrollPane1.setViewportView(bugDesText);

        backBtn.setBackground(new java.awt.Color(204, 204, 204));
        backBtn.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(33, 63, 86));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        sendBtn.setBackground(new java.awt.Color(204, 204, 204));
        sendBtn.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        sendBtn.setForeground(new java.awt.Color(33, 63, 86));
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(screenShotText, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(browseBtn))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bugNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bugTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(projectNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(statueText)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(priortyText, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(developersList, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(projectNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(developersList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priortyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statueText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bugNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(bugTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(screenShotText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xPress = evt.getX();
        yPress = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen()-xPress,evt.getYOnScreen()-yPress);
    }//GEN-LAST:event_formMouseDragged

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        try {
            addBug();
            IncBugs(myuser.getID());
            Mailer.send("your email","your password","the reciever email","email title",
                    "the Bug: " + this.bugNameText.getName() +" \nat project: " + this.projectNamesList.getSelectedItem().toString() + " \nis assigned");
            WindowEvent closewindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closewindow);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(BugSubmiter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    private void addBug() throws SQLException , ClassNotFoundException , IOException {
        if("".equals(priortyText.getText()) || "".equals(bugNameText.getText()) || "".equals(bugTypeText.getText()) || "".equals(screenShotText.getText()) || "".equals(bugDesText.getText()))
        {
            JOptionPane.showMessageDialog(null, "Please Fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int devId = getId();
            DataBase db = new DataBase();
            String sql = "SELECT * FROM projects WHERE ProjectName = '"+ this.projectNamesList.getSelectedItem() +"'";
            ResultSet rs = db.selectQuery(sql);
            rs.next();
            sql = "INSERT INTO bugs VALUES (NULL," +"'"+ this.statueText.getText()+"'" + "," +"'"+ this.bugNameText.getText()+"'"
                    + "," +"'"+ this.bugTypeText.getText() +"'"+ ","+"'"+
                    this.priortyText.getText() +"'" + ",0, '" + this.bugDesText.getText()+
                    "'"+ ","+"'" + myuser.getID()+"'" + ","+"'" + devId +"'"
                    + ","+"'" +rs.getInt("ProjectId") +"')";
            db.updateQuery(sql);
            sql = "SELECT * FROM bugs WHERE BugDetails = '"+ this.bugDesText.getText() +"'";
            rs = db.selectQuery(sql);
            rs.next();
            bugId = rs.getInt("BugId");
            sql = "UPDATE bugs SET ImageFileName=' " + bugId + "' WHERE BugId=" + bugId;
            db.updateQuery(sql);
            uploadImg();
        }
    }

    private void uploadImg() throws IOException {
        File source = new File(this.screenShotText.getText());
        File dest = new File("imgs\\"+ bugId + ".png");
        Files.copy(source.toPath(),dest.toPath());
    }
      private int getId() {
        for(int i=0;i < arrLst.size();i++)
                if(arrLst.get(i).getName() == this.developersList.getSelectedItem())
                    return arrLst.get(i).getID();
        return NOT_FOUND;
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        WindowEvent closewindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closewindow);
    }//GEN-LAST:event_backBtnActionPerformed

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // For File
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Photos", "png");
        fileChooser.addChoosableFileFilter(filter);
        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            this.screenShotText.setText(fileChooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new BugSubmiter(myuser).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton browseBtn;
    public javax.swing.JTextArea bugDesText;
    public javax.swing.JTextField bugNameText;
    public javax.swing.JTextField bugTypeText;
    public javax.swing.JComboBox<String> developersList;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField priortyText;
    public javax.swing.JComboBox<String> projectNamesList;
    public javax.swing.JTextField screenShotText;
    private javax.swing.JButton sendBtn;
    public javax.swing.JTextField statueText;
    // End of variables declaration//GEN-END:variables

  
    
}
