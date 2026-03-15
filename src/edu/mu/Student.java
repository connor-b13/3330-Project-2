package edu.mu;

import java.util.Objects;

public class Student {
	
	private String name;
	private int points = 0;
	

	// constructor for name, getter and setter
	public Student(String name, int points) {
		if(name == null) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		
		if(points<0){
			throw new IllegalArgumentException("Cannot have negative points");
		}
		this.name = name;
		this.points = 0;
		}
	
	public String getName() {
		return name;
	}
	// adds points to current total
	public void addPoints(int pts){
		points += pts;
		}
	
	public int getPoints(){
		return points;
	}

	
	// convert the student to a string:
	@Override
	public String toString() {
		return "Student name: " + name + " Points: " + points;
	}

	
	//generated hashCode and equals overrides using eclipses tool in source tab
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	
	}






