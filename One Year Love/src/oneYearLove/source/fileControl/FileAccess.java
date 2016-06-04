package oneYearLove.source.fileControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Random;



import oneYearLove.gui.InnerFrame;





public class FileAccess implements ActionListener{


	public List<String> chooseFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		List<String> data=null;
		
		if (isWeekend()) {
			data = loadFile("holiday365");
		} else {
			data = loadFile("work365");
		}
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> loadFile(String fileName) 
			throws FileNotFoundException, IOException, ClassNotFoundException{
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream stream =classLoader.getResourceAsStream(fileName);	
		
		List<String> data=null;
		try(ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(stream))){
			data=(List<String>) in.readObject();
		}
		return data;		
	}
	
	private void saveFile(List<String> fileData) 
			throws FileNotFoundException, IOException{
		File dest;
		if (isWeekend()) {
			dest = new File("bin"+File.separator+"holiday365");
		} else {
			dest = new File("bin"+File.separator+"work365");
		}
		try(ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(dest))){
			out.writeObject(fileData);
			System.out.println(fileData);
		}
		
	}
	
	
	
	
	private boolean isWeekend(){
		Calendar date = Calendar.getInstance();
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
	}
	
	
	
	public String getTicket(){
		String ticket=null;
		try {
			List<String> tickets= chooseFile();
			Random index=new Random();
			if (!tickets.isEmpty()) {
				ticket=tickets.remove(index.nextInt( tickets.size()));
				saveFile(tickets);
			}else{
				ticket="Годината мина :(";
			}						
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DateControl().saveDateOfExecution();
		InnerFrame frame=new InnerFrame();
		frame.setVisible(true);		
		
	}

	
}
