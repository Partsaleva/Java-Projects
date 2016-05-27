package oneYearLove.source.main;

import java.awt.EventQueue;

import oneYearLove.gui.Box;



public class RunProgram {

	//TODO problem when runnable jar is exported
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box frame = new Box();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
