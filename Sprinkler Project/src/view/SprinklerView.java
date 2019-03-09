package view;
import java.awt.Color;
import java.awt.EventQueue;

import javax.naming.ldap.StartTlsRequest;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JLabel;

import model.DBConnector;
import model.Sprinkler;

import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.BorderLayout;


public class SprinklerView {

	private JFrame frame;
	private JPanel cardPanel;
	private JPanel startPanel;
	private JPanel mainPanel;
	private CardLayout cards;
	
	// Card Layout for Sprinkler
	private JPanel sprinklerPanel;
	// Panels for sub cards
	private JPanel viewPanel;
	private JPanel configPanel;
	private JPanel waterUsage;
	private CardLayout cards1;
	private JLabel sp0;
	private JLabel sp1;
	private JLabel sp2;
	private JLabel sp3;
	private JLabel sp4;
	private JLabel sp5;
	private JLabel sp6;
	private JLabel sp7;
	private JLabel sp8;
	private JLabel sp9;
	
	ImageIcon sprinkleron;
	URL urlsd;
	ImageIcon sprinkleroff;
	ImageIcon broken;
	private JLabel gardenlawn;
	private JToggleButton tglbtn0,tglbtn1,tglbtn2,tglbtn3;
	private JTextField northSH;
	private JTextField northSM;
	private JTextField northEH;
	private JTextField northEM;
	private JTextField tempNorth;
	
	// group toggle button
	private JToggleButton northTglBtn;
	private JToggleButton southTglBtn;
	private JToggleButton eastTglBtn;
	private JToggleButton westTglBtn;
	private JSeparator separator_1;
	private JLabel lblSprinklerSystem;
	private JToggleButton tglbtnSprinkler;
	private JLabel lblTemperature;
	private JTextField tempText;
	
	
	Timer timer;
	Timer timer1; // setting Time
	Timer timer2;
	ActionListener timerListener; //apd
	ActionListener setTimeListener; // setting Time
	ActionListener checkTempListener;
	private int temp;
	private JTextField southSH;
	private JTextField southSM;
	private JTextField southEH;
	private JTextField southEM;
	private JTextField eastSH;
	private JTextField eastSM;
	private JTextField eastEH;
	private JTextField eastEM;
	private JTextField westSH;
	private JTextField westSM;
	private JTextField westEH;
	private JTextField westEM;
	private JTextField tempSouth;
	private JTextField tempEast;
	private JTextField tempWest;
	private JLabel lblStartTime;
	private JLabel lblEndTime_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblSprinkler_2;
	private JLabel lblSprinkler_3;
	private JLabel lblSprinkler_4;
	private JLabel lblSprinkler_5;
	private JLabel lblSprinkler_6;
	private JToggleButton tglbtn4;
	private JToggleButton tglbtn5;
	private JToggleButton tglbtn6;
	private JToggleButton tglbtn7;
	private JToggleButton tglbtn8;
	private JToggleButton tglbtn9;
	private JLabel lblSprinkler_7;
	private JTextField northFR;
	private JTextField southFR;
	private JTextField eastFR;
	private JTextField westFR;
	private DefaultCategoryDataset dcd , dcd1;
	private int northwater;
	private int southwater;
	private int eastwater;
	private int westwater;
	private int milisec;
	
	public static int flag0=0, flag1=0,flag2=0, flag3=0,flag4=0, flag5=0,flag6=0, flag7=0,flag8=0, flag9=0,flagNorth= 0,flagSouth=0,flagEast=0,flagWest=0;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		DBConnector db = new DBConnector();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SprinklerView window = new SprinklerView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SprinklerView() {
		frame = new JFrame();
		frame.setBounds(0, 15, 1600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		cardPanel = new JPanel();
		cards = new CardLayout();
		//cardPanel.setBounds(100, 100, 900, 600);
		cardPanel.setBounds(25, 25, 1000, 700);
		
		cardPanel.setLayout(cards);
		frame.getContentPane().add(cardPanel);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(25, 25, 1000, 700);
		mainPanel.setLayout(null);
		cardPanel.add(mainPanel,"main");
		
		JButton viewBtn = new JButton("View Systems");
		viewBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		viewBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cards1.show(sprinklerPanel, "view");
			}
		});
		viewBtn.setBounds(17, 11, 448, 23);
		mainPanel.add(viewBtn);
		
		JButton configBtn = new JButton("Configuration");
		configBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		configBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards1.show(sprinklerPanel, "config");
				
			}
		});
		configBtn.setBounds(475, 11, 452, 23);
		mainPanel.add(configBtn);
		
		JButton waterbtn = new JButton("Water Usage");
		waterbtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		waterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards1.show(sprinklerPanel, "waterusage");
				dcd.setValue(northwater, "North Group", "North Group");
				dcd.setValue(southwater, "south Group", "south Group");
				dcd.setValue(eastwater, "East Group", "East Group");
				dcd.setValue(westwater, "West Group", "West Group");
				
				dcd1.setValue(2200, "", "Jan");
				dcd1.setValue(5000, "", "Feb");
				dcd1.setValue(7170, "","Mar" );
				dcd1.setValue(900, "", "Apr");
				dcd1.setValue(2100, "", "May");
				dcd1.setValue(320, "", "Jun");
				dcd1.setValue(8170, "","Jul" );
				dcd1.setValue(850, "", "Aug");
				dcd1.setValue(640, "", "Sept");
				dcd1.setValue(590, "", "Oct");
				dcd1.setValue(890, "", "Nov");
				dcd1.setValue(northwater+southwater+eastwater+westwater, "", "Dec");
				
				
				}
		});
		waterbtn.setBounds(937, 11, 404, 23);
		mainPanel.add(waterbtn);
		
		// Sprinkler Panel 
		sprinklerPanel = new JPanel();
		cards1 = new CardLayout();
		sprinklerPanel.setBounds(25, 35, 1327, 600);
		sprinklerPanel.setLayout(cards1);
		mainPanel.add(sprinklerPanel);
		
		//sub panels
		viewPanel = new JPanel();
		configPanel = new JPanel();
		configPanel.setBackground(new Color(153, 153, 255));
		waterUsage = new JPanel();
