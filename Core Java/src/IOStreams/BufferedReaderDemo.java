package IOStreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderDemo {

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;
		
		int count = 0;
		
		try {
			fr = new FileReader("C:\\Users\\visha\\Desktop\\myfile.txt");
			br = new BufferedReader(fr);   //buffered reader is decorator class for file reader
			
			String line;
			
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) {
					System.out.println(st.nextToken());
					count++;
				}
			}
			
			
			System.out.println("no of words in file :: "+count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
