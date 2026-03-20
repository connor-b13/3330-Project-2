package edu.mu;

public class StreakQuest extends AbstractQuest{
	
	private int days;
	
	//constructs special subclass with new field and invariant validation
	public StreakQuest(int id, String title, int basePoints, int days) {
		super(id, title, basePoints);
		
		if(days<=0) {
			throw new IllegalArgumentException("Days must be greater than 0");
		}
		
		this.days=days;
	}
	
	
	//overrides method to add points based off days (2x days + base points)
	
	/**
	 * @param s the student to be assigned points
	 * @return points assigned to student s (2x days + base points)
	 */
	@Override
	public int completeFor(Student s) {
		int finalPoints = getBasePoints() + 2*days;
		s.addPoints(finalPoints);
		this.markCompleted();
		return finalPoints;
	}
	
}