//		viewPanel.setBounds(100, 76, 696, 474);
//		configPanel.setBounds(100, 76, 696, 474);
//		waterUsage.setBounds(100, 76, 696, 474);
		viewPanel.setBounds(25, 35, 1000, 626);
		configPanel.setBounds(25, 40, 1000, 600);
		waterUsage.setBounds(25, 35, 1000, 600);
		
		// charts 
		
		// chart for water usage per Group
		dcd = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart3D("Water Usage per Group", "Group", "Water Usage in Gallons", dcd, PlotOrientation.VERTICAL, false, false, false);
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.getRenderer().setSeriesPaint(0, Color.red);
		catPlot.getRenderer().setSeriesPaint(1, Color.red);
		catPlot.getRenderer().setSeriesPaint(2, Color.red);
		catPlot.getRenderer().setSeriesPaint(3, Color.red);
		catPlot.setRangeGridlinePaint(Color.BLACK);
						
		ChartPanel chartPanel = new ChartPanel(chart);
		
		waterUsage.add(chartPanel);
		chartPanel.setBounds(10,35,450,500);
		
		// Chart for Daily water Usage
		
		dcd1 = new DefaultCategoryDataset();
		JFreeChart chart1 = ChartFactory.createBarChart("Water Usage per Day Report", "Days of The Week","Water used in Gallons", dcd1, PlotOrientation.VERTICAL, false, false, false);
		CategoryPlot catPlot1 = chart1.getCategoryPlot();
		catPlot1.getRenderer().setSeriesPaint(0, Color.BLUE);
		catPlot1.getRenderer().setSeriesPaint(1, Color.BLUE);
		catPlot1.getRenderer().setSeriesPaint(2, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(3, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(4, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(5, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(6, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(7, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(8, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(9, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(10, Color.blue);
		catPlot1.getRenderer().setSeriesPaint(10, Color.blue);
		catPlot1.setRangeGridlinePaint(Color.BLACK);
						
		ChartPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setBackground(new Color(153, 153, 255));
		
		waterUsage.add(chartPanel1, BorderLayout.CENTER);
		chartPanel1.setBounds(470,35,700,500);
		
		
		// end of charts
		
		sprinklerPanel.add(viewPanel,"view");
		viewPanel.setLayout(null);
		
		ImageIcon fountain = new ImageIcon("fountain2.gif");
		JLabel fountainLabel = new JLabel(fountain,JLabel.CENTER);
		
		fountainLabel.setBounds(980, 10, 350, 600);
		configPanel.add(fountainLabel);
		
		sprinklerPanel.add(configPanel,"config");
		configPanel.setLayout(null);
		
		JLabel lblSprinkler = new JLabel("Sprinkler 0");
		lblSprinkler.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler.setBounds(66, 58, 75, 14);
		configPanel.add(lblSprinkler);
		
		JLabel lblNewLabel_1 = new JLabel("Sprinkler 1");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 228, 75, 14);
		configPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sprinkler 2");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(504, 58, 75, 14);
		configPanel.add(lblNewLabel_2);
		
		JLabel lblSprinkler_1 = new JLabel("Sprinkler 3");
		lblSprinkler_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_1.setBounds(504, 228, 75, 14);
		configPanel.add(lblSprinkler_1);
		
		 tglbtn0 = new JToggleButton("OFF");
		 tglbtn0.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn0.setBounds(165, 54, 69, 23);
		configPanel.add(tglbtn0);
		
		 tglbtn1 = new JToggleButton("ON");
		 tglbtn1.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn1.setBounds(165, 224, 69, 23);
		configPanel.add(tglbtn1);
		
		 tglbtn2 = new JToggleButton("OFF");
		 tglbtn2.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn2.setBounds(612, 54, 69, 23);
		configPanel.add(tglbtn2);
		
		 tglbtn3 = new JToggleButton("OFF");
		 tglbtn3.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn3.setBounds(612, 224, 69, 23);
		configPanel.add(tglbtn3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 341, 904, 8);
		configPanel.add(separator);
		
		JLabel lblGroup_1 = new JLabel("Group");
		lblGroup_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblGroup_1.setBounds(10, 360, 61, 14);
		configPanel.add(lblGroup_1);
		
		JLabel lblNewLabel_6 = new JLabel("North");
		lblNewLabel_6.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 402, 61, 14);
		configPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("South");
		lblNewLabel_7.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 439, 61, 14);
		configPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("East");
		lblNewLabel_8.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 475, 61, 14);
		configPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("West");
		lblNewLabel_9.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 513, 61, 14);
		configPanel.add(lblNewLabel_9);
		
		northSH = new JTextField();
		northSH.setBounds(151, 399, 46, 20);
		configPanel.add(northSH);
		northSH.setColumns(10);
		
		northSM = new JTextField();
		northSM.setColumns(10);
		northSM.setBounds(207, 399, 46, 20);
		configPanel.add(northSM);
		
		northEH = new JTextField();
		northEH.setColumns(10);
		northEH.setBounds(290, 397, 46, 20);
		configPanel.add(northEH);
		
		northEM = new JTextField();
		northEM.setColumns(10);
		northEM.setBounds(346, 397, 46, 20);
		configPanel.add(northEM);
		
		northTglBtn = new JToggleButton("ON");
		northTglBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		northTglBtn.setBounds(417, 396, 121, 23);
		configPanel.add(northTglBtn);
		
		tempNorth = new JTextField();
		tempNorth.setText("68");
		tempNorth.setBounds(612, 397, 51, 20);
		configPanel.add(tempNorth);
		tempNorth.setColumns(10);
		
		southTglBtn = new JToggleButton("ON");
		southTglBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		southTglBtn.setBounds(417, 436, 121, 23);
		configPanel.add(southTglBtn);
		
		eastTglBtn = new JToggleButton("ON");
		eastTglBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		eastTglBtn.setBounds(417, 470, 121, 23);
		configPanel.add(eastTglBtn);
		
		westTglBtn = new JToggleButton("ON");
		westTglBtn.setFont(new Font("Bell MT", Font.BOLD, 15));
		westTglBtn.setBounds(417, 507, 121, 23);
		configPanel.add(westTglBtn);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 539, 904, 8);
		configPanel.add(separator_1);
		
		lblSprinklerSystem = new JLabel("Sprinkler System");
		lblSprinklerSystem.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinklerSystem.setBounds(10, 558, 131, 31);
		configPanel.add(lblSprinklerSystem);
		
		tglbtnSprinkler = new JToggleButton("ON");
		tglbtnSprinkler.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtnSprinkler.setBounds(178, 562, 121, 23);
		configPanel.add(tglbtnSprinkler);
		
		lblTemperature = new JLabel("Water Flow Rate");
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblTemperature.setBounds(740, 356, 121, 23);
		configPanel.add(lblTemperature);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(797, 30, 148, 126);
		configPanel.add(panel);
		panel.setLayout(null);
		
		ImageIcon tempimage = new ImageIcon("sun.jpg");
		JLabel tempImage = new JLabel(tempimage,JLabel.CENTER);
		tempImage.setBounds(-1, 25, 81, 41);
		panel.add(tempImage);
		
		tempText = new JTextField("70");
		tempText.setFont(new Font("Serif", Font.BOLD, 20));
		tempText.setBounds(79, 25, 60, 38);
		tempText.setEditable(true);
		
		panel.add(tempText);
		tempText.setColumns(10);
		
		JLabel lblCurrentTemperature_1 = new JLabel("Current Temperature");
		lblCurrentTemperature_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblCurrentTemperature_1.setBounds(0, 0, 159, 14);
		panel.add(lblCurrentTemperature_1);
		
		southSH = new JTextField();
		southSH.setColumns(10);
		southSH.setBounds(151, 436, 46, 20);
		configPanel.add(southSH);
		
		southSM = new JTextField();
		southSM.setColumns(10);
		southSM.setBounds(207, 436, 46, 20);
		configPanel.add(southSM);
		
		southEH = new JTextField();
		southEH.setColumns(10);
		southEH.setBounds(290, 434, 46, 20);
		configPanel.add(southEH);
		
		southEM = new JTextField();
		southEM.setColumns(10);
		southEM.setBounds(346, 434, 46, 20);
		configPanel.add(southEM);
		
		eastSH = new JTextField();
		eastSH.setColumns(10);
		eastSH.setBounds(151, 472, 46, 20);
		configPanel.add(eastSH);
		
		eastSM = new JTextField();
		eastSM.setColumns(10);
		eastSM.setBounds(207, 472, 46, 20);
		configPanel.add(eastSM);
		
		eastEH = new JTextField();
		eastEH.setColumns(10);
		eastEH.setBounds(290, 470, 46, 20);
		configPanel.add(eastEH);
		
		eastEM = new JTextField();
		eastEM.setColumns(10);
		eastEM.setBounds(346, 470, 46, 20);
		configPanel.add(eastEM);
		
		westSH = new JTextField();
		westSH.setColumns(10);
		westSH.setBounds(151, 510, 46, 20);
		configPanel.add(westSH);
		
		westSM = new JTextField();
		westSM.setColumns(10);
		westSM.setBounds(207, 510, 46, 20);
		configPanel.add(westSM);
		
		westEH = new JTextField();
		westEH.setColumns(10);
		westEH.setBounds(290, 508, 46, 20);
		configPanel.add(westEH);
		
		westEM = new JTextField();
		westEM.setColumns(10);
		westEM.setBounds(346, 508, 46, 20);
		configPanel.add(westEM);
		
		tempSouth = new JTextField();
		tempSouth.setText("82");
		tempSouth.setColumns(10);
		tempSouth.setBounds(612, 434, 51, 20);
		configPanel.add(tempSouth);
		
		tempEast = new JTextField();
		tempEast.setText("85");
		tempEast.setColumns(10);
		tempEast.setBounds(612, 470, 51, 20);
		configPanel.add(tempEast);
		
		tempWest = new JTextField();
		tempWest.setText("75");
		tempWest.setColumns(10);
		tempWest.setBounds(612, 505, 51, 20);
		configPanel.add(tempWest);
		
		lblStartTime = new JLabel("Start Time");
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartTime.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblStartTime.setBounds(151, 360, 102, 14);
		configPanel.add(lblStartTime);
		
		lblEndTime_1 = new JLabel("End Time");
		lblEndTime_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblEndTime_1.setBounds(290, 358, 102, 14);
		configPanel.add(lblEndTime_1);
		
		label = new JLabel("Activation Status");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Bell MT", Font.BOLD, 15));
		label.setBounds(406, 358, 154, 14);
		configPanel.add(label);
		
		label_1 = new JLabel("Temperature");
		label_1.setFont(new Font("Bell MT", Font.BOLD, 15));
		label_1.setBounds(612, 358, 86, 14);
		configPanel.add(label_1);
		
		lblSprinkler_2 = new JLabel("Sprinkler 4");
		lblSprinkler_2.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_2.setBounds(66, 90, 75, 14);
		configPanel.add(lblSprinkler_2);
		
		lblSprinkler_3 = new JLabel("Sprinkler 5");
		lblSprinkler_3.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_3.setBounds(66, 260, 75, 14);
		configPanel.add(lblSprinkler_3);
		
		lblSprinkler_4 = new JLabel("Sprinkler 6");
		lblSprinkler_4.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_4.setBounds(504, 90, 75, 14);
		configPanel.add(lblSprinkler_4);
		
		lblSprinkler_5 = new JLabel("Sprinkler 7");
		lblSprinkler_5.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_5.setBounds(504, 260, 75, 14);
		configPanel.add(lblSprinkler_5);
		
		lblSprinkler_6 = new JLabel("Sprinkler 8");
		lblSprinkler_6.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_6.setBounds(66, 123, 75, 14);
		configPanel.add(lblSprinkler_6);
		
		tglbtn4 = new JToggleButton("OFF");
		tglbtn4.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn4.setBounds(165, 86, 69, 23);
		configPanel.add(tglbtn4);
		
		tglbtn5 = new JToggleButton("ON");
		tglbtn5.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn5.setBounds(165, 258, 69, 23);
		configPanel.add(tglbtn5);
		
		tglbtn6 = new JToggleButton("OFF");
		tglbtn6.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn6.setBounds(612, 88, 69, 23);
		configPanel.add(tglbtn6);
		
		tglbtn7 = new JToggleButton("OFF");
		tglbtn7.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn7.setBounds(612, 256, 69, 23);
		configPanel.add(tglbtn7);
		
		tglbtn8 = new JToggleButton("OFF");
		tglbtn8.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn8.setBounds(165, 119, 69, 23);
		configPanel.add(tglbtn8);
		
		lblSprinkler_7 = new JLabel("Sprinkler 9");
		lblSprinkler_7.setFont(new Font("Bell MT", Font.BOLD, 15));
		lblSprinkler_7.setBounds(66, 292, 75, 14);
		configPanel.add(lblSprinkler_7);
		
		tglbtn9 = new JToggleButton("OFF");
		tglbtn9.setFont(new Font("Bell MT", Font.BOLD, 15));
		tglbtn9.setBounds(165, 288, 69, 23);
		configPanel.add(tglbtn9);
		
		northFR = new JTextField();
		northFR.setEditable(false);
		northFR.setBounds(761, 399, 86, 20);
		configPanel.add(northFR);
		northFR.setColumns(10);
		
		southFR = new JTextField();
		southFR.setEditable(false);
		southFR.setColumns(10);
		southFR.setBounds(761, 436, 86, 20);
		configPanel.add(southFR);
		
		eastFR = new JTextField();
		eastFR.setEditable(false);
		eastFR.setColumns(10);
		eastFR.setBounds(761, 472, 86, 20);
		configPanel.add(eastFR);
		
		westFR = new JTextField();
		westFR.setEditable(false);
		westFR.setColumns(10);
		westFR.setBounds(761, 510, 86, 20);
		configPanel.add(westFR);
		
		JLabel lblEastGroup = new JLabel("East Group");
		lblEastGroup.setBounds(535, 31, 102, 14);
		configPanel.add(lblEastGroup);
		
		JLabel lblNorthGroup = new JLabel("North Group");
		lblNorthGroup.setBounds(116, 29, 102, 14);
		configPanel.add(lblNorthGroup);
		
		JLabel lblSouthGroup = new JLabel("South Group");
		lblSouthGroup.setBounds(100, 182, 102, 14);
		configPanel.add(lblSouthGroup);
		
		JLabel lblWestGroup = new JLabel("West Group");
		lblWestGroup.setBounds(547, 182, 90, 14);
		configPanel.add(lblWestGroup);
		sprinklerPanel.add(waterUsage,"waterusage");
		waterUsage.setLayout(new BorderLayout(0, 0));
		
		startPanel = new JPanel();
		startPanel.setBounds(25, 25, 1000, 700);
		cardPanel.add(startPanel,"start");
		
		ImageIcon startImage = new ImageIcon("nature1.jpg");
		startPanel.setLayout(null);
		JLabel startLabel = new JLabel(startImage,SwingConstants.LEFT);
		startLabel.setForeground(new Color(153, 0, 0));
		startLabel.setFont(new Font("Colonna MT", Font.BOLD, 35));
		startLabel.setBounds(20, 11, 1342, 639);
		startPanel.add(startLabel);
		
		JLabel humming = new JLabel("HummingBee",JLabel.CENTER);
		startLabel.add(humming);
		humming.setFont(new Font("Colonna MT", Font.BOLD, 70));
		humming.setBounds(0, 93, 1362, 75);
		JLabel lblGardenSprinklerSystem = new JLabel("Home Garden Sprinkler System");
		startLabel.add(lblGardenSprinklerSystem);
		lblGardenSprinklerSystem.setForeground(new Color(51, 102, 0));
		
		lblGardenSprinklerSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblGardenSprinklerSystem.setFont(new Font("Colonna MT", Font.BOLD, 60));
		lblGardenSprinklerSystem.setBounds(0, 190, 1362, 65);
		JLabel aLabel = new JLabel("Anagha Deshpande");
		JLabel jLabel = new JLabel("Jana Geddis");
		startLabel.add(aLabel);
		startLabel.add(jLabel);
		
		JLabel pLabel = new JLabel("Presented By :");
		pLabel.setFont(new Font("Colonna MT", Font.BOLD, 35));
		startLabel.add(pLabel);
		pLabel.setBounds(363,280,300,40);
		aLabel.setBounds(363,330,400,40);
		jLabel.setBounds(363,380,300,40);
		aLabel.setFont(new Font("Colonna MT", Font.BOLD, 35));
		jLabel.setFont(new Font("Colonna MT", Font.BOLD, 35));
		
		JButton start = new JButton("Go to your System");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(cardPanel, "main");
				cards1.show(sprinklerPanel, "view");
			}
		});
		start.setFont(new Font("Colonna MT", Font.BOLD, 30));
		startLabel.add(start);
		start.setBounds(489, 509, 431, 60);
		
		cards.show(cardPanel, "start");
		
		
		ImageIcon lawnImage = new ImageIcon("lawn.jpg");
		gardenlawn  = new JLabel(lawnImage,JLabel.CENTER);
		gardenlawn.setBounds(-30, 11, 1357, 626);
		viewPanel.add(gardenlawn);
		
		JLabel lblCurrentTemperature = new JLabel("Current temperature");
		lblCurrentTemperature.setBounds(672, 32, 106, 21);
		mainPanel.add(lblCurrentTemperature);
		
		try
		
		{urlsd = new URL("https://www.google.com/search?q=Sprinkler+gif&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiQ5dHdiM3QAhUP22MKHdQqAlUQ_AUICCgB&biw=1920&bih=971#imgrc=oqOfdUnYiNn91M%3A");
			sprinkleron = new ImageIcon("sprOn1.gif");
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		//sprinkleron = new ImageIcon("sprOn2.png");
		
		sprinkleroff = new ImageIcon("OFF1.png");	
		broken = new ImageIcon("notOk.jpg");
		sp0 = new JLabel();
		sp1 = new JLabel();
		sp2 = new JLabel();
		sp3 = new JLabel();
		sp4 = new JLabel();
		sp5 = new JLabel();
		sp6 = new JLabel();
		sp7 = new JLabel();
		sp8 = new JLabel();
		sp9 = new JLabel();
		
		
		timerListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random ran = new Random();
				temp = ran.nextInt(10)+70;
				setTemp(temp);
				
			}
		};
		
		checkTempListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(getSprinklerSysStatus())
				{changeStatusTemp();
				}
			}
		};
		
		setTimeListener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Calendar calendar = Calendar.getInstance();
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int mins = calendar.get(Calendar.MINUTE);
				
				 milisec = ((hours*60)+mins);
				
