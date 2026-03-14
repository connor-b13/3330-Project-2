package edu.mu;

public class EventCheckInQuest extends AbstractQuest{
	
	private String eventName;

	
	//constructs special subclass with new field and invariant validation
	public EventCheckInQuest(int id, String title, int basePoints, String eventName) {
		if (eventName == null||eventName.isEmpty()) {
			throw new IllegalArgumentException("Must include a valid event name.");
		}
		super(id, title, basePoints);
		this.eventName=eventName;
		
	}

//Simple getter for new field
	public String getEventName() {
		return eventName;
	}
	
}
