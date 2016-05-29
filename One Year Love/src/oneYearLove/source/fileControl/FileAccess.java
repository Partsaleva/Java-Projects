package oneYearLove.source.fileControl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class FileAccess  extends javax.swing.JInternalFrame{

	private static final long serialVersionUID = 1L;

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
		
		List<String> data=null;
		try(ObjectInputStream in=new ObjectInputStream(
				
						//get file as stream to include it in runnable jar
						getClass().getResourceAsStream(
								File.separator+fileName))){
			data=(List<String>) in.readObject();
		}
		return data;		
	}
	
	private void saveFile(List<String> fileData) 
			throws FileNotFoundException, IOException{
		File dest;
		if (isWeekend()) {
			dest = new File("files/holiday365");
		} else {
			dest = new File("files/work365");
		}
		try(ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(dest))){
			out.writeObject(fileData);
			System.out.println(fileData);
		}
	}
	
	
	public void createFileForYear(String sourse, String dest) throws IOException{
		List<String> fileData=new ArrayList<String>();
		try(BufferedReader in = new BufferedReader(
				new FileReader(sourse))){
			String line=null;
			while((line =in.readLine())!= null){
				fileData.add(line);
			}
		}		
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)))){
			out.writeObject(fileData);
		}	
	}
	
	private boolean isWeekend(){
		Calendar startDate = Calendar.getInstance();
		int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
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
}