//				// North Group
////				if(((Integer.parseInt(northSH.getText())*60)+Integer.parseInt(northSM.getText()) <= 
////						milisec) && (Integer.parseInt(northEH.getText())*60)+Integer.parseInt(northEM.getText()) >= milisec)
////				{
////					setNorthStatus("ON");
////					
////					
////				}
////				// South Sprinkler
////				if(((Integer.parseInt(southSH.getText())*60)+Integer.parseInt(southSM.getText()) <= 
////						milisec) && (Integer.parseInt(southEH.getText())*60)+Integer.parseInt(southEM.getText()) >= milisec)
////				{
////					setSouthStatus("ON");
////					
////				}
//				// East Sprinkler
////				if(((Integer.parseInt(eastSH.getText())*60)+Integer.parseInt(eastSM.getText()) <= 
////						milisec) && (Integer.parseInt(eastEH.getText())*60)+Integer.parseInt(eastEM.getText()) >= milisec)
////				{
////					setEastStatus("ON");
////				
////				}
//				// West Sprinkler
//				if(((Integer.parseInt(westSH.getText())*60)+Integer.parseInt(westSM.getText()) <= 
//						milisec) && (Integer.parseInt(westEH.getText())*60)+Integer.parseInt(westEM.getText()) >= milisec)
//				{
//					setWestStatus("ON");
//					
//				}
				// North Group
				if(tglbtn0.getText()=="ON")
				{
					northwater = northwater +3;
				}
				if(tglbtn4.getText()=="ON")
				{
					northwater = northwater +3;
				}
				if(tglbtn8.getText()=="ON")
				{
					northwater = northwater +3;
				}
