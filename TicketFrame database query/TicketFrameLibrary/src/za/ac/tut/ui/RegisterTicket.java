
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.utility.Members;

/**
 *
 * @author sifiso
 */
public class RegisterTicket extends JFrame{
    
    private JPanel headingPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel cellphonePnl;
    private JPanel customerDetailsPnl;
    private JPanel homeTeamPnl;
    private JPanel awayTeamPnl;
    private JPanel ticketCostPnl;
    private JPanel numTicketPnl;
    private JPanel totAmtDuePnl;
    private JPanel ticketsPnl;
    private JPanel btnPnl;
    private JPanel ticketsBtnsCombined;
    private JPanel mainPnl;
    
    //labels
    
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel cellphoneLbl;
    private JLabel homeTeamLbl;
    private JLabel awayTeamLbl;
    private JLabel ticketCostLbl;
    private JLabel numTicketLbl;
    private JLabel totAmtDueLbl;
    
    //textFields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField cellphoneTxtFld;
    private JTextField homeTeamTxtFld;
    private JTextField awayTeamTxtFld;
    private JTextField ticketCostTxtFld;
    private JTextField totAmtDueTxtFld;
    
    private JSlider numTicketsSld;
    
    private JButton buyBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    //buttons
    
//    //combobox
//    private JComboBox genderComboBox;
//    
//    //radioButton
//    private JRadioButton monthToMonthRadBtn;
//    private JRadioButton sixMonthsRadBtn;
//    private JRadioButton annualRadBtn;
//    
//    //checkbox
//    private JCheckBox personalTrainerChkBx;
//    
//    //buttongroup
//    private ButtonGroup btnGrp;
//    
//    //textArea
//    private JTextArea commentsArea;
//    
//    //scrollpane
//    private JScrollPane scrollableTextArea;
//    
    
    //creating a menu
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem registerMenuItem;
    private JMenuItem retrieveMenuItem;
    private JMenuItem closeAllMenuItem;
    
    public RegisterTicket(){
    
        setTitle("Menu Frame");
        setSize(700, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        
        //Start menu frame
        menuBar = new JMenuBar();
        
        fileMenu = new JMenu("File");
        
        registerMenuItem = new JMenuItem("Register...");
        registerMenuItem.addActionListener(new RegisterSale());
        
        retrieveMenuItem = new JMenuItem("Retrieve...");
        retrieveMenuItem.addActionListener(new DislaySale());
        
        closeAllMenuItem = new JMenuItem("Close...");
        closeAllMenuItem.addActionListener( new closeProject());
        
        
        fileMenu.add(registerMenuItem);
        fileMenu.add(retrieveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeAllMenuItem);
        
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        //end menu Frame
        
        //Create first panel
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cellphonePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        customerDetailsPnl = new JPanel(new GridLayout(3,1,1,1));
        customerDetailsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "Customer details" ));
    
        //====================================================================
        
