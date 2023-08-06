package Java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FilterUsingStreams {

	public static void main(String[] args) {

		Laptop l1 = new Laptop(1, "ASUS", 70000);
		Laptop l2 = new Laptop(2, "Apple", 160000);
		Laptop l3 = new Laptop(3, "DELL", 110000);
		Laptop l4 = new Laptop(4, "HP", 95000);
		
		
		List<Laptop> laptops = new ArrayList<>();
		laptops.addAll(Arrays.asList(l1,l2,l3,l4));
		
		List<Laptop> filteredLaptop1 = laptops.stream()
				.filter(laptop -> laptop.getPrice() > 100000)
				.collect(Collectors.toList());
		System.out.println("filteredLaptop1 :: "+filteredLaptop1);
		
		///////////////////////////////////////////////////////////////////////////
		List<Float> filterdLaptopPrice = laptops.stream()
				.filter(laptop -> laptop.getPrice() < 100000)
				.map(laptop -> laptop.getPrice())
				.collect(Collectors.toList());
		System.out.println("filterdLaptopPrice :: "+filterdLaptopPrice);
		
		///////////////////////////////////////////////////////////////////////////
		BinaryOperator<Float> bo = new BinaryOperator<Float>() {
			
			@Override
			public Float apply(Float t, Float u) {
				return t+u;
			}
		};
		Optional<Float> totalPrice = laptops.stream()
				.map(laptop -> laptop.getPrice())
				.reduce((a,b) -> a+b);
		System.out.println("totalPrice :: "+totalPrice);
		///////////////////////////////////////////////////////////////////////////
		
	}

}
