import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;


import javax.swing.*;

public class LogInPageWT extends JPanel implements ActionListener
{
	int c=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel1,panel2,fpanal,testpaJPanel;
	JTextField uiField;
	JPasswordField pwField;
	JLabel uiJLabel,pwJLabel,temp1JLabel,temp2JLabel;
	JButton suButton,twButton,tdButton;
	JRadioButton r1,r2,r3;
	public LogInPageWT(JFrame lf) 
	{
		frame=new JFrame();
		frame.setTitle("Login Page");
		fpanal=new JPanel();
		fpanal.setBounds(0,0,500,300);
		fpanal.setBackground(new Color(161,27,192));
		
		uiJLabel=new JLabel("User Name: ");
		uiField=new JTextField();
		uiJLabel.setBounds(100,50,75,20);
		uiField.setBounds(175,50,150,20);
		//uiJLabel.setForeground(Color.white);
		
		pwJLabel=new JLabel("Password: ");
		pwField=new JPasswordField();
		pwJLabel.setBounds(100,100,75,20);
		pwField.setBounds(175,100,150,20);
		//pwJLabel.setForeground(Color.white);
		
		temp1JLabel=new JLabel("Guest User need not to sign in just Login.");
		temp1JLabel.setBounds(120,125,250,20);
		//temp1JLabel.setForeground(Color.white);
		
		panel1=new JPanel();
		panel1.setBounds(100,125,265,20);
		panel1.setBackground(new Color(161,27,192));
		panel1.add(temp1JLabel);
		
		temp2JLabel=new JLabel("Select any option");
		temp2JLabel.setVisible(false);
		temp2JLabel.setBounds(200,230,150,20);
		temp2JLabel.setForeground(Color.white);
		
		panel2=new JPanel();
		panel2.setBounds(150,230,200,20);
		panel2.setBackground(new Color(238,15,15));
		//setBackground(new Color(64,64,64).darker());
				//new Color(238,15,15));
		panel2.setVisible(false);
		panel2.add(temp2JLabel);
		
		r1=new JRadioButton("Admin");
		r1.setBounds(100,150,75,20);
		r2=new JRadioButton("Manager");
		r2.setBounds(175,150,75,20);
		r3=new JRadioButton("Guest User");
		r3.setBounds(250,150,100,20);
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(r1);bGroup.add(r2);bGroup.add(r3);
		
		
		suButton=new JButton("Login");
		suButton.setBounds(175,200,150,20);
		suButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				if(r1.isSelected())
				{
					String u="admin";
					String p="root";
					temp2JLabel.setVisible(false);
					panel2.setVisible(false);
					if(u.equals(uiField.getText()) && p.equals(new String(pwField.getPassword())))
					{
						    lf.dispose();
						    
						    JFrame f = new JFrame("Admin Page");
						    AdminPageWT l=new AdminPageWT(f);
						    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    f.add(l); 
						    f.setSize(400, 300);
						    f.setLocationRelativeTo(null);
						    f.setVisible(true);
						//frame.dispose();
						//new AdminPage(lf);
					}
					else 
					{
						if(!(u.equals(uiField.getText()) || p.equals(new String(pwField.getPassword()))))
						{
							JOptionPane.showMessageDialog(frame, "Invalid User Name and Password");
						}
					    else if(!(u.equals(uiField.getText()))) 
						{
							JOptionPane.showMessageDialog(frame, "Invalid User Name");
						}
						else if(!(p.equals(new String(pwField.getPassword()))))
						{
							JOptionPane.showMessageDialog(frame, "Invalid Password");
						}
					}
						
				}
				else if(r2.isSelected())
				{
					
					String u="manager";
					String p="root";
					temp2JLabel.setVisible(false);
					panel2.setVisible(false);
					if(u.equals(uiField.getText()) && p.equals(new String(pwField.getPassword())))
					{
						try 
						{
							lf.dispose();
							JFrame f = new JFrame("Manager Page");
						    ManagerPageWT l=new ManagerPageWT(f);
						    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    f.add(l); 
						    f.setSize(500, 400);
						    f.setLocationRelativeTo(null);
						    f.setVisible(true);
						} 
						catch (IOException e1) {e1.printStackTrace();}
					}
					else 
					{
						if(!(u.equals(uiField.getText()) || p.equals(new String(pwField.getPassword()))))
						{
							JOptionPane.showMessageDialog(frame, "Invalid User Name and Password");
						}
					    else if(!(u.equals(uiField.getText()))) 
						{
							JOptionPane.showMessageDialog(frame, "Invalid User Name");
						}
						else if(!(p.equals(new String(pwField.getPassword()))))
						{
							JOptionPane.showMessageDialog(frame, "Invalid Password");
						}
					}
				}
				else if(r3.isSelected())
				{
				
				    lf.dispose();
				    
				    JFrame ufw = new JFrame("User Page");
				    UserPageWT u=new UserPageWT(ufw);
				    ufw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    ufw.add(u);
				    ufw.setSize(500, 400);
				    ufw.setLocationRelativeTo(null);
				    ufw.setVisible(true);
				    
					//new UserPage(lf);
					temp2JLabel.setVisible(false);
					panel2.setVisible(false);
				}
				else 
				{
					panel2.setVisible(true);
					temp2JLabel.setVisible(true);
				}
			}
		});
		
		
		tdButton=new JButton("Dark Theme");
		tdButton.setBounds(350,10,125,20);	
		tdButton.setVisible(true);
	   	tdButton.addActionListener(new ActionListener() 
	   	{
			public void actionPerformed(ActionEvent e) 
			{
				lf.dispose();
				JFrame f = new JFrame("Login in page");
			    LogInPage l=new LogInPage(f);
			    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    f.add(l); 
			    f.setSize(500, 400);
			    f.setLocationRelativeTo(null);
			    f.setVisible(true);
				
			}
		});
	
		
	
		
		add(uiJLabel);add(uiField);add(pwJLabel);add(pwField);add(suButton);
		add(r1);add(r2);add(r3);add(temp1JLabel);add(temp2JLabel);
		add(panel1);add(panel2);add(tdButton);
		
		setLocation(750, 350);
		setSize(500,400);
		setLayout(null);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g)
	{
		twButton=new JButton("White Theam");
		twButton.setBounds(350,10,125,20);	
		twButton.setVisible(true);
		twButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			
				 JFrame f = new JFrame("Login in page");
				    LogInPage l=new LogInPage(f);
				    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				     f.add(l);
				     
				     f.setSize(500, 400);
				     f.setLocationRelativeTo(null);
				     f.setVisible(true);
				     f.setBackground(Color.white);
			
			}
		});
		add(tdButton);
		super.paintComponent(g);
		this.setForeground(Color.black);	  
	}
public static void main(String[] args) 
{
    JFrame f = new JFrame("Login in page");
    LogInPage l=new LogInPage(f);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(l); 
    f.setSize(500, 400);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
}

}
