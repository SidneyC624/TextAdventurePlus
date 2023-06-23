package package01;
import javax.swing.*;

import package01.Game.ChoiceHandler;

import java.awt.*;

public class UI {
	JFrame frame;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JTextArea mainTextArea;
	JButton startButton, choice1, choice2, choice3, choice4;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	
	public void createUI(ChoiceHandler cHandler) {
		//window
		frame = new JFrame();
		con = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setBackground(Color.black);
		frame.setSize(800,600);
		frame.setLayout(null);
		
		//title screen
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Adventure");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusable(false);
		startButton.setActionCommand("start");
		startButton.addActionListener(cHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(startButtonPanel);
		con.add(titleNamePanel);
		
		//game screen
		mainTextPanel = new JPanel();
		mainTextPanel.setBackground(Color.black);
		mainTextPanel.setBounds(100,100,600,250);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(250,350,300,100);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4,1));
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusable(false);
		choice1.setActionCommand("c1");
		choice1.addActionListener(cHandler);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusable(false);
		choice2.setActionCommand("c2");
		choice2.addActionListener(cHandler);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusable(false);
		choice3.setActionCommand("c3");
		choice3.addActionListener(cHandler);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusable(false);
		choice4.setActionCommand("c4");
		choice4.addActionListener(cHandler);
		
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
		choicePanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setForeground(Color.white);
		hpLabel.setFont(normalFont);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setForeground(Color.white);
		hpLabelNumber.setFont(normalFont);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setForeground(Color.white);
		weaponLabel.setFont(normalFont);
		weaponLabelName = new JLabel();
		weaponLabelName.setForeground(Color.white);
		weaponLabelName.setFont(normalFont);
		
		playerPanel.add(hpLabel);
		playerPanel.add(hpLabelNumber);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponLabelName);
		
		con.add(playerPanel);
		con.add(mainTextPanel);
		con.add(choicePanel);
		
		frame.setVisible(true);
	}
}
