/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug_tracing_system;

/**
 *
 * @author husse
 */
public class Users {
    
    private int ID;
    private String Username;
    private String Password;
    private String Role;
    private int NoOfBugs;
    private String Name;

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getNoOfBugs() {
        return NoOfBugs;
    }

    public void setNoOfBugs(int NoOfBugs) {
        this.NoOfBugs = NoOfBugs;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
