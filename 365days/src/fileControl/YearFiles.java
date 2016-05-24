package fileControl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class YearFiles {

	public static void main(String[] args) {
		try {
			copyFilesValid365("work.txt","work365");
			copyFilesValid365("holiday.txt","holiday365");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copyFilesValid365(String sourse, String dest) throws IOException{
		InputStream in=null;
		OutputStream out=null;
		
			try {
				in=new FileInputStream(sourse);
				out= new FileOutputStream(dest);
				byte[] buffer=new byte[1024];
				int length;
				while((length =in.read(buffer)) > 0){
					out.write(buffer, 0, length);
				}
			} finally{
				in.close();
				out.close();
			}
			
		
	}
}