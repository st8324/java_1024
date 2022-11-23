package day23;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Data;

public class FileStreamEx04 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("test.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Student("홍길동","2002-01-01"));
			oos.writeObject(new Student("임꺽정","2002-02-02"));
			oos.writeObject(new Student("고길동","2002-03-03"));
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fis = new FileInputStream("test.txt");
			ois = new ObjectInputStream(fis);
			while(true) {
				Student std = (Student)ois.readObject();
				System.out.println(std);
			}
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
@Data
class Student implements Serializable{
	private static final long serialVersionUID = 1700858336115503227L;
	private String name;
	private String birthday;
	
	public Student(String name, String birth) {
		this.name= name;
		this.birthday = birth;
	}
}
