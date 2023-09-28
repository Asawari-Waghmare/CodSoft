import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
 public class QuizApp extends JFrame implements ActionListener
{     
    JRadioButton jb[]=new JRadioButton[5];
	JButton b2,b5,b6,a2,a3,a4,a5,a6,imgb;
	ButtonGroup bg; JLabel imgl;	
	JLabel name=new JLabel();
	
	JLabel l1=new JLabel("Read Instruction Carefully... ");
	JLabel l2=new JLabel("1. There are 10 questions in this test & 10 min to complete them all.");  //instruction line 1
	JLabel l3=new JLabel("2. In this three section 1st 3 English,2nd 4 logical,3rd 4 Quant.");
	JLabel l4=new JLabel("3. The time counter begins when you click on the Start Test button.  ");
	JLabel l5=new JLabel("4. You answer the quetion then click on save & next button. ");
	JLabel l6=new JLabel("5. You not answer the quetion then you click on next button. ");
	JLabel l7=new JLabel("6. Clicking the finish button will display the results. ");
	JLabel l8=new JLabel("  Best of luck...! ");
	JLabel l9=new JLabel();
	
	QuizApp(String s)
	{
		 super(s);
		 setLayout(new BorderLayout());
		 setContentPane(new JLabel(new ImageIcon("c:/Project/Quiz.jpg")));    // 2nd page img
		 setResizable(false);
		bg=new ButtonGroup();
            b2=new JButton("Start Test");                
	        b2.addActionListener(this);
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);
	    add(b2);add(name); 
	  
	  //add instruction
		name.setBounds(350,10,300,20);
	  l1.setBounds(50,20,300,50); 
	  l2.setBounds(100,60,400,50);   // instruction set
	  l3.setBounds(100,90,400,50);
	  l4.setBounds(100,120,400,50);
      l5.setBounds(100,150,400,50);
	  l6.setBounds(100,180,400,50);
      l7.setBounds(100,220,400,50);
	  l8.setBounds(100,250,400,50);
	  
	  b2.setBounds(230,300,110,30); 
                    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);setLocation(250,100);
	    setVisible(true);setSize(600,450);
		
				
	}	
                 public void actionPerformed(ActionEvent e)
               	{
                     if(e.getSource()==b2)
                      {						  
							System.out.println("Button Clicked");
                            OnlineTest1 ot1=new OnlineTest1("Quiz Test Of Java");						
                      }                                               

                     
				}

                  
				  public static void main(String s[])
                {   
				            
                             JFrame f=new JFrame(); 
                             try
	                       {
	                    	f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("c:/Project/Quiz.jpg")))));   //1st page img
                               }
                             catch(IOException e)
	                     	{
	                          e.printStackTrace();
	                        }
                                JButton b=new JButton("Login Here");  
                               	JLabel h=new JLabel("WELCOME TO QUIZ APPLICATION");
          	               	    h.setFont(new Font("Constantia",Font.BOLD,22));h.setForeground(Color.RED);  
								
								JLabel i=new JLabel("Enter the User Name :");   //login page name
								
								JTextArea t=new JTextArea();//text box
								
        	                	f.add(b);f.add(h);
								f.add(i);  //login
								
								f.add(t);//textbox
								
								
								h.setBounds(80,50,400,50);
                                b.setBounds(180,300,110,30);
								i.setBounds(80,85,300,50); //login
								t.setBounds(260,100,180,20);
								
								
								f. setLocation(250,100);
								
								b.addActionListener(new ActionListener()
                                	 {        public void actionPerformed(ActionEvent e) 
                      	                       { 
													if(t.getText().isEmpty())
														JOptionPane.showMessageDialog(f,"Please Enter Name"); 
													else
													{
                                                       QuizApp ot=new QuizApp("Quiz Test Of Java"); 												  
												       ot.name.setText("Login Name="+t.getText()+":");
													}
                    	                       }
               	                     });                                
								
                                    f.pack(); f.setSize(500,450);f.setLayout(null); f.setVisible(true);
									
                            }                                               
          }
		  
class OnlineTest1 extends JFrame implements ActionListener,Runnable
{	
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;ButtonGroup bg;
	boolean flag = false;
        int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	//30
	
	JFrame test;
   static Thread t=null;
	
	static int counter=0;
	
	JLabel disp;
 boolean stop=false;
 int i=0,j=0,k=0,n=0;	
	OnlineTest1(String s)
	{
		
		super(s);
		test=new JFrame();		
	
		if(counter>=0)
			new Thread(this).start();
		
		l=new JLabel();
		
		test.add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			test.add(jb[i]);
			bg.add(jb[i]);
		}
		
		
		disp=new JLabel("Time out");
		disp.setBounds(450,10,100,20);
		
