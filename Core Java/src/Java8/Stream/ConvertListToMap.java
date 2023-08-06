package Java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {

	public static void main(String[] args) {
		Laptop l1 = new Laptop(1, "ASUS", 70000);
		Laptop l2 = new Laptop(2, "Apple", 160000);
		Laptop l3 = new Laptop(3, "DELL", 110000);
		Laptop l4 = new Laptop(4, "HP", 95000);
		Laptop l5 = new Laptop(4, "ACER", 65000);
		Laptop l6 = new Laptop(4, "SONY", 50000);
		
		
		List<Laptop> laptops = new ArrayList<>();
		laptops.addAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
		
		Map<String, Float> map = laptops.stream().filter(l -> l.getPrice() < 100000).collect(Collectors.toMap(lap -> lap.getName(), lap -> lap.getPrice()));
		System.out.println("map = "+map);
	}

}
