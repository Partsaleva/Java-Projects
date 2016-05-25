package fileControl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FileAccess {

	public List<String> chooseFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		List<String> data=null;
		Calendar startDate = Calendar.getInstance();
		int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
		if ( dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
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
				new BufferedInputStream(
						new FileInputStream(fileName)))){
			data=(List<String>) in.readObject();
		}
		return data;		
	}
	
	public void saveFile(List<String> fileData, String dest) 
			throws FileNotFoundException, IOException{
		
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)))){
			out.writeObject(fileData);
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
		
		saveFile(fileData, dest);		
	}
}
