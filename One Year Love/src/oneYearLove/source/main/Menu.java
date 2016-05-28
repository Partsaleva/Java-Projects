package oneYearLove.source.main;

import java.io.IOException;

import oneYearLove.source.fileControl.FileAccess;


public class Menu {

	public static void main(String[] args) throws IOException {
		startNewYear();
	}
	public static void startNewYear() throws IOException{
		FileAccess files=new FileAccess();
		files.createFileForYear("files/work","files/work365");
		files.createFileForYear("files/holiday","files/holiday365");
	}
}
