package Java8.Stream.DistinctLimitCountReduceToArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Examples1 {

	//https://www.youtube.com/watch?v=-utC-IMnHwI&list=PLUDwpEzHYYLvTPVqVIt7tlBohABLo4gyg&index=5
	public static void main(String[] args) {

		List<String> cars = Arrays.asList("TATA","BMW","MERCIDES","FORD","SANTRO","I20","FORD","I20","SANTRO");
		
		//Distinct and Count
		List<String> distinctCars = cars.stream().distinct().collect(Collectors.toList());
		System.out.println("distinctCars :: "+distinctCars);
		
		long distinctCarsCount = cars.stream().distinct().count();
		System.out.println("distinctCarsCount :: "+distinctCarsCount);
		
		
		//Limit in Streams
		List<String> carsLimited = cars.stream().limit(4).collect(Collectors.toList());
		System.out.println("carsLimited :: "+carsLimited);
		
		//Min and Max in Streams
		String minCar = cars.stream().min((a,b) -> a.compareTo(b)).get();
		System.out.println("minCar :: "+minCar);
		
		String maxCar = cars.stream().max((a,b) -> a.compareTo(b)).get();
		System.out.println("maxCar :: "+maxCar);
		
		//Reduce method
		String reducedCar = cars.stream().reduce((value,combined) -> value + combined).get(); //This is opposite to flatmap..it will kepp of adding all values of the list as a string
		System.out.println("reducedCar :: "+reducedCar);
	}

}
