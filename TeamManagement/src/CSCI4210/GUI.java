package CSCI4210;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import java.text.MessageFormat;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import java.awt.Panel;

public class gui {

	private JFrame frmTeamResourceManager;
	public TeamManagementRunner manager;
	ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
	int index = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmTeamResourceManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		this.manager=new TeamManagementRunner();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		
		frmTeamResourceManager = new JFrame();
		frmTeamResourceManager.setMaximumSize(new Dimension(200, 5000));
		frmTeamResourceManager.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTeamResourceManager.setBackground(Color.BLACK);
		frmTeamResourceManager.setTitle("Team Resource Manager");
		frmTeamResourceManager.setBounds(100, 100, 1588, 1020);
		frmTeamResourceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("Add Team"); //This is the Add Team button that appears at the top of the screen
		btnNewButton.setBounds(10, 10, 1554, 21);
		
		
		
		
		
		/*
		 * 
		 * THIS ONLY APPEARS ONLY AFTER THE USER INPUTS THE FIRST TEAM. 
		 * THE IDEA IS THAT THE USER CAN PICK WHICH TEAM TO EDIT OR RUN CALCUATIONS ON
		 * THAT INFORMATION WILL THEN BE DISPLAYED WITH A JTABLE
		 * 
		 * 
		 */
		
		JComboBox TeamcomboBox = new JComboBox();
		TeamcomboBox.setBackground(new Color(0, 102, 255));
		TeamcomboBox.setForeground(Color.WHITE);
		TeamcomboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		TeamcomboBox.setVisible(false);
		JButton AddMember = new JButton("AddMember");
		AddMember.setBackground(new Color(0, 102, 255));
		AddMember.setForeground(Color.WHITE);
		AddMember.setVisible(false);
		
		
		JButton AddResource = new JButton("AddResource");
		AddResource.setBackground(new Color(0, 102, 255));
		AddResource.setForeground(Color.WHITE);
		AddResource.setVisible(false);
		
		JButton Cacluate = new JButton("Cacluate");
		Cacluate.setForeground(Color.WHITE);
		Cacluate.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel = new JLabel("Team Selected to Edit");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//JLabel teamName_1 = new JLabel("Selected Team:");
		//teamName_1.setFont(new Font("Dialog", Font.BOLD, 18));
		//teamName_1.setVisible(false);
		
		
		JTable teamName_1 = new JTable(new DefaultTableModel(new String[] {"TeamName","First Name","Last Name","Weight","Allocated Resource"},10));
		teamName_1.setForeground(Color.BLACK);
		teamName_1.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(teamName_1);
		scrollPane.setMaximumSize(new Dimension(2000, 32767));
		teamName_1.setAutoCreateRowSorter(true);
		teamName_1.setFont(new Font("Dialog", Font.BOLD, 18));
		DefaultTableModel model = (DefaultTableModel) teamName_1.getModel();
		
