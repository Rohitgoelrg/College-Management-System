import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;


class Admin  {
	
	static JTable table;
	String[] columnNames = {"First name", "Last name", "username", "Password", "Role id", "Gender"};
	Connection con;
	Statement st;
	
	Admin(String lusername) throws ClassNotFoundException, SQLException{
	

		//To get screen size end

		JFrame userFrame=new JFrame("Admin");
		userFrame.setLayout(null);
		userFrame.setBounds(0,0,1366,718);
		
		JLabel lblHeading=new JLabel("College Management System");
		lblHeading.setFont(new Font("ARIAL", Font.BOLD,40));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(0, 10, 1366, 70);
		userFrame.add(lblHeading);
		
		JPanel backuser=new JPanel();
		backuser.setLayout(null);
		backuser.setBounds(0,80,1366,588);
		backuser.setBackground(Color.black);
		userFrame.add(backuser);
		
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(20,10,200,568);
		btnPanel.setBackground(Color.gray);	
		backuser.add(btnPanel);
	

		
		//adding buttons in btnPanel
		
		JButton btn1=new JButton("Approval");
		btn1.setBounds(20, 80, 140, 20);
		btnPanel.add(btn1);
		

		JButton btn2=new JButton("Add Faculty");
		btn2.setBounds(20, 120, 140, 20);
		btnPanel.add(btn2);
		
		JButton btn3=new JButton("Add Student");
		btn3.setBounds(20, 160, 140, 20);
		btnPanel.add(btn3);
		
		JButton btn4=new JButton("Add Account");
		btn4.setBounds(20, 200, 140, 20);
		btnPanel.add(btn4);
		
		JButton btnLogout=new JButton("Logout");
		btnLogout.setBounds(20, 240, 140, 20);	
		btnPanel.add(btnLogout);
		//btnPanel add button end
		
		JPanel Approval_panel=new JPanel();
		JTextArea txtApprove=new JTextArea();
		JButton btnApprove=new JButton("Approve user");
		Approval_panel.setBounds(230, 10, 1100,568);
		Approval_panel.setBackground(Color.MAGENTA);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model); 
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(70,10, 800, 350);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

