package oneYearLove.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import oneYearLove.source.fileControl.FileAccess;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Box extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Box() {
		
		initComponents();
		createEvents();
		
	}

	//////////////////////////////////////////////////////
	

	private void initComponents() {
		

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Box.class.getResource("/oneYearLove/resourses/love_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 175, 175));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		btnNewButton = new JButton("CLICK ME!");
		
		btnNewButton.setIcon(new ImageIcon(Box.class.getResource("/oneYearLove/resourses/love_icon.png")));
		btnNewButton.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(157)
					.addComponent(btnNewButton)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addComponent(btnNewButton)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	private void createEvents() {
		FileAccess file=new FileAccess();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, file.getTicket());
				
			}
		});
		
	}
}
