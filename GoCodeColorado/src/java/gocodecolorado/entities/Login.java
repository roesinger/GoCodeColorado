/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.entities;

/**
 *
 * @author rsjodin
 */
public class Login {
    
    private String email = "";
    private String password = "";


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
