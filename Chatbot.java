import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Math;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
public class Chatbot extends JFrame implements KeyListener{  
   // JFrame f= new JFrame("Anatomy Chatbot");
	JPanel p=new JPanel();
	JTextArea con=new JTextArea();
	JTextField input=new JTextField();
	JScrollPane sc=new JScrollPane(con,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	String [][] bot= {{"hi","hello","hola","howdy"},
			{"ola","hi","hey"},
			{"how you doing?","how r uh","	how are you"},
			{"I'm good","doing well"},
			{"yes","yo"},
			{"no","no!!!!","NO"},
			{"stop talking you idiot","i'm bored","bot is not available"}};
	//standard greetings
    Chatbot(){  
    	super("Anatomy Chatbot");
    	setSize(600,600);
    	setResizable(false);
    	con.setEditable(false);
    	input.addKeyListener(this);
   // 	input.addActionListener(new ActionListener());
    	p.setBounds(0,0,390,300);
    	p.setBackground(Color.GRAY);
    	p.add(con);p.add(input);  
    	con.setSize(600,400);
		con.setLocation(2,2);
		input.setSize(600,30);
		input.setLocation(2,500);
        add(con);add(input); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);  
        setVisible(true);  
    }   
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_ENTER)
    	{
    		input.setEditable(false);
    		String quote=input.getText();
    		input.setText("");
    		addText("-->You:\t"+quote);
    		quote=quote.trim();
    		while(quote.charAt(quote.length()-1)=='!' || 
    				quote.charAt(quote.length()-1)=='.' ||
    				quote.charAt(quote.length()-1)=='?') {
    			//Remove the punctuation
    			quote=quote.substring(0,quote.length()-1);
    			quote=quote.trim();
    			byte response=0;
    			int i=0;
    			while(response==0) {
    				if(inList(quote.toLowerCase(),bot[i*2])) {
    					 response=2;
    					 int x=(int) Math.floor(Math.random()*bot[(i*2)+1].length);
    					 addText("\n-->Michael\t"+bot[(i*2)+1][x]);
    				}
    				i++;
    				if((i*2)==bot.length-1 && response==0)
    				{
    					response=1;
    			//		int x=(int) Math.floor(Math.random()*bot[bot.length-1].length);
    			//		addText("\n-->Michael\t"+bot[bot.length-1][x]);
    				}
    			
    			} 
    			if(response==1)
    			{
    				int x=(int) Math.floor(Math.random()*bot[bot.length-1].length);
        			addText("\n-->Bot\t"+bot[bot.length-1][x]);
    			}
    			addText("\n");
    		}
    	}
    }
    private boolean inList(String quote, String[] str) {
		// TODO Auto-generated method stub
    	boolean match=false;
    	for(int i=0;i<str.length;i++)
    	{
    		if(str[i].equals(quote))
    		{
    			match=true;
    		}
    	}
		return match;
	}
	private void addText(String str) {
		// TODO Auto-generated method stub
    	con.setText(con.getText()+str);
	}
	public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_ENTER)
    	{
    		input.setEditable(true);
    	}
    }
    public void keyTyped(KeyEvent e) {} 
    public static void main(String[] args) {  
        new Chatbot();  
    } } 