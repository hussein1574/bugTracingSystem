/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug_tracing_system;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author husse
 */
public class EditAccounts {

    public static void IncBugs(int accId) throws SQLException , ClassNotFoundException
    {    
        DataBase db = new DataBase();           
        String sql = "SELECT * FROM accounts WHERE UserId=" + accId;
        ResultSet rs = db.selectQuery(sql);
        while(rs.next())
        {
           sql = "UPDATE accounts SET NoOfBugs= " + ((rs.getInt("NoOfBugs")+1));
        }  
    }

    public static void Delete(int accId) throws SQLException , ClassNotFoundException{
        DataBase db = new DataBase(); 
        String sql = "SELECT * FROM accounts WHERE UserId ="+accId;
        ResultSet rs = db.selectQuery(sql);
        while(rs.next())
        {
           if(rs.getInt("NoOfBugs") > 0)
           {
            sql = "DELETE FROM bugs WHERE DeveloperId="+accId+ " OR TesterId="+accId;
            db.updateQuery(sql);
           }
        }   
         sql = "DELETE FROM roles WHERE AccountsUserId="+accId;
         db.updateQuery(sql);
         sql = "DELETE FROM accounts WHERE UserId ="+accId; 
         db.updateQuery(sql);
        
    }

    public static void Update(Users user) throws SQLException , ClassNotFoundException {
        DataBase db = new DataBase();          
         String[] fullName = user.getName().split(" ");
            String sql = "UPDATE accounts SET Username = '"+user.getUsername() +"', Password ='"+ user.getPassword()+"', NoOfBugs='"+user.getNoOfBugs()+"', FName='"+fullName[0]+"', LName='"+fullName[1]+"'  WHERE UserId ="+user.getID(); 
            db.updateQuery(sql);
            sql = "UPDATE roles SET RoleName='"+user.getRole()+"' WHERE AccountsUserId="+user.getID();
            db.updateQuery(sql);
    }
    
    public static boolean CheckUsername(String User) throws SQLException , ClassNotFoundException{
        DataBase db = new DataBase();           
        String sql = "SELECT * FROM accounts WHERE Username = '" +User + "'";
        ResultSet rs = db.selectQuery(sql);
        return rs.next();
    }
}
    

