package fileControl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FileLoader {

	public void chooseFile() throws FileNotFoundException, IOException{
		Calendar startDate = Calendar.getInstance();
		int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
		if ( dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
			//TODO return list with data and use it
		    loadFile("holiday365");
		} else {
			loadFile("work365");
		}
	}
	
	public List<String> loadFile(String fileName) throws FileNotFoundException, IOException{
		List<String> data=new ArrayList<String>();
		try(BufferedReader reader=new BufferedReader(
				new FileReader(fileName))){
			String line=null;
			while((line=reader.readLine())!= null){
				data.add(line);
			}
		}
		return data;
		
	}
}
