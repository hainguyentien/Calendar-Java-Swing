package UI;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginFrame extends JFrame {
    private JButton loginButton;
    private JPanel loginPanel;
    private JLabel laterLabel;

    public LoginFrame(){
        setLoginButton();

        setLaterLabel();

        setLoginPanel();

        this.add(loginPanel,BorderLayout.CENTER);
        this.setSize(800, 800);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.repaint();
        this.validate();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setUnvisible(){
        this.setVisible(false);
    }

    private void showLog(){
        JOptionPane.showMessageDialog(this,"This Feature is on update!");
    }

    private void setLoginButton() {
        loginButton = new JButton("Login with Google");
        loginButton.setBounds(300,365,200,70);
        loginButton.setBackground(Color.red);
        MaterialUIMovement.add(loginButton, MaterialColors.GRAY_500);
        loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showLog();
                setUnvisible();
                new MainFrame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void setLaterLabel() {
        laterLabel = new JLabel();
        laterLabel.setText("Sign-in Later");
        laterLabel.setBounds(350,450,100,50);
        laterLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setUnvisible();
                new MainFrame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void setLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setBounds(0,0,800,800);
        loginPanel.setLayout(null);
        loginPanel.add(loginButton);
        loginPanel.add(laterLabel);
    }
}
