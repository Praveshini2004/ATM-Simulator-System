/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulatorsystem;

/**
 *
 * @author DELL
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Transactions(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 860, 980);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        int centerX = 760 / 2;
        
        l1.setBounds(centerX - 200, 100, 400, 35);
        l2.add(l1);

        b1.setBounds(centerX - 180, 180, 150, 35);
        l2.add(b1);

        b2.setBounds(centerX + 30, 180, 150, 35);
        l2.add(b2);

        b3.setBounds(centerX - 180, 225, 150, 35);
        l2.add(b3);

        b4.setBounds(centerX + 30, 225, 150, 35);
        l2.add(b4);

        b5.setBounds(centerX - 180, 270, 150, 35);
        l2.add(b5);

        b6.setBounds(centerX + 30, 270, 150, 35);
        l2.add(b6);

        b7.setBounds(centerX + 30, 315, 150, 35);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);
        setLocation(10, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if(ae.getSource() == b2){ 
            setVisible(false);
             new Withdrawl(pin).setVisible(true);
        } else if(ae.getSource() == b3){ 
            setVisible(false);
             new FastCash(pin).setVisible(true);
        } else if(ae.getSource() == b4){ 
             new MiniStatement(pin).setVisible(true);
        } else if(ae.getSource() == b5){ 
            setVisible(false);
             new Pin(pin).setVisible(true);
        } else if(ae.getSource() == b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if(ae.getSource() == b7){ 
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}
