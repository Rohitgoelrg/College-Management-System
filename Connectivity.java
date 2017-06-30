import java.sql.*;


class Connectivity{
	Connection con;
	Statement st;
	
	void connection()
	{
       try{     
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","shashank");
		}
		catch(SQLException e)
		{
		}
		catch(ClassNotFoundException e)
		{ 
		}
		
	}
	
	public void loginVerification(String lusername,String lpassword){
		      
		     lusername=lusername.toLowerCase();
		     String password=null;
		try{
			PreparedStatement st= con.prepareStatement("select * from student where NAME=?");
			st.setString(1, lusername);
			ResultSet rs=st.executeQuery();   
			
			while(rs.next())
			{
				
				password=rs.getString(3);
				
			}
			
			if(lpassword.equals(password))
			{
				System.out.println("Successful");
				Userpage uo=new Userpage();
				Logintest.f.setVisible(false);
				uo.user();
				
			}
			else{
				System.out.println("Failed");
			}
			
		}
		catch(SQLException e){
			//System.out.println(e);
			}
		
	}
}
