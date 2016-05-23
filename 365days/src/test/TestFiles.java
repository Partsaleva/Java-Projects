package test;

import java.io.FileWriter;
import java.io.IOException;

public class TestFiles {

	public static void main(String[] args) {
		TestFiles test=new TestFiles();
		test.workFile();
		test.holidayFile();
	}
	
	public void createWorkdayFile(){
		
	}
	
	public void createHolidayFile(){
		
	}
	
	private void workFile(){
		try(FileWriter f=new FileWriter("work.txt")){
			for (int i = 1; i < 101; i++) {
				f.write("WorkdayTicket"+ "_"+i);
				f.write(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	private void holidayFile(){
		try(FileWriter f=new FileWriter("holiday.txt")){
			for (int i = 1; i < 101; i++) {
				f.write("HolidayTicket"+ "_"+i);
				f.write(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
