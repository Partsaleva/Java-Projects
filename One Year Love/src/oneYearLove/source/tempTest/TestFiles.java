package oneYearLove.source.tempTest;

import java.io.FileWriter;
import java.io.IOException;

public class TestFiles {

	public static void main(String[] args) {
		TestFiles test=new TestFiles();
		test.workFile();
		test.holidayFile();
	}
	
	
	private void workFile(){
		try(FileWriter f=new FileWriter("files/work")){
			for (int i = 1; i < 101; i++) {
				f.write("работен ден"+ "_"+i);
				f.write(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	private void holidayFile(){
		try(FileWriter f=new FileWriter("files/holiday")){
			for (int i = 1; i < 101; i++) {
				f.write("почивен ден"+ "_"+i);
				f.write(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
