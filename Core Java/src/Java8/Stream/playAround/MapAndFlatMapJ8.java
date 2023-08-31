package Java8.Stream.playAround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
		Comparator<String> c = (a,b) -> a.compareTo(b);
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Zlex", "A"));
		students.add(new Student(2, "Bale", "B"));
		students.add(new Student(3, "Charles", "C"));
		
		//3 of the sorted method also will work here
		List<String> studentNames = students.stream()
				.sorted((o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName()))
				//.sorted(Comparator.comparing(Student :: getFirstName))
				//.sorted(Comparator.comparing(Student :: getFirstName, (a,b) -> a.compareTo(b)))
		        .map(s -> s.getFirstName())
		        .collect(Collectors.toList());
		
		System.out.println("student first names :: "+studentNames);
		
		
		
		//Example 4 -> Get student names chars flattened
		List<String> flattenedStudentFirstName = students.stream()
				.map(student -> student.getFirstName())
				.flatMap(fName -> split(fName).stream())
				.collect(Collectors.toList());
		
		System.out.println("flattenedStudentFirstName :: "+flattenedStudentFirstName);
	}
	
	
	private static List<String> split(String s){
		return Arrays.asList(s.split(""));
	}

}
