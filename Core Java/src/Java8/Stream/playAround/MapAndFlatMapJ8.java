package Java8.Stream.playAround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ComparatorSorting.model.Student;

public class MapAndFlatMapJ8 {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("alex","bay","charle","dave");
		
		List<String> res = names.stream()
		     .map(name -> name.toUpperCase())
		     .collect(Collectors.toList());
		
		System.out.println("res :: "+res);
		
		
		//Example2
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Alex", "A"));
		students.add(new Student(2, "Bale", "B"));
		students.add(new Student(3, "Charles", "C"));
		
		List<String> studentNames = students.stream()
		        .map(s -> s.getFirstName())
		        .collect(Collectors.toList());
		
		System.out.println("student first names :: "+studentNames);
		
		
		//Example3  of flat map//TODO Reduce operation
		
		List<Student> flattenedStudents = students.stream()
		        .flatMap(student -> students.stream())
		        .collect(Collectors.toList());
		System.out.println("students :: "+students);
		System.out.println("flattenedStudents :: "+flattenedStudents);
		
		//Example 4 -> Get student names chars flattened
		
//		students.stream()
//		        .map(student -> student.getFirstName())
//		        .flatMap(pList -> pList.stream()).
	}
	
	
	private List<String> split(String s){
		return Arrays.asList(s.split(""));
	}

}
