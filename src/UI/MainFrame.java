package UI;

import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Calendar;

public class MainFrame extends JFrame {
    private JPanel infoPanel;
    private JButton calendarButton;
    private JButton settingsButton;
    private JButton listButton;

    private JPanel yearMonthPanel;
    private JLabel monthLabel,yearLabel;
    private JButton rightNavButton,leftNavButton;
    private JPanel calendarPanel;

    private JPanel listPanel;

    private JPanel settingsPanel;

    private String[] monthsName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private String[] headers = { "Sun", "Mon",
            "Tues", "Wed", "Thurs", "Fri",
            "Sat" };
    private int monthsCount, yearCount = 2019;

    public MainFrame() {

        setListPanel();
        setSettingsPanel();
        setYearMonthPanel();
        setSettingsButton();
        setListButton();
        setCalendarButton();
        setInfoPanel();

        this.setSize(800,835);
        this.setTitle("Vietnamese Calendar");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.repaint();
        this.validate();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(infoPanel);
        this.add(yearMonthPanel);
        this.add(settingsPanel);
        this.add(listPanel);
    }

    //Change Panel

    private void changetoCalendarPanel(){
        settingsPanel.setVisible(false);
        yearMonthPanel.setVisible(true);
        listPanel.setVisible(false);
    }

    private void changetoListPanel(){
        yearMonthPanel.setVisible(false);
        settingsPanel.setVisible(false);
        listPanel.setVisible(true);
    }

    private void changetoSettingsPanel(){
        yearMonthPanel.setVisible(false);
        settingsPanel.setVisible(true);
        listPanel.setVisible(false);
    }

    //Info Panel

