package oneYearLove.source.tempTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(Integer.toString(i+50));
		}
		
		ArrayList<String>res=read();
		System.out.println(res);

	}

	public static void write(List<String> list){
		try(ObjectOutputStream out=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("test")))){
			
			out.writeObject(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<String> read(){
		ArrayList<String> l=null;
		try(ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("test")))){
			l=(ArrayList<String>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
}
