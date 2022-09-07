package ExceptionHandling.checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptionUsingThrows {

	public static void main(String[] args) {

		CheckedExceptionUsingThrows ce = new CheckedExceptionUsingThrows();
		try {
			ce.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("file not found !! :: "+e);
		}
	}
	
	
	void readFile() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("");
		System.out.println("code after that");
	}

}
