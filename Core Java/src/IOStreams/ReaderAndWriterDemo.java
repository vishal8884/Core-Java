package IOStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderAndWriterDemo {

	public static void main(String[] args) throws Exception {

		FileReader fr = null;
		FileWriter fw = null;
		
		fr = new FileReader("C:\\Users\\visha\\Desktop\\myfile.txt");
		fw = new FileWriter("C:\\Users\\visha\\Desktop\\mynewfile.txt");
		
		int ch;
		
		while((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		
		fr.close();
		fw.close();
	}

}
