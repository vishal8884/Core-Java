package IOStreams.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) {

		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\visha\\Desktop\\emp.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			Employee emp = (Employee)obj;
			
			System.out.println("Employee id :: "+emp.id);
			System.out.println("Employee name :: "+emp.name);
			System.out.println("Employee sal :: "+emp.salary);
			System.out.println("Employee ssn :: "+emp.ssn);  //ssn is 0 as we marked it with transient and it never got into the file
			//default value for int field is 0
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

}
