package edu.mu;

public class VolunteerQuest extends AbstractQuest {

	int hours;
	
	//constructs special subclass with new field and invariant validation
	public VolunteerQuest(int id, String title, int basePoints, int hours) {
		if(hours<=0) {
			throw new IllegalArgumentException("Must have at least 1 hour");
		}
		super(id, title, basePoints);
		this.hours=hours;
	}

	//overrides method to add points multiplied by volunteer hours
	/**
	 * @param s the student to be assigned points
	 * @return points assigned to student s (base points * hours)
	 */
	@Override
	public int completeFor(Student s) {
		int finalPoints = getBasePoints()*hours;
		
		s.addPoints(finalPoints);
		this.markCompleted();
		return finalPoints;
	}
}
