package groupproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

/**
 * GUI that the user sees to authenticate them
 * @author Jan Zajaczkowski, Ayoub, Abir Ghosh 
 */
public class NewLogin extends JFrame{
    private JTextField tfu = new JTextField(15);
    private JPasswordField tfp = new JPasswordField(15);
    private JButton bts = new JButton("Submit");
    private JButton btr = new JButton("Reset");
    private JButton btg = new JButton("Register");
    private JButton btc = new JButton("Cancel");
    private JLabel lu = new JLabel("Username");
    private JLabel lp = new JLabel("Password");
    
    public NewLogin(){ 
        
        
        
        JPanel p1 = new JPanel();
        p1.add(lu);
        p1.add(tfu);
        
        JPanel p2 = new JPanel();
        p2.add(lp);
        p2.add(tfp);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2,2));
        p3.add(bts);
        p3.add(btr);
        p3.add(btg);
        p3.add(btc);
        
        setLayout(new GridLayout(3,1));
        add(p1);
        add(p2);
        add(p3);
        
        bts.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                String u = tfu.getText();
                String p = tfp.getText();
                try {
                    if(isValidUser(u)){
                        if(isValidPass(p)){
                            if(isUser(u)){
                                if(isAuth(u,p)){
                                    showMenu();
                                }
                                else {
                                    showWrongPass();
                                }
                            }
                            else {
                                showWrongUser();
                            }
                        }
                        else {
                            showInvalidPass();
                        }
                    }
                    else {
                        showInvalidUser();
                    }
                } 
                catch (SQLException ex) {
                    showError(ex.toString());
                } 
                catch (ClassNotFoundException ex) {
                    showError(ex.toString());
                } 
                catch (Error ex){
                    showError(ex.toString());
                }
            }
            
        });
        btr.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                tfu.setText("");
                tfp.setText("");
            }
            
        });
        
        btg.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                showRegistration();
            }
            
        });
        
        btc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
            
        });
    }
    
    public static void main(String[] args){
        NewLogin f = new NewLogin();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Login");
        f.setSize(200, 200);
        f.setVisible(true);
    }

    private boolean isUser(String u) throws SQLException, ClassNotFoundException{
        ResultSet r = DBConnect("select username from users where username ='"+
                u+"'");
        if(r.next()){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isAuth(String u, String p) throws SQLException, 
            ClassNotFoundException{
        ResultSet r = DBConnect("select username from users where username ='"+
                u+"' and password='"+p+"'");
        if(r.next()){
            return true;
        }
        else{
            return false;
        }
    }
    
    private ResultSet DBConnect(String query) throws SQLException, 
            ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "hello1");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(query);
        return r;
    }

    private boolean isValidUser(String u){
        String up = "^[a-z0-9_-]{3,15}$";
        Pattern  pt = Pattern.compile(up);
        Matcher m = pt.matcher(u);
        return m.matches();
    }
    
    private boolean isValidPass(String p){
        String pp = "^[a-z0-9_-]{3,15}$";
        Pattern pt = Pattern.compile(pp);
        Matcher m = pt.matcher(p);
        return m.matches();
    }
    
    private void showMenu(){
        Object[] options = {"Find order",
                            "New order"};
        int n = JOptionPane.showOptionDialog(this,
            "Welcome, what would you like to do now?",
            "Welcome",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title
        if(n==0){
            //find
        }
        if(n==1){
            showRegistration();
        }
    }
    
    private void showWrongPass(){
        JOptionPane.showMessageDialog(this,
            "The password you entered is incorrect",
            "Incorrect Password",
            JOptionPane.ERROR_MESSAGE);          
    }
    
    private void showWrongUser(){ 
        int n = JOptionPane.showConfirmDialog(this,
            "User is not recognized, register?",
            "Unrecognized user",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            showRegistration();
        }
        if(n==1){
            //no
        }
    }
    
    private void showInvalidPass(){
        JOptionPane.showMessageDialog(this,
            "Password should be 3-15 characters and be alphanumberic",
            "Invalid Password",
            JOptionPane.ERROR_MESSAGE);          
    }
    
    private void showInvalidUser(){
        JOptionPane.showMessageDialog(this,
            "Username should be 3-15 characters and be alphanumberic",
            "Invalid Username",
            JOptionPane.ERROR_MESSAGE);        
    }
    
    private void showError(String e){
        JOptionPane.showMessageDialog(this,
                "Please contact the system admin about: " + e,
                "Error",
                JOptionPane.ERROR_MESSAGE);            
    }
    
    private void showRegistration(){
        NewCustomer f = new NewCustomer();
        f.setLocationRelativeTo(null); // Center the frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Registration");
        f.setSize(500,300);
        f.setVisible(true);
        setVisible(false);
    }
}
