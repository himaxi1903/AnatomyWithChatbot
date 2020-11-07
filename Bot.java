import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Bot extends JFrame{
	private JTextArea dialog=new JTextArea();
	private JTextField input=new JTextField();
	public Bot()
	{
		JFrame j=new JFrame("Anatomy Chatbot");
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
		j.setVisible(true);
		j.setResizable(false);
		j.setLayout(null);
		j.setSize(600,600);
		j.add(dialog);j.add(input);
		dialog.setSize(500,400);
		dialog.setLocation(2,2);
		input.setSize(500,30);
		input.setLocation(2,500);
		input.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String quote=input.getText().toLowerCase();
				dialog.append("You ->"+quote+ "\n");
				input.setText("");
				if(quote.contains("hi"))
				{
					bot("hello");
				}
				else if(quote.contains("how are You?"))
				{
					bot("doing good");
				}
				else if(quote.contains("hello"))
				{
					bot("hey");
				}
				else {
					int r=(int)(Math.random()*3+1);
					if(r==1)
					{
						bot("I don't understand it");	
					}else if(r==2)
					{
						bot("I don't understand it broo");
					}
					else if(r==1)
					{
						bot("Please try again");
					}
					
				}
				
			}
			
		});
	}
		private void bot(String str)
		{
			dialog.append("Bot ->"+str+"\n");
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bot();
	}

}
