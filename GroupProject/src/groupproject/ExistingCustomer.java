/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;
import java.awt.*;
import javax.swing.*;
/**
 * Main Menu for an authenticated user
 * @author Abir Ghosh
 * @author Jan Zajaczkowski
 */
public class ExistingCustomer extends JFrame{
    
    //customer's full name
    private JTextField name = new JTextField(11);
    //field for customer address
    private JTextField address = new JTextField(9);
    //customer ohone number
    private JTextField phoneNumber = new JTextField(10);
    //show previious order
    private JTextArea orderHistory = new JTextArea();
    //add new order button 
    private JButton newOrder = new JButton("New Order");
    //button to repeat the last order 
    private JButton repeat = new JButton("Repeat Previous Order");
    //button to find another customer
    private JButton findACustomer = new JButton("Find Another Customer");
    
    public ExistingCustomer(){
        JPanel newCustomer = new JPanel();
        //setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
        setLayout(new GridLayout(6,2));
        
        add(new JLabel("Phone # "));
        add(phoneNumber);
        
        add(new JLabel("Name "));
        add(name);
        
        add(new JLabel("Address "));
        add(address);
        
        add(new JLabel("Order History "));
        add(orderHistory);
        
        add(newOrder);
        add(repeat);
        add(findACustomer);
        
        
    }
    
    public static void main(String[] args) {
    ExistingCustomer frame = new ExistingCustomer();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Existing Cusotomer Info");
    frame.setSize(350,200);
    frame.setVisible(true);
    }
    
}
