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

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1, l2, l3, l4;

    MiniStatement(String pin) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);  // Set bounds for l1
        add(l1);

        l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 200, 20);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        setLayout(null);

        b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 25);
        add(b1);

        b1.addActionListener(this);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (rs.next()) {
                l3.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            } else {
                l3.setText("No matching card number found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            StringBuilder transactions = new StringBuilder("<html>");
            while (rs.next()) {
                transactions.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("amount")).append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            transactions.append("</html>");
            l1.setText(transactions.toString());
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
