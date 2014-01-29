package sss.reasoner.penaltyObjects;

public class Penalty implements Comparable<Penalty> {
	
	public int penalty;

	@Override
	public int compareTo(Penalty penaltyObject) {
		if (penalty > penaltyObject.penalty) {
			return 1;
		} else if (penalty < penaltyObject.penalty) {
			return -1;
		}
		return 0;
	}

}
