import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class ManagerPage extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f1,f;
	JLabel l1,l2;
	JButton b1,b2,b3;
	JTextField t1,t2;
	JTable jt;
	
	
	int c;
	public ManagerPage(JFrame mf) throws IOException 
	{
		f1=new JFrame();
		//setTitle("Manager Page");
		
		l2=new JLabel("Orders Left:");
		l2.setBounds(75,50,75,20);
		l2.setForeground(Color.white);
		
		t1=new JTextField("No Orders");
		t1.setBounds(150,50,100,30);
		
		l1=new JLabel("Address of distributer area:");
		l1.setBounds(100,200,250,20);
		l1.setForeground(Color.white);
		
		t2=new JTextField();
		t2.setBounds(300,175,100,50);
		
		b1=new JButton("Submit");
		b1.setBounds(100,275,100,20);
		b2=new JButton("Log Out");
		b2.setBounds(300,275,100,20);
		b3=new JButton("Show the Orders");
		b3.setBounds(275,55,150,20);
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(f1,"Sure? You want to Submit?", "Conformation",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION)
			            {
			            	submit_Details();
			            	mf.dispose();
			            	JOptionPane.showMessageDialog(f1,"your resopnse has been submited");
			            	
			            	//new LogInPage(mf);	
			            	
								
								JFrame f = new JFrame("Manager Page");
								ManagerPage l;
								try {
									l = new ManagerPage(f);
									f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									f.add(l); 
									f.setSize(500,400);
									f.setLocationRelativeTo(null);
									f.setVisible(true);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
						   
			            	
			            }
			}
		});
		b2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mf.dispose();
				 JFrame f = new JFrame("Login in page");
				 LogInPage l=new LogInPage(f);
				 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 f.add(l); 
				 f.setSize(500, 400);
				 f.setLocationRelativeTo(null);
				 f.setVisible(true);
			}
		});
		b3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				details_For_Manager();
			}
		});
		
		add(t1);add(l1);add(t2);add(l2);add(b1);add(b2);add(b3);
		get_count();
		setLocation(750, 350);
		setSize(500, 400);
		setLayout(null);//it can also be null.
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//the value can also be 3.
	}
	public void get_count() throws IOException
	{
		 int lines=0;
		 String n="0";
		 BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
		 BufferedReader reader1 = new BufferedReader(new FileReader("Details.txt"));
		 while (reader.readLine() != null) lines++;
		for(int i=0;i<lines;i++)
		{
			if((i+1)%8==0)
			{
				if(n.equals(reader1.readLine())) 
					c++;
			}
			else 
				reader1.readLine();
		}
		t1.setText(String.valueOf(c));
		reader1.close();
		reader.close();
	}
	public void details_For_Manager() 
	{
		int i,lines=0,j,t1=0; 
	    try 
	    {
	    	 File myObj = new File("Details.txt");
	    	 Scanner myReader = new Scanner(myObj);
	    	 BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
	    	 while (reader.readLine() != null) lines++;
	    	 reader.close();
	    	 t1=((lines/8)-c);
	    	 System.out.print(t1);
	    	 String  file_data[][]= new String[lines/8][7];
	    	 
	         for(i=0;i<lines/8;i++)
	         {
	        	 
	        	 for(j=0;j<8;j++)
	        	 {
	        		 if(j==7){myReader.nextLine();}
	        		 else 
	        		 {
	        			if(t1==i)
	        			{
	        				 String data = myReader.nextLine();
				        	 file_data[i][j]=data;
				        	 
	        			 }
	        			else {
							myReader.nextLine();
						}
					 }
	        	 }
	        	 if(t1==i)
	        	 {
	        		 t1++;
	        	 }
	         }
	        String column[]={"Name","Item Name","Phone No","Quantity","GMail Id","Level of Hyziness","Address"};
	        jt=new JTable(file_data,column);
	        JScrollPane sp=new JScrollPane(jt);
	        
	        f = new JFrame("Table Example");
	        
	        f.add(sp);
	      
	        f.setLocation(550,150);
	        f.setSize(1000, 750);
	        f.setVisible(true);
	       
	        myReader.close(); 
	    
	    }
	    catch (Exception e) {System.out.print(e);}
	}
	public void submit_Details()
	{
		try 
		{
			int c=0;
			String temp=t2.getText();
			FileReader fr=new FileReader("Details.txt");
			
			BufferedReader br=new BufferedReader(fr);
			String st,temp1="";
			while ((st=br.readLine())!=null) 
			{
				if(st.equals("0") && c==0)
				{
					temp1+=temp;
					temp1+="\n";
					c++;
				}
				else 
				{
					temp1+=st;
					temp1+="\n";
				}	
			}
			FileWriter fw=new FileWriter("Details.txt");
			
			fw.write(temp1);
			
			System.out.println(temp1);
		fr.close();
		fw.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	/* using with files
	public void submit_Details() throws IOException
	{	
		try {
			
		
		int c=0;
		String temp=t2.getText();
		FileReader fr=new FileReader("Details.txt");
		FileWriter fw=new FileWriter("Temp.txt",true);
		BufferedReader br=new BufferedReader(fr);
		String st;
		//COPYING THIS FILE TO A TEMPORY FILE TO OVERRIDE DATA IN THE FILE.
		while ((st=br.readLine())!=null) 
		{
			if(st.equals("0") && c==0)
			{
				fw.write(temp);
				fw.append("\n");
				
				c++;
			}
			else 
			{
				fw.write(st);
				fw.append("\n");
				
			}	
		}
		
		fw.close();
		br.close();
		fr.close();
		//deletion the file to avoid
		File f=new File("Details.txt");
		f.delete();
		String st1;
		//copy from Temp to Details. 
		
		FileReader fr1=new FileReader("Temp.txt");
		FileWriter fw1=new FileWriter("Details.txt",true);
		BufferedReader br1=new BufferedReader(fr1);
		while ((st1=br1.readLine())!=null) 
		{
				fw1.write(st1);
				fw1.append("\n");
		}
		
		fw1.close();
		br1.close();
		fr1.close();
		FileReader fr3=new FileReader("Temp.txt");
		FileWriter fw3=new FileWriter("Temp.txt");
		BufferedReader br3=new BufferedReader(fr);
		String st3=null;
		//COPYING THIS FILE TO A TEMPORY FILE TO OVERRIDE DATA IN THE FILE.
		while (br.readLine()!=null) 
		{
			
			fw3.write(st3);
			
	   }
		fr3.close();
		fw3.close();
		br3.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
	}
	*/
	public void paintComponent(Graphics g)
	{
		
		
		super.paintComponent(g);
		this.setBackground(new Color(64,64,64).darker());
		this.setForeground(Color.white);	
		//g.drawLine(0, 0, 100, 100);     
	}
	/*public static void main(String[] args) throws IOException {
		JFrame tFrame=new JFrame();
		new ManagerPage(tFrame);
	}*/
	
}
