package Java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindMaxUsingStreams {

	public static void main(String[] args) {

		Laptop l1 = new Laptop(1, "ASUS", 70000);
		Laptop l2 = new Laptop(2, "Apple", 160000);
		Laptop l3 = new Laptop(3, "DELL", 110000);
		Laptop l4 = new Laptop(4, "HP", 95000);
		Laptop l5 = new Laptop(4, "ACER", 65000);
		Laptop l6 = new Laptop(4, "SONY", 50000);
		
		
		List<Laptop> laptops = new ArrayList<>();
		laptops.addAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
		
		Comparator<Laptop> priceComparator = new Comparator<Laptop>() {
			@Override
			public int compare(Laptop o1, Laptop o2) {
				return Float.compare(o1.getPrice(), o2.getPrice());
			}
		};
		
		Laptop highestPriceLaptop = laptops.stream().max((lap1,lap2) -> Float.compare(lap1.getPrice(), lap2.getPrice())).get();
		System.out.println("highestPriceLaptop = "+highestPriceLaptop);
		
		Set<Laptop> laptopSortedByPriceDesc = laptops.stream().sorted((lap1,lap2) -> Float.compare(lap2.getPrice(),lap1.getPrice())).collect(Collectors.toSet());
		System.out.println("laptopSortedByPriceDesc :: "+laptopSortedByPriceDesc);
	}

}
