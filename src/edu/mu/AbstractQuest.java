package edu.mu;

public abstract class AbstractQuest implements Quest {
	
	private int id;
	
	private String title;
	
	private int basePoints;
	
	private boolean isCompleted = false;
	
	AbstractQuest(int id, String title, int basePoints){
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
	
	@Override
	public int completeFor(Student s) {
		s.addPoints(basePoints);
		isCompleted=true;
		return basePoints;
	}
}
