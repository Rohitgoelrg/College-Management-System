import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Logintest{

	static JFrame f;
	JPanel home,about,login,information,contact,footer;
	
	String lusername,lpassword;
	
	//content for slideshow
		JLabel pic;
		Timer tm;
		int x=0;
		
		String[] list={
				
				"C:/Users/SHASHANK SINGH/Desktop/CMS1.jpg",
				"C:/Users/SHASHANK SINGH/Desktop/CMS2.jpg"
		};
		
	 //slideshow content end
	
	public static void main(String[] args) {
		
		new Logintest();

	}
	
	

	Logintest()
	{
		
		//To get screen size start
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				screenSize.getHeight();
				screenSize.getWidth();
				int screenHeight = screenSize.height;
				screenHeight=screenHeight-50;
				int screenWidth = screenSize.width;
		//To get screen size end
				
		f=new JFrame("College Management System");
		JLabel lblHeading=new JLabel("College Management System");
		lblHeading.setFont(new Font("ARIAL", Font.BOLD,40));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(0, 10, screenWidth, 70);
		f.add(lblHeading);
		
		//Buttons Design start
		
		int btnWidth=(screenWidth-120)/4;
		
		JButton b1=new JButton("About Us");
		b1.setFont(new Font("ARIAL", Font.BOLD, 20));
		b1.setBounds(50, 80, btnWidth, 40);
		
		JButton b2=new JButton("Login");
		b2.setFont(new Font("ARIAL", Font.BOLD, 20));
		b2.setBounds(50+btnWidth, 80, btnWidth, 40);
		
		JButton b3=new JButton("Information Broucher");
		b3.setFont(new Font("ARIAL", Font.BOLD, 20));
		b3.setBounds(50+2*btnWidth, 80, btnWidth, 40);
		
		JButton b4=new JButton("Contact us");
		b4.setFont(new Font("ARIAL", Font.BOLD, 20));
		b4.setBounds(50+3*btnWidth, 80, btnWidth, 40);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		//Buttons Design end
		
		//Home panel design Start
		home=new JPanel();
		home.setBounds(50, 130, screenWidth-120, screenHeight-300);
		home.setBackground(Color.BLUE);
		home.setLayout(null);
		
		// slideshow code start
		
				pic=new JLabel();
				pic.setBounds(0, 0, screenWidth-120, screenHeight-300);
				SETImageSize(1);
				
				tm=new Timer(2000,new ActionListener(){
					
					
					public void actionPerformed(ActionEvent e){
						
						SETImageSize(x);
						x+=1;
						if(x>=list.length)
							x=0;
					}
					
				});		
				home.add(pic);
				tm.start();
				f.setLocationRelativeTo(null);
			    pic.setVisible(true);
				
		//slideshow code end
			    
		//Home panel design end
		
		//About panel design start
		
			    about=new JPanel();
				about.setBounds(50, 130, screenWidth-120, screenHeight-300);
				about.setVisible(false);
				about.setBackground(Color.cyan);
				about.setLayout(new GridBagLayout());   

				int nr=(screenWidth-120)/23;
				int nc=(screenHeight-300)/12+50;
		        JTextArea txtArea=new JTextArea(32,147);
				txtArea.setText( "ABOUT US"


		+"Learn through Academics & beyond. Build Strong Virtues.Think Independently. Get Placed."
		+ "Being ranked 99th by National Institutional Ranking Framework, MHRD, Govt. of India; Noida Institute of Engineering & Technology, "
		+ "Greater Noida is one of the India's elite Engineering & Management Institutes. "
		+ "A self-financed Institute with a sprawling area of 16.9 acres of lush green campus, NIET is developing as a Centre of Excellence,"
		+ " imparting technical education and generating competent professionals with a high degree of credibility, integrity and "
		+ "ethical standards."
		+"We are thought leaders with an unquenchable thirst for learning and a devotion to world class research and teaching. "
		+ "The Institute excels in all the parameters earmarked by the AICTE and Dr. A.P.J. Abdul Kalam Technical University, Lucknow."
		+ "VISION STATEMENT"

		+"To be an institute of academic excellence in the field of education, with the future plan of becoming a deemed university, earn name & hence win the faith of the society."

		+"MISSION STATEMENT"

		+"To impart to its students high quality education, develop their skills, broaden their mental horizon, and nurture them into competent & talented professionals to meet the challenges of the new millennium."

		+"QUALITY POLICY"

		+"Our policy is to develop a class of highly skilled professionals who can cater to intellectually and technologically changing environments. This is achieved through the participative efforts of the management, staff, students and parents."


		+"ABOUT INSTITUTE"


		 +"NIET is one of the premier Engineering and Management institutes of India's National Capital Region (NCR). It was established by eminent visionaries, responsible for setting up City Educational & Social Welfare Society of Meerut, with a Vision to provide value driven education of global dimensions. The Institute is managed by City Educational & Social Welfare Society, which runs several prestigious education and health organizations, viz. NIET (Noida Institute of Engineering & Technology), MIET (Meerut Institute of Engineering & Technology), CVPS (City Vocational Public School), ACTS C- DAC, Pyramid Finishing School, Dayanand Nursing Home, Chandra Sen Charitable Hospital & Om Diagnostic Center. Noida Institute of Engineering and Technology, a self financed institute, offering high standard quality education to students from all corners of the country, is situated in Greater Noida (a hub of global MNCs.). The institute has a sprawling area of 13.90 acres and lush green ambiance all around. It is developing as the Center of Excellence imparting technical education and generating competent professionals with a high degree of credibility, integrity and ethical standards. We aim at recognizing, respecting and nurturing the creative potential of each student."



		+"NIET IN FOCUS" 

		+"Career Starts Here" +"Education at NIET is focused on equipping students with the critical skills they need to acquire in today's globalized world. Whether they choose to be entrepreneurs or build careers with leading organizations, their span at NIET gets them started on the way to their goals. That's why we say career Starts here. What truly sets NIET apart? Our unique 360 degree approach that builds synergy between education and industry and ensures that our programs are completely in sync with the contemporary, economic context." 
		+"At NIET, students get an environment that opens up a new world of opportunities, helps them to make the right choices and ensure that they are ready to start out on their own. They also benefit from a strong, global, alumni network. That's why we say that young people who come to NIET leave with much more than a degree- They take with them a valuable asset that they can count on, all their lives." 


		+"At NIET, fires are ignited every day, by the hour. The life and blood of NIET is its faculty base. The faculty is undoubtedly the nucleus around which the entire gamut of training activities revolves. Our faculty is dedicated to an integrated curriculum with a global focus, team teaching and leadership woven seamlessly. Inputs from students and corporate executives, along with the faculty experience are a sound marriage of ideas and impact. Innovative research, real world experience and effective teaching come together and create a storm of intense thought process." 

		+"What is also admirable at NIET is the vibrant interaction among the faculty and students, creating a healthy learning experience inspiring out-of-the-box thinking and honing sharp intellect. These interactions foster an entrepreneurial mind-set focused on identifying and capturing opportunity; the stuff of which leaders are made.");

				
		JScrollPane scroll = new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
		txtArea.setFont(new Font("Serif", Font.ITALIC, 16));
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setEditable(false); // set textArea non-editable

		scroll.setBounds(screenWidth-155,10,15, screenHeight-320);  

		about.add(scroll);
		txtArea.setVisible(true);
		//About panel design end
		
		
		//Login panel design start
		login=new JPanel();
		login.setBounds(50, 130, screenWidth-120, screenHeight-300);
		login.setVisible(false);
		login.setBackground(Color.DARK_GRAY);
		JPanel nlogin=new JPanel();
		JButton btnlogin=new JButton("Login");
		btnlogin.setBounds(400, 230, 80, 30);
		int nloginsx=(50+screenWidth-120)/2-(50+screenWidth-120)/4; //Start X
		int nloginsy=(130+screenHeight-300)/2-(130+screenHeight-300)/4; //Start Y
		int nloginex=(50+screenWidth-180)/2; //End X
		int nloginey=(130+screenHeight-300)/2; //End Y
		nlogin.setBounds(nloginsx, nloginsy, nloginex, nloginey);
		nlogin.setBackground(Color.LIGHT_GRAY);
		JLabel userName=new JLabel("Username");
		userName.setBounds(190, 110, 190, 20);
		userName.setFont(new Font("ARIAL", Font.BOLD,20));
		JLabel password=new JLabel("Password");
		password.setBounds(190, 180, 190, 20);
		password.setFont(new Font("ARIAL", Font.BOLD,20));
		JTextField tbUserName=new JTextField();
		tbUserName.setBounds(300, 100, 340, 35);
		JPasswordField tbpassword=new JPasswordField();
		tbpassword.setBounds(300, 170, 340, 35);
		nlogin.add(userName);
		nlogin.add(tbUserName);
		nlogin.add(password);
		nlogin.add(tbpassword);
		nlogin.add(btnlogin);
		nlogin.setLayout(null);
		login.add(nlogin);
		login.setLayout(null);
		//Login panel design end
		
		//Information panel design start
				information=new JPanel();
				information.setBounds(50, 130, screenWidth-120, screenHeight-300);
				information.setVisible(false);
				information.setBackground(Color.MAGENTA);
				JLabel lblinfo=new JLabel("Info us will be here");
				lblinfo.setBounds(50, -50, 400, 250);
				information.add(lblinfo);
				information.setLayout(null);
		//Information panel design end
				
		//Contact panel design start
				contact=new JPanel();
				contact.setBounds(50, 130, screenWidth-120, screenHeight-300);
				contact.setVisible(false);
				contact.setBackground(Color.WHITE);
				JLabel lblcontact=new JLabel("Contact us will be here");
				lblcontact.setBounds(50, -50, 400, 250);
				contact.add(lblcontact);
				contact.setLayout(null);
		//Contact panel design end
		
		//Footer panel design start
		footer=new JPanel();
		footer.setBounds(50 ,screenHeight-165, screenWidth-120, 100);
		JLabel lblFooter=new JLabel("Footer will be here");
		footer.setBackground(Color.GREEN);
		lblFooter.setBounds(50, 0, 400, 100);
		footer.add(lblFooter);
		footer.setLayout(null);
		//Footer panel design end
		
		
		
		
		f.add(home);
		f.add(about);
		f.add(login);
		f.add(footer);
		f.add(information);
		f.add(contact);
		f.setBounds(0, 10, screenWidth, screenHeight);
		f.setLayout(null);
		f.setVisible(true);
		
		//Button action starts here
		b1.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				about.setVisible(true);
				login.setVisible(false);
				information.setVisible(false);
				contact.setVisible(false);
			}
				});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				about.setVisible(false);
				login.setVisible(true);
				information.setVisible(false);
				contact.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				about.setVisible(false);
				login.setVisible(false);
				information.setVisible(true);
				contact.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				about.setVisible(false);
				login.setVisible(false);
				information.setVisible(false);
				contact.setVisible(true);
			}
		});
			
		
			//Login Button action start
		
				btnlogin.addActionListener(new ActionListener()
						{
					public void actionPerformed(ActionEvent e)
					{
						
						lusername=tbUserName.getText();
						lpassword=tbpassword.getText();
						Connectivity co=new Connectivity();
						co.connection();
						co.loginVerification(lusername, lpassword);
					}
						});
		
			//Login Button action end
		
		//Button action ends here
		
		
	}
	
	//slideshow action start
	
		public  void SETImageSize(int i){
			ImageIcon icon=new ImageIcon(list[i]);
			Image img=icon.getImage();
			Image newImg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
			 ImageIcon newImc = new ImageIcon(newImg);
			 pic.setIcon(newImc);
			
		}
		
		//slideshow action end
}

