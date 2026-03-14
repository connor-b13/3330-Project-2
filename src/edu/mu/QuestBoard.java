package edu.mu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestBoard {
	private Map<Integer, Quest> questsById = new HashMap<Integer, Quest>();
	private Map<Student, List<Quest>> assignments = new HashMap<Student, List<Quest>>();
	
	
	/**
	 * Adds a quest to the list of quests
	 * @param q the quest to add
	 * @throws IllegalArgumentException if a duplicate quest with the same ID already exists
	 */
	public void addQuest(Quest q) {
		if (questsById.containsKey(q.getId())) {
			throw new IllegalArgumentException("Quest cannot be a duplicate.");
		}
		
		questsById.put(q.getId(), q);
	}
	
	/**
	 * Finds a quest in the list by id
	 * @param id the id of the quest to find
	 * @return The quest if found, null otherwise
	 */
	public Quest findQuest(int id) {
		return questsById.get(id);
	}
	
	/**
	 * Assign a quest to a specific student
	 * @param s the student to assign the quest to
	 * @param questId the ID of the quest to be assigned
	 * @throws IllegalArgumentException If no known quest, or quest already assigned to student
	 */
	public void assignQuest(Student s, int questId) {
		if (!questsById.containsKey(questId)) {
			throw new IllegalArgumentException("No known quest by that questId");
		}
		
		Quest studentQuest = questsById.get(questId);
		List<Quest> studentList = assignments.get(s);
		
		if (studentList.isEmpty()) {
			studentList = new ArrayList<Quest>(List.of(studentQuest));
		} else if (studentList.contains(studentQuest)) {
			// Design Choice: Quests can only be assigned once
			throw new IllegalArgumentException("Student cannot be assigned the same quest multiple times.");
		}
		
		studentList.add(studentQuest);
		assignments.put(s, studentList);
	}
	
	/**
	 * Completes a quest for the given student
	 * @param s the student who completed the quest
	 * @param questId the ID of the quest they completed
	 * @return the amount of points earned
	 */
	public int completeQuest(Student s, int questId) {		
		List<Quest> studentList = assignments.get(s);
		
		if (studentList.isEmpty()) {
			throw new IllegalArgumentException("Student does not have any quests!");
		}
		
		Quest studentQuest = studentList.get(questId);
		
		if (studentQuest == null) {
			throw new IllegalArgumentException("No quest with that ID is assigned to the student");
		}
		
		return studentQuest.completeFor(s);
	}
	
	/**
	 * Prints all the quests on the board
	 */
	public void printAllQuests() {
		System.out.println("List of Quest:");
		System.out.println("-------------------");
		
		questsById.forEach((id, quest) -> {
			String title = quest.getTitle();
			String output = String.format("%d - %s", id, title);
			
			System.out.println(output);
		});
	}
	
	/**
	 * Prints all the assignments for the given student
	 * @param s the student to print assignments for
	 */
	public void printAssignmentsFor(Student s) {
		List<Quest> studentList = assignments.get(s);
		
		System.out.println("Quests for " + s);
		System.out.println("-------------------");
		
		for (Quest q : studentList) {
			String output = String.format("%d - %s", q.getId(), q.getTitle());
			System.out.println(output);
		}
	}
}
