package ExceptionHandling.unchecked.MultCatch;

public class MultipleCatch {

	public static void main(String[] args) {

		try {
			String input = args[0];
			System.out.println("input is :: " + input);

			int output = Integer.parseInt(input);
			System.out.println("output is :: " + output);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("input is requried!!!! :: "+e);
		} catch (NumberFormatException e) {                    // can handle parent of this exception also-
			System.out.println("invalid input provided :: "+e);
		}
		System.out.println("more code can go here");
	}

}
