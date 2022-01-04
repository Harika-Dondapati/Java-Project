import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class UserPageWT extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame uFrame;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	
	public UserPageWT(JFrame uf) 
	{
		JPanel panel = new JPanel();  
	    panel.setLayout(new FlowLayout()); 
		uFrame=new JFrame();
		uFrame.setTitle("User Page");
		
		l1=new JLabel("Name:");
		t1=new JTextField();
		l1.setBounds(25,20,50,20);
		t1.setBounds(100,20,125,20);
		
		l2=new JLabel("Type of Food:");
		t2=new JTextField();
		l2.setBounds(230,20,150,20);
		t2.setBounds(330,20,150,20);
		
		l3=new JLabel("Phone No:");
		t3=new JTextField();
		l3.setBounds(25,60,75,20);
		t3.setBounds(100,60,125,20);
		
		l4=new JLabel("Quantity of Food:");
		t4=new JTextField();
		l4.setBounds(230,60,150,20);
		t4.setBounds(330,60,150,20);
		
		l5=new JLabel("Email:");  
		t5=new JTextField();
		l5.setBounds(25,100,50,20);
		t5.setBounds(100,100,125,20);
		
		l6=new JLabel("Level of Hygine:");
		t6=new JTextField();
		l6.setBounds(230,100,150,20);
		t6.setBounds(330,100,150,20);
		
		l7=new JLabel("Address:");
		t7=new JTextField();
		l7.setBounds(25,150,150,20);
		t7.setBounds(100,150,300,50);
		
		b1=new JButton("Submit");
		b2=new JButton("Logout");
		b1.setBounds(125,250,100,20);
		b2.setBounds(300,250,100,20);
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(uFrame,"Sure? You want to Submit?", "Conformation",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION)
			            {
			            	submit();
			            	JOptionPane.showMessageDialog(uFrame,"your resopnse has been submited");
			            	uf.dispose();
			            	JFrame f = new JFrame("Login in page");
			            	LogInPageWT l=new LogInPageWT(f);
			            	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            	f.add(l); 
			            	f.setSize(500, 400);
			            	f.setLocationRelativeTo(null);
			            	f.setVisible(true);		            	
			            }
			}
		});
		b2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				uf.dispose();
				 JFrame f = new JFrame("Login in page");
				    LogInPageWT l=new LogInPageWT(f);
				    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    f.add(l); 
				    f.setSize(500, 400);
				    f.setLocationRelativeTo(null);
				    f.setVisible(true);
				
			}
		});
		
		add(l1);add(t1);add(l2);add(t2);add(l3);add(t3);add(l4);add(t4);
		add(l5);add(t5);add(l6);add(t6);add(l7);add(t7);add(b1);add(b2);
		
		//setLocation(750, 350);
		//setSize(500, 400);
		setLayout(null);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void submit()
	{
		String tempString="";
		if(tempString.equals(t1.getText()))
			System.exit(0);
		String[] st=new String[8];
		st[0]=t1.getText();
		st[1]=t2.getText();
		st[2]=t3.getText();
		st[3]=t4.getText();
		st[4]=t5.getText();
		st[5]=t6.getText();
		st[6]=t7.getText();
		try 
		{
			FileWriter fw = new FileWriter("Details.txt",true);
			for(int i=0;i<7;i++)
			{
				fw.append(st[i]);
				fw.append("\n");
			}
			fw.append("0");
			fw.append("\n");
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
		
	}
	public void paintComponent(Graphics g)
	{
		
		    super.paintComponent(g);
	       this.setBackground(Color.white);
	       this.setForeground(Color.white);
	       g.drawLine(0, 0, 100, 100);
	       
	       
	}
	/*
	public static void main(String[] args) {
		new UserPage();
	}
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
