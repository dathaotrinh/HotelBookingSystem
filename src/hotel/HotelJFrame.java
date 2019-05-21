package hotel;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Surface
 */
public class HotelJFrame extends javax.swing.JFrame {

    /**
     * Creates new form HotelJFrame
     */
    Connection conn = null; // declare a Connection object named conn and assign null to conn
    Statement stmt = null; // declare a Statement object named stmt and assign null to stmt
  
    public HotelJFrame() { // create a constructor for HotelJFrame
        initComponents();  // include all the things declared in the initComponents method to the contructor
    //    showTableData();
    
        setTextsManager();
        
        try{
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel");
        // use getConnection method to connect to the database

        stmt = conn.createStatement();
        // in the connection to the database, create a statement and assign it back to stmt
        
        } catch(SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of

        }
    }
    
    private void getInfo(ResultSet rs) throws SQLException
    {
        int resID = rs.getInt("RES_ID");
        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");
        String nationality = rs.getString("NATIONALITY");
        String guestType = rs.getString("GUEST_TYPE");
        String roomType = rs.getString("ROOM_TYPE");
        int roomNum = rs.getInt("ROOM_NUMBER");      
        int numGuest = rs.getInt("NUM_GUESTS");
        int limit = rs.getInt("LIMIT");
        float deposit = rs.getFloat("DEPOSIT");
        float total = rs.getFloat("TOTAL");
        float paid = rs.getFloat("PAID");        
        String inDate = rs.getString("CHECK_IN");
        String outDate = rs.getString("CHECK_OUT");
        String phone = rs.getString("PHONE");
        String email = rs.getString("EMAIL");
        String note = rs.getString("NOTE");
    }
    
    private void setGuestType(String guestType)
    {

        if(guestType.equals("Walk-in Guest"))
        {
            walkIn.setSelected(true);
        }
        else if(guestType.equals("Airbnb.com"))
        {
            airBnb.setSelected(true);
        }
        else if(guestType.equals("Booking.com"))
        {
            booking.setSelected(true);
        }
        else if(guestType.equals("Hotels.com"))
        {
            hotels.setSelected(true);
        }
        else if(guestType.equals("TripAdvisors"))
        {
            tripA.setSelected(true);
        }
        else if(guestType.equals("Agoda"))
        {
            agoda.setSelected(true);
        }
        else if(guestType.equals("Expedia"))
        {
            expedia.setSelected(true);
        }
        else if(guestType.equals("Kayak"))
        {
            kayak.setSelected(true);
        }
        else if(guestType.equals("Priceline"))
        {
            priceLine.setSelected(true);
        }
              
    }
    
    
    private String getGuestType()
    {
        if(walkIn.isSelected())
        {
            return "Walk-in Guest";
        }
        else if(airBnb.isSelected())
        {
            return "Airbnb.com";
        }
        else if(hotels.isSelected())
        {
            return "Hotels.com";
        }
        else if(agoda.isSelected())
        {
            return "Agoda";
        }
        else if(tripA.isSelected())
        {
            return "TripAdvisors";
        }
        else if(kayak.isSelected())
        {
            return "Kayak";
        }
        else if(priceLine.isSelected())
        {
            return "Priceline";
        }
        else if(booking.isSelected())
        {
            return "Booking.com";
        }
        else
        {
            return "Expedia";
        }
    }
    
