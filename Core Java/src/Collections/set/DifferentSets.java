package Collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DifferentSets {

	public static void main(String[] args) {

		Random obj = new Random();
		
		//------------------------------------------HASH SET---------------------------------------------------------------------------------------
		
		
		HashSet<Integer> set = new HashSet<>();  //insertion order not maitained
		for(int i=0;i<=5;i++) {
			int num = obj.nextInt(10);
			set.add(num);
			System.out.println("num :: "+num);
		}
		System.out.println("hash set elem :: "+set);
		System.out.println();
		
		//------------------------------------------TREE SET---------------------------------------------------------------------------------------
		
		LinkedHashSet<Integer> Linkedset = new LinkedHashSet<>();  //stores in insertion order
		for(int i=0;i<=5;i++) {
			int num = obj.nextInt(10);
			 Linkedset.add(num);
			System.out.println("num2 :: "+num);
		}
		System.out.println("hash set elem :: "+ Linkedset);
		System.out.println();
		
		//------------------------------------------TREE SET---------------------------------------------------------------------------------------
		
		Set<Integer> treeSet = new TreeSet<>();  //ascending order 
		for(int i=0;i<=5;i++) {
			int num = obj.nextInt(10);
			treeSet.add(num);
			System.out.println("treeSet num :: "+num);
		}
		
		System.out.println("treeSet :: "+treeSet);
	}

}
