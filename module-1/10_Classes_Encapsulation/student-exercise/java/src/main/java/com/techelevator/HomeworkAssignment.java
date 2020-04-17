package com.techelevator;

public class HomeworkAssignment {
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	
public HomeworkAssignment(int possibleMarks) {
	this.possibleMarks = possibleMarks;
	
}
	
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getLetterGrade() {
		if ((double)earnedMarks/possibleMarks >= .9) {
			letterGrade = "A";
		}else if((double)earnedMarks/possibleMarks >= .8) {
			letterGrade = "B";
		}else if ((double)earnedMarks/possibleMarks >= .7) {
			letterGrade = "C";
		}else if ((double)earnedMarks/possibleMarks >= .6) {
			letterGrade = "D";
		}else letterGrade = "F";
		return letterGrade;
	}

	

	
}
