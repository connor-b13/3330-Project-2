package edu.mu;

public interface Quest {
	public int getId();
	public String getTitle();
	public int getBasePoints();
	public boolean isCompleted();
	public int completeFor(Student s);
}