		b1=new JButton("Save&Next"); b2=new JButton("Skip");
	        b1.addActionListener(this);
		b2.addActionListener(this);
		test.add(b1);test.add(b2);test.add(disp);
		set();
		
		l.setBounds(30,40,450,20);		
		
		jb[0].setBounds(50,80,100,20);jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);b2.setBounds(270,240,100,30);
		test.setLayout(null);test.setLocation(250,100);
		counter++;
		test.setVisible(true);test.setSize(600,450);
		
	}
	
	
	 public void run()
 {
	// System.out.println("Hello");
  for(j=9;j>=0;j--)
  {
	  
    for(k=59;k>=0;k--)
    {
     for(n=0;n< 100;n++)
     {
      if(stop || flag)
      {
       break;
      }
      NumberFormat nf = new DecimalFormat("00");
      disp.setText(nf.format(j)+":"+nf.format(k)+":"+nf.format(n));
      try{
       Thread.sleep(10);
      }catch(Exception e){}
     }
 }
   }
		if(k==-1)
		{
			test.setVisible(false);
			JOptionPane.showMessageDialog(test,"Sorrry Timeout"); 
		}
	
 }


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
			count=count+1;current++;
			set();	
			if(current==9)  //29
			{
			b1.setEnabled(false);b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Skip"))
		{
			JButton bk=new JButton("Skip"+x);
			bk.setBounds(480,20+30*x,100,30);
			test.add(bk);bk.addActionListener(this);
			m[x]=current;x++;current++;
			
			set();	
			if(current==9)  //29
			b2.setText("Result");
			test.setVisible(false); test.setVisible(true);
			
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		  if(e.getActionCommand().equals("Skip"+y))
		  {
			if(check())
		        count=count+1;now=current;current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		  }
		} 
			if(e.getActionCommand().equals("Result"))
		{
		     if(check())
			 count=count+1; current++;
			 flag = true;
             JOptionPane.showMessageDialog(this,"Correct answers: "+count);
			 
	  }
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1:Choose one of the following options that means the opposite of the given word; Copious:");
			jb[0].setText("Reverse");jb[1].setText("Scarce");jb[2].setText("Abundant");jb[3].setText("Short");	
		}
		if(current==1)
		{
			l.setText("Que2: She lived ____ the expectations.");
			jb[0].setText("as per");jb[1].setText("up to");jb[2].setText("on");jb[3].setText("at");
		}
		if(current==2)
		{
			l.setText("Que3: The creatures will grow into bulls which then will be used for?");
			jb[0].setText("digging");jb[1].setText("hunting");jb[2].setText("transportation");jb[3].setText("flying");
		}
		if(current==3)
		{
			l.setText("Que4:He was very tired as he is working since 6 O' clock in the morning.");
			jb[0].setText("he was working");jb[1].setText("he had been working");jb[2].setText("he has been working");jb[3].setText("he will be working");
		}
		if(current==4)
		{
			l.setText("Que5: Which number should come next in the series, 48, 24, 12, ......?");
			jb[0].setText("8");jb[1].setText("6");jb[2].setText("4");jb[3].setText("2");
		}
		if(current==5)
		{
			l.setText("Que6: RQP, ONM, _, IHG, FED, find the missing letters.");
			jb[0].setText("CDE");jb[1].setText("LKI");jb[2].setText("LKJ");jb[3].setText("BAC");
		}
		if(current==6)
		{
			l.setText("Que7:Which word does not belong to others?");
			jb[0].setText("Inch");jb[1].setText("Kilogram");jb[2].setText("Centimeter");jb[3].setText("Yard");
		}
		if(current==7)
		{
			l.setText("Que8: What is the average of first five multiples of 12?");
			jb[0].setText("36");jb[1].setText("38");jb[2].setText("40");jb[3].setText("42");		
		}
		if(current==8)
		{
			l.setText("Que9: What is the difference in the place value of 5 in the numeral 754853?");
			jb[0].setText("49500");jb[1].setText("49950");jb[2].setText("45000");jb[3].setText("49940");
		}
		if(current==9)
		{
			l.setText("Que10: What is the compound interest on Rs. 2500 for 2 years at rate of interest 4% per annum?");
			jb[0].setText(" 180");jb[1].setText("204");jb[2].setText("210");jb[3].setText("220");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[2].isSelected());
		if(current==3)
			return(jb[1].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
}


