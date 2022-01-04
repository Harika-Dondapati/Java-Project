import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class LogInPage extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i=0;
	JFrame frame;
	JPanel panel1,panel2,fpanal,testpaJPanel;
	JTextField uiField;
	JPasswordField pwField;
	JLabel uiJLabel,pwJLabel,temp1JLabel,temp2JLabel;
	JButton suButton,twButton;
	JRadioButton r1,r2,r3;
	public LogInPage(JFrame lf) 
	{
		
		frame=lf;
		fpanal=new JPanel();
		fpanal.setBounds(0,0,500,300);
		fpanal.setBackground(new Color(161,27,192));
		
		uiJLabel=new JLabel("User Name: ");
		uiField=new JTextField();
		uiJLabel.setBounds(100,50,75,20); //100,50,75,20
		uiField.setBounds(175,50,150,20);
		uiJLabel.setForeground(Color.white);
		
		pwJLabel=new JLabel("Password: ");
		pwField=new JPasswordField();
		pwJLabel.setBounds(100,100,75,20);
		pwField.setBounds(175,100,150,20);
		pwJLabel.setForeground(Color.white);
		
		temp1JLabel=new JLabel("Guest User need not to sign in just Login.");
		temp1JLabel.setBounds(120,125,250,20);
		temp1JLabel.setForeground(Color.white);
		
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
		r1.setBackground(new Color(64,64,64).darker());
		r2.setBackground(new Color(64,64,64).darker());
		r3.setBackground(new Color(64,64,64).darker());
		r1.setForeground(Color.white);
		r2.setForeground(Color.white);
		r3.setForeground(Color.white);
		
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
						    AdminPage l=new AdminPage(f);
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
							ManagerPage l = null;
							l = new ManagerPage(f);
							f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							f.add(l); 
							f.setSize(500,400);
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
				    
				    JFrame uf = new JFrame("User Page");
				    UserPage u=new UserPage(uf);
				    uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    uf.add(u);
				    uf.setSize(500, 400);
				    uf.setLocationRelativeTo(null);
				    uf.setVisible(true);
				    
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
		
		twButton=new JButton("White Theme");
		twButton.setBounds(350,30,125,20);	
		twButton.setVisible(true);
		twButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					lf.dispose();
				 	JFrame f1 = new JFrame("Login in page");
				    LogInPageWT lw=new LogInPageWT(f1);
				    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    f1.add(lw); 
				    f1.setSize(500, 400);
				    f1.setLocationRelativeTo(null);
				    f1.setVisible(true);
				
			
			}
		});
	
		animi();
		add(uiJLabel);add(uiField);add(pwJLabel);add(pwField);add(suButton);
		add(r1);add(r2);add(r3);add(temp1JLabel);add(temp2JLabel);
		add(panel1);add(panel2);add(twButton);
		 
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
	public void animi()
	{
		JTextField label=new JTextField("Don’t waste food.");
		label.setBounds(0,0,500,20);
		label.setBackground(new Color(153,0,76));
		label.setForeground(Color.white);
	
		add(label);
	
		Timer timer = new Timer(5000, event -> {
            label.setText("Take only what you can eat.");
        });
        Timer timer1 = new Timer(10000, event -> {
            label.setText(" Taste your food, but do not waste your food.");
        });
        Timer timer2 = new Timer(15000, event -> {
            label.setText(" Wasting food today will lead to a food shortage tomorrow.");
        });
        Timer timer3 = new Timer(20000, event -> {
            label.setText(" Eat to live; don’t live to eat.");
        });
        Timer timer4 = new Timer(25000, event -> {
            label.setText(" Today’s wastage is tomorrow’s shortage.");
        });
        timer.start();
        timer1.start();
        timer2.start();
        timer3.start();
        timer4.start();
        
        timer.setRepeats(false);
        timer1.setRepeats(false);
        timer2.setRepeats(false);
        timer3.setRepeats(false);
        timer4.setRepeats(false);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(new Color(64,64,64).darker());
		this.setForeground(Color.white);	     
		uiField.setBorder(null);
		pwField.setBorder(null);
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