		String fname= "";
		String lname= "";
		String uname = "";
		String password = "";
		String rid="";
		String gender="";
		
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
		PreparedStatement ps = con.prepareStatement("select * from register");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		fname = rs.getString(1);
		lname = rs.getString(2);
		uname = rs.getString(3);
		password = rs.getString(4);
		rid=rs.getString(5);
		gender=rs.getString(6);
		model.addRow(new Object[]{fname, lname, uname, password, rid, gender});
		}
		
		txtApprove.setBounds(150, 380, 150, 20);
		btnApprove.setBounds(310, 380, 150, 20);
		
		Approval_panel.add(txtApprove);
		Approval_panel.add(btnApprove);
		Approval_panel.add(scroll);
		Approval_panel.setLayout(null);
		
		JPanel Add_faculty_panel=new JPanel();
		Add_faculty_panel.setBounds(230, 10, 1110,568);
		Add_faculty_panel.setVisible(false);
		Add_faculty_panel.setBackground(Color.BLUE);
		Add_faculty_panel.setLayout(null);
		
		
		
		JPanel Add_student_panel=new JPanel();
		Add_student_panel.setBounds(230, 10, 1110,568);
		Add_student_panel.setVisible(false);
		Add_student_panel.setBackground(Color.CYAN);
		Add_student_panel.setLayout(null);
		
		
		
		JPanel Add_account_panel=new JPanel();
		Add_account_panel.setBounds(230, 10, 1110,568);
		Add_account_panel.setVisible(false);
		Add_account_panel.setBackground(Color.ORANGE);
		Add_account_panel.setLayout(null);
		
		
		backuser.add(Approval_panel);
		backuser.add(Add_account_panel);
		backuser.add(Add_student_panel);
		backuser.add(Add_faculty_panel);
		
		
		//designing of add faculty panel
				JLabel lblFirstName,lblLastName,lblrpassword,lblGender;
				lblFirstName=new JLabel("First Name");
				lblLastName=new JLabel("Last Name");
				lblrpassword=new JLabel("Password");
				lblGender=new JLabel("Gender");
				
				
				JTextField txtFname,txtLname,txtrpassword;
				txtFname=new JTextField();
				txtLname=new JTextField();
				txtrpassword=new JTextField();
				
				
				
				JRadioButton genderMale=new JRadioButton("Male");  
				genderMale.setActionCommand("Male");
				JRadioButton genderFemale=new JRadioButton("Female");
				genderFemale.setActionCommand("Female");
				ButtonGroup bg=new ButtonGroup();    
				bg.add(genderMale);bg.add(genderFemale); 
				JButton btnRegister_faculty=new JButton("Register");
				
				
				
				lblFirstName.setBounds(190, 130, 190, 20);
				lblFirstName.setFont(new Font("ARIAL", Font.BOLD,20));
				txtFname.setBounds(300, 130, 340, 30);
				lblLastName.setBounds(190, 210, 190, 20);
				lblLastName.setFont(new Font("ARIAL", Font.BOLD,20));
				txtLname.setBounds(300, 210, 340, 30);
				lblrpassword.setBounds(190, 290, 190, 20);
				lblrpassword.setFont(new Font("ARIAL", Font.BOLD,20));
				txtrpassword.setBounds(300, 290, 340, 30);
				lblGender.setBounds(190, 370, 190, 20);
				lblGender.setFont(new Font("ARIAL", Font.BOLD,20));
				genderMale.setBounds(300, 370, 100, 20);
				genderMale.setFont(new Font("ARIAL", Font.BOLD,20));
				genderFemale.setBounds(400, 370, 100, 20);
				genderFemale.setFont(new Font("ARIAL", Font.BOLD,20));
				
				btnRegister_faculty.setBounds(300, 450, 190, 30);
				
				Add_faculty_panel.add(btnRegister_faculty);
				Add_faculty_panel.add(genderFemale);
				Add_faculty_panel.add(genderMale);
				Add_faculty_panel.add(txtrpassword);
				Add_faculty_panel.add(txtLname);
				Add_faculty_panel.add(txtFname);
				Add_faculty_panel.add(lblGender);
				Add_faculty_panel.add(lblrpassword);
				Add_faculty_panel.add(lblLastName);
				Add_faculty_panel.add(lblFirstName);
			
				
				
				//creating buttons and labels again for student
			
				JLabel slblFirstName,slblLastName,slblrpassword,slblGender;
				slblFirstName=new JLabel("First Name");
				slblLastName=new JLabel("Last Name");
				slblrpassword=new JLabel("Password");
				slblGender=new JLabel("Gender");
				
				
				JTextField stxtFname,stxtLname,stxtrpassword;
				stxtFname=new JTextField();
				stxtLname=new JTextField();
				stxtrpassword=new JTextField();
				
				
				
				JRadioButton sgenderMale=new JRadioButton("Male"); 
				sgenderMale.setActionCommand("Male");
				JRadioButton sgenderFemale=new JRadioButton("Female");       
				sgenderFemale.setActionCommand("Female");
				ButtonGroup sbg=new ButtonGroup();    
				sbg.add(sgenderMale);sbg.add(sgenderFemale); 
				JButton btnRegister_student=new JButton("Register");
				
				
				
				slblFirstName.setBounds(190, 130, 190, 20);
				slblFirstName.setFont(new Font("ARIAL", Font.BOLD,20));
				stxtFname.setBounds(300, 130, 340, 30);
				slblLastName.setBounds(190, 210, 190, 20);
				slblLastName.setFont(new Font("ARIAL", Font.BOLD,20));
				stxtLname.setBounds(300, 210, 340, 30);
				slblrpassword.setBounds(190, 290, 190, 20);
				slblrpassword.setFont(new Font("ARIAL", Font.BOLD,20));
				stxtrpassword.setBounds(300, 290, 340, 30);
				slblGender.setBounds(190, 370, 190, 20);
				slblGender.setFont(new Font("ARIAL", Font.BOLD,20));
				sgenderMale.setBounds(300, 370, 100, 20);
				sgenderMale.setFont(new Font("ARIAL", Font.BOLD,20));
				sgenderFemale.setBounds(400, 370, 100, 20);
				sgenderFemale.setFont(new Font("ARIAL", Font.BOLD,20));
				btnRegister_student.setBounds(300, 450, 190, 30);
				
				
				
				
				Add_student_panel.add(btnRegister_student);
				Add_student_panel.add(sgenderFemale);
				Add_student_panel.add(sgenderMale);
				Add_student_panel.add(stxtrpassword);
				Add_student_panel.add(stxtLname);
				Add_student_panel.add(stxtFname);
				Add_student_panel.add(slblGender);
				Add_student_panel.add(slblrpassword);
				Add_student_panel.add(slblLastName);
				Add_student_panel.add(slblFirstName);
			
			
				//code for student panel ends here
				
				
				
				//creating buttons and labels again for accountant
				
				JLabel alblFirstName,alblLastName,alblrpassword,alblGender;
				alblFirstName=new JLabel("First Name");
				alblLastName=new JLabel("Last Name");
				alblrpassword=new JLabel("Password");
				alblGender=new JLabel("Gender");
				
				
				JTextField atxtFname,atxtLname,atxtrpassword;
				atxtFname=new JTextField();
				atxtLname=new JTextField();
				atxtrpassword=new JTextField();
				
				
				
				JRadioButton agenderMale=new JRadioButton("Male"); 
				agenderMale.setActionCommand("Male");
				JRadioButton agenderFemale=new JRadioButton("Female");
				agenderFemale.setActionCommand("Female");
				ButtonGroup abg=new ButtonGroup();    
				abg.add(agenderMale);sbg.add(agenderFemale); 
				JButton btnRegister_accountant=new JButton("Register");
				
				
				
				alblFirstName.setBounds(190, 130, 190, 20);
				alblFirstName.setFont(new Font("ARIAL", Font.BOLD,20));
				atxtFname.setBounds(300, 130, 340, 30);
				alblLastName.setBounds(190, 210, 190, 20);
				alblLastName.setFont(new Font("ARIAL", Font.BOLD,20));
				atxtLname.setBounds(300, 210, 340, 30);
				alblrpassword.setBounds(190, 290, 190, 20);
				alblrpassword.setFont(new Font("ARIAL", Font.BOLD,20));
				atxtrpassword.setBounds(300, 290, 340, 30);
				alblGender.setBounds(190, 370, 190, 20);
				alblGender.setFont(new Font("ARIAL", Font.BOLD,20));
				agenderMale.setBounds(300, 370, 100, 20);
				agenderMale.setFont(new Font("ARIAL", Font.BOLD,20));
				agenderFemale.setBounds(400, 370, 100, 20);
				agenderFemale.setFont(new Font("ARIAL", Font.BOLD,20));
				btnRegister_accountant.setBounds(300, 450, 190, 30);
				
				
				
				
				Add_account_panel.add(btnRegister_accountant);
				Add_account_panel.add(agenderFemale);
				Add_account_panel.add(agenderMale);
				Add_account_panel.add(atxtrpassword);
				Add_account_panel.add(atxtLname);
				Add_account_panel.add(atxtFname);
				Add_account_panel.add(alblGender);
				Add_account_panel.add(alblrpassword);
				Add_account_panel.add(alblLastName);
				Add_account_panel.add(alblFirstName);
			
			
				//code for accountant panel ends here
				
				userFrame.setVisible(true);
				
				
				
				//ending of add faculty panel
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Approval_panel.setVisible(true);
				Add_faculty_panel.setVisible(false);
				Add_student_panel.setVisible(false);
				Add_account_panel.setVisible(false);
			}
		});
		
		
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Approval_panel.setVisible(false);
				Add_faculty_panel.setVisible(true);
				Add_student_panel.setVisible(false);
				Add_account_panel.setVisible(false);
			}
		});
		
		
		
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Approval_panel.setVisible(false);
				Add_faculty_panel.setVisible(false);
				Add_student_panel.setVisible(true);
				Add_account_panel.setVisible(false);
			}
		});
		
		
		
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				Approval_panel.setVisible(false);
				Add_faculty_panel.setVisible(false);
				Add_student_panel.setVisible(false);
				Add_account_panel.setVisible(true);
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.f.setVisible(true);
				userFrame.setVisible(false);
				
			}
		});
		
		btnApprove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String username=txtApprove.getText();
				PreparedStatement ps;
				try {
					
					String fname=null;
					String lname=null;
					String uname=null;
					String password=null;
					String rid=null;
					String gender=null;
					String role="Student";
					
					
					ps = con.prepareStatement("select * from register where username=?");
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
					fname = rs.getString(1);
					lname = rs.getString(2);
					uname = rs.getString(3);
					password = rs.getString(4);
					rid=rs.getString(5);
					gender=rs.getString(6);
					}
					ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, uname);
					ps.setString(4, password);
					ps.setString(5, rid);
					ps.setString(6, gender);
					ps.executeUpdate();
					
					if(rid.equals(role))
					{
					ps = con.prepareStatement("insert into fee values(?,0,0,0)");
					ps.setString(1, uname);
					ps.executeUpdate();
					ps = con.prepareStatement("insert into marks values(?,0,0,0,0)");
					ps.setString(1, uname);
					ps.executeUpdate();
					}
					ps=con.prepareStatement("delete from register where username=?");
					ps.setString(1, username);
					ps.executeUpdate();
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
						PreparedStatement ps1 = con.prepareStatement("select * from register");
						ResultSet rs1 = ps1.executeQuery();
						model.setRowCount(0);
						while(rs1.next())
						{
						fname = rs1.getString(1);
						lname = rs1.getString(2);
						uname = rs1.getString(3);
						password = rs1.getString(4);
						rid=rs1.getString(5);
						gender=rs1.getString(6);
						model.addRow(new Object[]{fname, lname, uname, password, rid, gender});
						}
					} catch (ClassNotFoundException e1) {
					} 
				
						Approval_panel.repaint();
					
				} catch (SQLException e1) {	
				}
				
				
				
				
			}
		});
		
		btnRegister_faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname,lname,username,password,gender;
				fname=txtFname.getText();
				lname=txtLname.getText();
				password=txtrpassword.getText();
				gender=bg.getSelection().getActionCommand();
				username=fname.substring(0, 1);
				Random random=new Random();
				String r=new String();
				r=Integer.toString(Math.abs(random.nextInt()));
				r=r.substring(0, 6);
				username=username + r + lname ;
				username=username.toLowerCase();
				PreparedStatement ps;
				try {
					ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, username);
					ps.setString(4, password);
					ps.setString(5, "Faculty");
					ps.setString(6, gender);
					ps.executeUpdate();					
				} catch (SQLException e1) {	
				}
			}
		});
		
		
		btnRegister_accountant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname,lname,username,password,gender;
				fname=atxtFname.getText();
				lname=atxtLname.getText();
				password=atxtrpassword.getText();
				gender=abg.getSelection().getActionCommand();
				username=fname.substring(0, 1);
				Random random=new Random();
				String r=new String();
				r=Integer.toString(Math.abs(random.nextInt()));
				r=r.substring(0, 6);
				username=username + r + lname ;
				username=username.toLowerCase();
				PreparedStatement ps;
				try {
					ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, username);
					ps.setString(4, password);
					ps.setString(5, "Accountant");
					ps.setString(6, gender);
					ps.executeUpdate();					
				} catch (SQLException e1) {	
				}
			}
		});
		
		
		btnRegister_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname,lname,username,password,gender;
				fname=stxtFname.getText();
				lname=stxtLname.getText();
				password=stxtrpassword.getText();
				gender=sbg.getSelection().getActionCommand();
				username=fname.substring(0, 1);
				Random random=new Random();
				String r=new String();
				r=Integer.toString(Math.abs(random.nextInt()));
				r=r.substring(0, 6);
				username=username + r + lname ;
				username=username.toLowerCase();
				PreparedStatement ps;
				try {
					ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, username);
					ps.setString(4, password);
					ps.setString(5, "Student");
					ps.setString(6, gender);
					ps.executeUpdate();		
					
					ps = con.prepareStatement("insert into fee values(?,0,0,0)");
					ps.setString(1, username);
					ps.executeUpdate();
					
					ps = con.prepareStatement("insert into marks values(?,0,0,0,0)");
					ps.setString(1, username);
					ps.executeUpdate();
				
					
				} catch (SQLException e1) {	
				}
			}
		});
		
		
		
	}


	
	

}

