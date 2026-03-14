package edu.mu;

public class Student {
	
	private String name;
	private int points = 0;
	}

	// constructor for name, getter and setter
	public Student(String name) {
		if(name == null) {
			throw IllegalArgumentException("Name cannot be empty.");
		}
		this.name = name;
		this.points = 0;
		}
	}
	public String getName() {
		return name;
	
	// getter to add points
	public addPoints{
		if(points < 0 || points.isEmpty()) {
			throw IllegalArgumentException("Name cannot be empty"):
		}
		else {
			return this.points += amount;
		}
	
	public getPoints{
		return points;
	}
	
	public void setPoints(int amount) {
		this.points = amount;
	}
	
	// finding the student:
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	// convert the student to a string:
	@Override
	public toString() {
		return "Student Name: " + name + "Student Points" + points;
	}
	
	// hash code to check for duplicates
	@Override
	public boolean(Object Name) {
		if(this == Name) {
			return true;
		}
		else if(Name == null || getClass() != Name.getClass()) {
			return false;
		}
	}
}






