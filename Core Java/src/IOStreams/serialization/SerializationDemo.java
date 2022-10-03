package IOStreams.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {

		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream("C:\\Users\\visha\\Desktop\\emp.ser");  //.ser is extention used for serialized files
			oos = new ObjectOutputStream(fos);
			
			Employee emp = new Employee(1,"john", 100000, 12345);
			oos.writeObject(emp);
			
			System.out.println("Employee object serialized");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