        //second panel
        homeTeamPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awayTeamPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ticketCostPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numTicketPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totAmtDuePnl =  new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        ticketsPnl = new JPanel(new GridLayout(5,1,1,1));
        ticketsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "Tickets details" ));
    
        //======================================================================================
        
        btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        ticketsBtnsCombined = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //make labels
        headingLbl = new JLabel("Soccer match Tickets");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 40));
        headingLbl.setForeground(Color.CYAN);
        
        nameLbl = new JLabel("Name:     ");
        surnameLbl = new JLabel("Surname    ");
        cellphoneLbl = new JLabel("Cellphone    ");
        homeTeamLbl = new JLabel("Home team ");
        awayTeamLbl = new JLabel("Away team ");
        ticketCostLbl = new JLabel("Cost price: R");
        numTicketLbl = new JLabel("Number of tickets required: ");
        totAmtDueLbl = new JLabel("Total amount due: R");
        
        //==============================================================
        
        //textFields
        nameTxtFld = new JTextField(10);
        nameTxtFld.setFocusable(true);
        
        surnameTxtFld = new JTextField(10);
        cellphoneTxtFld = new JTextField(10);
        homeTeamTxtFld = new JTextField(10);
        awayTeamTxtFld = new JTextField(10);
        ticketCostTxtFld = new JTextField(10);
        
        totAmtDueTxtFld = new JTextField(10);
        totAmtDueTxtFld.setText("To be calculated later.");
        totAmtDueTxtFld.setEditable(false);
        
        numTicketsSld = new JSlider(1, 20);
        
        buyBtn = new JButton("Buy");
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new clearData());
        
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new closeProject());
        
        //=======================================================================
        
        //adding components
        //first panel
        headingPnl.add(headingLbl);
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        cellphonePnl.add(cellphoneLbl);
        cellphonePnl.add(cellphoneTxtFld);
        
        customerDetailsPnl.add(namePnl);
        customerDetailsPnl.add(surnamePnl);
        customerDetailsPnl.add(cellphonePnl);
        //end of firstPane
        
        //===========================================================
        
        //second panel
        homeTeamPnl.add(homeTeamLbl);
        homeTeamPnl.add(homeTeamTxtFld);
        
        awayTeamPnl.add(awayTeamLbl);
        awayTeamPnl.add(awayTeamTxtFld);
        
        ticketCostPnl.add(ticketCostLbl);
        ticketCostPnl.add(ticketCostTxtFld);
        
        numTicketPnl.add(numTicketLbl);
        numTicketPnl.add(numTicketsSld);
        
        totAmtDuePnl.add(totAmtDueLbl);
        totAmtDuePnl.add(totAmtDueTxtFld);
        
        ticketsPnl.add(homeTeamPnl);
        ticketsPnl.add(awayTeamPnl);
        ticketsPnl.add(ticketCostPnl);
        ticketsPnl.add(numTicketPnl);
        ticketsPnl.add(totAmtDuePnl);
        //end of second panel
        
        //=====================================
        //frelance
        
        btnPnl.add(buyBtn);
        btnPnl.add(clearBtn); 
        btnPnl.add(exitBtn);
         
        ticketsBtnsCombined.add(ticketsPnl, BorderLayout.CENTER);
        ticketsBtnsCombined.add(btnPnl, BorderLayout.SOUTH);
        
        mainPnl.add(headingPnl, BorderLayout.NORTH);
        mainPnl.add(customerDetailsPnl, BorderLayout.CENTER);
        mainPnl.add(ticketsBtnsCombined, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        pack();
        
        setVisible(true);
    }
    
    
    
    private Connection connection;
    
    String dbUrl = "jdbc:derby://localhost:1527/CustomerDB;create=true";
    String username = "app";
    String password = "123";
            
    public RegisterTicket(String dbUrl, String username, String password) throws SQLException{
    
        dbUrl = "jdbc:derby://localhost:1527/CustomerDB;create=true";
        username = "app";
        password = "123";
        
        connection = getConnection(dbUrl, username, password);
        
        //System.out.println(connection);
    }
    
    private Connection getConnection(String dbURL, String username, String Password) throws SQLException{
    
        Connection theConnect;
        
        theConnect = DriverManager.getConnection(dbURL, username, Password);
        
        return theConnect;
    }
    
    
    private class RegisterSale implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try{
                
                connection = getConnection(dbUrl, username, password);
                
                String sql = "INSERT INTO CUSTOMERDB(NAME,SURNAME,CELLPHONE,HOMETEAMTICKETS,AWAYTEAMTICKETS,COST) " +
                        "VALUES(?,?,?,?,?,?)";
                
                String name = nameTxtFld.getText();
                String surname = surnameTxtFld.getText();
                Integer celphone = Integer.parseInt(cellphoneTxtFld.getText());
                Integer homeTeamTicket = Integer.parseInt(homeTeamTxtFld.getText());
                Integer awayTeamTicket = Integer.parseInt(awayTeamTxtFld.getText());
                Double cost = Double.parseDouble(ticketCostTxtFld.getText());
                
                try{
                    
                    PreparedStatement ps = connection.prepareStatement(sql);
                    
                    ps.setString(1, name);
                    ps.setString(2, surname);
                    ps.setInt(3, celphone);
                    ps.setInt(4, homeTeamTicket);
                    ps.setInt(5, awayTeamTicket);
                    ps.setDouble(6, cost);
                    
                    ps.executeUpdate();
                    ps.close();
                    
                }
                catch(SQLException ex){
                    
                    ex.getMessage();
                }
            }
            catch(SQLException ex){
            
                Logger.getLogger(RegisterTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    
    
    private class DislaySale implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try{
                
                List<Members> list = new ArrayList<Members>();
                
                List<Members> toStr = new ArrayList<Members>();
                
                String SQL = "SELECT * FROM CUSTOMERDB";
                
                connection = getConnection(dbUrl, username, password);
                
                PreparedStatement ps = connection.prepareStatement(SQL);
                
                ResultSet rs = ps.executeQuery();
                
                String membersOnly = "";
                
                
                while(rs.next()){
                
                   String name = rs.getString("NAME");
                   String surname = rs.getString("SURNAME");
                   Integer cellphone = rs.getInt("CELLPHONE");
                   Integer hometeam = rs.getInt("HOMETEAMTICKETS");
                   Integer awayteam = rs.getInt("AWAYTEAMTICKETS");
                   Double cost = rs.getDouble("COST");
                   
                   Members mem = new Members(name, surname, cellphone, hometeam, awayteam, cost);
                   
                   list.add(mem);
                }
                
                for(Members mm : list){
                
                    membersOnly += mm.toString() + "\n";
                }
                
                //nameTxtFld.setText(membersOnly);
                
                System.out.println(membersOnly);
                
                ps.close();
            }
            catch(SQLException ex){
            
                ex.getMessage();
            }
        }  
    }
    
    private class closeProject implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }  
    }
    
    private class clearData implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            nameTxtFld.setText("");
            surnameTxtFld.setText("");
            cellphoneTxtFld.setText("");
            homeTeamTxtFld.setText("");
            awayTeamTxtFld.setText("");
            ticketCostTxtFld.setText("");
        }  
    }
}