//				// Set North Toggle button ON or OFF as per individual sprinklers
//				if(tglbtn0.getText()== "ON"&& tglbtn4.getText()=="ON"&&tglbtn8.getText()=="ON")
//				{
//					setNorthStatus("ON");
//				}
//				else if(tglbtn0.getText()== "OFF"&& tglbtn4.getText()=="OFF"&&tglbtn8.getText()=="OFF")
//				{
//					setNorthStatus("OFF");
//				}
				// South Group
				if(tglbtn1.getText()=="ON")
				{
					southwater = southwater +3;
				}
				if(tglbtn5.getText()=="ON")
				{
					southwater = southwater +3;
				}
				if(tglbtn9.getText()=="ON")
				{
					southwater = southwater +3;
				}
//				// Set South Toggle button ON or OFF as per individual sprinklers
//				if(tglbtn1.getText()== "ON"&& tglbtn5.getText()=="ON"&&tglbtn9.getText()=="ON")
//				{
//					setSouthStatus("ON");
//				}
//				else if(tglbtn1.getText()== "OFF"&& tglbtn5.getText()=="OFF"&&tglbtn9.getText()=="OFF")
//				{
//					setSouthStatus("OFF");
//				}
//				
				// East Group
				if(tglbtn2.getText()=="ON")
				{
					eastwater = eastwater +3;
				}
				if(tglbtn6.getText()=="ON")
				{
					eastwater = eastwater +3;
				}
				
				// Set East Toggle button ON or OFF as per individual sprinklers
				if(tglbtn2.getText()== "ON"&& tglbtn6.getText()=="ON")
				{
					setEastStatus("ON");
				}
				else if(tglbtn2.getText()== "OFF"&& tglbtn6.getText()=="OFF")
				{
					setEastStatus("OFF");
				}
				
				//West Group
				if(tglbtn3.getText()=="ON")
				{
					westwater = westwater +3;
				}
				if(tglbtn7.getText()=="ON")
				{
					westwater = westwater +3;
				}
				// Set West Toggle button ON or OFF as per individual sprinklers
				if(tglbtn3.getText()== "ON"&& tglbtn7.getText()=="ON")
				{
					setWestStatus("ON");
				}
				else if(tglbtn3.getText()== "OFF"&& tglbtn7.getText()=="OFF")
				{
					setWestStatus("OFF");
				}
				
				
			}
			
		};
		
		
		
	}
	
	public void startTime()
	{
	// Change Temperature Field
	timer = new Timer(10000, timerListener);
	// Calculate Water Usage
	timer1 = new Timer(1000,setTimeListener);
	
	// Check Sprinklers for temperature Change
	timer2 = new Timer(2000,checkTempListener);
	
	timer1.start();
    //timer.start();
    timer2.start();
	
	}
	
	// if Sprinkler 0 is Active or not Active (NORTH)
	public void setLabel0(boolean status, boolean working)
	{
		
		if(status == true && working == true)
		{
			sp0.setIcon(sprinkleron);
			tglbtn0.setText("ON");
			tglbtn0.setSelected(false);
			
		}
		else
			{
			sp0.setIcon(broken);
			tglbtn0.setText("OFF");
			tglbtn0.setSelected(true);
			}
		
		
			
		JLabel no0 = new JLabel("0");
		no0.setBounds(197,55,30, 30);
		no0.setFont(new Font("Bell MT", Font.BOLD, 50));
		no0.setForeground(Color.BLACK);
			sp0.setBounds(222, 34, 90, 90);
			gardenlawn.add(sp0);
			gardenlawn.add(no0);
	}
	public boolean getLabel0()
	{
		if(tglbtn0.getText()=="ON")
		{
			return true;
		}
		else
			return false;
	}
	// if Sprinkler 1 is Active or not Active SOUTH
	public void setLabel1(boolean status)
	{
		if(status == true)
		{
			sp1.setIcon(sprinkleron);
			tglbtn1.setText("ON");
			tglbtn1.setSelected(false);
		}
		else
			{
			
			sp1.setIcon(sprinkleroff);
			tglbtn1.setText("OFF");
			tglbtn1.setSelected(true);}
		sp1.setBounds(300, 500, 90, 90);
		gardenlawn.add(sp1);
		JLabel no1 = new JLabel("1");
		no1.setBounds(250,510,30, 30);
		no1.setFont(new Font("Bell MT", Font.BOLD, 50));
		no1.setForeground(Color.black);
		gardenlawn.add(no1);
	}
	public boolean getLabel1()
	{
		if(tglbtn1.getText()=="ON")
		{
			return true;
		}
		else
			return false;
	}
	// if Sprinkler 2 is Active or not Active EAST
	public void setLabel2(boolean status)
	{
		if(status == true)
		{
			
			sp2.setIcon(sprinkleron);
			tglbtn2.setText("ON");
			tglbtn2.setSelected(false);		
		}
		else
			{
			sp2.setIcon(sprinkleroff);
			tglbtn2.setText("OFF");
			tglbtn2.setSelected(true);
			}
		    sp2.setBounds(1160, 200, 90, 90);
		    gardenlawn.add(sp2);
		    JLabel no2 = new JLabel("2");
		    no2.setBounds(1130,210,30,30);
			no2.setFont(new Font("Bell MT", Font.BOLD, 50));
			no2.setForeground(Color.black);
			gardenlawn.add(no2);
	}
	public boolean getLabel2()
	{
		if(tglbtn2.getText()=="ON")
		{
			return true;
		}
		else
			return false;
	}
	// if Sprinkler 3 is Active or not Active WEST
	public void setLabel3(boolean status)
	{
		if(status == true)
		{
			
			sp3.setIcon(sprinkleron);
			tglbtn3.setText("ON");
			tglbtn3.setSelected(false);
			
		}
		else
			{
			sp3.setIcon(sprinkleroff);
			tglbtn3.setText("OFF");
			tglbtn3.setSelected(true);
			}
		
		sp3.setBounds(100, 200, 90, 90);
		gardenlawn.add(sp3);
		 JLabel no3 = new JLabel("3");
		    no3.setBounds(60,210,30,30);
			no3.setFont(new Font("Bell MT", Font.BOLD, 50));
			no3.setForeground(Color.BLACK);
			gardenlawn.add(no3);
	}
	public boolean getLabel3()
	{
		if(tglbtn3.getText()=="ON")
		{
			return true;
		}
		else
			return false;
	}
	
