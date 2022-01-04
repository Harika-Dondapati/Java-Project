import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class AdminPage extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame aframe;
	JLabel label;
	JButton b1,b2;
	JTable jt;
	JFrame f = new JFrame("Complete Detalis");
	public AdminPage(JFrame af) 
	{
		aframe=new JFrame();
		//setTitle("Admin Page");
		
		b1=new JButton("Get the Details");
		b1.setBounds(50,100,150,20);
		b2=new JButton("Log Out");
		b2.setBounds(250,100,100,20);
		b1.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{
					try {getdata();} 
					catch (IOException e) {e.printStackTrace();}
				}
		});
		b2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				af.dispose();			
				JFrame f = new JFrame("Login in page");
				LogInPage l=new LogInPage(f);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.add(l); 
				f.setSize(500, 400);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				//  edit here     new LogInPage(af);
				
			}
		});
		
		add(b1);add(b2);
		setSize(400, 300);
		setLocation(750, 350);
		setLayout(null);//it can also be null.
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//the value can also be 3.
		
	}
	public void getdata() throws IOException
	{
	    int i,lines=0,j; 
	    try 
	    {
	    	 File myObj = new File("Details.txt");
	    	 Scanner myReader = new Scanner(myObj);
	    	 BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
	    	 while (reader.readLine() != null) lines++;
	    	 reader.close();
	    	 String  file_data[][]= new String[lines/8][8];
	         for(i=0;i<lines/8;i++)
	         {
	        	 for(j=0;j<8;j++)
	        	 {
	        		 String data = myReader.nextLine();
		        	 file_data[i][j]=data;
	        	 }
	         }
	        String column[]={"Name","Item Name","Phone No","Quantity","GMail Id","Level of Hyziness","Address","Address of Distributed"};
	        jt=new JTable(file_data,column);
	        JScrollPane sp=new JScrollPane(jt);
	        
	        f.add(sp);
	        f.setLocation(550,150);
	        f.setSize(1000, 750);
	        f.setVisible(true);

	        myReader.close(); 
	    } 
	    catch (FileNotFoundException e) 
	    {
	    	System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	
	}
	public void paintComponent(Graphics g)
	{
		
		    super.paintComponent(g);
	       this.setBackground(new Color(64,64,64).darker());
	       this.setForeground(Color.white);
	      // g.drawLine(0, 0, 100, 100);
	       
	       
	}
	/*
	public static void main(String[] args) {
		new AdminPage();
	}
	*/
}
