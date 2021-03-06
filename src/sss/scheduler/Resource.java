package sss.scheduler;

import sss.scheduler.objects.DoubleHourLesson;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.SingleHourLesson;
import sss.scheduler.properties.Availability;

public class Resource {

	
	protected Availability[] availabilities;
	
	
	/**
	 * Initializes the availabilities object of the resource to 'all available'.
	 * @param nHoursInWeek Amount of lesson hours in a week.
	 */
	protected void initializeAvailabilities(int nHoursInWeek) {
		availabilities = new Availability[nHoursInWeek];
		for (int i=0; i<nHoursInWeek; i++) {
			availabilities[i] = Availability.AVAILABLE;
		}
	}
	
	/**
	 * Makes the resource unavailable for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToUnavailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.UNAVAILABLE;
	}
	
	/**
	 * Makes the resource unavailable for a given lesson hour
	 * @param timeslot The timeslot to set.
	 */
	public void setToUnavailable(int timeslot) {
		availabilities[timeslot] = Availability.UNAVAILABLE;
	}
	
	/**
	 * Makes the resource available for a given lesson hour
	 * @param lessonHour The lesson hour to set.
	 */
	public void setToAvailable(LessonHour lessonHour) {
		availabilities[getLessonHourIndex(lessonHour)] = Availability.AVAILABLE;
	}
	
	/**
	 * Makes the resource available for a given lesson hour
	 * @param timeslot The timeslot to set.
	 */
	public void setToAvailable(int timeslot) {
		availabilities[timeslot] = Availability.AVAILABLE;
	}
	
	/**
	 * Returns whether the resource is available on a given lesson hour.
	 * @param lessonHour The lesson hour to check.
	 * @return Boolean value indicating whether the resource is available.
	 */
	public boolean isAvailable(LessonHour lessonHour, Lesson lesson) {
		if (lesson instanceof DoubleHourLesson) {
			return lessonHour.hasNextHour() &&
					(availabilities[getLessonHourIndex(lessonHour)] == Availability.AVAILABLE ||
					availabilities[getLessonHourIndex(lessonHour)] == Availability.RATHER_NOT) &&
					(availabilities[getLessonHourIndex(lessonHour.getNextHour())] == Availability.AVAILABLE ||
					availabilities[getLessonHourIndex(lessonHour.getNextHour())] == Availability.RATHER_NOT);
		} else if (lesson instanceof SingleHourLesson) {
			return availabilities[getLessonHourIndex(lessonHour)] == Availability.AVAILABLE ||
				availabilities[getLessonHourIndex(lessonHour)] == Availability.RATHER_NOT;
		} else {
			System.out.println("Error while checking isAvailable: lesson input not sane");
			System.exit(1);
			return false;
		}
	}
	
	/**
	 * Returns whether the resource is available on a given lesson hour.
	 * @param lessonHour The lesson hour to check.
	 * @return Boolean value indicating whether the resource is available.
	 */
	public boolean isAvailable(LessonHour lessonHour) {
		return availabilities[getLessonHourIndex(lessonHour)] == Availability.AVAILABLE ||
				availabilities[getLessonHourIndex(lessonHour)] == Availability.RATHER_NOT;
	}
	
	/**
	 * Returns whether the resource is available on a given lesson hour.
	 * @param int The timeslot to check.
	 * @return Boolean value indicating whether the resource is available.
	 */
	public boolean isAvailable(int timeslot) {
		return availabilities[timeslot] == Availability.AVAILABLE ||
				availabilities[timeslot] == Availability.RATHER_NOT;
	}
	
	/**
	 * Returns the resource's indicated availability on a given LessonHour.
	 * @param lessonHour The lesson hour to check the resources's availability of.
	 * @return Resources's availability on the given LessonHour.
	 */
	public Availability getAvailability(LessonHour lessonHour) {
		return availabilities[getLessonHourIndex(lessonHour)];
	}
	
	/**
	 * Counts the number of available timeslots.
	 * @return int Number of available timeslots.
	 */
	public int getNumberOfAvailableHours() {
		int result = 0;
		
		for (Availability availability : availabilities) {
			if (availability.equals(Availability.AVAILABLE) ||
					availability.equals(Availability.RATHER_NOT))
				result++;
		}
		
		return result;
	}

	
	/**
	 * Returns the availabilities index corresponding to a given lesson hour
	 * @param lessonHour The lesson hour object to check
	 * @return The index of the availabilities array corresponding to the lesson hour
	 */
	protected int getLessonHourIndex(LessonHour lessonHour) {
		int nHoursPerDay = availabilities.length / 5;
		int hour = lessonHour.getHour();
		switch (lessonHour.getWeekday()) {
		case MONDAY:
			return (hour - 1);
		case TUESDAY:
			return (nHoursPerDay * 1 + hour - 1);
		case WEDNESDAY:
			return (nHoursPerDay * 2 + hour - 1);
		case THURSDAY:
			return (nHoursPerDay * 3 + hour - 1);
		case FRIDAY:
			return (nHoursPerDay * 4 + hour - 1);
		default:
			System.out.println("Invalid input while getting lesson hour index");
			System.exit(1);
			return -1;
		}
	}
}
