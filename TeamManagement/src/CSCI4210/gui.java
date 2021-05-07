package CSCI4210;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
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
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;

public class gui{

	private JFrame frmTeamResourceManager;
	public TeamManager manager;
	int index = 0;
	int cindex = 3;
	private JTable table_2;
	private JTable table_1;
	
	public  gui() {
		this.manager=new TeamManager();
		initialize();
	}
	
	
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
	
	/*
	 * Helps us find the Index of a given String in a table
	 */
	private int findIndex(String selectedIndex,DefaultTableModel model) {
		int rowCount = model.getRowCount();
		int colCount = model.getColumnCount();
		for(int i=0;i<rowCount;i++) {
			String rowEntry = "";
			for(int j=0;j<colCount;j++) {
				if(model.getValueAt(i, j)!=null) {
					rowEntry =  model.getValueAt(i, j).toString();
					
					if(rowEntry.equalsIgnoreCase(selectedIndex)) {
						return i;
					}
				}
			}
			
		}
		return 0;
	}

	
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	 
	 
	private void initialize() {
		JLabel lblNewLabel = new JLabel("Team Selected to Edit");
		JComboBox TeamcomboBox = new JComboBox();
		TeamcomboBox.setVisible(false);
		frmTeamResourceManager = new JFrame();
		frmTeamResourceManager.setMaximumSize(new Dimension(200, 5000));
		frmTeamResourceManager.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTeamResourceManager.setBackground(Color.BLACK);
		frmTeamResourceManager.setTitle("Team Resource Manager");
		frmTeamResourceManager.setBounds(100, 100, 1588, 1020);
		frmTeamResourceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("Add Team"); //This is the Add Team button that appears at the top of the screen
		btnNewButton.setBounds(10, 10, 1554, 21);
		
		JButton Cacluate = new JButton("Cacluate");
		JButton AddResource = new JButton("AddResource");
		JButton AddMember = new JButton("AddMember");
		JButton TeamButton = new JButton("Add Team");
		
		
		
		/*
		 * Logic for the Team table
		 * 
		 *  
		 *  
		 */
		JTable teamName_1 = new JTable(new DefaultTableModel(new String[] {"TeamName","First Name","Last Name","Weight"},10)) {
			@Override
			public boolean isCellEditable(int row,int column) {
				return column == 5;
			}
		};
		teamName_1.setForeground(Color.BLACK);
		teamName_1.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(teamName_1);
		scrollPane.setMaximumSize(new Dimension(2000, 32767));
		teamName_1.setAutoCreateRowSorter(true);
		teamName_1.setFont(new Font("Dialog", Font.BOLD, 18));
		DefaultTableModel model = (DefaultTableModel) teamName_1.getModel();
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
		sorter.setComparator(0, new Comparator<String>() {
			@Override
			public int compare(String o1,String o2) {
				return o1.compareTo(o2);
			}
		});
		TreeSet<String> currentNames = new TreeSet<String>();
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		sortKeys.add(new RowSorter.SortKey(0,SortOrder.DESCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.setSortsOnUpdates(true);
		teamName_1.setRowSorter(sorter);
		teamName_1.getTableHeader().setEnabled(false);
		
		
		
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel ResourceLabel = new JLabel("Resource to Edit");
		ResourceLabel.setBackground(Color.CYAN);
		ResourceLabel.setForeground(Color.CYAN);
		ResourceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ResourceLabel.setVisible(false);
		
		JComboBox ResourceComboBox = new JComboBox();
		ResourceComboBox.setBackground(new Color(0, 102, 204));
		ResourceComboBox.setVisible(false);
		
		JButton UpdateResourceButton = new JButton("Update Resource Amount");
		UpdateResourceButton.setBackground(new Color(0, 102, 255));
		UpdateResourceButton.setForeground(Color.WHITE);
		UpdateResourceButton.setVisible(false);
		
		
		
		
		
		JButton ResetUsedResourcesButton = new JButton("Reset Resources Used Button");
		
		ResetUsedResourcesButton.setBackground(new Color(0, 102, 255));
		ResetUsedResourcesButton.setForeground(Color.WHITE);
		ResetUsedResourcesButton.setVisible(false);
		
		JButton DeleteResourceButton = new JButton("Delete Resource ");
		DeleteResourceButton.setBackground(new Color(0, 102, 255));
		DeleteResourceButton.setForeground(Color.WHITE);
		DeleteResourceButton.setVisible(false);
		
		
	
		
		JButton RemoveMemberButton = new JButton("Remove Member");
		RemoveMemberButton.setBackground(new Color(0, 102, 255));
		RemoveMemberButton.setForeground(Color.WHITE);
		RemoveMemberButton.setVisible(false);
		
		
		/*IGNORE ALL OF THIS
		 * THIS IS ECLIPSE GROUP LAYOUT STUFF
		 * 
		 * 
		 * 
		 * 
		 */
		GroupLayout groupLayout = new GroupLayout(frmTeamResourceManager.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DeleteResourceButton, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addComponent(ResetUsedResourcesButton, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addComponent(UpdateResourceButton, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TeamcomboBox, 0, 149, Short.MAX_VALUE)
							.addGap(30))
						.addComponent(Cacluate, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addComponent(AddResource, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addComponent(TeamButton, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ResourceLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ResourceComboBox, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AddMember, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(RemoveMemberButton, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1224, GroupLayout.PREFERRED_SIZE)
							.addGap(8))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
									.addGap(2))
								.addComponent(TeamcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TeamButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AddMember, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(RemoveMemberButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AddResource, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Cacluate, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
							.addGap(234))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(ResourceComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ResourceLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UpdateResourceButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ResetUsedResourcesButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(DeleteResourceButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(397))))
		);
		/*
		 * THE LAYOUT STUFF ENDS HERE
		 * 
		 * 
		 * 
		 */
		
		JTable ResourceTable = new JTable(new DefaultTableModel(new String[] {"Resource","Resouce Remaining","Total Resource used"},10)) {
			@Override
			public boolean isCellEditable(int row,int column) {
				return column == 5;
			}
		};
		ResourceTable.setForeground(Color.BLACK);
		ResourceTable.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(ResourceTable);
		DefaultTableModel model2 = (DefaultTableModel) ResourceTable.getModel();
		
		
		/*
		 * Update Resource Button LOGIC: 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		UpdateResourceButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(manager.teamResources.size()==-1) {
					JOptionPane.showMessageDialog(lblNewLabel, "There is no Resources to Caculate!");
					
				}
				else {
					JTextField Amount = new JTextField();
				
					Object[] fields = {
						"Enter Amount to decrease or increase",Amount,
						
					};
					int input = JOptionPane.showConfirmDialog(null, fields,"Member Information",JOptionPane.OK_CANCEL_OPTION);
					if(input ==JOptionPane.OK_OPTION) {
					
						int ResourceIndex = ResourceComboBox.getSelectedIndex();
						double Converted = Double.parseDouble(Amount.getText());
						manager.teamResources.get(ResourceIndex).increaseNumericalVal(Converted);
						model2.setValueAt(manager.teamResources.get(ResourceIndex).getNumericalVal(), ResourceIndex, 1);
					}
				}
			}

			
		});
		
		
		
		
		
	
		/*
		 * Cacluate button logic goes here
		 * 
		 * 
		 * 
		 * 
		 */
		
		Cacluate.setForeground(Color.WHITE);
		Cacluate.setBackground(new Color(0, 102, 255));
		
		Cacluate.setVisible(false);
		Cacluate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				
				JComboBox Name = new JComboBox(); //Used to Make the Resource ComboBox
				ActionListener actionListener = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				        Name.getSelectedIndex();
				      }
				    };
				    Name.addActionListener(actionListener);
				JTextField Amount = new JTextField(); // Used to Grab how much to allocate
				setUpRComboBox(Name); //Sets up the comboBox for Resources
				Object[] fields = {
						"Which Resource?",Name,
						"Amount to Allocate " ,Amount,
						
				};
				int valid= JOptionPane.showConfirmDialog(null,fields,"Cacluations" ,JOptionPane.OK_CANCEL_OPTION); // This allows us to get the Index Of the Resource the user Selected
				if(valid ==JOptionPane.OK_OPTION) { //If The user presses Okay we are good to go.
					
				
					int ResourceIndex = Name.getSelectedIndex();
					int teamIndex = TeamcomboBox.getSelectedIndex(); //The Input from the User from the dropdown box
					int currentIndex = findIndex(TeamcomboBox.getSelectedItem().toString(),model); // Find Where the Name first appears in the Table
					int placementIndex=currentIndex+manager.team.get(teamIndex).members.size(); //To be used on where it should be placed on the table	
					if(Double.parseDouble(Amount.getText())>manager.teamResources.get(ResourceIndex).getNumericalVal()) { //Checks to see if its possible to Actually run with this resource
						JOptionPane.showMessageDialog(lblNewLabel, "Amount is greater than resource"); //Error message
					}
					else {
						for(int j = manager.team.get(teamIndex).members.size();j-->0;) {
							if(manager.team.get(teamIndex).members.get(j).getFullName()!=null) {
								double allocation = manager.team.get(teamIndex).members.get(j).getWeight() * Double.parseDouble(Amount.getText());
								manager.teamResources.get(ResourceIndex).setResourceUsed(allocation);
								manager.teamResources.get(ResourceIndex).decreaseRemainingResource(allocation);;
								double rLeft = manager.teamResources.get(ResourceIndex).getNumericalVal() - manager.teamResources.get(ResourceIndex).getUsedResource(); //Resources Left = r.getNumericalVal() - r.getUsedResource();
								model.setValueAt(allocation, findIndex(manager.team.get(teamIndex).members.get(j).firstName,model),teamName_1.getColumn("Allocated Resource for: " + manager.teamResources.get(ResourceIndex).name).getModelIndex());
								model2.setValueAt(rLeft, ResourceIndex, 1);
								model2.setValueAt(manager.teamResources.get(ResourceIndex).getUsedResource(), ResourceIndex, 2);
								
								
								
								}
						}
					}
					
				}
			}
		});
		
	
		/*
		 * LOGIC FOR ADD RESOURCE BUTTON
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		AddResource.setBackground(new Color(0, 102, 255));
		AddResource.setForeground(Color.WHITE);
		
		AddResource.setVisible(false);
		AddResource.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				JTextField Name = new JTextField();
				JTextField Amount = new JTextField();
				
				Object[] fields = {
						"Name of Resource",Name,
						"Amount of Resources",Amount,
				};
				int input = JOptionPane.showConfirmDialog(null, fields,"Add Resource",JOptionPane.OK_CANCEL_OPTION);
				if(input==JOptionPane.OK_OPTION) {
					int currentIndex = TeamcomboBox.getSelectedIndex();
					if(onlyDigits(Amount.getText())==false) {
						JOptionPane.showMessageDialog(lblNewLabel, "Please Enter a number for Amount");
					}
					else {
						double convertToDouble = Double.parseDouble(Amount.getText());
						manager.teamResources.add(new Resources(Name.getText(),convertToDouble));
						model.addColumn("Allocated Resource for: " +Name.getText());
						model2.setValueAt(Name.getText(),manager.teamResources.size()-1,0);
						model2.setValueAt(convertToDouble,manager.teamResources.size()-1,1);
						ResourceComboBox.setVisible(true);
						UpdateResourceButton.setVisible(true);
						ResetUsedResourcesButton.setVisible(true);
						ResourceLabel.setVisible(true);
						ResourceComboBox.addItem(Name.getText());
						sorter.setSortable(model.getColumnCount()-1, false);
						cindex++;
						
					}
				
				}
			}
			/*
			 * A built in method to check if the string entered is a number
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			private boolean onlyDigits(String text) {
				for(int i=0;i<text.length();i++) {
					if(!Character.isDigit(text.charAt(i))) {
						return false;
					}
				}
				return true;
			}
		});
		
		
		
		/*
		 * LOGIC FOR ADD MEMBER BUTTON GOES HERE
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		AddMember.setBackground(new Color(0, 102, 255));
		AddMember.setForeground(Color.WHITE);
		AddMember.setVisible(false);
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
				int input = JOptionPane.showConfirmDialog(null, fields,"Member Information",JOptionPane.OK_CANCEL_OPTION);
				if(input ==JOptionPane.OK_OPTION) {
					if(index==model.getRowCount()) { // I believe this will make it so we can dynamically add rows when the user runs out
						for(int i = 1; i<model.getColumnCount();i++) {
							Vector<Object> data = new Vector<Object>();
							data.add(null);
							model.addRow(data);
						}
					}
					
					int teamIndex = TeamcomboBox.getSelectedIndex(); //The Input from the User from the dropdown box
					int currentIndex = findIndex(TeamcomboBox.getSelectedItem().toString(),model); // Find Where the Name first appears in the Table
					int placementIndex; //To be used on where it should be placed on the table
					if(manager.team.get(teamIndex).members.size()==0) {
						 placementIndex = currentIndex+1; //First Member of the Team being added
					}
					else {
						placementIndex = currentIndex+manager.team.get(teamIndex).members.size()+1; //All other members afterwards are added +1
					}
					double convertToDouble = Double.parseDouble(resourceWeight.getText());
					manager.team.get(teamIndex).members.add(new TeamMembers(firstName.getText(),lastName.getText(),convertToDouble));
					model.setValueAt(TeamcomboBox.getSelectedItem(),index, 0);
					model.setValueAt(firstName.getText(), index,1);
					model.setValueAt(lastName.getText(), index,2);
					model.setValueAt(convertToDouble, index,3);
					RemoveMemberButton.setVisible(true);
					index++;
				}
			}

			
		});
		
		
		/*
		 * This is the add Team Button logic
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		TeamButton.setForeground(Color.WHITE);
		TeamButton.setBackground(new Color(0, 102, 255));
		TeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField textField = new JTextField();
				Object[] field = {"Enter Team Name",textField};
				textField.setVisible(true);
				int input =JOptionPane.showConfirmDialog(null, field,"Enter Team Name",JOptionPane.OK_CANCEL_OPTION);
				if(input ==JOptionPane.OK_OPTION) {
					if(index==model.getRowCount()) { // I believe this will make it so we can dynamically add rows when the user runs out
						for(int i = 1; i<model.getColumnCount();i++) {
							Vector<Object> data = new Vector<Object>();
							data.add(null);
							model.addRow(data);
						}
					}
					if(manager.team==null) {
						manager.team = new ArrayList<Teams>();
						manager.team.add(new Teams(textField.getText()));
						currentNames.add(textField.getText());
						model.setValueAt(textField.getText(),0,0);
						index++;
					}
					else {
					
						currentNames.add(textField.getText());
						manager.team.add(new Teams(textField.getText()));
						model.setValueAt(textField.getText(), index,0);
						TeamcomboBox.addItem(textField.getText());
						index++;
					textField.setVisible(false);
					teamName_1.setVisible(true);
					Cacluate.setVisible(true);
					AddResource.setVisible(true);
					AddMember.setVisible(true);
					TeamcomboBox.setBackground(new Color(0, 102, 255));
					TeamcomboBox.setForeground(Color.WHITE);
					TeamcomboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
					TeamcomboBox.setVisible(true);
					DeleteResourceButton.setVisible(false);
				}
					textField.setText(""); //Reset the text field for the input of names
					
				}
			}
				
		});
		
		/*
		 * 
		 * Reset Used Resource LOGIC
		 * 
		 */
		ResetUsedResourcesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.teamResources.size()==-1) {
					JOptionPane.showMessageDialog(lblNewLabel, "There is no Resources to Caculate!");
				}
				else {
					int resourceIndex = ResourceComboBox.getSelectedIndex();
					manager.teamResources.get(resourceIndex).getUsedResource();
				
					model2.setValueAt(0, resourceIndex, 2);
				}
			}
		});
		
		/*
		 * 
		 * Delete Resource Button
		 * 
		 */
		DeleteResourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resourceIndex = ResourceComboBox.getSelectedIndex();
				model2.setValueAt(null, resourceIndex, 0);
				model2.setValueAt(null, resourceIndex, 1);
				model2.setValueAt(null, resourceIndex, 2);
				teamName_1.removeColumn(teamName_1.getColumn("Allocated Resource for: " + manager.teamResources.get(resourceIndex).name));
				ResourceComboBox.removeItemAt(resourceIndex);
				manager.teamResources.remove(resourceIndex);
				
			}
		});
		
		
		
		/*
		 * 
		 * Remove Member BUtton
		 * 
		 */
		RemoveMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(lblNewLabel, manager.team.get(TeamcomboBox.getSelectedIndex()).members.size());
				if(manager.team.get(TeamcomboBox.getSelectedIndex()).members.size()==0) {
					JOptionPane.showMessageDialog(lblNewLabel, "There are no Memebers to remove");
				}
				else {
				JComboBox Name = new JComboBox(); //Used to Make the Resource ComboBox
				ActionListener actionListener = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				        Name.getSelectedIndex();
				      }
				    };
				    Name.addActionListener(actionListener);
				    setUpMComboBox(Name,TeamcomboBox.getSelectedIndex());
				    Object[] fields = {
							"Which Team member?",Name,
							
							
					};
					int valid= JOptionPane.showConfirmDialog(null,fields,"Cacluations" ,JOptionPane.OK_CANCEL_OPTION); // This allows us to get the Index Of the Resource the user Selected
					
						if(valid ==JOptionPane.OK_OPTION) {
							int rowIndex = findIndex(Name.getSelectedItem().toString(),model);
							model.removeRow(rowIndex);
							manager.team.get(TeamcomboBox.getSelectedIndex()).removeMember(Name.getSelectedIndex());
							
						}
				}
			}
		});
		
		

		
		
	
		frmTeamResourceManager.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmTeamResourceManager.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File"); //Displays File on top of our window
		menuBar.add(mnNewMenu);
		
		
		/*
		 * This Button is For The Excel Export
		 */
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Export to Excel"); // This is for the jmenu bar item for File: Its exports it to excel
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(fc);
                if(option == JFileChooser.APPROVE_OPTION){ //Allows the user to choose thier desired path
                    String filename = fc.getSelectedFile().getName(); 
                    String path = fc.getSelectedFile().getParentFile().getPath();

					int len = filename.length();
					String ext = "";
					String file = "";

					if(len > 4){ //This is a check for the extension, this allows us to force it to save it as a .xls file
						ext = filename.substring(len-4, len);
					}

					if(ext.equals(".xls")){
						file = path + "\\" + filename; 
					}else{
						file = path + "\\" + filename + ".xls"; 
					}
					toExcel(teamName_1, new File(file)); 
                }
				
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Print"); //adds print under file
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				
				try {
					teamName_1.print();
				}
				catch(Exception l) {
					JOptionPane.showMessageDialog(scrollPane, l);
				}
				
				
			}
		});
		
		
		
		
		
		
		
		
		
			
		//After the first team has been set, we can now use the other buttons.
		
		
		/*
		 * This Method adds a listener to the addMember button, it creates a POPUP that allows users to type in information 
		 * 
		 */
	}
	
	
	private void setUpMComboBox(JComboBox box,int index) {
		for(int i = 0;i<manager.team.get(index).getTeamSize();i++) {
			box.addItem(manager.team.get(index).members.get(i).firstName);
		}
	}
	
	
	private void setUpRComboBox(JComboBox box) {
		for(int i = 0;i<manager.teamResources.size();i++) {
			box.addItem(manager.teamResources.get(i).name.toString());
		}
	}
	/*
	 * This method allows us to export our jtable to an excel file through serialization.
	 */
	private void toExcel(JTable table, File file){ 
	    try{
	        TableModel model = table.getModel();
	        FileWriter excel = new FileWriter(file);

	        for(int i = 0; i < model.getColumnCount(); i++){
	        	if(model.getColumnName(i)!=null) {
	        		excel.write(model.getColumnName(i) + "\t");
	        	}
	            
	        }

	        excel.write("\n");

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	            	if(model.getValueAt(i,j)!=null){
	            		excel.write(model.getValueAt(i,j).toString()+"\t");
	            	}
	            }
	            excel.write("\n");
	        }

	        excel.close();

	    }catch(IOException e){ System.out.println(e); }
	}
}
