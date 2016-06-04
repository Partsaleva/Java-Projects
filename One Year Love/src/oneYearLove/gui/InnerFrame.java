package oneYearLove.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import oneYearLove.source.fileControl.DateControl;
import oneYearLove.source.fileControl.FileAccess;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class InnerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2112961684093228682L;
	private JPanel contentPane;

	
	public InnerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InnerFrame.class.getResource("/oneYearLove/resourses/love_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 250, 260);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String ticket=printTicket();
		
		JTextArea textArea = new JTextArea(ticket, 6, 20);
        textArea.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 17));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.NORTH);
	}


	private String printTicket(){
		DateControl d=new DateControl();		
		String ticket;
		DateControl day=new DateControl();
		if (day.isTheSameDay()) {
			ticket="Ще трябва да почакаш до утре, Дино :) ";
		} else {
			ticket=new FileAccess().getTicket();
			d.saveDateOfExecution();
		}
		return ticket;
	}
}
