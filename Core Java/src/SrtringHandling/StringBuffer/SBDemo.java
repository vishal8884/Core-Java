package SrtringHandling.StringBuffer;

public class SBDemo {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();  
		
		System.out.println("initial capacity :: "+sb.capacity());
		
		sb.append("this is string buffer");  //This is mutable ...so no need to assign back
		sb.append(" hmmm..................");
		
		System.out.println(sb);
		System.out.println("current capacity :: "+sb.capacity());
		System.out.println("charAt :: "+sb.charAt(3));
		
		//---------------------------------------------------------------------------------------------------------------------------------------------
		
		StringBuffer sb2 = new StringBuffer("abcde");
		sb2.reverse();
		
		System.out.println("sb2 reversed :: "+sb2);
		System.out.println("sb2 insert :: "+sb2.insert(3, "xyz"));
		System.out.println("sb2 insert :: "+sb2.delete(3, 4));
	}

}
