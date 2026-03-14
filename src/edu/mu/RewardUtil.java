package edu.mu;

import java.util.List;

public class RewardUtil {
	
	/**
	 * Prints all items in a list
	 * @param <T> the type of elements in the list
	 * @param items a list to be printed
	 * @throws IllegalArgumentException if items is null
	 */
	public static <T> void printAll(List<T> items) {
		if (items == null) {
			throw new IllegalArgumentException("items must not be null");
		}
		
		for (T item : items) {
			System.out.println(item.toString());
		}
	}
	
	/**
	 * Sum all points in a list of Student or a subtype of Student
	 * @param students the list to be summed
	 * @throws IllegalArgumentException if the list is null
	 * @return the total points
	 */
	public static int sumPoints(List<? extends Student> students) {
		if (students == null) {
			throw new IllegalArgumentException("students must not be null");
		}
		
		int total = 0;
		
		for (Student s : students) {
			total += s.getPoints();
		}
		
		return total;
	}
}