    private void setTexts(ResultSet rs) throws ParseException, SQLException
    {
        resIDValue.setText(String.valueOf(rs.getInt("RES_ID")));
        firstNameValue.setText(rs.getString("FIRST_NAME"));
        lastNameValue.setText(rs.getString("LAST_NAME"));
        nationalityValue.setText(rs.getString("NATIONALITY"));
        phoneValue.setText(rs.getString("PHONE"));
        emailValue.setText(rs.getString("EMAIL"));
        
        limitVal.setText(String.valueOf(rs.getInt("LIMIT")));
        roomNumValue.setSelectedItem(String.valueOf(rs.getInt("ROOM_NUMBER")));
        numGuestValue.setSelectedItem(String.valueOf(rs.getInt("NUM_GUESTS")));
        roomTypeValue.setSelectedItem(String.valueOf(rs.getString("ROOM_TYPE")));     
        depositValue.setText(String.valueOf(rs.getFloat("DEPOSIT")));
        totalValue.setText(String.valueOf(rs.getFloat("TOTAL")));
        paidValue.setText(String.valueOf(rs.getFloat("PAID")));
        noteField.setText(rs.getString("NOTE"));
        
        SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");
        
        Date inDateValue = dp.parse(rs.getString("CHECK_IN"));
        Date outDateValue = dp.parse(rs.getString("CHECK_OUT"));
        
        inDateChooser.setDate(inDateValue);
        outDateChooser.setDate(outDateValue);
        
        setGuestType(rs.getString("GUEST_TYPE"));    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        customerListPanel = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fullNameL = new javax.swing.JLabel();
        emailL = new javax.swing.JLabel();
        addressL = new javax.swing.JLabel();
        jobL = new javax.swing.JLabel();
        phoneL = new javax.swing.JLabel();
        fullNameVal = new javax.swing.JLabel();
        emailVal = new javax.swing.JLabel();
        addressVal = new javax.swing.JLabel();
        phoneVal = new javax.swing.JLabel();
        jobVal = new javax.swing.JLabel();
        addressL1 = new javax.swing.JLabel();
        addressVal1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        skillP = new javax.swing.JPanel();
        skillL = new javax.swing.JLabel();
        langL = new javax.swing.JLabel();
        techL = new javax.swing.JLabel();
        opL = new javax.swing.JLabel();
        langVal = new javax.swing.JLabel();
        techVal = new javax.swing.JLabel();
        opVal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        eduP = new javax.swing.JPanel();
        eduL = new javax.swing.JLabel();
        school1 = new javax.swing.JPanel();
        schoolName = new javax.swing.JLabel();
        major = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        course1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        fileChooserButton = new javax.swing.JButton();
        customerDetailsPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        resIDLabel = new javax.swing.JLabel();
        resIDValue = new javax.swing.JTextField();
        firstNameValue = new javax.swing.JTextField();
        guestNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameValue = new javax.swing.JTextField();
        phoneValue = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nationalityLabel = new javax.swing.JLabel();
        nationalityValue = new javax.swing.JTextField();
        emailValue = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        roomNumL = new javax.swing.JLabel();
        numGuestValue = new javax.swing.JComboBox<>();
        inDateLabel = new javax.swing.JLabel();
        outDateLabel = new javax.swing.JLabel();
        roomTypeValue = new javax.swing.JComboBox<>();
        numGuestL = new javax.swing.JLabel();
        roomLimitLabel = new javax.swing.JLabel();
        inDateChooser = new com.toedter.calendar.JDateChooser();
        outDateChooser = new com.toedter.calendar.JDateChooser();
        roomNumValue = new javax.swing.JComboBox<>();
        roomTypeL2 = new javax.swing.JLabel();
        limitVal = new javax.swing.JTextField();
        fullBillPanel = new javax.swing.JPanel();
        billPanel = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        depositLabel = new javax.swing.JLabel();
        totalValue = new javax.swing.JTextField();
        depositValue = new javax.swing.JTextField();
        dolaSign = new javax.swing.JLabel();
        dolaSign2 = new javax.swing.JLabel();
        paidLabel = new javax.swing.JLabel();
        dolaSign3 = new javax.swing.JLabel();
        paidValue = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        noteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteField = new javax.swing.JTextPane();
        buttonPanel = new javax.swing.JPanel();
        bPrevious = new javax.swing.JButton();
        bNew = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bNext = new javax.swing.JButton();
        customerTypePanel = new javax.swing.JPanel();
        customerFullPanel = new javax.swing.JPanel();
        expedia = new javax.swing.JRadioButton();
        agoda = new javax.swing.JRadioButton();
        tripA = new javax.swing.JRadioButton();
        hotels = new javax.swing.JRadioButton();
        kayak = new javax.swing.JRadioButton();
        priceLine = new javax.swing.JRadioButton();
        walkIn = new javax.swing.JRadioButton();
        airBnb = new javax.swing.JRadioButton();
        booking = new javax.swing.JRadioButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Manager");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        profile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/img_0381_icon.png"))); // NOI18N

        fullNameL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fullNameL.setText("Full Name:");

        emailL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailL.setText("Email:");

        addressL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressL.setText("Address:");

        jobL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jobL.setText("Position:");

        phoneL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneL.setText("Phone:");

        fullNameVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fullNameVal.setText("THAO TRINH");

        emailVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailVal.setText("dtrinh5@student.ccp.edu");

        addressVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressVal.setText("1142 Devereaux Avue");

        phoneVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneVal.setText("510-309-3885");

        jobVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jobVal.setText("Software Developer");

        addressL1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressL1.setText("Website:");

        addressVal1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressVal1.setText("jtrinh21.github.io/portfolio/");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fullNameL))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(addressL))
                            .addComponent(emailL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addressVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fullNameVal, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(emailVal, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneL)
                                    .addComponent(jobL, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jobVal, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(phoneVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addressL1)
                        .addGap(38, 38, 38)
                        .addComponent(addressVal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullNameVal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobVal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailVal, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressL, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(addressVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ABOUT ME");

        skillL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        skillL.setText("SKILLS");

        langL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        langL.setText("Languages:");

        techL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        techL.setText("Technologies:");

        opL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opL.setText("Systems & Tools:");

        langVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        techVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        opVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout skillPLayout = new javax.swing.GroupLayout(skillP);
        skillP.setLayout(skillPLayout);
        skillPLayout.setHorizontalGroup(
            skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skillPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(skillPLayout.createSequentialGroup()
                        .addComponent(skillL, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(skillPLayout.createSequentialGroup()
                        .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(techL)
                            .addComponent(langL)
                            .addComponent(opL))
                        .addGap(19, 19, 19)
                        .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(langVal, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(techVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        skillPLayout.setVerticalGroup(
            skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skillPLayout.createSequentialGroup()
                .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skillL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(skillPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(skillPLayout.createSequentialGroup()
                        .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(langL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(langVal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(techL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(techVal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(skillPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opVal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        eduL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eduL.setText("EDUCATION");

        schoolName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        schoolName.setText("Community College of Philadelphia - Philadelphia, PA");

        major.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        major.setText("Computer Science, 2017 - Present, GPA: 4.0");

        course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        course.setText("Data Structure and Algorithms, Object-Oriented Programming, Disrete Math");

        course1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        course1.setText("Introduction to Computer Organization, Database Managment Systems");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-checkmark-20.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-checkmark-20.png"))); // NOI18N

        javax.swing.GroupLayout school1Layout = new javax.swing.GroupLayout(school1);
        school1.setLayout(school1Layout);
        school1Layout.setHorizontalGroup(
            school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(school1Layout.createSequentialGroup()
                .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(school1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(major, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(school1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(schoolName, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(school1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(course1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        school1Layout.setVerticalGroup(
            school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(school1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(schoolName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(major, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(course, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(school1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(course1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout eduPLayout = new javax.swing.GroupLayout(eduP);
        eduP.setLayout(eduPLayout);
        eduPLayout.setHorizontalGroup(
            eduPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eduPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(school1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(eduPLayout.createSequentialGroup()
                        .addComponent(eduL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        eduPLayout.setVerticalGroup(
            eduPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPLayout.createSequentialGroup()
                .addGroup(eduPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eduL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(eduPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(school1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        fileChooserButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fileChooserButton.setText("Choose picture");
        fileChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerListPanelLayout = new javax.swing.GroupLayout(customerListPanel);
        customerListPanel.setLayout(customerListPanelLayout);
        customerListPanelLayout.setHorizontalGroup(
            customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerListPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerListPanelLayout.createSequentialGroup()
                        .addComponent(eduP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(customerListPanelLayout.createSequentialGroup()
                        .addGroup(customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skillP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customerListPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerListPanelLayout.createSequentialGroup()
                                .addComponent(fileChooserButton)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerListPanelLayout.createSequentialGroup()
                                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))))))
        );
        customerListPanelLayout.setVerticalGroup(
            customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerListPanelLayout.createSequentialGroup()
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(fileChooserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(customerListPanelLayout.createSequentialGroup()
                        .addGroup(customerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skillP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(eduP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPane.addTab("Manager Details", customerListPanel);

        customerDetailsPanel.setToolTipText("");
        customerDetailsPanel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerDetailsPanel.setName("Hotel Manager"); // NOI18N

        resIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resIDLabel.setText("Reservation ID:");

        resIDValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        firstNameValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        guestNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        guestNameLabel.setText("First Name:");

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastNameLabel.setText("Last Name:");

        lastNameValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        phoneValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneLabel.setText("Phone Number:");

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailLabel.setText("Email:");

        nationalityLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nationalityLabel.setText("Nationality:");

        nationalityValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        emailValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-13.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resIDLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(emailLabel)
                    .addComponent(nationalityLabel)
                    .addComponent(phoneLabel)
                    .addComponent(guestNameLabel))
                .addGap(24, 24, 24)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneValue)
                    .addComponent(emailValue)
                    .addComponent(lastNameValue)
                    .addComponent(firstNameValue)
                    .addComponent(nationalityValue)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(resIDValue, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resIDValue)
                    .addComponent(resIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guestNameLabel)
                    .addComponent(firstNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationalityLabel)
                    .addComponent(nationalityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        roomNumL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomNumL.setText("Room Number:");

        numGuestValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numGuestValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8" }));
        numGuestValue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                numGuestValueItemStateChanged(evt);
            }
        });

        inDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inDateLabel.setText("Check-in Date:");

        outDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        outDateLabel.setText("Check-out Date:");

        roomTypeValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomTypeValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Twin", "Double", "Double-double", "Quad", "Executive Suite", "Apartment" }));

        numGuestL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numGuestL.setText("Number of Guests:");

        roomLimitLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomLimitLabel.setText("Room Limit:");

        inDateChooser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        outDateChooser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        roomNumValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomNumValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        roomTypeL2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomTypeL2.setText("Room Type:");

        limitVal.setEditable(false);
        limitVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        totalLabel.setText("Total:");

        depositLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        depositLabel.setText("Deposit:");

        totalValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        depositValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dolaSign.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dolaSign.setText("$");

        dolaSign2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dolaSign2.setText("$");

        paidLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paidLabel.setText("Paid:");

        dolaSign3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dolaSign3.setText("$");

        paidValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(depositLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addComponent(paidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dolaSign2)
                    .addComponent(dolaSign)
                    .addComponent(dolaSign3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalValue)
                    .addComponent(depositValue)
                    .addComponent(paidValue, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dolaSign))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(depositValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dolaSign2))
                    .addComponent(depositLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dolaSign3)
                            .addComponent(paidValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        noteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noteLabel.setText("Note:");

        noteField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(noteField);

        javax.swing.GroupLayout fullBillPanelLayout = new javax.swing.GroupLayout(fullBillPanel);
        fullBillPanel.setLayout(fullBillPanelLayout);
        fullBillPanelLayout.setHorizontalGroup(
            fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fullBillPanelLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addGroup(fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fullBillPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fullBillPanelLayout.createSequentialGroup()
                            .addComponent(jSeparator8)
                            .addGap(1, 1, 1))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)))
        );
        fullBillPanelLayout.setVerticalGroup(
            fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullBillPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fullBillPanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(fullBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6)
                        .addComponent(jSeparator5)
                        .addGroup(fullBillPanelLayout.createSequentialGroup()
                            .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 11, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inDateLabel)
                    .addComponent(roomLimitLabel)
                    .addComponent(outDateLabel)
                    .addComponent(roomNumL)
                    .addComponent(roomTypeL2)
                    .addComponent(numGuestL))
                .addGap(27, 27, 27)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numGuestValue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomTypeValue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomNumValue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limitVal)
                    .addComponent(inDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(fullBillPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numGuestL)
                    .addComponent(numGuestValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomTypeL2)
                    .addComponent(roomTypeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNumValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNumL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limitVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomLimitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outDateLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(fullBillPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bPrevious.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        bPrevious.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPrevious.setText("Previous");
        bPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreviousActionPerformed(evt);
            }
        });

        bNew.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        bNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bNew.setText("New");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        bSave.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleBackground"));
        bSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bDelete.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleBackground"));
        bDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bNext.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        bNext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bNext.setText("Next");
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(bNext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(627, Short.MAX_VALUE)))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNext)
                    .addComponent(bDelete)
                    .addComponent(bSave)
                    .addComponent(bNew))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(bPrevious)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        buttonGroup.add(expedia);
        expedia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        expedia.setText("Expedia");

        buttonGroup.add(agoda);
        agoda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agoda.setText("Agoda");

        buttonGroup.add(tripA);
        tripA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tripA.setText("TripAdvisors");

        buttonGroup.add(hotels);
        hotels.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hotels.setText("Hotels.com");

        buttonGroup.add(kayak);
        kayak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kayak.setText("Kayak");

        buttonGroup.add(priceLine);
        priceLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priceLine.setText("Priceline");

        buttonGroup.add(walkIn);
        walkIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        walkIn.setText("Walk-in Guest");

        buttonGroup.add(airBnb);
        airBnb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        airBnb.setText("Airbnb.com");

        buttonGroup.add(booking);
        booking.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        booking.setText("Booking.com");

        javax.swing.GroupLayout customerFullPanelLayout = new javax.swing.GroupLayout(customerFullPanel);
        customerFullPanel.setLayout(customerFullPanelLayout);
        customerFullPanelLayout.setHorizontalGroup(
            customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFullPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFullPanelLayout.createSequentialGroup()
                        .addComponent(booking)
                        .addGap(20, 20, 20)
                        .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expedia)
                            .addComponent(agoda)
                            .addComponent(tripA)))
                    .addComponent(walkIn)
                    .addComponent(airBnb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotels)
                    .addComponent(kayak)
                    .addComponent(priceLine))
                .addContainerGap())
        );
        customerFullPanelLayout.setVerticalGroup(
            customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerFullPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walkIn)
                    .addComponent(expedia)
                    .addComponent(priceLine))
                .addGap(11, 11, 11)
                .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airBnb)
                    .addComponent(agoda)
                    .addComponent(kayak))
                .addGap(11, 11, 11)
                .addGroup(customerFullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(booking)
                    .addComponent(tripA)
                    .addComponent(hotels))
                .addGap(17, 17, 17))
        );

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout customerTypePanelLayout = new javax.swing.GroupLayout(customerTypePanel);
        customerTypePanel.setLayout(customerTypePanelLayout);
        customerTypePanelLayout.setHorizontalGroup(
            customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerTypePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customerTypePanelLayout.createSequentialGroup()
                            .addComponent(jSeparator11)
                            .addGap(1, 1, 1))
                        .addComponent(customerFullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)))
        );
        customerTypePanelLayout.setVerticalGroup(
            customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerTypePanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customerTypePanelLayout.createSequentialGroup()
                            .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerTypePanelLayout.createSequentialGroup()
                            .addGroup(customerTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(customerFullPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(10, 10, 10)))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout customerDetailsPanelLayout = new javax.swing.GroupLayout(customerDetailsPanel);
        customerDetailsPanel.setLayout(customerDetailsPanelLayout);
        customerDetailsPanelLayout.setHorizontalGroup(
            customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                        .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(customerTypePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        customerDetailsPanelLayout.setVerticalGroup(
            customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customerDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerDetailsPanelLayout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        tabbedPane.addTab("Customer Details", customerDetailsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviousActionPerformed
        // TODO add your handling code here:
        try{

            if(!resIDValue.getText().equals(""))
            {
                ResultSet rs = stmt.executeQuery("SELECT * FROM GUESTS WHERE RES_ID < " + Integer.parseInt(resIDValue.getText()) 
                                            + " ORDER BY RES_ID DESC");                  

                if(rs.next()){
                // point the cursor to the first resultset and then the next one until the cursor reaches the last one
                    setTexts(rs);           
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "There is no other data before this.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Reservation ID required.");
            }

        } catch (SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of

        } catch (ParseException ex) {
            Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bPreviousActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        // TODO add your handling code here:

        // reset every information displays in the program to empty
        resIDValue.setText("");
        firstNameValue.setText("");
        lastNameValue.setText("");
        phoneValue.setText("");
        emailValue.setText("");
        nationalityValue.setText("");
        numGuestValue.setSelectedItem("Select");
        roomNumValue.setSelectedItem("Select");
        totalValue.setText("");
        depositValue.setText("");
        limitVal.setText("None");
        paidValue.setText("");
        walkIn.setSelected(true);
        inDateChooser.setDate(new java.util.Date());
        outDateChooser.setDate(new java.util.Date());
        noteField.setText("");
        
        try{

            ResultSet rs = stmt.executeQuery("SELECT MAX(RES_ID) FROM GUESTS");
            // execute all the information of the highest Reservation ID

            rs.next();
            // point the cursor to the first row

            int count = rs.getInt(1);
            // create an integer data type named count
            // assign the value of the first column, first row to count

            resIDValue.setText(String.valueOf(count + 1));
            // set the reservation ID in the program to the new reservation
            // (next to the highest number of reservation ID at the time)

        } catch (SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of
        }
    }//GEN-LAST:event_bNewActionPerformed
    
    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
             
        try{
            
            boolean alreadyExist = true; // create a boolean named alreadyExist and set it to true
            boolean doubleBooked = false; // create a boolean named doubleBooked and set it to false

             Statement stmtInsert = conn.createStatement();
            // in the connection to the database, create a statement and assign it back to stmtInsert
            // stmtInsert will be used later on when the user wants to insert new reservation to the table
            Statement stmtDoubleBooked = conn.createStatement();
            // in the connection to the database, create a statement and assign it back to stmtDoubleBooked
            // stmtDoubleBooked will be used later on to check double booking
            
            // assign the resultset of the Select query to resultset named rs
            ResultSet rs = stmt.executeQuery("SELECT * FROM GUESTS");         
                                   
            // declare String named sqlUpdate
            String sqlUpdate = "UPDATE GUESTS SET FIRST_NAME = ?, LAST_NAME = ?, NATIONALITY = ?, GUEST_TYPE = ?, ROOM_TYPE = ?, ROOM_NUMBER = ?, NUM_GUESTS = ?, LIMIT = ?, DEPOSIT = ?, TOTAL = ?, PAID = ?, CHECK_IN = ?, CHECK_OUT = ?, PHONE = ?, EMAIL = ?, NOTE = ? WHERE RES_ID = ?"; 
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");            
            String inDate = df.format(inDateChooser.getDate());
            String outDate = df.format(outDateChooser.getDate());
            
            int roomNumber  = Integer.parseInt(roomNumValue.getSelectedItem().toString());                     
        
            // declare String named sqlInsert
            String sqlInsert = "INSERT INTO GUESTS VALUES ('" 
                    +  firstNameValue.getText()
                    + "', '" + lastNameValue.getText()
                    + "', " + Integer.parseInt(resIDValue.getText())
                    + ", '" + nationalityValue.getText()
                    + "', '" + getGuestType()
                    + "', '" + roomTypeValue.getSelectedItem().toString()
                    + "', " + Integer.parseInt(roomNumValue.getSelectedItem().toString())
                                + ", " + Integer.parseInt(numGuestValue.getSelectedItem().toString())
                                + ", " + Integer.parseInt(limitVal.getText())
                                + ", " + Float.parseFloat(depositValue.getText())
                                        + ", " + Float.parseFloat(totalValue.getText())
                                        + ", " + Float.parseFloat(paidValue.getText())
                                        + ", '" + inDate + "', '" + outDate
                                        + "', '" + phoneValue.getText()
                                        + "', '" + emailValue.getText() 
                                        + "', '" + noteField.getText() + "')"  ;
                         
            boolean needToCheckRoom = false;
            boolean needToCheckDate = false;
            boolean sameRES = false;

            while(rs.next())
            {
                if(rs.getInt("RES_ID") == Integer.parseInt(resIDValue.getText()))
                {
                    sameRES= true;
                    
                    
                    java.util.Date checkIn = df.parse(String.valueOf(rs.getDate("CHECK_IN")));
                    java.util.Date checkOut = df.parse(String.valueOf(rs.getDate("CHECK_OUT")));            
                    java.util.Date dateIn = inDateChooser.getDate();
                    java.util.Date dateOut = outDateChooser.getDate();                
                    
                    
                    if(checkIn.equals(dateIn) && checkOut.equals(dateOut)
                            && rs.getInt("ROOM_NUMBER") == Integer.parseInt(roomNumValue.getSelectedItem().toString()))
                    {

                        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
                        ps.setString(1, firstNameValue.getText());
                        ps.setString(2, lastNameValue.getText());
                        ps.setString(3, nationalityValue.getText());
                        ps.setString(4, getGuestType());
                        ps.setString(5, roomTypeValue.getSelectedItem().toString());
                        ps.setInt(6, Integer.parseInt(roomNumValue.getSelectedItem().toString()));
                        ps.setInt(7, Integer.parseInt(numGuestValue.getSelectedItem().toString()));
                        ps.setInt(8, Integer.parseInt(limitVal.getText()));
                        ps.setFloat(9, Float.parseFloat(depositValue.getText()));
                        ps.setFloat(10, Float.parseFloat(totalValue.getText()));            
                        ps.setFloat(11, Float.parseFloat(paidValue.getText()));                                           
                        ps.setString(12, inDate);
                        ps.setString(13, outDate);
                        ps.setString(14, phoneValue.getText());
                        ps.setString(15, emailValue.getText());  
                        ps.setString(16, noteField.getText());
                        ps.setInt(17, Integer.parseInt(resIDValue.getText())); 
                        ps.executeUpdate();      
                        
                        JOptionPane.showMessageDialog(this, "Updated eservation ID " + resIDValue.getText() + ".");                        
                    }
                    else if(checkIn.equals(dateIn) && checkOut.equals(dateOut)
                            && rs.getInt("ROOM_NUMBER") != Integer.parseInt(roomNumValue.getSelectedItem().toString()))
                            {
                                ResultSet rs3 = stmtDoubleBooked.executeQuery(
                                            "SELECT ROOM_NUMBER, CHECK_IN, CHECK_OUT\n" +
                                            "FROM GUESTS\n" +
                                            "WHERE ROOM_NUMBER = " + roomNumber + "\n" +
                                            "AND NOT\n" +
                                            " (\n" +
                                            "  ('" + outDate + "' <= CHECK_IN AND '" + outDate + "' > '" + inDate + "')\n" +
                                            "  OR ('" + inDate + "' >= CHECK_OUT AND '" + outDate + "' > '" + inDate + "')\n" +
                                            ")" );

                                        if(rs3.next())
                                        {
                                            doubleBooked = true;
                                        }

                                        if(doubleBooked)
                                        {
                                            JOptionPane.showMessageDialog(this, 
                                                                    "Double booking detected");
                                        }
                                
                            }
                    else
                    {
                         needToCheckDate = true;
                    }
                }
            }

            if((sameRES==false) || (sameRES==true && needToCheckDate==true))           
            {                      
                ResultSet rs1 = stmtDoubleBooked.executeQuery(
                        "SELECT ROOM_NUMBER, CHECK_IN, CHECK_OUT\n" +
                        "FROM GUESTS\n" +
                        "WHERE ROOM_NUMBER = " + roomNumber + "\n" +
                        "AND NOT\n" +
                        " (\n" +
                        "  ('" + outDate + "' <= CHECK_IN AND '" + outDate + "' > '" + inDate + "')\n" +
                        "  OR ('" + inDate + "' >= CHECK_OUT AND '" + outDate + "' > '" + inDate + "')\n" +
                        ")" );

                if(rs1.next())
                {
                    doubleBooked = true;
                }

                if(doubleBooked)
                {
                    JOptionPane.showMessageDialog(this, 
                            "Double booking detected");
                }

                ResultSet rs3 = stmt.executeQuery("SELECT * FROM GUESTS");  
                if((sameRES==false && doubleBooked == false)
                    || (sameRES==true && needToCheckDate==true && doubleBooked == false && needToCheckRoom == false))
                {
                    
                    while(rs3.next())
                    {
                   
                        if(rs3.getInt("RES_ID") != Integer.parseInt(resIDValue.getText()))
                        
                        {
                            alreadyExist = false; // if not already exist, then it false
                        }                                
                    }
                }
            
                if (alreadyExist == false)
                {     
                    stmtInsert.execute(sqlInsert); 
                
                    JOptionPane.showMessageDialog(this, "Saved reservation ID " + resIDValue.getText());               
                    
                }         
            }      

        } catch (SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of
        } catch (ParseException ex) {
            Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        try{

            stmt.executeUpdate("DELETE FROM GUESTS WHERE RES_ID = " + resIDValue.getText());
            // use executeUpdate to delete a reservation ID and the whole information included with that RES_ID
            // that the user wants to

            JOptionPane.showMessageDialog(this, "Deleted reservation ID " + resIDValue.getText() + ".");
            // print out DELETED

        } catch (SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        // TODO add your handling code here:
        try{

            if(!resIDValue.getText().equals(""))
            {
                ResultSet rs = stmt.executeQuery("SELECT * FROM GUESTS WHERE RES_ID > " + Integer.parseInt(resIDValue.getText()) 
                                            + " ORDER BY RES_ID ASC");             

                if(rs.next()){
                // point the cursor to the first resultset and then the next one until the cursor reaches the last one
                    setTexts(rs);           
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Reached the end of the database.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Reservation ID required.");
            }

        } catch (SQLException e){
            e.printStackTrace();
            // print out a path of errors so that the programmer can keep track of
        } catch (ParseException ex) {
            Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bNextActionPerformed

    private void numGuestValueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numGuestValueItemStateChanged
        // TODO add your handling code here:
        List<String> a = new ArrayList<String>();
        Iterator<String> iter;
        List<String> a2 = new ArrayList<String>();
        Iterator<String> iter2;

        if(numGuestValue.getSelectedItem().equals("1")
            || numGuestValue.getSelectedItem().equals("2"))
        {
			
            roomTypeValue.removeAllItems();
            a2.add("Twin");
            a2.add("Double");
            iter2 = a2.iterator();
            while(iter2.hasNext())
            {
                roomTypeValue.addItem(iter2.next());
            }
            
        
            limitVal.setText("2");			
        }

        else if(numGuestValue.getSelectedItem().equals("4")
            || numGuestValue.getSelectedItem().equals("3"))
        {
			
            roomTypeValue.removeAllItems();
            a2.add("Quad");
            a2.add("Double-double");
            iter2 = a2.iterator();
            while(iter2.hasNext())
            {
                roomTypeValue.addItem(iter2.next());
            }

            limitVal.setText("4");
        }

        else if(numGuestValue.getSelectedItem().equals("6")
            || numGuestValue.getSelectedItem().equals("5"))
        {
            roomTypeValue.removeAllItems();
            a2.add("Executive Suite");
            iter2 = a2.iterator();
            while(iter2.hasNext())
            {
                roomTypeValue.addItem(iter2.next());
            }

            limitVal.setText("6");
        }

        else if(numGuestValue.getSelectedItem().equals("7")
            || numGuestValue.getSelectedItem().equals("8"))
        {

            roomTypeValue.removeAllItems();
            a2.add("Apartment");
            iter2 = a2.iterator();
            while(iter2.hasNext())
            {
                roomTypeValue.addItem(iter2.next());
            }

            limitVal.setText("8");
        }
        else
        {

            roomTypeValue.removeAllItems();
            a2.add("Select");
            iter2 = a2.iterator();
            while(iter2.hasNext())
            {
                roomTypeValue.addItem(iter2.next());
            }            
            limitVal.setText("None");
        }
        
        roomTypeValue.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            List<String> a = new ArrayList<String>();
            Iterator<String> iter;

            if(e.getItem().equals("Twin"))
            {
			
                roomNumValue.removeAllItems();
                a.add("1");
                a.add("2");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }
			
            }

            else if(e.getItem().equals("Double"))
            {
			
                roomNumValue.removeAllItems();
                a.add("3");
                a.add("4");
                a.add("5");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }
			
            }

            else if(e.getItem().equals("Quad"))
            {
			
                roomNumValue.removeAllItems();
                a.add("7");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }
			
            }

            else if(e.getItem().equals("Double-double"))
            {
			
                roomNumValue.removeAllItems();
                a.add("6");
                a.add("8");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }
			
            }
        
            else if(e.getItem().equals("Executive Suite"))
            {
			
                roomNumValue.removeAllItems();
                a.add("9");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }
			
            }
            
            else if(e.getItem().equals("Apartment"))
            {
			
                roomNumValue.removeAllItems();
                a.add("10");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }		
            }
            
            else
            {
                roomNumValue.removeAllItems();
                a.add("Select");
                iter = a.iterator();
                while(iter.hasNext())
                {
                    roomNumValue.addItem(iter.next());
                }            
            }

            }
        });

    }//GEN-LAST:event_numGuestValueItemStateChanged

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:        
        try {
            
            if(!resIDValue.getText().equals(""))
            {  
                int input = Integer.parseInt(resIDValue.getText());    
                ResultSet rs = stmt.executeQuery("SELECT * FROM GUESTS WHERE RES_ID = " + input);
            
                if(rs.next())
                {
                    setTexts(rs);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No record found.");
                    firstNameValue.setText("");
                    lastNameValue.setText("");
                    phoneValue.setText("");
                    emailValue.setText("");
                    nationalityValue.setText("");
                    numGuestValue.setSelectedItem("Select");
                    roomNumValue.setSelectedItem("Select");
                    totalValue.setText("");
                    depositValue.setText("");
                    limitVal.setText("None");
                    paidValue.setText("");
                    walkIn.setSelected(true);
                    inDateChooser.setDate(new java.util.Date());
                    outDateChooser.setDate(new java.util.Date());  
                    noteField.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Reservation ID required.");                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImg);
        return icon;
    }
    
    private void fileChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fChooser = new JFileChooser();
        fChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        fChooser.addChoosableFileFilter(filter);
        int result = fChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            profile.setIcon(ResizeImage(path));
        }
        else if(result == JFileChooser.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(this, "No file selected.");
        }
    }//GEN-LAST:event_fileChooserButtonActionPerformed

    private void setTextsManager()
    {
        fullNameVal.setText("THAO TRINH");
        jobVal.setText("Software Developer");
        addressVal.setText("1142 Devereaux Avenue, Philadelphia, PA 19111");
        emailVal.setText("dtrinh5@student.ccp.edu");
        phoneVal.setText("510-309-8309");
        langVal.setText("Java, C++, Python, Ruby, Kotlin");
        techVal.setText("JDBC, MySQL, Git, phpMyAdmin, CSS");
        opVal.setText("Windows, NetBeans, Eclipse, IntelliJ, Android Studio, Linux");
        
        schoolName.setText("Community College of Philadelphia - Philadelphia, PA");
        major.setText("Computer Science, 2017 - Present, GPA: 4.0");
        course.setText("Data Structure and Algorithms, Object-Oriented Programming, Disrete Math");
        course1.setText("Introduction to Computer Organization, Database Managment Systems");

    }
    private void showTableData()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel");
            String sql = "SELECT RES_ID, FIRST_NAME, LAST_NAME, CHECK_IN, CHECK_OUT FROM GUESTS";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
 //           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HotelJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelJFrame().setVisible(true); // set the hotel JFrame to visible
            }
        });

        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressL;
    private javax.swing.JLabel addressL1;
    private javax.swing.JLabel addressVal;
    private javax.swing.JLabel addressVal1;
    private javax.swing.JRadioButton agoda;
    private javax.swing.JRadioButton airBnb;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bNext;
    private javax.swing.JButton bPrevious;
    private javax.swing.JButton bSave;
    private javax.swing.JPanel billPanel;
    private javax.swing.JRadioButton booking;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel course;
    private javax.swing.JLabel course1;
    private javax.swing.JPanel customerDetailsPanel;
    private javax.swing.JPanel customerFullPanel;
    private javax.swing.JPanel customerListPanel;
    private javax.swing.JPanel customerTypePanel;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JTextField depositValue;
    private javax.swing.JLabel dolaSign;
    private javax.swing.JLabel dolaSign2;
    private javax.swing.JLabel dolaSign3;
    private javax.swing.JLabel eduL;
    private javax.swing.JPanel eduP;
    private javax.swing.JLabel emailL;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailVal;
    private javax.swing.JTextField emailValue;
    private javax.swing.JRadioButton expedia;
    private javax.swing.JButton fileChooserButton;
    private javax.swing.JTextField firstNameValue;
    private javax.swing.JPanel fullBillPanel;
    private javax.swing.JLabel fullNameL;
    private javax.swing.JLabel fullNameVal;
    private javax.swing.JLabel guestNameLabel;
    private javax.swing.JRadioButton hotels;
    private com.toedter.calendar.JDateChooser inDateChooser;
    private javax.swing.JLabel inDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jobL;
    private javax.swing.JLabel jobVal;
    private javax.swing.JRadioButton kayak;
    private javax.swing.JLabel langL;
    private javax.swing.JLabel langVal;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameValue;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTextField limitVal;
    private javax.swing.JLabel major;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextField nationalityValue;
    private javax.swing.JTextPane noteField;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel numGuestL;
    private javax.swing.JComboBox<String> numGuestValue;
    private javax.swing.JLabel opL;
    private javax.swing.JLabel opVal;
    private com.toedter.calendar.JDateChooser outDateChooser;
    private javax.swing.JLabel outDateLabel;
    private javax.swing.JLabel paidLabel;
    private javax.swing.JTextField paidValue;
    private javax.swing.JLabel phoneL;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneVal;
    private javax.swing.JTextField phoneValue;
    private javax.swing.JRadioButton priceLine;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel resIDLabel;
    private javax.swing.JTextField resIDValue;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel roomLimitLabel;
    private javax.swing.JLabel roomNumL;
    private javax.swing.JComboBox<String> roomNumValue;
    private javax.swing.JLabel roomTypeL2;
    private javax.swing.JComboBox<String> roomTypeValue;
    private javax.swing.JPanel school1;
    private javax.swing.JLabel schoolName;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel skillL;
    private javax.swing.JPanel skillP;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel techL;
    private javax.swing.JLabel techVal;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalValue;
    private javax.swing.JRadioButton tripA;
    private javax.swing.JRadioButton walkIn;
    // End of variables declaration//GEN-END:variables
}
