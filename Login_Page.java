package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login_Page extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField2;
    JButton signin, clear, signup;
    Login_Page(){
        super("Bank Management system");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM !");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Forte",Font.BOLD,38));
        label1.setBounds(150,125,450,40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Aerial",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField1 = new JTextField(15);
        textField1.setBounds(325,190,230,30);
        textField1.setFont(new Font("Aerial",Font.BOLD,14));
        add(textField1);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Aerial",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(325,250,230,30);
        passwordField2.setFont(new Font("Aerial",Font.BOLD,14));
        add(passwordField2);

        signin = new JButton("Sign In");
        signin.setFont(new Font("Aerial",Font.BOLD,14));
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setBounds(300,300,100,30);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("Clear");
        clear.setFont(new Font("Aerial",Font.BOLD,14));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setFont(new Font("Aerial",Font.BOLD,14));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        setLayout(null);
        setSize(850,480);
        setLocation(350,180);
//        setUndecorated(true); for not having all the borders and name and minimize maximize button
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if (e.getSource() == signin){
                Con c = new Con();
                String cardno = textField1.getText();
                String pin = passwordField2.getText();
                String q = "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultset = c.statement.executeQuery(q);
                if(resultset.next()){
                    setVisible(false);
                    new main_class(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card number / pin ");
                }

            }else if (e.getSource() == clear){
                textField1.setText("");
                passwordField2.setText("");
            }else if (e.getSource() == signup){
                new signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login_Page();
    }
}

// 2nd video completed