		JButton PrintButton = new JButton("Print");
		PrintButton.setForeground(Color.WHITE);
		PrintButton.setBackground(new Color(0, 102, 255));
		PrintButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) { 
					MessageFormat test = new MessageFormat("test");
					try {
						teamName_1.print();
					}
					catch(Exception l) {
						JOptionPane.showMessageDialog(scrollPane, l);
					}
					
					
				}
			});
		
		JButton btnNewButton_1 = new JButton("Add Team");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 102, 255));
		TreeSet<String> currentNames = new TreeSet<String>();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField textField = new JTextField();
				Object[] field = {"Enter Team Name",textField};
				textField.setVisible(true);
				JOptionPane.showConfirmDialog(null, field,"Enter Team Name",JOptionPane.OK_CANCEL_OPTION);
				if(manager.team==null) {
					manager.team = new ArrayList<Teams>();
					manager.team.add(new Teams(textField.getText()));
					currentNames.add(textField.getText());
					model.setValueAt(textField.getText(),0,0);
					//data.get(index).add(textField.getText());
					index++;
				}
				else {
					if(currentNames.contains(textField.getText())) {
						//TODO IMPLEMENT ERROR MESSAGE
					}
					currentNames.add(textField.getText());
					manager.team.add(new Teams(textField.getText()));
					model.setValueAt(textField.getText(), index,0);
					index+=2;
				textField.setVisible(false);
				teamName_1.setVisible(true);
				Cacluate.setVisible(true);
				AddResource.setVisible(true);
				AddMember.setVisible(true);
				TeamcomboBox.setVisible(true);
				TeamcomboBox.removeAllItems();//This is to ensure we Don't get multiple duplicates
				for(String names: currentNames) {
					
					TeamcomboBox.addItem(names);
					}
				}
				textField.setText(""); //Reset the text field for the input of names
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frmTeamResourceManager.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TeamcomboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(1223))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Cacluate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(AddResource, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(AddMember, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(PrintButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1718, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PrintButton)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(TeamcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(AddMember)
					.addGap(40)
					.addComponent(AddResource, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(Cacluate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(328))
		);
		frmTeamResourceManager.getContentPane().setLayout(groupLayout);
		
		Cacluate.setVisible(false);
		
		
		
		
		
		
		
		
		
			
		//After the first team has been set, we can now use the other buttons.
		
		
		/*
		 * This Method adds a listener to the addMember button, it creates a POPUP that allows users to type in information 
		 * 
		 */
		AddMember.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				JTextField firstName = new JTextField();
				JTextField lastName = new JTextField();
				JTextField resourceWeight = new JTextField();
				Object[] fields = {
						"Enter FirstName",firstName,
						"Enter LastName",lastName,
						"Enter the wieght for the resources(Has to be from 1.0-0.0)",resourceWeight
				};
				JOptionPane.showConfirmDialog(null, fields,"Member Information",JOptionPane.OK_CANCEL_OPTION);
				
				int currentIndex = TeamcomboBox.getSelectedIndex();
				double convertToDouble = Double.parseDouble(resourceWeight.getText());
				manager.team.get(currentIndex).members.add(new TeamMembers(firstName.getText(),lastName.getText(),convertToDouble));
				model.setValueAt(TeamcomboBox.getSelectedItem(),index-1, 0);
				model.setValueAt(firstName.getText(), index-1,1);
				model.setValueAt(lastName.getText(), index-1,2);
				model.setValueAt(convertToDouble, index-1,3);
				index++;
				//data.get(currentIndex).add(firstName.getText());
			//	data.get(currentIndex).add(lastName.getText());
				//data.get(currentIndex).add(convertToDouble);
				
			}
		});
		
		
		AddResource.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				JTextField Name = new JTextField();
				JTextField Amount = new JTextField();
				
				Object[] fields = {
						"Name of Resource",Name,
						"Amount of Resources",Amount,
				};
				JOptionPane.showConfirmDialog(null, fields,"Add Resource",JOptionPane.OK_CANCEL_OPTION);
				
				int currentIndex = TeamcomboBox.getSelectedIndex();
				double convertToDouble = Double.parseDouble(Amount.getText());
				manager.teamResources.add(new Resources(Name.getText(),convertToDouble));
				
				//data.get(currentIndex).add(Name.getText());
				//data.get(currentIndex).add(convertToDouble);
				
				
				
			}
		});
		

		Cacluate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				
				JComboBox Name = new JComboBox();
				JTextField Amount = new JTextField();
				setUpComboBox(Name);
				Object[] fields = {
						"Which Resource?",Name,
						"Amount Allocated to " + TeamcomboBox.getSelectedIndex(),Amount,
				};
				JOptionPane.showConfirmDialog(null, fields,"Cacluations",JOptionPane.OK_CANCEL_OPTION);
				
				
			}
		});
	}
	private void setUpComboBox(JComboBox box) {
		for(int i = 0;i<manager.teamResources.size();i++) {
			box.addItem(manager.teamResources.get(i).name.toString());
		}
	}
}
