import java.util.*;
import java.awt.*;
import java.applet.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import java.applet.Applet;
public class Clocky extends Applet implements Runnable
{
	Thread timer;     
	SimpleDateFormat formatter;
	Date currentDate;            
	Color handColor,numberColor;  
	int xcenter = 1800, ycenter = 55; 
	int u=0;
        Label l1,l2,l3;
        TextField t1,t2,t3;
	Button b;
	int x,y,z;
	Font f1,f2,f3; 


public void init()
{
	formatter = new SimpleDateFormat ("EEE MMM dd hh:mm:ss yyyy");
	currentDate = new Date();
	handColor = Color.blue;
	numberColor = Color.darkGray;
	setBackground( Color.pink);  
	Signals ts=new Signals();
	Thread t=new Thread(ts);
	t.start();
	setBackground(Color.cyan);
        l1 = new Label("Stop");
 	t1 = new TextField(10);
	l2 = new Label("Ready");
 	t2 = new TextField(10);
 	l3 = new Label("Go");
 	t3 = new TextField(10);
 	b = new Button("Start");
 	b.addActionListener(new test());
 	add(l1); add(t1);
 	add(l2); add(t2);
 	add(l3); add(t3);
 	add(b);
	f1 = new Font("Times New Roman",Font.BOLD,48);
	f2 = new Font("Times New Roman",Font.BOLD,24);
	f3 = new Font("Times New Roman",Font.PLAIN,20);
}
class test implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
 if(e.getSource() == b)
{
 x = Integer.parseInt(t1.getText());
 y = Integer.parseInt(t2.getText());
 z = Integer.parseInt(t3.getText());
}
} 
}
public void paint(Graphics g)
{
int xh, yh, xm, ym, xs, ys;
int s = 0, m = 10, h = 10;
String today;
currentDate = new Date();
formatter.applyPattern("s");
s=Integer.parseInt(formatter.format(currentDate));
formatter.applyPattern("m");
m = Integer.parseInt(formatter.format(currentDate));
formatter.applyPattern("h");
h = Integer.parseInt(formatter.format(currentDate));
formatter.applyPattern("EEE MMM dd HH:mm:ss yyyy");
today = formatter.format(currentDate);
g.setColor(numberColor);
g.drawString(today, 1715, 125);
xs = (int) (Math.cos(s * Math.PI/30-Math.PI/2) * 45+ xcenter);
ys = (int) (Math.sin(s * Math.PI/30-Math.PI/2) * 45+ ycenter);
xm = (int) (Math.cos(m * Math.PI/30-Math.PI/2) * 40+ xcenter);
ym = (int) (Math.sin(m * Math.PI/30-Math.PI/2) * 40+ ycenter);
xh = (int) (Math.cos((h*30+m/2) * Math.PI/180- Math.PI/2) * 30+xcenter);
yh = (int) (Math.sin((h*30+m/2) * Math.PI/180- Math.PI/2) * 30+ycenter);
g.drawLine(xcenter, ycenter, xs, ys);
g.setColor(handColor);
g.drawLine(xcenter, ycenter-1, xm, ym);
g.drawLine(xcenter-1, ycenter, xm, ym);
g.drawLine(xcenter, ycenter-1, xh, yh);
g.drawLine(xcenter-1, ycenter, xh, yh);
g.setColor(handColor);
g.drawArc(xcenter-50, ycenter-50, 100, 100, 0, 360);
g.setColor(numberColor);
g.drawString("9", xcenter-45, ycenter+3);
g.drawString("3", xcenter+40, ycenter+3);
g.drawString("12", xcenter-5, ycenter-37);
g.drawString("6", xcenter-3, ycenter+45);
	
                  int w=1000;
                  g.setFont(f1);
	g.drawString("Traffic Signal Control System",660,200);
	  g.setFont(f2);
	  g.drawString("Done BY:",1500,800);
	  g.setFont(f3);
	  g.drawString("P S S S Yasaswi",1500,840);
	          g.drawString("Electronics And Communication Engineering",1500,860);
		  g.drawString("Amrita Vishwa Vidyapeethyam",1500,880); 
		  g.setColor(Color.black);
		  g.fillRect(1000,400,110,270);
		  g.setColor(Color.white);
		  g.drawOval(1020,440,70,70);
		  g.drawOval(1020,520,70,70);
		  g.drawOval(1020,600,70,70);
            try{
		if(u==0)
		{
			   g.setColor(Color.red);
			   g.fillOval(1020,440,70,70);
			   Thread.sleep(w*x);
			   u=1;
		}
		else 
		if(u==1)
		{
			   g.setColor(Color.yellow);
			   g.fillOval(1020,520,70,70);
                           Thread.sleep(w*y);
		    	   u=2;
		}
		else
		{
			   g.setColor(Color.green);
			   g.fillOval(1020,600,70,70);
    			   Thread.sleep(w*z);
			   u=0;
		}
		
		}
		 catch(Exception e)
		{
		  System.out.println("Thread error");
		}
                  repaint();
  		
	}

public void start()
{
timer = new Thread(this);
timer.start();
}
public void stop()
{
timer = null;
}
public void run()
{
Thread me = Thread.currentThread();
while (true)  
{
try
{
Thread.currentThread().sleep(1500);
} 
catch (InterruptedException e) {
}
repaint();
}
}
}
 /*
 <html>
 <body> 
 <applet code = "Clocky.class" width = "600" height = "600"></applet>
 </body></html>*/