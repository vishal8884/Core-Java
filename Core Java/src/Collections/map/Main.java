package Collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		locations.put(0, new Location(0,"you are at home learning"));
		locations.put(1, new Location(1,"you are at road"));
		locations.put(2, new Location(2,"you are at hill"));
		locations.put(3, new Location(3,"you are at building"));
		locations.put(4, new Location(4,"you are eating food at kitchen"));
		locations.put(5, new Location(5,"you are valay beside stream"));
		locations.put(6, new Location(6,"you are at forest"));
		
		locations.get(1).addExit("W",2);
		locations.get(1).addExit("E",3);
		locations.get(1).addExit("S",4);
		locations.get(1).addExit("N",5);
		locations.get(1).addExit("Q ",0);
		
		locations.get(2).addExit("N", 5);
		locations.get(2).addExit("Q ",0);
		
		locations.get(3).addExit("W ",1);
		locations.get(3).addExit("Q ",0);
		
		locations.get(4).addExit("N ",1);
		locations.get(4).addExit("W ",2);
		locations.get(4).addExit("Q ",0);
		
		locations.get(5).addExit("S ",1);
		locations.get(5).addExit("W ",2);
		locations.get(5).addExit("Q ",0);
		
		
		int loc = 1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0) {
				System.out.println("returned to default(0) so breaking loop");
				break;
			}
			
			Map<String,Integer> exits = locations.get(loc).getExits();
			System.out.println("Available exits are ");
			for(String exit : exits.keySet()) {
				System.out.println(exit + ", ");
			}
			System.out.println();
			
			String direction = sc.nextLine().toUpperCase();
			
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("you cannot go into that direction");
			}

		}
		
	}

}
