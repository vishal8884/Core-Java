package IOStreams;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {

		String s = "you are creater of your destiny";
		
		StringTokenizer st = new StringTokenizer(s);
		
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
		
		//-------------------------------------------comma delimitor
		
        String s2 = "you,are,creater,of,your,destiny";
		
		StringTokenizer st2 = new StringTokenizer(s2,",");
		
		while(st2.hasMoreElements()) {
			System.out.println(st2.nextToken());
		}
		
       //-------------------------------------------
		
        String s3 = "you,are,creater,of,your,destiny";
		
		StringTokenizer st3 = new StringTokenizer(s3,",",true);
		
		while(st2.hasMoreElements()) {
			System.out.println(st2.nextToken());
		}
	}

}