    private void setInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(0,0,200,800);
        infoPanel.setBackground(Color.decode("#4286f4"));
        infoPanel.add(calendarButton);
        infoPanel.add(settingsButton);
        infoPanel.add(listButton);
    }

    private void setListButton() {
        try {
            BufferedImage icon = ImageIO.read(new File("List.png"));
            listButton = new JButton(new ImageIcon(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        listButton.setBounds(0,400,200,200);
        listButton.setBackground(Color.decode("#4286f4"));
        MaterialUIMovement.add(listButton, MaterialColors.BLUE_100);
        listButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changetoListPanel();
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

    private void setCalendarButton() {

        try {
            BufferedImage icon = ImageIO.read(new File("Calendar.png"));
            calendarButton = new JButton(new ImageIcon(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        calendarButton.setBounds(0,200,200,200);
        calendarButton.setBackground(Color.decode("#4286f4"));
        MaterialUIMovement.add(calendarButton, MaterialColors.BLUE_100);
        calendarButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changetoCalendarPanel();
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

    private void setSettingsButton(){
        try {
            BufferedImage icon = ImageIO.read(new File("Settings.png"));
            settingsButton = new JButton(new ImageIcon(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        settingsButton.setBounds(0,600,200,200);
        settingsButton.setBackground(Color.decode("#4286f4"));
        MaterialUIMovement.add(settingsButton, MaterialColors.BLUE_100);
        settingsButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changetoSettingsPanel();
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

    //Calendar Panel

    private void setYearMonthPanel() {

        setCalendarPanel();
        setMonthLabel();
        setYearLabel();
        setNavButton();

        yearMonthPanel = new JPanel();
        yearMonthPanel.setLayout(null);
        yearMonthPanel.setBounds(200,0,600,800);
        yearMonthPanel.setBackground(Color.white);
        yearMonthPanel.setVisible(false);
        yearMonthPanel.add(monthLabel);
        yearMonthPanel.add(rightNavButton);
        yearMonthPanel.add(leftNavButton);
        yearMonthPanel.add(calendarPanel);
        yearMonthPanel.add(yearLabel);
    }

    private void setYearLabel() {
        yearLabel = new JLabel();
        yearLabel.setBounds(400,50,100,50);
        yearLabel.setText("" + yearCount);
        yearLabel.setFont(new Font("NotoSans-Black", Font.PLAIN, 28));
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame jFrame = new JFrame("Choose Year");
                jFrame.setLocationRelativeTo(null);
                jFrame.setLayout(null);
                jFrame.setSize(new Dimension(300,300));
                jFrame.setVisible(true);
                JTextField jTextField = new JTextField(yearLabel.getText());
                jTextField.setBounds(50,50,200,50);
                JButton jButton = new JButton("Ok");
                jButton.setBounds(100,150,75,50);
                MaterialUIMovement.add(jButton,MaterialColors.BLUE_100);
                jFrame.add(jButton);
                jFrame.add(jTextField);
                jButton.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        yearCount = Integer.valueOf(jTextField.getText());
                        if(yearCount < 1900 || yearCount > 2050){
                            JOptionPane.showMessageDialog(jFrame,"This year is unavailable");
                        }
                        else{
                            jFrame.dispose();
                            yearLabel.setText(jTextField.getText());
                            calendarPanel.removeAll();
                            setCalendarPanel();
                            yearMonthPanel.add(calendarPanel);
                        }
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

    private void setMonthLabel() {
        monthLabel = new JLabel();
        monthLabel.setBounds(50,50,160,50);
        monthLabel.setText(monthsName[monthsCount]);
        monthLabel.setFont(new Font("NotoSans-Black", Font.PLAIN, 28));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setNavButton(){
        try {
            BufferedImage icon = ImageIO.read(new File("rightNav.png"));
            rightNavButton = new JButton(new ImageIcon(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        rightNavButton.setBounds(210,50,50,50);
        MaterialUIMovement.add(rightNavButton,MaterialColors.BLUE_100);
        rightNavButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                monthsCount++;
                if (monthsCount == 12) monthsCount = 0;
                monthLabel.setText(monthsName[monthsCount]);
                calendarPanel.removeAll();
                setCalendarPanel();
                yearMonthPanel.add(calendarPanel);
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

        try {
            BufferedImage icon = ImageIO.read(new File("leftNav.png"));
            leftNavButton = new JButton(new ImageIcon(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        leftNavButton.setBounds(0,50,50,50);
        MaterialUIMovement.add(leftNavButton,MaterialColors.BLUE_100);
        leftNavButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                monthsCount--;
                if (monthsCount == -1) monthsCount = 11;
                monthLabel.setText(monthsName[monthsCount]);
                calendarPanel.removeAll();
                setCalendarPanel();
                yearMonthPanel.add(calendarPanel);
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

    private void setCalendarPanel(){
        calendarPanel = new JPanel();
        GridLayout layout = new GridLayout(0,7);
        layout.setVgap(5);
        layout.setHgap(5);
        calendarPanel.setLayout(layout);
        calendarPanel.setBounds(0,100,600,700);

// Use for-each loop.
        for (String header : headers) {
            JButton jButton = new JButton(header);
            MaterialUIMovement.add(jButton, MaterialColors.BLUE_100);
            calendarPanel.add(jButton);
        }
// Add days to calendar, use String.valueOf
//        for (int i = 1; i < 31; i++) {
//            JButton jButton = new JButton(String.valueOf(i));
//            MaterialUIMovement.add(jButton, MaterialColors.BLUE_100);
//            calendarPanel.add(jButton);

        System.out.println(yearCount);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, monthsCount);
        calendar.set(Calendar.YEAR, yearCount);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar iterator = (Calendar) calendar.clone();
        iterator.add(Calendar.DAY_OF_MONTH,
                -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

        Calendar maximum = (Calendar) calendar.clone();
        maximum.add(Calendar.MONTH, +1);

        int count = 0;
        int limit = headers.length * 6;

        while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
            int lMonth = iterator.get(Calendar.MONTH);
            int lYear = iterator.get(Calendar.YEAR);

            JButton dayLabel = new JButton();
            MaterialUIMovement.add(dayLabel, MaterialColors.BLUE_100);

            if ((lMonth == monthsCount) && (lYear == yearCount)) {
                int lDay = iterator.get(Calendar.DAY_OF_MONTH);
                dayLabel.setText(Integer.toString(lDay));
                dayLabel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        openWebpage("https://lichvannien365.com/xem-ngay-tot-xau-ngay-"+ lDay + "-" + (lMonth+1) + "-" +lYear);
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

            calendarPanel.add(dayLabel);
            iterator.add(Calendar.DAY_OF_YEAR, +1);
            count++;
        }

        for (int i = count; i < limit; i++) {
            JButton jButton = new JButton();
            MaterialUIMovement.add(jButton, MaterialColors.BLUE_100);
            calendarPanel.add(jButton);
        }
        calendarPanel.setVisible(true);
    }


    private void setListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(null);
        listPanel.setBounds(200,0,600,800);
        listPanel.setBackground(Color.blue);
        listPanel.setVisible(false);
    }

    private void setSettingsPanel(){
        settingsPanel =  new JPanel();
        settingsPanel.setLayout(null);
        settingsPanel.setBounds(200,0,600,800);
        settingsPanel.setBackground(Color.white);
        settingsPanel.setVisible(false);
    }

    private static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
