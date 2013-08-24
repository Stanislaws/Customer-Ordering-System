package groupproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Phone lookup GUI
 * @author Abir Ghosh
 */
public class Project extends JFrame{
    
    //Find Button on the main window to search for the customer from the database
    private JButton find = new JButton("Find");
    
    //Add button on the index page to add a new customer to the database.
    private JButton mAdd = new JButton("Add New Customer");
    
    //textBox to add/search for phone number
    private JTextField phoneNum = new JTextField(10); 
    
    public Project(){
        JPanel jpMain = new JPanel();
        //create a panel and add the textField and the buttons 
        jpMain.add(new JLabel("Phone #"), BorderLayout.WEST);
        jpMain.add(phoneNum, BorderLayout.CENTER);
        jpMain.add(find, BorderLayout.CENTER);
        jpMain.add(mAdd, BorderLayout.CENTER);
        //add the panel to the frame
        add(jpMain);
        
        
        find.addActionListener(new ActionListener(){

            @Override
           public void actionPerformed(ActionEvent e) {
                
            }
            
        });
        
        mAdd.addActionListener(new ActionListener(){

            @Override
           public void actionPerformed(ActionEvent e) {
                
            }
            
        });
}
       
    public static void main(String[] args) {
         Project frame = new Project();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Group Project (Main/Index page)");
    frame.setSize(400,80);
    frame.setVisible(true);
    }
}
