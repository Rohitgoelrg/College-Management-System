import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


class Accountant  {
	
	
	
	
	Accountant(String lusername) throws ClassNotFoundException, SQLException{

		JFrame userFrame=new JFrame("Accountant");
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
		
		//adding buttons in userpanel
		
		JButton btn1=new JButton("Student Fee");
		btn1.setBounds(20, 80, 140, 20);
		btnPanel.add(btn1);
		
		JButton btnLogout=new JButton("Logout");
		btnLogout.setBounds(20, 240, 140, 20);	
		btnPanel.add(btnLogout);
		
		
		JPanel feePanel=new JPanel();
		feePanel.setBounds(230, 10, 1110,568);
		feePanel.setBackground(Color.MAGENTA);
		
		JLabel lblStudentUsername=new JLabel("Enter Username of Student");
		JTextField txtStudentUsername=new JTextField();
		JButton btnSearch=new JButton("Search");
		JLabel lblTotalFee=new JLabel("Total Fee");
		JTextField txtTotalFee=new JTextField();
		JLabel lblFeeSubmit=new JLabel("Enter Fee to submit");
		JTextField txtFeeSubmit=new JTextField();
		JButton btnSubmitFee=new JButton("Submit");
		JLabel lblRemainingFee=new JLabel();
		JLabel lblFeeSubmitted=new JLabel();
		
		lblStudentUsername.setBounds(50, 50, 260, 20);
		lblStudentUsername.setFont(new Font("ARIAL",Font.BOLD,20));
		txtStudentUsername.setBounds(320, 50, 200, 20);
		btnSearch.setBounds(530, 50, 100, 20);
		lblTotalFee.setBounds(50, 100, 260, 20);
		lblTotalFee.setFont(new Font("ARIAL",Font.BOLD,20));
		txtTotalFee.setBounds(320, 100, 200, 20);
		lblFeeSubmit.setBounds(50, 150, 260, 20);
		lblFeeSubmit.setFont(new Font("ARIAL",Font.BOLD,20));
		txtFeeSubmit.setBounds(320, 150, 200, 20);
		btnSubmitFee.setBounds(150, 200, 100, 20);
		lblRemainingFee.setBounds(120, 250, 300, 20);
		lblRemainingFee.setFont(new Font("ARIAL",Font.BOLD,20));
		lblFeeSubmitted.setBounds(120, 300, 300, 20);
		lblFeeSubmitted.setFont(new Font("ARIAL",Font.BOLD,20));
		
		feePanel.add(lblStudentUsername);
		feePanel.add(txtStudentUsername);
		feePanel.add(btnSearch);
		feePanel.add(lblTotalFee);
		feePanel.add(txtTotalFee);
		feePanel.add(lblFeeSubmit);
		feePanel.add(txtFeeSubmit);
		feePanel.add(btnSubmitFee);
		feePanel.add(lblRemainingFee);
		feePanel.add(lblFeeSubmitted);
		feePanel.setLayout(null);
		backuser.add(feePanel);
		
		userFrame.setVisible(true);
		
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				feePanel.setVisible(true);
				
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.f.setVisible(true);
				userFrame.setVisible(false);
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connectivity co=new Connectivity();
				co.connection();
				String username;
				username=txtStudentUsername.getText().toLowerCase();
				try {
					PreparedStatement ps=co.con.prepareStatement("Select * from fee where Username=?");
					ps.setString(1, username);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					
					txtTotalFee.setText(rs.getString(3));
					lblRemainingFee.setText("Remaining fees is "+rs.getString(4));
					lblFeeSubmitted.setText("Fee submitted "+rs.getString(2));
					}
				} catch (SQLException e1) {
				}
				
			}
		});
		
		
		btnSubmitFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connectivity co=new Connectivity();
				co.connection();
				int submitted=0,submit=0,remaining=0,total=0;
				
				String username;
				username=txtStudentUsername.getText().toLowerCase();
				try {
					PreparedStatement ps=co.con.prepareStatement("Select * from fee where Username=?");
					ps.setString(1, username);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
					total=Integer.parseInt(txtTotalFee.getText());
					remaining=Integer.parseInt(rs.getString(4));
					submitted=Integer.parseInt(rs.getString(2));
					submit=Integer.parseInt(txtFeeSubmit.getText());
					}
					submitted=submitted+submit;
					remaining=total-submitted;
					
					PreparedStatement ps2=co.con.prepareStatement("update fee set Submitted_fee=?, Total_fee=?, Remaining_fee=? where Username=?");
				    ps2.setString(1, Integer.toString(submitted));
				    ps2.setString(2, Integer.toString(total));
				    ps2.setString(3, Integer.toString(remaining));
				    ps2.setString(4, username);
				    ps2.executeUpdate();
					
				    feePanel.remove(lblRemainingFee);
				    feePanel.remove(lblFeeSubmitted);
				    txtFeeSubmit.setText("0");
				    lblRemainingFee.setText("Remaining fees is "+ remaining);
					lblFeeSubmitted.setText("Fee submitted "+ submitted);
					feePanel.add(lblRemainingFee);
					feePanel.add(lblFeeSubmitted);
					feePanel.repaint();
				    
				} catch (SQLException e1) {
				}
				
			}
		});
		
	}
	
	

}

