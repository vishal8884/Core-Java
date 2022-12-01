package ComparatorSorting.java7.sortByFirstName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ComparatorSorting.model.Student;

public class SortByNameRunner {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		for(int i=5;i<=10;i++) {
			students.add(new Student(i,i+"fName",i+"lName"));
		}
		for(int i=0;i<=4;i++) {
			students.add(new Student(i,i+"fName",i+"lName"));
		}
		System.out.println("---------------------------------------------before sort by name--------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
		
		Collections.sort(students, new SortByNameComparator());
		
		System.out.println("---------------------------------------------after sort by name----------------------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
	}

}
