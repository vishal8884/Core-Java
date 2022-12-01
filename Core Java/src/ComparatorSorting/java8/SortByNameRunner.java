package ComparatorSorting.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ComparatorSorting.java7.sortById.StudentIdComparator;
import ComparatorSorting.model.Student;

public class SortByNameRunner {

	public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
		
		for(int i=5;i<=10;i++) {
			students.add(new Student(i,i+"fName","lName"+i));
		}
		for(int i=0;i<=4;i++) {
			students.add(new Student(i,i+"fName","lName"+i));
		}
		System.out.println("---------------------------------------------before sort by id---------------------------------------");
		students.forEach(System.out :: println);
		
		
		//approach2...simplified
		
		Comparator<Student> sortByFirstNameComparator = Comparator.comparing(s -> s.getFirstName(), (a,b) -> {
			return a.compareTo(b);   //b.comnpareTo(a) for reverse sort
		});
		
		Collections.sort(students,sortByFirstNameComparator);
		
		
		System.out.println("---------------------------------------------after sort by id----------------------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
	}
}
