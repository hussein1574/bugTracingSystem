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
    
    private final int ID;
    private final String Username;
    private final String Password;
    private final String Role;
    private final int NoOfBugs;
    private final String Name;

    public Users(int ID, String Username, String Password, String Role, int NoOfBugs, String Name) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.NoOfBugs = NoOfBugs;
        this.Name = Name;
    }
    

    public String getRole() {
        return Role;
    }

    public int getID() {
        return ID;
    }


    public String getUsername() {
        return Username;
    }


    public String getPassword() {
        return Password;
    }


    public int getNoOfBugs() {
        return NoOfBugs;
    }


    public String getName() {
        return Name;
    }

    
}
