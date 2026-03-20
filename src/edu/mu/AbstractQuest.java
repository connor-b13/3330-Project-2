package edu.mu;

public abstract class AbstractQuest implements Quest {
	
	private int id;
	
	private String title;
	
	private int basePoints;
	
	private boolean isCompleted = false;
	
	
	//constructor with invariant validations.
	public AbstractQuest(int id, String title, int basePoints){
		if(id<=0) {
			throw new IllegalArgumentException("ID must be greater than 0");
		}
		
		if(title == null||title.isBlank()) {
			throw new IllegalArgumentException("Quest title cannot be null");
		}
		
		if(basePoints<=0) {
			throw new IllegalArgumentException("Base points must be greater than 0");
		}
		
		this.id=id;
		this.title=title;
		this.basePoints=basePoints;
	}
	//Basic getters

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getBasePoints() {
		return basePoints;
	}

	@Override
	public boolean isCompleted() {
		return isCompleted;
	}

	public void markCompleted() {
		if(this.isCompleted!=false) {
			throw new IllegalArgumentException("This quest has already been completed");
		}
		this.isCompleted = true;
	}
	
	//Base for setting quest completion, implementation should be overwritten in subclasses
	/**
	 * @param s the student to be assigned points
	 * @return points assigned to student s
	 */
	@Override
	public int completeFor(Student s) {
		s.addPoints(basePoints);
		this.markCompleted();
		return basePoints;
	}
}