// If Sprinkler 4 is active or not active NORTH
	public void setLabel4(boolean status)
	{
		if(status == true)
		{
			sp4.setIcon(sprinkleron);
			tglbtn4.setText("ON");
			tglbtn4.setSelected(false);
		}
		else
			{
			sp4.setIcon(sprinkleroff);
			tglbtn4.setText("OFF");
			tglbtn4.setSelected(true);
			}
			sp4.setBounds(730, 34, 90, 90);
			gardenlawn.add(sp4);
			JLabel no4 = new JLabel("4");
		    no4.setBounds(700,44,30,30);
			no4.setFont(new Font("Bell MT", Font.BOLD, 50));
			no4.setForeground(Color.BLACK);
			gardenlawn.add(no4);
	}
	public boolean getLabel4()
	{
		if(tglbtn4.getText()=="ON")
		{
			return true;
		}
		else
			return false;
	}
	
	// if Sprinkler 5 is Active or not Active SOUTH
		public void setLabel5(boolean status)
		{
			if(status == true)
			{
				sp5.setIcon(sprinkleron);
				tglbtn5.setText("ON");
				tglbtn5.setSelected(false);
			}
			else
				{
				sp5.setIcon(sprinkleroff);
				tglbtn5.setText("OFF");
				tglbtn5.setSelected(true);}
			sp5.setBounds(600, 500, 90, 90);
			gardenlawn.add(sp5);
			JLabel no5 = new JLabel("5");
		    no5.setBounds(550,510,30,30);
			no5.setFont(new Font("Bell MT", Font.BOLD, 50));
			no5.setForeground(Color.black);
			gardenlawn.add(no5);
		}
		public boolean getLabel5()
		{
			if(tglbtn5.getText()=="ON")
			{
				return true;
			}
			else
				return false;
		}
		
		// if Sprinkler 6 is Active or not Active EAST
		public void setLabel6(boolean status)
		{
			if(status == true)
			{
				sp6.setIcon(sprinkleron);
				tglbtn6.setText("ON");
				tglbtn6.setSelected(false);
			}
			else
			{
				sp6.setIcon(sprinkleroff);
				tglbtn6.setText("OFF");
				tglbtn6.setSelected(true);
			}
			sp6.setBounds(1160, 350, 90, 90);
			gardenlawn.add(sp6);
			JLabel no6 = new JLabel("6");
		    no6.setBounds(1130,350,30,30);
			no6.setFont(new Font("Bell MT", Font.BOLD, 50));
			no6.setForeground(Color.black);
			gardenlawn.add(no6);
		}
		public boolean getLabel6()
		{
			if(tglbtn6.getText()=="ON")
			{
				return true;
			}
			else
				return false;
		}
		
		// if Sprinkler 7 is Active or not Active WEST
		public void setLabel7(boolean status)
		{
			if(status == true)
			{
				sp7.setIcon(sprinkleron);
				tglbtn7.setText("ON");
				tglbtn7.setSelected(false);
			}
			else
				{
				
				sp7.setIcon(sprinkleroff);
				tglbtn7.setText("OFF");
				tglbtn7.setSelected(true);}
			sp7.setBounds(100, 300, 90, 90);
			gardenlawn.add(sp7);
			JLabel no7 = new JLabel("7");
		    no7.setBounds(69,310,30,30);
			no7.setFont(new Font("Bell MT", Font.BOLD, 50));
			no7.setForeground(Color.BLACK);
			gardenlawn.add(no7);
		}
		public boolean getLabel7()
		{
			if(tglbtn7.getText()=="ON")
			{
				return true;
			}
			else
				return false;
		}
		// if Sprinkler 8 is Active or not Active NORTH
		public void setLabel8(boolean status)
		{
			if(status == true)
			{
				sp8.setIcon(sprinkleron);
				tglbtn8.setText("ON");
				tglbtn8.setSelected(false);
			}
			else
				{
				
				sp8.setIcon(sprinkleroff);
				tglbtn8.setText("OFF");
				tglbtn8.setSelected(true);}
			sp8.setBounds(1060, 35, 90, 90);
			gardenlawn.add(sp8);
			JLabel no8 = new JLabel("8");
		    no8.setBounds(1030,45,30,30);
			no8.setFont(new Font("Bell MT", Font.BOLD, 50));
			no8.setForeground(Color.BLACK);
			gardenlawn.add(no8);
		}
		public boolean getLabel8()
		{
			if(tglbtn8.getText()=="ON")
			{
				return true;
			}
			else
				return false;
		}
		
		// if Sprinkler 9 is Active or not Active SOUTH
				public void setLabel9(boolean status)
				{
					if(status == true)
					{
						sp9.setIcon(sprinkleron);
						tglbtn9.setText("ON");
						tglbtn9.setSelected(false);
					}
					else
						{
						
						sp9.setIcon(sprinkleroff);
						tglbtn9.setText("OFF");
						tglbtn9.setSelected(true);}
					sp9.setBounds(1000, 500, 90, 90);
					gardenlawn.add(sp9);
					JLabel no9 = new JLabel("9");
				    no9.setBounds(960,510,30,30);
					no9.setFont(new Font("Bell MT", Font.BOLD, 50));
					no9.setForeground(Color.BLACK);
					gardenlawn.add(no9);
				}
				public boolean getLabel9()
				{
					if(tglbtn9.getText()=="ON")
					{
						return true;
					}
					else
						return false;
				}
	
	// toggle button0
	public void tglbtn0Listener(ActionListener action)
	{		 
		tglbtn0.addActionListener(action);
		
	}
	// toggle button1
		public void tglbtn1Listener(ActionListener action)
		{		 
			tglbtn1.addActionListener(action);
			
		}
	// toggle button2
		public void tglbtn2Listener(ActionListener action)
		{		 
			tglbtn2.addActionListener(action);
					
		}
	// toggle button3
		public void tglbtn3Listener(ActionListener action)
		{		 
			tglbtn3.addActionListener(action);
					
		}	
	// Toggle button4
		public void tglbtn4Listener(ActionListener action)
		{		 
			tglbtn4.addActionListener(action);
			
		}
	// Toggle button5
		public void tglbtn5Listener(ActionListener action)
		{		 
			tglbtn5.addActionListener(action);
			
		}
   // Toggle button6
		public void tglbtn6Listener(ActionListener action)
		{		 
			tglbtn6.addActionListener(action);
			
		}
	// Toggle button7
		public void tglbtn7Listener(ActionListener action)
		{		 
			tglbtn7.addActionListener(action);
			
		}
	// Toggle button8
		public void tglbtn8Listener(ActionListener action)
		{		 
			tglbtn8.addActionListener(action);
			
		}
	// Toggle button9
		public void tglbtn9Listener(ActionListener action)
		{		 
			tglbtn9.addActionListener(action);
			
		}
		
	// Toggle Button for North Group
		public void northtglbtnListener(ActionListener action)
		{
			northTglBtn.addActionListener(action);
		}
		
		
		public String getNorthStatus()
		{
			return northTglBtn.getText();
		}
		public void setNorthStatus(String status)
		{
			if(flagNorth== 0)
			{
				northTglBtn.setText(status);
			
				if(status == "ON")
				{
				northTglBtn.setSelected(false);
				if(flag0 == 0)
				{setLabel0(true,false);}
				if(flag4== 0){setLabel4(true);}
				if(flag8 == 0){setLabel8(true);}
				}
				else
				{
				northTglBtn.setSelected(true);
				if(flag0 == 0){setLabel0(false,false);}
				if(flag4 == 0){setLabel4(false);}
				if (flag8 == 0){setLabel8(false);}
				}
			}
		}
		// For Button Press
		public void setNorthStatusButton(String status)
		{
			northTglBtn.setText(status);
			
			if(status == "ON")
			{
				northTglBtn.setSelected(false);
				setLabel0(true,false);
				setLabel4(true);
				setLabel8(true);
			}
			else
			{
				northTglBtn.setSelected(true);
				setLabel0(false,false);
				setLabel4(false);
				setLabel8(false);
			}
		}
		
	// Toggle Button for South Group
		
		public void southtglbtnListener(ActionListener action)
		{
			southTglBtn.addActionListener(action);
		}
		public String getSouthStatus()
		{
			return southTglBtn.getText();
		}
		public void setSouthStatus(String status)
		{
			if(flagSouth == 0)
			{southTglBtn.setText(status);
			
			if(status == "ON")
			{
				southTglBtn.setSelected(false);
				if(flag1==0){setLabel1(true);}
				if(flag5==0){setLabel5(true);}
				if(flag9==0){setLabel9(true);}
			}
			else
			{ 	southTglBtn.setSelected(true);
				if(flag1==0){setLabel1(false);}
				if(flag5==0){setLabel5(false);}
				if(flag9==0){setLabel9(false);}
			}
			}
		}
		public void setSouthStatusButton(String status)
		{
			southTglBtn.setText(status);
			
			if(status == "ON")
			{
				southTglBtn.setSelected(false);
				setLabel1(true);
				setLabel5(true);
				setLabel9(true);
			}
			else
			{ 	southTglBtn.setSelected(true);
				setLabel1(false);
				setLabel5(false);
				setLabel9(false);
			}
		}
		
	// Toggle Button for East Group
		
		public void easttglbtnListener(ActionListener action)
		{
			eastTglBtn.addActionListener(action);
		}
		public String getEastStatus()
		{
			return eastTglBtn.getText();
		}
		public void setEastStatus(String status)
		{
			if(flagEast==0)
			{eastTglBtn.setText(status);
			
			if(status == "ON")
			{
				
				eastTglBtn.setSelected(false);
				if(flag2==0){setLabel2(true);}
				if(flag6==0){setLabel6(true);}
			}
			else
				{
				
				eastTglBtn.setSelected(true);
				if(flag2==0){setLabel2(false);}
				if(flag6==0){setLabel6(false);}
				}
			}
		}
		public void setEastStatusButton(String status)
		{
			eastTglBtn.setText(status);
			
			if(status == "ON")
			{
				
				eastTglBtn.setSelected(false);
				setLabel2(true);
				setLabel6(true);
			}
			else
				{
				
				eastTglBtn.setSelected(true);
				setLabel2(false);
				setLabel6(false);
				}
		}
			
	// Toggle Button for West Group
		
		public void westtglbtnListener(ActionListener action)
		{
			westTglBtn.addActionListener(action);
		}
		public String getWestStatus()
		{
			return westTglBtn.getText();
		}
		public void setWestStatus(String status)
		{
			if(flagWest==0)
			{	westTglBtn.setText(status);
			
			if(status == "ON")
			{
				
				westTglBtn.setSelected(false);
				if(flag3==0){setLabel3(true);}
				if(flag7==0){setLabel7(true);}
			}
			else
			{
				
				westTglBtn.setSelected(true);
				if(flag3==0){setLabel3(false);}
				if(flag7==0){setLabel7(false);}
			}
			}
		}
		
		public void setWestStatusButton(String status)
		{
			westTglBtn.setText(status);
			
			if(status == "ON")
			{
				
				westTglBtn.setSelected(false);
				setLabel3(true);
				setLabel7(true);
			}
			else
			{
				
				westTglBtn.setSelected(true);
				setLabel3(false);
				setLabel7(false);
			}
		}

	// Sprinkler System toggle button Action Listener
		public void tglbtnSprinklerListener(ActionListener action)
		{		 
			tglbtnSprinkler.addActionListener(action);
			
		}
	// Get Sprinkler sys toggle button status
		public boolean getSprinklerSysStatus()
		{
				if(tglbtnSprinkler.getText()== "ON")
				{
					return true;
				}
				else
					return false;
		}
	// set Sprinkler sys toggle button status
		public void setSprinklerSysStatus(boolean status)
		{
			if(status)
			{
				tglbtnSprinkler.setText("ON");
			}
			else
				tglbtnSprinkler.setText("OFF");
			
		}
		
  //  set Button visibility
		public void setButton(boolean status)
		{
			tglbtn0.setEnabled(status);
			tglbtn1.setEnabled(status);
			tglbtn2.setEnabled(status);
			tglbtn3.setEnabled(status);
			tglbtn4.setEnabled(status);
			tglbtn5.setEnabled(status);
			tglbtn6.setEnabled(status);
			tglbtn7.setEnabled(status);
			tglbtn8.setEnabled(status);
			tglbtn9.setEnabled(status);
	
			northTglBtn.setEnabled(status);
			southTglBtn.setEnabled(status);
			eastTglBtn.setEnabled(status);
			westTglBtn.setEnabled(status);
			
		}
		
	// Set Current Temperature
		public void setTemp(int temp)
		{
			tempText.setText(Integer.toString(temp));
			tempText.setVisible(true);
			
		}
		
		public void setNorthFR(double flowRate)
		{
			northFR.setText(Double.toString(flowRate));
		}
		public void setSouthFR(double flowRate)
		{
			southFR.setText(Double.toString(flowRate));
		}
		public void setEastFR(double flowRate)
		{
			eastFR.setText(Double.toString(flowRate));
		}
		public void setWestFR(double flowRate)
		{
			westFR.setText(Double.toString(flowRate));
		}
		
		//Anagha
		public void changeStatusTemp()
		{
			
			// Checking North Group Temperature and start Time and end time
			try{if(Integer.parseInt(tempNorth.getText().toString())<Integer.parseInt(tempText.getText().toString())
				||
				(((Integer.parseInt(northSH.getText())*60)+Integer.parseInt(northSM.getText()) <= 
				milisec) && (Integer.parseInt(northEH.getText())*60)+Integer.parseInt(northEM.getText()) >= milisec))
			{
			setNorthStatus("ON");
			
			}

			else
			{
				setNorthStatus("OFF");
			}
					
			}catch(NumberFormatException e)
			{
				System.out.println("Temperature can not be 0");
			}
			
			// Checking South Group Temperature and start Time and end time
			
			try{
				if(Integer.parseInt(tempSouth.getText().toString())<Integer.parseInt(tempText.getText().toString())
					||
					(((Integer.parseInt(southSH.getText())*60)+Integer.parseInt(southSM.getText()) <= 
					milisec) && (Integer.parseInt(southEH.getText())*60)+Integer.parseInt(southEM.getText()) >= milisec))
					
				{
				setSouthStatus("ON");
				}
				else
				{
					setSouthStatus("OFF");
				}
			}catch(NumberFormatException e)
			{
				System.out.println("Temperature can not be 0");
			}
			
			// Chaecking East Group Temperature and start Time and end time
			
			try{if(Integer.parseInt(tempEast.getText().toString())<Integer.parseInt(tempText.getText().toString())
					||
					(((Integer.parseInt(eastSH.getText())*60)+Integer.parseInt(eastSM.getText()) <= 
					milisec) && (Integer.parseInt(eastEH.getText())*60)+Integer.parseInt(eastEM.getText()) >= milisec))
			{
				setEastStatus("ON");
			}
			else
			{
				setEastStatus("OFF");
			}
			}catch(NumberFormatException e)
			{
				System.out.println("Temperature can not be 0");
			}
			
			//Checking West group
			try{
			if(Integer.parseInt(tempWest.getText().toString())<Integer.parseInt(tempText.getText().toString())
				||
				(((Integer.parseInt(westSH.getText())*60)+Integer.parseInt(westSM.getText()) <= 
				milisec) && (Integer.parseInt(westEH.getText())*60)+Integer.parseInt(westEM.getText()) >= milisec))
			{
				setWestStatus("ON");
			}
			else
			{
				setWestStatus("OFF");
			}
			}catch(NumberFormatException e)
			{
				System.out.println("Temperature can not be 0");
			}
		}
		// Starting and Ending Time for North
		public void northTime(int hourS , int minS , int hourE , int minE)
		{
			northSH.setText(Integer.toString(hourS));
			northSM.setText(Integer.toString(minS));
			northEH.setText(Integer.toString(hourE));
			northEM.setText(Integer.toString(minE));
		}
		// Starting and Ending Time for South
		public void southTime(int hourS , int minS , int hourE , int minE)
		{
			southSH.setText(Integer.toString(hourS));
			southSM.setText(Integer.toString(minS));
			southEH.setText(Integer.toString(hourE));
			southEM.setText(Integer.toString(minE));
		}
		// Starting and Ending Time for East
		public void eastTime(int hourS , int minS , int hourE , int minE)
		{
			eastSH.setText(Integer.toString(hourS));
			eastSM.setText(Integer.toString(minS));
			eastEH.setText(Integer.toString(hourE));
			eastEM.setText(Integer.toString(minE));
		}
		// Starting and Ending Time for West
		public void westTime(int hourS , int minS , int hourE , int minE)
		{
			westSH.setText(Integer.toString(hourS));
			westSM.setText(Integer.toString(minS));
			westEH.setText(Integer.toString(hourE));
			westEM.setText(Integer.toString(minE));
		}
		public int getNorthTime()
		{
			return northwater;
		}
		public int getSouthTime()
		{
			return southwater;
		}
		public int getEastTime()
		{
			return eastwater;
		}
		public int getWestTime()
		{
			return westwater;
		}
		public void setF0()
		{
			flag0 = 1;
		}
		public int getF0()
		{
			return flag0;
		}
}
