package groupproject;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
/**
 * Registration GUI
 * @author Jan Zajaczkowski, Ayoub, Abir Ghosh 
 */
public class NewCustomer extends JFrame{
    private JPasswordField tfp = new JPasswordField(15);
    
    private JTextField tfu = new JTextField(15);
    private JTextField tffn = new JTextField(50);
    private JTextField tfsn = new JTextField(25);
    private JTextField tfcn = new JTextField(25);
    private JTextField tfz = new JTextField(5);
    private JTextField tfpn = new JTextField(10); 
    private JTextField tfe = new JTextField(30);
    
    private JButton btg = new JButton("Register");
    private JButton btr = new JButton("Reset");
    private JButton btc = new JButton("Cancel");
            
    private String[] states = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL",
        "GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN",
        "MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR",
        "PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
    
    private JComboBox cbst = new JComboBox(states);
    
    private JLabel lu = new JLabel("Username:");
    private JLabel lp = new JLabel("Password:");
    private JLabel lfn = new JLabel("Full Name:");
    private JLabel lsn = new JLabel("Street:");
    private JLabel lcn = new JLabel("City:");
    private JLabel lst = new JLabel("State");
    private JLabel lz = new JLabel("5 digit zip:");
    private JLabel lpn = new JLabel("Phone:");
    private JLabel le = new JLabel("Email:");
  
    public NewCustomer() {
        lu.setHorizontalAlignment(JLabel.RIGHT);
        lp.setHorizontalAlignment(JLabel.RIGHT);
        lfn.setHorizontalAlignment(JLabel.RIGHT);
        lsn.setHorizontalAlignment(JLabel.RIGHT);
        lcn.setHorizontalAlignment(JLabel.RIGHT);
        lst.setHorizontalAlignment(JLabel.RIGHT);
        lz.setHorizontalAlignment(JLabel.RIGHT);
        lpn.setHorizontalAlignment(JLabel.RIGHT);
        le.setHorizontalAlignment(JLabel.RIGHT);
        
        setLayout(new GridLayout(11,2));       
        add(lu);
        add(tfu);      
        add(lp);
        add(tfp);
        add(lfn);
        add(tffn);
        add(lsn);
        add(tfsn);
        add(lcn);
        add(tfcn);
        add(lst);
        add(cbst);
        add(lz);
        add(tfz);
        add(lpn);
        add(tfpn);
        add(le);
        add(tfe);
        add(btg);
        add(btr);
        add(btc);
       
        btg.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                String u = tfu.getText();
                String p = tfp.getText();
                String fn = tffn.getText();
                String sn = tfsn.getText();
                String cn = tfcn.getText();
                String z = tfz.getText();
                String pn = tfpn.getText();
                String e = tfe.getText();
                /*
                if(!isUser(u)){
                    if(validUser()){
                        if(validPass()){
                            if(validName()){
                                if(validStreet()){
                                    if(validCity()){
                                        if(validZip()){
                                            if(validPhone()){
                                                if(validEmail()){
                                                    showSuccess();
                                                }
                                                else{
                                                    showInvalidEmail();
                                                }
                                            }
                                            else{
                                                showInvalidPhone();
                                            }
                                        }
                                        else{
                                            showInvalidZip();
                                        }
                                    }
                                    else{
                                        showInvalidCity();
                                    }
                                }
                                else{
                                    showInvalidStreet();
                                }
                            }
                            else{
                                showInvalidName();
                            }
                        }
                        else{
                            showInvalidPass();
                        }
                    }
                    else{
                        showInvalidUser();
                    }
                }
                else{
                    showDupeUser();
                }*/
            }
            
        });
        
        btr.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                tfu.setText("");
                tfp.setText("");
                tffn.setText("");
                tfsn.setText("");
                tfcn.setText("");
                tfz.setText("");
                tfpn.setText("");
                tfe.setText("");
            }
            
        });
        
        btc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                showLogin();
            }
            
        });
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
    private ResultSet DBConnect(String query) throws SQLException, 
            ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "hello1");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(query);
        return r;
    }    
    private void showLogin(){
        NewLogin f = new NewLogin();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Login");
        f.setSize(200, 200);
        f.setVisible(true);
        setVisible(false);
    }
    /**
     * Tests the registration window
     * @param args 
     */
     public static void main(String[] args) {
        NewCustomer f = new NewCustomer();
        f.setLocationRelativeTo(null); // Center the frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Registration");
        f.setSize(500,300);
        f.setVisible(true);
    }
    private boolean isEmail(String email){
        boolean isValid = false; 
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
        CharSequence inputStr = email;  
        //Make the comparison case-insensitive.  
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
        Matcher matcher = pattern.matcher(inputStr);  
            if(matcher.matches()){  
                isValid = true;  
            }  
        return isValid; 
    }
    
    private boolean isPhone(String s) {
        boolean isValid = false; 
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
        CharSequence inputStr = s;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
            if(matcher.matches()){  
                isValid = true;  
            }  
        return isValid;
    }

    private boolean isAddress( String s )
    {
      return s.matches( 
         "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
    }
    private boolean validUser( String username){
        String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

        Pattern  pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
