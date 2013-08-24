/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.awt.*;
import javax.swing.*;

/**
 * New Order GUI
 * @author Abir Ghosh
 * @author Jan Zajaczkowski
 */
public class NewOrder extends JFrame{
    
    //JTextField for item's name or number
    private JTextField item = new JTextField(11);
    //quantity of the item ordered
    private JTextField quantity = new JTextField(9);
    //price of the item
    private JTextField price = new JTextField(10);
    //add new order button 
    private JButton addOrder = new JButton("Add Order");
    //cancel button to close the page or return to previous page 
    private JButton cancel = new JButton("Cancel");
    
    public NewOrder(){
        JPanel newCustomer = new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
        
        //JPanel NewOrder = new JPanel();
        //setLayout(new GridLayout(3,3));
        
        add(new JLabel("Item "));
        add(item);
        
        add(new JLabel("Quantity"));//, BorderLayout.WEST);
        add(quantity);

        add(new JLabel("Price $"));//, BorderLayout.WEST);
        add(price);
        
        add(addOrder);
        add(cancel);
    }
    
    
    
    public static void main(String[] args) {
         NewOrder frame = new NewOrder();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("New Order");
    frame.setSize(220,250);
    frame.setVisible(true);
    }
    
}
