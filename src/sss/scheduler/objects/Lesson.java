package sss.scheduler.objects;

public class Lesson {
	
	private String subject;
	private int rank;

	public Lesson (String subject) {
		this.setRank(0);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
