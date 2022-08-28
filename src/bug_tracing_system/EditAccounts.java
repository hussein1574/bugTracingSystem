/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug_tracing_system;

import bug_tracing_system.Admin.Admin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author husse
 */
public class EditAccounts {

    public static void IncBugs(int accId) //Increment no of bugs for the users
    {
        
  try{
        DataBase db = new DataBase();           
            String sql = "SELECT * FROM accounts WHERE UserId=" + accId;
            ResultSet rs = db.Select_Query(sql);
            while(rs.next())
            {
               sql = "UPDATE accounts SET NoOfBugs= " + ((rs.getInt("NoOfBugs")+1));
            } 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Delete(int accId) {
        
  try{
        DataBase db = new DataBase(); 
          String sql = "SELECT * FROM accounts WHERE UserId ="+accId;
            ResultSet rs = db.Select_Query(sql);
            while(rs.next())
            {
               if(rs.getInt("NoOfBugs") > 0)
               {
                   sql = "DELETE FROM bugs WHERE DeveloperId="+accId+ " OR TesterId="+accId;
                db.Update_Query(sql);
               }
            }   
             sql = "DELETE FROM roles WHERE AccountsUserId="+accId;
            db.Update_Query(sql);
             sql = "DELETE FROM accounts WHERE UserId ="+accId; 
            db.Update_Query(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Update(Users u) {
         try{
        DataBase db = new DataBase();          
         String[] n = u.getName().split(" ");
            String sql = "UPDATE accounts SET Username = '"+u.getUsername() +"', Password ='"+ u.getPassword()+"', NoOfBugs='"+u.getNoOfBugs()+"', FName='"+n[0]+"', LName='"+n[1]+"'  WHERE UserId ="+u.getID(); 
            db.Update_Query(sql);
            sql = "UPDATE roles SET RoleName='"+u.getRole()+"' WHERE AccountsUserId="+u.getID();
            db.Update_Query(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static boolean CheckUsername(String User) {
        
  try{
        DataBase db = new DataBase();           
            String sql = "SELECT * FROM accounts WHERE Username = '" +User + "'";
            ResultSet rs = db.Select_Query(sql);
            while(rs.next())
            {
               return true;
            }   
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
    

