package edu.mu;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// print 3 students including duplicate
		Student s1 = new Student("Trent", 24);
		Student s2 = new Student("Trent", 21);
		Student s3 = new Student("Jack", 19);

		// Hash set implementation
		HashSet<Student> studentSet = new HashSet<Student>();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);

		// Output a lack of duplicates to the console
		System.out.println(studentSet);
		
		// create 2 of each quest type, including duplicate ID
		EventCheckInQuest eci1 = new EventCheckInQuest(01, "eci1", 3, "Career Fair");
		EventCheckInQuest eci2 = new EventCheckInQuest(02, "eci2", 3, "Resume Review");
		StreakQuest sq1  = new StreakQuest(03, "sq1", 3, 4);
		StreakQuest sq2  = new StreakQuest(04, "sq1", 3, 4);		
		VolunteerQuest vq1 = new VolunteerQuest(05, "vq1", 4, 8);
		VolunteerQuest vq2 = new VolunteerQuest(06, "vq2", 3, 4);
		//VolunteerQuest vq3 = new VolunteerQuest(01, null, 4, 8);
			
		QuestBoard questBoard = new QuestBoard();
		// add quests to the board and print them out
		questBoard.addQuest(eci1);
		questBoard.addQuest(eci2);
		questBoard.addQuest(sq1);
		questBoard.addQuest(sq2);
		questBoard.addQuest(vq1);
		questBoard.addQuest(vq2);
		
		questBoard.printAllQuests();
		
		// assign 2 students 4 	quests and print them out
		questBoard.assignQuest(s1, 01);
		questBoard.assignQuest(s1, 02);
		questBoard.assignQuest(s3, 03);
		questBoard.assignQuest(s3, 05);
		
		// complete 3 quests across 3 different types.
		questBoard.completeQuest(s1, 01);
		questBoard.completeQuest(s3, 03);
		questBoard.completeQuest(s3, 05);
		
		questBoard.printAssignmentsFor(s1);
		questBoard.printAssignmentsFor(s3);

	}
	
}





