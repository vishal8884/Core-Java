package ComparatorSorting.java7.sortById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ComparatorSorting.model.Student;

public class SortByIdRunner {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		for(int i=5;i<=10;i++) {
			students.add(new Student(i,"fName"+i,"lName"+i));
		}
		for(int i=0;i<=4;i++) {
			students.add(new Student(i,"fName"+i,"lName"+i));
		}
		System.out.println("---------------------------------before sort by id---------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
		
		Collections.sort(students,new StudentIdComparator());
		
		
		System.out.println("---------------------------------------------after sort by id----------------------------------------------------");
		for(Student s : students) {
			System.out.println("student :: "+s);
		}
	}

}
